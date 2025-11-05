package com.swingy.controller;

import static com.swingy.utils.Constants.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.swingy.model.CharactersFactory;
import com.swingy.view.DisplayController;
import com.swingy.model.ArtefactFactory;
import com.swingy.model.Characters;

public class Import {

	private static DisplayController display = DisplayController.getInstance();

	/* -------------------------------------------------- IMPORT KNOWLDGE METHOD -------------------------------------------------- */

	private static boolean importKnowledge(Characters hero, String line) {
		 Map<String, Integer> map = new HashMap<>();

		if (line == null || line.isEmpty() || line.equals("{}"))
			return false;
		
		line = line.replaceAll("[{}]", "");

		String[] entries = line.split(",\\s*");

		for (String entry : entries) {
			String[] parts = entry.split("=");
			if (parts.length == 2) {
				String key = parts[0].trim();
				try {
					int value = Integer.parseInt(parts[1].trim());
					map.put(key, value);
				} catch (NumberFormatException e) {
					display.printNormal(RED_BOLD + "Error: invalid Knowledge data!" + NO_LOAD + RESET);
				}
			}
		}
		hero.getKnowledge().setMap(map);
		return true;
	}

	/* -------------------------------------------------- IMPORT BAG METHOD -------------------------------------------------- */

	private static boolean importBag(Characters hero, String line) {
		String name;
		String type;
		String rarity;
		boolean match = false;
		boolean isEquipped;
		int bonus;

		String processedData[] = line.split("\\%");

		for (String tmp : processedData) {

			String tmpData[] = tmp.split(",");
			if (tmpData.length != 5) {
				display.printNormal(RED_BOLD + "Error: invalid Bag data size!" + NO_LOAD + RESET);
				display.getUserInput();
				return false;
			}

			/* NAME */
			name = tmpData[0];
			if (name.isEmpty()) {
				display.printNormal(RED_BOLD + "Error: invalid Item name!" + NO_LOAD + RESET);
				display.getUserInput();
				return false;
			}

			/* ISEQUIPPED */
			switch(tmpData[1]) {
				case "true":
					isEquipped = true;
					break;
				
				case "false":
					isEquipped = false;
					break;
				
				default:
					display.printNormal(RED_BOLD + "Error: invalid Item isEquipped!" + NO_LOAD + RESET);
					display.getUserInput();
					return false;
			}

			/* BONUS */
			try {
				bonus = Integer.parseInt(tmpData[2]);
			} catch (NumberFormatException e) {
				display.printNormal(RED_BOLD + "Error: invalid Item values - bonus not a integer!" + NO_LOAD + RESET);
				display.getUserInput();
				return false;
			}
			if (bonus < 1 || bonus > 48) {
				display.printNormal(RED_BOLD + "Error: invalid Item values -impossible bonus" + NO_LOAD + RESET);
				display.getUserInput();
				return false;
			}

			/* RARITY */
			match = List.of(COMMON, RARE, EPIC, LEGENDARY).contains(tmpData[3]);
			if (!match) {
				display.printNormal(RED_BOLD + "Error: invalid Item rarity!" + NO_LOAD + RESET);
				display.getUserInput();
				return false;
			}
			else
				rarity = tmpData[3];
			
			/* TYPE */
			match = List.of(ARMOR_TYPE, HELM_TYPE, WEAPON_TYPE, CONSOMMABLE_TYPE).contains(tmpData[4]);
			if (!match) {
				display.printNormal(RED_BOLD + "Error: invalid Item type!" + NO_LOAD + RESET);
				display.getUserInput();
				return false;
			}
			else
				type = tmpData[4];

			hero.addArtefact(ArtefactFactory.getInstance().loadArtefact(name, isEquipped, bonus, rarity, type));
		}
		return true;
	}


	/* -------------------------------------------------- IMPORT CHARACTER METHOD -------------------------------------------------- */

	private static Characters importCharacter(String line) {
		String name;
		String characterClass;
		boolean match;
		int lvl;
		int xp;
		int att;
		int def;
		int hp;
		int maxHp;

		String processedData[] = line.split(",");
		if (processedData.length != 8) {
			display.printNormal(RED_BOLD + "Error: invalid Characters data size!" + NO_LOAD + RESET);
			display.getUserInput();
			return null;
		}
		/* NAME */
		name = processedData[0];
		if (name.isEmpty()) {
			display.printNormal(RED_BOLD + "Error: invalid Item name!" + NO_LOAD + RESET);
			display.getUserInput();
			return null;
		}

		/* CLASS */
		match = List.of(WARRIOR_CLASS, MAGE_CLASS, PALADIN_CLASS, ASSASSIN_CLASS, ARCHER_CLASS).contains(processedData[1]);
		if (!match) {
			display.printNormal(RED_BOLD + "Error: invalid Characters class!" + NO_LOAD + RESET);
			display.getUserInput();
			return null;
		}
		else
			characterClass = processedData[1];

		/* ATT-DEF-HP */
		try {
			lvl = Integer.parseInt(processedData[2]);
			xp = Integer.parseInt(processedData[3]);
			att = Integer.parseInt(processedData[4]);
			def = Integer.parseInt(processedData[5]);
			hp = Integer.parseInt(processedData[6]);
			maxHp = Integer.parseInt(processedData[7]);

		} catch (NumberFormatException e) {
			display.printNormal(RED_BOLD + "Error: invalid Characters values - not a integer!" + NO_LOAD + RESET);
			display.getUserInput();
			return null;
		}
		if (lvl < 0 || xp < 0 || att < 0 || def < 0 || hp < 0 || maxHp < 0) {
			display.printNormal(RED_BOLD + "Error: invalid Characters values - negative value!" + NO_LOAD + RESET);
			display.getUserInput();
			return null;
		}
		if (att > 70 || def > 65 || maxHp > 240 || hp > 240) {
			display.printNormal(RED_BOLD + "Error: invalid Characters values - impossible values!" + NO_LOAD + RESET);
			display.getUserInput();
			return null;
		}
		
		return (CharactersFactory.getInstance().loadCharacters(HERO_TYPE, name, characterClass, lvl, xp, att, def, hp, maxHp));
	}

	/* -------------------------------------------------- FILE PARSER METHOD -------------------------------------------------- */

	private static void addLoadHero(Game ref, Characters importHero) {
		ref.getHeroesNameList().add(importHero.getName());
		ref.getListAvaible().add(importHero);
	}

	private static void removeLoadHero(Game ref, Characters importHero) {
		ref.getHeroesNameList().remove(importHero.getName());
		ref.getListAvaible().remove(importHero);
	}

	public static void fileParser(Game ref) {
		File file = new File("save.txt");
		Characters importHero;
		boolean checkerBag = false;
		boolean checkerKnowledge = false;

		try (Scanner myReader = new Scanner(file)) {
			if (!myReader.hasNextLine()) {
				display.printNormal(BLUE + "Empty save detected. Press ENTER to continue..." + RESET);
				display.getUserInput();
				return;
			}
			String data = myReader.nextLine();
			String[] characters = data.split("\\*");

			for (String line : characters) {
				String[] characterData = line.split("\\|");

				if (characterData.length > 3) {
					display.printNormal(RED_BOLD + "Error: invalid data size..." + NO_LOAD + RESET);
					display.getUserInput();
					return;
				}

				importHero = importCharacter(characterData[0]);
				if (importHero == null)
					return;

				switch (characterData.length) {
					case ONLY_HERO:
						addLoadHero(ref, importHero);
						break;

					case HERO_BAG:
						addLoadHero(ref, importHero);
						checkerBag = importBag(importHero, characterData[1]);
						if (!checkerBag) {
							removeLoadHero(ref, importHero);
							return;
						}
						break;
					
					case HERO_KNOWLDGE_OR_HERO_BAG_KNOWLEDGE:
						if (characterData[1].isEmpty()) {
							addLoadHero(ref, importHero);
							checkerKnowledge = importKnowledge(importHero, characterData[2]);
							if (!checkerKnowledge) {
								removeLoadHero(ref, importHero);
								return;
							}
						}
						else {
							addLoadHero(ref, importHero);
							checkerBag = importBag(importHero, characterData[1]);
							checkerKnowledge = importKnowledge(importHero, characterData[2]);
							if (!checkerBag || !checkerKnowledge) {
								removeLoadHero(ref, importHero);
								return;
							}
							checkerKnowledge = importKnowledge(importHero, characterData[2]);
						}
						break;

					default:
						break;
				}
			}
		} catch (FileNotFoundException e) {
			display.printNormal(RED + "Error while parsing save.txt file." + RESET + NO_LOAD);
		}
	}

	/* -------------------------------------------------- FILE CHECKER METHOD -------------------------------------------------- */

	public static boolean fileChecker() {
		
		File file = new File("save.txt");

		if (!file.exists()) {
			display.printNormal(ORANGE_BOLD + "No save detected! Press ENTER to continue..." + RESET);
			display.getUserInput();
			return false;
		}

		if (file.canWrite() || file.canExecute() || !file.canRead()) {
			display.printNormal(RED_BOLD + "Modification detected or corrupted data!"  + RESET + " The " + ITALIC + "save.txt" + RESET + " file will not be loaded! Press ENTER to continue...");
			display.getUserInput();
			return false;
		}
		else {
			display.printNormal ( BOLD + BLUE + "Loading " + ITALIC + "save.txt" + RESET + BLUE + BOLD + " file... Press ENTER to continue..." + RESET);
			display.getUserInput();
			return true;
		}
	}
}
package com.swingy.controller;

import static com.swingy.utils.Constants.*;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.swingy.model.CharactersFactory;
import com.swingy.model.Coordinates;
import com.swingy.view.DisplayController;
import com.swingy.model.ArtefactFactory;
import com.swingy.model.Characters;

public class Import {

	/* -------------------------------------------------- IMPORT BAG METHOD -------------------------------------------------- */

	private static boolean importBag(Characters hero, String line, Game ref) {
		String name;
		String type;
		String rarity;
		boolean match = false;
		boolean isEquipped;
		int bonus;

		System.out.println(DEBUG_BOLD + "line: " + line + RESET);
		String processedData[] = line.split("\\%");

		for (String tmp : processedData) {
			System.out.println(DEBUG_BOLD + "tmp: "+ tmp + RESET);

			String tmpData[] = tmp.split(",");
			if (tmpData.length != 5) {
				System.out.println(RED_BOLD + "Error: invalid Bag data size!" + RESET);
				DisplayController.getInstance().getUserInput();
				return false;
			}

			// NAME
			name = tmpData[0];
			if (name.isEmpty()) {
				System.out.println(RED_BOLD + "Error: invalid Item name!" + RESET);
				DisplayController.getInstance().getUserInput();
				return false;
			}

			//ISEQUIPPED
			switch(tmpData[1]) {
				case "true":
					isEquipped = true;
					break;
				
				case "false":
					isEquipped = false;
					break;
				
				default:
					System.out.println(RED_BOLD + "Error: invalid Item isEquipped!" + RESET);
					DisplayController.getInstance().getUserInput();
					return false;
			}

			//BONUS
			try {
				bonus = Integer.parseInt(tmpData[2]);
			} catch (NumberFormatException e) {
				System.out.println(RED_BOLD + "Error: invalid Item values - bonus not a integer!" + RESET);
				DisplayController.getInstance().getUserInput();
				return false;
			}
			if (bonus < 1 || bonus > 48) {
				System.out.println(RED_BOLD + "Error: invalid Item values -impossible bonus" + RESET);
				DisplayController.getInstance().getUserInput();
				return false;
			}

			//RARITY
			match = List.of(COMMON, RARE, EPIC, LEGENDARY).contains(tmpData[3]);
			if (!match) {
				System.out.println(RED_BOLD + "Error: invalid Item rarity!" + RESET);
				DisplayController.getInstance().getUserInput();
				return false;
			}
			else
				rarity = tmpData[3];
			
			//TYPE
			match = List.of(ARMOR_TYPE, HELM_TYPE, WEAPON_TYPE, CONSOMMABLE_TYPE).contains(tmpData[4]);
			if (!match) {
				System.out.println(RED_BOLD + "Error: invalid Item type!" + RESET);
				DisplayController.getInstance().getUserInput();
				return false;
			}
			else
				type = tmpData[4];

			// now can add item
			hero.addArtefact(ArtefactFactory.getInstance().loadArtefact(name, isEquipped, bonus, rarity, type));
		}
		DisplayController.getInstance().getUserInput();

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
			System.out.println(RED_BOLD + "Error: invalid Characters data size!" + RESET);
			DisplayController.getInstance().getUserInput();
			return null;
		}
		for (String processedDataLine : processedData) {
			System.out.println(DEBUG_BOLD + processedDataLine + RESET);
		}
		/* NAME */
		name = processedData[0];

		/* CLASS */
		match = List.of(WARRIOR_CLASS, MAGE_CLASS, PALADIN_CLASS, ASSASSIN_CLASS, ARCHER_CLASS).contains(processedData[1]);
		if (!match) {
			System.out.println(RED_BOLD + "Error: invalid Characters class!" + RESET);
			DisplayController.getInstance().getUserInput();
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

			if (lvl < 0 || xp < 0 || att < 0 || def < 0 || hp < 0 || maxHp < 0) {
				System.out.println(RED_BOLD + "Error: invalid Characters values - negative value!" + RESET);
				DisplayController.getInstance().getUserInput();
				return null;
			}
			if (att > 70 || def > 65 || maxHp > 240) {
				System.out.println(RED_BOLD + "Error: invalid Characters values - impossible values!" + RESET);
				DisplayController.getInstance().getUserInput();
				return null;
			}
		} catch (NumberFormatException e) {
			System.out.println(RED_BOLD + "Error: invalid Characters values - not a integer!" + RESET);
			DisplayController.getInstance().getUserInput();
			return null;
		}
		// ref.getHeroesNameList().add(name);
		// ref.getListAvaible().add(CharactersFactory.getInstance().loadCharacters(HERO_TYPE, name, characterClass, lvl, xp, att, def, hp, maxHp));
		
		return (CharactersFactory.getInstance().loadCharacters(HERO_TYPE, name, characterClass, lvl, xp, att, def, hp, maxHp));
	}

	/* -------------------------------------------------- FILE PARSER METHOD -------------------------------------------------- */

	public static void fileParser(Game ref) {
		File file = new File("save.txt");
		Characters importHero;
		boolean checkerBag = false;

		try (Scanner myReader = new Scanner(file)) {
			if (!myReader.hasNextLine()) {
				System.out.println(DEBUG_BOLD + "EMPTY SAVE" + RESET);
				DisplayController.getInstance().getUserInput();
				return;
			}
			String data = myReader.nextLine();

			// Split each character block with '*'
			String[] characters = data.split("\\*");

			for (String line : characters) {
				// Split each character's data section with '|'
				String[] characterData = line.split("\\|");

				if (characterData.length > 3) {
					System.out.println(RED_BOLD + "Error: invalid data size... Press ENTER to continue..." + RESET);
					DisplayController.getInstance().getUserInput();
					return;
				}

				switch (characterData.length) {
					case 1:
						importHero = importCharacter(characterData[0]);
						if (importHero == null)
							return;
						else {
							ref.getHeroesNameList().add(importHero.getName());
							ref.getListAvaible().add(importHero);
						}
						break;

					case 2:
						importHero = importCharacter(characterData[0]);
						if (importHero == null)
							return;
						else {
							ref.getHeroesNameList().add(importHero.getName());
							ref.getListAvaible().add(importHero);
							checkerBag = importBag(importHero, characterData[1], ref);
							if (!checkerBag) {
								// may loop here to delete all heroes from this save ? corrupted data -> no load!
								ref.getHeroesNameList().remove(importHero.getName());
								ref.getListAvaible().remove(importHero);
								return;
							}
						}

						break;
					
					case 3:
						importHero = importCharacter(characterData[0]);
						if (importHero == null)
							return;
						else {
							if (characterData[1].isEmpty())
								System.out.println(DEBUG_BOLD + "Only knowledge!");
							else {
								System.out.println(DEBUG_BOLD + "Knowledge and Bag!");
								ref.getHeroesNameList().add(importHero.getName());
								ref.getListAvaible().add(importHero);
								checkerBag = importBag(importHero, characterData[1], ref);
								if (!checkerBag) {
									// may loop here to delete all heroes from this save ? corrupted data -> no load!
									ref.getHeroesNameList().remove(importHero.getName());
									ref.getListAvaible().remove(importHero);
									return;
								}
							}
						}
						break;

					default:
						break;
				}

				DisplayController.getInstance().getUserInput();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/* -------------------------------------------------- FILE CHECKER METHOD -------------------------------------------------- */

	public static boolean fileChecker() {
		
		File file = new File("save.txt");
		DisplayController display = DisplayController.getInstance();

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
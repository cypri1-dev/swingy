package com.swingy.controller;

import static com.swingy.utils.Constants.*;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.swingy.model.CharactersFactory;
import com.swingy.view.DisplayController;

public class Import {

	private static boolean importCharacter(String line, Game ref) {
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
			return false;
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
			return false;
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
				return false;
			}
			if (att > 70 || def > 65 || maxHp > 240) {
				System.out.println(RED_BOLD + "Error: invalid Characters values - impossible values!" + RESET);
				DisplayController.getInstance().getUserInput();
				return false;
			}
		} catch (NumberFormatException e) {
			System.out.println(RED_BOLD + "Error: invalid Characters values - not a integer!" + RESET);
			DisplayController.getInstance().getUserInput();
			return false;
		}
		ref.getListAvaible().add(CharactersFactory.getInstance().loadCharacters(HERO_TYPE, name, characterClass, lvl, xp, att, def, hp, maxHp));
		
		return true;
	}

	public static void fileParser(Game ref) {
		File file = new File("save.txt");
		boolean checker = false;

		try (Scanner myReader = new Scanner(file)) {
			while (myReader.hasNextLine()) {
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
							checker = importCharacter(characterData[0], ref);
							if (!checker)
								return;
							break;

						default:
							break;
					}

					// DEBUG (optionnel)
					// for (String characterDataLine : characterData) {
					//     System.out.println(DEBUG_BOLD + characterDataLine + RESET);
					// }

					DisplayController.getInstance().getUserInput();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

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
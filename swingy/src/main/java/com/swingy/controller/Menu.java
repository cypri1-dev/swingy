package com.swingy.controller;

import static com.swingy.utils.Constants.*;

import java.util.Scanner;
import java.util.Set;

import com.swingy.model.CharactersFactory;
import com.swingy.view.DisplayController;

public class Menu {

	private Game ref;
	private final Scanner scanner = new Scanner(System.in);

	Menu(Game game) {
		this.ref = game;
	}

	public void launchGame() {
		DisplayController.getInstance().clearTerminal();
		DisplayController.getInstance().printSlow(MAIN_HEADER);
		DisplayController.getInstance().sleepTime(900);
		DisplayController.getInstance().clearTerminal();
		DisplayController.getInstance().printSlow(MAIN_MENU);

		String option = "";

		do {
			DisplayController.getInstance().printSlow(SELECT_OPTION);
			option = scanner.nextLine();
		} while (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4"));

		switch (option) {
			case "1":
				DisplayController.getInstance().clearTerminal();
				createHero();
				break;
			case "4":
				DisplayController.getInstance().clearTerminal();
				DisplayController.getInstance().printSlow(OUT_MSG);
				scanner.close();
				System.exit(0);
			default:
				break;
		}
	}

	public void createHero() {
		Set<String> validOption = Set.of("1", "2", "3", "4", "5");

		DisplayController.getInstance().printSlow(MENU_CREATION);
		DisplayController.getInstance().printSlow(NAME_HERO);
		String inputName = scanner.nextLine();
		DisplayController.getInstance().clearTerminal();
		String optionClass = "";
		do {
			DisplayController.getInstance().printSlow(CHOOSE_CLASS);
			optionClass = scanner.nextLine().trim().toLowerCase();

		} while (!validOption.contains(optionClass));
		
		String characterClass = "";
		switch (optionClass) {
			case "1":
				characterClass = WARRIOR_CLASS;
				break;
			case "2":
				characterClass = MAGE_CLASS;
				break;
			case "3":
				characterClass = ARCHER_CLASS;
				break;
			case "4":
				characterClass = PALADIN_CLASS;
				break;
			case "5":
				characterClass = ASSASSIN_CLASS;
				break;
			default:
				break;
		}
		ref.getListAvaible().add(CharactersFactory.getInstance().newCharacters(HERO_TYPE, inputName, characterClass));
		// scanner.close();
	}

	static private void removeHero() {}

	static private void loadHero() {}
}
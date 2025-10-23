package com.swingy.controller;

import static com.swingy.utils.Constants.*;

import java.util.Scanner;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

import com.swingy.model.CharactersFactory;
import com.swingy.view.DisplayController;
import com.swingy.model.Characters;

public class Menu {

	private Game ref;
	private final Scanner scanner = new Scanner(System.in);
	private List<String> herosName;

	Menu(Game game) {
		this.ref = game;
		this.herosName = new ArrayList<String>();
	}

	/* -------------------------------------------------- MENU OPTIONS -------------------------------------------------- */

	private void creationOption() {
		DisplayController.getInstance().clearTerminal();
		createHero();
	}

	private void heroesManagementOption() {
		DisplayController.getInstance().clearTerminal();
		DisplayController.getInstance().printSlow(VIEW_HEROS);
		viewMyHeros();
		if (this.ref.getListAvaible().isEmpty()) {
			DisplayController.getInstance().printSlow(ENTER_BACK);
			scanner.nextLine();
		}
		else
			removeHero();
	}

	public void arenaOption() {
		Characters hero = selectHero(ref);
		if (hero == null) return;

		ref.placeHero(hero);

		DisplayController.getInstance().clearTerminal();
		DisplayController.getInstance().displayMap(ref);

		ref.runArenaLoop();

		endArena();
	}

	private void exitOption() {
		DisplayController.getInstance().clearTerminal();
		DisplayController.getInstance().printSlow(OUT_MSG);
		scanner.close();
		System.exit(0);
	}

	private void d_vOption() {
		DisplayController.getInstance().clearTerminal();
		String optionSelected = "";
		do {
			DisplayController.getInstance().printSlow(A_SIMPLE + "\n");
			optionSelected = scanner.nextLine();
		} while (!optionSelected.equals("1") && !optionSelected.equals("2"));

		switch (optionSelected) {
			case "1":
				boolean validInput = false;
				int s___d = 0;
				D_V_M___E = true;

				do {
					try {
						DisplayController.getInstance().printSlow(SPEED + "\n");
						s___d = Integer.parseInt(scanner.nextLine());
						validInput = true;
					}
					catch (NumberFormatException e) {
						System.out.println("NOP");
					}
				} while (!validInput);
				D_V_S___D_T_T = s___d;

			case "2":
				break;
			
			default:
				break;
		}
	}

	/* -------------------------------------------------- MAIN MENU -------------------------------------------------- */

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
		} while (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("S"));

		switch (option) {
			case "1":
				creationOption();
				break;
			case "2":
				heroesManagementOption();
				break;
			case "3":
				arenaOption();
				break;
			case "4":
				exitOption();
			case "S":
				d_vOption();
			default:
				break;
		}
	}

	public void createHero() {
		Set<String> validOption = Set.of("1", "2", "3", "4", "5");

		DisplayController.getInstance().printSlow(MENU_CREATION);
		DisplayController.getInstance().printSlow(NAME_HERO);
		String inputName = "";
		do {
			inputName = scanner.nextLine();
			if (inputName.isEmpty() || this.herosName.contains(inputName)) {
				DisplayController.getInstance().printSlow(ERROR_NAME);
			}
			if (inputName.equals("x") || inputName.equals("X"))
				return;
		} while (inputName.isEmpty() || this.herosName.contains(inputName));
		this.herosName.add(inputName);
		DisplayController.getInstance().clearTerminal();
		String optionClass = "";
		do {
			DisplayController.getInstance().printSlow(CHOOSE_CLASS);
			optionClass = scanner.nextLine();

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
	}

	/* -------------------------------------------------- METHOD MENU -------------------------------------------------- */

	public Characters selectHero(Game game) {
		DisplayController display = DisplayController.getInstance();
		display.clearTerminal();
		display.printMyHeros(game);

		if (game.getListAvaible().isEmpty()) {
			display.printSlow(WARNING);
			scanner.nextLine();
			return null;
		}

		Characters selectedHero = null;
		String input;
		do {
			display.printSlow(SELECT_HERO + "\n");
			input = scanner.nextLine();

			if (input.equalsIgnoreCase("x")) return null;

			for (Characters hero : game.getListAvaible()) {
				if (hero.getName().equals(input)) {
					selectedHero = hero;
					break;
				}
			}
		} while (selectedHero == null);

		return selectedHero;
	}

	public void viewMyHeros() {
		DisplayController.getInstance().printMyHeros(ref);
	}

	public void removeHero() {
		
		String selectedHero = "";
		do {
			DisplayController.getInstance().printSlow(DELETE_HERO + "\n");
			// System.out.println("\n");
			selectedHero = scanner.nextLine();
		} while (!this.herosName.contains(selectedHero) && !selectedHero.equals("X") && !selectedHero.equals("x"));

		for (Characters hero : this.ref.getListAvaible()) {
			if (selectedHero.equals(hero.getName())) {
				this.ref.getListAvaible().remove(hero);
				this.herosName.remove(selectedHero);
				break;
			}
		}
	}

	public void endArena() {
		DisplayController display = DisplayController.getInstance();
		display.printSlow("🏁 Level completed or game exited.\n");
		display.printSlow("Press ENTER to return.\n");
		scanner.nextLine();
	}
}
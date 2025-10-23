package com.swingy.controller;

import static com.swingy.utils.Constants.*;

import java.util.Scanner;
import java.util.Set;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import com.swingy.model.CharactersFactory;
import com.swingy.model.MapFactory;
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

	private void arenaOption() {
		DisplayController display = DisplayController.getInstance();
		display.clearTerminal();

		if (this.ref.getListAvaible().isEmpty()) {
			display.printSlow(WARNING);
			scanner.nextLine();
			return;
		}

		display.printMyHeros(ref);
		String selectedHero = "";

		do {
			display.printSlow(SELECT_HERO);
			selectedHero = scanner.nextLine();

			if (selectedHero.equalsIgnoreCase("x"))
				return;

		} while (!this.herosName.contains(selectedHero));

		for (Characters hero : this.ref.getListAvaible()) {
			if (selectedHero.equals(hero.getName())) {
				hero.getCoordinates().setStart((hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2));
				this.ref.setSelectedHero(hero);
				this.ref.setActualMap(MapFactory.getInstance().newMap(hero));
				break;
			}
		}

		display.clearTerminal();
		display.displayMap(this.ref);
		display.printSlow(RULES);

		boolean running = true;

		while (running && !this.ref.getMap().getLevelCompleted()) {
			try {
				int c = System.in.read();

				if (c == 27) { // ESC (début séquence ANSI)
					int next1 = System.in.read();
					int next2 = System.in.read();

					if (next1 == 91) { // '['
						switch (next2) {
							case 'A': // ↑
								this.ref.getMainHero().getMovement().moveNorth(this.ref.getMainHero(), this.ref.getMap());
								break;
							case 'B': // ↓
								this.ref.getMainHero().getMovement().moveSouth(this.ref.getMainHero(), this.ref.getMap());
								break;
							case 'C': // →
								this.ref.getMainHero().getMovement().moveEast(this.ref.getMainHero(), this.ref.getMap());
								break;
							case 'D': // ←
								this.ref.getMainHero().getMovement().moveWest(this.ref.getMainHero(), this.ref.getMap());
								break;
						}

						// --- Affichage après un seul mouvement ---
						display.clearTerminal();
						display.displayMap(this.ref);

						// --- Vider le buffer pour ignorer les flèches restantes ---
						while (System.in.available() > 0) {
							System.in.read();
						}
					}
				} else if (c == 'x' || c == 'X') {
					running = false;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		display.printSlow("🏁 Level completed or game exited.");
		display.printSlow(ENTER_BACK);
		scanner.nextLine();
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
			DisplayController.getInstance().printSlow(A_SIMPLE);
			optionSelected = scanner.nextLine();
		} while (!optionSelected.equals("1") && !optionSelected.equals("2"));

		switch (optionSelected) {
			case "1":
				boolean validInput = false;
				int s___d = 0;
				D_V_M___E = true;

				do {
					try {
						DisplayController.getInstance().printSlow(SPEED);
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

	public void viewMyHeros() {
		DisplayController.getInstance().printMyHeros(ref);
	}

	public void removeHero() {
		
		String selectedHero = "";
		do {
			DisplayController.getInstance().printSlow(DELETE_HERO);
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
}
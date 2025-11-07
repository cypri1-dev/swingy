package com.swingy.controller;

import static com.swingy.utils.Constants.*;

import java.util.Set;

import com.swingy.model.CharactersFactory;
import com.swingy.view.DisplayController;
import com.swingy.model.Artefact;
import com.swingy.model.Characters;

public class Menu {

	private Game ref;
	private static DisplayController display = DisplayController.getInstance();;

	Menu(Game game) {
		this.ref = game;
		// this.display = DisplayController.getInstance();
	}

	/* -------------------------------------------------- MENU OPTIONS -------------------------------------------------- */

	private void creationOption() {
		display.clearTerminal();
		createHero();
	}

	private void heroesManagementOption() {
		display.clearTerminal();
		display.printSlow(VIEW_HEROS);
		viewMyHeros();
		if (this.ref.getListAvaible().isEmpty()) {
			display.printSlow(ENTER_BACK);
			display.getUserInput();
		}
		else
			removeHero();
	}

	private void arenaOption(Menu menu) {
		Characters hero = selectHero(ref);
		if (hero == null) return;

		ref.placeHero(hero);

		display.clearTerminal();
		display.displayMap(ref);

		ref.runArenaLoop(menu);

		endArena();
	}

	private void exitOption() {
		display.clearTerminal();
		display.printSlow(OUT_MSG);
		Export.exportData(ref.getListAvaible());
		display.closeScanner();
		System.exit(0);
	}

	public void d_vOption() {
		display.clearTerminal();
		String optionSelected = "";
		do {
			display.printSlow(A_SIMPLE + "\n");
			optionSelected = display.getUserInput();
		} while (!optionSelected.equals("1") && !optionSelected.equals("2") && !optionSelected.equals("3") && !optionSelected.equals("4"));

		switch (optionSelected) {
			case "1":
				boolean validInput = false;
				int s___d = 0;
				D_V_M___E = true;

				do {
					try {
						display.printSlow(SPEED + "\n");
						s___d = Integer.parseInt(display.getUserInput());
						validInput = true;
					}
					catch (NumberFormatException e) {
						display.printNormal("NOP");
					}
				} while (!validInput || s___d < 0);
				D_V_S___D_T_T = s___d;

			case "2":
				break;

			case "3":
				if (this.ref.getMap() == null)
					break;
				else {
					for (Characters enemies : this.ref.getMap().getListEnemies()) {
						int tmpX = enemies.getCoordinates().getX();
						int tmpY = enemies.getCoordinates().getY();
						String symbol = "?";

					if (enemies.getArtefacts().isEmpty()) {
						switch (enemies.getCharacterClass()) {
						case ENEMY_CLASS_RAT: symbol = RED + SYMBOL_ENEMY_RAT + RESET; break;
						case ENEMY_CLASS_SLIME: symbol = RED + SYMBOL_ENEMY_SLIME + RESET; break;
						case ENEMY_CLASS_GOBLIN: symbol = RED + SYMBOL_ENEMY_GOBLIN + RESET; break;
						case ENEMY_CLASS_BANDIT: symbol = RED + SYMBOL_ENEMY_BANDIT + RESET; break;

						case ENEMY_CLASS_SKELETON: symbol = RED + SYMBOL_ENEMY_SKELETON + RESET; break;
						case ENEMY_CLASS_WOLF: symbol = RED + SYMBOL_ENEMY_WOLF + RESET; break;
						case ENEMY_CLASS_CULTIST: symbol = RED + SYMBOL_ENEMY_CULTIST + RESET; break;
						case ENEMY_CLASS_ORC: symbol = RED + SYMBOL_ENEMY_ORC + RESET; break;

						case ENEMY_CLASS_DARK_MAGE: symbol = RED + SYMBOL_ENEMY_DARK_MAGE + RESET; break;
						case ENEMY_CLASS_ELEMENTAL: symbol = RED + SYMBOL_ENEMY_ELEMENTAL + RESET; break;
						case ENEMY_CLASS_TROLL: symbol = RED + SYMBOL_ENEMY_TROLL + RESET; break;
						case ENEMY_CLASS_ASSASSIN: symbol = RED + SYMBOL_ENEMY_ASSASSIN + RESET; break;

						case ENEMY_CLASS_LICH: symbol = RED + SYMBOL_ENEMY_LICH + RESET; break;
						case ENEMY_CLASS_MINOTAUR: symbol = RED + SYMBOL_ENEMY_MINOTAUR + RESET; break;
						case ENEMY_CLASS_VAMPIRE_LORD: symbol = RED + SYMBOL_ENEMY_VAMPIRE_LORD + RESET; break;
						case ENEMY_CLASS_DEMON_KNIGHT: symbol = RED + SYMBOL_ENEMY_DEMON_KNIGHT + RESET; break;

						case ENEMY_CLASS_DRAGON_WHELP: symbol = RED + SYMBOL_ENEMY_DRAGON_WHELP + RESET; break;
						case ENEMY_CLASS_ANCIENT_DRAGON: symbol = RED + SYMBOL_ENEMY_ANCIENT_DRAGON + RESET; break;
						case ENEMY_CLASS_ABYSSAL_HYDRA: symbol = RED + SYMBOL_ENEMY_ABYSSAL_HYDRA + RESET; break;
						case ENEMY_CLASS_FALLEN_GOD: symbol = RED + SYMBOL_ENEMY_FALLEN_GOD + RESET; break;

						default: symbol = SYMBOL_ENEMY; break;
						}

						this.ref.getMap().map[tmpX][tmpY] = symbol;
					}
					else  {
						switch (enemies.getCharacterClass()) {
							case ENEMY_CLASS_RAT: symbol = GREEN + SYMBOL_ENEMY_RAT + RESET; break;
							case ENEMY_CLASS_SLIME: symbol = GREEN + SYMBOL_ENEMY_SLIME + RESET; break;
							case ENEMY_CLASS_GOBLIN: symbol = GREEN + SYMBOL_ENEMY_GOBLIN + RESET; break;
							case ENEMY_CLASS_BANDIT: symbol = GREEN + SYMBOL_ENEMY_BANDIT + RESET; break;
	
							case ENEMY_CLASS_SKELETON: symbol = GREEN + SYMBOL_ENEMY_SKELETON + RESET; break;
							case ENEMY_CLASS_WOLF: symbol = GREEN + SYMBOL_ENEMY_WOLF + RESET; break;
							case ENEMY_CLASS_CULTIST: symbol = GREEN + SYMBOL_ENEMY_CULTIST + RESET; break;
							case ENEMY_CLASS_ORC: symbol = GREEN + SYMBOL_ENEMY_ORC + RESET; break;
	
							case ENEMY_CLASS_DARK_MAGE: symbol = GREEN + SYMBOL_ENEMY_DARK_MAGE + RESET; break;
							case ENEMY_CLASS_ELEMENTAL: symbol = GREEN + SYMBOL_ENEMY_ELEMENTAL + RESET; break;
							case ENEMY_CLASS_TROLL: symbol = GREEN + SYMBOL_ENEMY_TROLL + RESET; break;
							case ENEMY_CLASS_ASSASSIN: symbol = GREEN + SYMBOL_ENEMY_ASSASSIN + RESET; break;
	
							case ENEMY_CLASS_LICH: symbol = GREEN + SYMBOL_ENEMY_LICH + RESET; break;
							case ENEMY_CLASS_MINOTAUR: symbol = GREEN + SYMBOL_ENEMY_MINOTAUR + RESET; break;
							case ENEMY_CLASS_VAMPIRE_LORD: symbol = GREEN + SYMBOL_ENEMY_VAMPIRE_LORD + RESET; break;
							case ENEMY_CLASS_DEMON_KNIGHT: symbol = GREEN + SYMBOL_ENEMY_DEMON_KNIGHT + RESET; break;
	
							case ENEMY_CLASS_DRAGON_WHELP: symbol = GREEN + SYMBOL_ENEMY_DRAGON_WHELP + RESET; break;
							case ENEMY_CLASS_ANCIENT_DRAGON: symbol = GREEN + SYMBOL_ENEMY_ANCIENT_DRAGON + RESET; break;
							case ENEMY_CLASS_ABYSSAL_HYDRA: symbol = GREEN + SYMBOL_ENEMY_ABYSSAL_HYDRA + RESET; break;
							case ENEMY_CLASS_FALLEN_GOD: symbol = GREEN + SYMBOL_ENEMY_FALLEN_GOD + RESET; break;
	
							default: symbol = SYMBOL_ENEMY; break;
							}
	
							this.ref.getMap().map[tmpX][tmpY] = symbol;
						}
					}
					for (Artefact items : this.ref.getMap().getListConsommable()) {
						int tmpXC = items.getCoordinates().getX();
						int tmpYC = items.getCoordinates().getY();
						this.ref.getMap().map[tmpXC][tmpYC] = BLUE + "P" + RESET;
					}
				}
				break;
			case "4":
				if (this.ref.getMainHero() != null)
					this.ref.getMainHero().setHitPoint(10000000);
				break;
			default:
				break;
		}
	}

	/* -------------------------------------------------- MAIN MENU -------------------------------------------------- */

	public void launchGame() {
		display.clearTerminal();
		display.printSlow(MAIN_HEADER);
		display.sleepTime(900);
		display.clearTerminal();
		
		String option = "";
		
		do {
			display.clearTerminal();
			display.printSlow(MAIN_MENU);
			display.printSlow(SELECT_OPTION);
			option = display.getUserInput();
		} while (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("S"));

		switch (option) {
			case "1":
				creationOption();
				break;
			case "2":
				heroesManagementOption();
				break;
			case "3":
				arenaOption(this);
				break;
			case "4":
				exitOption();
				break;
			case "S":
				d_vOption();
				break;
			default:
				break;
		}
	}

	private void createHero() {
		Set<String> validOption = Set.of("1", "2", "3", "4", "5");

		display.printSlow(MENU_CREATION);
		display.printSlow(NAME_HERO);
		String inputName = "";
		do {
			inputName = display.getUserInput().trim();
			if (inputName.isEmpty() || ref.heroExists(inputName)) {
				display.printSlow(ERROR_NAME);
			}
			if (inputName.equals("x") || inputName.equals("X"))
				return;
		} while (inputName.isEmpty() || ref.heroExists(inputName) || inputName.equals("X") || inputName.equals("x"));
		ref.registerHeroName(inputName);
		display.clearTerminal();
		String optionClass = "";
		do {
			display.printSlow(CHOOSE_CLASS);
			optionClass = display.getUserInput();

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

	/* -------------------------------------------------- METHOD MAIN MENU -------------------------------------------------- */

	private Characters selectHero(Game game) {
		display.clearTerminal();
		display.printMyHeros(game);

		if (game.getListAvaible().isEmpty()) {
			display.printSlow(WARNING);
			display.getUserInput();
			return null;
		}

		Characters selectedHero = null;
		String input;
		do {
			display.printSlow(SELECT_HERO + "\n");
			input = display.getUserInput();

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

	private void viewMyHeros() {
		display.printMyHeros(ref);
	}

	private void removeHero() {
		
		String selectedHero = "";
		do {
			display.printSlow(DELETE_HERO + "\n");
			selectedHero = display.getUserInput();
		} while (!ref.heroExists(selectedHero) && !selectedHero.equals("X") && !selectedHero.equals("x"));

		Characters toRemove = null;
		for (Characters hero : this.ref.getListAvaible()) {
			if (selectedHero.equals(hero.getName())) {
				toRemove = hero;
				break;
			}
		}
		if (toRemove != null) {
			this.ref.getListAvaible().remove(toRemove);
			this.ref.getHeroesNameList().remove(selectedHero);
		}
	}

	private void endArena() {
		if (this.ref.getMap().getLevelCompleted())
			display.printSlow(LVL_COMPLETE);
		else if (this.ref.getMainHero().getHitPoint() <= 0)
			display.printSlow(GAME_OVER);
		else
			display.printSlow(EXIT_GAME);
		display.getUserInput();
	}

	/* -------------------------------------------------- INVENTORY MENU OPTIONS -------------------------------------------------- */

	private void equipOption() {
		display.printNormal(TO_EQUIPPED);
		String itemEquip = display.getUserInput();
		Artefact toEquip = null;

		for (Artefact item : ref.getMainHero().getArtefacts()) {
			if (itemEquip.contains(item.getName())) {
				toEquip = item;
				break;
			}
		}

		if (toEquip == null) {
			display.printNormal("❌ Item not found in your inventory.");
			display.printNormal("\nPress Enter to continue...");
			display.getUserInput();
			return;
		}
		else {
			this.ref.getMainHero().equipArtefact(toEquip);
			display.printNormal("🧝 " + this.ref.getMainHero().getName() + " equipped: " + toEquip.getName() + " ✨");
			display.printNormal("\nPress Enter to continue...");
			display.getUserInput();
			return;
		}
	}

	private void unequipOption() {
		display.printNormal(TO_UNEQUIPPED);
		String itemUnequip = display.getUserInput();
		Artefact toUnequipped = null;

		for (Artefact item : ref.getMainHero().getArtefacts()) {
			if (itemUnequip.equals(item.getName()) && item.getIsEquipped()) {
				toUnequipped = item;
				break;
			}
		}

		if (toUnequipped == null) {
			display.printNormal("❌ Item not found in your inventory or not equipped!.");
			display.printNormal("\nPress Enter to continue...");
			display.getUserInput();
			return;
		}
		else {
			this.ref.getMainHero().unequipArtefact(toUnequipped);
			display.printNormal("🧝 " + this.ref.getMainHero().getName() + " unequipped: " + toUnequipped.getName() + " ✨");
			display.printNormal("\nPress Enter to continue...");
			display.getUserInput();
			return;
		}

	}

	private void dropOption() {
		display.printNormal(TO_REMOVE);
		String itemName = display.getUserInput();
		Artefact toRemove = null;

		for (Artefact item : ref.getMainHero().getArtefacts()) {
			if (itemName.contains(item.getName())) {
				if (item.getIsEquipped()) {
					this.ref.getMainHero().unequipArtefact(item);
				}
				toRemove = item;
				break;
			}
		}

			if (toRemove != null) {
				ref.getMainHero().removeArtefact(toRemove);
				display.printNormal("🗑️  " + toRemove.getName() + " removed from inventory.");
			} else {
				display.printNormal("❌ Item not found in your inventory.");
			}

			display.printNormal("\nPress Enter to continue...");
			display.getUserInput();
	}

	private void potionOption() {
		Artefact potion = null;
		for (Artefact item : ref.getMainHero().getArtefacts()) {
			if (item.getType().equals(CONSOMMABLE_TYPE)) {
				ref.healHero(item.getBonus());
				potion = item;
				display.printNormal("🧝 " + this.ref.getMainHero().getName() + " recovered 10 HP 💊");
				display.printNormal("\nPress Enter to continue...");
				display.getUserInput();
				break;
			}
		}
		if (potion != null)
			ref.getMainHero().removeArtefact(potion);
	}
	
	/* -------------------------------------------------- INVENTORY MENU -------------------------------------------------- */

	public void inventoryMenu() {
		display.clearTerminal();
		String option = "";
		do {
			display.clearTerminal();
			display.printSlow(INVENTORY_MENU);
			display.displaySelelectedHero(this.ref.getMainHero());
			option = display.getUserInput();

		} while(!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4") && !option.equals("5"));

		switch (option) {
			case "1":
				equipOption();
				break;

			case "2":
				unequipOption();
				break;
			
			case "3":
				dropOption();
				break;

			case "4":
				potionOption();
				break;

			case "5":
				break;
			
			default:
				break;
		}
	}
}
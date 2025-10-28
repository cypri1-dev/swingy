package com.swingy.view;

import static com.swingy.utils.Constants.*;

import java.util.Scanner;

import com.swingy.controller.Game;
import com.swingy.model.Artefact;
import com.swingy.model.Characters;

public class DisplayController {

	private static DisplayController instance;
	private final Scanner scanner = new Scanner(System.in);

	private DisplayController() {}

	public void sleepTime(int time) {
		try {
			if (D_V_M___E) {
				Thread.sleep(D_V_S___D_T_T);
			}
			else
				Thread.sleep(time);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public static DisplayController getInstance() {
		if (instance == null) {
			instance = new DisplayController();
		}
		return instance;
	}

	public void printNormal(String txt) {
		System.out.println(txt);
	}

	public void printSlow(String asciiArt) {
	for (String line : asciiArt.split("\n")) {
		System.out.println(line);
		try {
			if (D_V_M___E) {
				Thread.sleep(D_V_S___D_T_T);
			}
			else
				// change befor final push
				Thread.sleep(25);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			}
		}
	}

	public void clearTerminal() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void printMyHeros(Game game) {
		for (Characters hero : game.getListAvaible()) {
				System.out.println("\n" + DARK_GRAY + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓" + RESET);
				System.out.println(DARK_GRAY + "┃" + RESET + BOLD + " ⚔️  " + hero.getName()+ " the " + hero.getCharacterClass().toUpperCase() + RESET);
				System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Level" + RESET + ": " + YELLOW + hero.getLevel() + RESET + 
								"   " + ITALIC + "XP" + RESET + ": " + YELLOW + hero.getXp() + RESET);
				System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Attack" + RESET + ": " + GREEN + hero.getAttack() + RESET +
								"   " + ITALIC + "Defense" + RESET + ": " + GREEN + hero.getDefense() + RESET);
				System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Hit Points" + RESET + ": " + RED + hero.getHitPoint() + "/" + hero.getMaxHitPoint() + RESET);
				System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Bag contents:" + RESET);

				if (hero.getArtefacts().isEmpty()) {
					System.out.println(DARK_GRAY + "┃" + RESET + "   " + RED + "Empty bag." + RESET);
				} else {
					for (Artefact item : hero.getArtefacts()) {
						String equippedMark = item.getIsEquipped() ? GREEN + " (E)" + RESET : "";
						System.out.println(DARK_GRAY + "┃" + RESET + "   • " + item.getName() + equippedMark);
					}
				}

				System.out.println(DARK_GRAY + "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + RESET);
			}
	}

	public void displayMap(Game game) {
		int size = game.getMap().getSize();

		System.out.println();
		System.out.println("╔" + "═".repeat(size) + "╗");

		for (int i = 0; i < size; i++) {
			System.out.print("║");
			for (int j = 0; j < size; j++) {
				System.out.print(game.getMap().map[i][j]);
			}
			System.out.println("║");
		}

		System.out.println("╚" + "═".repeat(size) + "╝");
		System.out.println();
	}

	public void displaySelelectedHero(Characters hero) {
		System.out.println("\n" + DARK_GRAY + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓" + RESET);
		System.out.println(DARK_GRAY + "┃" + RESET + BOLD + " ⚔️  " + hero.getName()+ " the " + hero.getCharacterClass().toUpperCase() + RESET);
		System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Level" + RESET + ": " + YELLOW + hero.getLevel() + RESET + "   " + ITALIC + "XP" + RESET + ": " + YELLOW + hero.getXp() + RESET);
		System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Attack" + RESET + ": " + GREEN + hero.getAttack() + RESET + "   " + ITALIC + "Defense" + RESET + ": " + GREEN + hero.getDefense() + RESET);
		System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Hit Points" + RESET + ": " + RED + hero.getHitPoint() + "/" + hero.getMaxHitPoint() + RESET);
		System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Bag contents:" + RESET);

		if (hero.getArtefacts().isEmpty()) {
			System.out.println(DARK_GRAY + "┃" + RESET + "   " + RED + "Empty bag." + RESET);
		} else {
			for (Artefact item : hero.getArtefacts()) {
				String equippedMark = item.getIsEquipped() ? GREEN + " (E)" + RESET : "";
				String color = "";
				String type = "";

				switch (item.getRarity()) {
					case COMMON:
						color = COMMON_COLOR + ITALIC;
						break;
					case RARE:
						color = BLUE + ITALIC;
						break;
					case EPIC:
						color = EPIC_COLOR + ITALIC;
						break;
					case LEGENDARY:
						color = LEGENDARY_COLOR + ITALIC;
						break;
					default:
						break;
				}

				switch (item.getType()) {
					case CONSOMMABLE_TYPE:
						type = "HP";
						break;
					case WEAPON_TYPE:
						type = "ATT";
						break;
					case ARMOR_TYPE:
						type = "DEF";
						break;
					case HELM_TYPE:
						type = "HP";
						break;
					default:
						break;
				}
				System.out.println(DARK_GRAY + "┃" + RESET + "   • " + color + item.getName() + " (+" + item.getBonus() + ")" + type + " " + RESET + equippedMark);
			}
		}

		System.out.println(DARK_GRAY + "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + RESET);
	}

	public void displayCurrentEnemy(Characters enemy, int knowledge) {
		System.out.println("\n" + DARK_GRAY + "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓" + RESET);
		System.out.println(DARK_GRAY + "┃" + RESET + BOLD + " ⚔️  " + enemy.getCharacterClass() + RESET);
		if (knowledge >= 10)
			System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Attack" + RESET + ": " + GREEN + enemy.getAttack() + RESET + "   " + ITALIC + "Defense" + RESET + ": " + GREEN + enemy.getDefense() + RESET);
		else
			System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Attack" + RESET + ": " + ITALIC + "????" + RESET + "   " + ITALIC + "Defense" + RESET + ": " + ITALIC + "????" + RESET);
		if (knowledge >= 20)
			System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Hit Points" + RESET + ": " + RED + enemy.getHitPoint() + "/" + enemy.getMaxHitPoint() + RESET);
		else
			System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Hit Points" + RESET + ": " + ITALIC + "????" + "/" + "????" + RESET);
		if (knowledge >= 35) {
			System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Bag contents:" + RESET);

			if (enemy.getArtefacts().isEmpty()) {
				System.out.println(DARK_GRAY + "┃" + RESET + "   " + RED + "Empty bag." + RESET);
			} else {
				for (Artefact item : enemy.getArtefacts()) {
					System.out.println(DARK_GRAY + "┃" + RESET + "   • " + item.getName());
				}
			}
		}
		else {
			System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Bag contents:" + RESET);

			if (enemy.getArtefacts().isEmpty()) {
				System.out.println(DARK_GRAY + "┃" + RESET + "   " + RED + "Empty bag." + RESET);
			} else {
				for (Artefact item : enemy.getArtefacts()) {
					String rarity = item.getRarity();
					String color = "";
					switch (rarity) {
						case COMMON:
							color = COMMON_COLOR;
							break;
						case RARE:
							color = BLUE;
							break;
						case EPIC:
							color = EPIC_COLOR;
							break;
						case LEGENDARY:
							color = LEGENDARY_COLOR;
							break;
					}
					System.out.println(DARK_GRAY + "┃" + RESET + "   • " + color + "????" + RESET);
				}
			}
		}

		System.out.println(DARK_GRAY + "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛" + RESET);
	}

	public String getUserInput() {
		return scanner.nextLine();
	}

	public void closeScanner() {
		this.scanner.close();
	}
}

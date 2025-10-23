package com.swingy.view;

import static com.swingy.utils.Constants.*;
import com.swingy.controller.Game;
import com.swingy.model.Artefact;
import com.swingy.model.Characters;

public class DisplayController {

	private static DisplayController instance;

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

	public void printSlow(String asciiArt) {
	for (String line : asciiArt.split("\n")) {
		System.out.println(line);
		try {
			if (D_V_M___E) {
				Thread.sleep(D_V_S___D_T_T);
			}
			else
				Thread.sleep(70);
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
				System.out.println(DARK_GRAY + "┃" + RESET + " " + ITALIC + "Hit Points" + RESET + ": " + RED + hero.getHitPoint() + RESET);
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
}

package com.swingy.controller;

import com.swingy.model.Characters;
import com.swingy.view.DisplayController;
import static com.swingy.utils.Constants.*;

import java.util.concurrent.ThreadLocalRandom;


public class FightLogic {

	private static DisplayController display = DisplayController.getInstance();
	
/* -------------------------------------------------- FIGHT METHOD -------------------------------------------------- */

	public static void fight(Characters enemy, Characters hero, Menu menu) {
		Integer tmp = hero.getKnowledge().getMap().get(enemy.getCharacterClass());
		String option = "";

		display.clearTerminal();
		
		do {
			display.clearTerminal();
			display.printNormal(FIGHT_TITLE);
			if (tmp == null)  {
				display.displaySelelectedHero(hero);
				display.displayCurrentEnemy(enemy, 0);
			}
			else {
				display.displaySelelectedHero(hero);
				display.displayCurrentEnemy(enemy, hero.getKnowledge().getMap().get(enemy.getCharacterClass()));
			}
			display.printNormal(FIGHT_MENU);
			option = display.getUserInput();
			switch (option) {
				/* -------- ATTACK -------- */
				case "1":
				int diceHero1 = ThreadLocalRandom.current().nextInt(1, 7);
				int diceHero2 = ThreadLocalRandom.current().nextInt(1, 7);
				int diceEnemy1 = ThreadLocalRandom.current().nextInt(1, 7);
				int diceEnemy2 = ThreadLocalRandom.current().nextInt(1, 7);

				int initH = (diceHero1 + diceHero2) + hero.getAttack();
				int initE = (diceEnemy1 + diceEnemy2) + enemy.getAttack();

				if (initH == initE) {
					display.printNormal("⚔️  Both fighters clash with equal strength  ⚔️  No one was hurt!");
					display.getUserInput();
					continue;
				}

				if (initH > initE) {
					int rawDamage = ThreadLocalRandom.current().nextInt(1, hero.getAttack() + 1);
					int damage = Math.max(1, rawDamage - enemy.getDefense() / 2);
					enemy.setHitPoint(-damage);
					display.printNormal("💥 " + hero.getName() +  " hits " + enemy.getCharacterClass() +  " for " + damage + " damage!");
				} else {
					int rawDamage = ThreadLocalRandom.current().nextInt(1, enemy.getAttack() + 1);
					int damage = Math.max(1, rawDamage - hero.getDefense() / 2);
					hero.setHitPoint(-damage);
					display.printNormal("🗡️ " + enemy.getCharacterClass() + " hits " + hero.getName() + " for " + damage + " damage!");
				}
				display.printNormal("\nPress Enter to continue...");
				display.getUserInput();
				break;

			case "2":
				/* -------- BLOCK -------- */
				int dmg = ThreadLocalRandom.current().nextInt(1, enemy.getAttack() + 1);
				int fullBlock = Math.max(1, dmg - hero.getDefense());
				if (fullBlock <= 0)
					fullBlock = 0;
				hero.setHitPoint(-fullBlock);
				display.printNormal("🛡️ The hero blocks it! Not today, villain! You took " + fullBlock + " damage!");
				display.printNormal("\nPress Enter to continue...");
				display.getUserInput();
				break;

			case "3":
				/* -------- RUN -------- */
				int luck = ThreadLocalRandom.current().nextInt(0, 2);
				if (luck == 0) {
					int rawDamage = ThreadLocalRandom.current().nextInt(1, enemy.getAttack() + 1);
					hero.setHitPoint(-rawDamage);
					display.printNormal("💨 The hero tries to escape... but fails!");
					display.printNormal("🗡️ " + enemy.getCharacterClass() + " hits " + hero.getName() + " for " + rawDamage + " damage!");
					display.printNormal("\nPress Enter to continue...");
					display.getUserInput();	
					break;
				}
				else {
					hero.getCoordinates().setXBack(hero.getCoordinates().getPrevX());
					hero.getCoordinates().setYBack(hero.getCoordinates().getPrevY());
					display.printNormal("🏃‍♂️ With lightning reflexes, the hero escapes into the shadows!");
					display.printNormal("\nPress Enter to continue...");
					display.getUserInput();
					return;
				}
			
				case "4":
				/* -------- INVENTORY -------- */
					menu.inventoryMenu();
					break;
			}

		} while ((enemy.getHitPoint() > 0 && hero.getHitPoint() > 0) || (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4")));

		if (hero.getHitPoint() <= 0) {
			// GAME OVER
			display.printNormal(RED_BOLD + "💀 GAME OVER" + RESET);
		} else {
			// WIN + ADD XP + ADD KNOLWEDGE + LOOT
			display.printNormal(GREEN_BOLD + "🏆 ENEMY DEFEATED!" + RESET);
			hero.addXP(enemy.getXp());
			hero.getKnowledge().addKnowledge(enemy);
			if (!enemy.getArtefacts().isEmpty()) {
				String choice = "";
				display.printNormal(LOOT);
				do {
					display.printNormal(LOOT_OPTION);
					choice = display.getUserInput();
				} while(!choice.equals("1") && !choice.equals("2"));
				if (choice.equals("1")) {
					hero.addArtefact(enemy.getArtefacts().get(0));
					enemy.removeArtefact(enemy.getArtefacts().get(0));
				}
			}
		}

		display.printNormal("\nPress Enter to continue...");
		display.getUserInput();
	}
}

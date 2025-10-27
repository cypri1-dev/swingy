package com.swingy.controller;

import com.swingy.model.Characters;
import com.swingy.view.DisplayController;

import static com.swingy.utils.Constants.*;

import java.util.concurrent.ThreadLocalRandom;

public class FightLogic {

	public static void fight(Characters enemy, Characters hero, Menu menu) {
		// DisplayInfos.printEnemy(enemy);
		Integer tmp = hero.getKnowledge().getMap().get(enemy.getCharacterClass());
		String option = "";

		DisplayController.getInstance().clearTerminal();
		
		do {
			DisplayController.getInstance().clearTerminal();
			DisplayController.getInstance().printSlow(FIGHT_TITLE);
			if (tmp == null)
				
				DisplayController.getInstance().displayCurrentEnemy(enemy, 0);
			else
				DisplayController.getInstance().displayCurrentEnemy(enemy, hero.getKnowledge().getMap().get(enemy.getCharacterClass()));
			DisplayController.getInstance().printNormal(FIGHT_MENU);
			option = DisplayController.getInstance().getUserInput();

			switch (option) {
				case "1":
					int diceHero1 = ThreadLocalRandom.current().nextInt(1, 7);
					int diceHero2 = ThreadLocalRandom.current().nextInt(1, 7);
					int diceEnemy1 = ThreadLocalRandom.current().nextInt(1, 7);
					int diceEnemy2 = ThreadLocalRandom.current().nextInt(1, 7);

					int initH = (diceHero1 + diceHero2) + hero.getAttack();
					int initE = (diceEnemy1 + diceEnemy2) + enemy.getAttack();

					if (initH == initE) {
						DisplayController.getInstance().printNormal(SAME_POWER);
						DisplayController.getInstance().getUserInput();
						continue;
					}

					if (initH > initE) {
						int rawDamage = ThreadLocalRandom.current().nextInt(1, hero.getAttack() + 1);
						int damage = Math.max(1, rawDamage - enemy.getDefense() / 2);
						enemy.setHitPoint(-damage);
						System.out.println("💥 " + hero.getName() +  " hits " + enemy.getCharacterClass() +  " for " + damage + " damage!");
					} else {
						int rawDamage = ThreadLocalRandom.current().nextInt(1, enemy.getAttack() + 1);
						int damage = Math.max(1, rawDamage - hero.getDefense() / 2);
						hero.setHitPoint(-damage);
						System.out.println("🗡️ " + enemy.getCharacterClass() + " hits " + hero.getName() + " for " + damage + " damage!");
					}

					System.out.println("❤️ HERO HP: " + hero.getHitPoint() + " | 💀 ENEMY HP: " + enemy.getHitPoint());
					DisplayController.getInstance().getUserInput();
					break;

				case "2":
					int dmg = ThreadLocalRandom.current().nextInt(1, enemy.getAttack() + 1);
					int fullBlock = Math.max(1, dmg - hero.getDefense());
					if (fullBlock <= 0)
						fullBlock = 0;
					hero.setHitPoint(-fullBlock);
					System.out.println("🛡️ The hero blocks it! Not today, villain! You took " + fullBlock + " damage!");
					DisplayController.getInstance().getUserInput();
					break;

				case "3":
					int luck = ThreadLocalRandom.current().nextInt(0, 2);
					if (luck == 0) {
						// escape FAIL
						System.out.println("💨 The hero tries to escape... but fails!");
						DisplayController.getInstance().getUserInput();	
						break;
					}
					else {
						hero.getCoordinates().setXBack(hero.getCoordinates().getPrevX());
						hero.getCoordinates().setYBack(hero.getCoordinates().getPrevY());
						System.out.println("🏃‍♂️ With lightning reflexes, the hero escapes into the shadows!");
						DisplayController.getInstance().getUserInput();
						// msg esacpe OK
						return;
					}
				
					case "4":
						menu.inventoryMenu();
						break;

			}

		} while ((enemy.getHitPoint() > 0 && hero.getHitPoint() > 0) || (!option.equals("1") && !option.equals("2") && !option.equals("3") && !option.equals("4")));

		if (hero.getHitPoint() <= 0) {
			System.out.println(RED_BOLD + "💀 GAME OVER" + RESET);
		} else {
			System.out.println(GREEN_BOLD + "🏆 ENEMY DEFEATED!" + RESET);
			hero.addXP(enemy.getXp());
			hero.getKnowledge().addKnowledge(enemy);
			int random = ThreadLocalRandom.current().nextInt(1, 101);
			if (random >= 75) {
				if (!enemy.getArtefacts().isEmpty()) {
					hero.addArtefact(enemy.getArtefacts().get(0));
					enemy.removeArtefact(enemy.getArtefacts().get(0));
				}
			}
		}

		System.out.println("\nPress Enter to continue...");
		DisplayController.getInstance().getUserInput();
	}
}

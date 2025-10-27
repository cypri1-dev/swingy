package com.swingy.controller;

import com.swingy.model.Characters;
import com.swingy.view.DisplayController;
import com.swingy.view.DisplayInfos;

import static com.swingy.utils.Constants.*;

import java.util.concurrent.ThreadLocalRandom;

public class FightLogic {

	public static void fight(Characters enemy, Characters hero) {
		// DisplayInfos.printEnemy(enemy);
		Integer tmp = hero.getKnowledge().getMap().get(enemy.getCharacterClass());

		DisplayController.getInstance().clearTerminal();
		DisplayController.getInstance().printSlow(FIGHT_TITLE);
		if (tmp == null)
			
			DisplayController.getInstance().displayCurrentEnemy(enemy, 0);
		else
			DisplayController.getInstance().displayCurrentEnemy(enemy, hero.getKnowledge().getMap().get(enemy.getCharacterClass()));

		do {
			int diceHero1 = ThreadLocalRandom.current().nextInt(1, 7);
			int diceHero2 = ThreadLocalRandom.current().nextInt(1, 7);
			int diceEnemy1 = ThreadLocalRandom.current().nextInt(1, 7);
			int diceEnemy2 = ThreadLocalRandom.current().nextInt(1, 7);

			int initH = (diceHero1 + diceHero2) + hero.getAttack();
			int initE = (diceEnemy1 + diceEnemy2) + enemy.getAttack();

			if (initH == initE)
				continue;

			if (initH > initE) {
				int rawDamage = ThreadLocalRandom.current().nextInt(1, hero.getAttack() + 1);
				int damage = Math.max(1, rawDamage - enemy.getDefense() / 2);
				enemy.setHitPoint(-damage);
				System.out.println("💥 Hero hits enemy for " + damage + " damage!");
			} else {
				int rawDamage = ThreadLocalRandom.current().nextInt(1, enemy.getAttack() + 1);
				int damage = Math.max(1, rawDamage - hero.getDefense() / 2);
				hero.setHitPoint(-damage);
				System.out.println("😵 Enemy hits hero for " + damage + " damage!");
			}

			System.out.println("❤️ HERO HP: " + hero.getHitPoint() + " | 💀 ENEMY HP: " + enemy.getHitPoint());
			DisplayController.getInstance().getUserInput();

		} while (enemy.getHitPoint() > 0 && hero.getHitPoint() > 0);

		if (hero.getHitPoint() <= 0) {
			System.out.println(RED_BOLD + "💀 GAME OVER" + RESET);
		} else {
			System.out.println(GREEN_BOLD + "🏆 ENEMY DEFEATED!" + RESET);
			hero.addXP(enemy.getXp());
			hero.getKnowledge().addKnowledge(enemy);
		}

		System.out.println("\nPress Enter to continue...");
		DisplayController.getInstance().getUserInput();
	}
}

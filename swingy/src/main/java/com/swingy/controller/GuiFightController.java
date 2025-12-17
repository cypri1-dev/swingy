package com.swingy.controller;

import java.util.concurrent.ThreadLocalRandom;

import com.swingy.model.Characters;
import com.swingy.model.Maps;

public class GuiFightController {
	
	private static Characters hero;
	private static Characters enemy;
	private static Maps map;

	public GuiFightController(Characters hero, Characters enemy, Maps map) {
		this.hero = hero;
		this.enemy = enemy;
		this.map = map;
	}

	public static String attackAction() {
		int diceHero1 = ThreadLocalRandom.current().nextInt(1, 7);
		int diceHero2 = ThreadLocalRandom.current().nextInt(1, 7);
		int diceEnemy1 = ThreadLocalRandom.current().nextInt(1, 7);
		int diceEnemy2 = ThreadLocalRandom.current().nextInt(1, 7);

		int initH = (diceHero1 + diceHero2) + hero.getAttack();
		int initE = (diceEnemy1 + diceEnemy2) + enemy.getAttack();

		if (initE == initH)
			return "Both fighters clash with equal strength! No one was hurt!";
		if (initH > initE) {
			int rawDamage = ThreadLocalRandom.current().nextInt(1, hero.getAttack() + 1);
			int damage = rawDamage - (enemy.getDefense() / 2);
			if (damage < 0)
				damage = 0;
			enemy.setHitPoint(-damage);
			if (enemy.getHitPoint() <= 0) {
				String[][] tmp = map.getMapTab();
				tmp[enemy.getCoordinates().getX()][enemy.getCoordinates().getY()] = "@";
				map.getListEnemies().remove(enemy);
				return "DEAD ENEMY";
			}
			return hero.getName() +  " hits " + enemy.getCharacterClass() +  " for " + damage + " damage!";
		}
		else {
			int rawDamage = ThreadLocalRandom.current().nextInt(1, enemy.getAttack() + 1);
			int damage = rawDamage - (hero.getDefense() / 2);
			if (damage < 0)
				damage = 0;
			hero.setHitPoint(-damage);
			if (hero.getHitPoint() <= 0)
				return "DEAD HERO";
			return enemy.getCharacterClass() + " hits " + hero.getName() + " for " + damage + " damage!";
		}

	}
}
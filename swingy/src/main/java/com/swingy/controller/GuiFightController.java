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

	public static String runAction() {
		int luck = ThreadLocalRandom.current().nextInt(0, 2);
		if (luck == 0) {
			int rawDamage = ThreadLocalRandom.current().nextInt(1, enemy.getAttack() + 1);
			hero.setHitPoint(-rawDamage);
			if (hero.getHitPoint() <= 0)
				return "DEAD HERO";
			return "💨 The hero tries to escape... but fails!\n🗡️ " + enemy.getCharacterClass() + " hits " + hero.getName() + " for " + rawDamage + " damage!";
		}
		else {
			map.getMapTab()[enemy.getCoordinates().getX()][enemy.getCoordinates().getY()] = "*";
			map.getListEnemies().remove(enemy);
			hero.getCoordinates().setXBack(hero.getCoordinates().getPrevX());
			hero.getCoordinates().setYBack(hero.getCoordinates().getPrevY());
			map.getMapTab()[hero.getCoordinates().getX()][hero.getCoordinates().getY()] = "\u001b[34m@\u001b[0m";
			return "ESCAPE";
		}
	}

	public static String blockAction() {
		int dmg = ThreadLocalRandom.current().nextInt(1, enemy.getAttack() + 1);
		int fullBlock = dmg - hero.getDefense();
		if (fullBlock <= 0)
			fullBlock = 0;
		hero.setHitPoint(-fullBlock);
		if (hero.getHitPoint() <= 0)
			return "DEAD ENEMY";
		return "🛡️ The hero blocks it! Not today, villain! You took " + fullBlock + " damage!";
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
				hero.addXP(enemy.getXp());
				hero.getKnowledge().addKnowledge(enemy);
				tmp[enemy.getCoordinates().getX()][enemy.getCoordinates().getY()] = "\u001b[34m@\u001b[0m";
				if (!enemy.getArtefacts().isEmpty())
					return "LOOT";
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
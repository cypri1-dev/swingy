package com.swingy.view;

import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.model.Maps;
import static com.swingy.utils.Constants.*;

public class DisplayInfos {
	public static void printHero(Characters hero) {
		System.out.println(DEBUG_BOLD + "--- HERO DATA ---" + RESET);
		System.out.println(ITALIC + "[type]: " + RESET + hero.getType());
		System.out.println(ITALIC + "[name]: " + RESET + hero.getName());
		System.out.println(ITALIC + "[characterClass]: " + RESET + hero.getCharacterClass());
		System.out.println(ITALIC + "[level]: " + RESET + hero.getLevel());
		System.out.println(ITALIC + "[xp]: " + RESET + hero.getXp());
		System.out.println(ITALIC + "[attack]: " + RESET + hero.getAttack());
		System.out.println(ITALIC + "[defense]: " + RESET + hero.getDefense());
		System.out.println(ITALIC + "[hitPoint]: " + RESET + hero.getHitPoint());
		System.out.println("------- BAG CONTENT -------");
		// System.out.println(ITALIC + "[bag]: " + RESET + hero.getArtefacts());
		for (Artefact item : hero.getArtefacts()) {
			if (item.getIsEquipped())
				System.out.println(item.getName() + "(E)");
			else
				System.out.println(item.getName());
		}
		System.out.println("------- ----------- -------");
		System.out.println(ITALIC + "[x]: " + RESET + hero.getCoordinates().getX());
		System.out.println(ITALIC + "[y]: " + RESET + hero.getCoordinates().getY());
		System.out.println(ITALIC + "[prevX]: " + RESET + hero.getCoordinates().getPrevX());
		System.out.println(ITALIC + "[prevY]: " + RESET + hero.getCoordinates().getPrevY());
		System.out.println(DEBUG_BOLD + "--- END HERO DATA ---" + RESET);
	}

	public static void printEnemy(Characters enemy) {
		System.out.println(DEBUG_BOLD + "--- ENEMY DATA ---" + RESET);
		System.out.println(ITALIC + "[type]: " + RESET + enemy.getType());
		System.out.println(ITALIC + "[name]: " + RESET + enemy.getName());
		System.out.println(ITALIC + "[characterClass]: " + RESET + enemy.getCharacterClass());
		System.out.println(ITALIC + "[level]: " + RESET + enemy.getLevel());
		System.out.println(ITALIC + "[xp]: " + RESET + enemy.getXp());
		System.out.println(ITALIC + "[attack]: " + RESET + enemy.getAttack());
		System.out.println(ITALIC + "[defense]: " + RESET + enemy.getDefense());
		System.out.println(ITALIC + "[hitPoint]: " + RESET + enemy.getHitPoint());
		// System.out.println(ITALIC + "[bag]: " + RESET + enemy.getArtefacts());
		System.out.println(ITALIC + "[x]: " + RESET + enemy.getCoordinates().getX());
		System.out.println(ITALIC + "[y]: " + RESET + enemy.getCoordinates().getY());
		System.out.println(ITALIC + "[prevX]: " + RESET + enemy.getCoordinates().getPrevX());
		System.out.println(ITALIC + "[prevY]: " + RESET + enemy.getCoordinates().getPrevY());
		System.out.println(DEBUG_BOLD + "--- END ENEMY DATA ---" + RESET);
	}

	public static void printArtefact(Artefact item) {
		System.out.println(DEBUG_BOLD + "--- ARTEFACT DATA ---" + RESET);
		System.out.println(ITALIC + "[type]: " + RESET + item.getType());
		System.out.println(ITALIC + "[name]: " + RESET + item.getName());
		System.out.println(ITALIC + "[bonus]: " + RESET + item.getBonus());
		System.out.println(ITALIC + "[isEquipped]: " + RESET + item.getIsEquipped());
		System.out.println(DEBUG_BOLD + "--- END ARTEFACT DATA ---" + RESET);
	}

	public static void printMap(Maps map) {
		for (int i = 0; i < map.getSize(); i++) {
			for (int j = 0; j < map.getSize(); j++) {
				System.out.print(map.map[i][j]);
			}
			System.out.println();
		}
	}

	public static void printEnemyInMap(Maps map) {
		for (Characters elem : map.getListEnemies()) {
			printEnemy(elem);
		}
	}

}
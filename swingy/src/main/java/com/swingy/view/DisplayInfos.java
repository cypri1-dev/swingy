package com.swingy.view;

import com.swingy.model.Characters;
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
		System.out.println(ITALIC + "[bag]: " + RESET + hero.getArtefacts());
		System.out.println(ITALIC + "[x]: " + RESET + hero.getCoordinates().getX());
		System.out.println(ITALIC + "[y]: " + RESET + hero.getCoordinates().getY());
		System.out.println(ITALIC + "[prevX]: " + RESET + hero.getCoordinates().getPrevX());
		System.out.println(ITALIC + "[prevY]: " + RESET + hero.getCoordinates().getPrevY());
		System.out.println(DEBUG_BOLD + "--- END HERO DATA ---" + RESET);
	}

	public static void printEnemy(Characters hero) {
		System.out.println(DEBUG_BOLD + "--- ENEMY DATA ---" + RESET);
		System.out.println(ITALIC + "[type]: " + RESET + hero.getType());
		System.out.println(ITALIC + "[name]: " + RESET + hero.getName());
		System.out.println(ITALIC + "[characterClass]: " + RESET + hero.getCharacterClass());
		System.out.println(ITALIC + "[level]: " + RESET + hero.getLevel());
		System.out.println(ITALIC + "[xp]: " + RESET + hero.getXp());
		System.out.println(ITALIC + "[attack]: " + RESET + hero.getAttack());
		System.out.println(ITALIC + "[defense]: " + RESET + hero.getDefense());
		System.out.println(ITALIC + "[hitPoint]: " + RESET + hero.getHitPoint());
		System.out.println(ITALIC + "[bag]: " + RESET + hero.getArtefacts());
		// System.out.println(ITALIC + "[x]: " + RESET + hero.getCoordinates().getX());
		// System.out.println(ITALIC + "[y]: " + RESET + hero.getCoordinates().getY());
		// System.out.println(ITALIC + "[prevX]: " + RESET + hero.getCoordinates().getPrevX());
		// System.out.println(ITALIC + "[prevY]: " + RESET + hero.getCoordinates().getPrevY());
		System.out.println(DEBUG_BOLD + "--- END ENEMY DATA ---" + RESET);
	}
}
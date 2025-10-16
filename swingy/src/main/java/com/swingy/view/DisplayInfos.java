package com.swingy.view;

import com.swingy.model.Artefact;
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
		System.out.println("------- BAG CONTENT -------");
		// System.out.println(ITALIC + "[bag]: " + RESET + hero.getArtefacts());
		for (Artefact item : hero.getArtefacts()) {
			System.out.println(item.getName());
		}
		System.out.println("------- ----------- -------");
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
		// System.out.println(ITALIC + "[bag]: " + RESET + hero.getArtefacts());
		// System.out.println(ITALIC + "[x]: " + RESET + hero.getCoordinates().getX());
		// System.out.println(ITALIC + "[y]: " + RESET + hero.getCoordinates().getY());
		// System.out.println(ITALIC + "[prevX]: " + RESET + hero.getCoordinates().getPrevX());
		// System.out.println(ITALIC + "[prevY]: " + RESET + hero.getCoordinates().getPrevY());
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
}
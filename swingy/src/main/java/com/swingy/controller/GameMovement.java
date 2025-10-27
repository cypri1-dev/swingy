package com.swingy.controller;

import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.model.Maps;
import com.swingy.view.DisplayController;

import static com.swingy.utils.Constants.*;

public class GameMovement {

	/* -------------------------------------------------- CHECK FIGHT METHOD -------------------------------------------------- */

	private void checkFight(Characters hero, Maps map, Menu menu) {

		if (!map.map[hero.getCoordinates().getPrevX()][hero.getCoordinates().getPrevY()].contains("!")) {
			map.map[hero.getCoordinates().getPrevX()][hero.getCoordinates().getPrevY()] = BLUE + "*" + RESET;
		}

		for (Characters enemy : map.getListEnemies()) {
			if (hero.getCoordinates().getX() == enemy.getCoordinates().getX() && hero.getCoordinates().getY() == enemy.getCoordinates().getY()) {

				// fight logic !
				// System.out.println(enemy.getCharacterClass() + " | " + enemy.getCoordinates().getX() + ", " + enemy.getCoordinates().getY());
				FightLogic.fight(enemy, hero, menu);

				map.map[hero.getCoordinates().getX()][hero.getCoordinates().getY()] = BLUE + "!" + RESET;
				// TEST WIN 
				map.getListEnemies().remove(enemy);
				return;
			}
		}
		if (map.map[hero.getCoordinates().getX()][hero.getCoordinates().getY()].contains("!"))
			;
		else
			map.map[hero.getCoordinates().getX()][hero.getCoordinates().getY()] = SYMBOL_MAIN_HERO;
	}

	/* -------------------------------------------------- CHECK CONSOMMABLE METHOD -------------------------------------------------- */

	private void checkConsommable(Characters hero, Maps map) {

		Artefact tmp = null;

		for (Artefact healingPotion : map.getListConsommable()) {
			if (hero.getCoordinates().getX() == healingPotion.getCoordinates().getX() && hero.getCoordinates().getY() == healingPotion.getCoordinates().getY()) {
				
				hero.addArtefact(healingPotion);
				DisplayController.getInstance().printSlow(HP_POTION);
				tmp = healingPotion;
				DisplayController.getInstance().getUserInput();
			}
		}
		if (tmp != null)
			map.getListConsommable().remove(tmp);
	}

	/* -------------------------------------------------- CHECK END LEVEL METHOD -------------------------------------------------- */

	private void checkEndLevel(Characters hero, Maps map) {
		if (hero.getCoordinates().getX() == 0 || hero.getCoordinates().getX() == map.getSize() - 1 || hero.getCoordinates().getY() == 0 || hero.getCoordinates().getY() == map.getSize() - 1) {
			// System.out.println(DEBUG_BOLD + "LVL COMPLETED!" + RESET);
			map.setLevelCompleted(true);
		}
	}

	/* -------------------------------------------------- MOVING METHOD -------------------------------------------------- */

	public void moveNorth(Characters hero, Maps map, Menu menu) {

		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());

		hero.getCoordinates().setX(-1);

		checkFight(hero, map, menu);
		checkConsommable(hero, map);
		checkEndLevel(hero, map);
	}


	public void moveEast(Characters hero, Maps map, Menu menu) {
		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());

		hero.getCoordinates().setY(+1);
		
		checkFight(hero, map, menu);
		checkConsommable(hero, map);
		checkEndLevel(hero, map);
	}

	public void moveSouth(Characters hero, Maps map, Menu menu) {
		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());
		
		hero.getCoordinates().setX(+1);
		
		checkFight(hero, map, menu);
		checkConsommable(hero, map);
		checkEndLevel(hero, map);
	}

	public void moveWest(Characters hero, Maps map, Menu menu) {
		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());
		
		hero.getCoordinates().setY(-1);
		
		checkFight(hero, map, menu);
		checkConsommable(hero, map);
		checkEndLevel(hero, map);
	}

}
package com.swingy.controller;

import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.model.Maps;
import com.swingy.view.DisplayController;

import java.util.Iterator;

import static com.swingy.utils.Constants.*;

public class GameMovement {

	/* -------------------------------------------------- CHECK FIGHT METHOD -------------------------------------------------- */

	private void checkFight(Characters hero, Maps map, Menu menu, boolean gui) {

		if (!map.map[hero.getCoordinates().getPrevX()][hero.getCoordinates().getPrevY()].contains("!")) {
			map.map[hero.getCoordinates().getPrevX()][hero.getCoordinates().getPrevY()] = BLUE + "*" + RESET;
		}

		Iterator<Characters> iterator = map.getListEnemies().iterator();
		while (iterator.hasNext()) {
			Characters enemy = iterator.next();
			if (hero.getCoordinates().getX() == enemy.getCoordinates().getX() && hero.getCoordinates().getY() == enemy.getCoordinates().getY()) {
				
				if (gui) {
					return;
				}
				else
					FightLogic.fight(enemy, hero, menu);
				iterator.remove();
				map.map[hero.getCoordinates().getX()][hero.getCoordinates().getY()] = SYMBOL_MAIN_HERO;
				return;
			}
		}

		if (!map.map[hero.getCoordinates().getX()][hero.getCoordinates().getY()].contains("!")) {
			map.map[hero.getCoordinates().getX()][hero.getCoordinates().getY()] = SYMBOL_MAIN_HERO;
		}
	}

	/* -------------------------------------------------- CHECK CONSOMMABLE METHOD -------------------------------------------------- */

	public void checkConsommable(Characters hero, Maps map, boolean gui) {
		Artefact toRemove = null;
		DisplayController display = DisplayController.getInstance();
		for (Artefact healingPotion : map.getListConsommable()) {
			if (hero.getCoordinates().getX() == healingPotion.getCoordinates().getX() && hero.getCoordinates().getY() == healingPotion.getCoordinates().getY()) {
				hero.addArtefact(healingPotion);
				if (gui)
					return;
				display.printSlow(HP_POTION);
				display.getUserInput();
				toRemove = healingPotion;
				break;
			}
		}
		if (toRemove != null) {
			map.getListConsommable().remove(toRemove);
		}
	}

	/* -------------------------------------------------- CHECK END LEVEL METHOD -------------------------------------------------- */

	public void checkEndLevel(Characters hero, Maps map) {
		if (hero.getCoordinates().getX() == 0 || hero.getCoordinates().getX() == map.getSize() - 1 || hero.getCoordinates().getY() == 0 || hero.getCoordinates().getY() == map.getSize() - 1) {
			map.setLevelCompleted(true);
		}
	}

	/* -------------------------------------------------- MOVING METHOD -------------------------------------------------- */

	public void moveNorth(Characters hero, Maps map, Menu menu, boolean gui) {
		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());

		if (hero.getCoordinates().getX() > 0) {
			hero.getCoordinates().setX(-1); // x += -1
		}

		checkFight(hero, map, menu, gui);
		checkConsommable(hero, map, gui);
		checkEndLevel(hero, map);
	}

	public void moveEast(Characters hero, Maps map, Menu menu, boolean gui) {
		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());

		if (hero.getCoordinates().getY() < map.getSize() - 1) {
			hero.getCoordinates().setY(1); // y += 1
		}

		checkFight(hero, map, menu, gui);
		checkConsommable(hero, map, gui);
		checkEndLevel(hero, map);
	}

	public void moveSouth(Characters hero, Maps map, Menu menu, boolean gui) {
		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());

		if (hero.getCoordinates().getX() < map.getSize() - 1) {
			hero.getCoordinates().setX(1); // x += 1
		}

		checkFight(hero, map, menu, gui);
		checkConsommable(hero, map, gui);
		checkEndLevel(hero, map);
	}

	public void moveWest(Characters hero, Maps map, Menu menu, boolean gui) {
		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());

		if (hero.getCoordinates().getY() > 0) {
			hero.getCoordinates().setY(-1); // y += -1
		}

		checkFight(hero, map, menu, gui);
		checkConsommable(hero, map, gui);
		checkEndLevel(hero, map);
	}

}

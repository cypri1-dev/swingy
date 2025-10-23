package com.swingy.controller;

import com.swingy.model.Characters;
import com.swingy.model.Map;
import static com.swingy.utils.Constants.*;

public class GameMovement {

	private void checkFight(Characters hero, Map map) {

		if (!map.map[hero.getCoordinates().getPrevX()][hero.getCoordinates().getPrevY()].contains("!")) {
			map.map[hero.getCoordinates().getPrevX()][hero.getCoordinates().getPrevY()] = BLUE + "*" + RESET;
		}

		for (Characters enemy : map.getListEnemies()) {
			if (hero.getCoordinates().getX() == enemy.getCoordinates().getX() && hero.getCoordinates().getY() == enemy.getCoordinates().getY()) {

				System.out.println(RED_BOLD + "FIGHT!" + RESET);
				System.out.println(enemy.getCharacterClass() + " | " + enemy.getCoordinates().getX() + ", " + enemy.getCoordinates().getY());

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

	private void checkEndLevel(Characters hero, Map map) {
		if (hero.getCoordinates().getX() == 0 || hero.getCoordinates().getX() == map.getSize() - 1 || hero.getCoordinates().getY() == 0 || hero.getCoordinates().getY() == map.getSize() - 1) {
			// System.out.println(DEBUG_BOLD + "LVL COMPLETED!" + RESET);
			map.setLevelCompleted(true);
		}
	}


	public void moveNorth(Characters hero, Map map) {

		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());

		hero.getCoordinates().setX(-1);

		checkFight(hero, map);
		checkEndLevel(hero, map);
	}


	public void moveEast(Characters hero, Map map) {
		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());

		hero.getCoordinates().setY(+1);
		
		checkFight(hero, map);
		checkEndLevel(hero, map);
	}

	public void moveSouth(Characters hero, Map map) {
		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());
		
		hero.getCoordinates().setX(+1);
		
		checkFight(hero, map);
		checkEndLevel(hero, map);
	}

	public void moveWest(Characters hero, Map map) {
		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());
		
		hero.getCoordinates().setY(-1);
		
		checkFight(hero, map);
		checkEndLevel(hero, map);
	}

}
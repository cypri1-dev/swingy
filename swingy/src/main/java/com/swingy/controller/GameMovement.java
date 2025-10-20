package com.swingy.controller;

import com.swingy.model.Characters;
import com.swingy.model.Map;
import static com.swingy.utils.Constants.*;;

public class GameMovement {
	private void checkEndLevel(Characters hero, Map map) {
		if (hero.getCoordinates().getX() == 0 || hero.getCoordinates().getPrevX() == map.getSize() - 1 || hero.getCoordinates().getPrevY() == 0 || hero.getCoordinates().getY() == map.getSize() - 1)
			System.out.println(DEBUG_BOLD + "LVL COMPLETED!" + RESET);
	}

	public void moveNorth(Characters hero, Map map) {
		hero.getCoordinates().setPrevX(hero.getCoordinates().getX());
		hero.getCoordinates().setPrevY(hero.getCoordinates().getY());
		map.map[hero.getCoordinates().getX()][hero.getCoordinates().getY()] = "*";
		hero.getCoordinates().setX(-1);
		map.map[hero.getCoordinates().getX()][hero.getCoordinates().getY()] = SYMBOL_MAIN_HERO;
		checkEndLevel(hero, map);
	}
	public void moveEast(Characters hero) {}
	public void moveSouth(Characters hero) {}
	public void moveWest(Characters hero) {}

}
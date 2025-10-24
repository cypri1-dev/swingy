package com.swingy.controller;

import com.swingy.model.Characters;
import com.swingy.model.Map;
import com.swingy.model.MapFactory;
import com.swingy.view.DisplayController;

import static com.swingy.utils.Constants.ENTER_BACK_GAME;
import static com.swingy.utils.Constants.GAME_OVER;
import static com.swingy.utils.Constants.RULES;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Characters> avaibleHeros;
	private Characters selectedHero;
	private Menu menu;
	private Map actualMap;
	private List<String> herosName;

	/* -------------------------------------------------- GAME CONSTRUCTOR -------------------------------------------------- */

	public Game() {
		this.avaibleHeros = new ArrayList<Characters>();
		this.menu = new Menu(this);
		this.actualMap = null;
		this.herosName = new ArrayList<String>();

	}

	/* -------------------------------------------------- GETTERS | SETTERS -------------------------------------------------- */

	public Menu getMenu() {return this.menu;}
	public Map getMap() {return this.actualMap;}
	public List<String> getHeroesNameList() {return this.herosName;}
	public Characters getMainHero() {return this.selectedHero;}
	public void setSelectedHero(Characters hero) {this.selectedHero = hero;}
	public void setActualMap(Map map) {this.actualMap = map;}
	public List<Characters> getListAvaible() {return this.avaibleHeros;}

	/* -------------------------------------------------- GAME CONTROLLER -------------------------------------------------- */

	public void placeHero(Characters hero) {
		hero.getCoordinates().setStart((hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2));
		setSelectedHero(hero);
		setActualMap(MapFactory.getInstance().newMap(hero));
	}

	public void runArenaLoop() {
		DisplayController display = DisplayController.getInstance();
		boolean running = true;

		while (running && !this.getMap().getLevelCompleted()) {
			if (this.selectedHero.getHitPoint() <= 0) {
				// DisplayController.getInstance().printSlow(GAME_OVER);
				this.herosName.remove(this.selectedHero.getName());
				this.avaibleHeros.remove(selectedHero);
				break;
			}
			System.out.println(RULES);

			String input = display.getUserInput().trim().toUpperCase();

			switch (input) {
				case "W" -> moveHero('A'); // 'A' = haut
				case "S" -> moveHero('B'); // 'B' = bas
				case "D" -> moveHero('C'); // 'C' = droite
				case "A" -> moveHero('D'); // 'D' = gauche
				case "I" -> {
					display.clearTerminal();
					display.displaySelelectedHero(getMainHero());
					display.printSlow(ENTER_BACK_GAME);
					display.getUserInput();
				}
				case "X" -> running = false;
				case "0" -> this.menu.d_vOption();
				default -> display.printSlow("Invalid input!\n");
			}

			display.clearTerminal();
			display.displayMap(this);
		}
	}

	public void moveHero(char arrow) {
		switch (arrow) {
			case 'A' -> getMainHero().getMovement().moveNorth(getMainHero(), getMap());
			case 'B' -> getMainHero().getMovement().moveSouth(getMainHero(), getMap());
			case 'C' -> getMainHero().getMovement().moveEast(getMainHero(), getMap());
			case 'D' -> getMainHero().getMovement().moveWest(getMainHero(), getMap());
			default -> {}
		}
	}

	public boolean heroExists(String name) {
		return this.herosName.contains(name);
	}

	public void registerHeroName(String name) {
		this.herosName.add(name);
	}
}
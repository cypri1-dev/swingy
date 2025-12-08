package com.swingy.controller;

import com.swingy.model.Characters;
import com.swingy.model.Maps;
import com.swingy.model.MapFactory;
import com.swingy.view.DisplayController;

import static com.swingy.utils.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Characters> avaibleHeros;
	private Characters selectedHero;
	private Menu menu;
	private Maps actualMap;  
	private List<String> herosName;

	/* -------------------------------------------------- GAME CONSTRUCTOR -------------------------------------------------- */

	public Game() {
		this.avaibleHeros = new ArrayList<Characters>();
		this.menu = new Menu(this);
		this.actualMap = null;
		this.herosName = new ArrayList<String>();
		this.selectedHero = null;
	}

	/* -------------------------------------------------- GETTERS | SETTERS -------------------------------------------------- */

	public Menu getMenu() {return this.menu;}
	public Maps getMap() {return this.actualMap;}
	public List<String> getHeroesNameList() {return this.herosName;}
	public Characters getMainHero() {return this.selectedHero;}
	public List<Characters> getListAvaible() {return this.avaibleHeros;}

	public void setSelectedHero(Characters hero) {this.selectedHero = hero;}
	public void setActualMap(Maps map) {this.actualMap = map;}

	/* -------------------------------------------------- GAME CONTROLLER -------------------------------------------------- */

	public void placeHero(Characters hero) {
		hero.getCoordinates().setStart((hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2));
		setSelectedHero(hero);
		setActualMap(MapFactory.getInstance().newMap(hero));
	}

	public void runArenaLoop(Menu menu) {
		DisplayController display = DisplayController.getInstance();
		boolean running = true;

		while (running && !this.getMap().getLevelCompleted()) {
			if (this.selectedHero.getHitPoint() <= 0) {
				this.herosName.remove(this.selectedHero.getName());
				this.avaibleHeros.remove(selectedHero);
				break;
			}
			display.printNormal(RULES);

			String input = display.getUserInput().trim().toUpperCase();

			switch (input) {
				case "W" -> moveHero('A', menu);
				case "S" -> moveHero('B', menu);
				case "D" -> moveHero('C', menu);
				case "A" -> moveHero('D', menu);
				case "I" -> {
					this.menu.inventoryMenu();
				}
				case "X" -> running = false;
				case "0" -> this.menu.d_vOption();
				default -> display.printSlow("Invalid input!\n");
			}

			display.clearTerminal();
			display.displayMap(this);
		}
	}

	public void moveHero(char arrow, Menu menu) {
		switch (arrow) {
			case 'A' -> getMainHero().getMovement().moveNorth(getMainHero(), getMap(), menu, false);
			case 'B' -> getMainHero().getMovement().moveSouth(getMainHero(), getMap(), menu, false);
			case 'C' -> getMainHero().getMovement().moveEast(getMainHero(), getMap(), menu, false);
			case 'D' -> getMainHero().getMovement().moveWest(getMainHero(), getMap(), menu, false);
			default -> {}
		}
	}

	public boolean heroExists(String name) {
		return this.herosName.contains(name);
	}

	public void registerHeroName(String name) {
		this.herosName.add(name);
	}

	public void healHero(int amount) {
		int maxHp = this.selectedHero.getMaxHitPoint();
		
		int currentHP = this.selectedHero.getHitPoint() + amount;
		if (currentHP > maxHp)
			currentHP = maxHp;
		this.selectedHero.setHealHp(currentHP);
	}
}
package com.swingy.controller;

import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.model.Maps;
import com.swingy.view.GuiCustomPage;
import com.swingy.view.GuiEndLevelPage;
import com.swingy.view.GuiGamePage;
import com.swingy.view.GuiMapTab;
import com.swingy.view.GuiPotionPage;
import com.swingy.view.GuiFightPage;
import com.swingy.view.GuiGameOverPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Map;

public class GuiInputController extends GuiCustomPage {

	private GameMovement movement;
	private Characters hero;
	private Maps map;
	private Menu menu;
	private static JPanel grid;
	private static Game rpg;
	private static Map<String, ImageIcon> listToken;
	private static Icon icon;
	private static JPanel baseInventory;

	/************************************************************************ CONSTRUCTOR ************************************************************************/

	public GuiInputController(JComponent panel, GameMovement movement, Characters hero, Maps map, Menu menu, JPanel grid, Game rpg, Map<String, ImageIcon> listToken, Icon icon, JPanel baseInventory) {

		this.movement = movement;
		this.hero = hero;
		this.map = map;
		this.menu = menu;
		this.grid = grid;
		this.rpg = rpg;
		this.listToken = listToken;
		this.icon = icon;
		this.baseInventory = baseInventory;
		
		bind(panel, "UP", () -> {
			if (map.getLevelCompleted() || GuiCustomPage.getShowingPagePotion() || GuiCustomPage.getShowingPageFight())
				return;
			if (!canMove(hero.getCoordinates().getX() - 1, hero.getCoordinates().getY()))
				return;
			movement.moveWest(hero, map, menu, true);
			update(panel);
		});
		
		bind(panel, "DOWN", () -> {
			if (map.getLevelCompleted() || GuiCustomPage.getShowingPagePotion() || GuiCustomPage.getShowingPageFight())
				return;
			if (!canMove(hero.getCoordinates().getX() + 1, hero.getCoordinates().getY()))
				return;
			movement.moveEast(hero, map, menu, true);
			update(panel);
		});
		
		bind(panel, "LEFT", () -> {
			if (map.getLevelCompleted() || GuiCustomPage.getShowingPagePotion() || GuiCustomPage.getShowingPageFight())
				return;
			if (!canMove(hero.getCoordinates().getX(), hero.getCoordinates().getY() - 1))
				return;
			movement.moveNorth(hero, map, menu, true);
			update(panel);
		});
		
		bind(panel, "RIGHT", () -> {
			if (map.getLevelCompleted() || GuiCustomPage.getShowingPagePotion() || GuiCustomPage.getShowingPageFight())
				return;
			if (!canMove(hero.getCoordinates().getX(), hero.getCoordinates().getY() + 1))
				return;
			movement.moveSouth(hero, map, menu, true);
			update(panel);
		});
	}
	
	/************************************************************************ BIND KEYS METHOD ************************************************************************/

	private void bind(JComponent comp, String key, Runnable action) {
		comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), key);
		comp.getActionMap().put(key, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				action.run();
			}
		});
	}
	
	/************************************************************************ MOVEMENTS ALLOW METHOD ************************************************************************/

	private boolean canMove(int x, int y) {
		int size = map.getSize();
		return !(x < 0 || y < 0 || x >= size || y >= size);
	}

	/************************************************************************ UPDATE METHOD - CHECK FIGHT - POTION - GAME OVER -WIN ************************************************************************/

	private void update(JComponent panel) {
		/* --------------------- FIGHT --------------------- */
		for (Characters enemy : map.getListEnemies()) {
			if (hero.getCoordinates().getX() == enemy.getCoordinates().getX() && hero.getCoordinates().getY() == enemy.getCoordinates().getY()) {
				GuiFightPage.showFightPage(panel, enemy, rpg);
				return;
			}
		}

		/* -------------------- POTION --------------------- */
		for (Artefact healingPotion : map.getListConsommable()) {
			if (hero.getCoordinates().getX() == healingPotion.getCoordinates().getX() && hero.getCoordinates().getY() == healingPotion.getCoordinates().getY()) {
				map.getListConsommable().remove(healingPotion);
				GuiGamePage.refreshInventory(rpg, baseInventory);
				GuiPotionPage.showPotionPage(panel, healingPotion, listToken, icon, grid, baseInventory, rpg);
				return;
			}
		}

		/* ------------------- GAME OVER ------------------- */
		if (hero.getHitPoint() <= 0) {
			rpg.getHeroesNameList().remove(hero.getName());
			rpg.getListAvaible().remove(hero);
			GuiGameOverPage.showGameOverPage(panel, listToken, map, rpg);
			return;
		}

		/* ---------------- LEVEL COMPLETED ---------------- */
		if (map.getLevelCompleted()) {
			GuiEndLevelPage.showLevelCompletePage(panel, hero, rpg);
			map.setLevelCompleted(true);
			return;
		}

		/* -------------------- UPDATE --------------------- */
		GuiMapTab.updateMap(rpg, listToken, grid);
	}
}

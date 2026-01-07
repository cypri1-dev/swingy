package com.swingy.controller;

import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.model.Maps;
import com.swingy.view.GuiCustomPage;
import com.swingy.view.GuiEndLevelPage;
import com.swingy.view.GuiGamePage;
import com.swingy.view.GuiMapTab;
import com.swingy.view.GuiPotionPage;
import com.swingy.view.components.RoundedImageButton;
import com.swingy.view.GuiFightPage;
import com.swingy.view.GuiGameOverPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Map;

public class GuiInputController {
	
	private RoundedImageButton btn;
	private JPanel bottom;
	private Characters hero;
	private Maps map;
	private JPanel baseMap;
	private JPanel grid;
	private Game rpg;
	private Map<String, ImageIcon> listToken;
	private Icon icon;
	private JPanel baseInventory;
	private boolean inFight = false;

	/************************************************************************ CONSTRUCTOR ************************************************************************/

	public GuiInputController(RoundedImageButton btn, JComponent baseMap, GameMovement movement, Characters hero, Maps map, Menu menu, JPanel grid, Game rpg, Map<String, ImageIcon> listToken, Icon icon, JPanel baseInventory, JPanel bottom) {

		this.btn = btn;
		this.bottom = bottom;
		this.baseMap = (JPanel) baseMap;
		this.hero = hero;	
		this.map = map;
		this.grid = grid;
		this.rpg = rpg;
		this.listToken = listToken;
		this.icon = icon;
		this.baseInventory = baseInventory;

		bind(baseMap, "LEFT", () -> {
			if (map.getLevelCompleted() || GuiCustomPage.getShowingPagePotion() || GuiCustomPage.getShowingPageFight())
				return;
			if (!canMove(hero.getCoordinates().getX() - 1, hero.getCoordinates().getY()))
				return;
			movement.moveWest(hero, map, menu, true);
			update();
		});

		bind(baseMap, "RIGHT", () -> {
			if (map.getLevelCompleted() || GuiCustomPage.getShowingPagePotion() || GuiCustomPage.getShowingPageFight())
				return;
			if (!canMove(hero.getCoordinates().getX() + 1, hero.getCoordinates().getY()))
				return;
			movement.moveEast(hero, map, menu, true);
			update();
		});

		bind(baseMap, "UP", () -> {
			if (map.getLevelCompleted() || GuiCustomPage.getShowingPagePotion() || GuiCustomPage.getShowingPageFight())
				return;
			if (!canMove(hero.getCoordinates().getX(), hero.getCoordinates().getY() - 1))
				return;
			movement.moveNorth(hero, map, menu, true);
			update();
		});

		bind(baseMap, "DOWN", () -> {
			if (map.getLevelCompleted() || GuiCustomPage.getShowingPagePotion() || GuiCustomPage.getShowingPageFight())
				return;
			if (!canMove(hero.getCoordinates().getX(), hero.getCoordinates().getY() + 1))
				return;
			movement.moveSouth(hero, map, menu, true);
			update();
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

	private void update() {
		/* --------------------- FIGHT --------------------- */
		boolean fightFound = false;
		for (Characters enemy : map.getListEnemies()) {
			if (hero.getCoordinates().getX() == enemy.getCoordinates().getX() && hero.getCoordinates().getY() == enemy.getCoordinates().getY()) {
				fightFound = true;

				if (!inFight) {
					btn.setVisible(false);
					bottom.revalidate();
					bottom.repaint();

					inFight = true;
				}

				GuiFightPage.showFightPage(baseMap, enemy, icon, rpg, listToken, grid, baseInventory, btn, bottom);
				break;
			}
		}

		if (!fightFound && inFight) {
			btn.setVisible(true);
			bottom.revalidate();
			bottom.repaint();
			inFight = false;
		}

		if (!fightFound) {
			/* -------------------- POTION --------------------- */
			for (Artefact healingPotion : map.getListConsommable()) {
				if (hero.getCoordinates().getX() == healingPotion.getCoordinates().getX() && hero.getCoordinates().getY() == healingPotion.getCoordinates().getY()) {
					GuiPotionPage.showPotionPage(baseMap, healingPotion, listToken, icon, grid, baseInventory, rpg);
					map.getListConsommable().remove(healingPotion);
					GuiGamePage.refreshInventory(rpg, baseInventory, icon);
					return;
				}
			}

			/* ------------------- GAME OVER ------------------- */
			if (hero.getHitPoint() <= 0) {
				rpg.getHeroesNameList().remove(hero.getName());
				rpg.getListAvaible().remove(hero);
				GuiGameOverPage.showGameOverPage(baseMap, listToken, map, rpg);
				return;
			}

			/* ---------------- LEVEL COMPLETED ---------------- */
			if (map.getLevelCompleted()) {
				btn.setVisible(true);
				bottom.revalidate();
				bottom.repaint();
				GuiEndLevelPage.showLevelCompletePage(baseMap, hero, rpg);
				map.setLevelCompleted(true);
				return;
			}

			/* -------------------- UPDATE --------------------- */
			GuiMapTab.updateMap(rpg, listToken, grid);
		}
	}
}

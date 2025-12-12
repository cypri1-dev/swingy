package com.swingy.controller;

import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.model.Maps;
import com.swingy.view.GuiCustomPage;
import com.swingy.view.GuiGamePage;
import com.swingy.view.GuiHeroManagerPage;
import com.swingy.view.GuiMapTab;
import com.swingy.view.GuiPotionPage;
import com.swingy.view.GuiPlayPage;
import com.swingy.view.GuiFightPage;
import com.swingy.view.components.RoundedImageButton;

import javax.swing.*;
import java.awt.*;
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
			Icon deadIcon = listToken.get("Cranefeu");
			rpg.getHeroesNameList().remove(hero.getName());
			rpg.getListAvaible().remove(hero);
			GuiPlayPage.updateHeroComboBox(rpg);
			GuiHeroManagerPage.updateHeroComboBox(rpg);

			if (!map.getLevelCompleted()) {
				panel.removeAll();
				panel.setLayout(new BorderLayout());

				JLabel deadLabel = new JLabel(
					"<html><div align='center'>"
					+ "<span style='color: #FF0000;'>Game Over !</span><br/>"
					+ "Your journey ends here… for now."
					+ "</div></html>"
				);

				deadLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 45));
				deadLabel.setIcon(deadIcon);
				deadLabel.setHorizontalTextPosition(JLabel.CENTER);
				deadLabel.setVerticalTextPosition(JLabel.BOTTOM);

				JPanel wrapperEndLabel = wrapperLabelGeneratorInventory(deadLabel, 30, 0, 30, 0, true);
				panel.add(wrapperEndLabel, BorderLayout.CENTER);

				panel.revalidate();
				panel.repaint();
				map.setLevelCompleted(true);
			}
			return;
		}

		/* ---------------- LEVEL COMPLETED ---------------- */
		if (map.getLevelCompleted()) {
			panel.removeAll();
			panel.setLayout(new BorderLayout());

			JLabel endLabel = new JLabel(
				"<html><div align='center'>"
				+ "Congratulation !<br/>"
				+ "Level Completed!"
				+ "</div></html>"
			);
			endLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 65));

			JPanel wrapperEndLabel = wrapperLabelGeneratorInventory(endLabel, 60, 0, 30, 0, true);
			panel.add(wrapperEndLabel, BorderLayout.NORTH);

			String inlineStats = String.format(
				"<html><div style='font-family: Ancient Modern Tales; font-size: 18px; color: #444444; text-align: center;'>"
				+ "%s<br/>"
				+ "<b>Level</b>: %d<br/>"
				+ "<b>XP</b>: %d<br/><br/>"
				+ "<i>Attack</i>: <span style='color: #008000;'>%d</span><br/>"
				+ "<i>Defense</i>: <span style='color: #008000;'>%d</span><br/>"
				+ "<i>Hit Points</i>: <span style='color: #FF0000;'>%d/%d</span>"
				+ "</div></html>",
				hero.getName(),
				hero.getLevel(),
				hero.getXp(),
				rpg.getMainHero().getAttack(),
				rpg.getMainHero().getDefense(),
				rpg.getMainHero().getHitPoint(),
				rpg.getMainHero().getMaxHitPoint()
			);

			JLabel statsLabel = new JLabel(inlineStats);
			statsLabel.setIcon(hero.getToken());
			statsLabel.setHorizontalTextPosition(JLabel.CENTER);
			statsLabel.setVerticalTextPosition(JLabel.BOTTOM);
			statsLabel.setIconTextGap(15);
			statsLabel.setHorizontalAlignment(JLabel.CENTER);

			JPanel wrapperStats = wrapperLabelGeneratorInventory(statsLabel, 0, 0, 20, 0, true);
			panel.add(wrapperStats, BorderLayout.CENTER);

			panel.revalidate();
			panel.repaint();

			map.setLevelCompleted(true);
			return;
		}

		/* -------------------- UPDATE --------------------- */
		GuiMapTab.updateMap(rpg, listToken, grid);
	}
}

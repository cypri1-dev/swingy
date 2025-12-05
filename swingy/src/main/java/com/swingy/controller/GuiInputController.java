package com.swingy.controller;

import com.swingy.controller.GameMovement;
import com.swingy.model.Characters;
import com.swingy.model.Maps;
import com.swingy.view.GuiGamePage;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.event.ActionEvent;
import java.util.Map;

public class GuiInputController {

	private GameMovement movement;
	private Characters hero;
	private Maps map;
	private Menu menu;
	private JPanel grid;
	private Game rpg;
	private Map<String, ImageIcon> listToken;

	public GuiInputController(JComponent panel, GameMovement movement, Characters hero, Maps map, Menu menu, JPanel grid, Game rpg, Map<String, ImageIcon> listToken) {
		this.movement = movement;
		this.hero = hero;
		this.map = map;
		this.menu = menu;
		this.grid = grid;
		this.rpg = rpg;
		this.listToken = listToken;

		bind(panel, "UP", () -> {
			movement.moveWest(hero, map, menu);
			GuiGamePage.updateMap(rpg, listToken, grid);
		});
		bind(panel, "DOWN", () -> {
			movement.moveEast(hero, map, menu);
			GuiGamePage.updateMap(rpg, listToken, grid);
		});
		bind(panel, "LEFT", () -> {
			movement.moveNorth(hero, map, menu);
			GuiGamePage.updateMap(rpg, listToken, grid);
		});
		bind(panel, "RIGHT", () -> {
			movement.moveSouth(hero, map, menu);
			GuiGamePage.updateMap(rpg, listToken, grid);
		});
	}

	private void bind(JComponent comp, String key, Runnable action) {
		comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key), key);
		comp.getActionMap().put(key, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				action.run();
			}
		});
	}
}

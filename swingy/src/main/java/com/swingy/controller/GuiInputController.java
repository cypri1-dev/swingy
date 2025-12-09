package com.swingy.controller;

import com.swingy.controller.GameMovement;
import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.model.Maps;
import com.swingy.view.GuiGamePage;
import com.swingy.view.components.RoundedImageButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;

public class GuiInputController {

	private GameMovement movement;
	private Characters hero;
	private Maps map;
	private Menu menu;
	private static JPanel grid;
	private Game rpg;
	private static Map<String, ImageIcon> listToken;
	private static Icon icon;
	private static JPanel baseInventory;

	private boolean levelFinished = false;  // bloque actions après fin niveau
	private static boolean showingPotionPage = false; // bloque update normal pendant potion

	public GuiInputController(
		JComponent panel,
		GameMovement movement,
		Characters hero,
		Maps map,
		Menu menu,
		JPanel grid,
		Game rpg,
		Map<String, ImageIcon> listToken,
		Icon icon,
		JPanel baseInventory
	) {
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
		if (levelFinished || showingPotionPage) return;
		if (!canMove(hero.getCoordinates().getX() - 1, hero.getCoordinates().getY()))
		return;
		movement.moveWest(hero, map, menu, true);
		update(panel);
	});

	bind(panel, "DOWN", () -> {
		if (levelFinished || showingPotionPage) return;
		if (!canMove(hero.getCoordinates().getX() + 1, hero.getCoordinates().getY()))
		return;
		movement.moveEast(hero, map, menu, true);
		update(panel);
	});

	bind(panel, "LEFT", () -> {
		if (levelFinished || showingPotionPage) return;
		if (!canMove(hero.getCoordinates().getX(), hero.getCoordinates().getY() - 1))
		return;
		movement.moveNorth(hero, map, menu, true);
		update(panel);
	});

	bind(panel, "RIGHT", () -> {
		if (levelFinished || showingPotionPage) return;
		if (!canMove(hero.getCoordinates().getX(), hero.getCoordinates().getY() + 1))
		return;
		movement.moveSouth(hero, map, menu, true);
		update(panel);
	});
	}

	private boolean canMove(int x, int y) {
	int size = map.getSize();
	return !(x < 0 || y < 0 || x >= size || y >= size);
	}

	private void update(JComponent panel) {
		// Potion
		for (Artefact healingPotion : map.getListConsommable()) {
			if (hero.getCoordinates().getX() == healingPotion.getCoordinates().getX() && hero.getCoordinates().getY() == healingPotion.getCoordinates().getY()) {
				map.getListConsommable().remove(healingPotion);
				GuiGamePage.refreshInventory(rpg, baseInventory);
				showPotionPage(panel, healingPotion);
				return;
			}
		}

		// Game Over
		if (hero.getHitPoint() <= 0) {
			Icon deadIcon = listToken.get("Cranefeu");

			if (!levelFinished) {
			panel.removeAll();
			panel.setLayout(new BorderLayout());

			JLabel deadLabel = new JLabel("<html><div align='center'>"
				+ "<span style='color: #FF0000;'>Game Over !</span><br/>"
				+ "Your journey ends here… for now."
				+ "</div></html>");

			deadLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 45));
			deadLabel.setIcon(deadIcon);
			deadLabel.setHorizontalTextPosition(JLabel.CENTER);
			deadLabel.setVerticalTextPosition(JLabel.BOTTOM);

			JPanel wrapperEndLabel = wrapperLabelGenerator(deadLabel, 30, 0, 30, 0, true);
			panel.add(wrapperEndLabel, BorderLayout.CENTER);

			panel.revalidate();
			panel.repaint();
			levelFinished = true;
			}
			return;
		}

		// Level Completed
		if (map.getLevelCompleted()) {
			if (!levelFinished) {
			panel.removeAll();
			panel.setLayout(new BorderLayout());

			JLabel endLabel = new JLabel("<html><div align='center'>"
				+ "Congratulation !<br/>"
				+ "Level Completed!"
				+ "</div></html>");

			endLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 65));
			JPanel wrapperEndLabel = wrapperLabelGenerator(endLabel, 60, 0, 30, 0, true);
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

			JPanel wrapperStats = wrapperLabelGenerator(statsLabel, 0, 0, 20, 0, true);
			panel.add(wrapperStats, BorderLayout.CENTER);

			panel.revalidate();
			panel.repaint();

			levelFinished = true;
			}
			return;
		}

		// Update normal
		GuiGamePage.updateMap(rpg, listToken, grid);
	}

	public static void showPotionPage(JComponent panel, Artefact potion) {
		showingPotionPage = true;

		panel.removeAll();
		panel.setLayout(new BorderLayout());

		Icon potionIcon = listToken.get("potion");
		if (potionIcon == null) potionIcon = new ImageIcon();

		JLabel potionLabel = new JLabel("<html><div align='center'>You found a Healing Potion !</div></html>");
		potionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
		potionLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 40));
		potionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel iconLabel = new JLabel(potionIcon);
		iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

		RoundedImageButton backButton = new RoundedImageButton("Back to Map", icon);
		Dimension Size = new Dimension(150, 48);
		configButtons(backButton, Size);
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		backButton.addActionListener(e -> {
			showingPotionPage = false;
			panel.removeAll();
			panel.setLayout(new BorderLayout());
			panel.add(grid, BorderLayout.CENTER);
			panel.revalidate();
			panel.repaint();
		});

		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setOpaque(false);

		container.add(potionLabel);
		container.add(iconLabel);
		container.add(Box.createRigidArea(new Dimension(0, 20)));
		container.add(backButton);

		// ⭐ CENTRE VERTICALEMENT
		JPanel centerWrapper = new JPanel(new GridBagLayout());
		centerWrapper.setOpaque(false);
		centerWrapper.add(container, new GridBagConstraints());

		panel.add(centerWrapper, BorderLayout.CENTER);

		panel.revalidate();
		panel.repaint();
	}


	private static JPanel wrapperLabelGenerator(JLabel elem, int top, int left, int bottom, int right, boolean setSize) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		wrapper.setOpaque(false);
		wrapper.add(elem);

		wrapper.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(Color.BLACK, 0),
			BorderFactory.createEmptyBorder(top, left, bottom, right)
		));

		if (setSize) {
			Dimension pref = wrapper.getPreferredSize();
			wrapper.setMaximumSize(new Dimension(pref.width, pref.height));
		}

		wrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
		return wrapper;
	}

	private void bind(JComponent comp, String key, Runnable action) {
		comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
			.put(KeyStroke.getKeyStroke(key), key);

		comp.getActionMap().put(key, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
			action.run();
			}
		});
	}

		/************************************************************************ CONFIGURATION BUTTONS ************************************************************************/

	private static void configButtons(RoundedImageButton btn, Dimension size) {
		btn.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		// btn.setPreferredSize(size);
		btn.setMinimumSize(size);
		btn.setMaximumSize(size);
	}
}

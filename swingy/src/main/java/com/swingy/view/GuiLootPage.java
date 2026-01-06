package com.swingy.view;

import java.util.Map;

import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.model.Maps;
import com.swingy.view.components.RoundedImageButton;
import com.swingy.controller.Game;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class GuiLootPage extends GuiCustomPage {

	public static void showLootPage(
		JComponent panel,
		Map<String, ImageIcon> listToken,
		Maps map,
		Game rpg,
		Icon icon,
		JPanel grid,
		JPanel baseInventory,
		Characters enemy,
		RoundedImageButton btn,
		JPanel bottom
	) {
		panel.removeAll();
		panel.setLayout(new BorderLayout());

		Icon heroIcon = rpg.getMainHero().getToken();

		/******************** TITLE ********************/
		JLabel lootLabel = new JLabel(
			"<html><div align='center'>"
			+ "Loot found!"
			+ "</div></html>"
		);
		setCustomFont(lootLabel, Font.BOLD, 40);
		lootLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
		lootLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		/******************** HERO ICON ********************/
		JLabel heroIconLabel = new JLabel(heroIcon);
		heroIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		heroIconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 25, 0));

		/******************** LOOT NAME ********************/
		String lootName = enemy.getArtefacts().get(0).getName();
		String lootRarity = enemy.getArtefacts().get(0).getRarity();
		String lootStat = enemy.getArtefacts().get(0).getType();
		Artefact tmp = enemy.getArtefacts().get(0);
		int bonus = enemy.getArtefacts().get(0).getBonus();
		JLabel lootNameLabel = new JLabel(
			"<html><div align='center'>"
			+ "The enemy dropped:<br/>"
			+ "<b>" + lootName + " (" + lootRarity + ") " + "+" + bonus + " - " + lootStat + "</b>"
			+ "</div></html>"
		);
		setCustomFont(lootNameLabel, Font.PLAIN, 22);
		lootNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		/******************** QUESTION ********************/
		JLabel questionLabel = new JLabel(
			"<html><div align='center'>"
			+ "Do you want to pick it up?"
			+ "</div></html>"
		);
		setCustomFont(questionLabel, Font.ITALIC, 20);
		questionLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 25, 0));
		questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		/******************** BUTTONS ********************/
		RoundedImageButton yesButton = new RoundedImageButton("Yes", icon);
		RoundedImageButton noButton  = new RoundedImageButton("No", icon);

		configButtons(yesButton);
		configButtons(noButton);
		btn.setVisible(true);
		bottom.revalidate();
		bottom.repaint();

		yesButton.addActionListener(e -> {
			rpg.getMainHero().addArtefact(tmp);
			rpg.getMap().getListEnemies().remove(enemy);
			GuiGamePage.refreshInventory(rpg, baseInventory);
			GuiGamePage.resetPage((JPanel) panel, rpg, listToken, grid, baseInventory);
			if (rpg.getMainHero().getCoordinates().getX() == 0 || rpg.getMainHero().getCoordinates().getX() == rpg.getMap().getSize() - 1 || rpg.getMainHero().getCoordinates().getY() == 0 || rpg.getMainHero().getCoordinates().getY() == rpg.getMap().getSize() - 1)
					GuiEndLevelPage.showLevelCompletePage(panel, rpg.getMainHero(), rpg);
		});

		noButton.addActionListener(e -> {
			rpg.getMap().getListEnemies().remove(enemy);
			GuiGamePage.resetPage((JPanel) panel, rpg, listToken, grid, baseInventory);
			if (rpg.getMainHero().getCoordinates().getX() == 0 || rpg.getMainHero().getCoordinates().getX() == rpg.getMap().getSize() - 1 || rpg.getMainHero().getCoordinates().getY() == 0 || rpg.getMainHero().getCoordinates().getY() == rpg.getMap().getSize() - 1)
					GuiEndLevelPage.showLevelCompletePage(panel, rpg.getMainHero(), rpg);
		});

		JPanel buttonRow = new JPanel();
		buttonRow.setLayout(new BoxLayout(buttonRow, BoxLayout.X_AXIS));
		buttonRow.setOpaque(false);
		buttonRow.add(yesButton);
		buttonRow.add(Box.createRigidArea(new Dimension(20, 0)));
		buttonRow.add(noButton);

		/******************** CONTAINER ********************/
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setOpaque(false);
		container.add(lootLabel);
		container.add(heroIconLabel);
		container.add(lootNameLabel);
		container.add(questionLabel);
		container.add(buttonRow);

		JPanel centerWrapper = new JPanel(new GridBagLayout());
		centerWrapper.setOpaque(false);
		centerWrapper.add(container, new GridBagConstraints());

		panel.add(centerWrapper, BorderLayout.CENTER);

		panel.revalidate();
		panel.repaint();
	}
}

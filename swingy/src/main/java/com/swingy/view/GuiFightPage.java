package com.swingy.view;

import java.awt.Font;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.swingy.model.Characters;
import com.swingy.controller.Game;;

public class GuiFightPage extends GuiCustomPage {

	public static void showFightPage(JComponent panel, Characters enemy, Game rpg) {
		setShowingPageFight(true);

		panel.removeAll();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// --- Titre ---
		JLabel titleLabel = new JLabel("Fight");
		setCustomFont(titleLabel, Font.BOLD, 45);
		JPanel wrapperTitleLabel = wrapperLabelGeneratorInventory(titleLabel, 0, 0, 20, 0, true);
		panel.add(wrapperTitleLabel);

		// --- Container horizontal pour héros & ennemi ---
		JPanel fightersPanel = new JPanel();
		fightersPanel.setLayout(new BoxLayout(fightersPanel, BoxLayout.X_AXIS));
		fightersPanel.setOpaque(false);
		fightersPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// --- Bloc héros ---
		JPanel heroPanel = new JPanel();
		configureJPanelFight(heroPanel);

		Characters hero = rpg.getMainHero();

		JLabel heroTokenLabel = new JLabel(GuiGamePage.rescaleToken(hero.getToken(), 150));
		heroTokenLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		heroPanel.add(heroTokenLabel);

		// Texte PV centré avec JLabel standard et HTML + centre forcé
		String heroHPText = String.format(
			"<html><div style='width: 215px; text-align: center;'>"
			+ "<b>HP</b>: <span style='color:red;'>%d/%d</span>"
			+ "</div></html>",
			hero.getHitPoint(), hero.getMaxHitPoint()
		);
		JLabel heroHPLabel = new JLabel(heroHPText);
		setCustomFont(heroHPLabel, Font.BOLD, 25);
		heroHPLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		heroPanel.add(heroHPLabel);

		// --- Bloc ennemi ---
		JPanel enemyPanel = new JPanel();
		configureJPanelFight(enemyPanel);

		JLabel enemyTokenLabel = new JLabel(GuiGamePage.rescaleToken(enemy.getToken(), 150));
		enemyTokenLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		enemyPanel.add(enemyTokenLabel);

		String enemyHPText = String.format(
			"<html><div style='width: 215px; text-align: center;'>"
			+ "<b>HP</b>: <span style='color:red;'>%d/%d</span>"
			+ "</div></html>",
			enemy.getHitPoint(), enemy.getMaxHitPoint()
		);
		JLabel enemyHPLabel = new JLabel(enemyHPText);
		setCustomFont(enemyHPLabel, Font.BOLD, 25);
		enemyHPLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		enemyPanel.add(enemyHPLabel);

		fightersPanel.add(Box.createHorizontalGlue());
		fightersPanel.add(heroPanel);
		fightersPanel.add(Box.createHorizontalGlue());
		fightersPanel.add(enemyPanel);
		fightersPanel.add(Box.createHorizontalGlue());

		panel.add(fightersPanel);

		panel.revalidate();
		panel.repaint();
	}
}
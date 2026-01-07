package com.swingy.view;

import java.awt.Font;
import java.awt.Component;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.swingy.model.Characters;
import com.swingy.view.components.RoundedImageButton;
import com.swingy.controller.Game;
import com.swingy.controller.GuiFightController;
import com.swingy.utils.TypeWriterEffect;

import static com.swingy.utils.Constants.DEBUG_BOLD;

public class GuiFightPage extends GuiCustomPage {

	private static FightLogPanel logPanel;
	private static JLabel currentHeroHPLabel;

	/* ==================== MAIN ENTRY ==================== */

	public static void showFightPage(
			JPanel baseMap,
			Characters enemy,
			Icon icon,
			Game rpg,
			Map<String, ImageIcon> listToken,
			JPanel grid,
			JPanel baseInventory,
			RoundedImageButton btn,
			JPanel bottom
	) {

		new GuiFightController(rpg.getMainHero(), enemy, rpg.getMap());
		setShowingPageFight(true);

		baseMap.removeAll();
		baseMap.setLayout(new BoxLayout(baseMap, BoxLayout.Y_AXIS));

		/* -------------------- TITLE -------------------- */
		JLabel titleLabel = new JLabel("Fight");
		setCustomFont(titleLabel, Font.BOLD, 45);
		JPanel wrapperTitle = wrapperLabelGeneratorInventory(titleLabel, 0, 0, 20, 0, true);
		baseMap.add(wrapperTitle);

		/* ------------------ FIGHTERS ------------------- */
		JPanel fightersPanel = new JPanel();
		fightersPanel.setLayout(new BoxLayout(fightersPanel, BoxLayout.X_AXIS));
		fightersPanel.setOpaque(false);
		fightersPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

		Characters hero = rpg.getMainHero();

		JPanel heroPanel = buildCharacterPanel(hero, hero.getToken());
		JPanel enemyPanel = buildCharacterPanel(enemy, enemy.getToken());

		JLabel heroHPLabel = (JLabel) heroPanel.getClientProperty("hpLabel");
		JLabel enemyHPLabel = (JLabel) enemyPanel.getClientProperty("hpLabel");

		// 🔥 Stockage pour refresh externe (potion)
		currentHeroHPLabel = heroHPLabel;

		fightersPanel.add(Box.createHorizontalGlue());
		fightersPanel.add(heroPanel);
		fightersPanel.add(Box.createHorizontalGlue());
		fightersPanel.add(enemyPanel);
		fightersPanel.add(Box.createHorizontalGlue());

		/* ------------------ BUTTONS -------------------- */
		RoundedImageButton attackButton = new RoundedImageButton("Attack", icon);
		configButtons(attackButton);
		attackButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		attackButton.addActionListener(e -> {
			String result = GuiFightController.attackAction();

			if (handleFightEnd(result, hero, enemy, baseMap, listToken, grid, baseInventory, rpg, btn, bottom))
				return;

			log(result);
			refreshHP(hero, enemy, heroHPLabel, enemyHPLabel);
		});

		RoundedImageButton blockButton = new RoundedImageButton("Block", icon);
		configButtons(blockButton);
		blockButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		blockButton.addActionListener(e -> {
			String result = GuiFightController.blockAction();

			if (handleHeroDeath(result, hero, baseMap, listToken, rpg))
				return;

			log(result);
			refreshHP(hero, enemy, heroHPLabel, enemyHPLabel);
		});

		RoundedImageButton runButton = new RoundedImageButton("Run", icon);
		configButtons(runButton);
		runButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		runButton.addActionListener(e -> {
			String result = GuiFightController.runAction();

			if (handleRun(result, hero, baseMap, listToken, icon, grid, baseInventory, rpg))
				return;

			log(result);
			refreshHP(hero, enemy, heroHPLabel, enemyHPLabel);
		});

		/* -------------------- LOG ---------------------- */
		JLabel historyLabel = new JLabel("Fight History:");
		setCustomFont(historyLabel, Font.ITALIC, 20);

		JPanel historyWrapper = new JPanel();
		historyWrapper.setLayout(new BoxLayout(historyWrapper, BoxLayout.X_AXIS));
		historyWrapper.setOpaque(false);
		historyWrapper.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		historyWrapper.add(historyLabel);
		historyWrapper.add(Box.createHorizontalGlue());

		logPanel = new FightLogPanel();

		/* -------------------- ADD ---------------------- */
		baseMap.add(fightersPanel);
		baseMap.add(Box.createVerticalStrut(10));
		baseMap.add(attackButton);
		baseMap.add(Box.createVerticalStrut(5));
		baseMap.add(blockButton);
		baseMap.add(Box.createVerticalStrut(5));
		baseMap.add(runButton);
		baseMap.add(Box.createVerticalStrut(10));
		baseMap.add(historyWrapper);
		baseMap.add(logPanel);

		baseMap.revalidate();
		baseMap.repaint();
	}

	/* ==================== HELPERS ==================== */

	private static JPanel buildCharacterPanel(Characters c, Icon iconToken) {
		JPanel panel = new JPanel();
		configureJPanelFight(panel);

		JLabel token = new JLabel(GuiGamePage.rescaleToken(iconToken, 150));
		token.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		token.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel hpLabel = new JLabel(buildHPText(c));
		setCustomFont(hpLabel, Font.BOLD, 25);
		hpLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		panel.add(token);
		panel.add(hpLabel);

		panel.putClientProperty("hpLabel", hpLabel);
		return panel;
	}

	private static void refreshHP(Characters hero, Characters enemy, JLabel heroLabel, JLabel enemyLabel) {
		heroLabel.setText(buildHPText(hero));
		enemyLabel.setText(buildHPText(enemy));
	}

	private static String buildHPText(Characters c) {
		return String.format(
			"<html><div style='width: 215px; text-align: center;'>"
			+ "<b>HP</b>: <span style='color:red;'>%d/%d</span>"
			+ "</div></html>",
			c.getHitPoint(),
			c.getMaxHitPoint()
		);
	}

	public static void refreshHeroHP(Characters hero) {
		if (currentHeroHPLabel != null) {
			currentHeroHPLabel.setText(buildHPText(hero));
			currentHeroHPLabel.revalidate();
			currentHeroHPLabel.repaint();
		}
	}

	/* ==================== FIGHT OUTCOMES ==================== */

	private static boolean handleHeroDeath(String result, Characters hero, JPanel baseMap, Map<String, ImageIcon> listToken, Game rpg) {
		if ("DEAD HERO".equals(result)) {
			rpg.getHeroesNameList().remove(hero.getName());
			rpg.getListAvaible().remove(hero);
			GuiGameOverPage.showGameOverPage(baseMap, listToken, rpg.getMap(), rpg);
			return true;
		}
		return false;
	}

	private static boolean handleFightEnd(
			String result,
			Characters hero,
			Characters enemy,
			JPanel baseMap,
			Map<String, ImageIcon> listToken,
			JPanel grid,
			JPanel baseInventory,
			Game rpg,
			RoundedImageButton btn,
			JPanel bottom
	) {
		if (handleHeroDeath(result, hero, baseMap, listToken, rpg))
			return true;

		if ("DEAD ENEMY".equals(result)) {
			setShowingPageFight(false);
			btn.setVisible(true);
			bottom.revalidate();
			bottom.repaint();
			GuiWinPage.showWinPage(baseMap, listToken, rpg.getMap(), rpg, null, grid, baseInventory);
			return true;
		}

		if ("LOOT".equals(result)) {
			setShowingPageFight(false);
			GuiLootPage.showLootPage(baseMap, listToken, rpg.getMap(), rpg, null, grid, baseInventory, enemy, btn, bottom);
			return true;
		}
		return false;
	}

	private static boolean handleRun(
			String result,
			Characters hero,
			JPanel baseMap,
			Map<String, ImageIcon> listToken,
			Icon icon,
			JPanel grid,
			JPanel baseInventory,
			Game rpg
	) {
		if (handleHeroDeath(result, hero, baseMap, listToken, rpg))
			return true;

		if ("ESCAPE".equals(result)) {
			GuiEscapePage.showEscapePage(baseMap, listToken, icon, grid, baseInventory, rpg);
			setShowingPageFight(false);
			GuiGamePage.resetPage(baseMap, rpg, listToken, grid, baseInventory, icon);
			return true;
		}
		return false;
	}

	/* ==================== LOG ==================== */

	public static void log(String text) {
		if (logPanel != null)
			TypeWriterEffect.appendAnimated(logPanel.getLogArea(), text, 25);
	}
}

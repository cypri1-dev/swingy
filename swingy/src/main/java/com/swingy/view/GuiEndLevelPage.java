package com.swingy.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComponent;

import com.swingy.model.Characters;
import com.swingy.controller.Game;

import java.awt.BorderLayout;
import java.awt.Font;

public class GuiEndLevelPage extends GuiCustomPage {

	public static void showLevelCompletePage(JComponent panel, Characters hero, Game rpg) {
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
	}
}
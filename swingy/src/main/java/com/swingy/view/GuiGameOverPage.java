package com.swingy.view;

import java.util.Map;

import com.swingy.model.Maps;
import com.swingy.controller.Game;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.BorderLayout;

public class GuiGameOverPage extends GuiCustomPage {

	public static void showGameOverPage(JComponent panel, Map<String, ImageIcon> listToken, Maps map, Game rpg) {
		GuiPlayPage.updateHeroComboBox(rpg);
		GuiHeroManagerPage.updateHeroComboBox(rpg);

		Icon deadIcon = listToken.get("Cranefeu");
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
		}
	}
}
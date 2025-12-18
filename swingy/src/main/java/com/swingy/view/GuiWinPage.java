package com.swingy.view;

import java.util.Map;

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

public class GuiWinPage extends GuiCustomPage {

	public static void showWinPage(JComponent panel, Map<String, ImageIcon> listToken, Maps map, Game rpg, Icon icon, JPanel grid, JPanel baseInventory) {
		GuiPlayPage.updateHeroComboBox(rpg);
		GuiHeroManagerPage.updateHeroComboBox(rpg);

		Icon heroIcon = rpg.getMainHero().getToken();
		if (!map.getLevelCompleted()) {
			panel.removeAll();
			panel.setLayout(new BorderLayout());

			JLabel victoryLabel = new JLabel(
				"<html><div align='center'>"
				+ "Victory !"
				+ "</div></html>"
			);

			setCustomFont(victoryLabel, Font.BOLD, 40);
			victoryLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
			victoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			
			JLabel iconLabel = new JLabel(heroIcon);
			iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

			RoundedImageButton backButton = new RoundedImageButton("Back to Map", icon);
			configButtons(backButton);
			backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

			backButton.addActionListener(e -> {
				GuiCustomPage.setShowingPageWin(false);
				GuiGamePage.resetPage((JPanel)panel, rpg, listToken, grid, baseInventory);
			});

			JPanel container = new JPanel();
			container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
			container.setOpaque(false);
			container.add(victoryLabel);
			container.add(iconLabel);
			container.add(Box.createRigidArea(new Dimension(0, 20)));
			container.add(backButton);

			JPanel centerWrapper = new JPanel(new GridBagLayout());
			centerWrapper.setOpaque(false);
			centerWrapper.add(container, new GridBagConstraints());

			panel.add(centerWrapper, BorderLayout.CENTER);

			panel.revalidate();
			panel.repaint();
		}
	}
}
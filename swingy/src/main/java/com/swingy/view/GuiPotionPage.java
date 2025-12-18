package com.swingy.view;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.util.Map;
import java.awt.GridBagConstraints;

import com.swingy.model.Artefact;
import com.swingy.controller.Game;
import com.swingy.view.components.RoundedImageButton;

public class GuiPotionPage extends GuiCustomPage {

	public static void showPotionPage(JComponent panel, Artefact potion, Map<String, ImageIcon> listToken, Icon icon, JPanel grid, JPanel baseInventory, Game rpg) {
		GuiCustomPage.setShowingPagePotion(true);

		panel.removeAll();
		panel.setLayout(new BorderLayout());

		Icon potionIcon = listToken.get("potion");
		if (potionIcon == null)
			potionIcon = new ImageIcon();

		JLabel potionLabel = new JLabel("<html><div align='center'>You found a Healing Potion !</div></html>");
		setCustomFont(potionLabel, Font.BOLD, 40);
		potionLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));
		potionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel iconLabel = new JLabel(potionIcon);
		iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		iconLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

		RoundedImageButton backButton = new RoundedImageButton("Back to Map", icon);
		configButtons(backButton);
		backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		backButton.addActionListener(e -> {
		    GuiCustomPage.setShowingPagePotion(false);
			if (rpg.getMainHero().getCoordinates().getX() == 0 || rpg.getMainHero().getCoordinates().getX() == rpg.getMap().getSize() - 1 || rpg.getMainHero().getCoordinates().getY() == 0 || rpg.getMainHero().getCoordinates().getY() == rpg.getMap().getSize() - 1)
				GuiEndLevelPage.showLevelCompletePage(panel, rpg.getMainHero(), rpg);
			else
				GuiGamePage.resetPage((JPanel)panel, rpg, listToken, grid, baseInventory);
		});

		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.setOpaque(false);
		container.add(potionLabel);
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
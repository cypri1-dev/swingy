package com.swingy.view;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.swingy.controller.Export;
import com.swingy.view.components.RoundedImageButton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;

import com.swingy.controller.Game;

public class GuiMainMenuPage extends GuiCustomPage {

	/************************************************************************ WRAPPER BUTTONS ************************************************************************/

	private static JPanel wrapperButtonGenerator(RoundedImageButton btnCreate, RoundedImageButton btnSelect, RoundedImageButton btnPlay, RoundedImageButton btnExit) {
		JPanel wrapper = new JPanel();
		wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
		wrapper.setOpaque(false);

		btnCreate.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);

		wrapper.add(btnCreate);
		wrapper.add(Box.createRigidArea(new Dimension(0, 20)));
		wrapper.add(btnSelect);
		wrapper.add(Box.createRigidArea(new Dimension(0, 20)));
		wrapper.add(btnPlay);
		wrapper.add(Box.createRigidArea(new Dimension(0, 20)));
		wrapper.add(btnExit);
		wrapper.setBorder(BorderFactory.createEmptyBorder(10, 0, 150, 0));

		return wrapper;
	}

	/************************************************************************ MAIN MENU PAGE BUILDER METHOD ************************************************************************/

	public static JPanel createPageMainMenu(ImageIcon icon, JPanel cardPanel, CardLayout cardLayout, Game rpg) {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);

		// --- Zone Verticale principale (au CENTRE) ---
		JPanel content = createBaseStructure();
		panel.add(content, BorderLayout.CENTER);

		// --- Titre ---
		JLabel label = new JLabel("Main Menu");
		setCustomFont(label, Font.BOLD, 60);

		JPanel labelWrapper = wrapperLabelGenerator(label, 60, 20, 0, 20, true, false);
		content.add(labelWrapper);

		// --- Description ---
		JLabel description = new JLabel(
			"<html><div align='center'>"
			+ "<b>Create</b>: Start creating a new character<br>"
			+ "<b>My Heroes</b>: View your existing heroes<br>"
			+ "<b>New Game</b>: Generate a new map and start game<br>"
			+ "<b>Exit</b>: Exit the Game"
			+ "</div></html>"
		);
		setCustomFont(description, Font.ITALIC, 25);

		JPanel descWrapper = wrapperLabelGenerator(description, 0, 0, 0, 0, false, false);
		content.add(descWrapper);

		// --- Buttons ---
		Dimension Size = new Dimension(150, 48);
		RoundedImageButton btnCreate = new RoundedImageButton("New Hero", icon);
		configButtons(btnCreate, Size);
		btnCreate.addActionListener(e -> cardLayout.show(cardPanel, "create"));

		RoundedImageButton btnSelect = new RoundedImageButton("My Heroes", icon);
		configButtons(btnSelect, Size);
		btnSelect.addActionListener(e -> cardLayout.show(cardPanel, "display"));

		RoundedImageButton btnPlay = new RoundedImageButton("New Game", icon);
		configButtons(btnPlay, Size);
		btnPlay.addActionListener(e -> cardLayout.show(cardPanel, "play"));

		RoundedImageButton btnExit = new RoundedImageButton("Exit", icon);
		configButtons(btnExit, Size);
		btnExit.addActionListener(e -> {
			Export.exportData(rpg.getListAvaible());
			System.exit(0);
		});

		JPanel btnWrapper = wrapperButtonGenerator(btnCreate, btnSelect, btnPlay, btnExit);
		content.add(btnWrapper, BorderLayout.CENTER);

		// --- Texte bas ---
		JLabel runes = new JLabel(
			"<html><div align=center>"
			+ "ᛁᚾ ᚨ ᚹᛟᚱᛚᛞ ᛟᚾ ᚦᛖ ᛒᚱᛁᚾᚲ ᛟᚠ ᚲᚺᚨᛟᛊ ᚺᛖᚱᛟᛖᛊ ᚨᚱᛖ ᛒᛟᚱᚾ ᚲᚱᛖᛏᛖ ᛁᛟᚢᚱ ᚲᚺᚨᚱᚨᚲᛏᛖᚱ ᛖᚲᛊᛈᛚᛟᚱᛖ<br>"
			+ "ᚦᛖ ᚢᚾᚲᚾᛟᚹᚾ ᚨᚾᛞ ᚠᚨᚲᛖ ᛁᛟᚢᚱ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖᚾᛏᚢᚱᛖ ᛊᛏᚨᚱᛏᛊ ᚾᛟᚹᚨᚱᛖ ᛁᛟᚢ ᚱᛖᛞᛁ ᛏᛟ ᛒᛖᚲᛟᛗᛖ ᛚᛖᚷᛖᚾᛞ"
			+ "</div></html>"
		);
		setCustomFont(runes, Font.BOLD, 14);

		JPanel runesWrapper = wrapperLabelGenerator(runes, 0, 0, 0, 0, false, false);
		content.add(runesWrapper, BorderLayout.SOUTH);

		return panel;
	}
}
package com.swingy.view;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.swingy.utils.LabelAnimator;
import com.swingy.view.components.FadingLabel;
import com.swingy.view.components.RoundedImageButton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Component;

public class GuiMainMenuPage {

	/* ---------------------- METHOD FOR MAIN MENU PAGE CREATION ----------------------*/

	private static void configButtons(RoundedImageButton btn, Dimension size) {
		btn.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btn.setPreferredSize(size);
		btn.setMinimumSize(size);
		btn.setMaximumSize(size);
	}

	public static JPanel createPageMainMenu(ImageIcon icon, JPanel cardPanel, CardLayout cardLayout) {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		// panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

		// --- Zone Verticale principale (au CENTRE) ---
		JPanel content = new JPanel();
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		// content.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		panel.add(content, BorderLayout.CENTER);

		// --- Titre ---
		JLabel label = new JLabel("Main Menu");
		label.setFont(new Font("Ancient Modern Tales", Font.BOLD, 60));
		// label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));

		JPanel labelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		labelWrapper.setOpaque(false);
		labelWrapper.add(label);
		labelWrapper.setBorder(BorderFactory.createEmptyBorder(60, 20, 0, 20));
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
		description.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 25));

		JPanel descWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		descWrapper.setOpaque(false);
		descWrapper.add(description);
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
		btnExit.addActionListener(e -> System.exit(0));

		JPanel btnWrapper = new JPanel();
		btnWrapper.setLayout(new BoxLayout(btnWrapper, BoxLayout.Y_AXIS));
		btnWrapper.setOpaque(false);

		btnCreate.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPlay.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btnWrapper.add(btnCreate);
		btnWrapper.add(Box.createRigidArea(new Dimension(0, 20)));
		btnWrapper.add(btnSelect);
		btnWrapper.add(Box.createRigidArea(new Dimension(0, 20)));
		btnWrapper.add(btnPlay);
		btnWrapper.add(Box.createRigidArea(new Dimension(0, 20)));
		btnWrapper.add(btnExit);
		btnWrapper.setBorder(BorderFactory.createEmptyBorder(10, 0, 150, 0));

		content.add(btnWrapper, BorderLayout.CENTER);

		// --- Texte bas ---
		JLabel runes = new JLabel(
			"<html><div align=center>"
			+ "ᛁᚾ ᚨ ᚹᛟᚱᛚᛞ ᛟᚾ ᚦᛖ ᛒᚱᛁᚾᚲ ᛟᚠ ᚲᚺᚨᛟᛊ ᚺᛖᚱᛟᛖᛊ ᚨᚱᛖ ᛒᛟᚱᚾ ᚲᚱᛖᛏᛖ ᛁᛟᚢᚱ ᚲᚺᚨᚱᚨᚲᛏᛖᚱ ᛖᚲᛊᛈᛚᛟᚱᛖ<br>"
			+ "ᚦᛖ ᚢᚾᚲᚾᛟᚹᚾ ᚨᚾᛞ ᚠᚨᚲᛖ ᛁᛟᚢᚱ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖᚾᛏᚢᚱᛖ ᛊᛏᚨᚱᛏᛊ ᚾᛟᚹᚨᚱᛖ ᛁᛟᚢ ᚱᛖᛞᛁ ᛏᛟ ᛒᛖᚲᛟᛗᛖ ᛚᛖᚷᛖᚾᛞ"
			+ "</div></html>"
		);
		runes.setFont(new Font("Ancient Modern Tales", Font.BOLD, 14));

		JPanel runesWrapper = new JPanel();
		runesWrapper.setOpaque(false);
		runesWrapper.add(runes);
		content.add(runesWrapper, BorderLayout.SOUTH);

		return panel;
	}
}
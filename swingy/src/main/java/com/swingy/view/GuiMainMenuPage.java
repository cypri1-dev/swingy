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
		// descWrapper.setBorder(BorderFactory.createCompoundBorder(
		// 	BorderFactory.createLineBorder(Color.BLACK, 2),
		// 	BorderFactory.createEmptyBorder(0, 0, 0, 0)
		// ));
		content.add(descWrapper);

		// --- Buttons ---
		Dimension btnSize = new Dimension(150, 48);
		RoundedImageButton btnCreate = new RoundedImageButton("New Hero", icon);
		btnCreate.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));

		btnCreate.setPreferredSize(btnSize);
		btnCreate.setMinimumSize(btnSize);
		btnCreate.setMaximumSize(btnSize);
		/* ActionListener */
		btnCreate.addActionListener(e -> cardLayout.show(cardPanel, "create"));

		RoundedImageButton btnSelect = new RoundedImageButton("My Heroes", icon);
		btnSelect.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));

		btnSelect.setPreferredSize(btnSize);
		btnSelect.setMinimumSize(btnSize);
		btnSelect.setMaximumSize(btnSize);
		/* ActionListener */
		btnSelect.addActionListener(e -> cardLayout.show(cardPanel, "display"));

		RoundedImageButton btnPlay = new RoundedImageButton("New Game", icon);
		btnPlay.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));

		btnPlay.setPreferredSize(btnSize);
		btnPlay.setMinimumSize(btnSize);
		btnPlay.setMaximumSize(btnSize);
		/* ActionListener */
		btnPlay.addActionListener(e -> cardLayout.show(cardPanel, "play"));

		RoundedImageButton btnExit = new RoundedImageButton("Exit", icon);
		btnExit.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));

		btnExit.setPreferredSize(btnSize);
		btnExit.setMinimumSize(btnSize);
		btnExit.setMaximumSize(btnSize);
		/* ActionListener */
		btnExit.addActionListener(e -> cardLayout.show(cardPanel, "exit"));

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

		// btnWrapper.setBorder(BorderFactory.createCompoundBorder(
		// 	BorderFactory.createEmptyBorder(10, 0, 240, 0),
		// 	BorderFactory.createLineBorder(Color.MAGENTA, 2)
		// ));

		// btnWrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, 260, 0));
		// content.add(Box.createRigidArea(new Dimension(0, 30)));
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
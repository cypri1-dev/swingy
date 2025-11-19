package com.swingy.view;

import com.swingy.view.components.RoundedImageButton;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

public class GuiCreationPage {

	/* ---------------------- METHOD FOR CREATION_PAGE CREATION ----------------------*/

	public static JPanel createCreationPage(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon) {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));

		// --- Zone verticale principale ---
		JPanel content = new JPanel();
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		panel.add(content, BorderLayout.CENTER);

		// --- Titre ---
		JLabel label = new JLabel(title);
		label.setFont(new Font("Ancient Modern Tales", Font.BOLD, 60));

		JPanel labelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		labelWrapper.setOpaque(false);
		labelWrapper.add(label);
		labelWrapper.setBorder(BorderFactory.createEmptyBorder(60, 20, 50, 20));
		content.add(labelWrapper);

		// --- Button Menu ---
		RoundedImageButton btn = new RoundedImageButton("Menu", icon);
		btn.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btn.setPreferredSize(new Dimension(150, 48));
		btn.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));
		btn.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2));

		JPanel bottom = new JPanel();
		bottom.setOpaque(false);
		bottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
		bottom.add(btn);
		panel.add(bottom, BorderLayout.SOUTH);

		return panel;
	}
}
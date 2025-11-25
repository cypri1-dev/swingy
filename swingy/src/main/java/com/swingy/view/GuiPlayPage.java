package com.swingy.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.swingy.controller.Game;

public class GuiPlayPage {

	/************************************************************************ PLAY PAGE BUILDER METHOD ************************************************************************/

	public static JPanel createPlayPage(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon, Game rpg) {

		// --- Panel a return ---
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

		return panel;
	}
}
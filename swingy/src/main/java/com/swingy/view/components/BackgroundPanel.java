package com.swingy.view;

import javax.swing.JPanel;

import java.awt.Image;
import java.awt.Graphics;

public class BackgroundPanel extends JPanel {
	private final Image backgroundImage;

	public BackgroundPanel(Image img) {
		this.backgroundImage = img;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
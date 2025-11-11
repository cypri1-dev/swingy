package com.swingy.view;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// Source - https://stackoverflow.com/a
// Posted by coobird, modified by community. See post 'Timeline' for change history
// Retrieved 2025-11-11, License - CC BY-SA 3.0

public class JPanelWithBackground extends JPanel {

	private Image backgroundImage;

	// Some code to initialize the background image.
	// Here, we use the constructor to load the image. This
	// can vary depending on the use case of the panel.
	public JPanelWithBackground(String fileName) throws IOException {
		backgroundImage = ImageIO.read(getClass().getResourceAsStream("/" + fileName));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw the background image.
		if (backgroundImage != null)
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	}
}

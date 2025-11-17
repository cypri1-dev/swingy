package com.swingy.view.components;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.BasicStroke;
import java.awt.geom.RoundRectangle2D;

public class RoundedImageButton extends JButton {
	private int radius = 20;

	public RoundedImageButton(String text, Icon icon) {
		super(text, icon);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setBorderPainted(false);
		setOpaque(false);
		setHorizontalTextPosition(SwingConstants.CENTER);
		setVerticalTextPosition(SwingConstants.CENTER);
		setForeground(Color.BLACK);
		setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();

		// Anti-aliasing pour arrondis smooth
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Clip arrondi
		Shape clip = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), radius, radius);
		g2.setClip(clip);

		// Dessiner l’icône et le texte via super (passe par paintComponent)
		super.paintComponent(g2);

		// Remet clip par défaut
		g2.setClip(null);

		// Dessiner la bordure arrondie
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(2));
		g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);

		g2.dispose();
	}
}
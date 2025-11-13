package com.swingy.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class GuiPageCreator {

	/* ---------------------- SPECIAL CLASS FOR FADDING ----------------------*/

	private static class FadingLabel extends JLabel {
		private float alpha = 0f; // transparence initiale

		public FadingLabel(String text) {
			super(text);
			setOpaque(false);
		}

		public void setAlpha(float alpha) {
			this.alpha = alpha;
			repaint();
		}

		public float getAlpha() {
			return alpha;
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			super.paintComponent(g2d);
			g2d.dispose();
		}
	}

	/* ---------------------- SPECIAL CLASS FOR ROUNDED BUTTON ----------------------*/

	public static class RoundedImageButton extends JButton {
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

	/* ---------------------- METHOD FOR WELCOME PAGE CREATION ----------------------*/

	public static JPanel createPageWelcome(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);

		// Title //
		JLabel label = new JLabel(title, SwingConstants.CENTER);
		label.setFont(new Font("Ancient Modern Tales", Font.BOLD, 56));
		label.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));
		panel.add(label, BorderLayout.NORTH);

		// Description //
		FadingLabel description = new FadingLabel("<html><div align='center'>" + "Welcome, brave adventurer!<br>" + "Your journey through the world of Swingy begins now!<br>" + "Where courage, strategy, and fate will decide your legend..." + "</div></html>");
		description.setHorizontalAlignment(SwingConstants.CENTER);
		description.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 26));
		description.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.add(description, BorderLayout.CENTER);

		// Button //
		RoundedImageButton btn = new RoundedImageButton("Enter Game", icon);
		btn.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btn.setPreferredSize(new Dimension(152, 52));
		btn.addActionListener(e -> {
			cardLayout.show(cardPanel, "main_menu");
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 40, 0));
		buttonPanel.add(btn);
		panel.add(buttonPanel, BorderLayout.SOUTH);

		// Timer for fade-in
		Timer timer = new Timer(60, null);
		timer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float alpha = description.getAlpha() + 0.05f;
				if (alpha >= 1f) {
					alpha = 1f;
					timer.stop();
				}
				description.setAlpha(alpha);
			}
		});
		timer.start();

		return panel;
	}
}

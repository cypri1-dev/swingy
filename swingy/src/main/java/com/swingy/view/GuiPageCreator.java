package com.swingy.view;

import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPageCreator {

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

	public static JPanel createPageWelcome(String title) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);

		JLabel label = new JLabel(title, SwingConstants.CENTER);
		label.setFont(new Font("Ancient Modern Tales", Font.BOLD, 56));

		Border debugBorder1 = BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.RED, 2), // visible
				BorderFactory.createEmptyBorder(60, 0, 0, 0)  // padding intérieur
		);
		label.setBorder(debugBorder1);
		panel.add(label, BorderLayout.NORTH);

		FadingLabel description = new FadingLabel("<html><div align='center'>" + "Welcome, brave adventurer!<br>" + "Your journey through the world of Swingy begins now!<br>" + "Where courage, strategy, and fate will decide your legend..." + "</div></html>");
		description.setHorizontalAlignment(SwingConstants.CENTER);
		description.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 26));

		Border debugBorder2 = BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.GREEN, 2),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
		);
		description.setBorder(debugBorder2);

		panel.add(description, BorderLayout.CENTER);

		// Timer pour le fade-in
		Timer timer = new Timer(50, null);
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

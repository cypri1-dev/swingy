package com.swingy.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class GuiPageCreator {

	/* ---------------------- SPECIAL CLASS FOR FADDING_TOKEN ----------------------*/

	private static class FadingToken extends JLabel {
		private float alpha = 0f;

		public FadingToken(ImageIcon token) {
			super(token);
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

	/* ----------------------FADDING_TOKEN METHODS ----------------------*/

	private static void fadeTokensSequentially(FadingToken[] tokens) {
		fadeToken(tokens, 0);
	}

	private static void fadeToken(FadingToken[] tokens, int index) {
		if (index >= tokens.length) return;

		FadingToken token = tokens[index];

		Timer timer = new Timer(40, null);
		timer.addActionListener(e -> {
			float alpha = token.getAlpha() + 0.05f;
			if (alpha >= 1f) {
				token.setAlpha(1f);
				((Timer)e.getSource()).stop();
				// Quand le token est terminé, on lance le suivant
				fadeToken(tokens, index + 1);
			} else {
				token.setAlpha(alpha);
			}
		});
		timer.start();
	}


	/* ---------------------- SPECIAL CLASS FOR FADDING_LABEL ----------------------*/

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

	public static JPanel createPageWelcome(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon, Map<String, ImageIcon> listToken) {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));  // DEBUG

		// --- Zone verticale principale (au CENTER) ---
		JPanel content = new JPanel();
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));  // DEBUG
		panel.add(content, BorderLayout.CENTER);

		// --- Titre ---
		JLabel label = new JLabel(title);
		label.setFont(new Font("Ancient Modern Tales", Font.BOLD, 56));
		label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // debug

		JPanel labelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		labelWrapper.setOpaque(false);
		labelWrapper.add(label);
		labelWrapper.setBorder(BorderFactory.createEmptyBorder(60, 20, 60, 20));
		content.add(labelWrapper);

		// --- Description ---
		FadingLabel description = new FadingLabel(
			"<html><div align='center'>"
			+ "Welcome, brave adventurer!<br>"
			+ "Your journey through the world of Swingy begins now!<br>"
			+ "Where courage, strategy, and fate will decide your legend..."
			+ "</div></html>"
		);
		description.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 26));
		description.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2)); // debug150

		JPanel descWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		descWrapper.setOpaque(false);
		descWrapper.add(description);
		descWrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0));
		content.add(descWrapper);

		// --- Tokens ---
		JPanel tokenContent = new JPanel();
		tokenContent.setOpaque(false);
		tokenContent.setLayout(new BoxLayout(tokenContent, BoxLayout.Y_AXIS));
		tokenContent.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(Color.BLACK, 2),
			BorderFactory.createEmptyBorder(0, 0, 0, 0)
		));
		tokenContent.setPreferredSize(new Dimension(400, 500)); // largeur x hauteur

		ImageIcon iconSpider = listToken.get("Araignee_geante");
		ImageIcon iconSkull = listToken.get("Cranefeu");
		ImageIcon iconOzi = listToken.get("Ozi");
		ImageIcon iconManticore = listToken.get("manticore");
		ImageIcon iconEttins = listToken.get("ettins");
		ImageIcon iconOrc = listToken.get("Orc");
		ImageIcon iconVolo = listToken.get("volothamp_geddarm");

		FadingToken tokenSpider = new FadingToken(iconSpider);
		FadingToken tokenSkull = new FadingToken(iconSkull);
		FadingToken tokenOzi = new FadingToken(iconOzi);
		FadingToken tokenManticore = new FadingToken(iconManticore);
		FadingToken tokenEttins = new FadingToken(iconEttins);
		FadingToken tokenOrc = new FadingToken(iconOrc);
		FadingToken tokenVolo = new FadingToken(iconVolo);

		FadingToken[] tokens = {tokenSpider, tokenSkull, tokenOzi, tokenManticore, tokenEttins, tokenOrc, tokenVolo};
		List<FadingToken> tokenList = Arrays.asList(tokens);
		Collections.shuffle(tokenList);
		tokenList.toArray(tokens);
		fadeTokensSequentially(tokens);
		
		JPanel tokenWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		tokenWrapper.setOpaque(false);
		tokenWrapper.add(tokenSpider);
		tokenWrapper.add(tokenSkull);
		tokenWrapper.add(tokenOzi);
		tokenWrapper.add(tokenManticore);
		tokenWrapper.add(tokenEttins);
		tokenWrapper.add(tokenOrc);
		tokenWrapper.add(tokenVolo);
		tokenContent.add(tokenWrapper);

		content.add(tokenContent);

		// int baseDelay = 500;
		// int stepdelay = 300;

		// for (int i = 0; i < tokens.length; i++) {
		// 	FadingToken tmp = tokens[i];
		// 	int delay = baseDelay + i * stepdelay;

		// 	new Timer(40, null) {{
		// 		addActionListener(e -> {
		// 			float alpha = tmp.getAlpha() + 0.05f;
		// 			if (alpha >= 1f) {
		// 				tmp.setAlpha(1f);
		// 				((Timer)e.getSource()).stop();
		// 			} else {
		// 				tmp.setAlpha(alpha);
		// 			}
		// 		});
		// 		new Timer(delay, e -> start()).start();
		// 	}};
		// }

		// --- Bouton en bas ---
		RoundedImageButton btn = new RoundedImageButton("Enter Game", icon);
		btn.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btn.setPreferredSize(new Dimension(152, 52));
		btn.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));
		btn.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2)); // DEBUG

		JPanel bottom = new JPanel();
		bottom.setOpaque(false);
		bottom.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2)); // DEBUG
		bottom.add(btn);
		panel.add(bottom, BorderLayout.SOUTH);

		// --- Animation description ---
		Timer timer = new Timer(60, e -> {
			float alpha = description.getAlpha() + 0.05f;
			if (alpha >= 1f) {
				description.setAlpha(1f);
				((Timer)e.getSource()).stop();
			} else {
				description.setAlpha(alpha);
			}
		});
		timer.start();

		return panel;


	}
}
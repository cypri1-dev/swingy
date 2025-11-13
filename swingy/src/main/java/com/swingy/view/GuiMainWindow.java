package com.swingy.view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GuiMainWindow extends JFrame {

	private CardLayout cardLayout;
	private JPanel cardPanel;

	public GuiMainWindow() throws IOException {
		setTitle("RetroRPG");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(673, 930);
		setLocationRelativeTo(null);

		// Création du panel fond parchemin
		BackgroundPanel backgroundPanel = new BackgroundPanel(ImageIO.read(getClass().getResourceAsStream("/parchment.jpeg")));
		backgroundPanel.setLayout(new BorderLayout()); // pour placer d autres elements dessus

		// Création du CardLayout
		cardLayout = new CardLayout(); // gestionnaire agencemment pour afficher une page a la fois
		cardPanel = new JPanel(cardLayout);
		cardPanel.setOpaque(false);  // IMPORTANT : le panel de cartes doit être transparent

		// Création des pages, toutes transparentes
		JPanel welcomePage = GuiPageCreator.createPageWelcome("RetroRPG");
		JPanel page1 = createPage("Main Menu");

		cardPanel.add(welcomePage, "welcome");
		cardPanel.add(page1, "main_menu");

		// Ajout du cardPanel dans le backgroundPanel (avec fond parchemin)
		backgroundPanel.add(cardPanel, BorderLayout.CENTER);

		// Définir backgroundPanel comme content pane
		setContentPane(backgroundPanel);

		cardLayout.show(cardPanel, "welcome");
	}

	private JPanel createPage(String title) {
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);  // FOND TRANSPARENT pour laisser voir l'image

		JLabel label = new JLabel(title, SwingConstants.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, 36));
		// label.setForeground(Color.BLACK);
		panel.add(label, BorderLayout.CENTER);

		JButton switchButton = new JButton("Switch page");
		switchButton.addActionListener(e -> {
			if (title.equals("RetroRPG")) {
				cardLayout.show(cardPanel, "main_menu");
			} else {
				cardLayout.show(cardPanel, "welcome");
			}
		});
		panel.add(switchButton, BorderLayout.SOUTH);

		return panel;
	}

	private static class BackgroundPanel extends JPanel {
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
}

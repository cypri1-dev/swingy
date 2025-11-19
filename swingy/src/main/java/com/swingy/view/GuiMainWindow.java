package com.swingy.view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.util.HashMap;
import java.util.Map;

public class GuiMainWindow extends JFrame {

	private CardLayout cardLayout;
	private JPanel cardPanel;
	private Map<String, ImageIcon> listToken = new HashMap<>();

	private void initTokens() {
		String[] tokenPaths = {
			"/Araignee_geante_token.png",
			"/Cranefeu_token.png",
			"/ettins_token.png",
			"/golem_de_chair_token.png",
			"/Jeune_dragon_vert_token.png",
			"/manticore_token.png",
			"/Orc_token.png",
			"/Ozi_token.png",
			"/volothamp_geddarm_token.png"
		};

		for (String path : tokenPaths) {
			try {
				ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResourceAsStream(path)));
				String name = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("_token.png"));
				listToken.put(name, icon);
			} catch (IOException e) {
				e.printStackTrace();
				// fail so exit !
			}
		}
	}

	public GuiMainWindow() throws IOException {
		// --- Init tokens ---
		initTokens();

		setTitle("RetroRPG");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
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
		ImageIcon iconTest = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/test_button.png")));
		ImageIcon iconButton = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/test_button.png")));
		JPanel welcomePage = GuiWelcomePage.createPageWelcome("RetroRPG", cardLayout, cardPanel, iconTest, listToken);
		JPanel mainMenuPage = GuiMainMenuPage.createPageMainMenu(iconButton, cardPanel, cardLayout);
		JPanel createPage = createPageTest("Creation");
		JPanel displayPage = createPageTest("Heroes");
		JPanel playPage = createPageTest("Play");
		JPanel exitPage = createPageTest("Exit");

		cardPanel.add(welcomePage, "welcome");
		cardPanel.add(mainMenuPage, "main_menu");
		cardPanel.add(createPage, "create");
		cardPanel.add(displayPage, "display");
		cardPanel.add(playPage, "play");
		cardPanel.add(exitPage, "exit");

		// Ajout du cardPanel dans le backgroundPanel (avec fond parchemin)
		backgroundPanel.add(cardPanel, BorderLayout.CENTER);

		// Définir backgroundPanel comme content pane
		setContentPane(backgroundPanel);

		cardLayout.show(cardPanel, "welcome");
	}

	private JPanel createPageTest(String title) {
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

	public CardLayout getCardLayout() {return this.cardLayout;}
	public JPanel getCardPanel() {return this.cardPanel;}
	public Map<String, ImageIcon> getListTokens() {return this.listToken;}
}

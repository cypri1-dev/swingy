package com.swingy.view;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

import com.swingy.controller.Game;

import java.util.HashMap;
import java.util.Map;

import com.swingy.view.components.BackgroundPanel;

public class GuiMainWindow extends JFrame {

	private CardLayout cardLayout;
	private JPanel cardPanel;
	private Map<String, ImageIcon> listToken = new HashMap<>();
	private Game rpg;

	/************************************************************************ INIT TOKENS METHOD ************************************************************************/

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
			}
		}
	}

	/************************************************************************ CONSTRUCTOR ************************************************************************/

	public GuiMainWindow(Game rpg) throws IOException {
		this.rpg = rpg;
		initTokens();

		setTitle("RetroRPG");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		setResizable(false);
		setSize(673, 930);
		setLocationRelativeTo(null);

		// Création du panel fond parchemin
		BackgroundPanel backgroundPanel = new BackgroundPanel(ImageIO.read(getClass().getResourceAsStream("/parchment.jpeg")));
		backgroundPanel.setLayout(new BorderLayout());

		// Création du CardLayout
		cardLayout = new CardLayout(); // gestionnaire agencemment pour afficher une page a la fois
		cardPanel = new JPanel(cardLayout);
		cardPanel.setOpaque(false);

		// Chargement des images pour les boutons customs
		ImageIcon iconTest = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/test_button.png")));
		ImageIcon iconButton = new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/test_button.png")));

		// Création des pages, toutes transparentes
		JPanel welcomePage = GuiWelcomePage.createPageWelcome("RetroRPG", cardLayout, cardPanel, iconTest, listToken);
		JPanel mainMenuPage = GuiMainMenuPage.createPageMainMenu(iconButton, cardPanel, cardLayout, rpg);
		JPanel createPage = GuiCreationPage.createCreationPage("New Hero", cardLayout, cardPanel, iconTest, rpg);
		JPanel displayPage = GuiHeroManagerPage.createViewPage("Heroes", cardLayout, cardPanel, iconTest, rpg);
		JPanel playPage = createPageTest("Play");

		// ajout des pages au cardPanel
		cardPanel.add(welcomePage, "welcome");
		cardPanel.add(mainMenuPage, "main_menu");
		cardPanel.add(createPage, "create");
		cardPanel.add(displayPage, "display");
		cardPanel.add(playPage, "play");

		// Ajout du cardPanel dans le backgroundPanel
		backgroundPanel.add(cardPanel, BorderLayout.CENTER);

		// Définir backgroundPanel comme content pane
		setContentPane(backgroundPanel);

		// Affiche la premiere page
		cardLayout.show(cardPanel, "welcome");
	}

	/************************************************************************ PAGES TEST BUILDER METHOD ************************************************************************/

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
				cardLayout.show(cardPanel, "main_menu");
			}
		});
		panel.add(switchButton, BorderLayout.SOUTH);

		return panel;
	}

	/************************************************************************ GETTERS ************************************************************************/

	public CardLayout getCardLayout() {return this.cardLayout;}
	public JPanel getCardPanel() {return this.cardPanel;}
	public Map<String, ImageIcon> getListTokens() {return this.listToken;}
	public Game getGame() {return this.rpg;}
}

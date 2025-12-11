package com.swingy.view;

import com.swingy.controller.Game;
import com.swingy.view.components.BackgroundPanel;

import javax.swing.*;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.Map;


public class GuiMainWindow extends JFrame {

	private CardLayout cardLayout;
	private JPanel cardPanel;
	private static Map<String, ImageIcon> listToken = new HashMap<>();
	private Game rpg;
	private static Map<Integer, BufferedImage> listBackground = new HashMap<>();

	/************************************************************************ INIT TOKENS METHOD ************************************************************************/

	private void initImages() {
		String[] tokenPaths = {
			"/Araignee_geante_token.png",
			"/Cranefeu_token.png",
			"/ettins_token.png",
			"/golem_de_chair_token.png",
			"/Jeune_dragon_vert_token.png",
			"/manticore_token.png",
			"/Orc_token.png",
			"/Ozi_token.png",
			"/volothamp_geddarm_token.png",
			"/token1_token.png",
			"/token2_token.png",
			"/token3_token.png",
			"/token4_token.png",
			"/bandit_token.png",
			"/bat_token.png",
			"/gobelin_token.png",
			"/mudling_token.png",
			"/rat_token.png",
			"/skeletal_hand_token.png",
			"/slime_token.png",
			"/spider_token.png",
			"/potion_token.png"
		};

		String[] backgroundPaths = {
			"/forest_map.jpg",
			"/cavern_map.jpeg"
		};

		for (String path : tokenPaths) {
			try (InputStream is = getClass().getResourceAsStream(path)) {

				if (is == null) {
					System.err.println("❌ Token introuvable : " + path);
					continue;
				}

				BufferedImage img = ImageIO.read(is);
				ImageIcon icon = new ImageIcon(img);

				String name = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("_token.png"));
				listToken.put(name, icon);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		int idx = 0;
		for (String path : backgroundPaths) {
			try (InputStream is = getClass().getResourceAsStream(path)) {

				if (is == null) {
					System.err.println("❌ Background introuvable : " + path);
					continue;
				}

				BufferedImage bg = ImageIO.read(is);
				listBackground.put(idx, bg);
				idx++;

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	/************************************************************************ CONSTRUCTOR ************************************************************************/

	public GuiMainWindow(Game rpg) throws IOException {
		this.rpg = rpg;
		
		initImages();
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
		JPanel playPage = GuiPlayPage.createPlayPage("Game", cardLayout, cardPanel, iconButton, listToken, rpg);

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

	/************************************************************************ GETTERS ************************************************************************/

	public CardLayout getCardLayout() {return this.cardLayout;}
	public JPanel getCardPanel() {return this.cardPanel;}
	public static Map<String, ImageIcon> getListTokens() {return listToken;}
	public Game getGame() {return this.rpg;}
	public static Map<Integer, BufferedImage> getBackgrounds() {return listBackground;}
}

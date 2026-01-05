package com.swingy.view;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.swingy.controller.Game;
import com.swingy.controller.GuiInputController;
import com.swingy.controller.GuiInventoryController;
import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.view.components.RoundedImageButton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.awt.image.BufferedImage;

public class GuiGamePage extends GuiCustomPage {

	/************************************************************************ METHOD USE POTION ************************************************************************/

	private static void usePotion(Game rpg, JPanel baseInventory) {
		GuiInventoryController.checkPotion(rpg, baseInventory);
		refreshInventory(rpg, baseInventory);
	}

	/************************************************************************ METHOD REFRESH CHECKBOXES ************************************************************************/

	public static void refreshInventory(Game rpg, JPanel baseInventory) {
		baseInventory.removeAll();

		// Title
		JLabel titleInventory = new JLabel("Inventory");
		setCustomFont(titleInventory, Font.BOLD, 45);

		JPanel wrapperTitleInventory = wrapperLabelGeneratorInventory(titleInventory, 0, 0, 40, 0, true);
		baseInventory.add(wrapperTitleInventory);

		// Stats
		JLabel statsLabel = new JLabel(GuiInventoryController.buildFormattedStats(rpg));
		JPanel wrapperStats = wrapperLabelGeneratorInventory(statsLabel, 0, 0, 20, 0, true);
		baseInventory.add(wrapperStats);

		// Checkboxes
		createCheckBoxes(rpg, baseInventory);

		baseInventory.revalidate();
		baseInventory.repaint();
	}

	/************************************************************************ METHOD TO SET CHECKBOXES ************************************************************************/

	private static void createCheckBoxes(Game rpg, JPanel baseInventory) {
		Characters hero = rpg.getMainHero();
		Map<String, List<JCheckBox>> checkBoxesByType = new HashMap<>();

		for (Artefact items : hero.getArtefacts()) {
			String checkboxText = GuiInventoryController.buildFormattedItem(items);

			final Artefact currentItem = items;  // **Important** : variable finale locale pour la lambda

			JCheckBox checkBox = new JCheckBox(checkboxText);
			checkBox.setOpaque(false);
			checkBox.setSelected(currentItem.getIsEquipped());
			setCustomFont(checkBox, Font.PLAIN, 25);

			// Remplissage des maps
			checkBoxesByType.computeIfAbsent(currentItem.getType(), k -> new ArrayList<>()).add(checkBox);
			checkBox.putClientProperty("artefact", currentItem);

			checkBox.addItemListener(e -> {
				GuiInventoryController.inventoryManager(checkBox, checkBoxesByType, hero, e);
				refreshInventory(rpg, baseInventory);
			});
			
			JPanel wrapperCheckBox = wrapperCheckboxGenerator(checkBox, 0, 0, 0, 0);
			baseInventory.add(wrapperCheckBox);
		}
	}
	
	/************************************************************************ RESET PAGE METHOD ************************************************************************/
	
	public static void resetPage( JPanel baseMap, Game rpg, Map<String, ImageIcon> listToken, JPanel grid, JPanel baseInventory) {
		baseMap.removeAll();
		baseMap.setLayout(new BoxLayout(baseMap, BoxLayout.Y_AXIS));

		// --- Title ---
		JLabel titleMap = new JLabel("Map");
		setCustomFont(titleMap, Font.BOLD, 45);
		JPanel wrapperTitleMap = wrapperLabelGeneratorInventory(titleMap, 0, 0, 20, 0, true);
		baseMap.add(wrapperTitleMap);

		// --- Nouveau background ---
		BufferedImage newBg = selectRandomBackground();
		grid.putClientProperty("background", newBg);

		// --- Reset contenu de la grille ---
		grid.removeAll();

		// --- Redessine la map ---
		GuiMapTab.updateMap(rpg, listToken, grid);

		baseMap.add(grid);

		// --- Reset inventory si nécessaire ---
		if (baseInventory != null)
			refreshInventory(rpg, baseInventory);

		baseMap.revalidate();
		baseMap.repaint();
		grid.repaint();
	}
	
	/************************************************************************ GAME PAGE BUILDER ************************************************************************/

	public static JPanel createGamePage(Game rpg, CardLayout cardLayout, JPanel cardPanel, Map<String, ImageIcon> listToken, ImageIcon icon) {

		// Main panel
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);

		// Tabs container
		JTabbedPane tabPanel = new JTabbedPane();
		configureTabPanel(tabPanel);

		/****************************** TAB 2 — INVENTORY ******************************/

		JPanel baseInventory = createBaseStructure();

		// Title
		JLabel titleInventory = new JLabel("Inventory");
		setCustomFont(titleInventory, Font.BOLD, 45);

		JPanel wrapperTitleInventory = wrapperLabelGeneratorInventory(titleInventory, 0, 0, 40, 0, true);
		baseInventory.add(wrapperTitleInventory);

		// Stats
		JLabel statsLabel = new JLabel(GuiInventoryController.buildFormattedStats(rpg));
		JPanel wrapperStats = wrapperLabelGeneratorInventory(statsLabel, 0, 0, 20, 0, true);
		baseInventory.add(wrapperStats);

		// Checkboxes
		createCheckBoxes(rpg, baseInventory);

		/****************************** TAB 1 — MAP ******************************/

		JPanel baseMap = createBaseStructure();

		// Title
		JLabel titleMap = new JLabel("Map");
		setCustomFont(titleMap, Font.BOLD, 45);

		JPanel wrapperTitleMap = wrapperLabelGeneratorInventory(titleMap, 0, 0, 20, 0, true);
		baseMap.add(wrapperTitleMap);

		// Création de la grille unique
		int viewportSize = 9;

		BufferedImage initialBg = selectRandomBackground();

		JPanel grid = new JPanel(new GridLayout(viewportSize, viewportSize)) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				BufferedImage bg = (BufferedImage) getClientProperty("background");
				if (bg != null)
					g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
			}
		};

		// Stocke le background dans une propriété
		grid.putClientProperty("background", initialBg);

		grid.setOpaque(false);
		baseMap.add(grid);
		rpg.placeHero(rpg.getMainHero());
		
		// Dessine la map initiale
		GuiMapTab.drawMap(rpg, listToken, grid);


		/****************************** ADD TABS ******************************/
		
		JLabel mapTabLabel = new JLabel("Map");
		setCustomFont(mapTabLabel, Font.PLAIN, 20);

		JLabel inventoryTabLabel = new JLabel("Inventory");
		setCustomFont(inventoryTabLabel, Font.PLAIN, 20);
		
		tabPanel.addTab("Map", baseMap);
		tabPanel.setTabComponentAt(0, mapTabLabel);
		
		tabPanel.addTab("Inventory", baseInventory);
		tabPanel.setTabComponentAt(1, inventoryTabLabel);
		
		panel.add(tabPanel, BorderLayout.CENTER);

		// --- Button Potion ---
		RoundedImageButton btnPotion = new RoundedImageButton("Use Potion", icon);
		configButtons(btnPotion);
		btnPotion.addActionListener(e -> usePotion(rpg, baseInventory));
		// --- Button Menu ---
		RoundedImageButton btn = new RoundedImageButton("Menu", icon);
		configButtons(btn);
		btn.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));
		
		JPanel bottom = new JPanel();
		bottom.add(btn);
		configureBottomPanel(bottom, btnPotion);
		panel.add(bottom, BorderLayout.SOUTH);

		GuiInputController inputController = new GuiInputController(panel, btn, baseMap, rpg.getMainHero().getMovement(), rpg.getMainHero(), rpg.getMap(), rpg.getMenu(), grid, rpg, listToken, icon, baseInventory, bottom);

		return panel;
	}
}

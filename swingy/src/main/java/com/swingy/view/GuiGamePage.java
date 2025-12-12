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

import static com.swingy.utils.Constants.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Color;
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
		String inlineStats = String.format(
			"<html><div style='font-family: Ancient Modern Tales; font-size: 17px; color: #444444;'>" +
			"<i>Attack</i>: <span style='color: #008000;'>%d</span> &nbsp;&nbsp; " +
			"<i>Defense</i>: <span style='color: #008000;'>%d</span> &nbsp;&nbsp; " +
			"<i>Hit Points</i>: <span style='color: #FF0000;'>%d/%d</span>" +
			"</div></html>",
			rpg.getMainHero().getAttack(),
			rpg.getMainHero().getDefense(),
			rpg.getMainHero().getHitPoint(),
			rpg.getMainHero().getMaxHitPoint()
		);
		JLabel statsLabel = new JLabel(inlineStats);
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
		Map<JCheckBox, Artefact> checkBoxToArtefact = new HashMap<>();

		for (Artefact items : hero.getArtefacts()) {
			String name  = items.getName() + " ";
			Color color;

			switch (items.getRarity()) {
				case COMMON:
					color = Color.BLACK;
					break;
				case RARE:
					color = Color.BLUE;
					break;
				case EPIC:
					color = new Color(128, 0, 128);
					break;
				case LEGENDARY:
					color = new Color(255, 215, 0);
					break;
				default:
					color = Color.WHITE;
					break;
			}

			String bonus = "+" + items.getBonus();
			switch (items.getType()) {
				case HELM_TYPE:
					bonus += " HP";
					break;
				case WEAPON_TYPE:
					bonus += " ATT";
					break;
				case ARMOR_TYPE:
					bonus += " DEF";
					break;
				case CONSOMMABLE_TYPE:
					bonus += " HP";
					break;
			}

			String hexColor = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());
			String checkboxText = "<html><span style='color:" + hexColor + "'>" + name + bonus + "</span></html>";

			final Artefact currentItem = items;  // **Important** : variable finale locale pour la lambda

			JCheckBox checkBox = new JCheckBox(checkboxText);
			checkBox.setOpaque(false);
			checkBox.setSelected(currentItem.getIsEquipped());
			setCustomFont(checkBox, Font.PLAIN, 25);

			// Remplissage des maps
			checkBoxesByType.computeIfAbsent(currentItem.getType(), k -> new ArrayList<>()).add(checkBox);
			checkBoxToArtefact.put(checkBox, currentItem);

			checkBox.addItemListener(e -> {
				GuiInventoryController.inventoryManager(checkBoxToArtefact, checkBox, checkBoxesByType, hero, e);
				refreshInventory(rpg, baseInventory);
			});
			
			JPanel wrapperCheckBox = wrapperCheckboxGenerator(checkBox, 0, 0, 0, 0);
			baseInventory.add(wrapperCheckBox);
		}
	}
	
	/************************************************************************ RESET PAGE METHOD ************************************************************************/
	
	public static void resetPage(JPanel baseMap, Game rpg, Map<String, ImageIcon> listToken, JPanel grid, JPanel baseInventory) {
		baseMap.removeAll();
		baseMap.setLayout(new BoxLayout(baseMap, BoxLayout.Y_AXIS));
		
		// --- Title ---
		JLabel titleMap = new JLabel("Map");
		setCustomFont(titleMap, Font.BOLD, 45);
		
		JPanel wrapperTitleMap = wrapperLabelGeneratorInventory(titleMap, 0, 0, 20, 0, true);
		baseMap.add(wrapperTitleMap);
		
		// --- Background ---
		BufferedImage bg = selectRandomBackground();
		
		grid.setOpaque(false);
		grid.setLayout(new GridLayout(9, 9));
		grid = new JPanel(new GridLayout(9, 9)) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (bg != null)
					g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
			}
		};
		
		baseMap.add(grid);
		
		// --- Replace inventory if exists ---
		if (baseInventory != null)
			refreshInventory(rpg, baseInventory);
		
		// --- Update map ---
		GuiMapTab.updateMap(rpg, listToken, grid);
		
		baseMap.revalidate();
		baseMap.repaint();
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
		String inlineStats = String.format(
			"<html><div style='font-family: Ancient Modern Tales; font-size: 17px; color: #444444;'>" +
			"<i>Attack</i>: <span style='color: #008000;'>%d</span> &nbsp;&nbsp; " +
			"<i>Defense</i>: <span style='color: #008000;'>%d</span> &nbsp;&nbsp; " +
			"<i>Hit Points</i>: <span style='color: #FF0000;'>%d/%d</span>" +
			"</div></html>",
			rpg.getMainHero().getAttack(),
			rpg.getMainHero().getDefense(),
			rpg.getMainHero().getHitPoint(),
			rpg.getMainHero().getMaxHitPoint()
		);

		JLabel statsLabel = new JLabel(inlineStats);
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
		BufferedImage bg = selectRandomBackground();
		JPanel grid = new JPanel(new GridLayout(viewportSize, viewportSize)) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (bg != null) {
					g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);
				}
			}
		};
		grid.setOpaque(false);
		baseMap.add(grid);

		// Place le héros sur la map
		rpg.placeHero(rpg.getMainHero());

		GuiInputController inputController = new GuiInputController(baseMap, rpg.getMainHero().getMovement(), rpg.getMainHero(), rpg.getMap(), rpg.getMenu(), grid, rpg, listToken, icon, baseInventory);
		// Dessine la map initiale dans la grille
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

		// --- Button Menu ---
		RoundedImageButton btn = new RoundedImageButton("Menu", icon);
		configButtons(btn);
		btn.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));

		// --- Button Potion ---
		RoundedImageButton btnPotion = new RoundedImageButton("Use Potion", icon);
		configButtons(btnPotion);
		btnPotion.addActionListener(e -> usePotion(rpg, baseInventory));

		JPanel bottom = new JPanel();
		bottom.add(btn);
		configureBottomPanel(bottom, btnPotion);
		panel.add(bottom, BorderLayout.SOUTH);

		return panel;
	}
}

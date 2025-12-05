package com.swingy.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.Icon;

import com.swingy.controller.Game;
import com.swingy.controller.GuiInputController;
import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.view.components.RoundedImageButton;

import static com.swingy.utils.Constants.*;
import com.swingy.model.Maps;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.concurrent.ThreadLocalRandom;
import java.awt.image.BufferedImage;

public class GuiGamePage {

	/************************************************************************ WRAPPER BUTTON ************************************************************************/

	private static JPanel wrapperCheckboxGenerator(JCheckBox elem, int top, int left, int bottom, int right) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		wrapper.setOpaque(false);
		wrapper.add(elem);

		elem.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.GREEN, 2),
				BorderFactory.createEmptyBorder(top, left, bottom, right)
		));

		wrapper.setMaximumSize(new Dimension(
				Integer.MAX_VALUE,
				elem.getPreferredSize().height + top + bottom
		));

		wrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
		return wrapper;
	}

	/************************************************************************ WRAPPER LABEL ************************************************************************/

	private static JPanel wrapperLabelGenerator(JLabel elem, int top, int left, int bottom, int right, boolean setSize) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		wrapper.setOpaque(false);
		wrapper.add(elem);

		wrapper.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createEmptyBorder(top, left, bottom, right)
		));

		// 🔥 FIX IMPORTANT : empêche le wrapper de prendre toute la hauteur !
		if (setSize) {
			Dimension pref = wrapper.getPreferredSize();
			wrapper.setMaximumSize(new Dimension(pref.width, pref.height));
		}

		wrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
		return wrapper;
	}

	/************************************************************************ METHOD USE POTION ************************************************************************/

	private static void usePotion(Game rpg, JPanel baseInventory) {
		Artefact potion = null;

		for (Artefact items : rpg.getMainHero().getArtefacts()) {
			if (items.getType().equals(CONSOMMABLE_TYPE)) {
				rpg.healHero(items.getBonus());
				potion = items;
			}
		}
		if (potion != null)
			rpg.getMainHero().removeArtefact(potion);

		refreshInventory(rpg, baseInventory);
	}

	/************************************************************************ METHOD REFRESH CHECKBOXES ************************************************************************/

	private static void refreshInventory(Game rpg, JPanel baseInventory) {
		baseInventory.removeAll(); // vider les composants existants

		// Title
		JLabel titleInventory = new JLabel("Inventory");
		titleInventory.setFont(new Font("Ancient Modern Tales", Font.BOLD, 45));
		JPanel wrapperTitleInventory = wrapperLabelGenerator(titleInventory, 0, 0, 40, 0, true);
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
		JPanel wrapperStats = wrapperLabelGenerator(statsLabel, 0, 0, 20, 0, true);
		baseInventory.add(wrapperStats);

		// Checkboxes
		createCheckBoxes(rpg, baseInventory);

		// Forcer la mise à jour de l'affichage
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
				checkBox.setFont(new Font("Ancient Modern Tales", Font.PLAIN, 25));

				// Remplissage des maps
				checkBoxesByType.computeIfAbsent(currentItem.getType(), k -> new ArrayList<>()).add(checkBox);
				checkBoxToArtefact.put(checkBox, currentItem);

				checkBox.addItemListener(e -> {
					Artefact artefact = checkBoxToArtefact.get(checkBox);
					if (artefact == null) {
						System.err.println("Erreur : Artefact introuvable pour cette checkbox !");
						return;
					}

					if (e.getStateChange() == ItemEvent.SELECTED) {
						hero.equipArtefact(artefact);
						artefact.setIsEquipped(true);

						String type = artefact.getType();
						List<JCheckBox> sameTypeCheckBoxes = checkBoxesByType.get(type);

						for (JCheckBox cb : sameTypeCheckBoxes) {
							if (cb != checkBox && cb.isSelected()) {
								cb.setSelected(false);
								Artefact otherItem = checkBoxToArtefact.get(cb);
								if (otherItem != null)
									otherItem.setIsEquipped(false);
							}
						}
					} else if (e.getStateChange() == ItemEvent.DESELECTED) {
						hero.unequipArtefact(artefact);
						artefact.setIsEquipped(false);
					}
					refreshInventory(rpg, baseInventory);
				});
			
			JPanel wrapperCheckBox = wrapperCheckboxGenerator(checkBox, 0, 0, 0, 0);
			baseInventory.add(wrapperCheckBox);
		}
	}

	/************************************************************************ LOAD AND CONFIG TOKEN METHOD ************************************************************************/

	private static void loadToken(Map<String, ImageIcon> listToken, JPanel cell, String nameEnemy) {
		JLabel ratLabel = new JLabel(rescaleToken(listToken.get(nameEnemy)));
		ratLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ratLabel.setVerticalAlignment(SwingConstants.CENTER);
		cell.add(ratLabel);
	}


	/************************************************************************ RANDOM BACKGROUND METHOD ************************************************************************/

	private static BufferedImage selectRandomBackground() {
		int size = GuiMainWindow.getBackgrounds().size();
		int random = ThreadLocalRandom.current().nextInt(size);

		System.out.println("[MAP]: " + random);

		return (GuiMainWindow.getBackgrounds().get(random));

	}

	/************************************************************************ RESCALE TOKEN METHOD ************************************************************************/

	private static Icon rescaleToken(Icon token) {
		Image img = ((ImageIcon) token).getImage();
		Image scaled = img.getScaledInstance(65, 65, Image.SCALE_SMOOTH);
		Icon resizedToken = new ImageIcon(scaled);
		return resizedToken;
	}

	/************************************************************************ BASE STRUCTURE ************************************************************************/

	private static JPanel createBaseStructure() {
		JPanel content = new JPanel();
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		content.setAlignmentX(Component.CENTER_ALIGNMENT);
		return content;
	}

	/************************************************************************ DRAW MAP METHOD ************************************************************************/

	private static void drawMap(Game rpg, Map<String, ImageIcon> listToken, JPanel grid) {
		grid.removeAll();  // Vide la grille avant remplissage

		Maps map = rpg.getMap();
		String[][] mapTab = map.getMapTab();
		int mapSize = map.getSize();

		int viewportSize = 9;
		int halfViewport = viewportSize / 2;

		int heroX = rpg.getMainHero().getCoordinates().getX();
		int heroY = rpg.getMainHero().getCoordinates().getY();

		// Calcul bornes du viewport dans la map, en limitant aux bords
		int startX = Math.max(0, heroX - halfViewport);
		int startY = Math.max(0, heroY - halfViewport);
		int endX = Math.min(mapSize - 1, heroX + halfViewport);
		int endY = Math.min(mapSize - 1, heroY + halfViewport);

		// Ajuster si la fenêtre est plus petite que 9 (proche bord)
		if (endX - startX + 1 < viewportSize) {
			if (startX == 0)
				endX = viewportSize - 1;
			else
				startX = mapSize - viewportSize;
		}
		if (endY - startY + 1 < viewportSize) {
			if (startY == 0)
				endY = viewportSize - 1;
			else
				startY = mapSize - viewportSize;
		}

		for (int y = startY; y <= endY; y++) {
			for (int x = startX; x <= endX; x++) {
				JPanel cell = new JPanel();
				cell.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
				cell.setOpaque(false);

				switch (mapTab[x][y]) {
					case SYMBOL_MAIN_HERO:
						JLabel heroLabel = new JLabel(rescaleToken(rpg.getMainHero().getToken()));
						heroLabel.setHorizontalAlignment(SwingConstants.CENTER);
						heroLabel.setVerticalAlignment(SwingConstants.CENTER);
						cell.add(heroLabel);
						break;
					
					case SYMBOL_ENEMY:
						JLabel deadEnemyLabel = new JLabel(rescaleToken(rpg.getMainHero().getToken()));
						deadEnemyLabel.setHorizontalAlignment(SwingConstants.CENTER);
						deadEnemyLabel.setVerticalAlignment(SwingConstants.CENTER);
						cell.add(deadEnemyLabel);
						break;

					case SYMBOL_ENEMY_RAT: loadToken(listToken, cell, "rat"); break;
					case SYMBOL_ENEMY_SLIME: loadToken(listToken, cell, "slime"); break;
					case SYMBOL_ENEMY_GOBLIN: loadToken(listToken, cell, "gobelin"); break;
					case SYMBOL_ENEMY_BANDIT: loadToken(listToken, cell, "bandit"); break;
					case SYMBOL_ENEMY_BAT: loadToken(listToken, cell, "bat"); break;
					case SYMBOL_ENEMY_SPIDERLING: loadToken(listToken, cell, "spider"); break;
					case SYMBOL_ENEMY_SKELETAL_HAND: loadToken(listToken, cell, "skeletal_hand"); break;
					case SYMBOL_ENEMY_MUDLING: loadToken(listToken, cell, "mudling"); break;

					case SYMBOL_ENEMY_SKELETON: cell.setBackground(Color.ORANGE); break;
					case SYMBOL_ENEMY_WOLF: cell.setBackground(Color.ORANGE); break;
					case SYMBOL_ENEMY_CULTIST: cell.setBackground(Color.ORANGE); break;
					case SYMBOL_ENEMY_ORC: cell.setBackground(Color.ORANGE); break;
					case SYMBOL_ENEMY_BANDIT_CHIEF: cell.setBackground(Color.ORANGE); break;
					case SYMBOL_ENEMY_GOBLIN_SHAMAN: cell.setBackground(Color.ORANGE); break;
					case SYMBOL_ENEMY_WARG: cell.setBackground(Color.ORANGE); break;
					case SYMBOL_ENEMY_GRAVE_ROBBER: cell.setBackground(Color.ORANGE); break;

					case SYMBOL_ENEMY_DARK_MAGE: cell.setBackground(Color.RED); break;
					case SYMBOL_ENEMY_ELEMENTAL: cell.setBackground(Color.RED); break;
					case SYMBOL_ENEMY_TROLL: cell.setBackground(Color.RED); break;
					case SYMBOL_ENEMY_ASSASSIN: cell.setBackground(Color.RED); break;
					case SYMBOL_ENEMY_NECROMANCER: cell.setBackground(Color.RED); break;
					case SYMBOL_ENEMY_WARLOCK: cell.setBackground(Color.RED); break;
					case SYMBOL_ENEMY_SHADOW_BEAST: cell.setBackground(Color.RED); break;
					case SYMBOL_ENEMY_GOLEM: cell.setBackground(Color.RED); break;

					case SYMBOL_ENEMY_LICH: cell.setBackground(Color.YELLOW); break;
					case SYMBOL_ENEMY_MINOTAUR: cell.setBackground(Color.YELLOW); break;
					case SYMBOL_ENEMY_VAMPIRE_LORD: cell.setBackground(Color.YELLOW); break;
					case SYMBOL_ENEMY_DEMON_KNIGHT: cell.setBackground(Color.YELLOW); break;
					case SYMBOL_ENEMY_DREAD_KNIGHT: cell.setBackground(Color.YELLOW); break;
					case SYMBOL_ENEMY_PLAGUE_BRINGER: cell.setBackground(Color.YELLOW); break;
					case SYMBOL_ENEMY_PYROMANCER: cell.setBackground(Color.YELLOW); break;
					case SYMBOL_ENEMY_SPECTER: cell.setBackground(Color.YELLOW); break;

					case SYMBOL_ENEMY_DRAGON_WHELP: cell.setBackground(Color.PINK); break;
					case SYMBOL_ENEMY_ANCIENT_DRAGON: cell.setBackground(Color.PINK); break;
					case SYMBOL_ENEMY_ABYSSAL_HYDRA: cell.setBackground(Color.PINK); break;
					case SYMBOL_ENEMY_FALLEN_GOD: cell.setBackground(Color.PINK); break;
					case SYMBOL_ENEMY_DEMON_OVERLORD: cell.setBackground(Color.PINK); break;
					case SYMBOL_ENEMY_TITAN: cell.setBackground(Color.PINK); break;
					case SYMBOL_ENEMY_VOID_SERPENT: cell.setBackground(Color.PINK); break;
					case SYMBOL_ENEMY_COSMIC_DRAGON: cell.setBackground(Color.PINK); break;

					default: cell.setBackground(Color.LIGHT_GRAY); break;
				}
				grid.add(cell);
			}
		}

		grid.revalidate();
		grid.repaint();
	}

	/************************************************************************ UPDATE MAP METHOD ************************************************************************/

	public static void updateMap(Game rpg, Map<String, ImageIcon> listToken, JPanel grid) {
		drawMap(rpg, listToken, grid);
	}

	/************************************************************************ GAME PAGE BUILDER ************************************************************************/

	public static JPanel createGamePage(Game rpg, CardLayout cardLayout, JPanel cardPanel, Map<String, ImageIcon> listToken, ImageIcon icon) {

		// Main panel
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));

		// Tabs container
		JTabbedPane tabPanel = new JTabbedPane();
		tabPanel.setOpaque(false);
		tabPanel.setBackground(new Color(0, 0, 0, 0));

		tabPanel.setUI(new BasicTabbedPaneUI() {
			@Override
			protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
				g.setColor(new Color(0, 0, 0, 0));
				g.fillRect(x, y, w, h);
			}

			@Override
			protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) { }
		});

		/****************************** TAB 1 — MAP ******************************/

		JPanel baseMap = createBaseStructure();

		// Title
		JLabel titleMap = new JLabel("Map");
		titleMap.setFont(new Font("Ancient Modern Tales", Font.BOLD, 45));

		JPanel wrapperTitleMap = wrapperLabelGenerator(titleMap, 0, 0, 20, 0, true);
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

		// Crée le contrôleur en lui passant la grille (à adapter dans GuiInputController)
		GuiInputController inputController = new GuiInputController(baseMap, rpg.getMainHero().getMovement(), rpg.getMainHero(), rpg.getMap(), rpg.getMenu(), grid, rpg, listToken);

		// Dessine la map initiale dans la grille
		drawMap(rpg, listToken, grid);

		/****************************** TAB 2 — INVENTORY ******************************/

		JPanel baseInventory = createBaseStructure();

		// Title
		JLabel titleInventory = new JLabel("Inventory");
		titleInventory.setFont(new Font("Ancient Modern Tales", Font.BOLD, 45));

		JPanel wrapperTitleInventory = wrapperLabelGenerator(titleInventory, 0, 0, 40, 0, true);
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
		JPanel wrapperStats = wrapperLabelGenerator(statsLabel, 0, 0, 20, 0, true);
		baseInventory.add(wrapperStats);

		// Checkboxes
		createCheckBoxes(rpg, baseInventory);

		/****************************** ADD TABS ******************************/

		JLabel mapTabLabel = new JLabel("Map");
		mapTabLabel.setFont(new Font("Ancient Modern Tales", Font.PLAIN, 20));

		JLabel inventoryTabLabel = new JLabel("Inventory");
		inventoryTabLabel.setFont(new Font("Ancient Modern Tales", Font.PLAIN, 20));

		tabPanel.addTab("Map", baseMap);
		tabPanel.setTabComponentAt(0, mapTabLabel);

		tabPanel.addTab("Inventory", baseInventory);
		tabPanel.setTabComponentAt(1, inventoryTabLabel);

		panel.add(tabPanel, BorderLayout.CENTER);

		// --- Button Menu ---
		RoundedImageButton btn = new RoundedImageButton("Menu", icon);
		btn.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btn.setPreferredSize(new Dimension(150, 48));
		btn.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));

		// --- Button Potion ---
		RoundedImageButton btnPotion = new RoundedImageButton("Use Potion", icon);
		btnPotion.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btnPotion.setPreferredSize(new Dimension(150, 48));
		btnPotion.addActionListener(e -> usePotion(rpg, baseInventory));

		JPanel bottom = new JPanel();
		bottom.setOpaque(false);
		bottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
		bottom.add(btn);
		// bottom.add(btnRefresh);
		bottom.add(btnPotion);
		panel.add(bottom, BorderLayout.SOUTH);

		return panel;
	}
}

package com.swingy.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import com.swingy.controller.Game;
import com.swingy.model.Artefact;
import com.swingy.model.Characters;
import com.swingy.view.components.RoundedImageButton;

import static com.swingy.utils.Constants.*;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
				});
			
			JPanel wrapperCheckBox = wrapperCheckboxGenerator(checkBox, 0, 0, 0, 0);
			baseInventory.add(wrapperCheckBox);
		}
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

	/************************************************************************ GAME PAGE BUILDER ************************************************************************/

	public static JPanel createGamePage(Game rpg, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon) {

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
			protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex,
											  int x, int y, int w, int h, boolean isSelected) {
				g.setColor(new Color(0, 0, 0, 0));
				g.fillRect(x, y, w, h);
			}

			@Override
			protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) { }
		});

		/****************************** TAB 1 — MAP ******************************/

		JPanel map = new JPanel();
		map.setOpaque(false);
		map.setBackground(new Color(0, 0, 0, 0));

		JLabel mapLabel = new JLabel("Map");
		mapLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 45));
		mapLabel.setOpaque(false);
		map.add(mapLabel);

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

		tabPanel.addTab("Map", map);
		tabPanel.setTabComponentAt(0, mapTabLabel);

		tabPanel.addTab("Inventory", baseInventory);
		tabPanel.setTabComponentAt(1, inventoryTabLabel);

		panel.add(tabPanel, BorderLayout.CENTER);

		// --- Button Menu ---
		RoundedImageButton btn = new RoundedImageButton("Menu", icon);
		btn.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btn.setPreferredSize(new Dimension(150, 48));
		btn.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));

		// --- Button Refresh ---
		RoundedImageButton btnRefresh = new RoundedImageButton("Refresh", icon);
		btnRefresh.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btnRefresh.setPreferredSize(new Dimension(150, 48));
		btnRefresh.addActionListener(e -> refreshInventory(rpg, baseInventory));

		// --- Button Potion
		RoundedImageButton btnPotion = new RoundedImageButton("Use Potion", icon);
		btnPotion.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btnPotion.setPreferredSize(new Dimension(150, 48));
		btnPotion.addActionListener(e -> usePotion(rpg, baseInventory));

		JPanel bottom = new JPanel();
		bottom.setOpaque(false);
		bottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
		bottom.add(btn);
		bottom.add(btnRefresh);
		bottom.add(btnPotion);
		panel.add(bottom, BorderLayout.SOUTH);

		return panel;
	}
}

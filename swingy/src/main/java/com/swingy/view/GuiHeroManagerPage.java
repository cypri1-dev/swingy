package com.swingy.view;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import com.swingy.controller.Game;
import com.swingy.model.Characters;
import com.swingy.view.components.RoundedImageButton;
import static com.swingy.utils.Constants.*;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Component;

public class GuiHeroManagerPage {

	private static JComboBox<String> choiceComboBox = null;

	/************************************************************************ CONSTRUCTOR ************************************************************************/

	private static JPanel createBaseStructure() {
		JPanel content = new JPanel();
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createLineBorder(Color.GREEN, 0));

		return content;
	}

	/************************************************************************ CONFIGURATION BUTTONS ************************************************************************/

	private static void configureConfirmButton( RoundedImageButton elem, String selectedName, JComboBox<String> choiceComboBox, JLabel hiddenNameLabel, JPanel hiddenNameLabelWrapper, JPanel base, Game rpg) {
		elem.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		elem.setPreferredSize(new Dimension(150, 48));

		elem.addActionListener(e -> {
			String selectedHeroName = (String) choiceComboBox.getSelectedItem();
			if (selectedHeroName == null) {
				hiddenNameLabel.setText("<html><div style='color:red; text-align:center;'>No hero selected!</div></html>");
				hiddenNameLabel.setVisible(true);
				hiddenNameLabelWrapper.repaint();
				hiddenNameLabelWrapper.revalidate();
				return;
			}
			Characters hero = null;
			for (Characters target : rpg.getListAvaible()) {
				if (target.getName().equals(selectedHeroName)) {
					hero = target;
					break;
				}
			}
			if (hero == null) {
				hiddenNameLabel.setText("<html><div style='color:red; text-align:center;'>Hero not found!</div></html>");
				hiddenNameLabel.setVisible(true);
				hiddenNameLabelWrapper.repaint();
				hiddenNameLabelWrapper.revalidate();
				return;
			}

			// Construction du HTML (style console → html)
			StringBuilder sb = new StringBuilder("<html><div style='font-family: Ancient Modern Tales; font-size: 17px; color: #444444;'>");

			// Titre
			sb.append("<div style='font-weight: bold; font-size: 25px; margin-bottom: 10px;'>⚔️ ")
			.append(hero.getName())
			.append(" the ")
			.append(hero.getCharacterClass().toUpperCase())
			.append(" ⚔️")
			.append("</div>");

			// Stats de base (Level, XP)
			sb.append("<div><i>Level</i>: <span style='color: #ff3c00ff;'>")
			.append(hero.getLevel())
			.append("</span> &nbsp;&nbsp; <i>XP</i>: <span style='color: #ff3c00ff;'>")
			.append(hero.getXp())
			.append("</span></div>");

			// Attack, Defense
			sb.append("<div><i>Attack</i>: <span style='color: #008000;'>")
			.append(hero.getAttack())
			.append("</span> &nbsp;&nbsp; <i>Defense</i>: <span style='color: #008000;'>")
			.append(hero.getDefense())
			.append("</span></div>");

			// Hit Points
			sb.append("<div><i>Hit Points</i>: <span style='color: #FF0000;'>")
			.append(hero.getHitPoint())
			.append("/")
			.append(hero.getMaxHitPoint())
			.append("</span></div>");

			// Bag contents
			sb.append("<div><i>Bag contents:</i></div>");
			if (hero.getArtefacts().isEmpty()) {
				sb.append("<div style='margin-left: 15px; color: #FF0000;'>Empty bag.</div>");
			} else {
				for (var item : hero.getArtefacts()) {
					String equippedMark = item.getIsEquipped() ? "<span style='color:#008000;'>  (E)</span>" : "";

					// Couleur selon la rareté
					String color;
					switch (item.getRarity()) {
						case COMMON -> color = "#A0A0A0"; // gris clair
						case RARE -> color = "#0000FF";   // bleu
						case EPIC -> color = "#800080";   // violet
						case LEGENDARY -> color = "#FFA500"; // orange
						default -> color = "#000000";
					}

					// Type
					String type;
					switch (item.getType()) {
						case CONSOMMABLE_TYPE -> type = "HP";
						case WEAPON_TYPE -> type = "ATT";
						case ARMOR_TYPE -> type = "DEF";
						case HELM_TYPE -> type = "HP";
						default -> type = "";
					}

					sb.append("<div style='margin-left: 15px;'>• <span style='color: ")
					.append(color)
					.append("; font-style: italic;'>")
					.append(item.getName())
					.append(" (+")
					.append(item.getBonus())
					.append(") ")
					.append(type)
					.append("</span>")
					.append(equippedMark)
					.append("</div>");
				}
			}

			sb.append("</div></html>");

			hiddenNameLabel.setText(sb.toString());
			hiddenNameLabel.setVisible(true);
			hiddenNameLabelWrapper.repaint();
			hiddenNameLabelWrapper.revalidate();
			base.repaint();
		});
	}

	private static void configureDeleteButton(RoundedImageButton btnDelete, Game rpg, JLabel hiddenNameLabel, JPanel hiddenNameLabelWrapper, JPanel base) {
		btnDelete.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btnDelete.setPreferredSize(new Dimension(150, 48));

		btnDelete.addActionListener(e -> {
			String selectedHeroName = (String) choiceComboBox.getSelectedItem();
			if (selectedHeroName != null) {
				Characters target = null;
				for (Characters elem : rpg.getListAvaible()) {
					if (elem.getName().equals(selectedHeroName)) {
						target = elem;
						break;
					}
				}
				if (target != null) {
					rpg.getHeroesNameList().remove(selectedHeroName);
					rpg.getListAvaible().remove(target);
				}
				updateHeroComboBox(rpg);
				hiddenNameLabel.setText("<html><div style='color:red; text-align:center;'>Hero deleted!</div></html>");
				hiddenNameLabel.setVisible(true);
				hiddenNameLabelWrapper.repaint();
				hiddenNameLabelWrapper.revalidate();
				base.repaint();
			}
		});
	}

	/************************************************************************ CONFIGURATION JSCROLLPANE ************************************************************************/

	private static void configureJScrollPane(JScrollPane scrollPane) {
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.GREEN, 0));
	}

	/************************************************************************ CONFIGURATION JCOMBOBOX ************************************************************************/

	private static void configureComboBox(JComboBox<String> elem) {
		elem.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 25));
		/* Centrer les éléments */
		elem.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				lbl.setHorizontalAlignment(SwingConstants.CENTER);
				return lbl;
			}
		});
	}

	/************************************************************************ CONFIGURATION HIDDENLABEL ************************************************************************/

	private static void configureHiddenLabel(JLabel elem) {
		elem.setVisible(false);
		elem.setFont(new Font("Ancient Modern Tales", Font.PLAIN, 20));
		elem.setHorizontalAlignment(SwingConstants.CENTER);
	}

	/************************************************************************ WRAPPER BUTTON ************************************************************************/

	private static JPanel wrapperButtonGenerator(RoundedImageButton elem, int top, int left, int bottom, int right) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		wrapper.setOpaque(false);
		wrapper.add(elem);
		elem.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.GREEN, 0),
				BorderFactory.createEmptyBorder(top, left, bottom, right)
		));
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height));

		return wrapper;
	}

	/************************************************************************ WRAPPER COMBOBOX ************************************************************************/

	private static JPanel wrapperComboBoxGenerator(JComboBox<String> elem, int top, int left, int bottom, int right) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		wrapper.setOpaque(false);
		wrapper.add(elem);
		wrapper.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.ORANGE, 0),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
		));
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height + 40));

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
		if (setSize)
			wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height));

		return wrapper;
	}

	/************************************************************************ UPDATE COMBOBOX METHOD ************************************************************************/

		// Mets à jour le modèle de la combo box existante
	public static void updateHeroComboBox(Game rpg) {
		if (choiceComboBox != null) {
			choiceComboBox.setModel(new DefaultComboBoxModel<>(rpg.getHeroesNameList().toArray(new String[0])));
		}
	}

	/************************************************************************ VIEW PAGE BUILDER METHOD ************************************************************************/

	public static JPanel createViewPage(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon, Game rpg) {

		// --- Panel à retourner ---
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 0));

		// --- Zone verticale principale ---
		JPanel base = createBaseStructure();
		panel.add(base, BorderLayout.CENTER);

		// --- Label Titre ---
		JLabel titleLabel = new JLabel(title);
		titleLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 60));

		JPanel titleLabelWrapper = wrapperLabelGenerator(titleLabel, 60, 0, 20, 0, true);
		base.add(titleLabelWrapper);

		// --- Label Hero ---
		JLabel nameLabel = new JLabel("<html><div align=center>"
				+ "<span style='font-size:10px;'>ᛁᚾ ᛖᚲᛊᛈᛚᛟᚱᛖᛁ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖ </span>"
				+ " - Choose a hero -"
				+ "<span style='font-size:10px;'> ᚾ ᛖᚲᛊᛈᛚᛟᚱᛖᛁ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖ</span>"
				+ "</div></html>");
		nameLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));

		JPanel nameLabelWrapper = wrapperLabelGenerator(nameLabel, 10, 10, 10, 10, true);
		base.add(nameLabelWrapper);

		// --- Combobox ---
		if (choiceComboBox == null) {
			String[] array = rpg.getHeroesNameList().toArray(new String[0]);
			choiceComboBox = new JComboBox<>(array);
			configureComboBox(choiceComboBox);
			JPanel choiceWrapper = wrapperComboBoxGenerator(choiceComboBox, 10, 10, 10, 10);
			base.add(choiceWrapper);
		} else {
			updateHeroComboBox(rpg);
		}

		// --- Label Hidden ---
		JLabel hiddenNameLabel = new JLabel(" ");
		configureHiddenLabel(hiddenNameLabel);

		JPanel hiddenNameLabelWrapper = wrapperLabelGenerator(hiddenNameLabel, 20, 0, 0, 0, false);

		// Création du JScrollPane autour du label
		JScrollPane scrollPane = new JScrollPane(hiddenNameLabel);
		// scrollPane.setOpaque(false);
		// scrollPane.getViewport().setOpaque(false);
		// scrollPane.setBorder(BorderFactory.createLineBorder(Color.GREEN, 0));
		configureJScrollPane(scrollPane);

		// --- Button Confirm ---
		RoundedImageButton btnConfirm = new RoundedImageButton("Confirm", icon);
		String selectedName = (String) choiceComboBox.getSelectedItem();
		configureConfirmButton(btnConfirm, selectedName, choiceComboBox, hiddenNameLabel, hiddenNameLabelWrapper, base, rpg);

		RoundedImageButton btnDelete = new RoundedImageButton("Delete", icon);
		configureDeleteButton(btnDelete, rpg, hiddenNameLabel, hiddenNameLabelWrapper, base);

		// Panel pour contenir les deux boutons côte à côte
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		buttonsPanel.setOpaque(false);
		buttonsPanel.add(wrapperButtonGenerator(btnConfirm, 0, 0, 0, 0));
		buttonsPanel.add(wrapperButtonGenerator(btnDelete, 0, 0, 0, 0));

		base.add(buttonsPanel);
		base.add(Box.createVerticalStrut(20));
		base.add(scrollPane);
		base.add(hiddenNameLabelWrapper);

		// --- Button Menu ---
		RoundedImageButton btn = new RoundedImageButton("Menu", icon);
		btn.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btn.setPreferredSize(new Dimension(150, 48));
		btn.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));

		JPanel bottom = new JPanel();
		bottom.setOpaque(false);
		bottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
		bottom.add(btn);
		panel.add(bottom, BorderLayout.SOUTH);

		return panel;

	}

}


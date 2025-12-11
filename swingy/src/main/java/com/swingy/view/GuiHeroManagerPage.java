package com.swingy.view;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.swingy.controller.Game;
import com.swingy.controller.GuiHeroManagementController;
import com.swingy.view.components.RoundedImageButton;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.FlowLayout;

public class GuiHeroManagerPage extends GuiCustomPage {

	private static JComboBox<String> choiceComboBox = null;

	/************************************************************************ CONFIGURATION BUTTONS ************************************************************************/

	private static void configureConfirmButton(RoundedImageButton elem, String selectedName, JComboBox<String> choiceComboBox, JLabel hiddenNameLabel, JPanel hiddenNameLabelWrapper, JPanel base, Game rpg) {
		configButtons(elem);

		elem.addActionListener(e -> {
			String selectedHeroName = (String) choiceComboBox.getSelectedItem();
			String txt = GuiHeroManagementController.displaySelectedHero(selectedHeroName, rpg);

			hiddenNameLabel.setText(txt);
			hiddenNameLabel.setVisible(true);
			hiddenNameLabelWrapper.repaint();
			hiddenNameLabelWrapper.revalidate();
			base.repaint();
		});
	}

	private static void configureDeleteButton(RoundedImageButton btnDelete, Game rpg, JLabel hiddenNameLabel, JPanel hiddenNameLabelWrapper, JPanel base) {
		configButtons(btnDelete);

		btnDelete.addActionListener(e -> {
			String selectedHeroName = (String) choiceComboBox.getSelectedItem();
			String txt = GuiHeroManagementController.deleteHero(selectedHeroName, rpg);

			updateHeroComboBox(rpg);
			GuiPlayPage.updateHeroComboBox(rpg);

			hiddenNameLabel.setText(txt);
			hiddenNameLabel.setVisible(true);
			hiddenNameLabelWrapper.repaint();
			hiddenNameLabelWrapper.revalidate();
			base.repaint();
			});
	}

	/************************************************************************ UPDATE COMBOBOX METHOD ************************************************************************/

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

		// --- Zone verticale principale ---
		JPanel base = createBaseStructure();
		panel.add(base, BorderLayout.CENTER);

		// --- Label Titre ---
		JLabel titleLabel = new JLabel(title);
		setCustomFont(titleLabel, Font.BOLD, 60);

		JPanel titleLabelWrapper = wrapperLabelGenerator(titleLabel, 60, 0, 20, 0, true, true);
		base.add(titleLabelWrapper);

		// --- Label Hero ---
		JLabel nameLabel = new JLabel("<html><div align=center>"
				+ "<span style='font-size:10px;'>ᛁᚾ ᛖᚲᛊᛈᛚᛟᚱᛖᛁ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖ </span>"
				+ " - Choose a hero -"
				+ "<span style='font-size:10px;'> ᚾ ᛖᚲᛊᛈᛚᛟᚱᛖᛁ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖ</span>"
				+ "</div></html>");
		setCustomFont(nameLabel, Font.BOLD, 25);

		JPanel nameLabelWrapper = wrapperLabelGenerator(nameLabel, 10, 10, 10, 10, true, true);
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

		JPanel hiddenNameLabelWrapper = wrapperLabelGenerator(hiddenNameLabel, 20, 0, 0, 0, true, false);

		// Création du JScrollPane autour du label
		JScrollPane scrollPane = new JScrollPane(hiddenNameLabel);
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
		configButtons(btn);
		btn.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));

		JPanel bottom = new JPanel();
		configureBottomPanel(bottom, btn);
		panel.add(bottom, BorderLayout.SOUTH);

		return panel;
	}

	/************************************************************************ GETTERS ************************************************************************/

	public static JComboBox<String> getComboBox() {return choiceComboBox;}
}


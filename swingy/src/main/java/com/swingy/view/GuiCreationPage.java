package com.swingy.view;

import com.swingy.view.components.RoundedImageButton;
import com.swingy.controller.CreationController;
import com.swingy.controller.Game;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.Dimension;


public class GuiCreationPage extends GuiCustomPage {

	/************************************************************************ CONFIGURATION CONFIRM BUTTON ************************************************************************/

	private static void configureConfirmButton (RoundedImageButton elem, JTextField inputName, JComboBox<String> choiceComboBox, JLabel hiddenNameLabel, JPanel hiddenNameLabelWrapper, JPanel base, Game rpg) {
		setCustomFont(elem, Font.BOLD, 25);
		elem.setPreferredSize(new Dimension(150, 48));

		elem.addActionListener(e -> {
			String txt = CreationController.createHero(rpg, inputName, choiceComboBox);
			hiddenNameLabel.setText(txt);
			hiddenNameLabel.setVisible(true);
			hiddenNameLabelWrapper.repaint();
			hiddenNameLabelWrapper.revalidate();
			base.repaint();
		});
	}

	/************************************************************************ CONFIGURATION HIDDEN LABEL ************************************************************************/

	private static void configureHiddenLabel(JLabel elem) {
		elem.setVisible(false);
		setCustomFont(elem, Font.PLAIN, 20);
		elem.setHorizontalAlignment(SwingConstants.CENTER);
	}

	/************************************************************************ CONFIGURATION COMBOBOX ************************************************************************/

	private static void configureComboBox(JComboBox<String> elem) {
		setCustomFont(elem, Font.ITALIC, 25);
		/* Center items */
		elem.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				lbl.setHorizontalAlignment(SwingConstants.CENTER);
				return lbl;
			}
		});
	}

	/************************************************************************ CONFIGURATION JTEXTFIELD ************************************************************************/

	private static void configureJTextField(JTextField elem) {
		elem.setOpaque(false);
		setCustomFont(elem, Font.ITALIC, 25);
		elem.setColumns(15);
		elem.setHorizontalAlignment(JTextField.CENTER);
	}

	/************************************************************************ CREATION PAGE BUIDER METHOD ************************************************************************/

	public static JPanel createCreationPage(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon, Game rpg) {

		// --- Panel/Card a return ---
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);

		// --- Zone verticale principale ---
		JPanel base = createBaseStructure();
		panel.add(base, BorderLayout.CENTER);

		// --- Titre ---
		JLabel titleLabel = new JLabel(title);
		setCustomFont(titleLabel, Font.BOLD, 60);

		JPanel titleLabelWrapper = wrapperLabelGenerator(titleLabel, 60, 0, 20, 0, true, true);
		base.add(titleLabelWrapper);

		// --- Label Name ---
		JLabel nameLabel = new JLabel("<html><div align=center>"
				+ "<span style='font-size:10px;'>ᛁᚾ ᛖᚲᛊᛈᛚᛟᚱᛖᛁ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖ </span>"
				+ " - Choose a name -"
				+ "<span style='font-size:10px;'> ᚾ ᛖᚲᛊᛈᛚᛟᚱᛖᛁ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖ</span>"
				+ "</div></html>");
		setCustomFont(nameLabel, Font.BOLD, 25);

		JPanel nameLabelWrapper = wrapperLabelGenerator(nameLabel, 10, 10, 10, 10, true, true);
		base.add(nameLabelWrapper);

		// --- InputName ---
		JTextField inputName = new JTextField("Enter name");
		configureJTextField(inputName);

		JPanel inputNameWrapper = wrapperJTextFieldGenerator(inputName);
		base.add(inputNameWrapper);

		// --- Label Class ---
		JLabel classType = new JLabel("<html><div align=center>"
				+ "<span style='font-size:10px;'>ᛁᚾ ᛖᚲᛊᛈᛚᛟᚱᛖᛁ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖ </span>"
				+ " - Select a class -"
				+ "<span style='font-size:10px;'> ᚾ ᛖᚲᛊᛈᛚᛟᚱᛖᛁ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖ</span>"
				+ "</div></html>");
		setCustomFont(classType, Font.BOLD, 25);

		JPanel classTypeWrapper = wrapperLabelGenerator(classType, 10, 10, 10, 10, true, true);
		base.add(classTypeWrapper);

		// --- Combobox ---
		JComboBox<String> choiceComboBox = new JComboBox<>(new String[]{"Warrior", "Mage", "Archer", "Paladin", "Assassin"});
		configureComboBox(choiceComboBox);

		JPanel choiceWrapper = wrapperComboBoxGenerator(choiceComboBox, 10, 10, 10, 10);
		base.add(choiceWrapper);

		// --- Label Hidden ---
		JLabel hiddenNameLabel = new JLabel(" ");
		configureHiddenLabel(hiddenNameLabel);

		JPanel hiddenNameLabelWrapper = wrapperLabelGenerator(hiddenNameLabel, 20, 0, 0, 0, true, false);

		// --- Button Confirm ---
		RoundedImageButton btnConfirm = new RoundedImageButton("Confirm", icon);
		configureConfirmButton(btnConfirm, inputName, choiceComboBox, hiddenNameLabel, hiddenNameLabelWrapper, base, rpg);

		JPanel btnConfirmWrapper = wrapperButtonGenerator(btnConfirm, 0, 0, 0, 0);
		base.add(btnConfirmWrapper);
		base.add(hiddenNameLabelWrapper);

		// --- Button Menu ---
		RoundedImageButton btn = new RoundedImageButton("Menu", icon);
		Dimension size = new Dimension(150, 48);

		configButtons(btn, size);
		btn.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));

		JPanel bottom = new JPanel();
		configureBottomPanel(bottom, btn);
		panel.add(bottom, BorderLayout.SOUTH);

		return panel;
	}
}

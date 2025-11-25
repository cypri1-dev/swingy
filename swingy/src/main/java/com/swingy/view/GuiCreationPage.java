package com.swingy.view;

import com.swingy.view.components.RoundedImageButton;
import com.swingy.controller.Game;
import com.swingy.model.CharactersFactory;
import com.swingy.model.Characters;

import static com.swingy.utils.Constants.*;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Dimension;

import java.util.Set;

public class GuiCreationPage {

	/************************************************************************ CONFIGURATION CONFIRM BUTTON ************************************************************************/

	private static void configureConfirmButton (RoundedImageButton elem, JTextField inputName, JComboBox<String> choiceComboBox, JLabel hiddenNameLabel, JPanel hiddenNameLabelWrapper, JPanel base, Game rpg) {
		elem.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		elem.setPreferredSize(new Dimension(150, 48));

		Set<String> forbiddenChars = Set.of("|", ",", "*", "%", "=", "{", "}");

		elem.addActionListener(e -> {
			String txt;
			String getName = inputName.getText().trim();
			String getSelectedClass = (String) choiceComboBox.getSelectedItem();
			boolean hasForbiddenChar = forbiddenChars.stream().anyMatch(getName::contains);
			boolean invalidName = getName.isEmpty() || rpg.heroExists(getName) || hasForbiddenChar;

			if (invalidName || getName.equalsIgnoreCase("x")) {
				txt = "<html><div align='center' style='color: red;'>"
					+ "Name already exists or contains Forbidden characters!<br/>"
					+ "<b>Try again</b>"
					+ "</div></html>";
			}
			else {
				rpg.registerHeroName(getName);
				String characterClass = switch (getSelectedClass) {
					case "Warrior" -> WARRIOR_CLASS;
					case "Mage" -> MAGE_CLASS;
					case "Archer" -> ARCHER_CLASS;
					case "Paladin" -> PALADIN_CLASS;
					case "Assassin" -> ASSASSIN_CLASS;
					default -> "";
				};
				Characters newHero = CharactersFactory.getInstance().newCharacters(HERO_TYPE, getName, characterClass);
				String att = Integer.toString(newHero.getAttack());
				String def = Integer.toString(newHero.getDefense());
				String hp = Integer.toString(newHero.getMaxHitPoint());

				rpg.getListAvaible().add(CharactersFactory.getInstance().newCharacters(HERO_TYPE, getName, characterClass));
				GuiHeroManagerPage.updateHeroComboBox(rpg);
				txt = "<html><div align='center'>"
					+ "NAME<br/>"
					+ "<b style='font-size: 25px'>" + getName + "</b><br/><br/>"
					+ "CLASS<br/>"
					+ "<b style='font-size: 25px'>" + getSelectedClass + "</b><br/><br/>"
					+ "ATT<br/>"
					+ "<b style='font-size: 25px'>" + att + "</b><br/><br/>"
					+ "DEF<br/>"
					+ "<b style='font-size: 25px'>" + def + "</b><br/><br/>"
					+ "HP<br/>"
					+ "<b style='font-size: 25px'>" + hp + "</b>"
					+ "</div></html>";
			}
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
		elem.setFont(new Font("Ancient Modern Tales", Font.PLAIN, 20));
		elem.setHorizontalAlignment(SwingConstants.CENTER);
	}

	/************************************************************************ CONFIGURATION COMBOBOX ************************************************************************/

	private static void configureComboBox(JComboBox<String> elem) {
		elem.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 25));
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
		elem.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 25));
		elem.setColumns(15);
		elem.setHorizontalAlignment(JTextField.CENTER);
	}

	/************************************************************************ WRAPPER BUTTON ************************************************************************/

	private static JPanel wrapperButtonGenerator(RoundedImageButton elem, int top, int left, int bottom, int right) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		wrapper.setOpaque(false);
		wrapper.add(elem);
		elem.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(Color.GREEN, 2),
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

	/************************************************************************ WRAPPER JTEXTFIELD ************************************************************************/

	private static JPanel wrapperJTextFieldGenerator(JTextField elem) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		wrapper.setOpaque(false);
		wrapper.add(elem);
		elem.setBorder(BorderFactory.createEmptyBorder());
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height));

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

	/************************************************************************ METHOD BASE STRUCTURE BUILDER ************************************************************************/

	private static JPanel createBaseStructure() {
		JPanel content = new JPanel();
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createLineBorder(Color.GREEN, 0));

		return content;
	}

	/************************************************************************ CREATION PAGE BUIDER METHOD ************************************************************************/

	public static JPanel createCreationPage(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon, Game rpg) {

		// --- Panel/Card a return ---
		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 0));

		// --- Zone verticale principale ---
		JPanel base = createBaseStructure();
		panel.add(base, BorderLayout.CENTER);

		// --- Titre ---
		JLabel titleLabel = new JLabel(title);
		titleLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 60));

		JPanel titleLabelWrapper = wrapperLabelGenerator(titleLabel, 60, 0, 20, 0, true);
		base.add(titleLabelWrapper);

		// --- Label Name ---
		JLabel nameLabel = new JLabel("<html><div align=center>"
				+ "<span style='font-size:10px;'>ᛁᚾ ᛖᚲᛊᛈᛚᛟᚱᛖᛁ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖ </span>"
				+ " - Choose a name -"
				+ "<span style='font-size:10px;'> ᚾ ᛖᚲᛊᛈᛚᛟᚱᛖᛁ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖ</span>"
				+ "</div></html>");
		nameLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));

		JPanel nameLabelWrapper = wrapperLabelGenerator(nameLabel, 10, 10, 10, 10, true);
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
		classType.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));

		JPanel classTypeWrapper = wrapperLabelGenerator(classType, 10, 10, 10, 10, true);
		base.add(classTypeWrapper);

		// --- Combobox ---
		JComboBox<String> choiceComboBox = new JComboBox<>(new String[]{"Warrior", "Mage", "Archer", "Paladin", "Assassin"});
		configureComboBox(choiceComboBox);

		JPanel choiceWrapper = wrapperComboBoxGenerator(choiceComboBox, 10, 10, 10, 10);
		base.add(choiceWrapper);

		// --- Label Hidden ---
		JLabel hiddenNameLabel = new JLabel(" ");
		configureHiddenLabel(hiddenNameLabel);

		JPanel hiddenNameLabelWrapper = wrapperLabelGenerator(hiddenNameLabel, 20, 0, 0, 0, false);

		// --- Button Confirm ---
		RoundedImageButton btnConfirm = new RoundedImageButton("Confirm", icon);
		configureConfirmButton(btnConfirm, inputName, choiceComboBox, hiddenNameLabel, hiddenNameLabelWrapper, base, rpg);

		JPanel btnConfirmWrapper = wrapperButtonGenerator(btnConfirm, 0, 0, 0, 0);
		base.add(btnConfirmWrapper);
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

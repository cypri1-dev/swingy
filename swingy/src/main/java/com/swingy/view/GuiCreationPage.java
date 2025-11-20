package com.swingy.view;

import com.swingy.view.components.RoundedImageButton;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.BorderFactory;
import javax.swing.Box;
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

public class GuiCreationPage {

	/* ---------------------- METHOD FOR CREATION_PAGE CREATION ----------------------*/

	public static JPanel createCreationPage(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon) {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 0));

		// --- Zone verticale principale ---
		JPanel content = new JPanel();
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createLineBorder(Color.GREEN, 0));
		panel.add(content, BorderLayout.CENTER);

		// --- Titre ---
		JLabel label = new JLabel(title);
		label.setFont(new Font("Ancient Modern Tales", Font.BOLD, 60));

		JPanel labelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		labelWrapper.setOpaque(false);
		labelWrapper.add(label);
		labelWrapper.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.WHITE, 0),
				BorderFactory.createEmptyBorder(60, 0, 20, 0)
		));
		labelWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, labelWrapper.getPreferredSize().height));
		content.add(labelWrapper);

		// --- Label Name ---
		JLabel name = new JLabel("<html><div align=center>"
				+ "ᛁᚾ ᛖᚲᛊᛈᛚᛟᚱᛖ - Choose a name - ᛁᚾ ᚨᛖᚲᛊᛈᛚᛟᚱᛖ"
				+ "</div></html>");
		name.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));

		JPanel nameWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		nameWrapper.setOpaque(false);
		nameWrapper.add(name);
		nameWrapper.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLUE, 0),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
		));
		nameWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, nameWrapper.getPreferredSize().height));
		content.add(nameWrapper);

		// --- InputName ---
		JTextField inputName = new JTextField("Enter name");
		inputName.setOpaque(false);
		inputName.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 25));
		inputName.setColumns(15);
		inputName.setHorizontalAlignment(JTextField.CENTER);

		JPanel inputNameWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		inputNameWrapper.setOpaque(false);
		inputNameWrapper.add(inputName);
		inputName.setBorder(BorderFactory.createEmptyBorder());
		inputNameWrapper.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.GRAY, 0),
				BorderFactory.createEmptyBorder(10, 10, 20, 10)
		));
		inputNameWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, inputNameWrapper.getPreferredSize().height));
		content.add(inputNameWrapper);

		// --- Label Class ---
		JLabel classType = new JLabel("<html><div align=center>"
				+ "ᛁᚾ ᛖᚲᛊᛈᛚᛟᚱᛖ - Select a class - ᛁᚾ ᚨᛖᚲᛊᛈᛚᛟᚱᛖ"
				+ "</div></html>");
		classType.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));

		JPanel classTypeWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		classTypeWrapper.setOpaque(false);
		classTypeWrapper.add(classType);
		classTypeWrapper.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
		));
		classTypeWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, classTypeWrapper.getPreferredSize().height));
		content.add(classTypeWrapper);

		// --- Combobox ---
		JComboBox<String> choice = new JComboBox<>(new String[]{"Warrior", "Mage", "Archer", "Paladin", "Assassin"});
		choice.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 25));
		/* Center items */
		choice.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				JLabel lbl = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				lbl.setHorizontalAlignment(SwingConstants.CENTER);
				return lbl;
			}
		});

		JPanel choiceWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		choiceWrapper.setOpaque(false);
		choiceWrapper.add(choice);
		choiceWrapper.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.ORANGE, 1),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)
		));
		choiceWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, choice.getPreferredSize().height + 40));
		content.add(choiceWrapper);

		// --- Button Confirm ---
		RoundedImageButton btnConfirm = new RoundedImageButton("Confirm", icon);
		btnConfirm.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btnConfirm.setPreferredSize(new Dimension(150, 48));
		btnConfirm.addActionListener(e -> {
			String getName = inputName.getText();
			String getSelectedClass = (String) choice.getSelectedItem();
		});

		JPanel btnConfirmWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		btnConfirmWrapper.setOpaque(false);
		btnConfirmWrapper.add(btnConfirm);
		btnConfirm.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(Color.GREEN, 2),
			BorderFactory.createEmptyBorder(0, 0, 0, 0)
		));
		btnConfirmWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnConfirm.getPreferredSize().height));
		content.add(btnConfirmWrapper);

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

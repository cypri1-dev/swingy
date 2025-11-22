package com.swingy.view;

import com.swingy.view.components.RoundedImageButton;

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

public class GuiCreationPage {

	/* ---------------------- METHOD FOR CREATION_PAGE CREATION ----------------------*/

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

	private static void configureJTextField(JTextField elem) {
		elem.setOpaque(false);
		elem.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 25));
		elem.setColumns(15);
		elem.setHorizontalAlignment(JTextField.CENTER);
	}

	private static JPanel wrapperComboBoxGenerator(JComboBox elem, int top, int left, int bottom, int right) {
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

	private static JPanel wrapperJTextFieldGenerator(JTextField elem) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		wrapper.setOpaque(false);
		wrapper.add(elem);
		elem.setBorder(BorderFactory.createEmptyBorder());
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height));

		return wrapper;
	}

	private static JPanel wrapperLabelGenerator(JLabel elem, int top, int left, int bottom, int right) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		wrapper.setOpaque(false);
		wrapper.add(elem);
		wrapper.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.BLACK, 0),
				BorderFactory.createEmptyBorder(top, left, bottom, right)
		));
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height));

		return wrapper;
	}

	private static JPanel createBaseStructure() {
		JPanel content = new JPanel();
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createLineBorder(Color.GREEN, 0));

		return content;
	}

	public static JPanel createCreationPage(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon) {

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

		JPanel titleLabelWrapper = wrapperLabelGenerator(titleLabel, 60, 0, 20, 0);
		base.add(titleLabelWrapper);

		// --- Label Name ---
		JLabel nameLabel = new JLabel("<html><div align=center>"
				+ "ᛁᚾ ᛖᚲᛊᛈᛚᛟᚱᛖ - Choose a name - ᛁᚾ ᚨᛖᚲᛊᛈᛚᛟᚱᛖ"
				+ "</div></html>");
		nameLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));

		JPanel nameLabelWrapper = wrapperLabelGenerator(nameLabel, 10, 10, 10, 10);
		base.add(nameLabelWrapper);

		// --- InputName ---
		JTextField inputName = new JTextField("Enter name");
		configureJTextField(inputName);

		JPanel inputNameWrapper = wrapperJTextFieldGenerator(inputName);
		base.add(inputNameWrapper);

		// --- Label Class ---
		JLabel classType = new JLabel("<html><div align=center>"
				+ "ᛁᚾ ᛖᚲᛊᛈᛚᛟᚱᛖ - Select a class - ᛁᚾ ᚨᛖᚲᛊᛈᛚᛟᚱᛖ"
				+ "</div></html>");
		classType.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));

		JPanel classTypeWrapper = wrapperLabelGenerator(classType, 10, 10, 10, 10);
		base.add(classTypeWrapper);

		// --- Combobox ---
		JComboBox<String> choice = new JComboBox<>(new String[]{"Warrior", "Mage", "Archer", "Paladin", "Assassin"});
		configureComboBox(choice);

		JPanel choiceWrapper = wrapperComboBoxGenerator(choice, 10, 10, 10, 10);
		base.add(choiceWrapper);

		JLabel hidden = new JLabel("");
		hidden.setVisible(false);
		hidden.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 22));
		hidden.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel hiddenWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		hiddenWrapper.setOpaque(false);
		hiddenWrapper.add(hidden);
		hiddenWrapper.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createEmptyBorder(30, 0, 0, 0), 
			BorderFactory.createLineBorder(Color.BLACK, 2)
		));
		// hiddenWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, hidden.getPreferredSize().height));
		// base.add(hiddenWrapper);

		// --- Button Confirm ---
		RoundedImageButton btnConfirm = new RoundedImageButton("Confirm", icon);
		btnConfirm.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btnConfirm.setPreferredSize(new Dimension(150, 48));
		btnConfirm.addActionListener(e -> {
			String getName = inputName.getText();
			String getSelectedClass = (String) choice.getSelectedItem();

			String heroTxt = "<html><div align='center'>"
				+ "Your name = <b>" + getName + "</b><br/>"
				+ "Your class = <b>" + getSelectedClass + "</b>"
				+ "</div></html>";

			hidden.setText(heroTxt);
			hidden.setVisible(true);
			hiddenWrapper.repaint();
			hiddenWrapper.revalidate();
			base.repaint();
		});

		JPanel btnConfirmWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		btnConfirmWrapper.setOpaque(false);
		btnConfirmWrapper.add(btnConfirm);
		btnConfirm.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(Color.GREEN, 2),
			BorderFactory.createEmptyBorder(0, 0, 0, 0)
		));
		btnConfirmWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnConfirm.getPreferredSize().height));
		base.add(btnConfirmWrapper);
		base.add(hiddenWrapper);

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

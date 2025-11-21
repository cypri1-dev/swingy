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

	private static JPanel wrapperJTextFieldGenerator(JTextField elem, int top, int left, int bottom, int right) {
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
		inputName.setOpaque(false);
		inputName.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 25));
		inputName.setColumns(15);
		inputName.setHorizontalAlignment(JTextField.CENTER);

		JPanel inputNameWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		inputNameWrapper.setOpaque(false);
		inputNameWrapper.add(inputName);
		inputName.setBorder(BorderFactory.createEmptyBorder());
		inputNameWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, inputName.getPreferredSize().height));
		base.add(inputNameWrapper);

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
		classTypeWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, classType.getPreferredSize().height));
		base.add(classTypeWrapper);

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

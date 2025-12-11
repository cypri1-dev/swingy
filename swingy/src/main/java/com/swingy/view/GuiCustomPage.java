package com.swingy.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.swingy.view.components.RoundedImageButton;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Color;

public abstract class GuiCustomPage {

	private static Dimension BtnDimension = new Dimension(150, 48);

	/************************************************************************ WRAPPER COMBOBOX (from GuiCreationPage) ************************************************************************/

	public static JPanel wrapperComboBoxGenerator(JComboBox<String> elem, int top, int left, int bottom, int right) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

		wrapper.setOpaque(false);
		wrapper.add(elem);
		wrapper.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height + 40));

		return wrapper;
	}

	/************************************************************************ WRAPPER JTEXTFIELD (from GuiCreationPage) ************************************************************************/

	public static JPanel wrapperJTextFieldGenerator(JTextField elem) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

		wrapper.setOpaque(false);
		wrapper.add(elem);
		elem.setBorder(BorderFactory.createEmptyBorder());
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height));

		return wrapper;
	}

	/************************************************************************ WRAPPER BUTTON (from GuiCreationPage)************************************************************************/

	public static JPanel wrapperButtonGenerator(RoundedImageButton elem, int top, int left, int bottom, int right) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

		wrapper.setOpaque(false);
		wrapper.add(elem);
		elem.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height));

		return wrapper;
	}
	
	/************************************************************************ WRAPPER LABEL (from GuiMainWindow / GuiCreationPage) ************************************************************************/
	
	public static JPanel wrapperLabelGenerator(JLabel elem, int top, int left, int bottom, int right, boolean setBorder, boolean setSize) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

		wrapper.setOpaque(false);
		wrapper.add(elem);
		if (setBorder) // GuiMainWindow
		wrapper.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
		if (setSize) // GuiCreationPage
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height));
		
		return wrapper;
	}
	
	/************************************************************************ CONFIGURATION BOTTOM PANEL (from GuiWelcomePage) ************************************************************************/

	public static void configureBottomPanel(JPanel elem, RoundedImageButton btn) {
		elem.setOpaque(false);
		elem.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
		elem.add(btn);
	}
	
	/************************************************************************ CONFIGURATION BUTTONS (from GuiMainMenuPage) ************************************************************************/

	public static void configButtons(RoundedImageButton btn) {
		setCustomFont(btn, Font.BOLD, 25);
		btn.setPreferredSize(BtnDimension);
		btn.setMinimumSize(BtnDimension);
		btn.setMaximumSize(BtnDimension);
	}

	/************************************************************************ CONFIGURATION JCOMBOBOX (from GuiCreationPage / GuiHeroManagerPage) ************************************************************************/

	public static void configureComboBox(JComboBox<String> elem) {
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

	/************************************************************************ CONFIGURATION HIDDEN LABEL (from GuiCreationPage / GuiHeroManagerPage) ************************************************************************/

	public static void configureHiddenLabel(JLabel elem) {
		elem.setVisible(false);
		setCustomFont(elem, Font.PLAIN, 20);
		elem.setHorizontalAlignment(SwingConstants.CENTER);
	}

	/************************************************************************ CONFIGURATION JSCROLLPANE (from GuiHeroManagerPage)************************************************************************/

	public static void configureJScrollPane(JScrollPane elem) {
		elem.setOpaque(false);
		elem.getViewport().setOpaque(false);
		elem.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
	}

	/************************************************************************ CONFIGURATION JTEXTFIELD ************************************************************************/

	public static void configureJTextField(JTextField elem) {
		elem.setOpaque(false);
		setCustomFont(elem, Font.ITALIC, 25);
		elem.setColumns(15);
		elem.setHorizontalAlignment(JTextField.CENTER);
	}

	/************************************************************************ SET CUSTOM FONT METHOD ************************************************************************/

	public static void setCustomFont(JComponent elem, int type, int size) {
		elem.setFont(new Font("Ancient Modern Tales", type, size));
	}

	/************************************************************************ METHOD BASE STRUCTURE BUILDER ************************************************************************/

	public static JPanel createBaseStructure() {
		JPanel content = new JPanel();
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

		return content;
	}

}
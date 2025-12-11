package com.swingy.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.swingy.view.components.RoundedImageButton;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;

public abstract class GuiCustomPage {

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

	/************************************************************************ CONFIGURATION BUTTONS (from GuiMainMenuPage) ************************************************************************/

	public static void configButtons(RoundedImageButton btn, Dimension size) {
		setCustomFont(btn, Font.BOLD, 25);
		btn.setPreferredSize(size);
		btn.setMinimumSize(size);
		btn.setMaximumSize(size);
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

	/************************************************************************ CONFIGURATION BOTTOM PANEL (from GuiWelcomePage) ************************************************************************/

	public static void configureBottomPanel(JPanel elem, RoundedImageButton btn) {
		elem.setOpaque(false);
		elem.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
		elem.add(btn);
	}
}
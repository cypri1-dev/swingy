package com.swingy.view;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.swingy.view.components.RoundedImageButton;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;

public abstract class GuiCustomPage {

	/************************************************************************ CONFIGURATION BUTTONS (From GuiMainMenuPage) ************************************************************************/

	public static void configButtons(RoundedImageButton btn, Dimension size) {
		setCustomFont(btn, Font.BOLD, 25);
		btn.setPreferredSize(size);
		btn.setMinimumSize(size);
		btn.setMaximumSize(size);
	}

	/************************************************************************ SET CUSTOM FONT METHOD ************************************************************************/

	public static void setCustomFont(JComponent elem, int type, int size) {
		elem.setFont(new Font("Ancient Modern Tales", type, size));
	}

	/************************************************************************ WRAPPER LABEL (from GuiMainWindow) ************************************************************************/

	public static JPanel wrapperLabelGenerator(JLabel elem, int top, int left, int bottom, int right, boolean setBorder) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		wrapper.setOpaque(false);
		wrapper.add(elem);
		if (setBorder)
			wrapper.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));

		return wrapper;
	}
}
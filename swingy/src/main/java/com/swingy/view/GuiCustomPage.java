package com.swingy.view;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import com.swingy.view.components.RoundedImageButton;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

import java.util.concurrent.ThreadLocalRandom;

public abstract class GuiCustomPage {

	private static Dimension BtnDimension = new Dimension(150, 48);
	private static boolean showingPotionPage = false;
	private static boolean showingFightPage = false;

	/************************************************************************ WRAPPER CHECKBOX (from GuiGamePage) ************************************************************************/

	public static JPanel wrapperCheckboxGenerator(JCheckBox elem, int top, int left, int bottom, int right) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		wrapper.setOpaque(false);
		wrapper.add(elem);
		elem.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height + top + bottom));
		wrapper.setAlignmentX(Component.CENTER_ALIGNMENT);

		return wrapper;
	}

	/************************************************************************ WRAPPER COMBOBOX (from GuiCreationPage) ************************************************************************/

	public static JPanel wrapperComboBoxGenerator(JComboBox<String> elem) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

		wrapper.setOpaque(false);
		wrapper.add(elem);
		wrapper.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height + 40));

		wrapper.setAlignmentX(Component.CENTER_ALIGNMENT); // need to test - EDIT: seems to be OK

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

		wrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		return wrapper;
	}

	// (from and for GuiGamePage / GuiInputController)
	public static JPanel wrapperLabelGeneratorInventory(JLabel elem, int top, int left, int bottom, int right, boolean setSize) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

		wrapper.setOpaque(false);
		wrapper.add(elem);
		wrapper.setBorder(BorderFactory.createEmptyBorder(top, left, bottom, right));
		if (setSize) {
			Dimension pref = wrapper.getPreferredSize();
			wrapper.setMaximumSize(new Dimension(pref.width, pref.height));
		}
		
		wrapper.setAlignmentX(Component.CENTER_ALIGNMENT);
		return wrapper;
	}

	/************************************************************************ CONFIGURATION JPANEL FIGHT (from GuiFightPage) ************************************************************************/

	public static void configureJPanelFight(JPanel panel) {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 0, 20));
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
	}

	/************************************************************************ CONFIGURATION TAB PANEL (from GuiGamePage) ************************************************************************/

	public static void configureTabPanel(JTabbedPane tabPanel) {
		tabPanel.setOpaque(false);
		tabPanel.setBackground(new Color(0, 0, 0, 0));

		tabPanel.setUI(new BasicTabbedPaneUI() {
			@Override
			protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
				g.setColor(new Color(0, 0, 0, 0));
				g.fillRect(x, y, w, h);
			}

			@Override
			protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) { }
		});
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
		setCustomFont(elem, Font.ITALIC, 25);

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

	/************************************************************************ CONFIGURATION JTEXTFIELD (from GuiCreationPage) ************************************************************************/

	public static void configureJTextField(JTextField elem) {
		elem.setOpaque(false);
		setCustomFont(elem, Font.ITALIC, 25);
		elem.setColumns(15);
		elem.setHorizontalAlignment(JTextField.CENTER);
	}

	/************************************************************************ RANDOM BACKGROUND METHOD ************************************************************************/

	public static BufferedImage selectRandomBackground() {
		int size = GuiMainWindow.getBackgrounds().size();
		int random = ThreadLocalRandom.current().nextInt(size);

		return (GuiMainWindow.getBackgrounds().get(random));
	}

	/************************************************************************ RESCALE TOKEN METHOD (from GuiGamePage) ************************************************************************/

	public static Icon rescaleToken(Icon token, int size) {
		Image img = ((ImageIcon) token).getImage();
		Image scaled = img.getScaledInstance(size, size, Image.SCALE_SMOOTH);
		Icon resizedToken = new ImageIcon(scaled);
		return resizedToken;
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
		content.setAlignmentX(Component.CENTER_ALIGNMENT); // need to test - EDIT: seems to be OK

		return content;
	}

	/************************************************************************ GETTERS/SETTERS ************************************************************************/

	public static boolean getShowingPagePotion() {return showingPotionPage;}
	public static void setShowingPagePotion(boolean set) {showingPotionPage = set;}
	public static boolean getShowingPageFight() {return showingFightPage;}
	public static void setShowingPageFight(boolean set) {showingFightPage = set;}
}
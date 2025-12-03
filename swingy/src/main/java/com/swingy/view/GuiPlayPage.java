package com.swingy.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.swingy.controller.Game;
import com.swingy.view.components.RoundedImageButton;
import com.swingy.model.Characters;

public class GuiPlayPage {

	private static JComboBox<String> choiceComboBox = null;

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

		// Centre horizontalement dans BoxLayout vertical
		wrapper.setAlignmentX(Component.CENTER_ALIGNMENT);

		return wrapper;
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
		// Permet à BoxLayout de gérer la largeur, on ne fixe pas la hauteur max trop basse
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height + top + bottom));

		// Centre horizontalement
		wrapper.setAlignmentX(Component.CENTER_ALIGNMENT);

		return wrapper;
	}

	/************************************************************************ WRAPPER COMBOBOX ************************************************************************/

	private static JPanel wrapperComboBoxGenerator(JComboBox<String> elem, int top, int left, int bottom, int right) {
		JPanel wrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		wrapper.setOpaque(false);
		wrapper.add(elem);
		wrapper.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.ORANGE, 0),
				BorderFactory.createEmptyBorder(top, left, bottom, right)
		));
		wrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, elem.getPreferredSize().height + 40));

		// Centre horizontalement dans BoxLayout vertical
		wrapper.setAlignmentX(Component.CENTER_ALIGNMENT);

		return wrapper;
	}

	/************************************************************************ UPDATE COMBOBOX METHOD ************************************************************************/

	// Mets à jour le modèle de la combo box existante
	public static void updateHeroComboBox(Game rpg) {
		if (choiceComboBox != null) {
			choiceComboBox.setModel(new DefaultComboBoxModel<>(rpg.getHeroesNameList().toArray(new String[0])));
		}
	}

	/************************************************************************ BASE STRUCTURE ************************************************************************/

	private static JPanel createBaseStructure() {
		JPanel content = new JPanel();
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.setBorder(BorderFactory.createLineBorder(Color.GREEN, 0));
		content.setAlignmentX(Component.CENTER_ALIGNMENT);
		return content;
	}

	/************************************************************************ CONFIGURATION JCOMBOBOX ************************************************************************/

	private static void configureComboBox(JComboBox<String> elem) {
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

	/************************************************************************ PLAY PAGE BUILDER METHOD ************************************************************************/

	public static JPanel createPlayPage(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon, Map<String, ImageIcon> listToken, Game rpg) {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		panel.setBorder(BorderFactory.createLineBorder(Color.RED, 0));

		JPanel base = createBaseStructure();
		panel.add(base, BorderLayout.CENTER);

		JLabel titleLabel = new JLabel(title);
		titleLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 60));
		JPanel titleLabelWrapper = wrapperLabelGenerator(titleLabel, 60, 0, 20, 0, true);

		JLabel runes = new JLabel(
			"<html><div align=center>"
			+ "ᛁᚾ ᚨ ᚹᛟᚱᛚᛞ ᛟᚾ ᚦᛖ ᛒᚱᛁᚾᚲ ᛟᚠ ᚲᚺᚨᛟᛊ ᚺᛖᚱᛟᛖᛊ ᚨᚱᛖ ᛒᛟᚱᚾ ᚲᚱᛖᛏᛖ ᛁᛟᚢᚱ ᚲᚺᚨᚱᚨᚲᛏᛖᚱ ᛖᚲᛊᛈᛚᛟᚱᛖ<br>"
			+ "ᚦᛖ ᚢᚾᚲᚾᛟᚹᚾ ᚨᚾᛞ ᚠᚨᚲᛖ ᛁᛟᚢᚱ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖᚾᛏᚢᚱᛖ ᛊᛏᚨᚱᛏᛊ ᚾᛟᚹᚨᚱᛖ ᛁᛟᚢ ᚱᛖᛞᛁ ᛏᛟ ᛒᛖᚲᛟᛗᛖ ᛚᛖᚷᛖᚾᛞ"
			+ "</div></html>"
		);
		runes.setFont(new Font("Ancient Modern Tales", Font.BOLD, 14));
		JPanel runesWrapper = wrapperLabelGenerator(runes, 0, 0, 0, 0, false);
		int maxHeight = 40;
		runesWrapper.setMaximumSize(new Dimension(runesWrapper.getMaximumSize().width, maxHeight));
		runesWrapper.setPreferredSize(new Dimension(runesWrapper.getPreferredSize().width, maxHeight));

		JLabel heroLabel = new JLabel("<html><div align=center> - Choose a hero - </div></html>");
		heroLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		JPanel heroLabelWrapper = wrapperLabelGenerator(heroLabel, 0, 0, 0, 0, false);
		heroLabelWrapper.setMaximumSize(new Dimension(heroLabelWrapper.getMaximumSize().width, maxHeight));
		heroLabelWrapper.setPreferredSize(new Dimension(heroLabelWrapper.getPreferredSize().width, maxHeight));

		JPanel choiceWrapper;
		if (choiceComboBox == null) {
			String[] array = rpg.getHeroesNameList().toArray(new String[0]);
			choiceComboBox = new JComboBox<>(array);
			configureComboBox(choiceComboBox);
			choiceWrapper = wrapperComboBoxGenerator(choiceComboBox, 10, 10, 10, 10);
		} else {
			updateHeroComboBox(rpg);
			choiceWrapper = wrapperComboBoxGenerator(choiceComboBox, 10, 10, 10, 10);
		}

		JLabel tokenLabel = new JLabel("<html><div> - Select a token - </div></html>");
		tokenLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		JPanel tokenLabelWrapper = wrapperLabelGenerator(tokenLabel, 0, 0, 0, 0, false);
		tokenLabelWrapper.setMaximumSize(new Dimension(tokenLabelWrapper.getMaximumSize().width, maxHeight));
		tokenLabelWrapper.setPreferredSize(new Dimension(tokenLabelWrapper.getPreferredSize().width, maxHeight));

		JPanel heroSelection = new JPanel(new FlowLayout());
		heroSelection.setOpaque(false);

		JLabel token1Label = new JLabel(listToken.get("token1"));
		JLabel token2Label = new JLabel(listToken.get("token2"));
		JLabel token3Label = new JLabel(listToken.get("token3"));
		JLabel token4Label = new JLabel(listToken.get("token4"));

		token1Label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		token2Label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		token3Label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		token4Label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		heroSelection.add(token1Label);
		heroSelection.add(token2Label);
		heroSelection.add(token3Label);
		heroSelection.add(token4Label);

		final JLabel[] selected = {null};
		MouseAdapter selectHero = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (selected[0] != null)
					selected[0].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
				JLabel clicked = (JLabel) e.getSource();
				clicked.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
				selected[0] = clicked;
			}
		};

		token1Label.addMouseListener(selectHero);
		token2Label.addMouseListener(selectHero);
		token3Label.addMouseListener(selectHero);
		token4Label.addMouseListener(selectHero);

		JLabel infoLabel = new JLabel("");
		infoLabel.setFont(new Font("Ancient Modern Tales", Font.BOLD, 20));
		JPanel infoLabelWrapper = wrapperLabelGenerator(infoLabel, 10, 0, 10, 0, false);

		RoundedImageButton btnConfirm = new RoundedImageButton("Confirm", icon);
		JPanel btnConfirmWrapper = wrapperButtonGenerator(btnConfirm, 0, 0, 0, 0);
		btnConfirm.setPreferredSize(new Dimension(150, 48));
		btnConfirmWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnConfirm.getPreferredSize().height));

		RoundedImageButton btnPlay = new RoundedImageButton("Play", icon);
		btnPlay.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btnPlay.setPreferredSize(new Dimension(150, 48));
		btnPlay.setVisible(false);
		JPanel btnPlayWrapper = wrapperButtonGenerator(btnPlay, 0, 0, 0, 0);
		btnPlayWrapper.setMaximumSize(new Dimension(Integer.MAX_VALUE, btnPlay.getPreferredSize().height));

		btnConfirm.addActionListener(e -> {
			String selectedHeroName = (String) choiceComboBox.getSelectedItem();

			if (selectedHeroName == null) {
				infoLabel.setText("<html><div style='color:red;'>Please select a hero.</div></html>");
				return;
			}
			if (selected[0] == null) {
				infoLabel.setText("<html><div style='color:red;'>Please select a token.</div></html>");
				return;
			}

			Icon tokenIcon = selected[0].getIcon();

			int level = 0;
			for (Characters hero : rpg.getListAvaible()) {
				if (selectedHeroName.equals(hero.getName())) {
					rpg.setSelectedHero(hero);
					level = hero.getLevel();
					break;
				}
			}

			infoLabel.setText(
				"<html><div style='text-align: center;'>"
				+ selectedHeroName + "<br/>"
				+ "<b>Level </b> " + level + "<br/>"
				+ "</div></html>"
			);
			infoLabel.setIcon(tokenIcon);
			infoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			infoLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

			btnPlay.setVisible(true);
			base.revalidate();
			base.repaint();
		});

		btnPlay.addActionListener(e -> {
			JPanel gamePage = GuiGamePage.createGamePage(rpg, cardLayout, cardPanel, icon);
			cardPanel.add(gamePage, "game");
			cardLayout.show(cardPanel, "game");
		});

		JLabel runesBottom = new JLabel(
			"<html><div align=center>"
			+ "ᚦᛖ ᚨᚾᛞ ᚠᚨᚲᛖ ᛁᛟᚢᚱ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖᚾᛏᚢᚱᛖ ᛊᛏᚨᚱᛏᛊ ᚾᛟᚹᚨ"
			+ "</div></html>"
		);
		runesBottom.setFont(new Font("Ancient Modern Tales", Font.BOLD, 14));
		JPanel runesBottomWrapper = wrapperLabelGenerator(runesBottom, 0, 0, 0, 0, false);
		runesBottomWrapper.setMaximumSize(new Dimension(runesBottomWrapper.getMaximumSize().width, maxHeight));
		runesBottomWrapper.setPreferredSize(new Dimension(runesBottomWrapper.getPreferredSize().width, maxHeight));

		// Ordre d'ajout des composants (btnPlay avant btnConfirm, avec espace)
		base.add(titleLabelWrapper);
		base.add(runesWrapper);
		base.add(heroLabelWrapper);
		base.add(choiceWrapper);
		base.add(tokenLabelWrapper);
		base.add(heroSelection);
		base.add(runesBottomWrapper);

		base.add(infoLabelWrapper);

		base.add(btnPlayWrapper);
		base.add(Box.createVerticalStrut(10)); // Espace entre Play et Confirm
		base.add(btnConfirmWrapper);

		JPanel bottom = new JPanel();
		bottom.setOpaque(false);
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
		bottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));

		bottom.add(Box.createVerticalStrut(5));

		RoundedImageButton btnMenu = new RoundedImageButton("Menu", icon);
		btnMenu.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btnMenu.setPreferredSize(new Dimension(150, 48));
		btnMenu.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));

		JPanel menuWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		menuWrapper.setOpaque(false);
		menuWrapper.add(btnMenu);

		bottom.add(menuWrapper);

		panel.add(bottom, BorderLayout.SOUTH);

		return panel;
	}

}

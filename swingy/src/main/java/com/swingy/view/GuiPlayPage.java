package com.swingy.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.swingy.controller.Game;
import com.swingy.controller.GuiLaunchGameController;
import com.swingy.view.components.RoundedImageButton;

public class GuiPlayPage extends GuiCustomPage {

	private static JComboBox<String> choiceComboBox = null;
	private static final JLabel[] selected = {null};

	/************************************************************************ UPDATE COMBOBOX METHOD ************************************************************************/

	private static JPanel createTokenSelector(Map<String, ImageIcon> listToken) {
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

		JLabel[] selected = getSelected();
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

		return heroSelection;
	} 

	/************************************************************************ UPDATE COMBOBOX METHOD ************************************************************************/

	public static void updateHeroComboBox(Game rpg) {
		if (choiceComboBox != null) {
			choiceComboBox.setModel(new DefaultComboBoxModel<>(rpg.getHeroesNameList().toArray(new String[0])));
		}
	}

	/************************************************************************ PLAY PAGE BUILDER METHOD ************************************************************************/

	public static JPanel createPlayPage(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon, Map<String, ImageIcon> listToken, Game rpg) {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);

		JPanel base = createBaseStructure();
		panel.add(base, BorderLayout.CENTER);

		JLabel titleLabel = new JLabel(title);
		setCustomFont(titleLabel, Font.BOLD, 60);
		JPanel titleLabelWrapper = wrapperLabelGenerator(titleLabel, 60, 0, 20, 0, true, true);

		JLabel runes = new JLabel(
			"<html><div align=center>"
			+ "ᛁᚾ ᚨ ᚹᛟᚱᛚᛞ ᛟᚾ ᚦᛖ ᛒᚱᛁᚾᚲ ᛟᚠ ᚲᚺᚨᛟᛊ ᚺᛖᚱᛟᛖᛊ ᚨᚱᛖ ᛒᛟᚱᚾ ᚲᚱᛖᛏᛖ ᛁᛟᚢᚱ ᚲᚺᚨᚱᚨᚲᛏᛖᚱ ᛖᚲᛊᛈᛚᛟᚱᛖ<br>"
			+ "ᚦᛖ ᚢᚾᚲᚾᛟᚹᚾ ᚨᚾᛞ ᚠᚨᚲᛖ ᛁᛟᚢᚱ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖᚾᛏᚢᚱᛖ ᛊᛏᚨᚱᛏᛊ ᚾᛟᚹᚨᚱᛖ ᛁᛟᚢ ᚱᛖᛞᛁ ᛏᛟ ᛒᛖᚲᛟᛗᛖ ᛚᛖᚷᛖᚾᛞ"
			+ "</div></html>"
		);
		setCustomFont(runes, Font.BOLD, 14);
		JPanel runesWrapper = wrapperLabelGenerator(runes, 0, 0, 10, 0, true, true);

		JLabel heroLabel = new JLabel("<html><div align=center> - Choose a hero - </div></html>");
		setCustomFont(heroLabel, Font.BOLD, 25);
		JPanel heroLabelWrapper = wrapperLabelGenerator(heroLabel, 0, 0, 0, 0, true, true);

		JPanel choiceWrapper;
		if (choiceComboBox == null) {
			String[] array = rpg.getHeroesNameList().toArray(new String[0]);
			choiceComboBox = new JComboBox<>(array);
			configureComboBox(choiceComboBox);
			choiceWrapper = wrapperComboBoxGenerator(choiceComboBox);
		} else {
			updateHeroComboBox(rpg);
			choiceWrapper = wrapperComboBoxGenerator(choiceComboBox);
		}

		JLabel tokenLabel = new JLabel("<html><div> - Select a token - </div></html>");
		setCustomFont(tokenLabel, Font.BOLD, 25);
		JPanel tokenLabelWrapper = wrapperLabelGenerator(tokenLabel, 0, 0, 0, 0, true,  true);

		JPanel heroSelection = createTokenSelector(listToken);

		JLabel infoLabel = new JLabel("");
		setCustomFont(infoLabel, Font.BOLD, 20);
		JPanel infoLabelWrapper = wrapperLabelGenerator(infoLabel, 10, 0, 10, 0, true, false);

		RoundedImageButton btnConfirm = new RoundedImageButton("Confirm", icon);
		configButtons(btnConfirm);
		JPanel btnConfirmWrapper = wrapperButtonGenerator(btnConfirm, 0, 0, 0, 0);

		RoundedImageButton btnPlay = new RoundedImageButton("Play", icon);
		configButtons(btnPlay);
		btnPlay.setVisible(false);
		JPanel btnPlayWrapper = wrapperButtonGenerator(btnPlay, 0, 0, 0, 0);

		btnConfirm.addActionListener(e -> {
			String selectedHeroName = (String) choiceComboBox.getSelectedItem();

			if (selectedHeroName == null) {
				infoLabel.setText("<html><div style='color:red;'>Please select a hero.</div></html>");
				return;
			}

			JLabel[] selected = getSelected();
			if (selected[0] == null) {
				infoLabel.setText("<html><div style='color:red;'>Please select a token.</div></html>");
				return;
			}

			Icon tokenIcon = selected[0].getIcon();
			String txt = GuiLaunchGameController.selectHeroGame(selectedHeroName, rpg, tokenIcon);

			infoLabel.setText(txt);
			infoLabel.setIcon(tokenIcon);
			infoLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			infoLabel.setVerticalTextPosition(SwingConstants.BOTTOM);

			btnPlay.setVisible(true);
			base.revalidate();
			base.repaint();
		});


		btnPlay.addActionListener(e -> {
			infoLabel.setText("");
			btnPlay.setVisible(false);
			infoLabel.setIcon(null);
			JPanel gamePage = GuiGamePage.createGamePage(rpg, cardLayout, cardPanel, listToken, icon);
			cardPanel.add(gamePage, "game");
			cardLayout.show(cardPanel, "game");
		});

		JLabel runesBottom = new JLabel(
			"<html><div align=center>"
			+ "ᚦᛖ ᚨᚾᛞ ᚠᚨᚲᛖ ᛁᛟᚢᚱ ᛞᛖᛊᛏᛁᚾᛁ ᛏᚺᛖ ᚨᛞᚢᛖᚾᛏᚢᚱᛖ ᛊᛏᚨᚱᛏᛊ ᚾᛟᚹᚨ"
			+ "</div></html>"
		);
		setCustomFont(runesBottom, Font.BOLD, 14);
		JPanel runesBottomWrapper = wrapperLabelGenerator(runesBottom, 0, 0, 0, 0, true, true);

		base.add(titleLabelWrapper);
		base.add(runesWrapper);
		base.add(heroLabelWrapper);
		base.add(choiceWrapper);
		base.add(tokenLabelWrapper);
		base.add(heroSelection);
		base.add(runesBottomWrapper);
		base.add(infoLabelWrapper);
		base.add(btnPlayWrapper);
		base.add(Box.createVerticalStrut(10));
		base.add(btnConfirmWrapper);

		RoundedImageButton btnMenu = new RoundedImageButton("Menu", icon);
		configButtons(btnMenu);
		btnMenu.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));

		JPanel bottom = new JPanel();
		configureBottomPanel(bottom, btnMenu);
		panel.add(bottom, BorderLayout.SOUTH);

		return panel;
	}

	/************************************************************************ SETTERS/GETTERS ************************************************************************/

	public static JLabel[] getSelected() {return selected;}
}

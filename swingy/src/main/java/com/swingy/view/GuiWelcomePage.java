package com.swingy.view;

import com.swingy.utils.TokenAnimator;
import com.swingy.utils.LabelAnimator;
import com.swingy.view.components.FadingLabel;
import com.swingy.view.components.RoundedImageButton;
import com.swingy.view.components.FadingToken;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import java.awt.Font;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.util.Map;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class GuiWelcomePage extends GuiCustomPage {

	/************************************************************************ CONFIGURATION BUTTON ************************************************************************/

	private static void configureButton(RoundedImageButton btn, CardLayout cardLayout, JPanel cardPanel) {
		setCustomFont(btn, Font.BOLD, 25);
		btn.setPreferredSize(new Dimension(152, 52));
		btn.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));
	}

	/************************************************************************ CONFIGURATION PANEL TOKENS ************************************************************************/

	private static void configurePanelTokens(JPanel elem) {
		elem.setOpaque(false);
		elem.setLayout(new BoxLayout(elem, BoxLayout.Y_AXIS));
		elem.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		elem.setPreferredSize(new Dimension(400, 500));
	}

	/************************************************************************ CONFIGURATION BOTTOM PANEL ************************************************************************/

	private static void configureBottomPanel(JPanel elem, RoundedImageButton btn) {
		elem.setOpaque(false);
		elem.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
		elem.add(btn);
	}

	/************************************************************************ WELCOME PAGE BUILDER METHOD ************************************************************************/

	public static JPanel createPageWelcome(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon, Map<String, ImageIcon> listToken) {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);

		// --- Zone verticale principale (au CENTRE) ---
		JPanel content = new JPanel();
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		panel.add(content, BorderLayout.CENTER);

		// --- Titre ---
		JLabel label = new JLabel(title);
		setCustomFont(label, Font.BOLD, 60);

		JPanel labelWrapper = wrapperLabelGenerator(label, 60, 20, 50, 20, true);
		content.add(labelWrapper);

		// --- Description ---
		FadingLabel description = new FadingLabel(
			"<html><div align='center'>"
			+ "Welcome, brave adventurer!<br>"
			+ "Your journey through the world of Swingy begins now!<br>"
			+ "Where courage, strategy, and fate will decide your legend..."
			+ "</div></html>"
		);
		setCustomFont(description, Font.ITALIC, 30);

		JPanel descWrapper = wrapperLabelGenerator(description, 0, 0, 60, 0, true);
		content.add(descWrapper);

		// --- Tokens ---
		JPanel tokenContent = new JPanel();
		configurePanelTokens(tokenContent);

		FadingToken tokenSpider = new FadingToken(listToken.get("Araignee_geante"));
		FadingToken tokenSkull = new FadingToken(listToken.get("Cranefeu"));
		FadingToken tokenOzi = new FadingToken(listToken.get("Ozi"));
		FadingToken tokenManticore = new FadingToken(listToken.get("manticore"));
		FadingToken tokenEttins = new FadingToken(listToken.get("ettins"));
		FadingToken tokenOrc = new FadingToken(listToken.get("Orc"));
		FadingToken tokenVolo = new FadingToken(listToken.get("volothamp_geddarm"));

		FadingToken[] tokens = {tokenSpider, tokenSkull, tokenOzi, tokenManticore, tokenEttins, tokenOrc, tokenVolo};
		List<FadingToken> tokenList = Arrays.asList(tokens);
		Collections.shuffle(tokenList);
		tokenList.toArray(tokens);
		TokenAnimator.fadeTokensSequentially(tokens);

		JPanel tokenWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		tokenWrapper.setOpaque(false);
		tokenWrapper.add(tokenSpider);
		tokenWrapper.add(tokenEttins);
		tokenWrapper.add(tokenOzi);
		tokenWrapper.add(tokenManticore);
		tokenWrapper.add(tokenSkull);
		tokenWrapper.add(tokenOrc);
		tokenWrapper.add(tokenVolo);
		tokenContent.add(tokenWrapper);

		content.add(tokenContent);

		// --- Bouton en bas ---
		RoundedImageButton btn = new RoundedImageButton("Enter Game", icon);
		configureButton(btn, cardLayout, cardPanel);

		JPanel bottom = new JPanel();
		configureBottomPanel(bottom, btn);
		
		panel.add(bottom, BorderLayout.SOUTH);
		LabelAnimator.animateLabel(description);

		return panel;
	}
}
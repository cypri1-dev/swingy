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

public class GuiWelcomePage {

	/* ---------------------- METHOD FOR WELCOME_PAGE CREATION ----------------------*/

	public static JPanel createPageWelcome(String title, CardLayout cardLayout, JPanel cardPanel, ImageIcon icon, Map<String, ImageIcon> listToken) {

		JPanel panel = new JPanel(new BorderLayout());
		panel.setOpaque(false);
		// panel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));  // DEBUG

		// --- Zone verticale principale (au CENTRE) ---
		JPanel content = new JPanel();
		content.setOpaque(false);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		// content.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));  // DEBUG
		panel.add(content, BorderLayout.CENTER);

		// --- Titre ---
		JLabel label = new JLabel(title);
		label.setFont(new Font("Ancient Modern Tales", Font.BOLD, 60));
		// label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2)); // debug

		JPanel labelWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		labelWrapper.setOpaque(false);
		labelWrapper.add(label);
		labelWrapper.setBorder(BorderFactory.createEmptyBorder(60, 20, 50, 20));
		content.add(labelWrapper);

		// --- Description ---
		FadingLabel description = new FadingLabel(
			"<html><div align='center'>"
			+ "Welcome, brave adventurer!<br>"
			+ "Your journey through the world of Swingy begins now!<br>"
			+ "Where courage, strategy, and fate will decide your legend..."
			+ "</div></html>"
		);
		description.setFont(new Font("Ancient Modern Tales", Font.ITALIC, 30));
		// description.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));

		JPanel descWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		descWrapper.setOpaque(false);
		descWrapper.add(description);
		descWrapper.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0));
		content.add(descWrapper);

		// --- Tokens ---
		JPanel tokenContent = new JPanel();
		tokenContent.setOpaque(false);
		tokenContent.setLayout(new BoxLayout(tokenContent, BoxLayout.Y_AXIS));
		tokenContent.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		// tokenContent.setBorder(BorderFactory.createCompoundBorder(
		// 	BorderFactory.createLineBorder(Color.BLACK, 2),
		// 	BorderFactory.createEmptyBorder(0, 0, 0, 0)
		// ));
		tokenContent.setPreferredSize(new Dimension(400, 500)); // largeur x hauteur

		ImageIcon iconSpider = listToken.get("Araignee_geante");
		ImageIcon iconSkull = listToken.get("Cranefeu");
		ImageIcon iconOzi = listToken.get("Ozi");
		ImageIcon iconManticore = listToken.get("manticore");
		ImageIcon iconEttins = listToken.get("ettins");
		ImageIcon iconOrc = listToken.get("Orc");
		ImageIcon iconVolo = listToken.get("volothamp_geddarm");

		FadingToken tokenSpider = new FadingToken(iconSpider);
		FadingToken tokenSkull = new FadingToken(iconSkull);
		FadingToken tokenOzi = new FadingToken(iconOzi);
		FadingToken tokenManticore = new FadingToken(iconManticore);
		FadingToken tokenEttins = new FadingToken(iconEttins);
		FadingToken tokenOrc = new FadingToken(iconOrc);
		FadingToken tokenVolo = new FadingToken(iconVolo);

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
		btn.setFont(new Font("Ancient Modern Tales", Font.BOLD, 25));
		btn.setPreferredSize(new Dimension(152, 52));
		btn.addActionListener(e -> cardLayout.show(cardPanel, "main_menu"));
		// btn.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 2)); // DEBUG

		JPanel bottom = new JPanel();
		bottom.setOpaque(false);
		bottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 40, 0));
		// bottom.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2)); // DEBUG
		bottom.add(btn);
		panel.add(bottom, BorderLayout.SOUTH);
		LabelAnimator.animateLabel(description);

		return panel;
	}
}
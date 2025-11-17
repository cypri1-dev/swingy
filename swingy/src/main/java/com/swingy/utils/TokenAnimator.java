package com.swingy.utils;

import javax.swing.Timer;

import com.swingy.view.components.FadingToken;

public class TokenAnimator {

	public static void fadeTokensSequentially(FadingToken[] tokens) {
		fadeToken(tokens, 0);
	}

	private static void fadeToken(FadingToken[] tokens, int index) {
		if (index >= tokens.length) return;

		FadingToken token = tokens[index];

		Timer timer = new Timer(40, null);
		timer.addActionListener(e -> {
			float alpha = token.getAlpha() + 0.05f;
			if (alpha >= 1f) {
				token.setAlpha(1f);
				((Timer)e.getSource()).stop();
				// Quand le token est terminé, on lance le suivant
				fadeToken(tokens, index + 1);
			} else {
				token.setAlpha(alpha);
			}
		});
		timer.start();
	}
}

package com.swingy.utils;

import javax.swing.Timer;

import com.swingy.view.components.FadingLabel;

public class LabelAnimator {

	public static void animateLabel(FadingLabel description) {
		Timer timer = new Timer(60, e -> {
			float alpha = description.getAlpha() + 0.05f;
			if (alpha >= 1f) {
				description.setAlpha(1f);
				((Timer)e.getSource()).stop();
			} else {
				description.setAlpha(alpha);
			}
		});
		timer.start();
	}
}
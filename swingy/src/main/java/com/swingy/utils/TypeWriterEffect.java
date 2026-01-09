package com.swingy.utils;

import javax.swing.JTextArea;
import javax.swing.Timer;

public class TypeWriterEffect {

	private static Timer currentTimer;

	public static void appendAnimated(
		JTextArea area,
		String text,
		int delayMs,
		Runnable onFinish
	) {
		if (currentTimer != null && currentTimer.isRunning()) {
			currentTimer.stop();
		}

		final int[] index = {0};

		currentTimer = new Timer(delayMs, null);
		currentTimer.addActionListener(e -> {
			if (index[0] < text.length()) {
				area.append(String.valueOf(text.charAt(index[0]++)));
				area.setCaretPosition(area.getDocument().getLength());
			} else {
				area.append("\n");
				currentTimer.stop();
				if (onFinish != null)
					onFinish.run();
			}
		});

		currentTimer.start();
	}
}

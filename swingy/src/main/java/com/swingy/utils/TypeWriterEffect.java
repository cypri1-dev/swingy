package com.swingy.utils;

import javax.swing.JTextArea;
import javax.swing.Timer;

public class TypeWriterEffect {

	public static void appendAnimated(
		JTextArea area,
		String text,
		int delayMs
	) {
		final int[] index = {0};

		Timer timer = new Timer(delayMs, null);
		timer.addActionListener(e -> {
			if (index[0] < text.length()) {
				area.append(String.valueOf(text.charAt(index[0]++)));
				area.setCaretPosition(area.getDocument().getLength());
			} else {
				area.append("\n");
				timer.stop();
			}
		});
		timer.start();
	}
}

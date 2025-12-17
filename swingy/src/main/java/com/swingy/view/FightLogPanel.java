package com.swingy.view;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;

public class FightLogPanel extends JPanel {

	private final JTextArea logArea;
	private final JScrollPane scrollPane;

	public FightLogPanel() {
		setLayout(new BorderLayout());
		setOpaque(false);

		logArea = new JTextArea();
		logArea.setEditable(false);
		logArea.setLineWrap(true);
		logArea.setWrapStyleWord(true);
		logArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		logArea.setForeground(new Color(0x00FF99));
		logArea.setBackground(Color.BLACK);
		logArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		scrollPane = new JScrollPane(logArea);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);

		add(scrollPane, BorderLayout.CENTER);
	}

	public void appendInstant(String text) {
		logArea.append(text + "\n");
		logArea.setCaretPosition(logArea.getDocument().getLength());
	}

	public JTextArea getLogArea() {
		return logArea;
	}
}

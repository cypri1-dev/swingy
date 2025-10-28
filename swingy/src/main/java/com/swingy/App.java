package com.swingy;


import javax.swing.*;          // Pour JFrame, JLabel, JButton, JTextField
import java.awt.event.*;  

import com.swingy.controller.Game;

public class App {
	public static void main(String[] args) {
		// windows creation
		JFrame frame = new JFrame("Conversion Celcius -> Fahrenheit");
		frame.setSize(400, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);

		// label asking for temperature
		JLabel label = new JLabel("Enter temperature in °C :");
		label.setBounds(20, 20, 200, 25);
		frame.add(label);

		// field to enter temperature
		JTextField textField = new JTextField();
		textField.setBounds(220, 20, 100, 25);
		frame.add(textField);

		// button to make conversion
		JButton button = new JButton("Convert");
		button.setBounds(150, 60, 100, 25);
		frame.add(button);

		// label diplaying result
		JLabel reslutLabel = new JLabel("");
		reslutLabel.setBounds(20, 100, 350, 25);
		frame.add(reslutLabel);

		// button action
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double celcius = Double.parseDouble(textField.getText());
					double fahreinheit = celcius * 9 / 5 + 32;
					reslutLabel.setText(celcius + "°C = " + fahreinheit + "°F");
				} catch (NumberFormatException ex) {
					reslutLabel.setText("Please enter valid value !");
				}
			}
		});

		frame.setVisible(true);

		Game rpg = new Game();

		while(true) {
			rpg.getMenu().launchGame();
		}

	}
}
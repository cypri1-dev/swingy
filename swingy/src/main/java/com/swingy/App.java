package com.swingy;

import com.swingy.model.Artefact;
import com.swingy.model.ArtefactFactory;
import com.swingy.model.Characters;
import com.swingy.model.CharactersFactory;
import com.swingy.model.Helm;

import static com.swingy.utils.Constants.*;
import com.swingy.view.DisplayInfos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
	public static void main(String[] args) {
		// windows creation
		// JFrame frame = new JFrame("Conversion Celcius -> Fahrenheit");
		// frame.setSize(400, 150);
		// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setLayout(null);

		// // label asking for temperature
		// JLabel label = new JLabel("Enter temperature in °C :");
		// label.setBounds(20, 20, 200, 25);
		// frame.add(label);

		// // field to enter temperature
		// JTextField textField = new JTextField();
		// textField.setBounds(220, 20, 100, 25);
		// frame.add(textField);

		// // button to make conversion
		// JButton button = new JButton("Convert");
		// button.setBounds(150, 60, 100, 25);
		// frame.add(button);

		// // label diplaying result
		// JLabel reslutLabel = new JLabel("");
		// reslutLabel.setBounds(20, 100, 350, 25);
		// frame.add(reslutLabel);

		// // button action
		// button.addActionListener(new ActionListener() {
		// 	@Override
		// 	public void actionPerformed(ActionEvent e) {
		// 		try {
		// 			double celcius = Double.parseDouble(textField.getText());
		// 			double fahreinheit = celcius * 9 / 5 + 32;
		// 			reslutLabel.setText(celcius + "°C = " + fahreinheit + "°F");
		// 		} catch (NumberFormatException ex) {
		// 			reslutLabel.setText("Please enter valid value !");
		// 		}
		// 	}
		// });

		// frame.setVisible(true);
		Characters myHero = CharactersFactory.getInstance().newCharacters(HERO_TYPE, "Adshum", MAGE_CLASS);
		Characters myEnemy = CharactersFactory.getInstance().newCharacters(ENEMY_TYPE, "Bandit", ASSASSIN_CLASS);
		DisplayInfos.printHero(myHero);
		DisplayInfos.printEnemy(myEnemy);
		Artefact testItem0 = ArtefactFactory.getInstance().newArtefact(WEAPON_TYPE, "Deuillegivre", 10);
		Artefact testItem1 = ArtefactFactory.getInstance().newArtefact(HELM_TYPE, "Casque de bronze", 3);
		Artefact testItem2 = ArtefactFactory.getInstance().newArtefact(ARMOR_TYPE, "Pastron en cuir", 4);
		DisplayInfos.printArtefact(testItem0);
		DisplayInfos.printArtefact(testItem1);
		DisplayInfos.printArtefact(testItem2);
		myHero.addArtefact(testItem0);
		DisplayInfos.printHero(myHero);
		myHero.addArtefact(testItem1);
		myHero.addArtefact(testItem2);
		myHero.removeArtefact(testItem0);
		DisplayInfos.printHero(myHero);

	}
}
package com.swingy;

import com.swingy.controller.Game;

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

		/* TESTS HERO - ENEMY - ARTEFACT */

		// Characters myHero = CharactersFactory.getInstance().newCharacters(HERO_TYPE, "Adshum", MAGE_CLASS);
		// Characters myEnemy = CharactersFactory.getInstance().newCharacters(ENEMY_TYPE, "Bandit", ASSASSIN_CLASS);
		// DisplayInfos.printHero(myHero);
		// DisplayInfos.printEnemy(myEnemy);
		// Artefact testItem0 = ArtefactFactory.getInstance().newArtefact(WEAPON_TYPE, "Deuillegivre", 10);
		// Artefact testItem1 = ArtefactFactory.getInstance().newArtefact(HELM_TYPE, "Casque de bronze", 3);
		// Artefact testItem2 = ArtefactFactory.getInstance().newArtefact(ARMOR_TYPE, "Pastron en cuir", 4);
		// DisplayInfos.printArtefact(testItem0);
		// DisplayInfos.printArtefact(testItem1);
		// DisplayInfos.printArtefact(testItem2);
		// myHero.addArtefact(testItem0);
		// DisplayInfos.printHero(myHero);
		// myHero.addArtefact(testItem1);
		// myHero.addArtefact(testItem2);
		// myHero.removeArtefact(testItem0);
		// DisplayInfos.printHero(myHero);

		/* TESTS CLASS STATS */

		// Characters warrior = CharactersFactory.getInstance().newCharacters(HERO_TYPE, "Adshum", WARRIOR_CLASS);
		// Characters mage = CharactersFactory.getInstance().newCharacters(HERO_TYPE, "Adshum", MAGE_CLASS);
		// Characters archer = CharactersFactory.getInstance().newCharacters(HERO_TYPE, "Adshum", ARCHER_CLASS);
		// Characters paladin = CharactersFactory.getInstance().newCharacters(HERO_TYPE, "Adshum", PALADIN_CLASS);
		// Characters assassin = CharactersFactory.getInstance().newCharacters(HERO_TYPE, "Adshum", ASSASSIN_CLASS);

		// DisplayInfos.printHero(warrior);
		// DisplayInfos.printHero(mage);
		// DisplayInfos.printHero(archer);
		// DisplayInfos.printHero(paladin);
		// DisplayInfos.printHero(assassin);
		
		// Characters bandit = CharactersFactory.getInstance().newCharacters(ENEMY_TYPE, "Bandit", ARCHER_CLASS);
		// DisplayInfos.printEnemy(bandit);

		/* TESTS ITEM EQUIPPED AND UNEQUIPPED */

		// Characters warrior = CharactersFactory.getInstance().newCharacters(HERO_TYPE, "Adshum", WARRIOR_CLASS);
		// Artefact testItem0 = ArtefactFactory.getInstance().newArtefact(WEAPON_TYPE, "Deuillegivre", 10);
		// Artefact sword = ArtefactFactory.getInstance().newArtefact(WEAPON_TYPE, "Sword", 11);
		// Artefact testItem1 = ArtefactFactory.getInstance().newArtefact(HELM_TYPE, "Casque de bronze", 3);


		// warrior.addArtefact(testItem0);
		// warrior.addArtefact(sword);
		// warrior.addArtefact(testItem1);
		// warrior.equipArtefact(testItem0);
		// DisplayInfos.printHero(warrior);
		// warrior.equipArtefact(testItem1);
		// warrior.equipArtefact(sword);
		// DisplayInfos.printHero(warrior);
		// warrior.unequipArtefact(testItem1);
		// warrior.unequipArtefact(testItem0);
		// DisplayInfos.printHero(warrior);
		// warrior.removeArtefact(sword);
		// DisplayInfos.printHero(warrior);
		// warrior.unequipArtefact(testItem0);
		// DisplayInfos.printHero(warrior);

		/* MAP TESTS */

		// Characters warrior = CharactersFactory.getInstance().newCharacters(HERO_TYPE, "Adshum", WARRIOR_CLASS);
		// Map myMap = MapFactory.getInstance().newMap(warrior);

		// DisplayInfos.printMap(myMap);
		// // DisplayInfos.printEnemyInMap(myMap);
		// System.out.println("------------------------------------");
		// warrior.getMovement().moveNorth(warrior, myMap);
		// DisplayInfos.printMap(myMap);
		// System.out.println("------------------------------------");

		// warrior.getMovement().moveNorth(warrior, myMap);
		// DisplayInfos.printMap(myMap);
		// System.out.println("------------------------------------");

		// // warrior.getMovement().moveNorth(warrior, myMap);
		// // DisplayInfos.printMap(myMap);
		// warrior.getMovement().moveNorth(warrior, myMap);
		// // warrior.getMovement().moveEast(warrior, myMap);
		// // warrior.getMovement().moveEast(warrior, myMap);
		// // warrior.getMovement().moveWest(warrior, myMap);
		// // warrior.getMovement().moveWest(warrior, myMap);
		// // warrior.getMovement().moveWest(warrior, myMap);
		// DisplayInfos.printMap(myMap);

		// System.out.println("------------------------------------");
		// System.out.println("------------------------------------");


		// warrior.getMovement().moveSouth(warrior, myMap);

		// DisplayInfos.printMap(myMap);

		// System.out.println("------------------------------------");

		// warrior.getMovement().moveSouth(warrior, myMap);

		// DisplayInfos.printMap(myMap);
		// System.out.println("------------------------------------");

		// warrior.getMovement().moveSouth(warrior, myMap);

		// DisplayInfos.printMap(myMap);
		// System.out.println("------------------------------------");

		// warrior.getMovement().moveSouth(warrior, myMap);

		// DisplayInfos.printMap(myMap);
		// System.out.println("------------------------------------");

		// DisplayInfos.printHero(warrior);

		Game rpg = new Game();

		while(true) {
			rpg.getMenu().launchGame();
		}

	}
}
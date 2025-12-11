package com.swingy.controller;

import static com.swingy.utils.Constants.*;

import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.swingy.model.Characters;
import com.swingy.model.CharactersFactory;
import com.swingy.view.GuiHeroManagerPage;
import com.swingy.view.GuiPlayPage;

public class CreationController {

	public static String createHero(Game rpg, JTextField inputName, JComboBox<String> choiceComboBox) {

		Set<String> forbiddenChars = Set.of("|", ",", "*", "%", "=", "{", "}");
		String txt;
		String getName = inputName.getText().trim();
		String getSelectedClass = (String) choiceComboBox.getSelectedItem();
		boolean hasForbiddenChar = forbiddenChars.stream().anyMatch(getName::contains);
		boolean invalidName = getName.isEmpty() || rpg.heroExists(getName) || hasForbiddenChar;
	
		if (invalidName || getName.equalsIgnoreCase("x")) {
			txt = "<html><div align='center' style='color: red;'>"
				+ "Name already exists or contains Forbidden characters!<br/>"
				+ "<b>Try again</b>"
				+ "</div></html>";
		}
		else {
			rpg.registerHeroName(getName);
			String characterClass = switch (getSelectedClass) {
				case "Warrior" -> WARRIOR_CLASS;
				case "Mage" -> MAGE_CLASS;
				case "Archer" -> ARCHER_CLASS;
				case "Paladin" -> PALADIN_CLASS;
				case "Assassin" -> ASSASSIN_CLASS;
				default -> "";
			};
			Characters newHero = CharactersFactory.getInstance().newCharacters(HERO_TYPE, getName, characterClass);
			String att = Integer.toString(newHero.getAttack());
			String def = Integer.toString(newHero.getDefense());
			String hp = Integer.toString(newHero.getMaxHitPoint());
	
			rpg.getListAvaible().add(CharactersFactory.getInstance().newCharacters(HERO_TYPE, getName, characterClass));
	
			GuiHeroManagerPage.updateHeroComboBox(rpg);
			GuiPlayPage.updateHeroComboBox(rpg);
			
			txt = "<html><div align='center'>"
				+ "NAME<br/>"
				+ "<b style='font-size: 25px'>" + getName + "</b><br/><br/>"
				+ "CLASS<br/>"
				+ "<b style='font-size: 25px'>" + getSelectedClass + "</b><br/><br/>"
				+ "ATT<br/>"
				+ "<b style='font-size: 25px'>" + att + "</b><br/><br/>"
				+ "DEF<br/>"
				+ "<b style='font-size: 25px'>" + def + "</b><br/><br/>"
				+ "HP<br/>"
				+ "<b style='font-size: 25px'>" + hp + "</b>"
				+ "</div></html>";
		}
		return txt;
	}
}
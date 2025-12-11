package com.swingy.controller;

import static com.swingy.utils.Constants.*;

import java.util.Set;

import com.swingy.model.Characters;
import com.swingy.model.CharactersFactory;

public class GuiCreationController {

	public static String createHero(Game rpg, String inputName, String selectedClass) {

		Set<String> forbiddenChars = Set.of("|", ",", "*", "%", "=", "{", "}");
		String txt;
		boolean hasForbiddenChar = forbiddenChars.stream().anyMatch(inputName::contains);
		boolean invalidName = inputName.isEmpty() || rpg.heroExists(inputName) || hasForbiddenChar;
	
		if (invalidName || inputName.equalsIgnoreCase("x")) {
			txt = "<html><div align='center' style='color: red;'>"
				+ "Name already exists or contains Forbidden characters!<br/>"
				+ "<b>Try again</b>"
				+ "</div></html>";
		}
		else {
			rpg.registerHeroName(inputName);
			String characterClass = switch (selectedClass) {
				case "Warrior" -> WARRIOR_CLASS;
				case "Mage" -> MAGE_CLASS;
				case "Archer" -> ARCHER_CLASS;
				case "Paladin" -> PALADIN_CLASS;
				case "Assassin" -> ASSASSIN_CLASS;
				default -> "";
			};
			Characters newHero = CharactersFactory.getInstance().newCharacters(HERO_TYPE, inputName, characterClass);
			String att = Integer.toString(newHero.getAttack());
			String def = Integer.toString(newHero.getDefense());
			String hp = Integer.toString(newHero.getMaxHitPoint());
	
			rpg.getListAvaible().add(CharactersFactory.getInstance().newCharacters(HERO_TYPE, inputName, characterClass));
			
			txt = "<html><div align='center'>"
				+ "NAME<br/>"
				+ "<b style='font-size: 25px'>" + inputName + "</b><br/><br/>"
				+ "CLASS<br/>"
				+ "<b style='font-size: 25px'>" + selectedClass + "</b><br/><br/>"
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
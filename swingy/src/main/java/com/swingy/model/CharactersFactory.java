package com.swingy.model;

import static com.swingy.utils.Constants.*;
import com.swingy.view.DisplayController;

public class CharactersFactory {

	private static CharactersFactory instance;

	/* -------------------------------------------------- CONSTRUCTOR -------------------------------------------------- */

	private CharactersFactory() {}

	/* -------------------------------------------------- INSTANCE GETTER -------------------------------------------------- */

	public static CharactersFactory getInstance() {
		if (instance == null) {
			instance = new CharactersFactory();
		}
		return instance;
	}

	/* -------------------------------------------------- METHOD CHARACTERS_FACTORY -------------------------------------------------- */

	public Characters newCharacters(String type, String name, String characterClass) {
		switch (type) {
			case HERO_TYPE:
				return new Hero(type, name, characterClass);
			case ENEMY_TYPE:
				return new Enemy(type, name, characterClass);
			default:
				DisplayController.getInstance().printNormal(RED_BOLD + "Error: unknown type!" + RESET);
		}
		return null;
	}
}
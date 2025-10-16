package com.swingy.model;

import com.swingy.model.Hero;
import com.swingy.model.Enemy;
import static com.swingy.utils.Constants.*;;

public class CharactersFactory {
	private static CharactersFactory instance;

	private CharactersFactory() {}

	public static CharactersFactory getInstance() {
		if (instance == null) {
			instance = new CharactersFactory();
		}
		return instance;
	}

	public Characters newCharacters(String type, String name, String characterClass) {
		switch (type) {
			case HERO_TYPE:
				return new Hero(type, name, characterClass);
			case ENEMY_TYPE:
				return new Enemy(type, name, characterClass);
			default:
				System.out.println(RED_BOLD + "Error: unknown type!" + RESET);
		}
		return null;
	}
}
package com.swingy.model;

public class HeroFactory {
	private static HeroFactory instance;

	private HeroFactory() {}

	public static HeroFactory getInstance() {
		if (instance == null)
			instance = new HeroFactory();
		return instance;
	}

	public Characters newHero(String type, String name, String characterClass) {
		return new Hero(type, name, characterClass);
	}
}
package com.swingy.model;

public class MapFactory {

	private static MapFactory instance;

	/* -------------------------------------------------- CONSTRUCTOR -------------------------------------------------- */

	private MapFactory() {};

	/* -------------------------------------------------- INSTANCE GETTER -------------------------------------------------- */

	public static MapFactory getInstance() {
		if (instance == null) {
			instance = new MapFactory();
		}
		return instance;
	}

	/* -------------------------------------------------- METHOD MAP_FACTORY -------------------------------------------------- */

	public Maps newMap(Characters hero) {
		return new Maps(hero);
	}
}
package com.swingy.model;

public class MapFactory {
	private static MapFactory instance;

	private MapFactory() {};

	public static MapFactory getInstance() {
		if (instance == null) {
			instance = new MapFactory();
		}
		return instance;
	}

	public Maps newMap(Characters hero) {
		return new Maps(hero);
	}
}
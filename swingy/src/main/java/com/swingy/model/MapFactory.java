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

	public Map newMap(Characters hero) {
		return new Map(hero);
	}
}
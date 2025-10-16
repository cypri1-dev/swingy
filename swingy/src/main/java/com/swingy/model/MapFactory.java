package com.swingy.model;

import com.swingy.model.Map;

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
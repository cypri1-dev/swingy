package com.swingy.model;

public class EnemyFactory {
	private static EnemyFactory instance;

	private EnemyFactory() {}

	public static EnemyFactory getInstance() {
		if (instance == null)
			instance = new EnemyFactory();
		return instance;
	}

	public Characters newEnemy(String type, String name, String characterClass) {
		return new Enemy(type, name, characterClass);
	}
}
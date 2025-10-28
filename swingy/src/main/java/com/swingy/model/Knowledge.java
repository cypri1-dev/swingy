package com.swingy.model;

import java.util.HashMap;
import java.util.Map;

public class Knowledge {

	private static Knowledge instance;
	private Map<String, Integer> knowledge;

	private Knowledge() {
		this.knowledge = new HashMap<>();
	}

	public static Knowledge getInstance() {
		if (instance == null)
			instance = new Knowledge();
		return instance;
	}

	public void addKnowledge(Characters enemy) {
		if (knowledge.get(enemy.getCharacterClass()) == null) {
			knowledge.put(enemy.getCharacterClass(), 1);
		}
		else
			knowledge.put(enemy.getCharacterClass(), knowledge.get(enemy.getCharacterClass()) + 1);
	}

	public Map<String, Integer> getMap() {return this.knowledge;}
}
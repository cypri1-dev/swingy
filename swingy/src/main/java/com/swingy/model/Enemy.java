package com.swingy.model;

public class Enemy extends Characters {

	/* -------------------------------------------------- CONSTRUCTOR -------------------------------------------------- */

	public Enemy(String type, String name, String characterClass) {
		super(type, name, characterClass);
		this.setLevel(0);
	}
}
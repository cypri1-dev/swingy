package com.swingy.model;

import com.swingy.controller.GameMovement;

public class Hero extends Characters {
	private GameMovement movement;

	/* -------------------------------------------------- CONSTRUCTOR -------------------------------------------------- */

	public Hero(String type, String name, String characterClass) {
		super(type, name, characterClass);
		this.setLevel(1);
		this.setXp(0);
		this.movement = new GameMovement();
	}
	
	/* -------------------------------------------------- GETTER -------------------------------------------------- */

	public GameMovement getMovement() {return this.movement;}
}
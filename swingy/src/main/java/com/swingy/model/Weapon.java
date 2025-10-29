package com.swingy.model;

public class Weapon extends Artefact {

	/* -------------------------------------------------- CONSTRUCTOR -------------------------------------------------- */

	public Weapon(String type, String name, String rarity, int bonus) {
		super(type, name, rarity, bonus);
		this.setIsEquipped(false);
	}
}
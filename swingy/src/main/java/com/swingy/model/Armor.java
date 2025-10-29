package com.swingy.model;

public class Armor extends Artefact {
	
	/* -------------------------------------------------- CONSTRUCTOR -------------------------------------------------- */

	public Armor(String type, String name, String rarity, int bonus) {
		super(type, name, rarity, bonus);
		this.setIsEquipped(false);
	}
}
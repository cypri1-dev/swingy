package com.swingy.model;

public class Consommable extends Artefact {
	
	/* -------------------------------------------------- CONSTRUCTOR -------------------------------------------------- */
	
	public Consommable(String type, String name, String rarity, int bonus) {
		super(type, name, rarity, bonus);
		this.setIsEquipped(false);
	}
}
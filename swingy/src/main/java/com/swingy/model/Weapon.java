package com.swingy.model;

public class Weapon extends Artefact {
	public Weapon(String type, String name, int bonus) {
		super(type, name, bonus);
		this.setIsEquipped(false);
	}
}
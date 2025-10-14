package com.swingy.model;

public class Armor extends Artefact {
	public Armor(String type, String name, int bonus) {
		super(type, name, bonus);
		this.setIsEquipped(false);
	}
}
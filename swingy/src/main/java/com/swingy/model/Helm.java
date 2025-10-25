package com.swingy.model;

public class Helm extends Artefact {
	public Helm(String type, String name, String rarity, int bonus) {
		super(type, name, rarity, bonus);
		this.setIsEquipped(false);
	}
}
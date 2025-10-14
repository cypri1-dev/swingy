package com.swingy.model;

public class Helm extends Artefact {
	public Helm(String type, String name, int bonus) {
		super(type, name, bonus);
		this.setIsEquipped(false);
	}
}
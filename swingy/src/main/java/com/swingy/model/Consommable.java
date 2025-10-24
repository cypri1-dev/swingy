package com.swingy.model;

public class Consommable extends Artefact {
		public Consommable(String type, String name, int bonus) {
		super(type, name, bonus);
		this.setIsEquipped(false);
	}
}
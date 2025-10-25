package com.swingy.model;

import static com.swingy.utils.Constants.*;

public class ArtefactFactory {
	private static ArtefactFactory instance;

	private ArtefactFactory() {}

	public static ArtefactFactory getInstance() {
		if (instance == null)
			instance = new ArtefactFactory();
		return instance;
	}

	public Artefact newArtefact(String type, String name, int bonus) {
		switch(type) {
			case ARMOR_TYPE:
				return new Armor(type, name, bonus);
			case HELM_TYPE:
				return new Helm(type, name, bonus);
			case WEAPON_TYPE:
				return new Weapon(type, name, bonus);
			case CONSOMMABLE_TYPE:
				return new Consommable(type, name, bonus);
			default:
				System.out.println(RED_BOLD + "Error: unknown type!" + RESET);
		}
		return null;
	}
}
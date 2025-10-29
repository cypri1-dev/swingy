package com.swingy.model;

import static com.swingy.utils.Constants.*;

import com.swingy.view.DisplayController;

public class ArtefactFactory {

	private static ArtefactFactory instance;

	/* -------------------------------------------------- CONSTRUCTOR -------------------------------------------------- */

	private ArtefactFactory() {}

	/* -------------------------------------------------- INSTANCE GETTER -------------------------------------------------- */

	public static ArtefactFactory getInstance() {
		if (instance == null)
			instance = new ArtefactFactory();
		return instance;
	}

	/* -------------------------------------------------- METHOD ARTEFACT_FACTORY -------------------------------------------------- */

	public Artefact newArtefact(String type, String name, String rarity, int bonus) {

		switch(type) {
			case ARMOR_TYPE:
				return new Armor(type, name, rarity, bonus);
			case HELM_TYPE:
				return new Helm(type, name, rarity, bonus);
			case WEAPON_TYPE:
				return new Weapon(type, name, rarity, bonus);
			case CONSOMMABLE_TYPE:
				return new Consommable(type, name, rarity, bonus);
			default:
				DisplayController.getInstance().printNormal(RED_BOLD + "Error: unknown type!" + RESET);
		}
		return null;
	}
}
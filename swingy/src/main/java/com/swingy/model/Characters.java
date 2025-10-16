package com.swingy.model;

import static com.swingy.utils.Constants.*;
import java.util.ArrayList;
import java.util.List;

public class Characters {
	private String type;
	private String name;
	private String characterClass;
	private int level;
	private int xp;
	private int attack;
	private int defense;
	private int hitPoint;
	private List<Artefact> bag;
	private Coordinates coord;

	protected Characters(String type, String name, String characterClass) {
		this.type = type;
		this.name = name;
		this.characterClass = characterClass;
		this.bag = new ArrayList<Artefact>();
		this.coord = new Coordinates(0, 0);

		switch(characterClass) {
			case WARRIOR_CLASS:
				setHitPoint(HP_BASE + HP_WARRIOR);
				setAttack(ATT_BASE + ATT_WARRIOR);
				setDefense(DEF_BASE + DEF_WARRIOR);
				break;
			case MAGE_CLASS:
				setHitPoint(HP_BASE + HP_MAGE);
				setAttack(ATT_BASE + ATT_MAGE);
				setDefense(DEF_BASE + DEF_MAGE);
				break;
			case ARCHER_CLASS:
				setHitPoint(HP_BASE + HP_ARCHER);
				setAttack(ATT_BASE + ATT_ARCHER);
				setDefense(DEF_BASE + DEF_ARCHER);
				break;
			case PALADIN_CLASS:
				setHitPoint(HP_BASE + HP_PALADIN);
				setAttack(ATT_BASE + ATT_PALADIN);
				setDefense(DEF_BASE + DEF_PALADIN);
				break;
			case ASSASSIN_CLASS:
				setHitPoint(HP_BASE + HP_ASSASSIN);
				setAttack(ATT_BASE + ATT_ASSASSIN);
				setDefense(DEF_BASE + DEF_ASSASSIN);
				break;
			default:
				System.out.println(RED_BOLD + "Error: unkown class!" + RESET);
		}
	}

	protected void setName(String name) {this.name = name;}
	protected void setClass(String characterClass) {this.characterClass = characterClass;}
	protected void setLevel(int level) {this.level = level;}
	protected void setXp(int xp) {this.xp = xp;}
	protected void addXp(int xp) {this.xp += xp;}
	protected void setAttack(int attack) {this.attack += attack;}
	protected void setDefense(int defense) {this.defense += defense;}
	protected void setHitPoint(int hp) {this.hitPoint += hp;}
	
	public void addArtefact(Artefact item) {this.bag.add(item);}
	public void removeArtefact(Artefact item) {this.bag.remove(item);}

	public void equipArtefact(Artefact item) {

		for (Artefact artefact : bag) {
			if (artefact.getIsEquipped() && item.getType() == artefact.getType()) {
				System.out.println(ORANGE_BOLD + "Artefact type is already equipped!");
				return;
			}
			if (item.getName() == artefact.getName()) {
				item.setIsEquipped(true);
				switch (item.getType()) {
					case ARMOR_TYPE:
						this.setDefense(item.getBonus());
						break;
					case HELM_TYPE:
						this.setHitPoint(item.getBonus());
						break;
					case WEAPON_TYPE:
						this.setAttack(item.getBonus());
						break;
					default:
						System.out.println(RED_BOLD + "Error: unknown weapon type!");
				}
				return;
			}
		}
		System.out.println(ORANGE_BOLD + "Error: no such Artefact!" + RESET);
	}

	public void unequipArtefact(Artefact item) {
		for (Artefact artefact : bag) {
			if (artefact.getName() == item.getName()) {
				item.setIsEquipped(false);
				switch (item.getType()) {
					case ARMOR_TYPE:
						this.setDefense(-item.getBonus());
						break;
					case HELM_TYPE:
						this.setHitPoint(-item.getBonus());
						break;
					case WEAPON_TYPE:
						this.setAttack(-item.getBonus());
						break;
					default:
						System.out.println(RED_BOLD + "Error: unknown weapon type!");
				}
				return;
			}
		}
		System.out.println(ORANGE_BOLD + "Error: no such Artefact!" + RESET);
	}

	public String getName() {return this.name;}
	public String getType() {return this.type;}
	public String getCharacterClass() {return this.characterClass;}
	public int getLevel() {return this.level;}
	public int getXp() {return this.xp;}
	public int getAttack() {return this.attack;}
	public int getDefense() {return this.defense;}
	public int getHitPoint() {return this.hitPoint;}
	public List<Artefact> getArtefacts() {return this.bag;}
	public Coordinates getCoordinates() {return this.coord;}
}
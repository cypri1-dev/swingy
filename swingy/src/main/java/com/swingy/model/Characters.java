package com.swingy.model;

import static com.swingy.utils.Constants.*;
import java.util.ArrayList;
import java.util.List;

import com.swingy.controller.GameMovement;
import com.swingy.model.Knowledge;

public class Characters {
	private String type;
	private String name;
	private String characterClass;
	private int level;
	private int xp;
	private int attack;
	private int defense;
	private int hitPoint;
	private int maxHitPoint;
	private List<Artefact> bag;
	private Coordinates coord;
	private Knowledge knowledge;

	protected Characters(String type, String name, String characterClass) {
		this.type = type;
		this.name = name;
		this.characterClass = characterClass;
		this.bag = new ArrayList<Artefact>();
		this.knowledge = Knowledge.getInstance();
		this.coord = new Coordinates(0, 0);

		switch (characterClass) {
			case WARRIOR_CLASS:
				setHitPoint(HP_BASE + HP_WARRIOR);
				setMaxHitPoint(HP_BASE + HP_WARRIOR);
				setAttack(ATT_BASE + ATT_WARRIOR);
				setDefense(DEF_BASE + DEF_WARRIOR);
				break;

			case MAGE_CLASS:
				setHitPoint(HP_BASE + HP_MAGE);
				setMaxHitPoint(HP_BASE + HP_MAGE);
				setAttack(ATT_BASE + ATT_MAGE);
				setDefense(DEF_BASE + DEF_MAGE);
				break;

			case ARCHER_CLASS:
				setHitPoint(HP_BASE + HP_ARCHER);
				setMaxHitPoint(HP_BASE + HP_ARCHER);
				setAttack(ATT_BASE + ATT_ARCHER);
				setDefense(DEF_BASE + DEF_ARCHER);
				break;

			case PALADIN_CLASS:
				setHitPoint(HP_BASE + HP_PALADIN);
				setMaxHitPoint(HP_BASE + HP_PALADIN);
				setAttack(ATT_BASE + ATT_PALADIN);
				setDefense(DEF_BASE + DEF_PALADIN);
				break;

			case ASSASSIN_CLASS:
				setHitPoint(HP_BASE + HP_ASSASSIN);
				setMaxHitPoint(HP_BASE + HP_ASSASSIN);
				setAttack(ATT_BASE + ATT_ASSASSIN);
				setDefense(DEF_BASE + DEF_ASSASSIN);
				break;

			case ENEMY_CLASS_GOBELIN:
				setHitPoint(HP_BASE_ENEMY + HP_GOBLIN);
				setAttack(ATT_BASE_ENEMY + ATT_GOBLIN);
				setDefense(DEF_BASE_ENEMY + DEF_GOBLIN);
				setXp(XP_GOBLIN);
				break;

			case ENEMY_CLASS_ORC:
				setHitPoint(HP_BASE_ENEMY + HP_ORC);
				setAttack(ATT_BASE_ENEMY + ATT_ORC);
				setDefense(DEF_BASE_ENEMY + DEF_ORC);
				setXp(XP_ORC);
				break;

			case ENEMY_CLASS_SKELETON:
				setHitPoint(HP_BASE_ENEMY + HP_SKELETON);
				setAttack(ATT_BASE_ENEMY + ATT_SKELETON);
				setDefense(DEF_BASE_ENEMY + DEF_SKELETON);
				setXp(XP_SKELETON);
				break;

			case ENEMY_CLASS_BANDIT:
				setHitPoint(HP_BASE_ENEMY + HP_BANDIT);
				setAttack(ATT_BASE_ENEMY + ATT_BANDIT);
				setDefense(DEF_BASE_ENEMY + DEF_BANDIT);
				setXp(XP_BANDIT);
				break;

			case ENEMY_CLASS_DARK_MAGE:
				setHitPoint(HP_BASE_ENEMY + HP_DARK_MAGE);
				setAttack(ATT_BASE_ENEMY + ATT_DARK_MAGE);
				setDefense(DEF_BASE_ENEMY + DEF_DARK_MAGE);
				setXp(XP_DARK_MAGE);
				break;

			case ENEMY_CLASS_TROLL:
				setHitPoint(HP_BASE_ENEMY + HP_TROLL);
				setAttack(ATT_BASE_ENEMY + ATT_TROLL);
				setDefense(DEF_BASE_ENEMY + DEF_TROLL);
				setXp(XP_TROLL);
				break;

			case ENEMY_CLASS_ASSASSIN:
				setHitPoint(HP_BASE_ENEMY + HP_ASSASSIN_ENEMY);
				setAttack(ATT_BASE_ENEMY + ATT_ASSASSIN_ENEMY);
				setDefense(DEF_BASE_ENEMY + DEF_ASSASSIN_ENEMY);
				setXp(XP_ASSASSIN_ENEMY);
				break;

			case ENEMY_CLASS_CULTIST:
				setHitPoint(HP_BASE_ENEMY + HP_CULTIST);
				setAttack(ATT_BASE_ENEMY + ATT_CULTIST);
				setDefense(DEF_BASE_ENEMY + DEF_CULTIST);
				setXp(XP_CULTIST);
				break;

			case ENEMY_CLASS_ELEMENTAL:
				setHitPoint(HP_BASE_ENEMY + HP_ELEMENTAL);
				setAttack(ATT_BASE_ENEMY + ATT_ELEMENTAL);
				setDefense(DEF_BASE_ENEMY + DEF_ELEMENTAL);
				setXp(XP_ELEMENTAL);
				break;

			case ENEMY_CLASS_DRAGON_WHELP:
				setHitPoint(HP_BASE_ENEMY + HP_DRAGON_WHELP);
				setAttack(ATT_BASE_ENEMY + ATT_DRAGON_WHELP);
				setDefense(DEF_BASE_ENEMY + DEF_DRAGON_WHELP);
				setXp(XP_DRAGON_WHELP);
				break;

			default:
				System.out.println(RED_BOLD + "Error: unknown class!" + RESET);
		}
	}

	protected void setName(String name) {this.name = name;}
	protected void setClass(String characterClass) {this.characterClass = characterClass;}
	protected void setLevel(int level) {this.level = level;}
	protected void setXp(int xp) {this.xp = xp;}
	protected void addXp(int xp) {this.xp += xp;}
	protected void setAttack(int attack) {this.attack += attack;}
	protected void setDefense(int defense) {this.defense += defense;}
	public void setHitPoint(int hp) {this.hitPoint += hp;}
	public void setMaxHitPoint(int hp) {this.maxHitPoint += hp;}
	public void setHealHp(int hp) {this.hitPoint = hp;}

	public void addXP(int amount) {
		int nextLevel = (int) (this.level * 1000 + Math.pow(this.level - 1, 2) * 450);
		this.xp += amount;

		if (this.xp >= nextLevel) {
			this.xp = 0;
			this.level += 1;
		}
	}
	
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
	public int getMaxHitPoint() {return this.maxHitPoint;}
	public GameMovement getMovement() {return null;}
	public List<Artefact> getArtefacts() {return this.bag;}
	public Coordinates getCoordinates() {return this.coord;}
	public Knowledge getKnowledge() {return this.knowledge;}
}
package com.swingy.model;

import java.util.ArrayList;
import java.util.List;

import static com.swingy.utils.Constants.*;
import com.swingy.controller.GameMovement;
import com.swingy.view.DisplayController;

import javax.swing.Icon;

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
	private Icon token;

	/* -------------------------------------------------- CONSTRUCTOR -------------------------------------------------- */

	protected Characters(String type, String name, String characterClass) {

		this.type = type;
		this.name = name;
		this.characterClass = characterClass;
		this.bag = new ArrayList<Artefact>();
		this.knowledge = Knowledge.getInstance();
		this.coord = new Coordinates(0, 0);
		this.token = null;

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

			case ENEMY_CLASS_RAT:
				setHitPoint(HP_BASE_ENEMY + HP_RAT);
				setMaxHitPoint(HP_BASE_ENEMY + HP_RAT);
				setAttack(ATT_BASE_ENEMY + ATT_RAT);
				setDefense(DEF_BASE_ENEMY + DEF_RAT);
				setXp(XP_RAT);
				setLevel(1);
				break;

			case ENEMY_CLASS_SLIME:
				setHitPoint(HP_BASE_ENEMY + HP_SLIME);
				setMaxHitPoint(HP_BASE_ENEMY + HP_SLIME);
				setAttack(ATT_BASE_ENEMY + ATT_SLIME);
				setDefense(DEF_BASE_ENEMY + DEF_SLIME);
				setXp(XP_SLIME);
				setLevel(2);
				break;

			case ENEMY_CLASS_GOBLIN:
				setHitPoint(HP_BASE_ENEMY + HP_GOBLIN);
				setMaxHitPoint(HP_BASE_ENEMY + HP_GOBLIN);
				setAttack(ATT_BASE_ENEMY + ATT_GOBLIN);
				setDefense(DEF_BASE_ENEMY + DEF_GOBLIN);
				setXp(XP_GOBLIN);
				setLevel(3);
				break;

			case ENEMY_CLASS_BANDIT:
				setHitPoint(HP_BASE_ENEMY + HP_BANDIT);
				setMaxHitPoint(HP_BASE_ENEMY + HP_BANDIT);
				setAttack(ATT_BASE_ENEMY + ATT_BANDIT);
				setDefense(DEF_BASE_ENEMY + DEF_BANDIT);
				setXp(XP_BANDIT);
				setLevel(4);
				break;

			case ENEMY_CLASS_SKELETON:
				setHitPoint(HP_BASE_ENEMY + HP_SKELETON);
				setMaxHitPoint(HP_BASE_ENEMY + HP_SKELETON);
				setAttack(ATT_BASE_ENEMY + ATT_SKELETON);
				setDefense(DEF_BASE_ENEMY + DEF_SKELETON);
				setXp(XP_SKELETON);
				setLevel(5);
				break;

			case ENEMY_CLASS_WOLF:
				setHitPoint(HP_BASE_ENEMY + HP_WOLF);
				setMaxHitPoint(HP_BASE_ENEMY + HP_WOLF);
				setAttack(ATT_BASE_ENEMY + ATT_WOLF);
				setDefense(DEF_BASE_ENEMY + DEF_WOLF);
				setXp(XP_WOLF);
				setLevel(6);
				break;

			case ENEMY_CLASS_CULTIST:
				setHitPoint(HP_BASE_ENEMY + HP_CULTIST);
				setMaxHitPoint(HP_BASE_ENEMY + HP_CULTIST);
				setAttack(ATT_BASE_ENEMY + ATT_CULTIST);
				setDefense(DEF_BASE_ENEMY + DEF_CULTIST);
				setXp(XP_CULTIST);
				setLevel(7);
				break;

			case ENEMY_CLASS_ORC:
				setHitPoint(HP_BASE_ENEMY + HP_ORC);
				setMaxHitPoint(HP_BASE_ENEMY + HP_ORC);
				setAttack(ATT_BASE_ENEMY + ATT_ORC);
				setDefense(DEF_BASE_ENEMY + DEF_ORC);
				setXp(XP_ORC);
				setLevel(8);
				break;

			case ENEMY_CLASS_DARK_MAGE:
				setHitPoint(HP_BASE_ENEMY + HP_DARK_MAGE);
				setMaxHitPoint(HP_BASE_ENEMY + HP_DARK_MAGE);
				setAttack(ATT_BASE_ENEMY + ATT_DARK_MAGE);
				setDefense(DEF_BASE_ENEMY + DEF_DARK_MAGE);
				setXp(XP_DARK_MAGE);
				setLevel(9);
				break;

			case ENEMY_CLASS_ELEMENTAL:
				setHitPoint(HP_BASE_ENEMY + HP_ELEMENTAL);
				setMaxHitPoint(HP_BASE_ENEMY + HP_ELEMENTAL);
				setAttack(ATT_BASE_ENEMY + ATT_ELEMENTAL);
				setDefense(DEF_BASE_ENEMY + DEF_ELEMENTAL);
				setXp(XP_ELEMENTAL);
				setLevel(10);
				break;

			case ENEMY_CLASS_TROLL:
				setHitPoint(HP_BASE_ENEMY + HP_TROLL);
				setMaxHitPoint(HP_BASE_ENEMY + HP_TROLL);
				setAttack(ATT_BASE_ENEMY + ATT_TROLL);
				setDefense(DEF_BASE_ENEMY + DEF_TROLL);
				setXp(XP_TROLL);
				setLevel(11);
				break;

			case ENEMY_CLASS_ASSASSIN:
				setHitPoint(HP_BASE_ENEMY + HP_ASSASSIN_ENEMY);
				setMaxHitPoint(HP_BASE_ENEMY + HP_ASSASSIN_ENEMY);
				setAttack(ATT_BASE_ENEMY + ATT_ASSASSIN_ENEMY);
				setDefense(DEF_BASE_ENEMY + DEF_ASSASSIN_ENEMY);
				setXp(XP_ASSASSIN_ENEMY);
				setLevel(12);
				break;

			case ENEMY_CLASS_LICH:
				setHitPoint(HP_BASE_ENEMY + HP_LICH);
				setMaxHitPoint(HP_BASE_ENEMY + HP_LICH);
				setAttack(ATT_BASE_ENEMY + ATT_LICH);
				setDefense(DEF_BASE_ENEMY + DEF_LICH);
				setXp(XP_LICH);
				setLevel(13);
				break;

			case ENEMY_CLASS_MINOTAUR:
				setHitPoint(HP_BASE_ENEMY + HP_MINOTAUR);
				setMaxHitPoint(HP_BASE_ENEMY + HP_MINOTAUR);
				setAttack(ATT_BASE_ENEMY + ATT_MINOTAUR);
				setDefense(DEF_BASE_ENEMY + DEF_MINOTAUR);
				setXp(XP_MINOTAUR);
				setLevel(14);
				break;

			case ENEMY_CLASS_VAMPIRE_LORD:
				setHitPoint(HP_BASE_ENEMY + HP_VAMPIRE_LORD);
				setMaxHitPoint(HP_BASE_ENEMY + HP_VAMPIRE_LORD);
				setAttack(ATT_BASE_ENEMY + ATT_VAMPIRE_LORD);
				setDefense(DEF_BASE_ENEMY + DEF_VAMPIRE_LORD);
				setXp(XP_VAMPIRE_LORD);
				setLevel(15);
				break;

			case ENEMY_CLASS_DEMON_KNIGHT:
				setHitPoint(HP_BASE_ENEMY + HP_DEMON_KNIGHT);
				setMaxHitPoint(HP_BASE_ENEMY + HP_DEMON_KNIGHT);
				setAttack(ATT_BASE_ENEMY + ATT_DEMON_KNIGHT);
				setDefense(DEF_BASE_ENEMY + DEF_DEMON_KNIGHT);
				setXp(XP_DEMON_KNIGHT);
				setLevel(16);
				break;

			case ENEMY_CLASS_DRAGON_WHELP:
				setHitPoint(HP_BASE_ENEMY + HP_DRAGON_WHELP);
				setMaxHitPoint(HP_BASE_ENEMY + HP_DRAGON_WHELP);
				setAttack(ATT_BASE_ENEMY + ATT_DRAGON_WHELP);
				setDefense(DEF_BASE_ENEMY + DEF_DRAGON_WHELP);
				setXp(XP_DRAGON_WHELP);
				setLevel(17);
				break;

			case ENEMY_CLASS_ANCIENT_DRAGON:
				setHitPoint(HP_BASE_ENEMY + HP_ANCIENT_DRAGON);
				setMaxHitPoint(HP_BASE_ENEMY + HP_ANCIENT_DRAGON);
				setAttack(ATT_BASE_ENEMY + ATT_ANCIENT_DRAGON);
				setDefense(DEF_BASE_ENEMY + DEF_ANCIENT_DRAGON);
				setXp(XP_ANCIENT_DRAGON);
				setLevel(18);
				break;

			case ENEMY_CLASS_ABYSSAL_HYDRA:
				setHitPoint(HP_BASE_ENEMY + HP_ABYSSAL_HYDRA);
				setMaxHitPoint(HP_BASE_ENEMY + HP_ABYSSAL_HYDRA);
				setAttack(ATT_BASE_ENEMY + ATT_ABYSSAL_HYDRA);
				setDefense(DEF_BASE_ENEMY + DEF_ABYSSAL_HYDRA);
				setXp(XP_ABYSSAL_HYDRA);
				setLevel(19);
				break;

			case ENEMY_CLASS_FALLEN_GOD:
				setHitPoint(HP_BASE_ENEMY + HP_FALLEN_GOD);
				setMaxHitPoint(HP_BASE_ENEMY + HP_FALLEN_GOD);
				setAttack(ATT_BASE_ENEMY + ATT_FALLEN_GOD);
				setDefense(DEF_BASE_ENEMY + DEF_FALLEN_GOD);
				setXp(XP_FALLEN_GOD);
				setLevel(20);
				break;

			case ENEMY_CLASS_BAT:
				setHitPoint(HP_BASE_ENEMY + HP_BAT);
				setMaxHitPoint(HP_BASE_ENEMY + HP_BAT);
				setAttack(ATT_BASE_ENEMY + ATT_BAT);
				setDefense(DEF_BASE_ENEMY + DEF_BAT);
				setXp(XP_BAT);
				setLevel(1);
				break;

			case ENEMY_CLASS_SPIDERLING:
				setHitPoint(HP_BASE_ENEMY + HP_SPIDERLING);
				setMaxHitPoint(HP_BASE_ENEMY + HP_SPIDERLING);
				setAttack(ATT_BASE_ENEMY + ATT_SPIDERLING);
				setDefense(DEF_BASE_ENEMY + DEF_SPIDERLING);
				setXp(XP_SPIDERLING);
				setLevel(1);
				break;

			case ENEMY_CLASS_SKELETAL_HAND:
				setHitPoint(HP_BASE_ENEMY + HP_SKELETAL_HAND);
				setMaxHitPoint(HP_BASE_ENEMY + HP_SKELETAL_HAND);
				setAttack(ATT_BASE_ENEMY + ATT_SKELETAL_HAND);
				setDefense(DEF_BASE_ENEMY + DEF_SKELETAL_HAND);
				setXp(XP_SKELETAL_HAND);
				setLevel(1);
				break;

			case ENEMY_CLASS_MUDLING:
				setHitPoint(HP_BASE_ENEMY + HP_MUDLING);
				setMaxHitPoint(HP_BASE_ENEMY + HP_MUDLING);
				setAttack(ATT_BASE_ENEMY + ATT_MUDLING);
				setDefense(DEF_BASE_ENEMY + DEF_MUDLING);
				setXp(XP_MUDLING);
				setLevel(2);
				break;

			case ENEMY_CLASS_BANDIT_CHIEF:
				setHitPoint(HP_BASE_ENEMY + HP_BANDIT_CHIEF);
				setMaxHitPoint(HP_BASE_ENEMY + HP_BANDIT_CHIEF);
				setAttack(ATT_BASE_ENEMY + ATT_BANDIT_CHIEF);
				setDefense(DEF_BASE_ENEMY + DEF_BANDIT_CHIEF);
				setXp(XP_BANDIT_CHIEF);
				setLevel(8);
				break;

			case ENEMY_CLASS_GOBLIN_SHAMAN:
				setHitPoint(HP_BASE_ENEMY + HP_GOBLIN_SHAMAN);
				setMaxHitPoint(HP_BASE_ENEMY + HP_GOBLIN_SHAMAN);
				setAttack(ATT_BASE_ENEMY + ATT_GOBLIN_SHAMAN);
				setDefense(DEF_BASE_ENEMY + DEF_GOBLIN_SHAMAN);
				setXp(XP_GOBLIN_SHAMAN);
				setLevel(8);
				break;

			case ENEMY_CLASS_WARG:
				setHitPoint(HP_BASE_ENEMY + HP_WARG);
				setMaxHitPoint(HP_BASE_ENEMY + HP_WARG);
				setAttack(ATT_BASE_ENEMY + ATT_WARG);
				setDefense(DEF_BASE_ENEMY + DEF_WARG);
				setXp(XP_WARG);
				setLevel(8);
				break;

			case ENEMY_CLASS_GRAVE_ROBBER:
				setHitPoint(HP_BASE_ENEMY + HP_GRAVE_ROBBER);
				setMaxHitPoint(HP_BASE_ENEMY + HP_GRAVE_ROBBER);
				setAttack(ATT_BASE_ENEMY + ATT_GRAVE_ROBBER);
				setDefense(DEF_BASE_ENEMY + DEF_GRAVE_ROBBER);
				setXp(XP_GRAVE_ROBBER);
				setLevel(8);
				break;

			case ENEMY_CLASS_NECROMANCER:
				setHitPoint(HP_BASE_ENEMY + HP_NECROMANCER);
				setMaxHitPoint(HP_BASE_ENEMY + HP_NECROMANCER);
				setAttack(ATT_BASE_ENEMY + ATT_NECROMANCER);
				setDefense(DEF_BASE_ENEMY + DEF_NECROMANCER);
				setXp(XP_NECROMANCER);
				setLevel(11);
				break;

			case ENEMY_CLASS_WARLOCK:
				setHitPoint(HP_BASE_ENEMY + HP_WARLOCK);
				setMaxHitPoint(HP_BASE_ENEMY + HP_WARLOCK);
				setAttack(ATT_BASE_ENEMY + ATT_WARLOCK);
				setDefense(DEF_BASE_ENEMY + DEF_WARLOCK);
				setXp(XP_WARLOCK);
				setLevel(11);
				break;

			case ENEMY_CLASS_SHADOW_BEAST:
				setHitPoint(HP_BASE_ENEMY + HP_SHADOW_BEAST);
				setMaxHitPoint(HP_BASE_ENEMY + HP_SHADOW_BEAST);
				setAttack(ATT_BASE_ENEMY + ATT_SHADOW_BEAST);
				setDefense(DEF_BASE_ENEMY + DEF_SHADOW_BEAST);
				setXp(XP_SHADOW_BEAST);
				setLevel(11);
				break;

			case ENEMY_CLASS_GOLEM:
				setHitPoint(HP_BASE_ENEMY + HP_GOLEM);
				setMaxHitPoint(HP_BASE_ENEMY + HP_GOLEM);
				setAttack(ATT_BASE_ENEMY + ATT_GOLEM);
				setDefense(DEF_BASE_ENEMY + DEF_GOLEM);
				setXp(XP_GOLEM);
				setLevel(12);
				break;

			case ENEMY_CLASS_DREAD_KNIGHT:
				setHitPoint(HP_BASE_ENEMY + HP_DREAD_KNIGHT);
				setMaxHitPoint(HP_BASE_ENEMY + HP_DREAD_KNIGHT);
				setAttack(ATT_BASE_ENEMY + ATT_DREAD_KNIGHT);
				setDefense(DEF_BASE_ENEMY + DEF_DREAD_KNIGHT);
				setXp(XP_DREAD_KNIGHT);
				setLevel(16);
				break;

			case ENEMY_CLASS_PLAGUE_BRINGER:
				setHitPoint(HP_BASE_ENEMY + HP_PLAGUE_BRINGER);
				setMaxHitPoint(HP_BASE_ENEMY + HP_PLAGUE_BRINGER);
				setAttack(ATT_BASE_ENEMY + ATT_PLAGUE_BRINGER);
				setDefense(DEF_BASE_ENEMY + DEF_PLAGUE_BRINGER);
				setXp(XP_PLAGUE_BRINGER);
				setLevel(16);
				break;

			case ENEMY_CLASS_PYROMANCER:
				setHitPoint(HP_BASE_ENEMY + HP_PYROMANCER);
				setMaxHitPoint(HP_BASE_ENEMY + HP_PYROMANCER);
				setAttack(ATT_BASE_ENEMY + ATT_PYROMANCER);
				setDefense(DEF_BASE_ENEMY + DEF_PYROMANCER);
				setXp(XP_PYROMANCER);
				setLevel(16);
				break;

			case ENEMY_CLASS_SPECTER:
				setHitPoint(HP_BASE_ENEMY + HP_SPECTER);
				setMaxHitPoint(HP_BASE_ENEMY + HP_SPECTER);
				setAttack(ATT_BASE_ENEMY + ATT_SPECTER);
				setDefense(DEF_BASE_ENEMY + DEF_SPECTER);
				setXp(XP_SPECTER);
				setLevel(16);
				break;

			case ENEMY_CLASS_DEMON_OVERLORD:
				setHitPoint(HP_BASE_ENEMY + HP_DEMON_OVERLORD);
				setMaxHitPoint(HP_BASE_ENEMY + HP_DEMON_OVERLORD);
				setAttack(ATT_BASE_ENEMY + ATT_DEMON_OVERLORD);
				setDefense(DEF_BASE_ENEMY + DEF_DEMON_OVERLORD);
				setXp(XP_DEMON_OVERLORD);
				setLevel(20);
				break;

			case ENEMY_CLASS_TITAN:
				setHitPoint(HP_BASE_ENEMY + HP_TITAN);
				setMaxHitPoint(HP_BASE_ENEMY + HP_TITAN);
				setAttack(ATT_BASE_ENEMY + ATT_TITAN);
				setDefense(DEF_BASE_ENEMY + DEF_TITAN);
				setXp(XP_TITAN);
				setLevel(20);
				break;

			case ENEMY_CLASS_VOID_SERPENT:
				setHitPoint(HP_BASE_ENEMY + HP_VOID_SERPENT);
				setMaxHitPoint(HP_BASE_ENEMY + HP_VOID_SERPENT);
				setAttack(ATT_BASE_ENEMY + ATT_VOID_SERPENT);
				setDefense(DEF_BASE_ENEMY + DEF_VOID_SERPENT);
				setXp(XP_VOID_SERPENT);
				setLevel(20);
				break;

			case ENEMY_CLASS_COSMIC_DRAGON:
				setHitPoint(HP_BASE_ENEMY + HP_COSMIC_DRAGON);
				setMaxHitPoint(HP_BASE_ENEMY + HP_COSMIC_DRAGON);
				setAttack(ATT_BASE_ENEMY + ATT_COSMIC_DRAGON);
				setDefense(DEF_BASE_ENEMY + DEF_COSMIC_DRAGON);
				setXp(XP_COSMIC_DRAGON);
				setLevel(20);
				break;


			default:
				DisplayController.getInstance().printNormal(RED_BOLD + "Error: unknown class!" + RESET);
				break;
		}
	}

	/* -------------------------------------------------- SETTERS/GETTERS -------------------------------------------------- */

	protected void setName(String name) {this.name = name;}
	protected void setClass(String characterClass) {this.characterClass = characterClass;}
	protected void setLevel(int level) {this.level = level;}
	protected void setXp(int xp) {this.xp = xp;}
	// protected void addXp(int xp) {this.xp += xp;}
	protected void loadAttack(int attack) {this.attack = attack;}
	protected void loadDefense(int defense) {this.defense = defense;}
	protected void setAttack(int attack) {this.attack += attack;}
	protected void setDefense(int defense) {this.defense += defense;}
	public void setHitPoint(int hp) {this.hitPoint += hp;}
	public void setMaxHitPoint(int hp) {this.maxHitPoint = hp;}
	public void setHealHp(int hp) {this.hitPoint = hp;}
	public void setToken(Icon token) {this.token = token;}

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
	public Icon getToken() {return this.token;}

	/* -------------------------------------------------- CHARACTERS METHOD -------------------------------------------------- */

	public void addArtefact(Artefact item) {this.bag.add(item);}
	public void removeArtefact(Artefact item) {this.bag.remove(item);}

	public void addXP(int amount) {
		int nextLevel = (int) (this.level * 1000 + Math.pow(this.level - 1, 2) * 450);
		this.xp += amount;

		if (this.xp >= nextLevel) {
			this.xp = 0;
			this.level += 1;
		}
	}
	
	public void equipArtefact(Artefact item) {
		if (item.getIsEquipped())
			return;

		for (Artefact artefact : this.bag) {
			if (artefact.getType().equals(item.getType()) && artefact.getIsEquipped()) {
				this.unequipArtefact(artefact);
				break;
			}
		}
		item.setIsEquipped(true);
		int bonus = -1;

		switch (item.getType()) {
			case WEAPON_TYPE:
				int actualAtt = this.attack;
				bonus = item.getBonus();
				this.attack = actualAtt + bonus;
				break;

			case ARMOR_TYPE:
				int actualDef = this.defense;
				bonus = item.getBonus();
				this.defense = actualDef + bonus;
				break;
			
			case HELM_TYPE:
				int actualMaxHp = this.maxHitPoint;
				bonus = item.getBonus();
				this.maxHitPoint = actualMaxHp + bonus;
				break;
			default:
				break;
		}
	}

	public void unequipArtefact(Artefact item) {
		if (!item.getIsEquipped())
			return;
		item.setIsEquipped(false);
		int bonus = -1;

		switch (item.getType()) {
			case WEAPON_TYPE:
				int actualAtt = this.attack;
				bonus = item.getBonus();
				this.attack = actualAtt - bonus;
				break;

			case ARMOR_TYPE:
				int actualDef = this.defense;
				bonus = item.getBonus();
				this.defense = actualDef - bonus;
				break;
			
			case HELM_TYPE:
				int actualMaxHp = this.maxHitPoint;
				bonus = item.getBonus();
				this.maxHitPoint = actualMaxHp - bonus;
				if (this.hitPoint > this.maxHitPoint)
					this.hitPoint = maxHitPoint;
				break;
			default:
				break;
		}
	}
}
package com.swingy.model;

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
	}

	protected void setName(String name) {this.name = name;}
	protected void setClass(String characterClass) {this.characterClass = characterClass;}
	protected void setLevel(int level) {this.level = level;}
	protected void setXp(int xp) {this.xp = xp;}
	protected void addXp(int xp) {this.xp += xp;}
	protected void setAttack(int attack) {this.attack = attack;}
	protected void setDefense(int defense) {this.defense = defense;}
	protected void addArtefact(Artefact item) {this.bag.add(item);}
	protected void removeItem(Artefact item) {this.bag.remove(item);}
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
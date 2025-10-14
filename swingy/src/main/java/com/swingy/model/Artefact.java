package com.swingy.model;

public class Artefact {
	private String type;
	private String name;
	private int bonus;
	private boolean isEquipped;

	protected Artefact(String type, String name, int bonus) {
		this.type = type;
		this.name = name;
		this.bonus = bonus;
	}

	protected void setType(String type) {this.type = type;}
	protected void setName(String name) {this.name = name;}
	protected void setBonus(int bonus) {this.bonus = bonus;}
	protected void setIsEquipped(boolean equipped) {this.isEquipped = equipped;}
	protected String getType() {return this.type;}
	protected String getName() {return this.name;}
	protected int getBonus() {return this.bonus;}
	protected boolean getIsEquipped() {return this.isEquipped;}
}
package com.swingy.model;

import static com.swingy.utils.Constants.*;

public class Artefact {
	private String type;
	private String name;
	private String rarity;
	private int bonus;
	private boolean isEquipped;
	private Coordinates coord;

	protected Artefact(String type, String name, String rarity, int bonus) {
		this.type = type;
		this.bonus = bonus;
		this.rarity = rarity;
		this.coord = new Coordinates(0, 0);

		switch(rarity) {
			case COMMON: this.name = name; break;
			case RARE: this.name = name; break;
			case EPIC: this.name = name; break;
			case LEGENDARY: this.name = name; break;
			default: break;
		}
	}

	protected void setType(String type) {this.type = type;}
	protected void setName(String name) {this.name = name;}
	protected void setBonus(int bonus) {this.bonus = bonus;}
	public void setIsEquipped(boolean equipped) {this.isEquipped = equipped;}
	public String getType() {return this.type;}
	public String getName() {return this.name;}
	public int getBonus() {return this.bonus;}
	public boolean getIsEquipped() {return this.isEquipped;}
	public Coordinates getCoordinates() {return this.coord;}
	public String getRarity() {return this.rarity;}
}
package com.swingy.model;

public class Artefact {
	private String type;
	private String name;
	private int bonus;
	private boolean isEquipped;
	private Coordinates coord;

	protected Artefact(String type, String name, int bonus) {
		this.type = type;
		this.name = name;
		this.bonus = bonus;
		this.coord = new Coordinates(0, 0);
	}

	protected void setType(String type) {this.type = type;}
	protected void setName(String name) {this.name = name;}
	protected void setBonus(int bonus) {this.bonus = bonus;}
	protected void setIsEquipped(boolean equipped) {this.isEquipped = equipped;}
	public String getType() {return this.type;}
	public String getName() {return this.name;}
	public int getBonus() {return this.bonus;}
	public boolean getIsEquipped() {return this.isEquipped;}
	public Coordinates getCoordinates() {return this.coord;}
}
package com.swingy.model;

import java.util.List;
import static com.swingy.utils.Constants.*;

public class Map {
	private int size;
	public char[][] map;
	private List<Characters> enemiesList;
	private Characters mainHero;

	protected Map(Characters hero) {
		this.mainHero = hero;
		this.size =(hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
		this.map = new char[this.size][this.size];
		initMap();
	}

	protected void initMap() {
		int start = this.size /2;
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.map[i][j] = '*';
			}
		}
		mainHero.getCoordinates().setX(start);
		mainHero.getCoordinates().setY(start);
		mainHero.getCoordinates().setPrevX(start);
		mainHero.getCoordinates().setPrevY(start);
		this.map[mainHero.getCoordinates().getX()][mainHero.getCoordinates().getPrevY()] = SYMBOL_MAIN_HERO;
	}

	public int getSize() {return this.size;}
}
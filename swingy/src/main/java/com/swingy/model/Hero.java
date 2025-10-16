package com.swingy.model;

import java.util.List;
import com.swingy.controller.GameMovement;

public class Hero extends Characters {
	private GameMovement movement;

	public Hero(String type, String name, String characterClass) {
		super(type, name, characterClass);
		this.setLevel(1);
		this.setXp(0);
		this.movement = new GameMovement();
	}
}
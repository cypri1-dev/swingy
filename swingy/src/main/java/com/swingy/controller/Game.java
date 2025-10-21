package com.swingy.controller;

import com.swingy.model.Characters;
import com.swingy.model.Map;
// import com.swingy.controller.Menu;
import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Characters> avaibleHeros;
	private Menu menu;
	private Map actualMap;

	public Game() {
		this.avaibleHeros = new ArrayList<Characters>();
		this.menu = new Menu(this);
		this.actualMap = null;
	}

	public Menu getMenu() {return this.menu;}
	public List<Characters> getListAvaible() {return this.avaibleHeros;}
}
package com.swingy.controller;

import javax.swing.Icon;

import com.swingy.model.Characters;

public class GuiLaunchGameController {

	public static String electHeroGame(String selectedHeroName, Game rpg, Icon tokenIcon) {
		String txt = "";

		int level = 0;
		for (Characters hero : rpg.getListAvaible()) {
			if (selectedHeroName.equals(hero.getName())) {
				rpg.setSelectedHero(hero);
				rpg.getMainHero().setToken(tokenIcon);
				level = hero.getLevel();
				break;
			}
		}

		txt = "<html><div style='text-align: center;'>" + selectedHeroName + "<br/>" + "<b>Level </b> " + level + "<br/>" + "</div></html>";

		return txt;
	}
}
package com.swingy.controller;

import static com.swingy.utils.Constants.ARMOR_TYPE;
import static com.swingy.utils.Constants.COMMON;
import static com.swingy.utils.Constants.CONSOMMABLE_TYPE;
import static com.swingy.utils.Constants.EPIC;
import static com.swingy.utils.Constants.HELM_TYPE;
import static com.swingy.utils.Constants.LEGENDARY;
import static com.swingy.utils.Constants.RARE;
import static com.swingy.utils.Constants.WEAPON_TYPE;

import com.swingy.model.Characters;

public class GuiHeroManagementController {

	public static String displaySelectedHero(String selectedHeroName, Game rpg) {
		String txt = "";
		if (selectedHeroName == null) {
			txt = "<html><div style='color:red; text-align:center;'>No hero selected!</div></html>";
			return txt;
		}
		Characters hero = null;
		for (Characters target : rpg.getListAvaible()) {
			if (target.getName().equals(selectedHeroName)) {
				hero = target;
				break;
			}
		}
		if (hero == null) {
			txt = "<html><div style='color:red; text-align:center;'>Hero not found!</div></html>";
			return txt;
		}

		StringBuilder sb = new StringBuilder("<html><div style='font-family: Ancient Modern Tales; font-size: 17px; color: #444444;'>");

		// Titre
		sb.append("<div style='font-weight: bold; font-size: 25px; margin-bottom: 10px;'>⚔️ ")
		.append(hero.getName())
		.append(" the ")
		.append(hero.getCharacterClass().toUpperCase())
		.append(" ⚔️")
		.append("</div>");

		// Stats de base (Level, XP)
		sb.append("<div><i>Level</i>: <span style='color: #ff3c00ff;'>")
		.append(hero.getLevel())
		.append("</span> &nbsp;&nbsp; <i>XP</i>: <span style='color: #ff3c00ff;'>")
		.append(hero.getXp())
		.append("</span></div>");

		// Attack, Defense
		sb.append("<div><i>Attack</i>: <span style='color: #008000;'>")
		.append(hero.getAttack())
		.append("</span> &nbsp;&nbsp; <i>Defense</i>: <span style='color: #008000;'>")
		.append(hero.getDefense())
		.append("</span></div>");

		// Hit Points
		sb.append("<div><i>Hit Points</i>: <span style='color: #FF0000;'>")
		.append(hero.getHitPoint())
		.append("/")
		.append(hero.getMaxHitPoint())
		.append("</span></div>");

		// Bag contents
		sb.append("<div><i>Bag contents:</i></div>");
		if (hero.getArtefacts().isEmpty()) {
			sb.append("<div style='margin-left: 15px; color: #FF0000;'>Empty bag.</div>");
		} else {
			for (var item : hero.getArtefacts()) {
				String equippedMark = item.getIsEquipped() ? "<span style='color:#008000;'>  (E)</span>" : "";

				String color;
				switch (item.getRarity()) {
					case COMMON -> color = "#A0A0A0";
					case RARE -> color = "#0000FF";
					case EPIC -> color = "#800080";
					case LEGENDARY -> color = "#FFA500";
					default -> color = "#000000";
				}

				String type;
				switch (item.getType()) {
					case CONSOMMABLE_TYPE -> type = "HP";
					case WEAPON_TYPE -> type = "ATT";
					case ARMOR_TYPE -> type = "DEF";
					case HELM_TYPE -> type = "HP";
					default -> type = "";
				}

				sb.append("<div style='margin-left: 15px;'>• <span style='color: ")
				.append(color)
				.append("; font-style: italic;'>")
				.append(item.getName())
				.append(" (+")
				.append(item.getBonus())
				.append(") ")
				.append(type)
				.append("</span>")
				.append(equippedMark)
				.append("</div>");
			}
		}

		sb.append("</div></html>");

		return sb.toString();
	}

	public static String deleteHero(String selectedHeroName, Game rpg) {
		String txt = "<html><div style='color:red; text-align:center;'>Hero deleted!</div></html>";
		if (selectedHeroName != null) {
			Characters target = null;
			for (Characters elem : rpg.getListAvaible()) {
				if (elem.getName().equals(selectedHeroName)) {
					target = elem;
					break;
				}
			}
			if (target != null) {
				rpg.getHeroesNameList().remove(selectedHeroName);
				rpg.getListAvaible().remove(target);
			}
		}
		return (txt);
	}
}
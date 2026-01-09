package com.swingy.view;

import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;

import com.swingy.controller.Game;
import com.swingy.model.Maps;
import static com.swingy.utils.Constants.*;

public class GuiMapTab extends GuiCustomPage {

	/************************************************************************ UPDATE MAP METHOD ************************************************************************/

	public static void updateMap(Game rpg, Map<String, ImageIcon> listToken, JPanel grid) {
		GuiMapTab.drawMap(rpg, listToken, grid);
	}

	/************************************************************************ LOAD AND CONFIG TOKEN METHOD ************************************************************************/

	public static void loadToken(Map<String, ImageIcon> listToken, JPanel cell, String nameEnemy) {
		JLabel enemyLabel = new JLabel(rescaleToken(listToken.get(nameEnemy), 65));
		enemyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enemyLabel.setVerticalAlignment(SwingConstants.CENTER);
		cell.add(enemyLabel);
	}
	
	/************************************************************************ DRAW MAP METHOD ************************************************************************/

	public static void drawMap(Game rpg, Map<String, ImageIcon> listToken, JPanel grid) {
		grid.removeAll();

		Maps map = rpg.getMap();
		String[][] mapTab = map.getMapTab();
		int mapSize = map.getSize();

		int viewportSize = 9;
		int halfViewport = viewportSize / 2;

		int heroX = rpg.getMainHero().getCoordinates().getX();
		int heroY = rpg.getMainHero().getCoordinates().getY();

		// Calcul bornes du viewport dans la map en limitant aux bords
		int startX = Math.max(0, heroX - halfViewport);
		int startY = Math.max(0, heroY - halfViewport);
		int endX = Math.min(mapSize - 1, heroX + halfViewport);
		int endY = Math.min(mapSize - 1, heroY + halfViewport);

		// Ajuster si la fenêtre est plus petite que 9 (proche bord)
		if (endX - startX + 1 < viewportSize) {
			if (startX == 0)
				endX = viewportSize - 1;
			else
				startX = mapSize - viewportSize;
		}
		if (endY - startY + 1 < viewportSize) {
			if (startY == 0)
				endY = viewportSize - 1;
			else
				startY = mapSize - viewportSize;
		}

		for (int x = startX; x <= endX; x++) {
			for (int y = startY; y <= endY; y++) {

				JPanel cell = new JPanel();
				cell.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
				cell.setOpaque(false);

				switch (mapTab[x][y]) {
					case SYMBOL_MAIN_HERO:
						JLabel heroLabel = new JLabel(rescaleToken(rpg.getMainHero().getToken(), 65));
						heroLabel.setHorizontalAlignment(SwingConstants.CENTER);
						heroLabel.setVerticalAlignment(SwingConstants.CENTER);
						cell.add(heroLabel);
						break;

					case SYMBOL_ENEMY_RAT: loadToken(listToken, cell, "rat"); break;
					case SYMBOL_ENEMY_SLIME: loadToken(listToken, cell, "slime"); break;
					case SYMBOL_ENEMY_GOBLIN: loadToken(listToken, cell, "gobelin"); break;
					case SYMBOL_ENEMY_BANDIT: loadToken(listToken, cell, "bandit"); break;
					case SYMBOL_ENEMY_BAT: loadToken(listToken, cell, "bat"); break;
					case SYMBOL_ENEMY_SPIDERLING: loadToken(listToken, cell, "spider"); break;
					case SYMBOL_ENEMY_SKELETAL_HAND: loadToken(listToken, cell, "skeletal_hand"); break;
					case SYMBOL_ENEMY_MUDLING: loadToken(listToken, cell, "mudling"); break;

					case SYMBOL_ENEMY_SKELETON: loadToken(listToken, cell, "skeletal"); break;
					case SYMBOL_ENEMY_WOLF: loadToken(listToken, cell, "wolf"); break;
					case SYMBOL_ENEMY_CULTIST: loadToken(listToken, cell, "cultist"); break;
					case SYMBOL_ENEMY_ORC: loadToken(listToken, cell, "Orc"); break;
					case SYMBOL_ENEMY_BANDIT_CHIEF: loadToken(listToken, cell, "bandit_chief"); break;
					case SYMBOL_ENEMY_GOBLIN_SHAMAN: loadToken(listToken, cell, "gobelin_mage"); break;
					case SYMBOL_ENEMY_WARG: loadToken(listToken, cell, "warg"); break;
					case SYMBOL_ENEMY_GRAVE_ROBBER: loadToken(listToken, cell, "grave_robber"); break;

					case SYMBOL_ENEMY_DARK_MAGE: loadToken(listToken, cell, "dark_mage"); break;
					case SYMBOL_ENEMY_ELEMENTAL: loadToken(listToken, cell, "elemental"); break;
					case SYMBOL_ENEMY_TROLL: loadToken(listToken, cell, "troll"); break;
					case SYMBOL_ENEMY_ASSASSIN: loadToken(listToken, cell, "assassin"); break;
					case SYMBOL_ENEMY_NECROMANCER: loadToken(listToken, cell, "necromancer"); break;
					case SYMBOL_ENEMY_WARLOCK: loadToken(listToken, cell, "warlock"); break;
					case SYMBOL_ENEMY_SHADOW_BEAST: loadToken(listToken, cell, "shadow_beast"); break;
					case SYMBOL_ENEMY_GOLEM: loadToken(listToken, cell, "golem"); break;

					case SYMBOL_ENEMY_LICH: loadToken(listToken, cell, "lich"); break;
					case SYMBOL_ENEMY_MINOTAUR: loadToken(listToken, cell, "minotaur"); break;
					case SYMBOL_ENEMY_VAMPIRE_LORD: loadToken(listToken, cell, "vampire"); break;
					case SYMBOL_ENEMY_DEMON_KNIGHT: loadToken(listToken, cell, "demon_knight"); break;
					case SYMBOL_ENEMY_DREAD_KNIGHT: loadToken(listToken, cell, "dread_knight"); break;
					case SYMBOL_ENEMY_PLAGUE_BRINGER: loadToken(listToken, cell, "plague_bringer"); break;
					case SYMBOL_ENEMY_PYROMANCER: loadToken(listToken, cell, "pyromancer"); break;
					case SYMBOL_ENEMY_SPECTER: loadToken(listToken, cell, "specter"); break;

					case SYMBOL_ENEMY_DRAGON_WHELP: loadToken(listToken, cell, "Jeune_dragon_vert"); break;
					case SYMBOL_ENEMY_ANCIENT_DRAGON: loadToken(listToken, cell, "ancient_dragon"); break;
					case SYMBOL_ENEMY_ABYSSAL_HYDRA: loadToken(listToken, cell, "hydra"); break;
					case SYMBOL_ENEMY_FALLEN_GOD: loadToken(listToken, cell, "fallen_god"); break;
					case SYMBOL_ENEMY_DEMON_OVERLORD: loadToken(listToken, cell, "demon_overlord"); break;
					case SYMBOL_ENEMY_TITAN: loadToken(listToken, cell, "titan"); break;
					case SYMBOL_ENEMY_VOID_SERPENT: loadToken(listToken, cell, "serpent"); break;
					case SYMBOL_ENEMY_COSMIC_DRAGON: loadToken(listToken, cell, "cosmic_dragon"); break;

					default: cell.setBackground(Color.LIGHT_GRAY); break;
				}
				grid.add(cell);
			}
		}

		grid.revalidate();
		grid.repaint();
	}
}
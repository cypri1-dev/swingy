package com.swingy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

import com.swingy.view.GuiMainWindow;

import java.util.Map;

import static com.swingy.utils.Constants.*;

public class Maps {

	private int size;
	public String[][] map;
	private List<Characters> enemiesList;
	private Characters mainHero;
	private boolean levelCompleted;
	private List<Artefact> consommableList;
	public static Map<String, ImageIcon> listToken = GuiMainWindow.getListTokens();

	/* -------------------------------------------------- CONSTRUCTOR -------------------------------------------------- */

	protected Maps(Characters hero) {
	
		this.mainHero = hero;
		this.size =(hero.getLevel() - 1) * 5 + 10 - (hero.getLevel() % 2);
		this.map = new String[this.size][this.size];
		this.enemiesList = new ArrayList<Characters>();
		this.levelCompleted = false;
		this.consommableList = new ArrayList<Artefact>();
		initMap();
		List<String> tmp = generateRandomEnemies();
		generateRandomConsommable(tmp);
	}

	/* -------------------------------------------------- GETTERS/SETTERS -------------------------------------------------- */

	public int getSize() {return this.size;}
	public List<Artefact> getListConsommable() {return this.consommableList;}
	public List<Characters> getListEnemies() { return this.enemiesList;}
	public boolean getLevelCompleted() {return this.levelCompleted;}
	public String[][] getMapTab() {return this.map;}
	
	public void setLevelCompleted(boolean state) {this.levelCompleted = state;}

	/* -------------------------------------------------- METHOD MAPS -------------------------------------------------- */

	private void initMap() {
		int start = this.size /2;
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.map[i][j] = "*";
			}
		}
		mainHero.getCoordinates().setPrevX(start);
		mainHero.getCoordinates().setPrevY(start);
		this.map[mainHero.getCoordinates().getX()][mainHero.getCoordinates().getPrevY()] = SYMBOL_MAIN_HERO;
	}


	private void generateRandomConsommable(List<String> occupiedCoords) {
		int countConsommable = (int)(this.size * this.size * DENSITY_CONSOMMABLE);

		for (int i = 0; i < countConsommable; i++) {
			Artefact healingPotion = ArtefactFactory.getInstance().newArtefact(CONSOMMABLE_TYPE, "Healing Potion", COMMON, 10);

			int tmpX;
			int tmpY;
			String consommableCoord;

			do {
				tmpX = ThreadLocalRandom.current().nextInt(0, this.size);
				tmpY = ThreadLocalRandom.current().nextInt(0, this.size);
				consommableCoord = tmpX + "," + tmpY;
			} while (occupiedCoords.contains(consommableCoord) || (tmpX == mainHero.getCoordinates().getX() && tmpY == mainHero.getCoordinates().getY()));

			healingPotion.getCoordinates().setX(tmpX);
			healingPotion.getCoordinates().setY(tmpY);

			occupiedCoords.add(consommableCoord);
			this.consommableList.add(healingPotion);
			
			this.map[tmpX][tmpY] = "*";
		}

	}

	private List<String> generateRandomEnemies() {
		int enemyCount = (int)(this.size * this.size * DENSITY);
		String symbol = "";

		List<String> occupiedCoords = new ArrayList<>();

		for (int i = 0; i < enemyCount; i++) {

			Artefact loot = null;

			int lootPercent = ThreadLocalRandom.current().nextInt(1, 1001);
			if (lootPercent > 990) {
				loot = createRandomLoot(LEGENDARY);
			} else if (lootPercent > 950) {
				loot = createRandomLoot(EPIC);
			} else if (lootPercent > 800) {
				loot = createRandomLoot(RARE);
			} else if (lootPercent > 400) {
				loot = createRandomLoot(COMMON);
			} else if (lootPercent > 150)
				loot = ArtefactFactory.getInstance().newArtefact(CONSOMMABLE_TYPE, "Healing Potion", COMMON, 10);
			
			String randomEnemy = "";
			if (mainHero.getLevel() <=4)
				randomEnemy = ENEMIES_ALL[ThreadLocalRandom.current().nextInt(0, 8)];
			else if (mainHero.getLevel() > 4 && mainHero.getLevel() <=8) {
				randomEnemy = ENEMIES_ALL[ThreadLocalRandom.current().nextInt(6, 16)];
			}
			else if (mainHero.getLevel() > 8 && mainHero.getLevel() <= 12) {
				randomEnemy = ENEMIES_ALL[ThreadLocalRandom.current().nextInt(14, 24)];
			}
			else if (mainHero.getLevel() > 12 && mainHero.getLevel() <= 16) {
				randomEnemy = ENEMIES_ALL[ThreadLocalRandom.current().nextInt(22, 32)];
			}
			else {
				randomEnemy = ENEMIES_ALL[ThreadLocalRandom.current().nextInt(30, 40)];
			}
			Characters tmpEnemy = CharactersFactory.getInstance().newCharacters(ENEMY_TYPE, "Enemy" + "(" + i + ")" , randomEnemy);

			int tmpX;
			int tmpY;
			String enemyCoord;

			do {
				tmpX = ThreadLocalRandom.current().nextInt(0, this.size);
				tmpY = ThreadLocalRandom.current().nextInt(0, this.size);
				enemyCoord = tmpX + "," + tmpY;
			} while (occupiedCoords.contains(enemyCoord) || (tmpX == mainHero.getCoordinates().getX() && tmpY == mainHero.getCoordinates().getY()));

			occupiedCoords.add(enemyCoord);

			tmpEnemy.getCoordinates().setX(tmpX);
			tmpEnemy.getCoordinates().setY(tmpY);
			if (loot != null)
				tmpEnemy.addArtefact(loot);

			this.enemiesList.add(tmpEnemy);;

			switch(tmpEnemy.getCharacterClass()) {
				// ---- Tier 1 : basiques ----
				case ENEMY_CLASS_RAT: 
					symbol = "r";
					if (listToken != null)
						tmpEnemy.setToken(listToken.get("rat"));
					break;

				case ENEMY_CLASS_SLIME:
					symbol = "s";
					if (listToken != null)
						tmpEnemy.setToken(listToken.get("slime"));
					break;

				case ENEMY_CLASS_GOBLIN: {
					symbol = "g";
					if (listToken != null)
						tmpEnemy.setToken(listToken.get("goblin"));
				}
				case ENEMY_CLASS_BANDIT: {
					symbol = "b";
					if (listToken != null)
						tmpEnemy.setToken(listToken.get("bandit"));
				}
				case ENEMY_CLASS_BAT: {
					symbol = "v"; // volant
					if (listToken != null)
						tmpEnemy.setToken(listToken.get("bat"));
				}
				case ENEMY_CLASS_SPIDERLING: {
					symbol = "x"; // petite araignée
					if (listToken != null)
						tmpEnemy.setToken(listToken.get("spiderling"));
				}
				case ENEMY_CLASS_SKELETAL_HAND: {
					symbol = "h"; // main squelettique
					if (listToken != null)
						tmpEnemy.setToken(listToken.get("skeletal_hand"));
				}
				case ENEMY_CLASS_MUDLING: {
					symbol = "m"; // boueux
					if (listToken != null)
						tmpEnemy.setToken(listToken.get("mudling"));
				}

				// ---- Tier 2 : intermédiaires (niv. 5–8) ----
				// case ENEMY_CLASS_SKELETON -> symbol = "S";
				// case ENEMY_CLASS_WOLF -> symbol = "w";
				// case ENEMY_CLASS_CULTIST -> symbol = "c";
				// case ENEMY_CLASS_ORC -> symbol = "O";
				// case ENEMY_CLASS_BANDIT_CHIEF -> symbol = "B";
				// case ENEMY_CLASS_GOBLIN_SHAMAN -> symbol = "G";
				// case ENEMY_CLASS_WARG -> symbol = "W";
				// case ENEMY_CLASS_GRAVE_ROBBER -> symbol = "R";

				// // ---- Tier 3 : avancés (niv. 9–12) ----
				// case ENEMY_CLASS_DARK_MAGE -> symbol = "M";
				// case ENEMY_CLASS_ELEMENTAL -> symbol = "E";
				// case ENEMY_CLASS_TROLL -> symbol = "T";
				// case ENEMY_CLASS_ASSASSIN -> symbol = "A";
				// case ENEMY_CLASS_NECROMANCER -> symbol = "N";
				// case ENEMY_CLASS_WARLOCK -> symbol = "℧"; // symbole mystique
				// case ENEMY_CLASS_SHADOW_BEAST -> symbol = "§";
				// case ENEMY_CLASS_GOLEM -> symbol = "Gm";

				// // ---- Tier 4 : élite (niv. 13–16) ----
				// case ENEMY_CLASS_LICH -> symbol = "L";
				// case ENEMY_CLASS_MINOTAUR -> symbol = "Mʈ";
				// case ENEMY_CLASS_VAMPIRE_LORD -> symbol = "V";
				// case ENEMY_CLASS_DEMON_KNIGHT -> symbol = "K";
				// case ENEMY_CLASS_DREAD_KNIGHT -> symbol = "Đ";
				// case ENEMY_CLASS_PLAGUE_BRINGER -> symbol = "P";
				// case ENEMY_CLASS_PYROMANCER -> symbol = "Ψ";
				// case ENEMY_CLASS_SPECTER -> symbol = "Ʃ";

				// // ---- Tier 5 : boss & divinités (niv. 17–20) ----
				// case ENEMY_CLASS_DRAGON_WHELP -> symbol = "D";
				// case ENEMY_CLASS_ANCIENT_DRAGON -> symbol = "Ω";
				// case ENEMY_CLASS_ABYSSAL_HYDRA -> symbol = "H";
				// case ENEMY_CLASS_FALLEN_GOD -> symbol = "Φ";
				// case ENEMY_CLASS_DEMON_OVERLORD -> symbol = "Ð";
				// case ENEMY_CLASS_TITAN -> symbol = "τ";
				// case ENEMY_CLASS_VOID_SERPENT -> symbol = "∑";
				// case ENEMY_CLASS_COSMIC_DRAGON -> symbol = "∞";

				// default -> symbol = "?"; // cas par défaut
			}


			if ((mainHero.getLevel() == tmpEnemy.getLevel() || mainHero.getLevel() >= tmpEnemy.getLevel()))
				this.map[tmpX][tmpY] = symbol;
			else
				this.map[tmpX][tmpY] = "*";
		}
		return occupiedCoords;
	}

	private Artefact createRandomLoot(String rarity) {
		String nameLoot = "";
		int power = -1;
		String typeLoot = LOOT_TYPE[ThreadLocalRandom.current().nextInt(0, 4)];

		Map<String, Integer> lootMap = switch (typeLoot) {
			case WEAPON_TYPE -> getWeaponMapByRarity(rarity);
			case ARMOR_TYPE  -> getArmorMapByRarity(rarity);
			case HELM_TYPE   -> getHelmMapByRarity(rarity);
			default -> null;
		};

		if (lootMap == null || lootMap.isEmpty()) {
			return null;
		}

		List<String> lootNames = new ArrayList<>(lootMap.keySet());
		nameLoot = lootNames.get(ThreadLocalRandom.current().nextInt(lootNames.size()));
		power = lootMap.get(nameLoot);

		return ArtefactFactory.getInstance().newArtefact(typeLoot, nameLoot, rarity, power);
	}

	private Map<String, Integer> getWeaponMapByRarity(String rarity) {
		return switch (rarity) {
			case LEGENDARY -> WEAPONS_LEGENDARY;
			case EPIC -> WEAPONS_EPIC;
			case RARE -> WEAPONS_RARE;
			case COMMON -> WEAPONS_COMMON;
			default -> Map.of();
		};
	}

	private Map<String, Integer> getArmorMapByRarity(String rarity) {
		return switch (rarity) {
			case LEGENDARY -> ARMORS_LEGENDARY;
			case EPIC -> ARMORS_EPIC;
			case RARE -> ARMORS_RARE;
			case COMMON -> ARMORS_COMMON;
			default -> Map.of();
		};
	}

	private Map<String, Integer> getHelmMapByRarity(String rarity) {
		return switch (rarity) {
			case LEGENDARY -> HELMS_LEGENDARY;
			case EPIC -> HELMS_EPIC;
			case RARE -> HELMS_RARE;
			case COMMON -> HELMS_COMMON;
			default -> Map.of();
		};
	}

}
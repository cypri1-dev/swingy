package com.swingy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Map;

import static com.swingy.utils.Constants.*;

public class Maps {

	private int size;
	public String[][] map;
	private List<Characters> enemiesList;
	private Characters mainHero;
	private boolean levelCompleted;
	private List<Artefact> consommableList;

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
				} else if (lootPercent > 200)
					loot = ArtefactFactory.getInstance().newArtefact(CONSOMMABLE_TYPE, "Healing Potion", COMMON, 10);

			String randomEnemy = ENEMIES_LIST_NAMES[ThreadLocalRandom.current().nextInt(0, 20)];
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

			this.enemiesList.add(tmpEnemy);

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
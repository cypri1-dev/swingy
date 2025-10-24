package com.swingy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static com.swingy.utils.Constants.*;

public class Map {
	private int size;
	public String[][] map;
	private List<Characters> enemiesList;
	private Characters mainHero;
	private boolean levelCompleted;
	private List<Artefact> consommableList;

	protected Map(Characters hero) {
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

	protected void initMap() {
		int start = this.size /2;
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				this.map[i][j] = "*";
			}
		}
		// mainHero.getCoordinates().setX(start);
		// mainHero.getCoordinates().setY(start);
		mainHero.getCoordinates().setPrevX(start);
		mainHero.getCoordinates().setPrevY(start);
		this.map[mainHero.getCoordinates().getX()][mainHero.getCoordinates().getPrevY()] = SYMBOL_MAIN_HERO;
	}

	public String getSymbolEnemy(Characters enemy) {
		// switch (enemy.getCharacterClass()) {
		// 	case ENEMY_CLASS_GOBELIN: return SYMBOL_ENEMY_GOBELIN;
		// 	case ENEMY_CLASS_ORC: return SYMBOL_ENEMY_ORC;
		// 	case ENEMY_CLASS_SKELETON: return SYMBOL_ENEMY_SKELETON;
		// 	case ENEMY_CLASS_BANDIT: return SYMBOL_ENEMY_BANDIT;
		// 	case ENEMY_CLASS_DARK_MAGE:return SYMBOL_ENEMY_DARK_MAGE;
		// 	case ENEMY_CLASS_TROLL: return SYMBOL_ENEMY_TROLL;
		// 	case ENEMY_CLASS_ASSASSIN: return SYMBOL_ENEMY_ASSASSIN;
		// 	case ENEMY_CLASS_CULTIST: return SYMBOL_ENEMY_CULTIST;
		// 	case ENEMY_CLASS_ELEMENTAL: return SYMBOL_ENEMY_ELEMENTAL;
		// 	case ENEMY_CLASS_DRAGON_WHELP: return SYMBOL_ENEMY_DRAGON_WHELP;
		// 	default: return "?";
		// }
		return "*";
	}

	private void generateRandomConsommable(List<String> occupiedCoords) {
		int countConsommable = (int)(this.size * this.size * DENSITY_CONSOMMABLE);

		for (int i = 0; i < countConsommable; i++) {
			Artefact healingPotion = ArtefactFactory.getInstance().newArtefact(CONSOMMABLE, "Healing Potion (+10)", 10);

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
			this.map[tmpX][tmpY] = "*";
		}

	}

	private List<String> generateRandomEnemies() {
		int enemyCount = (int)(this.size * this.size * DENSITY);
		// System.out.println(DEBUG_BOLD + "[enemyCount]: " + enemyCount + " | [density]: " + DENSITY + RESET);

		List<String> occupiedCoords = new ArrayList<>();

		for (int i = 0; i < enemyCount; i++) {
			String randomEnemy = ENEMIES_LIST_NAMES[ThreadLocalRandom.current().nextInt(0, 10)];
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

			this.enemiesList.add(tmpEnemy);

			// this.map[tmpX][tmpY] = getSymbolEnemy(tmpEnemy);
			this.map[tmpX][tmpY] = "*";
		}
		return occupiedCoords;
	}


	public int getSize() {return this.size;}
	public List<Artefact> getListConsommable() {return this.consommableList;}
	public List<Characters> getListEnemies() { return this.enemiesList;}
	public boolean getLevelCompleted() {return this.levelCompleted;}
	public void setLevelCompleted(boolean state) {this.levelCompleted = state;}
}
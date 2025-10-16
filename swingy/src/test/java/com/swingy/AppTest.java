package com.swingy;

import com.swingy.model.Characters;
import com.swingy.model.CharactersFactory;
import junit.framework.TestCase;

public class AppTest extends TestCase {

	public void testHeroAndEnemyCreation() {
		Characters hero = CharactersFactory.getInstance().newCharacters("hero", "Adshum", "mage");
		Characters enemy = CharactersFactory.getInstance().newCharacters("enemy", "Bandit", "assassin");

		assertNotNull(hero);
		assertEquals("Adshum", hero.getName());
		assertEquals("mage", hero.getCharacterClass());

		assertNotNull(enemy);
		assertEquals("Bandit", enemy.getName());
		assertEquals("assassin", enemy.getCharacterClass());
	}
}


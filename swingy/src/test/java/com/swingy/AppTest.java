package com.swingy;

import static com.swingy.utils.Constants.ASSASSIN_CLASS;
import static com.swingy.utils.Constants.MAGE_CLASS;

import com.swingy.model.Characters;
import com.swingy.model.CharactersFactory;
import junit.framework.TestCase;

public class AppTest extends TestCase {

	public void testHeroAndEnemyCreation() {
		Characters hero = CharactersFactory.getInstance().newCharacters("hero", "Adshum", MAGE_CLASS);
		Characters enemy = CharactersFactory.getInstance().newCharacters("enemy", "Bandit", ASSASSIN_CLASS);

		assertNotNull(hero);
		assertEquals("Adshum", hero.getName());
		assertEquals("mage", hero.getCharacterClass());

		assertNotNull(enemy);
		assertEquals("Bandit", enemy.getName());
		assertEquals("assassin", enemy.getCharacterClass());
	}
}


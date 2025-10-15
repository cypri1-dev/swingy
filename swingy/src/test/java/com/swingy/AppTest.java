package com.swingy;

import com.swingy.model.Characters;
import com.swingy.model.HeroFactory;
import com.swingy.model.EnemyFactory;
import junit.framework.TestCase;

public class AppTest extends TestCase {

	public void testHeroAndEnemyCreation() {
		Characters hero = HeroFactory.getInstance().newHero("hero", "Adshum", "mage");
		Characters enemy = EnemyFactory.getInstance().newEnemy("enemy", "Bandit", "assassin");

		assertNotNull(hero);
		assertEquals("Adshum", hero.getName());
		assertEquals("mage", hero.getCharacterClass());

		assertNotNull(enemy);
		assertEquals("Bandit", enemy.getName());
		assertEquals("assassin", enemy.getCharacterClass());
	}
}


package com.swingy.utils;

public final class Constants {

	private Constants() {}

	/* COLORS */

	public static final String RED_BOLD = "\033[1;31m";
	public static final String GREEN_BOLD = "\033[1;32m";
	public static final String ORANGE_BOLD = "\033[1;38;5;208m";
	public static final String DEBUG_BOLD = "\u001B[1;34m" + "[DEBUG]: " + "\033[0m";
	public static final String ITALIC = "\033[3m";
	public static final String RESET = "\033[0m";

	/* TYPES CHARACTERS */

	public static final String HERO_TYPE = "hero";
	public static final String ENEMY_TYPE = "enemy";

	/* TYPE CLASS */

	public static final String WARRIOR_CLASS = "warrior";
	public static final String MAGE_CLASS = "mage";
	public static final String ARCHER_CLASS = "archer";
	public static final String PALADIN_CLASS = "paladin";
	public static final String ASSASSIN_CLASS = "assassin";

	/* STATS CLASS */

	public static final int HP_BASE = 10;
	public static final int HP_WARRIOR = 4;
	public static final int HP_MAGE = -3;
	public static final int HP_ARCHER = -2;
	public static final int HP_PALADIN = 5;
	public static final int HP_ASSASSIN = -1;

	public static final int ATT_BASE = 5;
	public static final int ATT_WARRIOR = 2;
	public static final int ATT_MAGE = 3;
	public static final int ATT_ARCHER = 2;
	public static final int ATT_PALADIN = 1;
	public static final int ATT_ASSASSIN = 4;

	public static final int DEF_BASE = 5;
	public static final int DEF_WARRIOR = 2;
	public static final int DEF_MAGE = -2;
	public static final int DEF_ARCHER = -1;
	public static final int DEF_PALADIN = 3;
	public static final int DEF_ASSASSIN = -2;

	/* TYPES ARTEFACTS */

	public static final String ARMOR_TYPE = "armor";
	public static final String HELM_TYPE = "helm";
	public static final String WEAPON_TYPE = "weapon";

}

package com.swingy.utils;

import java.util.Map;

public final class Constants {

	private Constants() {}
	
	/* COLORS */

	public static final String RED_BOLD = "\033[1;31m";
	public static final String GREEN_BOLD = "\033[1;32m";
	public static final String ORANGE_BOLD = "\033[1;38;5;208m";
	public static final String DEBUG_BOLD = "\u001B[1;34m" + "[DEBUG]: " + "\033[0m";
	public static final String ITALIC = "\033[3m";
	public static final String RESET = "\033[0m";
	public static final String RED   = "\u001B[31m";
	public static final String BLUE  = "\u001B[34m";
	public static final String CYAN = "\u001B[36m";
	public static final String BOLD = "\u001B[1m";
	public static final String YELLOW = "\u001B[33m";
	public static final String GREEN = "\u001B[32m";
	public static final String DARK_GRAY = "\u001B[90m";
	public static final String COMMON_COLOR = "\u001B[37m";
	public static final String EPIC_COLOR = "\u001B[35m";
	public static final String LEGENDARY_COLOR = "\u001B[33m";

	/* MODES */

	public static final String CONSOLE = "console";
	public static final String GUI = "gui";

	/* TYPES CHARACTERS */

	public static final String HERO_TYPE = "hero";
	public static final String ENEMY_TYPE = "enemy";

	/* TYPE CLASS */

	public static final String WARRIOR_CLASS = "warrior";
	public static final String MAGE_CLASS = "mage";
	public static final String ARCHER_CLASS = "archer";
	public static final String PALADIN_CLASS = "paladin";
	public static final String ASSASSIN_CLASS = "assassin";

	/* STATS BASE HERO */

	public static final int HP_BASE = 20;
	public static final int ATT_BASE = 8;
	public static final int DEF_BASE = 10;

	/* MODIFICATEURS PAR CLASSE */

	public static final int HP_WARRIOR = 6;
	public static final int HP_MAGE = -2;
	public static final int HP_ARCHER = 0;
	public static final int HP_PALADIN = 8;
	public static final int HP_ASSASSIN = 0;

	public static final int ATT_WARRIOR = 2;
	public static final int ATT_MAGE = 4;
	public static final int ATT_ARCHER = 3;
	public static final int ATT_PALADIN = 1;
	public static final int ATT_ASSASSIN = 5;

	public static final int DEF_WARRIOR = 3;
	public static final int DEF_MAGE = -2;
	public static final int DEF_ARCHER = 0;
	public static final int DEF_PALADIN = 6;
	public static final int DEF_ASSASSIN = -1;


	/* ENEMY STATS */

	public static final int HP_BASE_ENEMY = 19;
	public static final int ATT_BASE_ENEMY = 8;
	public static final int DEF_BASE_ENEMY = 8;

	/* ENEMY ARCHETYPES */

	public static final String ENEMY_CLASS_RAT = "Rat";
	public static final String ENEMY_CLASS_SLIME = "Slime";
	public static final String ENEMY_CLASS_GOBLIN = "Goblin";
	public static final String ENEMY_CLASS_BANDIT = "Bandit";
	public static final String ENEMY_CLASS_BAT = "Cave Bat";
	public static final String ENEMY_CLASS_SPIDERLING = "Spiderling";
	public static final String ENEMY_CLASS_SKELETAL_HAND = "Skeletal Hand";
	public static final String ENEMY_CLASS_MUDLING = "Mudling";

	public static final String ENEMY_CLASS_SKELETON = "Skeleton";
	public static final String ENEMY_CLASS_WOLF = "Wolf";
	public static final String ENEMY_CLASS_CULTIST = "Cultist";
	public static final String ENEMY_CLASS_ORC = "Orc";
	public static final String ENEMY_CLASS_BANDIT_CHIEF = "Bandit Chief";
	public static final String ENEMY_CLASS_GOBLIN_SHAMAN = "Goblin Shaman";
	public static final String ENEMY_CLASS_WARG = "Warg";
	public static final String ENEMY_CLASS_GRAVE_ROBBER = "Grave Robber";

	public static final String ENEMY_CLASS_DARK_MAGE = "Dark Mage";
	public static final String ENEMY_CLASS_ELEMENTAL = "Elemental";
	public static final String ENEMY_CLASS_TROLL = "Troll";
	public static final String ENEMY_CLASS_ASSASSIN = "Assassin";
	public static final String ENEMY_CLASS_NECROMANCER = "Necromancer";
	public static final String ENEMY_CLASS_WARLOCK = "Warlock";
	public static final String ENEMY_CLASS_SHADOW_BEAST = "Shadow Beast";
	public static final String ENEMY_CLASS_GOLEM = "Stone Golem";

	public static final String ENEMY_CLASS_LICH = "Lich";
	public static final String ENEMY_CLASS_MINOTAUR = "Minotaur";
	public static final String ENEMY_CLASS_VAMPIRE_LORD = "Vampire Lord";
	public static final String ENEMY_CLASS_DEMON_KNIGHT = "Demon Knight";
	public static final String ENEMY_CLASS_DREAD_KNIGHT = "Dread Knight";
	public static final String ENEMY_CLASS_PLAGUE_BRINGER = "Plague Bringer";
	public static final String ENEMY_CLASS_PYROMANCER = "Pyromancer";
	public static final String ENEMY_CLASS_SPECTER = "Specter";

	public static final String ENEMY_CLASS_DRAGON_WHELP = "Dragon Whelp";
	public static final String ENEMY_CLASS_ANCIENT_DRAGON = "Ancient Dragon";
	public static final String ENEMY_CLASS_ABYSSAL_HYDRA = "Abyssal Hydra";
	public static final String ENEMY_CLASS_FALLEN_GOD = "Fallen God";
	public static final String ENEMY_CLASS_DEMON_OVERLORD = "Demon Overlord";
	public static final String ENEMY_CLASS_TITAN = "Titan";
	public static final String ENEMY_CLASS_VOID_SERPENT = "Void Serpent";
	public static final String ENEMY_CLASS_COSMIC_DRAGON = "Cosmic Dragon";


	public static final String[] ENEMIES_ALL = {
		// ---- Niveaux 1–4 : faibles ----
		ENEMY_CLASS_RAT,
		ENEMY_CLASS_SLIME,
		ENEMY_CLASS_GOBLIN,
		ENEMY_CLASS_BANDIT,
		ENEMY_CLASS_BAT,
		ENEMY_CLASS_SPIDERLING,
		ENEMY_CLASS_SKELETAL_HAND,
		ENEMY_CLASS_MUDLING,

		// ---- Niveaux 5–8 : intermédiaires ----
		ENEMY_CLASS_SKELETON,
		ENEMY_CLASS_WOLF,
		ENEMY_CLASS_CULTIST,
		ENEMY_CLASS_ORC,
		ENEMY_CLASS_BANDIT_CHIEF,
		ENEMY_CLASS_GOBLIN_SHAMAN,
		ENEMY_CLASS_WARG,
		ENEMY_CLASS_GRAVE_ROBBER,

		// ---- Niveaux 9–12 : avancés ----
		ENEMY_CLASS_DARK_MAGE,
		ENEMY_CLASS_ELEMENTAL,
		ENEMY_CLASS_TROLL,
		ENEMY_CLASS_ASSASSIN,
		ENEMY_CLASS_NECROMANCER,
		ENEMY_CLASS_WARLOCK,
		ENEMY_CLASS_SHADOW_BEAST,
		ENEMY_CLASS_GOLEM,

		// ---- Niveaux 13–16 : élite ----
		ENEMY_CLASS_LICH,
		ENEMY_CLASS_MINOTAUR,
		ENEMY_CLASS_VAMPIRE_LORD,
		ENEMY_CLASS_DEMON_KNIGHT,
		ENEMY_CLASS_DREAD_KNIGHT,
		ENEMY_CLASS_PLAGUE_BRINGER,
		ENEMY_CLASS_PYROMANCER,
		ENEMY_CLASS_SPECTER,

		// ---- Niveaux 17–20 : boss & divinités ----
		ENEMY_CLASS_DRAGON_WHELP,
		ENEMY_CLASS_ANCIENT_DRAGON,
		ENEMY_CLASS_ABYSSAL_HYDRA,
		ENEMY_CLASS_FALLEN_GOD,
		ENEMY_CLASS_DEMON_OVERLORD,
		ENEMY_CLASS_TITAN,
		ENEMY_CLASS_VOID_SERPENT,
		ENEMY_CLASS_COSMIC_DRAGON
	};


	// ==================
	// ENEMY STATS MODIFIERS
	// ==================

	public static final int HP_RAT = -3;
	public static final int ATT_RAT = -1;
	public static final int DEF_RAT = -1;
	public static final int XP_RAT = 25;

	public static final int HP_SLIME = -2;
	public static final int ATT_SLIME = -1;
	public static final int DEF_SLIME = 0;
	public static final int XP_SLIME = 35;

	public static final int HP_GOBLIN = 0;
	public static final int ATT_GOBLIN = 1;
	public static final int DEF_GOBLIN = 0;
	public static final int XP_GOBLIN = 55;

	public static final int HP_BANDIT = 1;
	public static final int ATT_BANDIT = 1;
	public static final int DEF_BANDIT = 1;
	public static final int XP_BANDIT = 80;

	public static final int HP_BAT = -1;
	public static final int ATT_BAT = 1;
	public static final int DEF_BAT = -2;
	public static final int XP_BAT = 30;

	public static final int HP_SPIDERLING = -1;
	public static final int ATT_SPIDERLING = 1;
	public static final int DEF_SPIDERLING = -1;
	public static final int XP_SPIDERLING = 40;

	public static final int HP_SKELETAL_HAND = 0;
	public static final int ATT_SKELETAL_HAND = 1;
	public static final int DEF_SKELETAL_HAND = 1;
	public static final int XP_SKELETAL_HAND = 45;

	public static final int HP_MUDLING = 1;
	public static final int ATT_MUDLING = 1;
	public static final int DEF_MUDLING = 0;
	public static final int XP_MUDLING = 50;

	public static final int HP_SKELETON = 2;
	public static final int ATT_SKELETON = 1;
	public static final int DEF_SKELETON = 1;
	public static final int XP_SKELETON = 110;

	public static final int HP_WOLF = 2;
	public static final int ATT_WOLF = 2;
	public static final int DEF_WOLF = 1;
	public static final int XP_WOLF = 140;

	public static final int HP_CULTIST = 3;
	public static final int ATT_CULTIST = 3;
	public static final int DEF_CULTIST = 2;
	public static final int XP_CULTIST = 180;

	public static final int HP_ORC = 4;
	public static final int ATT_ORC = 4;
	public static final int DEF_ORC = 3;
	public static final int XP_ORC = 240;

	public static final int HP_BANDIT_CHIEF = 5;
	public static final int ATT_BANDIT_CHIEF = 4;
	public static final int DEF_BANDIT_CHIEF = 3;
	public static final int XP_BANDIT_CHIEF = 260;

	public static final int HP_GOBLIN_SHAMAN = 3;
	public static final int ATT_GOBLIN_SHAMAN = 5;
	public static final int DEF_GOBLIN_SHAMAN = 2;
	public static final int XP_GOBLIN_SHAMAN = 200;

	public static final int HP_WARG = 4;
	public static final int ATT_WARG = 5;
	public static final int DEF_WARG = 3;
	public static final int XP_WARG = 230;

	public static final int HP_GRAVE_ROBBER = 3;
	public static final int ATT_GRAVE_ROBBER = 4;
	public static final int DEF_GRAVE_ROBBER = 2;
	public static final int XP_GRAVE_ROBBER = 210;

	public static final int HP_DARK_MAGE = 3;
	public static final int ATT_DARK_MAGE = 6;
	public static final int DEF_DARK_MAGE = 2;
	public static final int XP_DARK_MAGE = 320;

	public static final int HP_ELEMENTAL = 5;
	public static final int ATT_ELEMENTAL = 5;
	public static final int DEF_ELEMENTAL = 5;
	public static final int XP_ELEMENTAL = 420;

	public static final int HP_TROLL = 6;
	public static final int ATT_TROLL = 4;
	public static final int DEF_TROLL = 6;
	public static final int XP_TROLL = 550;

	public static final int HP_ASSASSIN_ENEMY = 4;
	public static final int ATT_ASSASSIN_ENEMY = 8;
	public static final int DEF_ASSASSIN_ENEMY = 2;
	public static final int XP_ASSASSIN_ENEMY = 700;

	public static final int HP_NECROMANCER = 5;
	public static final int ATT_NECROMANCER = 7;
	public static final int DEF_NECROMANCER = 3;
	public static final int XP_NECROMANCER = 620;

	public static final int HP_WARLOCK = 6;
	public static final int ATT_WARLOCK = 6;
	public static final int DEF_WARLOCK = 4;
	public static final int XP_WARLOCK = 580;

	public static final int HP_SHADOW_BEAST = 7;
	public static final int ATT_SHADOW_BEAST = 8;
	public static final int DEF_SHADOW_BEAST = 4;
	public static final int XP_SHADOW_BEAST = 750;

	public static final int HP_GOLEM = 9;
	public static final int ATT_GOLEM = 5;
	public static final int DEF_GOLEM = 8;
	public static final int XP_GOLEM = 800;


	public static final int HP_LICH = 7;
	public static final int ATT_LICH = 6;
	public static final int DEF_LICH = 5;
	public static final int XP_LICH = 950;

	public static final int HP_MINOTAUR = 10;
	public static final int ATT_MINOTAUR = 7;
	public static final int DEF_MINOTAUR = 6;
	public static final int XP_MINOTAUR = 1200;

	public static final int HP_VAMPIRE_LORD = 8;
	public static final int ATT_VAMPIRE_LORD = 9;
	public static final int DEF_VAMPIRE_LORD = 7;
	public static final int XP_VAMPIRE_LORD = 1600;

	public static final int HP_DEMON_KNIGHT = 12;
	public static final int ATT_DEMON_KNIGHT = 10;
	public static final int DEF_DEMON_KNIGHT = 8;
	public static final int XP_DEMON_KNIGHT = 2000;

	public static final int HP_DREAD_KNIGHT = 13;
	public static final int ATT_DREAD_KNIGHT = 9;
	public static final int DEF_DREAD_KNIGHT = 10;
	public static final int XP_DREAD_KNIGHT = 2200;

	public static final int HP_PLAGUE_BRINGER = 11;
	public static final int ATT_PLAGUE_BRINGER = 11;
	public static final int DEF_PLAGUE_BRINGER = 7;
	public static final int XP_PLAGUE_BRINGER = 1800;

	public static final int HP_PYROMANCER = 9;
	public static final int ATT_PYROMANCER = 12;
	public static final int DEF_PYROMANCER = 5;
	public static final int XP_PYROMANCER = 1750;

	public static final int HP_SPECTER = 8;
	public static final int ATT_SPECTER = 10;
	public static final int DEF_SPECTER = 6;
	public static final int XP_SPECTER = 1500;

	public static final int HP_DRAGON_WHELP = 10;
	public static final int ATT_DRAGON_WHELP = 8;
	public static final int DEF_DRAGON_WHELP = 6;
	public static final int XP_DRAGON_WHELP = 2500;

	public static final int HP_ANCIENT_DRAGON = 16;
	public static final int ATT_ANCIENT_DRAGON = 12;
	public static final int DEF_ANCIENT_DRAGON = 10;
	public static final int XP_ANCIENT_DRAGON = 3500;

	public static final int HP_ABYSSAL_HYDRA = 20;
	public static final int ATT_ABYSSAL_HYDRA = 14;
	public static final int DEF_ABYSSAL_HYDRA = 12;
	public static final int XP_ABYSSAL_HYDRA = 4500;

	public static final int HP_FALLEN_GOD = 25;
	public static final int ATT_FALLEN_GOD = 18;
	public static final int DEF_FALLEN_GOD = 15;
	public static final int XP_FALLEN_GOD = 6000;

	public static final int HP_DEMON_OVERLORD = 22;
	public static final int ATT_DEMON_OVERLORD = 16;
	public static final int DEF_DEMON_OVERLORD = 13;
	public static final int XP_DEMON_OVERLORD = 5200;

	public static final int HP_TITAN = 24;
	public static final int ATT_TITAN = 15;
	public static final int DEF_TITAN = 20;
	public static final int XP_TITAN = 5800;

	public static final int HP_VOID_SERPENT = 18;
	public static final int ATT_VOID_SERPENT = 17;
	public static final int DEF_VOID_SERPENT = 11;
	public static final int XP_VOID_SERPENT = 5000;

	public static final int HP_COSMIC_DRAGON = 28;
	public static final int ATT_COSMIC_DRAGON = 20;
	public static final int DEF_COSMIC_DRAGON = 18;
	public static final int XP_COSMIC_DRAGON = 7000;


	/* TYPES ARTEFACTS */

	public static final String ARMOR_TYPE = "armor";
	public static final String HELM_TYPE = "helm";
	public static final String WEAPON_TYPE = "weapon";
	public static final String CONSOMMABLE_TYPE = "consommable";

	public static final String COMMON = "common";
	public static final String RARE = "rare";
	public static final String EPIC = "epic";
	public static final String LEGENDARY = "legendary";

	public static final String[] LOOT_TYPE = {
		"armor",
		"helm",
		"weapon",
		"consommable"
	};

	/* -------------------- WEAPONS (ATT bonus) -------------------- */

	public static final Map<String, Integer> WEAPONS_COMMON = Map.ofEntries(
		Map.entry("Rusty Dagger", 1), Map.entry("Iron Sword", 2), Map.entry("Wooden Mace", 1),
		Map.entry("Stone Axe", 2), Map.entry("Bronze Spear", 1), Map.entry("Simple Club", 1),
		Map.entry("Short Bow", 2), Map.entry("Hunting Knife", 1), Map.entry("Sling Staff", 1),
		Map.entry("Training Sword", 1), Map.entry("Old Halberd", 2), Map.entry("Light Crossbow", 2),
		Map.entry("Wooden Scimitar", 1), Map.entry("Iron Dagger", 2), Map.entry("Rusty Axe", 1),
		Map.entry("Stick Staff", 1), Map.entry("Stone Hammer", 2), Map.entry("Small Saber", 1),
		Map.entry("Old Pike", 2), Map.entry("Practice Bow", 1), Map.entry("Leather Sling", 1),
		Map.entry("Club", 1), Map.entry("Jagged Sword", 2), Map.entry("Iron Knife", 1),
		Map.entry("Basic Mace", 1)
	);

	public static final Map<String, Integer> WEAPONS_RARE = Map.ofEntries(
		Map.entry("Steel Axe", 3), Map.entry("Elven Longbow", 4), Map.entry("Iron Spear", 3),
		Map.entry("Battle Hammer", 3), Map.entry("Silver Dagger", 4), Map.entry("Knight's Sword", 3),
		Map.entry("Hunter's Bow", 4), Map.entry("War Scimitar", 3), Map.entry("Saber of Valor", 4),
		Map.entry("Reinforced Mace", 3), Map.entry("Twin Daggers", 4), Map.entry("Long Spear", 3),
		Map.entry("Heavy Crossbow", 4), Map.entry("Steel Sword", 3), Map.entry("Frost Axe", 4),
		Map.entry("Elven Spear", 4), Map.entry("Orcish Blade", 3), Map.entry("Reaver Bow", 4),
		Map.entry("Champion Mace", 3), Map.entry("Iron Katana", 4), Map.entry("Silver Halberd", 4),
		Map.entry("Battle Staff", 3), Map.entry("Runed Blade", 4), Map.entry("Hunter Spear", 3),
		Map.entry("Crimson Sword", 4)
	);

	public static final Map<String, Integer> WEAPONS_EPIC = Map.ofEntries(
		Map.entry("Rune Blade", 5), Map.entry("Shadowfang", 6), Map.entry("Stormbreaker", 6),
		Map.entry("Dragonfang", 7), Map.entry("Frostbite", 6), Map.entry("Demon Slayer", 7),
		Map.entry("Phoenix Talon", 6), Map.entry("Vampire Fang", 7), Map.entry("Celestial Sword", 8),
		Map.entry("Oblivion Blade", 7), Map.entry("Twilight Scimitar", 6), Map.entry("Thunder Pike", 7),
		Map.entry("Soul Reaver", 8), Map.entry("Moonlight Bow", 7), Map.entry("Flamebrand", 6),
		Map.entry("Darkfang", 7), Map.entry("Storm Saber", 6), Map.entry("Eclipse Sword", 8),
		Map.entry("Blood Pike", 7), Map.entry("Silver Fang", 6), Map.entry("Warlock Dagger", 7),
		Map.entry("Arcane Blade", 8), Map.entry("Inferno Sword", 7), Map.entry("Lightbringer", 8),
		Map.entry("Frostmourne", 9)
	);

	public static final Map<String, Integer> WEAPONS_LEGENDARY = Map.ofEntries(
		Map.entry("Excalibur", 10), Map.entry("Soulrender", 12), Map.entry("Dragon Slayer", 15),
		Map.entry("Aegis Fang", 14), Map.entry("Infinity Blade", 13), Map.entry("Dawnbreaker", 15),
		Map.entry("Nightfall", 14), Map.entry("Heaven's Wrath", 16), Map.entry("Oblivion Edge", 15),
		Map.entry("Celestial Fang", 16), Map.entry("Shadowmourne", 17), Map.entry("Stormbringer", 15),
		Map.entry("Moonblade", 16), Map.entry("Infernal Sword", 17), Map.entry("Light's Justice", 16),
		Map.entry("Dragonheart", 18), Map.entry("Phoenix Blade", 17), Map.entry("Bloodfang", 16),
		Map.entry("Eternity Edge", 18), Map.entry("Doombringer", 19), Map.entry("Soulfang", 18),
		Map.entry("Thunderstrike", 17), Map.entry("Valkyrie Blade", 19), Map.entry("Celestial Edge", 20)
	);

	/* -------------------- ARMORS (DEF bonus) -------------------- */

	public static final Map<String, Integer> ARMORS_COMMON = Map.ofEntries(
		Map.entry("Leather Vest", 1), Map.entry("Chainmail", 2), Map.entry("Hide Armor", 1),
		Map.entry("Paw Leather", 2), Map.entry("Cloth Tunic", 1), Map.entry("Wooden Chestguard", 1),
		Map.entry("Bronze Plate", 2), Map.entry("Studded Vest", 2), Map.entry("Simple Robe", 1),
		Map.entry("Leather Jerkin", 1), Map.entry("Iron Bracers", 2), Map.entry("Worn Armor", 1),
		Map.entry("Basic Chainmail", 2), Map.entry("Leather Hauberk", 1), Map.entry("Padded Armor", 1),
		Map.entry("Traveler's Tunic", 1), Map.entry("Hardened Leather", 2), Map.entry("Old Plate", 2),
		Map.entry("Guardian Chest", 2), Map.entry("Reinforced Vest", 2), Map.entry("Squire's Armor", 1),
		Map.entry("Huntsman Leather", 1), Map.entry("Light Chain", 1), Map.entry("Iron Padded Armor", 2),
		Map.entry("Rusty Plate", 1)
	);

	public static final Map<String, Integer> ARMORS_RARE = Map.ofEntries(
		Map.entry("Iron Plate", 3), Map.entry("Dwarven Chestguard", 4), Map.entry("Steel Chain", 3),
		Map.entry("Elven Robe", 4), Map.entry("Knight's Armor", 3), Map.entry("Warrior's Chestplate", 4),
		Map.entry("Reinforced Chainmail", 3), Map.entry("Battle Vest", 4), Map.entry("Guardian Plate", 3),
		Map.entry("Shadow Armor", 4), Map.entry("Silver Breastplate", 3), Map.entry("Dragonhide Armor", 4),
		Map.entry("Templar Chestguard", 3), Map.entry("Ranger Vest", 4), Map.entry("Heavy Plate", 3),
		Map.entry("Steel Hauberk", 4), Map.entry("Battle Robe", 3), Map.entry("Mystic Armor", 4),
		Map.entry("Champion Chestplate", 3), Map.entry("Paladin Armor", 4), Map.entry("Stormguard Plate", 3),
		Map.entry("Ironclad Vest", 4), Map.entry("War Plate", 3), Map.entry("Assassin's Tunic", 4),
		Map.entry("Warlord Armor", 3)
	);

	public static final Map<String, Integer> ARMORS_EPIC = Map.ofEntries(
		Map.entry("Enchanted Breastplate", 5), Map.entry("Obsidian Armor", 6), Map.entry("Dragon Scale Vest", 5),
		Map.entry("Celestial Robe", 6), Map.entry("Demon Plate", 5), Map.entry("Phoenix Armor", 6),
		Map.entry("Titan Chestplate", 5), Map.entry("Runed Chainmail", 6), Map.entry("Storm Armor", 5),
		Map.entry("Shadowguard Vest", 6), Map.entry("Frostplate", 5), Map.entry("Infernal Armor", 6),
		Map.entry("Holy Breastplate", 5), Map.entry("Valkyrie Plate", 6), Map.entry("Eclipse Armor", 5),
		Map.entry("Darksteel Vest", 6), Map.entry("Moonlight Robe", 5), Map.entry("Soulguard Armor", 6),
		Map.entry("Bloodplate", 5), Map.entry("Arcane Chestplate", 6), Map.entry("Thunderplate", 5),
		Map.entry("Warlord Breastplate", 6), Map.entry("Titanium Armor", 5), Map.entry("Oblivion Vest", 6),
		Map.entry("Celestial Plate", 7)
	);

	public static final Map<String, Integer> ARMORS_LEGENDARY = Map.ofEntries(
		Map.entry("Dragon Scale Armor", 7), Map.entry("Aegis Plate", 8), Map.entry("Godslayer Vest", 9),
		Map.entry("Phoenix Breastplate", 10), Map.entry("Titan Armor", 11), Map.entry("Celestial Guard", 12),
		Map.entry("Oblivion Plate", 10), Map.entry("Infinity Armor", 11), Map.entry("Stormbreaker Vest", 12),
		Map.entry("Lightbringer Plate", 13), Map.entry("Shadowmourne Armor", 12), Map.entry("Moonlight Vest", 13),
		Map.entry("Dawnbreaker Breastplate", 14), Map.entry("Eternity Armor", 15), Map.entry("Dragonheart Plate", 14),
		Map.entry("Soulguard Vest", 15), Map.entry("Infernal Plate", 14), Map.entry("Valkyrie Armor", 15),
		Map.entry("Thunderstrike Vest", 16), Map.entry("Bloodfang Plate", 16), Map.entry("Celestial Armor", 17),
		Map.entry("Fallen God Plate", 18), Map.entry("Heaven's Wrath Armor", 17), Map.entry("Divine Vest", 18),
		Map.entry("Eclipse Plate", 19)
	);

	/* -------------------- HELMS (HP bonus) -------------------- */

	public static final Map<String, Integer> HELMS_COMMON = Map.ofEntries(
		Map.entry("Leather Hood", 3), Map.entry("Iron Helmet", 5), Map.entry("Wooden Cap", 3),
		Map.entry("Hide Helm", 4), Map.entry("Cloth Hat", 3), Map.entry("Bronze Helmet", 4),
		Map.entry("Simple Hood", 3), Map.entry("Studded Cap", 4), Map.entry("Traveler's Cap", 3),
		Map.entry("Leather Headpiece", 3), Map.entry("Iron Coif", 5), Map.entry("Worn Helm", 3),
		Map.entry("Basic Hood", 3), Map.entry("Leather Helm", 4), Map.entry("Padded Cap", 3),
		Map.entry("Huntsman Hat", 3), Map.entry("Reinforced Hood", 4), Map.entry("Old Helmet", 5),
		Map.entry("Guardian Helm", 4), Map.entry("Light Cap", 3), Map.entry("Squire Hood", 3),
		Map.entry("Shadow Cap", 3), Map.entry("Iron Headguard", 4), Map.entry("Rusty Helmet", 3),
		Map.entry("Novice Hood", 3)
	);

	public static final Map<String, Integer> HELMS_RARE = Map.ofEntries(
		Map.entry("Steel Helm", 8), Map.entry("Guardian Mask", 10), Map.entry("Iron Crown", 9),
		Map.entry("Elven Circlet", 8), Map.entry("Knight's Helm", 9), Map.entry("Warrior's Headpiece", 10),
		Map.entry("Reinforced Helm", 9), Map.entry("Battle Cap", 8), Map.entry("Shadow Helm", 10),
		Map.entry("Silver Mask", 9), Map.entry("Dragon Helm", 10), Map.entry("Templar Circlet", 9),
		Map.entry("Ranger Hood", 8), Map.entry("Heavy Helm", 9), Map.entry("Steel Crown", 10),
		Map.entry("Battle Helm", 9), Map.entry("Mystic Helm", 8), Map.entry("Champion Mask", 10),
		Map.entry("Paladin Helm", 9), Map.entry("Stormguard Headpiece", 8), Map.entry("Ironclad Helm", 9),
		Map.entry("War Helm", 10), Map.entry("Assassin Hood", 8), Map.entry("Warlord Helm", 10),
		Map.entry("Oblivion Helm", 9)
	);

	public static final Map<String, Integer> HELMS_EPIC = Map.ofEntries(
		Map.entry("Warlord Crown", 12), Map.entry("Helm of Eternity", 15), Map.entry("Dragonlord Helm", 13),
		Map.entry("Celestial Circlet", 14), Map.entry("Demon Helm", 12), Map.entry("Phoenix Hood", 15),
		Map.entry("Titan Crown", 14), Map.entry("Runed Helm", 13), Map.entry("Stormguard Helm", 14),
		Map.entry("Shadowguard Cap", 12), Map.entry("Frost Helm", 13), Map.entry("Infernal Hood", 15),
		Map.entry("Holy Crown", 14), Map.entry("Valkyrie Helm", 15), Map.entry("Eclipse Hood", 13),
		Map.entry("Darksteel Helm", 14), Map.entry("Moonlight Crown", 15), Map.entry("Soulguard Helm", 14),
		Map.entry("Blood Helm", 13), Map.entry("Arcane Hood", 15), Map.entry("Thunder Helm", 14),
		Map.entry("Warlord Headpiece", 15), Map.entry("Titanium Crown", 14), Map.entry("Oblivion Helm", 15),
		Map.entry("Celestial Helm", 16)
	);

	public static final Map<String, Integer> HELMS_LEGENDARY = Map.ofEntries(
		Map.entry("Godslayer Helm", 30), Map.entry("Aegis Crown", 28), Map.entry("Phoenix Helm", 32),
		Map.entry("Titan Helm", 31), Map.entry("Celestial Mask", 33), Map.entry("Oblivion Crown", 34),
		Map.entry("Infinity Crown", 35), Map.entry("Stormbreaker Helm", 33), Map.entry("Lightbringer Helm", 36),
		Map.entry("Shadowmourne Helm", 34), Map.entry("Moonlight Helm", 35), Map.entry("Dawnbreaker Helm", 36),
		Map.entry("Eternity Helm", 37), Map.entry("Dragonheart Helm", 38), Map.entry("Soulguard Helm", 37),
		Map.entry("Infernal Helm", 36), Map.entry("Valkyrie Helm", 38), Map.entry("Thunderstrike Helm", 39),
		Map.entry("Bloodfang Helm", 38), Map.entry("Celestial Helm", 40), Map.entry("Fallen God Helm", 41),
		Map.entry("Heaven's Wrath Helm", 42), Map.entry("Divine Helm", 40), Map.entry("Eclipse Helm", 43),
		Map.entry("Omniscient Helm", 45)
	);

	// ==================
	// SYMBOLS - HERO & ENEMIES
	// ==================

	public static final String SYMBOL_MAIN_HERO = BLUE + "@" + RESET;
	public static final String SYMBOL_ENEMY = RED + "!" + RESET;

	// ---- Tier 1 : faibles (niv. 1–4) ----
	public static final String SYMBOL_ENEMY_RAT = "r";
	public static final String SYMBOL_ENEMY_SLIME = "s";
	public static final String SYMBOL_ENEMY_GOBLIN = "g";
	public static final String SYMBOL_ENEMY_BANDIT = "b";
	public static final String SYMBOL_ENEMY_BAT = "v"; // volant
	public static final String SYMBOL_ENEMY_SPIDERLING = "x"; // petite araignée
	public static final String SYMBOL_ENEMY_SKELETAL_HAND = "h"; // hand
	public static final String SYMBOL_ENEMY_MUDLING = "m"; // mud

	// ---- Tier 2 : intermédiaires (niv. 5–8) ----
	public static final String SYMBOL_ENEMY_SKELETON = "S";
	public static final String SYMBOL_ENEMY_WOLF = "w";
	public static final String SYMBOL_ENEMY_CULTIST = "c";
	public static final String SYMBOL_ENEMY_ORC = "O";
	public static final String SYMBOL_ENEMY_BANDIT_CHIEF = "B";
	public static final String SYMBOL_ENEMY_GOBLIN_SHAMAN = "G";
	public static final String SYMBOL_ENEMY_WARG = "W";
	public static final String SYMBOL_ENEMY_GRAVE_ROBBER = "R";

	// ---- Tier 3 : avancés (niv. 9–12) ----
	public static final String SYMBOL_ENEMY_DARK_MAGE = "M";
	public static final String SYMBOL_ENEMY_ELEMENTAL = "E";
	public static final String SYMBOL_ENEMY_TROLL = "T";
	public static final String SYMBOL_ENEMY_ASSASSIN = "A";
	public static final String SYMBOL_ENEMY_NECROMANCER = "N";
	public static final String SYMBOL_ENEMY_WARLOCK = "℧"; // symbole mystique
	public static final String SYMBOL_ENEMY_SHADOW_BEAST = "§";
	public static final String SYMBOL_ENEMY_GOLEM = "Gm";

	// ---- Tier 4 : élite (niv. 13–16) ----
	public static final String SYMBOL_ENEMY_LICH = "L";
	public static final String SYMBOL_ENEMY_MINOTAUR = "Mʈ";
	public static final String SYMBOL_ENEMY_VAMPIRE_LORD = "V";
	public static final String SYMBOL_ENEMY_DEMON_KNIGHT = "K";
	public static final String SYMBOL_ENEMY_DREAD_KNIGHT = "Đ";
	public static final String SYMBOL_ENEMY_PLAGUE_BRINGER = "P";
	public static final String SYMBOL_ENEMY_PYROMANCER = "Ψ";
	public static final String SYMBOL_ENEMY_SPECTER = "Ʃ";

	// ---- Tier 5 : boss & divinités (niv. 17–20) ----
	public static final String SYMBOL_ENEMY_DRAGON_WHELP = "D";
	public static final String SYMBOL_ENEMY_ANCIENT_DRAGON = "Ω";
	public static final String SYMBOL_ENEMY_ABYSSAL_HYDRA = "H";
	public static final String SYMBOL_ENEMY_FALLEN_GOD = "Φ";
	public static final String SYMBOL_ENEMY_DEMON_OVERLORD = "Ð";
	public static final String SYMBOL_ENEMY_TITAN = "τ";
	public static final String SYMBOL_ENEMY_VOID_SERPENT = "∑";
	public static final String SYMBOL_ENEMY_COSMIC_DRAGON = "∞";


	/* MAPS DATA */
	public static final double DENSITY = 0.23;
	public static final double DENSITY_CONSOMMABLE = 0.10;

	/* D_V_D__A */
	public static boolean D_V_M___E = false;
	public static int D_V_S___D_T_T = 0;
	public static final int TIME_DEV = 0;

	/* IMPORT - EXPORT */
	public static final int ONLY_HERO = 1;
	public static final int HERO_BAG = 2;
	public static final int HERO_KNOWLDGE_OR_HERO_BAG_KNOWLEDGE = 3;

	/* FIGHT CHOICE */
	public static final String ATTACK = "1";
	public static final String BLOCK = "2";
	public static final String RUN = "3";
	public static final String INVENTORY = "4";

	/* DISPLAY */
	public static final String NO_LOAD = " The character will not be loaded and will be deleted to preserve the integrity of the game and its files. Press ENTER to continue...";

	public static final String MAIN_HEADER = """

			██████╗ ███████╗████████╗██████╗  ██████╗     ██████╗ ██████╗  ██████╗ 
			██╔══██╗██╔════╝╚══██╔══╝██╔══██╗██╔═══██╗    ██╔══██╗██╔══██╗██╔════╝ 
			██████╔╝█████╗     ██║   ██████╔╝██║   ██║    ██████╔╝██████╔╝██║  ███╗
			██╔══██╗██╔══╝     ██║   ██╔══██╗██║   ██║    ██╔══██╗██╔═══╝ ██║   ██║
			██║  ██║███████╗   ██║   ██║  ██║╚██████╔╝    ██║  ██║██║     ╚██████╔╝
			╚═╝  ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝     ╚═╝  ╚═╝╚═╝      ╚═════╝ 
																				
																				
		""";

	public static final String MENU_CREATION = """

			████████╗███████╗███╗   ███╗██████╗ ██╗     ███████╗     ██████╗ ███████╗     ██████╗ ██████╗ ██╗ ██████╗ ██╗███╗   ██╗███████╗
			╚══██╔══╝██╔════╝████╗ ████║██╔══██╗██║     ██╔════╝    ██╔═══██╗██╔════╝    ██╔═══██╗██╔══██╗██║██╔════╝ ██║████╗  ██║██╔════╝
			   ██║   █████╗  ██╔████╔██║██████╔╝██║     █████╗      ██║   ██║█████╗      ██║   ██║██████╔╝██║██║  ███╗██║██╔██╗ ██║███████╗
			   ██║   ██╔══╝  ██║╚██╔╝██║██╔═══╝ ██║     ██╔══╝      ██║   ██║██╔══╝      ██║   ██║██╔══██╗██║██║   ██║██║██║╚██╗██║╚════██║
			   ██║   ███████╗██║ ╚═╝ ██║██║     ███████╗███████╗    ╚██████╔╝██║         ╚██████╔╝██║  ██║██║╚██████╔╝██║██║ ╚████║███████║
			   ╚═╝   ╚══════╝╚═╝     ╚═╝╚═╝     ╚══════╝╚══════╝     ╚═════╝ ╚═╝          ╚═════╝ ╚═╝  ╚═╝╚═╝ ╚═════╝ ╚═╝╚═╝  ╚═══╝╚══════╝
																					
																					
				""";

	public static final String VIEW_HEROS = """

					███╗   ███╗██╗   ██╗    ██╗  ██╗███████╗██████╗  ██████╗ ███████╗███████╗
					████╗ ████║╚██╗ ██╔╝    ██║  ██║██╔════╝██╔══██╗██╔═══██╗██╔════╝██╔════╝
					██╔████╔██║ ╚████╔╝     ███████║█████╗  ██████╔╝██║   ██║█████╗  ███████╗
					██║╚██╔╝██║  ╚██╔╝      ██╔══██║██╔══╝  ██╔══██╗██║   ██║██╔══╝  ╚════██║
					██║ ╚═╝ ██║   ██║       ██║  ██║███████╗██║  ██║╚██████╔╝███████╗███████║
					╚═╝     ╚═╝   ╚═╝       ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚══════╝
																					
																					
			""";

	public static final String MAIN_MENU = """

			███╗   ███╗ █████╗ ██╗███╗   ██╗    ███╗   ███╗███████╗███╗   ██╗██╗   ██╗
			████╗ ████║██╔══██╗██║████╗  ██║    ████╗ ████║██╔════╝████╗  ██║██║   ██║
			██╔████╔██║███████║██║██╔██╗ ██║    ██╔████╔██║█████╗  ██╔██╗ ██║██║   ██║
			██║╚██╔╝██║██╔══██║██║██║╚██╗██║    ██║╚██╔╝██║██╔══╝  ██║╚██╗██║██║   ██║
			██║ ╚═╝ ██║██║  ██║██║██║ ╚████║    ██║ ╚═╝ ██║███████╗██║ ╚████║╚██████╔╝
			╚═╝     ╚═╝╚═╝  ╚═╝╚═╝╚═╝  ╚═══╝    ╚═╝     ╚═╝╚══════╝╚═╝  ╚═══╝ ╚═════╝ 
																					
																					
					▗     ▄▖      ▗              ▖▖      
					▜     ▌ ▛▘█▌▀▌▜▘█▌  ▛▌█▌▌▌▌  ▙▌█▌▛▘▛▌
					▟▖▗   ▙▖▌ ▙▖█▌▐▖▙▖  ▌▌▙▖▚▚▘  ▌▌▙▖▌ ▙▌
														
					▄▖    ▖▖          
					▄▌    ▙▌█▌▛▘▛▌█▌▛▘
					▙▖▗   ▌▌▙▖▌ ▙▌▙▖▄▌
									
					▄▖    ▄▖  ▗       ▗ ▌     ▄▖        
					▄▌    ▙▖▛▌▜▘█▌▛▘  ▜▘▛▌█▌  ▌▌▛▘█▌▛▌▀▌
					▄▌▗   ▙▖▌▌▐▖▙▖▌   ▐▖▌▌▙▖  ▛▌▌ ▙▖▌▌█▌
														
					▖▖    ▄▖  ▘▗   ▄▖       
					▙▌    ▙▖▚▘▌▜▘  ▌ ▀▌▛▛▌█▌
					 ▌▗   ▙▖▞▖▌▐▖  ▙▌█▌▌▌▌▙▖

		""";

	public static final String SELECT_OPTION = "\n\n" + """
				▄▖  ▜     ▗             ▗ ▘    
				▚ █▌▐ █▌▛▘▜▘  ▀▌▛▌  ▛▌▛▌▜▘▌▛▌▛▌
				▄▌▙▖▐▖▙▖▙▖▐▖  █▌▌▌  ▙▌▙▌▐▖▌▙▌▌▌▗▗▗
				                      ▌        
										""";

	public static final String OUT_MSG = "\n" + """
				▄▖  ▘▗ ▘                       ▄▖                        ▌
				▙▖▚▘▌▜▘▌▛▌▛▌  ▛▌▀▌▛▛▌█▌        ▚ █▌█▌  ▌▌▛▌▌▌  ▛▘▛▌▛▌▛▌  ▌
				▙▖▞▖▌▐▖▌▌▌▙▌  ▙▌█▌▌▌▌▙▖▗ ▗ ▗   ▄▌▙▖▙▖  ▙▌▙▌▙▌  ▄▌▙▌▙▌▌▌  ▖
				          ▄▌  ▄▌                       ▄▌                 
					""";

	public static final String NAME_HERO = "\n\n" + """
			▄▖▌                                        ▖▖  ▗       ▗       ▌     ▌   ▘  ▗                    
			▌ ▛▌▛▌▛▌▛▘█▌  ▛▌▀▌▛▛▌█▌  ▛▌▛▘  ▛▌▛▘█▌▛▘▛▘  ▚▘  ▜▘▛▌  ▛▘▜▘█▌▛▌  ▛▌▀▌▛▘▙▘  ▌▛▌▜▘▛▌  ▛▛▌█▌▛▌▌▌      
			▙▖▌▌▙▌▙▌▄▌▙▖  ▌▌█▌▌▌▌▙▖  ▙▌▌   ▙▌▌ ▙▖▄▌▄▌  ▌▌  ▐▖▙▌  ▄▌▐▖▙▖▙▌  ▙▌█▌▙▖▛▖  ▌▌▌▐▖▙▌  ▌▌▌▙▖▌▌▙▌▗ ▗ ▗ 
					               ▌                           ▌                                     
			""";

	public static final String CHOOSE_CLASS = "\n" + """
				▄▖▌                 ▜       
				▌ ▛▌▛▌▛▌▛▘█▌  ▀▌  ▛▘▐ ▀▌▛▘▛▘
				▙▖▌▌▙▌▙▌▄▌▙▖  █▌  ▙▖▐▖█▌▄▌▄▌▗▗▗
											

					▗              ▘    
					▜     ▌▌▌▀▌▛▘▛▘▌▛▌▛▘
					▟▖▗   ▚▚▘█▌▌ ▌ ▌▙▌▌ 

					▄▖             
					▄▌    ▛▛▌▀▌▛▌█▌
					▙▖▗   ▌▌▌█▌▙▌▙▖
						   ▄▌ 
					▄▖          ▌     
					▄▌    ▀▌▛▘▛▘▛▌█▌▛▘
					▄▌▗   █▌▌ ▙▖▌▌▙▖▌ 

					▖▖        ▜    ▌▘  
					▙▌    ▛▌▀▌▐ ▀▌▛▌▌▛▌
					 ▌▗   ▙▌█▌▐▖█▌▙▌▌▌▌
					      ▌            
					▄▖                ▘  
					▙▖    ▀▌▛▘▛▘▀▌▛▘▛▘▌▛▌
					▄▌▗   █▌▄▌▄▌█▌▄▌▄▌▌▌▌
			""";

	public static final String ENTER_BACK = "\n\n" + """
			▄▖          ▄▖▖ ▖▄▖▄▖▄▖  ▗       ▗       ▌     ▌   ▘  ▗     ▗ ▌              
			▙▌▛▘█▌▛▘▛▘  ▙▖▛▖▌▐ ▙▖▙▘  ▜▘▛▌  ▛▘▜▘█▌▛▌  ▛▌▀▌▛▘▙▘  ▌▛▌▜▘▛▌  ▜▘▛▌█▌  ▛▛▌█▌▛▌▌▌
			▌ ▌ ▙▖▄▌▄▌  ▙▖▌▝▌▐ ▙▖▌▌  ▐▖▙▌  ▄▌▐▖▙▖▙▌  ▙▌█▌▙▖▛▖  ▌▌▌▐▖▙▌  ▐▖▌▌▙▖  ▌▌▌▙▖▌▌▙▌ ▗▗▗
							     ▌                                       
			""";

	public static final String ENTER_BACK_GAME = "\n\n" + """
			▄▖          ▄▖▖ ▖▄▖▄▖▄▖  ▗       ▗       ▌     ▌   ▘  ▗     ▗ ▌                    
			▙▌▛▘█▌▛▘▛▘  ▙▖▛▖▌▐ ▙▖▙▘  ▜▘▛▌  ▛▘▜▘█▌▛▌  ▛▌▀▌▛▘▙▘  ▌▛▌▜▘▛▌  ▜▘▛▌█▌  ▛▌▀▌▛▛▌█▌      
			▌ ▌ ▙▖▄▌▄▌  ▙▖▌▝▌▐ ▙▖▌▌  ▐▖▙▌  ▄▌▐▖▙▖▙▌  ▙▌█▌▙▖▛▖  ▌▌▌▐▖▙▌  ▐▖▌▌▙▖  ▙▌█▌▌▌▌▙▖▗ ▗ ▗ 
			                                     ▌                              ▄▌             
			""";

	public static final String WARNING ="\n" + """
			▄▖▜                     ▗       ▗   ▜       ▗           ▌         ▌  ▄▖          ▄▖▖ ▖▄▖▄▖▄▖  ▗           ▗ ▘            
			▙▌▐ █▌▀▌▛▘█▌    ▛▘▛▘█▌▀▌▜▘█▌  ▀▌▜▘  ▐ █▌▀▌▛▘▜▘  ▛▌▛▌█▌  ▛▌█▌▛▘▛▌  ▌  ▙▌▛▘█▌▛▘▛▘  ▙▖▛▖▌▐ ▙▖▙▘  ▜▘▛▌  ▛▘▛▌▛▌▜▘▌▛▌▌▌█▌      
			▌ ▐▖▙▖█▌▄▌▙▖▗   ▙▖▌ ▙▖█▌▐▖▙▖  █▌▐▖  ▐▖▙▖█▌▄▌▐▖  ▙▌▌▌▙▖  ▌▌▙▖▌ ▙▌  ▖  ▌ ▌ ▙▖▄▌▄▌  ▙▖▌▝▌▐ ▙▖▌▌  ▐▖▙▌  ▙▖▙▌▌▌▐▖▌▌▌▙▌▙▖▗ ▗ ▗ 
				    ▘                                                                                                            
			""";

	public static final String SELECT_HERO = "\n\n" + """
			▄▖  ▗           ▌       ▌               ▗     ▌     ▘                      ▖▖  ▗       ▗       ▌     ▌   ▘  ▗                    
			▙▖▛▌▜▘█▌▛▘  ▀▌  ▛▌█▌▛▘▛▌ ▛▘  ▛▌▀▌▛▛▌█▌  ▜▘▛▌  ▛▌█▌▛▌▌▛▌  ▛▌▛▘  ▛▌▛▘█▌▛▘▛▘  ▚▘  ▜▘▛▌  ▛▘▜▘█▌▛▌  ▛▌▀▌▛▘▙▘  ▌▛▌▜▘▛▌  ▛▛▌█▌▛▌▌▌      
			▙▖▌▌▐▖▙▖▌   █▌  ▌▌▙▖▌ ▙▌ ▄▌  ▌▌█▌▌▌▌▙▖  ▐▖▙▌  ▙▌▙▖▙▌▌▌▌  ▙▌▌   ▙▌▌ ▙▖▄▌▄▌  ▌▌  ▐▖▙▌  ▄▌▐▖▙▖▙▌  ▙▌█▌▙▖▛▖  ▌▌▌▐▖▙▌  ▌▌▌▙▖▌▌▙▌▗ ▗ ▗ 
			                                                  ▄▌           ▌                           ▌                                     
			""";

	public static final String DELETE_HERO = "\n" + """
			▄▖  ▗       ▌                    ▗      ▌  ▜   ▗           ▖▖  ▗         ▘▗       
			▙▖▛▌▜▘█▌▛▘  ▛▌█▌▛▘▛▌  ▛▌▀▌▛▛▌█▌  ▜▘▛▌  ▛▌█▌▐ █▌▜▘█▌  ▛▌▛▘  ▚▘  ▜▘▛▌  █▌▚▘▌▜▘      
			▙▖▌▌▐▖▙▖▌   ▌▌▙▖▌ ▙▌  ▌▌█▌▌▌▌▙▖  ▐▖▙▌  ▙▌▙▖▐▖▙▖▐▖▙▖  ▙▌▌   ▌▌  ▐▖▙▌  ▙▖▞▖▌▐▖▗ ▗ ▗ 
			""";
	
	public static final String A_SIMPLE = "\n\n" + """
			▗▄▖      ▌            ▄ ▄▖▖▖  ▄▖▄▖▖ ▖▄▖            ▌      ▗▄▖
			▌▄▐  ▄▖▄▖▌            ▌▌▙▖▌▌  ▗▘▌▌▛▖▌▙▖            ▌▄▖▄▖  ▌▄▐
			▌▀▀      ▖▄▖▄▖▄▖▄▖▄▖  ▙▘▙▖▚▘  ▙▖▙▌▌▝▌▙▖  ▄▖▄▖▄▖▄▖▄▖▖      ▌▀▀
			▀                                                         ▀ 

			▗     ▄▖▌         ▄▖       ▌▄▖    ▗ 
			▜     ▌ ▛▌▀▌▛▌▛▌█▌▚ ▛▌█▌█▌▛▌▐ █▌▚▘▜▘
			▟▖▗   ▙▖▌▌█▌▌▌▙▌▙▖▄▌▙▌▙▖▙▖▙▌▐ ▙▖▞▖▐▖
			              ▄▌    ▌               
			▄▖    ▄▖  ▘▗ 
			▄▌    ▙▖▚▘▌▜▘
			▙▖▗   ▙▖▞▖▌▐▖
						
			▄▖    ▄ ▘    ▜     ▄▖       ▘    
			▄▌    ▌▌▌▛▘▛▌▐ ▀▌▌▌▙▖▛▌█▌▛▛▌▌█▌▛▘
			▄▌▗   ▙▘▌▄▌▙▌▐▖█▌▙▌▙▖▌▌▙▖▌▌▌▌▙▖▄▌
              ▌     ▄▌              
			▖▖    ▗ ▄▖▄▖▄▖▄▖▖▖▄▖
			▙▌    ▜ ▛▌▛▌▛▌▛▌▙▌▙▌
			 ▌▗   ▟▖█▌█▌█▌█▌▌▌▌ 
                    
			""";

	public static final String SPEED = "\n\n" + """
			▖ ▖           ▜           
			▛▖▌█▌▌▌▌  ▌▌▀▌▐ ▌▌█▌      
			▌▝▌▙▖▚▚▘  ▚▘█▌▐▖▙▌▙▖▗ ▗ ▗ 
									
			""";

	public static final String ERROR_NAME = "" + """
			▄▖▌                       ▗       ▗   ▌            ▗             ▜        ▌    ▗   ▌           
			▐ ▛▌█▌  ▛▌▀▌▛▛▌█▌  ▛▛▌▌▌▛▘▜▘  ▛▌▛▌▜▘  ▛▌█▌  █▌▛▛▌▛▌▜▘▌▌  ▛▌▛▘  ▀▌▐ ▛▘█▌▀▌▛▌▌▌  ▜▘▀▌▙▘█▌▛▌      
			▐ ▌▌▙▖  ▌▌█▌▌▌▌▙▖  ▌▌▌▙▌▄▌▐▖  ▌▌▙▌▐▖  ▙▌▙▖  ▙▖▌▌▌▙▌▐▖▙▌  ▙▌▌   █▌▐▖▌ ▙▖█▌▙▌▙▌  ▐▖█▌▛▖▙▖▌▌▗ ▗ ▗ 
			                                                 ▌   ▄▌                    ▄▌                  
			""";

	public static final String RULES = "\n\n" + """
			▖  ▖                                                     
			▌▞▖▌  ▄▖  ▌▌▛▌                                           
			▛ ▝▌      ▙▌▙▌                                           
				    ▌                                            
			▄▖       ▌                                               
			▚   ▄▖  ▛▌▛▌▌▌▌▛▌                                        
			▄▌      ▙▌▙▌▚▚▘▌▌                                        
																	
			▄▖      ▜   ▐▘▗                                          
			▌▌  ▄▖  ▐ █▌▜▘▜▘                                         
			▛▌      ▐▖▙▖▐ ▐▖                                         
																				
			▄         ▘  ▌ ▗                                         
			▌▌  ▄▖  ▛▘▌▛▌▛▌▜▘                                        
			▙▘      ▌ ▌▙▌▌▌▐▖                                        
				   ▄▌                                            
			▄▖      ▄▖        ▗                                      
			▐   ▄▖  ▐ ▛▌▌▌█▌▛▌▜▘▛▌▛▘▌▌                               
			▟▖      ▟▖▌▌▚▘▙▖▌▌▐▖▙▌▌ ▙▌                               
					        ▄▌                               
			▖▖          ▘▗   ▗▘              ▘▜ ▜   ▌     ▜     ▗ ▌▝▖
			▚▘  ▄▖  █▌▚▘▌▜▘  ▐ ▛▌▀▌▛▛▌█▌  ▌▌▌▌▐ ▐   ▛▌█▌  ▐ ▛▌▛▘▜▘▌ ▌
			▌▌      ▙▖▞▖▌▐▖  ▐ ▙▌█▌▌▌▌▙▖  ▚▚▘▌▐▖▐▖  ▙▌▙▖  ▐▖▙▌▄▌▐▖▖ ▌
					 ▝▖▄▌                                  ▗▘
			""";

	public static final String GAME_OVER = """
			▄▖         ▄▖        ▌  ▄▖              ▗           
			▌ ▀▌▛▛▌█▌  ▌▌▌▌█▌▛▘  ▌  ▙▌▛▘█▌▛▘▛▘  █▌▛▌▜▘█▌▛▘      
			▙▌█▌▌▌▌▙▖  ▙▌▚▘▙▖▌   ▖  ▌ ▌ ▙▖▄▌▄▌  ▙▖▌▌▐▖▙▖▌ ▗ ▗ ▗ 
																
			""";

	public static final String LVL_COMPLETE = """
			▖       ▜            ▜   ▗     ▌  ▄▖          ▗   ▜   ▗ ▘        ▌  ▄▖          ▄▖  ▗           
			▌ █▌▌▌█▌▐   ▛▘▛▌▛▛▌▛▌▐ █▌▜▘█▌  ▌  ▌ ▛▌▛▌▛▌▛▘▀▌▜▘▌▌▐ ▀▌▜▘▌▛▌▛▌▛▘  ▌  ▙▌▛▘█▌▛▘▛▘  ▙▖▛▌▜▘█▌▛▘      
			▙▖▙▖▚▘▙▖▐▖  ▙▖▙▌▌▌▌▙▌▐▖▙▖▐▖▙▖  ▖  ▙▖▙▌▌▌▙▌▌ █▌▐▖▙▌▐▖█▌▐▖▌▙▌▌▌▄▌  ▖  ▌ ▌ ▙▖▄▌▄▌  ▙▖▌▌▐▖▙▖▌ ▗ ▗ ▗ 
					   ▌                    ▄▌                                                      
			""";

	public static final String EXIT_GAME = """
			▄▖             ▘▗    ▌  ▌  ▄▖          ▄▖  ▗           
			▌ ▀▌▛▛▌█▌  █▌▚▘▌▜▘█▌▛▌  ▌  ▙▌▛▘█▌▛▘▛▘  ▙▖▛▌▜▘█▌▛▘      
			▙▌█▌▌▌▌▙▖  ▙▖▞▖▌▐▖▙▖▙▌  ▖  ▌ ▌ ▙▖▄▌▄▌  ▙▖▌▌▐▖▙▖▌ ▗ ▗ ▗ 
																
			""";

	public static final String HP_POTION = """
			▖▖      ▐▘       ▌        ▌     ▜ ▘          ▗ ▘      ▌
			▌▌▛▌▌▌  ▜▘▛▌▌▌▛▌▛▌  ▀▌▛▌  ▛▌█▌▀▌▐ ▌▛▌▛▌  ▛▌▛▌▜▘▌▛▌▛▌  ▌
			▐ ▙▌▙▌  ▐ ▙▌▙▌▌▌▙▌  █▌▌▌  ▌▌▙▖█▌▐▖▌▌▌▙▌  ▙▌▙▌▐▖▌▙▌▌▌  ▖
				                             ▄▌  ▌             
			""";

	public static final String INVENTORY_MENU = """

				██╗███╗   ██╗██╗   ██╗███████╗███╗   ██╗████████╗ ██████╗ ██████╗ ██╗   ██╗
				██║████╗  ██║██║   ██║██╔════╝████╗  ██║╚══██╔══╝██╔═══██╗██╔══██╗╚██╗ ██╔╝
				██║██╔██╗ ██║██║   ██║█████╗  ██╔██╗ ██║   ██║   ██║   ██║██████╔╝ ╚████╔╝ 
				██║██║╚██╗██║╚██╗ ██╔╝██╔══╝  ██║╚██╗██║   ██║   ██║   ██║██╔══██╗  ╚██╔╝  
				██║██║ ╚████║ ╚████╔╝ ███████╗██║ ╚████║   ██║   ╚██████╔╝██║  ██║   ██║   
				╚═╝╚═╝  ╚═══╝  ╚═══╝  ╚══════╝╚═╝  ╚═══╝   ╚═╝    ╚═════╝ ╚═╝  ╚═╝   ╚═╝   
																						
					▗     ▄▖    ▘                  
					▜     ▙▖▛▌▌▌▌▛▌                
					▟▖▗   ▙▖▙▌▙▌▌▙▌                
						 ▌   ▌                 
					▄▖    ▖▖        ▘              
					▄▌    ▌▌▛▌█▌▛▌▌▌▌▛▌            
					▙▖▗   ▙▌▌▌▙▖▙▌▙▌▌▙▌            
						     ▌   ▌             
					▄▖    ▄                        
					▄▌    ▌▌▛▘▛▌▛▌                 
					▄▌▗   ▙▘▌ ▙▌▙▌                 
						    ▌                  
					▖▖    ▖▖          ▗ ▘          
					▙▌    ▌▌▛▘█▌  ▛▌▛▌▜▘▌▛▌▛▌      
					 ▌▗   ▙▌▄▌▙▖  ▙▌▙▌▐▖▌▙▌▌▌      
						      ▌                
					▄▖    ▌     ▌   ▗              
					▙▖    ▛▌▀▌▛▘▙▘  ▜▘▛▌  ▛▌▀▌▛▛▌█▌
					▄▌▗   ▙▌█▌▙▖▛▖  ▐▖▙▌  ▙▌█▌▌▌▌▙▖
                      		      ▄▌       
			""";

	public static final String FIGHT_TITLE = """
			
                  ██╗██╗ ██╗ ██╗    ███████╗██╗ ██████╗ ██╗  ██╗████████╗    ██╗ ██╗ ██╗██╗                  
                  ██║╚═╝██╔╝██╔╝    ██╔════╝██║██╔════╝ ██║  ██║╚══██╔══╝    ╚██╗╚═╝██╔╝██║                  
█████╗█████╗█████╗██║  ██╔╝ ██║     █████╗  ██║██║  ███╗███████║   ██║        ██║  ██╔╝ ██║█████╗█████╗█████╗
╚════╝╚════╝╚════╝╚═╝ ██╔╝  ██║     ██╔══╝  ██║██║   ██║██╔══██║   ██║        ██║ ██╔╝  ╚═╝╚════╝╚════╝╚════╝
                  ██╗██╔╝██╗╚██╗    ██║     ██║╚██████╔╝██║  ██║   ██║       ██╔╝██╔╝██╗██╗                  
                  ╚═╝╚═╝ ╚═╝ ╚═╝    ╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝   ╚═╝       ╚═╝ ╚═╝ ╚═╝╚═╝                  
                                                                                                             
			""";

	public static final String FIGHT_MENU = """
			▗   ▄▖▘  ▌ ▗     ▄▖  ▄ ▜     ▌     ▄▖  ▄▖        ▖▖  ▄▖        ▗       
			▜   ▙▖▌▛▌▛▌▜▘    ▄▌  ▙▘▐ ▛▌▛▘▙▘    ▄▌  ▙▘▌▌▛▌    ▙▌  ▐ ▛▌▌▌█▌▛▌▜▘▛▌▛▘▌▌
			▟▖▗ ▌ ▌▙▌▌▌▐▖    ▙▖▗ ▙▘▐▖▙▌▙▖▛▖    ▄▌▗ ▌▌▙▌▌▌     ▌▗ ▟▖▌▌▚▘▙▖▌▌▐▖▙▌▌ ▙▌
			       ▄▌                                                            ▄▌
			""";

	public static final String SAME_POWER = """
			▄   ▗ ▌   ▐▘▘  ▌ ▗           ▜     ▌      ▘▗ ▌           ▜     ▗         ▗ ▌       
			▙▘▛▌▜▘▛▌  ▜▘▌▛▌▛▌▜▘█▌▛▘▛▘  ▛▘▐ ▀▌▛▘▛▌  ▌▌▌▌▜▘▛▌  █▌▛▌▌▌▀▌▐   ▛▘▜▘▛▘█▌▛▌▛▌▜▘▛▌      
			▙▘▙▌▐▖▌▌  ▐ ▌▙▌▌▌▐▖▙▖▌ ▄▌  ▙▖▐▖█▌▄▌▌▌  ▚▚▘▌▐▖▌▌  ▙▖▙▌▙▌█▌▐▖  ▄▌▐▖▌ ▙▖▌▌▙▌▐▖▌▌▗ ▗ ▗ 
				     ▄▌                                     ▌                  ▄▌          
			""";

	public static final String LOOT = """
			▄▖▌                   ▌         ▌      ▗               ▌  ▄                    ▗   ▗       ▘  ▌   ▘▗       ▄▖
			▐ ▛▌█▌  █▌▛▌█▌▛▛▌▌▌  ▛▌▛▘▛▌▛▌█▌▛▌  ▀▌  ▜▘▛▘█▌▀▌▛▘▌▌▛▘█▌▌  ▌▌▛▌  ▌▌▛▌▌▌  ▌▌▌▀▌▛▌▜▘  ▜▘▛▌  ▛▌▌▛▘▙▘  ▌▜▘  ▌▌▛▌▗▘
			▐ ▌▌▙▖  ▙▖▌▌▙▖▌▌▌▙▌  ▙▌▌ ▙▌▙▌▙▖▙▌  █▌  ▐▖▌ ▙▖█▌▄▌▙▌▌ ▙▖▖  ▙▘▙▌  ▙▌▙▌▙▌  ▚▚▘█▌▌▌▐▖  ▐▖▙▌  ▙▌▌▙▖▛▖  ▌▐▖  ▙▌▙▌▗ 
					 ▄▌        ▌                                    ▄▌                       ▌               ▌   
			""";

	public static final String LOOT_OPTION = """
			▗   ▖▖        ▄▖  ▖ ▖  
			▜   ▌▌█▌▛▘    ▄▌  ▛▖▌▛▌
			▟▖▗ ▐ ▙▖▄▌    ▙▖▗ ▌▝▌▙▌
								
			""";

	public static final String TO_REMOVE = """
			▄▖  ▗       ▘▗                   ▗      ▌  ▜   ▗         
			▙▖▛▌▜▘█▌▛▘  ▌▜▘█▌▛▛▌  ▛▌▀▌▛▛▌█▌  ▜▘▛▌  ▛▌█▌▐ █▌▜▘█▌      
			▙▖▌▌▐▖▙▖▌   ▌▐▖▙▖▌▌▌  ▌▌█▌▌▌▌▙▖  ▐▖▙▌  ▙▌▙▖▐▖▙▖▐▖▙▖▗ ▗ ▗ 
																	
			""";

	public static final String TO_UNEQUIPPED = """
			▄▖  ▗       ▘▗                   ▗               ▘       ▌      
			▙▖▛▌▜▘█▌▛▘  ▌▜▘█▌▛▛▌  ▛▌▀▌▛▛▌█▌  ▜▘▛▌  ▌▌▛▌█▌▛▌▌▌▌▛▌▛▌█▌▛▌      
			▙▖▌▌▐▖▙▖▌   ▌▐▖▙▖▌▌▌  ▌▌█▌▌▌▌▙▖  ▐▖▙▌  ▙▌▌▌▙▖▙▌▙▌▌▙▌▙▌▙▖▙▌▗ ▗ ▗ 
								      ▌   ▌ ▌           
			""";

	public static final String TO_EQUIPPED = """
			▄▖  ▗       ▘▗                   ▗           ▘       ▌      
			▙▖▛▌▜▘█▌▛▘  ▌▜▘█▌▛▛▌  ▛▌▀▌▛▛▌█▌  ▜▘▛▌  █▌▛▌▌▌▌▛▌▛▌█▌▛▌      
			▙▖▌▌▐▖▙▖▌   ▌▐▖▙▖▌▌▌  ▌▌█▌▌▌▌▙▖  ▐▖▙▌  ▙▖▙▌▙▌▌▙▌▙▌▙▖▙▌▗ ▗ ▗ 
								  ▌   ▌ ▌           
			""";


	// ==================
	//      GUI DATA
	// ==================

	public static final String WELCOME_MSG = """
	<html style='text-align:center'>
	Welcome, brave adventurer!<br>
	Your journey through the world of Swingy begins now!<br>
	Where courage, strategy, and fate will decide your legend...
	</html>
	""";

	public static String FORBIDDEN_CHAR = "<html><div align='center' style='color: red;'>"
		+ "Name already exists or contains Forbidden characters!<br/>"
		+ "<b>Try again</b>"
		+ "</div></html>";

	public static String DEAD_HERO_CASE = "DEAD HERO";
	public static String DEAD_ENEMY_CASE = "DEAD ENEMY";
	public static String ESCAPE_CASE = "ESCAPE";
	public static String LOOT_CASE = "LOOT";
	public static String EQUAL_CASE = "Both fighters clash with equal strength! No one was hurt!";

	public static String NO_SELECTION = "<html><div style='color:red; text-align:center;'>No hero selected!</div></html>";
	public static String HERO_NOT_FOUND = "<html><div style='color:red; text-align:center;'>Hero not found!</div></html>";
	public static String HERO_DELETED = "<html><div style='color:red; text-align:center;'>Hero deleted!</div></html>";
}
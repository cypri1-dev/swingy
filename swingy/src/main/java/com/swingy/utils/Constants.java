package com.swingy.utils;

public final class Constants {

	private Constants() {}

	public static final int TIME_DEV = 0;
	
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

	/* TYPES CHARACTERS */

	public static final String HERO_TYPE = "hero";
	public static final String ENEMY_TYPE = "enemy";

	/* TYPE CLASS */

	public static final String WARRIOR_CLASS = "warrior";
	public static final String MAGE_CLASS = "mage";
	public static final String ARCHER_CLASS = "archer";
	public static final String PALADIN_CLASS = "paladin";
	public static final String ASSASSIN_CLASS = "assassin";

	/* STATS CLASS HERO */

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

	/* ENEMY STATS */

	public static final int HP_BASE_ENEMY = 8;
	public static final int ATT_BASE_ENEMY = 4;
	public static final int DEF_BASE_ENEMY = 4;

	/* ENEMY ARCHETYPES */

	public static final String[] ENEMIES_LIST_NAMES = {
		"Goblin",
		"Orc",
		"Skeleton",
		"Bandit",
		"Dark Mage",
		"Troll",
		"Assassin",
		"Cultist",
		"Elemental",
		"Dragon Whelp"
	};

	public static final String ENEMY_CLASS_GOBELIN = "Goblin";
	public static final String ENEMY_CLASS_ORC = "Orc";
	public static final String ENEMY_CLASS_SKELETON = "Skeleton";
	public static final String ENEMY_CLASS_BANDIT = "Bandit";
	public static final String ENEMY_CLASS_DARK_MAGE = "Dark Mage";
	public static final String ENEMY_CLASS_TROLL = "Troll";
	public static final String ENEMY_CLASS_ASSASSIN = "Assassin";
	public static final String ENEMY_CLASS_CULTIST = "Cultist";
	public static final String ENEMY_CLASS_ELEMENTAL = "Elemental";
	public static final String ENEMY_CLASS_DRAGON_WHELP  = "Dragon Whelp";

	public static final int HP_GOBLIN = -2;
	public static final int ATT_GOBLIN = 1;
	public static final int DEF_GOBLIN = -1;
	public static final int XP_GOBLIN = 18;

	public static final int HP_ORC = 3;
	public static final int ATT_ORC = 3;
	public static final int DEF_ORC = -1;
	public static final int XP_ORC = 30;

	public static final int HP_SKELETON = -1;
	public static final int ATT_SKELETON = 0;
	public static final int DEF_SKELETON = 2;
	public static final int XP_SKELETON = 20;

	public static final int HP_BANDIT = 0;
	public static final int ATT_BANDIT = 1;
	public static final int DEF_BANDIT = 0;
	public static final int XP_BANDIT = 22;

	public static final int HP_DARK_MAGE = -3;
	public static final int ATT_DARK_MAGE = 4;
	public static final int DEF_DARK_MAGE = -2;
	public static final int XP_DARK_MAGE = 55;

	public static final int HP_TROLL = 6;
	public static final int ATT_TROLL = 1;
	public static final int DEF_TROLL = 3;
	public static final int XP_TROLL = 40;

	public static final int HP_ASSASSIN_ENEMY = -2;
	public static final int ATT_ASSASSIN_ENEMY = 5;
	public static final int DEF_ASSASSIN_ENEMY = -3;
	public static final int XP_ASSASSIN_ENEMY = 60;

	public static final int HP_CULTIST = -1;
	public static final int ATT_CULTIST = 2;
	public static final int DEF_CULTIST = 1;
	public static final int XP_CULTIST = 24;

	public static final int HP_ELEMENTAL = 2;
	public static final int ATT_ELEMENTAL = 2;
	public static final int DEF_ELEMENTAL = 4;
	public static final int XP_ELEMENTAL = 45;

	public static final int HP_DRAGON_WHELP = 5;
	public static final int ATT_DRAGON_WHELP = 5;
	public static final int DEF_DRAGON_WHELP = 3;
	public static final int XP_DRAGON_WHELP = 70;

	/* TYPES ARTEFACTS */

	public static final String ARMOR_TYPE = "armor";
	public static final String HELM_TYPE = "helm";
	public static final String WEAPON_TYPE = "weapon";
	public static final String CONSOMMABLE_TYPE = "consommable";

	public static final String COMMON = "common";
	public static final String RARE = "rare";
	public static final String EPIC = "epic";
	public static final String LEGENDARY = "legendary";

	/* -------------------- WEAPONS (ATT bonus) -------------------- */

	public static final String[] WEAPONS_COMMON = {
		"Rusty Dagger",
		"Iron Sword",
		"Wooden Mace",
		"Stone Axe"
	};

	public static final String[] WEAPONS_RARE = {
		"Steel Axe",
		"Elven Longbow",
		"Iron Spear"
	};

	public static final String[] WEAPONS_EPIC = {
		"Rune Blade",
		"Shadowfang"
	};

	public static final String[] WEAPONS_LEGENDARY = {
		"Excalibur"
	};

	/* Commun */
	public static final String WEAPON_NAME_RUSTY_DAGGER = "Rusty Dagger (+1.ATT)";
	public static final String WEAPON_RARITY_RUSTY_DAGGER = COMMON;
	public static final int WEAPON_ATT_RUSTY_DAGGER = 1;

	public static final String WEAPON_NAME_IRON_SWORD = "Iron Sword (+2.ATT)";
	public static final String WEAPON_RARITY_IRON_SWORD = COMMON;
	public static final int WEAPON_ATT_IRON_SWORD = 2;

	public static final String WEAPON_NAME_WOODEN_MACE = "Wooden Mace (+1.ATT)";
	public static final String WEAPON_RARITY_WOODEN_MACE = COMMON;
	public static final int WEAPON_ATT_WOODEN_MACE = 1;

	public static final String WEAPON_NAME_STONE_AXE = "Stone Axe (+2.ATT)";
	public static final String WEAPON_RARITY_STONE_AXE = COMMON;
	public static final int WEAPON_ATT_STONE_AXE = 2;

	/* Rare */
	public static final String WEAPON_NAME_STEEL_AXE = "Steel Axe (+3.ATT)";
	public static final String WEAPON_RARITY_STEEL_AXE = RARE;
	public static final int WEAPON_ATT_STEEL_AXE = 3;

	public static final String WEAPON_NAME_ELVEN_LONGBOW = "Elven Longbow (+4.ATT)";
	public static final String WEAPON_RARITY_ELVEN_LONGBOW = RARE;
	public static final int WEAPON_ATT_ELVEN_LONGBOW = 4;

	public static final String WEAPON_NAME_IRON_SPEAR = "Iron Spear (+3.ATT)";
	public static final String WEAPON_RARITY_IRON_SPEAR = RARE;
	public static final int WEAPON_ATT_IRON_SPEAR = 3;

	/* Epic */
	public static final String WEAPON_NAME_RUNE_BLADE = "Rune Blade (+5.ATT)";
	public static final String WEAPON_RARITY_RUNE_BLADE = EPIC;
	public static final int WEAPON_ATT_RUNE_BLADE = 5;

	public static final String WEAPON_NAME_SHADOWFANG = "Shadowfang (+6.ATT)";
	public static final String WEAPON_RARITY_SHADOWFANG = EPIC;
	public static final int WEAPON_ATT_SHADOWFANG = 6;

	/* Légendaire */
	public static final String WEAPON_NAME_EXCALIBUR = "Excalibur (+10.ATT)";
	public static final String WEAPON_RARITY_EXCALIBUR = LEGENDARY;
	public static final int WEAPON_ATT_EXCALIBUR = 10;

	/* -------------------- ARMORS (DEF bonus) -------------------- */

	public static final String[] ARMORS_COMMON = {
		"Leather Vest",
		"Chainmail",
		"Hide Armor",
		"Paw Leather"
	};

	public static final String[] ARMORS_RARE = {
		"Iron Plate",
		"Dwarven Chestguard",
		"Steel Chain"
	};

	public static final String[] ARMORS_EPIC = {
		"Enchanted Breastplate",
		"Obsidian Armor"
	};

	public static final String[] ARMORS_LEGENDARY = {
		"Dragon Scale Armor"
	};

	/* Commun */
	public static final String ARMOR_NAME_LEATHER_VEST = "Leather Vest (+1.DEF)";
	public static final String ARMOR_RARITY_LEATHER_VEST = COMMON;
	public static final int ARMOR_DEF_LEATHER_VEST = 1;

	public static final String ARMOR_NAME_CHAINMAIL = "Chainmail (+2.DEF)";
	public static final String ARMOR_RARITY_CHAINMAIL = COMMON;
	public static final int ARMOR_DEF_CHAINMAIL = 2;

	public static final String ARMOR_NAME_HIDE_ARMOR = "Hide Armor (+1.DEF)";
	public static final String ARMOR_RARITY_HIDE_ARMOR = COMMON;
	public static final int ARMOR_DEF_HIDE_ARMOR = 1;

	public static final String ARMOR_NAME_PAW_LEATHER = "Paw Leather (+2.DEF)";
	public static final String ARMOR_RARITY_PAW_LEATHER = COMMON;
	public static final int ARMOR_DEF_PAW_LEATHER = 2;

	/* Rare */
	public static final String ARMOR_NAME_IRON_PLATE = "Iron Plate (+3.DEF)";
	public static final String ARMOR_RARITY_IRON_PLATE = RARE;
	public static final int ARMOR_DEF_IRON_PLATE = 3;

	public static final String ARMOR_NAME_DWARVEN_CHESTGUARD = "Dwarven Chestguard (+4.DEF)";
	public static final String ARMOR_RARITY_DWARVEN_CHESTGUARD = RARE;
	public static final int ARMOR_DEF_DWARVEN_CHESTGUARD = 4;

	public static final String ARMOR_NAME_STEEL_CHAIN = "Steel Chain (+3.DEF)";
	public static final String ARMOR_RARITY_STEEL_CHAIN = RARE;
	public static final int ARMOR_DEF_STEEL_CHAIN = 3;

	/* Epic */
	public static final String ARMOR_NAME_ENCHANTED_BREASTPLATE = "Enchanted Breastplate (+5.DEF)";
	public static final String ARMOR_RARITY_ENCHANTED_BREASTPLATE = EPIC;
	public static final int ARMOR_DEF_ENCHANTED_BREASTPLATE = 5;

	public static final String ARMOR_NAME_OBSIDIAN_ARMOR = "Obsidian Armor (+6.DEF)";
	public static final String ARMOR_RARITY_OBSIDIAN_ARMOR = EPIC;
	public static final int ARMOR_DEF_OBSIDIAN_ARMOR = 6;

	/* Légendaire */
	public static final String ARMOR_NAME_DRAGON_SCALE_ARMOR = "Dragon Scale Armor (+7.DEF)";
	public static final String ARMOR_RARITY_DRAGON_SCALE_ARMOR = LEGENDARY;
	public static final int ARMOR_DEF_DRAGON_SCALE_ARMOR = 7;


	/* -------------------- HELMS (HP bonus) -------------------- */

	public static final String[] HELMS_COMMON = {
		"Leather Hood",
		"Iron Helmet",
		"Wooden Cap",
		"Hide Helm"
	};

	public static final String[] HELMS_RARE = {
		"Steel Helm",
		"Guardian Mask",
		"Iron Crown"
	};

	public static final String[] HELMS_EPIC = {
		"Warlord Crown",
		"Helm of Eternity"
	};

	public static final String[] HELMS_LEGENDARY = {
		"Godslayer Helm"
	};

	/* Commun */
	public static final String HELM_NAME_LEATHER_HOOD = "Leather Hood (+3)";
	public static final String HELM_RARITY_LEATHER_HOOD = COMMON;
	public static final int HELM_HP_LEATHER_HOOD = 3;

	public static final String HELM_NAME_IRON_HELMET = "Iron Helmet (+5)";
	public static final String HELM_RARITY_IRON_HELMET = COMMON;
	public static final int HELM_HP_IRON_HELMET = 5;

	public static final String HELM_NAME_WOODEN_CAP = "Wooden Cap (+3)";
	public static final String HELM_RARITY_WOODEN_CAP = COMMON;
	public static final int HELM_HP_WOODEN_CAP = 3;

	public static final String HELM_NAME_HIDE_HELM = "Hide Helm (+4)";
	public static final String HELM_RARITY_HIDE_HELM = COMMON;
	public static final int HELM_HP_HIDE_HELM = 4;

	/* Rare */
	public static final String HELM_NAME_STEEL_HELM = "Steel Helm (+8.HP)";
	public static final String HELM_RARITY_STEEL_HELM = RARE;
	public static final int HELM_HP_STEEL_HELM = 8;

	public static final String HELM_NAME_GUARDIAN_MASK = "Guardian Mask (+10.HP)";
	public static final String HELM_RARITY_GUARDIAN_MASK = RARE;
	public static final int HELM_HP_GUARDIAN_MASK = 10;

	public static final String HELM_NAME_IRON_CROWN = "Iron Crown (+9.HP)";
	public static final String HELM_RARITY_IRON_CROWN = RARE;
	public static final int HELM_HP_IRON_CROWN = 9;

	/* Epic */
	public static final String HELM_NAME_WARLORD_CROWN = "Warlord Crown (+12.HP)";
	public static final String HELM_RARITY_WARLORD_CROWN = EPIC;
	public static final int HELM_HP_WARLORD_CROWN = 12;

	public static final String HELM_NAME_HELM_OF_ETERNITY = "Helm of Eternity (+15.HP)";
	public static final String HELM_RARITY_HELM_OF_ETERNITY = EPIC;
	public static final int HELM_HP_HELM_OF_ETERNITY = 15;

	/* Légendaire */
	public static final String HELM_NAME_GODSLAYER_HELM = "Godslayer Helm (+30.HP)";
	public static final String HELM_RARITY_GODSLAYER_HELM = LEGENDARY;
	public static final int HELM_HP_GODSLAYER_HELM = 30;



	/* SYMBOLS MAP */

	public static final String SYMBOL_MAIN_HERO = BLUE + "@" + RESET;
	public static final String SYMBOL_ENEMY = RED + "!";
	public static final String SYMBOL_ENEMY_GOBELIN = RED + "G" + RESET;
	public static final String SYMBOL_ENEMY_ORC = RED + "O" + RESET;
	public static final String SYMBOL_ENEMY_SKELETON  = RED + "S" + RESET;
	public static final String SYMBOL_ENEMY_BANDIT = RED + "B" + RESET;
	public static final String SYMBOL_ENEMY_DARK_MAGE = RED + "M" + RESET;
	public static final String SYMBOL_ENEMY_TROLL  = RED + "T" + RESET;
	public static final String SYMBOL_ENEMY_ASSASSIN  = RED + "A" + RESET;
	public static final String SYMBOL_ENEMY_CULTIST= RED + "C" + RESET;
	public static final String SYMBOL_ENEMY_ELEMENTAL = RED + "E" + RESET;
	public static final String SYMBOL_ENEMY_DRAGON_WHELP = RED + "D" + RESET;


	/* MAPS DATA */

	public static final double DENSITY = 0.23;
	public static final double DENSITY_CONSOMMABLE = 0.10;

	/* D_V_D__A */

	public static boolean D_V_M___E = false;
	public static int D_V_S___D_T_T = 0;

	/* DISPLAY */

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
					▙▖▗   ▙▘▌ ▙▌▙▌                 
						    ▌                  
					▄▖    ▖▖          ▗ ▘          
					▄▌    ▌▌▛▘█▌  ▛▌▛▌▜▘▌▛▌▛▌      
					▄▌▗   ▙▌▄▌▙▖  ▙▌▙▌▐▖▌▙▌▌▌      
						      ▌                
					▖▖    ▄     ▌   ▗              
					▙▌    ▙▘▀▌▛▘▙▘  ▜▘▛▌  ▛▌▀▌▛▛▌█▌
					 ▌▗   ▙▘█▌▙▖▛▖  ▐▖▙▌  ▙▌█▌▌▌▌▙▖
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
}
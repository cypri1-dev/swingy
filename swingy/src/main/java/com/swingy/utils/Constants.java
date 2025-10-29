package com.swingy.utils;

import java.util.Map;

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

	public static final int HP_BASE_ENEMY = 8;
	public static final int ATT_BASE_ENEMY = 4;
	public static final int DEF_BASE_ENEMY = 4;

	/* ENEMY ARCHETYPES */

	// ==================
	// ENEMY NAMES
	// ==================
	public static final String[] ENEMIES_LIST_NAMES = {
		"Rat",
		"Slime",
		"Goblin",
		"Bandit",
		"Skeleton",
		"Wolf",
		"Cultist",
		"Orc",
		"Dark Mage",
		"Elemental",
		"Troll",
		"Assassin",
		"Lich",
		"Minotaur",
		"Vampire Lord",
		"Demon Knight",
		"Dragon Whelp",
		"Ancient Dragon",
		"Abyssal Hydra",
		"Fallen God"
	};

	// ==================
	// ENEMY CLASS STRINGS
	// ==================
	
	public static final String ENEMY_CLASS_RAT = "Rat";
	public static final String ENEMY_CLASS_SLIME = "Slime";
	public static final String ENEMY_CLASS_GOBLIN = "Goblin";
	public static final String ENEMY_CLASS_BANDIT = "Bandit";
	public static final String ENEMY_CLASS_SKELETON = "Skeleton";
	public static final String ENEMY_CLASS_WOLF = "Wolf";
	public static final String ENEMY_CLASS_CULTIST = "Cultist";
	public static final String ENEMY_CLASS_ORC = "Orc";
	public static final String ENEMY_CLASS_DARK_MAGE = "Dark Mage";
	public static final String ENEMY_CLASS_ELEMENTAL = "Elemental";
	public static final String ENEMY_CLASS_TROLL = "Troll";
	public static final String ENEMY_CLASS_ASSASSIN = "Assassin";
	public static final String ENEMY_CLASS_LICH = "Lich";
	public static final String ENEMY_CLASS_MINOTAUR = "Minotaur";
	public static final String ENEMY_CLASS_VAMPIRE_LORD = "Vampire Lord";
	public static final String ENEMY_CLASS_DEMON_KNIGHT = "Demon Knight";
	public static final String ENEMY_CLASS_DRAGON_WHELP = "Dragon Whelp";
	public static final String ENEMY_CLASS_ANCIENT_DRAGON = "Ancient Dragon";
	public static final String ENEMY_CLASS_ABYSSAL_HYDRA = "Abyssal Hydra";
	public static final String ENEMY_CLASS_FALLEN_GOD = "Fallen God";

	// ==================
	// ENEMY STATS MODIFIERS
	// ==================

	// ---- Niveau 1-4 : très faibles ----
	public static final int HP_RAT = -6;
	public static final int ATT_RAT = -3;
	public static final int DEF_RAT = -3;
	public static final int XP_RAT = 15;

	public static final int HP_SLIME = -5;
	public static final int ATT_SLIME = -3;
	public static final int DEF_SLIME = -2;
	public static final int XP_SLIME = 20;

	public static final int HP_GOBLIN = -4;
	public static final int ATT_GOBLIN = -2;
	public static final int DEF_GOBLIN = -2;
	public static final int XP_GOBLIN = 30;

	public static final int HP_BANDIT = -3;
	public static final int ATT_BANDIT = -2;
	public static final int DEF_BANDIT = -1;
	public static final int XP_BANDIT = 45;

	// ---- Niveau 5-8 : intermédiaires ----
	public static final int HP_SKELETON = -2;
	public static final int ATT_SKELETON = -1;
	public static final int DEF_SKELETON = 0;
	public static final int XP_SKELETON = 70;

	public static final int HP_WOLF = -1;
	public static final int ATT_WOLF = 1;
	public static final int DEF_WOLF = -1;
	public static final int XP_WOLF = 90;

	public static final int HP_CULTIST = 0;
	public static final int ATT_CULTIST = 1;
	public static final int DEF_CULTIST = 0;
	public static final int XP_CULTIST = 120;

	public static final int HP_ORC = 2;
	public static final int ATT_ORC = 2;
	public static final int DEF_ORC = 0;
	public static final int XP_ORC = 160;

	// ---- Niveau 9-12 : avancés ----
	public static final int HP_DARK_MAGE = -1;
	public static final int ATT_DARK_MAGE = 4;
	public static final int DEF_DARK_MAGE = -1;
	public static final int XP_DARK_MAGE = 220;

	public static final int HP_ELEMENTAL = 2;
	public static final int ATT_ELEMENTAL = 2;
	public static final int DEF_ELEMENTAL = 3;
	public static final int XP_ELEMENTAL = 300;

	public static final int HP_TROLL = 4;
	public static final int ATT_TROLL = 1;
	public static final int DEF_TROLL = 3;
	public static final int XP_TROLL = 400;

	public static final int HP_ASSASSIN_ENEMY = -1;
	public static final int ATT_ASSASSIN_ENEMY = 6;
	public static final int DEF_ASSASSIN_ENEMY = -2;
	public static final int XP_ASSASSIN_ENEMY = 550;

	// ---- Niveau 13-16 : élite ----
	public static final int HP_LICH = 3;
	public static final int ATT_LICH = 3;
	public static final int DEF_LICH = 2;
	public static final int XP_LICH = 750;

	public static final int HP_MINOTAUR = 6;
	public static final int ATT_MINOTAUR = 4;
	public static final int DEF_MINOTAUR = 3;
	public static final int XP_MINOTAUR = 950;

	public static final int HP_VAMPIRE_LORD = 2;
	public static final int ATT_VAMPIRE_LORD = 6;
	public static final int DEF_VAMPIRE_LORD = 2;
	public static final int XP_VAMPIRE_LORD = 1200;

	public static final int HP_DEMON_KNIGHT = 7;
	public static final int ATT_DEMON_KNIGHT = 5;
	public static final int DEF_DEMON_KNIGHT = 4;
	public static final int XP_DEMON_KNIGHT = 1500;

	// ---- Niveau 17-20 : boss & divinités ----
	public static final int HP_DRAGON_WHELP = 5;
	public static final int ATT_DRAGON_WHELP = 5;
	public static final int DEF_DRAGON_WHELP = 3;
	public static final int XP_DRAGON_WHELP = 1800;

	public static final int HP_ANCIENT_DRAGON = 10;
	public static final int ATT_ANCIENT_DRAGON = 8;
	public static final int DEF_ANCIENT_DRAGON = 6;
	public static final int XP_ANCIENT_DRAGON = 2500;

	public static final int HP_ABYSSAL_HYDRA = 12;
	public static final int ATT_ABYSSAL_HYDRA = 9;
	public static final int DEF_ABYSSAL_HYDRA = 8;
	public static final int XP_ABYSSAL_HYDRA = 3200;

	public static final int HP_FALLEN_GOD = 15;
	public static final int ATT_FALLEN_GOD = 10;
	public static final int DEF_FALLEN_GOD = 10;
	public static final int XP_FALLEN_GOD = 4500;


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

	public static final Map<String, Integer> WEAPONS_COMMON = Map.of(
		"Rusty Dagger", 1,
		"Iron Sword", 2,
		"Wooden Mace", 1,
		"Stone Axe", 2
	);

	public static final Map<String, Integer> WEAPONS_RARE = Map.of(
		"Steel Axe", 3,
		"Elven Longbow", 4,
		"Iron Spear", 3
	);

	public static final Map<String, Integer> WEAPONS_EPIC = Map.of(
		"Rune Blade", 5,
		"Shadowfang", 6
	);

	public static final Map<String, Integer> WEAPONS_LEGENDARY = Map.of(
		"Excalibur", 10
	);
	
	/* -------------------- ARMORS (DEF bonus) -------------------- */

	public static final Map<String, Integer> ARMORS_COMMON = Map.of(
		"Leather Vest", 1,
		"Chainmail", 2,
		"Hide Armor", 1,
		"Paw Leather", 2
	);

	public static final Map<String, Integer> ARMORS_RARE = Map.of(
		"Iron Plate", 3,
		"Dwarven Chestguard", 4,
		"Steel Chain", 3
	);

	public static final Map<String, Integer> ARMORS_EPIC = Map.of(
		"Enchanted Breastplate", 5,
		"Obsidian Armor", 6
	);

	public static final Map<String, Integer> ARMORS_LEGENDARY = Map.of(
		"Dragon Scale Armor", 7
	);

	/* -------------------- HELMS (HP bonus) -------------------- */

	public static final Map<String, Integer> HELMS_COMMON = Map.of(
		"Leather Hood", 3,
		"Iron Helmet", 5,
		"Wooden Cap", 3,
		"Hide Helm", 4
	);

	public static final Map<String, Integer> HELMS_RARE = Map.of(
		"Steel Helm", 8,
		"Guardian Mask", 10,
		"Iron Crown", 9
	);

	public static final Map<String, Integer> HELMS_EPIC = Map.of(
		"Warlord Crown", 12,
		"Helm of Eternity", 15
	);

	public static final Map<String, Integer> HELMS_LEGENDARY = Map.of(
		"Godslayer Helm", 30
	);

	// ==================
	// SYMBOLS - HERO & ENEMIES
	// ==================

	public static final String SYMBOL_MAIN_HERO = BLUE + "@" + RESET;
	public static final String SYMBOL_ENEMY = RED + "!" + RESET;

	// ---- Tier 1 : faibles ----
	public static final String SYMBOL_ENEMY_RAT = RED + "r" + RESET;
	public static final String SYMBOL_ENEMY_SLIME = RED + "s" + RESET;
	public static final String SYMBOL_ENEMY_GOBLIN = RED + "g" + RESET;
	public static final String SYMBOL_ENEMY_BANDIT = RED + "b" + RESET;

	// ---- Tier 2 : intermédiaires ----
	public static final String SYMBOL_ENEMY_SKELETON = RED + "S" + RESET;
	public static final String SYMBOL_ENEMY_WOLF = RED + "w" + RESET;
	public static final String SYMBOL_ENEMY_CULTIST = RED + "c" + RESET;
	public static final String SYMBOL_ENEMY_ORC = RED + "O" + RESET;

	// ---- Tier 3 : avancés ----
	public static final String SYMBOL_ENEMY_DARK_MAGE = RED + "M" + RESET;
	public static final String SYMBOL_ENEMY_ELEMENTAL = RED + "E" + RESET;
	public static final String SYMBOL_ENEMY_TROLL = RED + "T" + RESET;
	public static final String SYMBOL_ENEMY_ASSASSIN = RED + "A" + RESET;

	// ---- Tier 4 : élite ----
	public static final String SYMBOL_ENEMY_LICH = RED + "L" + RESET;
	public static final String SYMBOL_ENEMY_MINOTAUR = RED + "m" + RESET;
	public static final String SYMBOL_ENEMY_VAMPIRE_LORD = RED + "V" + RESET;
	public static final String SYMBOL_ENEMY_DEMON_KNIGHT = RED + "K" + RESET;

	// ---- Tier 5 : boss & dieux ----
	public static final String SYMBOL_ENEMY_DRAGON_WHELP = RED + "D" + RESET;
	public static final String SYMBOL_ENEMY_ANCIENT_DRAGON = RED + "Ω" + RESET;
	public static final String SYMBOL_ENEMY_ABYSSAL_HYDRA = RED + "H" + RESET;
	public static final String SYMBOL_ENEMY_FALLEN_GOD = RED + "Φ" + RESET;



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
}
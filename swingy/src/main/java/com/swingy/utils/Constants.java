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

	public static final String[] LOOT_TYPE = {
		"armor",
		"helm",
		"weapon",
		"consommable"
	};

	public static final Map<String, Integer> WEAPONS_COMMON = Map.of(
		"Rusty Dagger ", 1,
		"Iron Sword ", 2,
		"Wooden Mace ", 1,
		"Stone Axe ", 2
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
		"Excalibur (+10.ATT)", 10
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
package com.arlania.world;

import com.arlania.model.Position;
import com.arlania.model.definitions.NPCDrops;
import com.arlania.world.content.transportation.TeleportHandler;
import com.arlania.world.entity.impl.player.Player;

public class TeleportInterface 
{
	private final static int CATEGORY_NAME_ID = 50508;
	
	public static void resetOldData() 
	{
		currentTab = 0;
		currentClickIndex = 0;
	}
	
	public enum Monsters
	{
		STARTER_AREA(50601, "@gre@Starter Area", "Make your way through", "Tiers 1-8 of this Area,", "to unlock access to", "fighting Bosses.", "@gre@EASY", 1677,
				new int[] {3144, 4126, 0}),
		MEDIUM_SLAYER(50602, "@gre@Medium Slayer Area", "This area contains all", "the npcs needed to complete", "Medium Slayer Tasks.", "", "@or2@MEDIUM", 500,
				new int[] {2588, 3534, 0}),
		HARD_SLAYER(50603, "@gre@Hard Slayer Area", "This area contains all", "the npcs needed to complete", "Hard Slayer Tasks.", "", "@red@HARD", 69,
				new int[] {2460, 3598, 0}),
		ELITE_SLAYER(50604, "@gre@Elite Slayer Area", "This area contains all", "the npcs needed to complete", "Elite Slayer Tasks.", "", "@red@HARD", 10039,
				new int[] {2460, 3663, 0});
		
		Monsters(int textId, String name, String description1, String description2, String description3,
				String description4, String description5, int npcId, int[] teleportCords) {
			this.textId = textId;
			this.name = name;
			this.description1 = description1;
			this.description2 = description2;
			this.description3 = description3;
			this.description4 = description4;
			this.description5 = description5;
			this.npcId = npcId;
			this.teleportCords = teleportCords;

		}

		private int textId;
		private String name;
		private String description1, description2, description3, description4, description5;
		private int npcId;
		private int[] teleportCords;
	}
	
	public enum Bosses 
	{
		SEADRA(50601, "@gre@Seadra", "@gre@500 HP", "Seadra: ", "@whi@80 Dragonair Kills Required", "", "@whi@TIER 9", 5666, new int[] {2973, 9492, 1},0),
		LUGIA(50602, "@gre@Lugia", "@gre@1500 HP", "Lugia: ", "@whi@100 Seadra Kills Required", 
				 "", "@whi@TIER 10", 32, new int[] {2465, 4447, 0},0),
		YVALTAL(50603, "@gre@Yvaltal", "@gre@2500 HP", "Yvaltal: ", "@whi@150 Lugia Kills Required", "", "@whi@TIER 11", 35, new int[] {2400, 3808, 0},0),
		TOXIN_MASTER(50604, "@gre@Toxin Master", "@gre@3500 HP", "Toxin Master: ", "@whi@200 Yvaltal Kills Required", "", 
				"@whi@TIER 12", 7845,
				new int[] {3105, 3168, 0},0),
		INFINITY(50605, "@gre@Infinity Guardian", "@gre@4500 HP", "Infinity Guardian: ", "@whi@300 Toxin Master Kills Required", "", "@whi@TIER 13",
				7563, new int[] {3421, 3231, 0},0),
		BAPHOMET(50606, "@gre@Baphomet", "@gre@6500 HP", "Baphomet: ", "@whi@350 Infinity Guardian Kills Required", "",
				"@whi@TIER 14", 2236, new int[] {2976, 3483, 0},0),
		DOOMSDAY(50607, "@gre@Doomsday", "@gre@7500 HP", "Doomsday: ", "@whi@400 Baphomet Kills Required", "", 
				"@whi@TIER 15", 6357, new int[] {2843, 3804, 0},0),
		DARTH_VADER(50608, "@gre@Darth Vader", "@gre@8500 HP", "Darth Vader: ", " @whi@450 Doomsday Kills Required", "", 
				"@whi@TIER 16", 8721, new int[] {3294, 9823, 0},0),
		SEPIROTH(50609, "@gre@Sepiroth", "@gre@9500 HP", "Sephiroth: ", "@whi@500 Darth Vader Kills Required", "", 
				"@whi@TIER 17", 9325, new int[] {1826, 5150, 0},0),
		HAUNTER(50610, "@gre@Haunter", "@gre@10500 HP", "Haunter: ", "@whi@550 Sepiroth Kills Required", "", "@whi@TIER 18", 3200, new int[] {3292, 3934, 0},0),
		ABADDON(50611, "@gre@Abaddon", "@gre@11500 HP", "Abaddon: ", "@whi@600 Haunter Kills Required", "", 
				"@whi@TIER 19", 6303, new int[] {3102, 3680, 0},0),
		CORP(50612, "@gre@Corp Beast", "@gre@12000 HP", "Corp Beast: ", "@whi@700 Abaddon Kills Req", "", "@whi@TIER 20", 8133, new int[] {3105, 4061, 0},0),
		CERBERUS_CAVE(50613, "@gre@Toxic Cerb", "@gre@12500 HP", "Toxic Cerb: ", "@whi@750 Corp Kills Required", "", "@whi@TIER 21", 
				1999, new int[] {2781, 3292, 0},0),
		SKOTIZO(50614, "@gre@Skotizo", "@gre@13500 HP", "Skotizo: ", "@whi@800 Toxic Cerb Kills Required", "", "@whi@TIER 22", 8754, 
				new int[] {3359, 9825, 0},0),
		BLASTOISE(50615, "@gre@Blastoise", "@gre@14500 HP", "Blastoise: ", "@whi@850 Skotizo Kills Required", "", "@whi@TIER 23", 4976,
				new int[] {2916, 3681, 0},0),
		VENASAUR(50616, "@gre@Venasaur", "@gre@15500 HP", "Venasaur: ", "@whi@900 Blastoise Kills Required", "", "@whi@TIER 24", 14, 
				new int[] {2569, 4967, 0},0),
		BLOOD_NEX(50617, "@gre@Blood Nex", "@gre@20500 HP", "Blood Nex: ", "@whi@950 Venasaur Kills Required", "", "@whi@TIER 25",
				13447, new int[] {2914, 5203, 0},0),
		MACHAMP(50618, "@gre@Machamp", "@gre@21500 HP", "Machamp", "@whi@1000 Blood Nex Kills Required", "", "@whi@TIER 26", 81, 
				new int[] {2656, 3307, 0},0),
		BLAZIKEN(50619, "@gre@Blaziken", "@gre@40000 HP", "Blaziken: ", "@whi@1100 Machamp Kills Required", "", "@whi@TIER 27", 88, 
				new int[] {3373, 2898, 0},0),
		SCYTHER(50620, "@gre@Scyther", "@gre@50000 HP", "Scyther: ", "@whi@1200 Blaziken Kills Required",  "", "@whi@TIER 28", 134, 
				new int[] {2273, 3744, 0},0),
		SHARKY(50621, "@gre@Sharky", "@gre@60000 HP", "Sharky: ", "@whi@1300 Scyther Kills Required", "", "@whi@TIER 29", 71, 
				new int[] {2144, 3744, 0},0),
		CURSED_SASUKE(50622, "@gre@Cursed Sasuke", "@gre@70000 HP", "Cursed Sasuke: ", "@whi@1500 Sharky Kills Required", 
				"", "@whi@TIER 30", 131, 
				new int[] {2209, 3808, 0},0),
		OROCHIMARU(50623, "@gre@Orochimaru", "@gre@80000 HP", "Orochimaru: ", "@whi@1600 Sasuke Kills Required", "", "@whi@TIER 31", 132, 
				new int[] {2463, 3871, 0},0),
		TELOS(50624, "@gre@Telos", "This Boss drops Telos Cult Gear,", "Customs Goodiebags, and 3 new weapons.", 
				"He will disable your", "prayer", "@red@HARD", 34, new int[] {2669, 3728, 0},0),
		DALEK(50625, "@gre@Dalek", "Dalek is a World Boss", "thats spawns once an hour", 
				"check to see if he is active", "using the ::events", "command.", 3334, new int[] {2786, 3855, 0},0),
		CHARIZARD(50626, "@gre@Charizard", "Charizard is a World Boss that will spawn", "every 2 hours.", "Check if this Event is Active", 
				"by using ::events", "@red@WORLD BOSS", 48, new int[] {3298, 4966, 0},0),
		GOKU(50627, "@gre@Goku", "Goku is a World Boss that will spawn", "every 3 hours.", "Check if this Event is Active", 
				"by using ::events", "@red@WORLD BOSS", 7851, new int[] {3104, 3232, 0},0),
		MADARA(50628, "@gre@Madara", "Madara is a World Boss that will spawn", "every 4 hours.", "Check if this Event is Active", 
				"by using ::events", "@red@WORLD BOSS", 30, new int[] {3233, 2918, 0},0);
		
		Bosses(int textId, String name, String description1, String description2, String description3,
				String description4, String description5, int npcId, int[] teleportCords, int KillReq) 
		{
			this.textId = textId;
			this.name = name;
			this.description1 = description1;
			this.description2 = description2;
			this.description3 = description3;
			this.description4 = description4;
			this.description5 = description5;
			this.npcId = npcId;
			this.teleportCords = teleportCords;

		}
		
		private int textId;
		private String name;
		private String description1, description2, description3, description4, description5;
		private int npcId;
		private int[] teleportCords;
	}

	public enum Raids 
	{
		HALO_RAIDS(50601, "@whi@Halo Raids", "This minigame is great", 
				"for competitive group PVMing.", "Face 16 Spartans in this action", "packed group raid.", "@gre@EASY", 239, new int[] {2530, 5842, 0}),
		DEOXYS_RAIDS(50602, "@whi@Deoxys Raids", "This minigame is great", 
				"for competitive group PVMing.", "Face 7 Legendary Pokemon in this action", "packed group raid.", "@or2@MEDIUM", 102, new int[] {2069, 3680, 0}),
		HYDRA_RAIDS(50603, "@whi@Hydra Raids", "This minigame is great", 
				"for competitive group PVMing.", "Face 16 Custom Hydras in this action", "packed transformative group raid.", "@red@HARD", 401, new int[] {2461, 4124, 0}),
		DBZ_RAIDS(50604, "@whi@Dragon Ball Raids", "This minigame is great", 
				"for competitive group PVMing.", "Face 22 DBZ Fighters in this action", "packed 4 Phase raid.", "@red@HARD", 613, new int[] {2267, 3871, 0});
		
		Raids(int textId, String name, String description1, String description2, String description3,
				String description4, String description5, int npcId, int[] teleportCords) 
		{
			this.textId = textId;
			this.name = name;
			this.description1 = description1;
			this.description2 = description2;
			this.description3 = description3;
			this.description4 = description4;
			this.description5 = description5;
			this.npcId = npcId;
			this.teleportCords = teleportCords;

		}

		private int textId;
		private String name;
		private String description1, description2, description3, description4, description5;
		private int npcId;
		private int[] teleportCords;
	}
		
	public enum Zones 
	{
		STARTER_ZONE(50601, "@gre@Starter Zone", "Earn Fused Quantum gear",
				"mboxes, lboxes, and", "Telos Stones for the", "boss.", "@gre@FREE", 36, new int[] {2679, 3714, 0}),
		AVENGERS_ZONE(50602, "@gre@Avengers Zone", "Defeat enough Avengers", "to fight the Evil", "Overlord Thanos!", 
				"", "@gre@FREE", 9202, new int[] {2899, 3617, 0});
		
		Zones(int textId, String name, String description1, String description2, String description3,
				String description4, String description5, int npcId, int[] teleportCords) 
		{
			this.textId = textId;
			this.name = name;
			this.description1 = description1;
			this.description2 = description2;
			this.description3 = description3;
			this.description4 = description4;
			this.description5 = description5;
			this.npcId = npcId;
			this.teleportCords = teleportCords;

		}

		private int textId;
		private String name;
		private String description1, description2, description3, description4, description5;
		private int npcId;
		private int[] teleportCords;
	}

	public enum Minigames 
	{

		FIGHT_CAVES(50601, "@gre@Fight Caves", "This minigame can", "reward you with Fire", "Cape, and upgrade.", "", "@or1@MEDIUM", 3032, new int[] {2445, 5177, 0}),
	
		DUEL_ARENA(50602, "@red@Duel Arena", 
				"This minigame is great", "for competitive PKers.", 
				"", "", "@gre@EASY", 659, new int[] {3303, 5076, 0}),
		POKEMON_BATTLES(50603, "@whi@Pokemon Battles", "This is a pet dueling", 
				"minigame you may play at ", "::home if both parties have", " pets summoned.", 
				"@gre@EASY", 88, new int[] {2941, 2817, 0}),
		MURDER_BALL(50604, "@whi@Murder Ball", "This minigame is great", 
				"for for earning new kinds of gear!", "You get MB points every kill", " and on the 10th kill the Game ends", 
				"@gre@EASY", 659, new int[] {3191, 9828, 0}),
		GUN_GAME(50605, "@whi@Gun Game", "This minigame is great", 
				"for competitive PKers", "First to 7 kills wins", "", "@gre@EASY", 4288, new int[] {2483, 9679, 0}),
		SPACE_WARS(50606, "@whi@Space Wars", "Pilot a TIE Fighter and fight", 
				"enemy X Wing NPCs and fellow ", "hostile TIE Pilots.", " On the 20th kill the Game ends", "@gre@EASY", 120, new int[] {3161, 4061, 0});
		
		Minigames(int textId, String name, String description1, String description2, String description3,
				String description4, String description5, int npcId, int[] teleportCords) 
		{
			this.textId = textId;
			this.name = name;
			this.description1 = description1;
			this.description2 = description2;
			this.description3 = description3;
			this.description4 = description4;
			this.description5 = description5;
			this.npcId = npcId;
			this.teleportCords = teleportCords;

		}

		private int textId;
		private String name;
		private String description1, description2, description3, description4, description5;
		private int npcId;
		private int[] teleportCords;
	}

	public enum Cities
	{
		VARROCK(50601, "@gre@Varrock", "Hourly Events can be", "in this location.", "", "", "@gre@FREE", 1, new int[] {3210, 3424, 0}),
		LUMBRIDGE(50602, "@gre@Lumbridge", "Quests and Hourly", "Events are used", "in this location.", "", "@gre@FREE", 1, new int[] {3222, 3218, 0}),
		FALADOR(50603, "@gre@Falador", "in this location", "Hourly Events occur.", "", "", "@gre@FREE", 1, new int[] {2964, 3378, 0}),
		CAMELOT(50604, "@gre@Camelot", "This location", "is used in", "clue scrolls.", "", "@gre@FREE", 1, new int[] {2757, 3477, 0}),
		ARDOUGNE(50605, "@gre@Ardougne", "This location", "is used in", "clue scrolls.", "", "@gre@FREE", 1, new int[] {2662, 3305, 0}),
		WATCHTOWER(50606, "@gre@Watch Tower", "This location", "is used in", "clue scrolls.", "", "@gre@FREE", 1, new int[] {2728, 3349, 0});

		Cities(int textId, String name, String description1, String description2, String description3,
				String description4, String description5, int npcId, int[] teleportCords) {
			this.textId = textId;
			this.name = name;
			this.description1 = description1;
			this.description2 = description2;
			this.description3 = description3;
			this.description4 = description4;
			this.description5 = description5;
			this.npcId = npcId;
			this.teleportCords = teleportCords;

		}

		private int textId;
		private String name;
		private String description1, description2, description3, description4, description5;
		private int npcId;
		private int[] teleportCords;
	}

	public static void handleTeleports(Player player) 
	{
		switch (currentTab) 
		{
		case 0:
			Bosses bossData = Bosses.values()[currentClickIndex];
			handleBossTeleport(player, bossData);
			break;
		case 1:
			Monsters monsterData = Monsters.values()[currentClickIndex];
			handleMonsterTeleport(player, monsterData);
			break;
		case 2:
			Raids raidsData = Raids.values()[currentClickIndex];
			handleRaidsTeleport(player, raidsData);
			break;
		case 3:
			Zones zonesData = Zones.values()[currentClickIndex];
			handleZonesTeleport(player, zonesData);
			break;
		case 4:
			Minigames minigameData = Minigames.values()[currentClickIndex];
			handleMinigameTeleport(player, minigameData);
			break;
		case 5:
			Cities cityData = Cities.values()[currentClickIndex];
			handleCityTeleport(player, cityData);
			break;
		}
	}

	public static void handleBossTeleport(Player player, Bosses bossData) 
	{
		TeleportHandler.teleportPlayer(player,
				new Position(bossData.teleportCords[0], bossData.teleportCords[1], bossData.teleportCords[2]),
				player.getSpellbook().getTeleportType());
	}

	public static void handleMonsterTeleport(Player player, Monsters monsterData) 
	{	
		TeleportHandler.teleportPlayer(player,
				new Position(monsterData.teleportCords[0], monsterData.teleportCords[1], monsterData.teleportCords[2]),
				player.getSpellbook().getTeleportType());
	}

	public static void handleRaidsTeleport(Player player, Raids raidsData) 
	{
		TeleportHandler.teleportPlayer(player,
				new Position(raidsData.teleportCords[0], raidsData.teleportCords[1], raidsData.teleportCords[2]),
				player.getSpellbook().getTeleportType());
	}

	public static void handleZonesTeleport(Player player, Zones zonesData) 
	{
		TeleportHandler.teleportPlayer(player,
				new Position(zonesData.teleportCords[0], zonesData.teleportCords[1], zonesData.teleportCords[2]),
				player.getSpellbook().getTeleportType());
	}

	public static void handleMinigameTeleport(Player player, Minigames minigameData) 
	{
		TeleportHandler.teleportPlayer(player, new Position(minigameData.teleportCords[0],
				minigameData.teleportCords[1], minigameData.teleportCords[2]), player.getSpellbook().getTeleportType());
	}

	public static void handleCityTeleport(Player player, Cities cityData) 
	{
		TeleportHandler.teleportPlayer(player,
				new Position(cityData.teleportCords[0], cityData.teleportCords[1], cityData.teleportCords[2]),
				player.getSpellbook().getTeleportType());
	}

	private static void clearData(Player player) 
	{
		for (int i = 50601; i < 50700; i++)
		{
			player.getPacketSender().sendString(i, "");
		}
	}
	
	public static void resetData()
	{
		currentTab = 0;
		currentClickIndex = -14935;
	}

	private static int currentTab = 0; // 0 = Boss, 1 = Monsters, 2 = Wildy, 3 = Skilling, 4 = Minigame, 5 = Cities

	public static boolean handleButton(Player player, int buttonID)
	{
		if (!(buttonID >= -14935 && buttonID <= -14836)) 
		{
			return false;
		}
		int index = -1;

		if (buttonID >= -14935) 
		{
			index = 14935 + buttonID;
		}
		if (currentTab == 0) 
		{
			if (index >= 0 && index < Bosses.values().length) 
			{
				Bosses bossData = Bosses.values()[index];
				currentClickIndex = index;
				sendBossData(player, bossData);
				sendDrops(player, bossData.npcId);
			}
		}
		if (currentTab == 1) 
		{
			if (index >= 0 && index < Bosses.values().length)
			{
				Monsters monsterData = Monsters.values()[index];
				currentClickIndex = index;
				sendMonsterData(player, monsterData);
				sendDrops(player, monsterData.npcId);
			}
		}
		if (currentTab == 2)
		{
			if (index >= 0 && index < Raids.values().length)
			{	
				Raids wildyData = Raids.values()[index];
				currentClickIndex = index;
				sendRaidsData(player, wildyData);
				sendDrops(player, wildyData.npcId);
			}
		}
		if (currentTab == 3) 
		{
			if (index >= 0 && index < Zones.values().length)
			{
				Zones skillingData = Zones.values()[index];
				currentClickIndex = index;
				sendZonesData(player, skillingData);
				sendDrops(player, skillingData.npcId);
			}
		}
		if (currentTab == 4) 
		{
			if (index >= 0 && index < Minigames.values().length) 
			{
				Minigames minigamesData = Minigames.values()[index];
				currentClickIndex = index;
				sendMinigameData(player, minigamesData);
				sendDrops(player, minigamesData.npcId);
			}
		}
		if (currentTab == 5)
		{
			if (index >= 0 && index < Cities.values().length)
			{
				Cities cityData = Cities.values()[index];
				currentClickIndex = index;
				sendCityData(player, cityData);
				sendDrops(player, cityData.npcId);
			}
		}
		return true;

	}

	public static int currentClickIndex = -14935;

	public static void sendBossData(Player player, Bosses data)
	{
		player.getPacketSender().sendString(51200, data.description1);
		player.getPacketSender().sendString(51201, data.description2);
		player.getPacketSender().sendString(51202, data.description3);
		player.getPacketSender().sendString(51203, data.description4);
		player.getPacketSender().sendString(51204, data.description5);
		player.getPacketSender().sendNpcOnInterface(50514, data.npcId);
	}

	public static void sendMonsterData(Player player, Monsters data) 
	{
		player.getPacketSender().sendString(51200, data.description1);
		player.getPacketSender().sendString(51201, data.description2);
		player.getPacketSender().sendString(51202, data.description3);
		player.getPacketSender().sendString(51203, data.description4);
		player.getPacketSender().sendString(51204, data.description5);
		player.getPacketSender().sendNpcOnInterface(50514, data.npcId);
	}

	public static void sendRaidsData(Player player, Raids data)
	{
		player.getPacketSender().sendString(51200, data.description1);
		player.getPacketSender().sendString(51201, data.description2);
		player.getPacketSender().sendString(51202, data.description3);
		player.getPacketSender().sendString(51203, data.description4);
		player.getPacketSender().sendString(51204, data.description5);
		player.getPacketSender().sendNpcOnInterface(50514, data.npcId);
	}

	public static void sendZonesData(Player player, Zones data)
	{
		player.getPacketSender().sendString(51200, data.description1);
		player.getPacketSender().sendString(51201, data.description2);
		player.getPacketSender().sendString(51202, data.description3);
		player.getPacketSender().sendString(51203, data.description4);
		player.getPacketSender().sendString(51204, data.description5);
		player.getPacketSender().sendNpcOnInterface(50514, data.npcId);
	}

	public static void sendMinigameData(Player player, Minigames data) 
	{
		player.getPacketSender().sendString(51200, data.description1);
		player.getPacketSender().sendString(51201, data.description2);
		player.getPacketSender().sendString(51202, data.description3);
		player.getPacketSender().sendString(51203, data.description4);
		player.getPacketSender().sendString(51204, data.description5);
		player.getPacketSender().sendNpcOnInterface(50514, data.npcId);
	}

	public static void sendCityData(Player player, Cities data) 
	{
		player.getPacketSender().sendString(51200, data.description1);
		player.getPacketSender().sendString(51201, data.description2);
		player.getPacketSender().sendString(51202, data.description3);
		player.getPacketSender().sendString(51203, data.description4);
		player.getPacketSender().sendString(51204, data.description5);
		player.getPacketSender().sendNpcOnInterface(50514, data.npcId);
	}

	public static void sendBossTab(Player player) 
	{
		player.getPacketSender().sendInterface(50500);
		currentTab = 0;
		clearData(player);
		resetOldData();
		player.getPacketSender().sendString(CATEGORY_NAME_ID, "@whi@Bosses");
		for (Bosses data : Bosses.values()) {
			player.getPacketSender().sendString(data.textId, data.name);
		}

	}

	public static void sendMonsterTab(Player player)
	{
		currentTab = 1;
		clearData(player);
		player.getPacketSender().sendString(CATEGORY_NAME_ID, "@whi@Monsters");
		for (Monsters data : Monsters.values()) {
			player.getPacketSender().sendString(data.textId, data.name);
		}
	}

	public static void sendRaidsTab(Player player) 
	{
		currentTab = 2;
		clearData(player);
		player.getPacketSender().sendString(CATEGORY_NAME_ID, "@whi@Raids");
		for (Raids data : Raids.values()) {
			player.getPacketSender().sendString(data.textId, data.name);
		}
	}

	public static void sendZonesTab(Player player) 
	{
		currentTab = 3;
		clearData(player);
		player.getPacketSender().sendString(CATEGORY_NAME_ID, "@whi@Zones");
		for (Zones data : Zones.values()) {
			player.getPacketSender().sendString(data.textId, data.name);
		}
	}

	public static void sendMinigamesTab(Player player)
	{
		currentTab = 4;
		clearData(player);
		player.getPacketSender().sendString(CATEGORY_NAME_ID, "@whi@Minigames");
		for (Minigames data : Minigames.values()) {
			player.getPacketSender().sendString(data.textId, data.name);
		}
	}

	public static void sendCitiesTab(Player player)
	{
		currentTab = 5;
		clearData(player);
		player.getPacketSender().sendString(CATEGORY_NAME_ID, "@whi@Cities");
		for (Cities data : Cities.values()) {
			player.getPacketSender().sendString(data.textId, data.name);
		}
	}

	public static void sendDrops(Player player, int npcId) 
	{
		player.getPacketSender().resetItemsOnInterface(51251, 100); // wtf u dont have this method? ig not? morytania bro.
		try {
			NPCDrops drops = NPCDrops.forId(npcId);
			if(drops == null) 
			{
				System.out.println("No drops found");
				return;
			}
			for (int i = 0; i < drops.getDropList().length; i++) {
				player.getPacketSender().sendItemOnInterface(51251, drops.getDropList()[i].getId(), i,
						drops.getDropList()[i].getItem().getAmount());
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}

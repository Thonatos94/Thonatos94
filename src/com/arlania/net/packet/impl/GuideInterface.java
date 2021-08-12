package com.arlania.net.packet.impl;

import com.arlania.world.entity.impl.player.Player;

public class GuideInterface {
	
	private static final String[] CATEGORIES = new String[]{ //
			"Rules", "Money Making", "Commands", "XP Rates", "Voting", "Donating", "Shops", "Teleporting", "Account Security", "Wilderness Guide", "Game Modes", "Ironman Guide", "Reward Tickets", "Titles", "Other Guides"};
	
	private static final String[] RULES = new String[]{ //
			"- It is highly recommended that all players", "take a detailed look at our rules.", "You can view these rules by typing ::rules", "Quick summary of the rules:", "1. No hateful or racist comments towards another player", "2. No form of advertising of another server", "3. No selling or trading accounts", "4. Scamming other players is not allowed", "5. No form of spamming is allowed", "6. Attempting to threaten another player is not allowed"};
	
	private static final String[] MONEY = new String[]{ //
			"@gre@Skilling:", "- Just south of the edgeville bank are thieving stalls", "where you can make some quick starter money", "- Collect resources from various skills", "and sell them to fellow players for profit", "", "@gre@Slayer: ", "- Killing Monsters during a Slayer Task will increase", "the drop rate of receiving a casket full of coins", "- Completing Slayer Tasks in the Wilderness will also", "increase the chance of obtaining wilderness reward tickets", "", "@gre@Voting:", "- By voting players can receive reward tickets which", "allow players at a chance of receiving many rewards!", "See the Reward Ticket section for more information on this.", "", "@gre@Bossing:", "- There are numerous bosses at Zaros that drop rare", "items. Rare items can be sold for a ton of gp!", "", "@gre@PvP:", "Killing players on Zaros will not only", "reward players with their opponents belongings but also", "with artifacts which can be traded in for Blood money!", "", "@gre@Events:", "- Join in on various server events/minigames to obtain", "coin rewards. Examples are wilderness warbands,", "Tournaments, and our many competitions.", "", "@gre@Donating:", "- You can get quite rich by choosing to support Zaros", "and donating. Donators get access to plenty of perks", "as well as exclusive money making methods."};
	
	private static final String[] EXPERIENCE = new String[]{ //
			"XP Rates at Zaros are currently x25 for all skills", "and x100 for combat skills.", "Rates for all skills, including combat, will drop to", "x10 once they�ve reached a milestone of 99.", "However, we�ve made it so that there are plenty of", "opportunities to receive bonus XP by training at the", "x2 Wilderness location, voting for 1.5x lamps and", "portables, double XP weekends, and brawler gloves.", "Classic mode players will be faced with x10 XP", "in all skills including combat.", "", "", "", "", "", "", "", "", "",};
	
	public static final String[] COMMANDS = new String[]{"@red@Teleports:", "::Home - Teleport to Home location", "::Train - Teleport to Rock Crabs", "::ffa - Teleport to FFA Lobby", "::Mb - Teleport to Mage Bank", "::Easts - Teleport to East Dragons (WILDY)", "::West - Teleport to Wests Dragons (WILDY)", "::Duel - Teleport to Duel Arena", "::Gamble - Teleport to Gamble Area",
			
			"@red@Links:", "::Forums - Opens up the Forums page", "::Vote - Opens up the Vote page", "::Store - Opens up the Donation page", //"::Thread (#) - Opens up the Thread id in the forums",
			"::Discord - Links to the Servers community discord", "::Rules - Links to the server rules and guidelines", "::News - Links to the latest server news and updates", "::Guides - Links to the Guide section on the forums",
			
			"@red@Misc:", "::Players - Displays the Player count", "::Changepassword (Password) - Changes your password", "::Setemail (Email) - Sets your Email", "::Empty - Empty your inventory", "::Skull - Makes you skulled", "::Claimvote - Claim voting Reward", "::Claimdonation - Claim a Donation", "::Help - Signals a Staff member for assistance", "::Save - Saves your account data",
			//"::Kc - Displays your total Npc and Boss Kill counts",
	};
	
	public static final String[] STAFFCOMMANDS = new String[]{"@red@Helper:", "::Kick (Name) - Force log out the target", "::Unjail (Name) - Un-jail the target", "::Unmute (Name) - Un-mute the target", "::Movehome (Name) - Teleport the target home", "::Mute (15-60min) (Name) - Mute the target", "::Jail (15-60min) (Name) - Jail the target", "::Teleto (Name) - Teleport to the target", "::Teletome (Name) - Teleport the target to me",
			
			"@red@Moderator:", "::Ban (Name) - Ban the target", "::Unban (Name) - Un-ban the target", "::Permmute (Name) - Perm-Mute the target", "::Permjail (Name) - Perm-Jail the target", "::Ipmute (Name) - Ip-Mute the target", "::Ipban (Name) - Ip-Ban the target", "::Checkinv (Name) - Checks the targets inventory", "::Totalcash - Displays the total cash ", "::Richest - Displays the richest online players", "::Cp (Name) - Displays the targets money pouch amount", "::Sameip (Name) - Shows online players with same ip as target", "::Samemac (Name) - Shows online players with same mac as target", "::Sameserial (Name) - Shows online players with same serial as target", "::Toggleinvis - Toggles invisibility",
			
			"@red@Administrator:", "::Macban (Name) - MacBan the target", "::Unmacban (Name) - Un-MacBan the target", "::Pcban (Name) - PcBan the target", "::Unpcban (Name) - Un-PcBan the target", "::Demote (Name) - Demote the target", "::Broadcast (Message) - Broadcast a message server-wide", "::Giverank (Id) (Name) - Set targets rank", "::Coords - Displays player Coordinates", "::Tele (X) (Y) - Teleports to (x,y) Coordinates", "::Eviltree - Spawns an Evil tree", "::Star - Spawns a Shooting star", "::Displaytitles - Displays all titles and their id", "::Givetitle (Id) (Name) - give the target a title",
			
			"@red@Manager:", "::Setexp (amount) - Set the server-wide experience", "::Bank - Opens up your bank", "::Npc (Id) - Spawns an npc", "::Pnpc (Id) - Transform into an Npc", "::Id (Item Name) - Searches for Item Id", "::Item (Id) (Amount) - Spawns x Amount of Item Id", "::Giveitem (Id) (Amount) (Name) - Spawns Item for target", "::Master - Maxes out all of your skills",
			//"::Sethp - Spawns Item for target",
			"::Gear - Opens a gear selection",};
	
	public static void open(Player player) {
		for(int j = 0; j < CATEGORIES.length; j++) {
			player.getPacketSender().sendString(62021 + j, "@whi@" + CATEGORIES[j]);
		}
		player.getPacketSender().sendInterface(62000);
	}
	
	public static void rules(Player player) {
		for(int j = 0; j < RULES.length; j++) {
			player.getPacketSender().sendString(62051 + j, "" + RULES[j]);
		}
		//player.getPacketSender().setScrollBar(62050, RULES.length * 20 + 6);
		player.getPacketSender().sendInterface(62000);
	}
	
	public static void money(Player player) {
		for(int j = 0; j < MONEY.length; j++) {
			player.getPacketSender().sendString(62051 + j, "" + MONEY[j]);
		}
		//player.getPacketSender().setScrollBar(62050, MONEY.length * 20 + 6);
		
		player.getPacketSender().sendInterface(62000);
	}
	
	public static void exp(Player player) {
		for(int j = 0; j < EXPERIENCE.length; j++) {
			player.getPacketSender().sendString(62051 + j, "" + EXPERIENCE[j]);
		}
		// p.getPacketSender().setScrollBar(62050, xp.length * 20 + 6);
		player.getPacketSender().sendInterface(62000);
		
	}
	
	public static void commands(Player player) {
		for(int j = 0; j < COMMANDS.length; j++) {
			player.getPacketSender().sendString(62051 + j, "" + COMMANDS[j]);
		}
		//player.getPacketSender().setScrollBar(62050, COMMANDS.length * 20 + 6);
		player.getPacketSender().sendInterface(62000);
	}
}

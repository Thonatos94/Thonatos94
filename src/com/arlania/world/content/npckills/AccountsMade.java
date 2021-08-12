package com.arlania.world.content.npckills;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import com.arlania.GameServer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AccountsMade {

	/** this is your starting variable for tracking **/
	private static int accountsMade = 0;
	
	/**
	 *another example
	 */
	
	private static int commandsUsed = 0;
	
	private static void setAccountsMade(int killed) {
		accountsMade = killed;
	}
	
	public static int getTotalAccountsMade() {
		return accountsMade;
	}
	
	private static void setCommandsUsed(int used) {
		commandsUsed = used;
	}
	
	public static int getCommandsUsed() {
		return commandsUsed;
	}
	
	public static void save() {
	
		// Create the path and file objects.
		Path path = Paths.get("./data/", "accounts.json");
		File file = path.toFile();
		file.getParentFile().setWritable(true);

		// Attempt to make the player save directory if it doesn't
		// exist.
		if (!file.getParentFile().exists()) {
			try {
				file.getParentFile().mkdirs();
			} catch (SecurityException e) {
				System.out.println("Unable to create directory for player kill data!");
			}
		}
		try (FileWriter writer = new FileWriter(file)) {

			Gson builder = new GsonBuilder().setPrettyPrinting().create();
			JsonObject object = new JsonObject();
			object.addProperty("accountsMade", accountsMade + 1);
			//object.addProperty("commandsUsed", commandsUsed + 1);
			//System.out.println(builder.toJson(npcs));
			writer.write(builder.toJson(object));
			writer.close();
		} catch (Exception e) {
			// An error happened while saving.
			GameServer.getLogger().log(Level.WARNING, "An error has occured while saving a npc kills file!", e);
		}
	}

	public static void getResult() {

		// Create the path and file objects.
		Path path = Paths.get("./data/", "accounts.json");
		File file = path.toFile();

		// If the file doesn't exist, we're logging in for the first
		// time and can skip all of this.
		if (!file.exists()) {
			System.out.println("File does not exist");
		}
		
		try (FileReader fileReader = new FileReader(file)) {
			JsonParser fileParser = new JsonParser();
			JsonObject reader = (JsonObject) fileParser.parse(fileReader);

			if (reader.has("accountsMade")) {
                setAccountsMade(reader.get("accountsMade").getAsInt());
            }

		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

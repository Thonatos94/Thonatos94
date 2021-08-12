package com.arlania.world.content.transportation;

import com.arlania.model.Item;
import com.arlania.model.Locations.Location;
import com.arlania.model.Position;
import com.arlania.model.container.impl.Equipment;
import com.arlania.model.definitions.ItemDefinition;
import com.arlania.world.content.dialogue.DialogueManager;
import com.arlania.world.entity.impl.player.Player;

public class JewelryTeleporting {
	
	public static void rub(Player player, int item) {
		if(player.getInterfaceId() > 0)
			player.getPacketSender().sendInterfaceRemoval();
		if(ItemDefinition.forId(item).getName().contains("glory")) {
			player.setDialogueActionId(48);
			DialogueManager.start(player, 88);
		} else if(ItemDefinition.forId(item).getName().contains("Combat bracelet")) {
			player.setDialogueActionId(89);
			DialogueManager.start(player, 89);
		}
		player.setInteractingItem(new Item(item));
	}
	
	public static void teleport(Player player, Position location) {
		player.setSelectedSkillingItem(player.getInteractingItem().getId());
		player.getPacketSender().sendInterfaceRemoval();
		
		if(!TeleportHandler.checkReqs(player, location)) {
			return;
		}
		if(!player.getTeleDelay().elapsed(4500) || player.getMovementQueue().isLockMovement())
			return;
		int pItem = player.getSelectedSkillingItem();
		if(!player.getInventory().contains(pItem) && !player.getEquipment().contains(pItem))
			return;
		boolean inventory = !player.getEquipment().contains(pItem);
		if(pItem >= 1706 && pItem <= 1712 || pItem >= 11118 && pItem <= 11124) {
			boolean bracelet = pItem >= 11118 && pItem <= 11124;
			int newItem = bracelet ? (pItem + 2) : (pItem - 2);
			if(inventory) {
				player.getInventory().delete(pItem, 1).add(newItem, 1).refreshItems();
			} else {
				player.getEquipment().delete(player.getEquipment().getItems()[bracelet ? Equipment.HANDS_SLOT : Equipment.AMULET_SLOT]);
				player.getEquipment().setItem(bracelet ? Equipment.HANDS_SLOT : Equipment.AMULET_SLOT, new Item(newItem, 1));
				player.getEquipment().refreshItems();
			}
			if(newItem == 1704 || newItem == 11126) {
				player.getPacketSender().sendMessage("Your " + (bracelet ? "bracelet" : "amulet") + " has run out of charges.");
			}
		}
		
		boolean wildy = player.getLocation() == Location.WILDERNESS;
		boolean glory = (player.getSelectedSkillingItem() == 49707 || player.getSelectedSkillingItem() == 1712 || player.getSelectedSkillingItem() == 1710 || player.getSelectedSkillingItem() == 1708 || player.getSelectedSkillingItem() == 1706 || player.getSelectedSkillingItem() == 1704);
		// player.sendMessage("wildy = " + wildy);
		// player.sendMessage("glory = " + glory);
		if(wildy && glory) {

		} else {
			player.setSelectedSkillingItem(-1);
		}
		player.getPacketSender().sendInterfaceRemoval();
		TeleportHandler.teleportPlayer(player, location, TeleportType.RING_TELE);
	}
}

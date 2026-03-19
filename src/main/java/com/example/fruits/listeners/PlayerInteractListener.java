package com.example.fruits.listeners;

import com.example.fruits.models.Fruit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        // Only handle right-click interactions (air or block)
        if (!event.getAction().name().contains("RIGHT_CLICK")) return;

        Player player = event.getPlayer();
        ItemStack item = event.getItem(); // Item in main hand (or off hand depending on event)

        // If the item is null or not a fruit, ignore
        if (item == null) return;
        String fruitId = Fruit.getFruitId(item);
        if (fruitId == null) return;

        // Cancel the interaction
        event.setCancelled(true);

        // Send a message to the player
        player.sendMessage("§eYou need to eat the fruit first to use its powers!");
    }
}

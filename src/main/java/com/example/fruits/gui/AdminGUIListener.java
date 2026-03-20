package com.example.fruits.gui;

import com.example.fruits.models.Fruit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class AdminGUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        // Using the correct public GUIHolder class
        if (!(event.getInventory().getHolder() instanceof AdminGUI.GUIHolder)) return;
        
        event.setCancelled(true);
        if (event.getCurrentItem() == null) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack clicked = event.getCurrentItem();
        
        if (event.getSlot() == 8) {
            // Spin: give random fruit
            player.performCommand("fruitadmin spin " + player.getName());
        } else {
            // Give specific fruit
            String fruitId = Fruit.getFruitId(clicked);
            if (fruitId != null) {
                player.performCommand("fruitadmin give " + player.getName() + " " + fruitId);
            }
        }
        player.closeInventory();
    }
}

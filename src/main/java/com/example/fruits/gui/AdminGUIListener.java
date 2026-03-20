package com.example.fruits.gui;

import com.example.fruits.models.Fruit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AdminGUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if(!(event.getInventory().getHolder() instanceof AdminGUI.GUIHolder)) return;
        
        event.setCancelled(true);
        if(event.getCurrentItem() == null) return;
        
        Player player = (Player) event.getWhoClicked();
        
        if(event.getSlot() == 8) {
            player.performCommand("fruitadmin spin " + player.getName());
        } else {
            String fruitId = Fruit.getFruitId(event.getCurrentItem());
            if(fruitId != null) {
                player.performCommand("fruitadmin give " + player.getName() + " " + fruitId);
            }
        }
        player.closeInventory();
    }
}

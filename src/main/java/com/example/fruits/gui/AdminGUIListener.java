package com.example.fruits.gui;

import com.example.fruits.models.Fruit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AdminGUIListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(!(e.getInventory().getHolder() instanceof AdminGUI.GUIHolder)) return;
        
        e.setCancelled(true);
        if(e.getCurrentItem() == null) return;
        
        Player p = (Player) e.getWhoClicked();
        
        if(e.getSlot() == 8) {
            p.performCommand("fruitadmin spin " + p.getName());
        } else {
            String fruitId = Fruit.getFruitId(e.getCurrentItem());
            if(fruitId != null) {
                p.performCommand("fruitadmin give " + p.getName() + " " + fruitId);
            }
        }
        p.closeInventory();
    }
}

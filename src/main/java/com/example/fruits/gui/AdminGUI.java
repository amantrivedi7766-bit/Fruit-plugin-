package com.example.fruits.gui;

import com.example.fruits.FruitsPlugin;
import com.example.fruits.models.Fruit;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class AdminGUI implements Listener {
    public static void open(Player player) {
        Inventory inv = Bukkit.createInventory(new Holder(), 9, "§8Fruit Admin Panel");
        int slot = 0;
        for (Fruit fruit : FruitsPlugin.getInstance().getFruitRegistry().getAllFruits()) {
            ItemStack item = fruit.createItem();
            ItemMeta meta = item.getItemMeta();
            meta.setLore(Arrays.asList("§7Click to give this fruit"));
            item.setItemMeta(meta);
            inv.setItem(slot++, item);
        }
        // Spin button
        ItemStack spin = new ItemStack(Material.COMPASS);
        ItemMeta spinMeta = spin.getItemMeta();
        spinMeta.setDisplayName("§a§lRandom Fruit");
        spin.setItemMeta(spinMeta);
        inv.setItem(8, spin);

        player.openInventory(inv);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof Holder)) return;
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

    private static class Holder implements InventoryHolder {
        @Override
        public Inventory getInventory() { return null; }
    }
}

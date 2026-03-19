package com.example.fruits.models;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;

public class PlayerFruitData {
    private final Player player;
    private Fruit fruit;
    private int usedAbilities; // 0..3

    public PlayerFruitData(Player player, Fruit fruit) {
        this.player = player;
        this.fruit = fruit;
        this.usedAbilities = 0;
    }

    public void incrementUsed() {
        usedAbilities++;
        if (usedAbilities >= 3) {
            // Give back fruit item
            player.getInventory().addItem(fruit.createItem());
            // Clear data
            fruit = null;
            usedAbilities = 0;
        }
    }

    public Fruit getFruit() { return fruit; }
    public int getUsedAbilities() { return usedAbilities; }
}

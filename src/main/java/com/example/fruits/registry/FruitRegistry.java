package com.example.fruits.registry;

import com.example.fruits.models.Ability;
import com.example.fruits.models.Fruit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import java.util.*;

public class FruitRegistry {
    private final Map<String, Fruit> fruits = new HashMap<>();

    public FruitRegistry() {
        registerFruits();
    }

    private void registerFruits() {
        // Apple
        fruits.put("apple", new Fruit("apple", "Apple", Material.APPLE, Arrays.asList(
            new Ability("Vine Grab", 20, p -> { /* vine grab logic */ }),
            new Ability("Apple Shrapnel", 15, p -> { /* shrapnel logic */ }),
            new Ability("Tree Slam", 30, p -> { /* tree slam logic */ })
        )));

        // Banana
        fruits.put("banana", new Fruit("banana", "Banana", Material.BANANA, Arrays.asList(
            new Ability("Banana Peel", 15, p -> { /* peel logic */ }),
            new Ability("Banana Throw", 20, p -> { /* throw logic */ }),
            new Ability("Monkey Frenzy", 30, p -> { /* frenzy logic */ })
        )));

        // Cherry – using Material.SWEET_BERRIES as placeholder
        fruits.put("cherry", new Fruit("cherry", "Cherry", Material.SWEET_BERRIES, Arrays.asList(
            new Ability("Cherry Bomb", 20, p -> { /* bomb logic */ }),
            new Ability("Cherry Blossom", 25, p -> { /* blossom logic */ }),
            new Ability("Cherry Beam", 30, p -> { /* beam logic */ })
        )));

        // Grape – using Material.GLOW_BERRIES
        fruits.put("grape", new Fruit("grape", "Grape", Material.GLOW_BERRIES, Arrays.asList(
            new Ability("Poison Splash", 15, p -> { /* poison splash */ }),
            new Ability("Grape Shot", 20, p -> { /* grape shot */ }),
            new Ability("Vine Whip", 25, p -> { /* vine whip */ })
        )));

        // Orange
        fruits.put("orange", new Fruit("orange", "Orange", Material.ORANGE, Arrays.asList(
            new Ability("Orange Slice", 15, p -> { /* slice logic */ }),
            new Ability("Acid Spray", 20, p -> { /* acid spray */ }),
            new Ability("Sun Burst", 30, p -> { /* sun burst */ })
        )));

        // Pineapple
        fruits.put("pineapple", new Fruit("pineapple", "Pineapple", Material.PUMPKIN_PIE, Arrays.asList(
            new Ability("Spiky Roll", 20, p -> { /* roll logic */ }),
            new Ability("Pineapple Launcher", 25, p -> { /* launcher logic */ }),
            new Ability("Tropical Storm", 35, p -> { /* storm logic */ })
        )));

        // Strawberry – using Material.SWEET_BERRIES (we need distinct items, so use different material)
        fruits.put("strawberry", new Fruit("strawberry", "Strawberry", Material.SWEET_BERRIES, Arrays.asList(
            new Ability("Berry Trap", 20, p -> { /* trap logic */ }),
            new Ability("Strawberry Rush", 25, p -> { /* rush logic */ }),
            new Ability("Berry Blast", 30, p -> { /* blast logic */ })
        )));

        // Watermelon
        fruits.put("watermelon", new Fruit("watermelon", "Watermelon", Material.MELON_SLICE, Arrays.asList(
            new Ability("Watermelon Slam", 20, p -> { /* slam logic */ }),
            new Ability("Seed Spray", 15, p -> { /* seed spray */ }),
            new Ability("Watermelon Cannon", 30, p -> { /* cannon logic */ })
        )));

        // Dragon Fruit – using Material.CHORUS_FRUIT
        fruits.put("dragonfruit", new Fruit("dragonfruit", "Dragon Fruit", Material.CHORUS_FRUIT, Arrays.asList(
            new Ability("Dragon Breath", 20, p -> { /* breath logic */ }),
            new Ability("Scales", 25, p -> { /* scales logic */ }),
            new Ability("Dragon Flight", 35, p -> { /* flight logic */ })
        )));

        // God Fruit – mix of all, with one‑shot ability
        fruits.put("godfruit", new Fruit("godfruit", "God Fruit", Material.ENCHANTED_GOLDEN_APPLE, Arrays.asList(
            new Ability("One Shot", 120, p -> {
                // requires 30 XP levels
                if (p.getLevel() < 30) {
                    p.sendMessage("§cYou need 30 XP levels to use One Shot!");
                    return;
                }
                // find target and kill if in diamond armor
                // ... implementation
                p.setLevel(p.getLevel() - 30);
            }),
            new Ability("God's Wrath", 60, p -> { /* lightning strikes */ }),
            new Ability("Divine Shield", 90, p -> { /* invulnerability */ })
        )));
    }

    public Fruit getFruit(String id) { return fruits.get(id); }
    public Collection<Fruit> getAllFruits() { return fruits.values(); }
}

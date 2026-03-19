package com.example.fruits.registry;

import com.example.fruits.models.Ability;
import com.example.fruits.models.Fruit;
import org.bukkit.Material;

import java.util.*;

public class FruitRegistry {
    private final Map<String, Fruit> fruits = new HashMap<>();

    public FruitRegistry() {
        registerFruits();
    }

    private void registerFruits() {
        // 1. Crimson Star (internal id: apple)
        fruits.put("apple", new Fruit("apple", "Crimson Star", Material.APPLE, Arrays.asList(
            new Ability("Vine Grab", 20, p -> p.sendMessage("§aCrimson Star Ability 1 used (placeholder)")),
            new Ability("Apple Shrapnel", 15, p -> p.sendMessage("§aCrimson Star Ability 2 used (placeholder)")),
            new Ability("Tree Slam", 30, p -> p.sendMessage("§aCrimson Star Ability 3 used (placeholder)"))
        )));

        // 2. Moon Crescent (internal id: banana)
        fruits.put("banana", new Fruit("banana", "Moon Crescent", Material.BANANA, Arrays.asList(
            new Ability("Banana Peel", 15, p -> p.sendMessage("§aMoon Crescent Ability 1 used")),
            new Ability("Banana Throw", 20, p -> p.sendMessage("§aMoon Crescent Ability 2 used")),
            new Ability("Monkey Frenzy", 30, p -> p.sendMessage("§aMoon Crescent Ability 3 used"))
        )));

        // 3. Blood Gem (internal id: cherry)
        fruits.put("cherry", new Fruit("cherry", "Blood Gem", Material.SWEET_BERRIES, Arrays.asList(
            new Ability("Cherry Bomb", 20, p -> p.sendMessage("§aBlood Gem Ability 1 used")),
            new Ability("Cherry Blossom", 25, p -> p.sendMessage("§aBlood Gem Ability 2 used")),
            new Ability("Cherry Beam", 30, p -> p.sendMessage("§aBlood Gem Ability 3 used"))
        )));

        // 4. Void Cluster (internal id: grape)
        fruits.put("grape", new Fruit("grape", "Void Cluster", Material.GLOW_BERRIES, Arrays.asList(
            new Ability("Poison Splash", 15, p -> p.sendMessage("§aVoid Cluster Ability 1 used")),
            new Ability("Grape Shot", 20, p -> p.sendMessage("§aVoid Cluster Ability 2 used")),
            new Ability("Vine Whip", 25, p -> p.sendMessage("§aVoid Cluster Ability 3 used"))
        )));

        // 5. Solar Orb (internal id: orange)
        fruits.put("orange", new Fruit("orange", "Solar Orb", Material.ORANGE, Arrays.asList(
            new Ability("Orange Slice", 15, p -> p.sendMessage("§aSolar Orb Ability 1 used")),
            new Ability("Acid Spray", 20, p -> p.sendMessage("§aSolar Orb Ability 2 used")),
            new Ability("Sun Burst", 30, p -> p.sendMessage("§aSolar Orb Ability 3 used"))
        )));

        // 6. Thorned Crown (internal id: pineapple)
        fruits.put("pineapple", new Fruit("pineapple", "Thorned Crown", Material.PUMPKIN_PIE, Arrays.asList(
            new Ability("Spiky Roll", 20, p -> p.sendMessage("§aThorned Crown Ability 1 used")),
            new Ability("Pineapple Launcher", 25, p -> p.sendMessage("§aThorned Crown Ability 2 used")),
            new Ability("Tropical Storm", 35, p -> p.sendMessage("§aThorned Crown Ability 3 used"))
        )));

        // 7. Ruby Heart (internal id: strawberry)
        fruits.put("strawberry", new Fruit("strawberry", "Ruby Heart", Material.SWEET_BERRIES, Arrays.asList(
            new Ability("Berry Trap", 20, p -> p.sendMessage("§aRuby Heart Ability 1 used")),
            new Ability("Strawberry Rush", 25, p -> p.sendMessage("§aRuby Heart Ability 2 used")),
            new Ability("Berry Blast", 30, p -> p.sendMessage("§aRuby Heart Ability 3 used"))
        )));

        // 8. Jade Melon (internal id: watermelon)
        fruits.put("watermelon", new Fruit("watermelon", "Jade Melon", Material.MELON_SLICE, Arrays.asList(
            new Ability("Watermelon Slam", 20, p -> p.sendMessage("§aJade Melon Ability 1 used")),
            new Ability("Seed Spray", 15, p -> p.sendMessage("§aJade Melon Ability 2 used")),
            new Ability("Watermelon Cannon", 30, p -> p.sendMessage("§aJade Melon Ability 3 used"))
        )));

        // 9. Drake's Tear (internal id: dragonfruit)
        fruits.put("dragonfruit", new Fruit("dragonfruit", "Drake's Tear", Material.CHORUS_FRUIT, Arrays.asList(
            new Ability("Dragon Breath", 20, p -> p.sendMessage("§aDrake's Tear Ability 1 used")),
            new Ability("Scales", 25, p -> p.sendMessage("§aDrake's Tear Ability 2 used")),
            new Ability("Dragon Flight", 35, p -> p.sendMessage("§aDrake's Tear Ability 3 used"))
        )));

        // 10. Primordial Essence (internal id: godfruit)
        fruits.put("godfruit", new Fruit("godfruit", "Primordial Essence", Material.ENCHANTED_GOLDEN_APPLE, Arrays.asList(
            new Ability("One Shot", 120, p -> p.sendMessage("§aPrimordial Essence Ability 1 used (one-shot placeholder)")),
            new Ability("God's Wrath", 60, p -> p.sendMessage("§aPrimordial Essence Ability 2 used")),
            new Ability("Divine Shield", 90, p -> p.sendMessage("§aPrimordial Essence Ability 3 used"))
        )));
    }

    public Fruit getFruit(String id) { return fruits.get(id); }
    public Collection<Fruit> getAllFruits() { return fruits.values(); }
}

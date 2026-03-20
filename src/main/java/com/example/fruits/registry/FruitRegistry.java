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
        // 1. Crimson Star - APPLE
        fruits.put("crimson_star", new Fruit("crimson_star", "Crimson Star", Material.APPLE, Arrays.asList(
            new Ability("Vine Grab", 20, p -> p.sendMessage("§aCrimson Star: Vine Grab used!")),
            new Ability("Crimson Shrapnel", 15, p -> p.sendMessage("§aCrimson Star: Crimson Shrapnel used!")),
            new Ability("Nature's Wrath", 30, p -> p.sendMessage("§aCrimson Star: Nature's Wrath used!"))
        )));

        // 2. Moon Crescent - GOLDEN_CARROT (NOT BANANA!)
        fruits.put("moon_crescent", new Fruit("moon_crescent", "Moon Crescent", Material.GOLDEN_CARROT, Arrays.asList(
            new Ability("Lunar Slip", 15, p -> p.sendMessage("§aMoon Crescent: Lunar Slip used!")),
            new Ability("Crescent Throw", 20, p -> p.sendMessage("§aMoon Crescent: Crescent Throw used!")),
            new Ability("Lunar Frenzy", 30, p -> p.sendMessage("§aMoon Crescent: Lunar Frenzy used!"))
        )));

        // 3. Blood Gem - SWEET_BERRIES
        fruits.put("blood_gem", new Fruit("blood_gem", "Blood Gem", Material.SWEET_BERRIES, Arrays.asList(
            new Ability("Blood Bomb", 20, p -> p.sendMessage("§aBlood Gem: Blood Bomb used!")),
            new Ability("Crimson Bloom", 25, p -> p.sendMessage("§aBlood Gem: Crimson Bloom used!")),
            new Ability("Sanguine Beam", 30, p -> p.sendMessage("§aBlood Gem: Sanguine Beam used!"))
        )));

        // 4. Void Cluster - GLOW_BERRIES
        fruits.put("void_cluster", new Fruit("void_cluster", "Void Cluster", Material.GLOW_BERRIES, Arrays.asList(
            new Ability("Void Splash", 15, p -> p.sendMessage("§aVoid Cluster: Void Splash used!")),
            new Ability("Cluster Shot", 20, p -> p.sendMessage("§aVoid Cluster: Cluster Shot used!")),
            new Ability("Abyssal Whip", 25, p -> p.sendMessage("§aVoid Cluster: Abyssal Whip used!"))
        )));

        // 5. Solar Orb - ORANGE_DYE (NOT ORANGE!)
        fruits.put("solar_orb", new Fruit("solar_orb", "Solar Orb", Material.ORANGE_DYE, Arrays.asList(
            new Ability("Solar Slice", 15, p -> p.sendMessage("§aSolar Orb: Solar Slice used!")),
            new Ability("Radiant Spray", 20, p -> p.sendMessage("§aSolar Orb: Radiant Spray used!")),
            new Ability("Supernova", 30, p -> p.sendMessage("§aSolar Orb: Supernova used!"))
        )));

        // 6. Thorned Crown - PUMPKIN_PIE
        fruits.put("thorned_crown", new Fruit("thorned_crown", "Thorned Crown", Material.PUMPKIN_PIE, Arrays.asList(
            new Ability("Thorned Roll", 20, p -> p.sendMessage("§aThorned Crown: Thorned Roll used!")),
            new Ability("Crown Launcher", 25, p -> p.sendMessage("§aThorned Crown: Crown Launcher used!")),
            new Ability("Nature's Storm", 35, p -> p.sendMessage("§aThorned Crown: Nature's Storm used!"))
        )));

        // 7. Ruby Heart - SWEET_BERRIES
        fruits.put("ruby_heart", new Fruit("ruby_heart", "Ruby Heart", Material.SWEET_BERRIES, Arrays.asList(
            new Ability("Ruby Trap", 20, p -> p.sendMessage("§aRuby Heart: Ruby Trap used!")),
            new Ability("Heart Rush", 25, p -> p.sendMessage("§aRuby Heart: Heart Rush used!")),
            new Ability("Crimson Blast", 30, p -> p.sendMessage("§aRuby Heart: Crimson Blast used!"))
        )));

        // 8. Jade Melon - MELON_SLICE
        fruits.put("jade_melon", new Fruit("jade_melon", "Jade Melon", Material.MELON_SLICE, Arrays.asList(
            new Ability("Jade Slam", 20, p -> p.sendMessage("§aJade Melon: Jade Slam used!")),
            new Ability("Seed Barrage", 15, p -> p.sendMessage("§aJade Melon: Seed Barrage used!")),
            new Ability("Melon Cannon", 30, p -> p.sendMessage("§aJade Melon: Melon Cannon used!"))
        )));

        // 9. Drake's Tear - CHORUS_FRUIT
        fruits.put("drakes_tear", new Fruit("drakes_tear", "Drake's Tear", Material.CHORUS_FRUIT, Arrays.asList(
            new Ability("Drake's Breath", 20, p -> p.sendMessage("§aDrake's Tear: Drake's Breath used!")),
            new Ability("Dragon Scales", 25, p -> p.sendMessage("§aDrake's Tear: Dragon Scales used!")),
            new Ability("Wyvern Flight", 35, p -> p.sendMessage("§aDrake's Tear: Wyvern Flight used!"))
        )));

        // 10. Primordial Essence - ENCHANTED_GOLDEN_APPLE
        fruits.put("primordial_essence", new Fruit("primordial_essence", "Primordial Essence", Material.ENCHANTED_GOLDEN_APPLE, Arrays.asList(
            new Ability("One Shot", 120, p -> {
                if (p.getLevel() < 30) {
                    p.sendMessage("§cYou need 30 XP levels for One Shot!");
                    return;
                }
                p.sendMessage("§aPrimordial Essence: One Shot used!");
                p.setLevel(p.getLevel() - 30);
            }),
            new Ability("God's Wrath", 60, p -> p.sendMessage("§aPrimordial Essence: God's Wrath used!")),
            new Ability("Divine Shield", 90, p -> p.sendMessage("§aPrimordial Essence: Divine Shield used!"))
        )));
    }

    public Fruit getFruit(String id) { 
        return fruits.get(id); 
    }
    
    public Collection<Fruit> getAllFruits() { 
        return fruits.values(); 
    }
}

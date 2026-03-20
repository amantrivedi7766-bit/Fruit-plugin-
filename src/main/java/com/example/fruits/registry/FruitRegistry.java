package com.example.fruits.registry;

import com.example.fruits.models.Ability;
import com.example.fruits.models.Fruit;
import org.bukkit.Material;
import java.util.*;

public class FruitRegistry {
    private final Map<String, Fruit> fruits = new HashMap<>();

    public FruitRegistry() {
        // 1. Crimson Star
        fruits.put("crimson_star", new Fruit("crimson_star", "Crimson Star", Material.APPLE,
            Arrays.asList(new Ability("Vine Grab", 20, p -> p.sendMessage("§aCrimson Star")))));
        
        // 2. Moon Crescent - GOLDEN_CARROT
        fruits.put("moon_crescent", new Fruit("moon_crescent", "Moon Crescent", Material.GOLDEN_CARROT,
            Arrays.asList(new Ability("Lunar Slip", 15, p -> p.sendMessage("§aMoon Crescent")))));
        
        // 3. Blood Gem
        fruits.put("blood_gem", new Fruit("blood_gem", "Blood Gem", Material.SWEET_BERRIES,
            Arrays.asList(new Ability("Blood Bomb", 20, p -> p.sendMessage("§aBlood Gem")))));
        
        // 4. Void Cluster
        fruits.put("void_cluster", new Fruit("void_cluster", "Void Cluster", Material.GLOW_BERRIES,
            Arrays.asList(new Ability("Void Splash", 15, p -> p.sendMessage("§aVoid Cluster")))));
        
        // 5. Solar Orb - ORANGE_DYE
        fruits.put("solar_orb", new Fruit("solar_orb", "Solar Orb", Material.ORANGE_DYE,
            Arrays.asList(new Ability("Solar Slice", 15, p -> p.sendMessage("§aSolar Orb")))));
        
        // 6. Thorned Crown
        fruits.put("thorned_crown", new Fruit("thorned_crown", "Thorned Crown", Material.PUMPKIN_PIE,
            Arrays.asList(new Ability("Thorned Roll", 20, p -> p.sendMessage("§aThorned Crown")))));
        
        // 7. Ruby Heart
        fruits.put("ruby_heart", new Fruit("ruby_heart", "Ruby Heart", Material.SWEET_BERRIES,
            Arrays.asList(new Ability("Ruby Trap", 20, p -> p.sendMessage("§aRuby Heart")))));
        
        // 8. Jade Melon
        fruits.put("jade_melon", new Fruit("jade_melon", "Jade Melon", Material.MELON_SLICE,
            Arrays.asList(new Ability("Jade Slam", 20, p -> p.sendMessage("§aJade Melon")))));
        
        // 9. Drake's Tear
        fruits.put("drakes_tear", new Fruit("drakes_tear", "Drake's Tear", Material.CHORUS_FRUIT,
            Arrays.asList(new Ability("Drake's Breath", 20, p -> p.sendMessage("§aDrake's Tear")))));
        
        // 10. Primordial Essence
        fruits.put("primordial_essence", new Fruit("primordial_essence", "Primordial Essence", 
            Material.ENCHANTED_GOLDEN_APPLE,
            Arrays.asList(new Ability("One Shot", 120, p -> {
                if(p.getLevel() >= 30) {
                    p.sendMessage("§aONE SHOT!");
                    p.setLevel(p.getLevel() - 30);
                } else {
                    p.sendMessage("§cNeed 30 levels!");
                }
            }))));
    }

    public Fruit getFruit(String id) { return fruits.get(id); }
    public Collection<Fruit> getAllFruits() { return fruits.values(); }
}

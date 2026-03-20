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
            List.of(new Ability("Vine Grab", 20, p->p.sendMessage("§aCrimson Star 1")))));
        
        // 2. Moon Crescent - GOLDEN_CARROT (NOT BANANA)
        fruits.put("moon_crescent", new Fruit("moon_crescent", "Moon Crescent", Material.GOLDEN_CARROT,
            List.of(new Ability("Lunar Slip", 15, p->p.sendMessage("§aMoon Crescent 1")))));
        
        // 3. Blood Gem
        fruits.put("blood_gem", new Fruit("blood_gem", "Blood Gem", Material.SWEET_BERRIES,
            List.of(new Ability("Blood Bomb", 20, p->p.sendMessage("§aBlood Gem 1")))));
        
        // 4. Void Cluster
        fruits.put("void_cluster", new Fruit("void_cluster", "Void Cluster", Material.GLOW_BERRIES,
            List.of(new Ability("Void Splash", 15, p->p.sendMessage("§aVoid Cluster 1")))));
        
        // 5. Solar Orb - ORANGE_DYE (NOT ORANGE)
        fruits.put("solar_orb", new Fruit("solar_orb", "Solar Orb", Material.ORANGE_DYE,
            List.of(new Ability("Solar Slice", 15, p->p.sendMessage("§aSolar Orb 1")))));
        
        // 6. Thorned Crown
        fruits.put("thorned_crown", new Fruit("thorned_crown", "Thorned Crown", Material.PUMPKIN_PIE,
            List.of(new Ability("Thorned Roll", 20, p->p.sendMessage("§aThorned Crown 1")))));
        
        // 7. Ruby Heart
        fruits.put("ruby_heart", new Fruit("ruby_heart", "Ruby Heart", Material.SWEET_BERRIES,
            List.of(new Ability("Ruby Trap", 20, p->p.sendMessage("§aRuby Heart 1")))));
        
        // 8. Jade Melon
        fruits.put("jade_melon", new Fruit("jade_melon", "Jade Melon", Material.MELON_SLICE,
            List.of(new Ability("Jade Slam", 20, p->p.sendMessage("§aJade Melon 1")))));
        
        // 9. Drake's Tear
        fruits.put("drakes_tear", new Fruit("drakes_tear", "Drake's Tear", Material.CHORUS_FRUIT,
            List.of(new Ability("Drake's Breath", 20, p->p.sendMessage("§aDrake's Tear 1")))));
        
        // 10. Primordial Essence
        fruits.put("primordial_essence", new Fruit("primordial_essence", "Primordial Essence", 
            Material.ENCHANTED_GOLDEN_APPLE,
            List.of(new Ability("One Shot", 120, p->{
                if(p.getLevel()>=30){
                    p.sendMessage("§aONE SHOT!");
                    p.setLevel(p.getLevel()-30);
                }
            }))));
    }

    public Fruit getFruit(String id) { return fruits.get(id); }
    public Collection<Fruit> getAllFruits() { return fruits.values(); }
}

package com.example.fruits;

import org.bukkit.plugin.java.JavaPlugin;

public class FruitsPlugin extends JavaPlugin {
    private static FruitsPlugin instance;
    private FruitRegistry fruitRegistry;
    private CooldownManager cooldownManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        fruitRegistry = new FruitRegistry();
        cooldownManager = new CooldownManager();

        // Register commands
        getCommand("fruit").setExecutor(new FruitCommand());
        getCommand("fruitadmin").setExecutor(new FruitAdminCommand());

        // Register listeners
        getServer().getPluginManager().registerEvents(new PlayerEatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);

        getLogger().info("FruitsPlugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("FruitsPlugin disabled.");
    }

    public static FruitsPlugin getInstance() { return instance; }
    public FruitRegistry getFruitRegistry() { return fruitRegistry; }
    public CooldownManager getCooldownManager() { return cooldownManager; }
}

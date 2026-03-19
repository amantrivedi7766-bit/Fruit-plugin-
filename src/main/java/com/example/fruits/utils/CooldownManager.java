package com.example.fruits.utils;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {
    private final Map<String, Long> cooldowns = new HashMap<>();

    public void setCooldown(Player player, String abilityKey) {
        cooldowns.put(player.getUniqueId() + "_" + abilityKey, System.currentTimeMillis());
    }

    public boolean checkCooldown(Player player, String abilityKey, int seconds) {
        String key = player.getUniqueId() + "_" + abilityKey;
        if (!cooldowns.containsKey(key)) return true;
        long diff = (System.currentTimeMillis() - cooldowns.get(key)) / 1000;
        return diff >= seconds;
    }

    public long getRemaining(Player player, String abilityKey) {
        String key = player.getUniqueId() + "_" + abilityKey;
        if (!cooldowns.containsKey(key)) return 0;
        long diff = (System.currentTimeMillis() - cooldowns.get(key)) / 1000;
        return Math.max(0, diff);
    }
}

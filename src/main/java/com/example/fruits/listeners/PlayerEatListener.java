package com.example.fruits.listeners;

import com.example.fruits.FruitsPlugin;
import com.example.fruits.models.Fruit;
import com.example.fruits.models.PlayerFruitData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerEatListener implements Listener {

    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem();
        String fruitId = Fruit.getFruitId(item);
        if (fruitId == null) return;

        event.setCancelled(true);
        Player player = event.getPlayer();
        Fruit fruit = FruitsPlugin.getInstance().getFruitRegistry().getFruit(fruitId);
        if (fruit == null) return;

        // Remove one fruit from hand
        item.setAmount(item.getAmount() - 1);

        // Set player's active fruit data
        PlayerFruitData data = new PlayerFruitData(player, fruit);
        FruitsPlugin.getInstance().getActivePlayers().put(player.getUniqueId(), data);

        String msg = FruitsPlugin.getInstance().getConfig().getString("messages.fruit_eaten")
                .replace("{fruit}", fruit.getDisplayName())
                .replace('&', '§');
        player.sendMessage(msg);
    }
}

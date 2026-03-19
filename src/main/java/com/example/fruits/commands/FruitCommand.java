package com.example.fruits.commands;

import com.example.fruits.FruitsPlugin;
import com.example.fruits.models.Ability;
import com.example.fruits.models.Fruit;
import com.example.fruits.models.PlayerFruitData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FruitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command.");
            return true;
        }
        Player player = (Player) sender;
        if (args.length < 2 || !args[0].equalsIgnoreCase("use")) {
            player.sendMessage("§cUsage: /fruit use <1|2|3>");
            return true;
        }

        PlayerFruitData data = FruitsPlugin.getInstance().getActivePlayers().get(player.getUniqueId());
        if (data == null || data.getFruit() == null) {
            player.sendMessage(FruitsPlugin.getInstance().getConfig().getString("messages.no_fruit").replace('&', '§'));
            return true;
        }

        int abilityIndex;
        try {
            abilityIndex = Integer.parseInt(args[1]) - 1;
        } catch (NumberFormatException e) {
            player.sendMessage(FruitsPlugin.getInstance().getConfig().getString("messages.invalid_ability").replace('&', '§'));
            return true;
        }

        Fruit fruit = data.getFruit();
        if (abilityIndex < 0 || abilityIndex >= fruit.getAbilities().size()) {
            player.sendMessage(FruitsPlugin.getInstance().getConfig().getString("messages.invalid_ability").replace('&', '§'));
            return true;
        }

        Ability ability = fruit.getAbilities().get(abilityIndex);
        // Check cooldown
        String cooldownKey = fruit.getId() + "_" + abilityIndex;
        if (!FruitsPlugin.getInstance().getCooldownManager().checkCooldown(player, cooldownKey, ability.getCooldown())) {
            long remaining = FruitsPlugin.getInstance().getCooldownManager().getRemaining(player, cooldownKey);
            String msg = FruitsPlugin.getInstance().getConfig().getString("messages.on_cooldown")
                    .replace("{seconds}", String.valueOf(remaining))
                    .replace('&', '§');
            player.sendMessage(msg);
            return true;
        }

        // Execute ability
        ability.getExecutor().execute(player);
        // Set cooldown
        FruitsPlugin.getInstance().getCooldownManager().setCooldown(player, cooldownKey);

        // Increment used abilities count
        data.incrementUsed();
        String abilityUsedMsg = FruitsPlugin.getInstance().getConfig().getString("messages.ability_used")
                .replace("{ability}", ability.getName())
                .replace("{used}", String.valueOf(data.getUsedAbilities()))
                .replace('&', '§');
        player.sendMessage(abilityUsedMsg);

        if (data.getFruit() == null) {
            player.sendMessage(FruitsPlugin.getInstance().getConfig().getString("messages.fruit_returned").replace('&', '§'));
        }

        return true;
    }
}

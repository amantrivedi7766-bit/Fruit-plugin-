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
            player.sendMessage("§cYou haven't eaten any fruit! Eat a fruit first.");
            return true;
        }

        int abilityIndex;
        try {
            abilityIndex = Integer.parseInt(args[1]) - 1;
        } catch (NumberFormatException e) {
            player.sendMessage("§cInvalid ability number. Use 1, 2, or 3.");
            return true;
        }

        Fruit fruit = data.getFruit();
        if (abilityIndex < 0 || abilityIndex >= fruit.getAbilities().size()) {
            player.sendMessage("§cInvalid ability number. Use 1, 2, or 3.");
            return true;
        }

        Ability ability = fruit.getAbilities().get(abilityIndex);
        // Check cooldown
        if (!FruitsPlugin.getInstance().getCooldownManager().checkCooldown(player, fruit.getId() + "_" + abilityIndex, ability.getCooldown())) {
            long remaining = FruitsPlugin.getInstance().getCooldownManager().getRemaining(player, fruit.getId() + "_" + abilityIndex);
            player.sendMessage("§cAbility on cooldown! " + remaining + " seconds left.");
            return true;
        }

        // Execute ability
        ability.getExecutor().execute(player);
        // Set cooldown
        FruitsPlugin.getInstance().getCooldownManager().setCooldown(player, fruit.getId() + "_" + abilityIndex);

        // Increment used abilities count
        data.incrementUsed();
        if (data.getFruit() == null) {
            player.sendMessage("§aYou have used all three abilities! Your fruit has been returned to your inventory.");
        }

        return true;
    }
}

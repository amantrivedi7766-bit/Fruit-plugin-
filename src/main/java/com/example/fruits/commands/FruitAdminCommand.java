package com.example.fruits.commands;

import com.example.fruits.FruitsPlugin;
import com.example.fruits.gui.AdminGUI;
import com.example.fruits.models.Fruit;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class FruitAdminCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("fruits.admin")) {
            sender.sendMessage("§cYou don't have permission.");
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage("§cUsage: /fruitadmin <give|spin|reload|setcooldown|gui>");
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "give":
                if (args.length < 3) {
                    sender.sendMessage("§cUsage: /fruitadmin give <player> <fruit> [amount]");
                    return true;
                }
                Player target = Bukkit.getPlayer(args[1]);
                if (target == null) {
                    sender.sendMessage("§cPlayer not found.");
                    return true;
                }
                Fruit fruit = FruitsPlugin.getInstance().getFruitRegistry().getFruit(args[2]);
                if (fruit == null) {
                    sender.sendMessage("§cFruit not found.");
                    return true;
                }
                int amount = 1;
                if (args.length > 3) {
                    try { amount = Integer.parseInt(args[3]); } catch (NumberFormatException ignored) {}
                }
                ItemStack item = fruit.createItem();
                item.setAmount(amount);
                target.getInventory().addItem(item);
                sender.sendMessage("§aGave " + amount + "x " + fruit.getDisplayName() + " to " + target.getName());
                break;

            case "spin":
                if (args.length < 2) {
                    sender.sendMessage("§cUsage: /fruitadmin spin <player>");
                    return true;
                }
                Player spinTarget = Bukkit.getPlayer(args[1]);
                if (spinTarget == null) {
                    sender.sendMessage("§cPlayer not found.");
                    return true;
                }
                Fruit[] fruits = FruitsPlugin.getInstance().getFruitRegistry().getAllFruits().toArray(new Fruit[0]);
                Fruit randomFruit = fruits[new Random().nextInt(fruits.length)];
                spinTarget.getInventory().addItem(randomFruit.createItem());
                sender.sendMessage("§aGave random fruit " + randomFruit.getDisplayName() + " to " + spinTarget.getName());
                break;

            case "reload":
                FruitsPlugin.getInstance().reloadConfig();
                sender.sendMessage("§aConfig reloaded.");
                break;

            case "setcooldown":
                sender.sendMessage("§cNot implemented yet.");
                break;

            case "gui":
                if (!(sender instanceof Player)) {
                    sender.sendMessage("§cOnly players can open GUI.");
                    return true;
                }
                AdminGUI.open((Player) sender);
                break;

            default:
                sender.sendMessage("§cUnknown subcommand.");
        }
        return true;
    }
}

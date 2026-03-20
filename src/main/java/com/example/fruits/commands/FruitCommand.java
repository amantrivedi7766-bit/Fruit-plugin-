package com.example.fruits.commands;

import com.example.fruits.FruitsPlugin;
import com.example.fruits.models.Ability;
import com.example.fruits.models.Fruit;
import com.example.fruits.models.PlayerFruitData;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FruitCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) return true;
        Player p = (Player) sender;
        
        if(args.length != 2 || !args[0].equalsIgnoreCase("use")) {
            p.sendMessage("§cUsage: /fruit use <1|2|3>");
            return true;
        }
        
        PlayerFruitData data = FruitsPlugin.getInstance().getActivePlayers().get(p.getUniqueId());
        if(data == null || data.getF

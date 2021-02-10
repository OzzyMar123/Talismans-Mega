package com.github.ozzymar.talismansmega.interfaces;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;

public interface ICommand extends TabExecutor {
    @Override
    boolean onCommand(CommandSender sender, Command cmd, String label, String[] args);

    @Override
    List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args);
}

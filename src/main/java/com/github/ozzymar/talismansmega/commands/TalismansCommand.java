package com.github.ozzymar.talismansmega.commands;

import com.github.ozzymar.marsapi.api.colors.ColorFormatter;
import com.github.ozzymar.talismansmega.TalismansMega;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TalismansCommand implements TabExecutor {

    private final TalismansMega talismansMega;

    public TalismansCommand(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("talismans.base")) {
                player.sendMessage(ColorFormatter.format(
                    talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.no-permission")));
                return true;
            }
            if (args.length == 0) {
                talismansMega.getConfigs().getLangConfig().getYaml().getStringList("messages.cmd-usage")
                    .forEach((s) -> player.sendMessage(ColorFormatter.format(s)));
            }
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("give")) {
                    if (!player.hasPermission("talismans.base.give")) {
                        player.sendMessage(ColorFormatter.format(
                            talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.no-permission")));
                        return true;
                    }
                    if (args.length < 3) {
                        player.sendMessage(ColorFormatter.format(
                            talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.more-args-needed")));
                        return true;
                    }
                    if (args.length > 3) {
                        player.sendMessage(
                            ColorFormatter.format(talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.less-args-needed")));
                        return true;
                    }
                    Player target = Bukkit.getPlayerExact(args[1]);
                    if (target == null) {
                        player.sendMessage(ColorFormatter.format(
                            talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.player-invalid")));
                        return true;
                    }
                    switch (args[2]) {
                        case "flash":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getFlashTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getFlashTalisman().getItem());
                            }
                            break;
                        case "health":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getHealthTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getHealthTalisman().getItem());
                            }
                            break;
                        case "warrior":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getWarriorTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getWarriorTalisman().getItem());
                            }
                            break;
                        case "ironskin":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getIronskinTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getIronskinTalisman().getItem());
                            }
                            break;
                        case "moltenskin":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getMoltenskinTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getMoltenskinTalisman().getItem());
                            }
                            break;
                        case "quickhands":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getQuickhandsTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getQuickhandsTalisman().getItem());
                            }
                            break;
                        case "waterbreath":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getWaterbreathTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getWaterbreathTalisman().getItem());
                            }
                            break;
                        case "workbench":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getWorkbenchTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getWorkbenchTalisman().getItem());
                            }
                            break;
                        case "enderchest":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getEnderTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getEnderTalisman().getItem());
                            }
                        case "*":
                            talismansMega.getUtilities().getTUtils().talismans()
                                .forEach(talisman -> target.getInventory().addItem(talisman));
                            break;
                        default:
                            player.sendMessage(ColorFormatter.format(
                                talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.talisman-invalid")));
                            break;
                    }
                }
                if (args[0].equalsIgnoreCase("shop")) {
                    if (!player.hasPermission("talismans.base.shop")) {
                        player.sendMessage(ColorFormatter.format(
                            talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.no-permission")));
                        return true;
                    }
                    if (args.length > 1) {
                        player.sendMessage(ColorFormatter.format(
                            talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.less-args-needed")));
                        return true;
                    }
                    player.openInventory(talismansMega.getMenus().getShopMenu().getInventory());
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    if (!player.hasPermission("talismans.base.reload")) {
                        player.sendMessage(
                            ColorFormatter.format(
                                talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.no-permission")));
                        return true;
                    }
                    if (args.length > 1) {
                        player.sendMessage(ColorFormatter.format(
                            talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.less-args-needed")));
                        return true;
                    }
                    talismansMega.getUtilities().getTUtils().reload(player);
                }
            }
        }
        if (sender instanceof ConsoleCommandSender) {
            if (args.length == 0) {
                talismansMega.getConfigs().getLangConfig().getYaml().getStringList("messages.cmd-usage")
                    .forEach((s) -> System.out.println(ColorFormatter.format(s)));
            }
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("give")) {
                    if (args.length < 3) {
                        System.out.println(ColorFormatter.format(
                            talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.more-args-needed")));
                        return true;
                    }
                    if (args.length > 3) {
                        System.out.println(
                            ColorFormatter.format(talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.less-args-needed")));
                        return true;
                    }
                    Player target = Bukkit.getPlayerExact(args[1]);
                    if (target == null) {
                        System.out.println(ColorFormatter.format(
                            talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.player-invalid")));
                        return true;
                    }
                    switch (args[2]) {
                        case "flash":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getFlashTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getFlashTalisman().getItem());
                            }
                            break;
                        case "health":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getHealthTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getHealthTalisman().getItem());
                            }
                            break;
                        case "warrior":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getWarriorTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getWarriorTalisman().getItem());
                            }
                            break;
                        case "ironskin":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getIronskinTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getIronskinTalisman().getItem());
                            }
                            break;
                        case "moltenskin":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getMoltenskinTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getMoltenskinTalisman().getItem());
                            }
                            break;
                        case "quickhands":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getQuickhandsTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getQuickhandsTalisman().getItem());
                            }
                            break;
                        case "waterbreath":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getWaterbreathTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getWaterbreathTalisman().getItem());
                            }
                            break;
                        case "workbench":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getWorkbenchTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getWorkbenchTalisman().getItem());
                            }
                            break;
                        case "enderchest":
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(),
                                    talismansMega.getTalismans().getEnderTalisman().getItem());
                            } else {
                                target.getInventory().addItem(talismansMega.getTalismans().getEnderTalisman().getItem());
                            }
                        case "*":
                            talismansMega.getUtilities().getTUtils().talismans()
                                .forEach(talisman -> target.getInventory().addItem(talisman));
                            break;
                        default:
                            System.out.println(ColorFormatter.format(
                                talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.talisman-invalid")));
                            break;
                    }
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    if (args.length > 1) {
                        System.out.println(ColorFormatter.format(
                            talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.less-args-needed")));
                        return true;
                    }
                    talismansMega.getUtilities().getTUtils().reload();
                }
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> list = new ArrayList<>();
            list.add("give");
            list.add("shop");
            list.add("reload");
            List<String> result = new ArrayList<>();
            for (String a : list) {
                if (a.toLowerCase().startsWith(args[0].toLowerCase()))
                    result.add(a);
            }
            return result;
        }
        if (args[0].equalsIgnoreCase("give")) {
            if (args.length == 2) {
                List<String> list = new ArrayList<>();
                Bukkit.getOnlinePlayers()
                    .stream()
                    .map(player -> (Player) player)
                    .forEach(player -> list.add(player.getName()));
                List<String> result = new ArrayList<>();
                for (String a : list) {
                    if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                        result.add(a);
                }
                return result;
            }
            if (args.length == 3) {
                List<String> list = new ArrayList<>();
                list.add("flash");
                list.add("health");
                list.add("warrior");
                list.add("ironskin");
                list.add("moltenskin");
                list.add("quickhands");
                list.add("waterbreath");
                list.add("workbench");
                list.add("enderchest");
                list.add("*");
                List<String> result = new ArrayList<>();
                for (String a : list) {
                    if (a.toLowerCase().startsWith(args[2].toLowerCase()))
                        result.add(a);
                }
                return result;
            }
            List<String> override = new ArrayList<>();
            override.add(" ");
            return override;
        }
        return Collections.emptyList();
    }
}
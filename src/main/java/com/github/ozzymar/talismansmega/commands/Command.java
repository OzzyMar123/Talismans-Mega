package com.github.ozzymar.talismansmega.commands;

import com.github.ozzymar.talismansmega.config.LangConfiguration;
import com.github.ozzymar.talismansmega.items.models.*;
import com.github.ozzymar.talismansmega.ui.ShopMenu;
import com.github.ozzymar.talismansmega.utils.TUtils;
import com.github.ozzymar.talismansmega.utils.string.StringUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Command implements ICommand {

    //CMD    : talismans [give] [player] [talisman]
    //ARGS   :   null       0       1        2
    //LENGTH :    0        1        2       3

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        if (!player.hasPermission("talismans.base")) {
            player.sendMessage(StringUtil.format(LangConfiguration.getYaml().getString("messages.no-permission")));
            return true;
        }
        if (args.length == 0) {
            LangConfiguration.getYaml().getStringList("messages.cmd-usage").forEach((s) -> player.sendMessage(StringUtil.format(s)));
        }
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("give")) {
                if (!player.hasPermission("talismans.base.give")) {
                    player.sendMessage(StringUtil.format(LangConfiguration.getYaml().getString("messages.no-permission")));
                    return true;
                }
                if (args.length < 3) {
                    player.sendMessage(StringUtil.format(LangConfiguration.getYaml().getString("messages.more-args-needed")));
                    return true;
                }
                if (args.length > 3) {
                    player.sendMessage(StringUtil.format(LangConfiguration.getYaml().getString("messages.less-args-needed")));
                    return true;
                }
                Player target = Bukkit.getPlayerExact(args[1]);
                if (target == null) {
                    player.sendMessage(StringUtil.format(LangConfiguration.getYaml().getString("messages.player-invalid")));
                    return true;
                }
                switch (args[2]) {
                    case "flash":
                        if (target.getInventory().firstEmpty() == -1) {
                            target.getWorld().dropItemNaturally(target.getLocation(), new FLASH_TALISMAN().getItem());
                        } else {
                            target.getInventory().addItem(new FLASH_TALISMAN().getItem());
                        }
                        break;
                    case "health":
                        if (target.getInventory().firstEmpty() == -1) {
                            target.getWorld().dropItemNaturally(target.getLocation(), new HEALTH_TALISMAN().getItem());
                        } else {
                            target.getInventory().addItem(new HEALTH_TALISMAN().getItem());
                        }
                        break;
                    case "warrior":
                        if (target.getInventory().firstEmpty() == -1) {
                            target.getWorld().dropItemNaturally(target.getLocation(), new WARRIOR_TALISMAN().getItem());
                        } else {
                            target.getInventory().addItem(new WARRIOR_TALISMAN().getItem());
                        }
                        break;
                    case "ironskin":
                        if (target.getInventory().firstEmpty() == -1) {
                            target.getWorld().dropItemNaturally(target.getLocation(), new IRONSKIN_TALISMAN().getItem());
                        } else {
                            target.getInventory().addItem(new IRONSKIN_TALISMAN().getItem());
                        }
                        break;
                    case "moltenskin":
                        if (target.getInventory().firstEmpty() == -1) {
                            target.getWorld().dropItemNaturally(target.getLocation(), new MOLTENSKIN_TALISMAN().getItem());
                        } else {
                            target.getInventory().addItem(new MOLTENSKIN_TALISMAN().getItem());
                        }
                        break;
                    case "quickhands":
                        if (target.getInventory().firstEmpty() == -1) {
                            target.getWorld().dropItemNaturally(target.getLocation(), new QUICKHANDS_TALISMAN().getItem());
                        } else {
                            target.getInventory().addItem(new QUICKHANDS_TALISMAN().getItem());
                        }
                        break;
                    case "workbench":
                        if (target.getInventory().firstEmpty() == -1) {
                            target.getWorld().dropItemNaturally(target.getLocation(), new WORKBENCH_TALISMAN().getItem());
                        } else {
                            target.getInventory().addItem(new WORKBENCH_TALISMAN().getItem());
                        }
                        break;
                    case "enderchest":
                        if (target.getInventory().firstEmpty() == -1) {
                            target.getWorld().dropItemNaturally(target.getLocation(), new ENDER_TALISMAN().getItem());
                        } else {
                            target.getInventory().addItem(new ENDER_TALISMAN().getItem());
                        }
                    case "*":
                        TUtils.talismans()
                            .forEach(talisman -> target.getInventory().addItem(talisman));
                        break;
                }
            }
            if (args[0].equalsIgnoreCase("shop")) {
                if (!player.hasPermission("talismans.base.shop")) {
                    player.sendMessage(StringUtil.format(LangConfiguration.getYaml().getString("messages.no-permission")));
                    return true;
                }
                if (args.length > 1) {
                    player.sendMessage(StringUtil.format(LangConfiguration.getYaml().getString("messages.less-args-needed")));
                    return true;
                }
                player.openInventory(ShopMenu.getInventory());
            }

            if (args[0].equalsIgnoreCase("reload")) {
                if (!player.hasPermission("talismans.base.reload")) {
                    player.sendMessage(StringUtil.format(LangConfiguration.getYaml().getString("messages.no-permission")));
                    return true;
                }
                if (args.length > 1) {
                    player.sendMessage(StringUtil.format(LangConfiguration.getYaml().getString("messages.less-args-needed")));
                    return true;
                }
                TUtils.reload(player);
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
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
        return null;
    }
}

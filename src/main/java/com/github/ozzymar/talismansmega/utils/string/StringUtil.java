package com.github.ozzymar.talismansmega.utils.string;

import org.bukkit.ChatColor;

public class StringUtil {
    public static String format(String str) {
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}

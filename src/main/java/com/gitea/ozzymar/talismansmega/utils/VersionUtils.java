package com.gitea.ozzymar.talismansmega.utils;

import org.bukkit.Bukkit;

public class VersionUtils {
    public static boolean isAbove1_8() {
        return !Bukkit.getVersion().contains("1.8") || !Bukkit.getVersion().contains("1.7");
    }
}

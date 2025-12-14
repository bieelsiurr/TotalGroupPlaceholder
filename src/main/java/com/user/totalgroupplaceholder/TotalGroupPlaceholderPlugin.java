package com.user.totalgroupplaceholder;

import com.user.totalgroupplaceholder.command.TotalGroupCommand;
import com.user.totalgroupplaceholder.expansion.TotalGroupExpansion;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class TotalGroupPlaceholderPlugin extends JavaPlugin {

    private static final String TOTALGROUP_COMMAND = "totalgroup";

    @Override
    public void onEnable() {
        getLogger().info("Enabling TotalGroupPlaceholder...");

        if (getCommand(TOTALGROUP_COMMAND) != null) {
            TotalGroupCommand cmd = new TotalGroupCommand();

            getCommand(TOTALGROUP_COMMAND).setExecutor(cmd);
            getCommand(TOTALGROUP_COMMAND).setTabCompleter(cmd);
        }

        Plugin placeholderApi = Bukkit.getPluginManager().getPlugin("PlaceholderAPI");
        if (placeholderApi != null) {
            new TotalGroupExpansion().register();
            getLogger().info("PlaceholderAPI expansion registered successfully.");
        } else {
            getLogger().warning("PlaceholderAPI is not installed, disabling plugin...");
            getServer().getPluginManager().disablePlugin(this);

            return;
        }

        getLogger().info("TotalGroupPlaceholder enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TotalGroupPlaceholder disabled.");
    }

}

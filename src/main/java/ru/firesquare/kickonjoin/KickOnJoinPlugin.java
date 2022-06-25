package ru.firesquare.kickonjoin;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import redempt.redlib.config.ConfigManager;
import ru.firesquare.kickonjoin.config.Config;
import ru.firesquare.kickonjoin.listeners.PlayerJoinListener;

public class KickOnJoinPlugin extends JavaPlugin {
    @Override
    public void onEnable () {
        // Load config
        ConfigManager.create(this).target(Config.class).saveDefaults().load();

        // Load messages
        reloadFileConfig();

        // Set static instance
        KickOnJoinPlugin.instance = this;
        
        // Register listeners
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

        // Setup Vault
        setupPermissions();
    }

    public void reloadFileConfig() {
        ConfigManager.create(this).target(Config.class).saveDefaults().reload();
    }

    private static Permission perms = null;

    private void setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        assert rsp != null;
        perms = rsp.getProvider();
    }

    public Permission getPermissions() {
        return perms;
    }

    private static KickOnJoinPlugin instance;

    public static KickOnJoinPlugin getInstance () {
        return KickOnJoinPlugin.instance;
    }
}
package ru.firesquare.kickonjoin.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ru.firesquare.kickonjoin.KickOnJoinPlugin;
import ru.firesquare.kickonjoin.utils.ChatUtils;
import ru.firesquare.kickonjoin.config.Config;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin (PlayerJoinEvent e) {
        if (!KickOnJoinPlugin.getInstance().getPermissions().has(e.getPlayer(), "group."+Config.role)) {
            e.getPlayer().kickPlayer(ChatUtils.translate(Config.message.replace("{role}", Config.role)));
        }
    }
}

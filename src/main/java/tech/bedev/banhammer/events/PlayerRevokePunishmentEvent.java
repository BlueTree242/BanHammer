package tech.bedev.banhammer.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import tech.bedev.banhammer.BanHammer;
import tech.bedev.banhammer.Punishment;

public class PlayerRevokePunishmentEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private String message;
    private final Punishment punishment;
    private final BanHammer core;
    private final Plugin BansPlugin;

    public PlayerRevokePunishmentEvent(Punishment punishment, Plugin pl, BanHammer bh) {
        this.punishment = punishment;
        this.BansPlugin = pl;
        core = bh;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Punishment getPunishment() {
        return punishment;
    }

    public Plugin getPunishmentsPlugin() {
        return BansPlugin;
    }
}

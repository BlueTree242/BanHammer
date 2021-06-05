package tech.bedev.banhammer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import tech.bedev.banhammer.events.PlayerPunishmentEvent;
import tech.bedev.banhammer.events.PlayerRevokePunishmentEvent;

public class BanHammer extends JavaPlugin {
    private BanPlugin banPlugin = null;
    private Plugin punishmentPluginMainClass = null;
    boolean canRegister = true;

    public void onEnable() {
        Bukkit.getScheduler().runTask(this, () -> {
          if (punishmentPluginMainClass != null) {
              getLogger().info(ChatColor.GREEN + "Plugin " + ChatColor.RED + punishmentPluginMainClass.getName() + " v." + punishmentPluginMainClass.getDescription().getVersion() + ChatColor.GREEN + " is the ban manager.");
            } else {
              getLogger().info(ChatColor.GREEN + "No plugins registered.");
            }
          canRegister = false;
        });

    }
    public void onDisable() {

    }

    public void setPunishmentsPlugin(BanPlugin plugin, Plugin mainClass) {
        if (!canRegister) {
            throw new IllegalStateException("Registering is disabled");
        }
        if (mainClass == this) {
            throw new IllegalArgumentException("Main class cannot be BanHammer's Main Class!");
        }

        this.banPlugin = plugin;
        this.punishmentPluginMainClass = mainClass;
    }

    public String getBanPluginName() {
        return punishmentPluginMainClass.getName();
    }
    public BanPlugin getBanPlugin() {
        return banPlugin;
    }

    public void firePunishmentEvent(Plugin plugin, Punishment punishment) {
        if (plugin == punishmentPluginMainClass) {
            Bukkit.getPluginManager().callEvent(new PlayerPunishmentEvent(punishment, plugin, this));
        }
    }
    public void fireRevokePunishmentEvent(Plugin plugin, Punishment punishment) {
        if (plugin == punishmentPluginMainClass) {
            Bukkit.getPluginManager().callEvent(new PlayerRevokePunishmentEvent(punishment, plugin, this));
        }
    }
}

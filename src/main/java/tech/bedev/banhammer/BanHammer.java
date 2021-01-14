package tech.bedev.banhammer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import tech.bedev.banhammer.events.PlayerPunishmentEvent;
import tech.bedev.banhammer.events.PlayerRevokePunishmentEvent;

public class BanHammer extends JavaPlugin {
    private BanPlugin banPlugin = null;
    private Plugin banPluginMainClass = null;
    boolean canRegister = true;

    public void onEnable() {
        Bukkit.getScheduler().runTask(this, () -> {
          if (banPluginMainClass != null) {
              getLogger().info(ChatColor.GREEN + "Plugin " + ChatColor.RED + banPluginMainClass.getName() + " v." + banPluginMainClass.getDescription().getVersion() + ChatColor.GREEN + " is the ban manager.");
            } else {
              getLogger().info(ChatColor.GREEN + "No plugins registered.");
            }
          canRegister = false;
        });

    }
    public void onDisable() {

    }

    public void setBanPlugin(BanPlugin plugin, Plugin mainClass) {
        if (!canRegister) {
            throw new IllegalStateException("Registering is disabled");
        }
        if (mainClass == this) {
            throw new IllegalArgumentException("Main class cannot be BanHammer's Main Class!");
        }

        this.banPlugin = plugin;
        this.banPluginMainClass = mainClass;
    }

    public String getBanPluginName() {
        return banPluginMainClass.getName();
    }
    public BanPlugin getBanPlugin() {
        return banPlugin;
    }

    public void firePunishmentEvent(Plugin plugin, Punishment punishment) {
        if (plugin == banPluginMainClass) {
            Bukkit.getPluginManager().callEvent(new PlayerPunishmentEvent(punishment, plugin, this));
        }
    }
    public void fireRevokePunishmentEvent(Plugin plugin, Punishment punishment) {
        if (plugin == banPluginMainClass) {
            Bukkit.getPluginManager().callEvent(new PlayerRevokePunishmentEvent(punishment, plugin, this));
        }
    }
}

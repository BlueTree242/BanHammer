package tech.bedev.banhammer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

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
        if (!canRegister) return;
        if (mainClass == this) return;
        this.banPlugin = plugin;
        this.banPluginMainClass = mainClass;
    }

    public String getBanPluginName() {
        return banPluginMainClass.getName();
    }
    public BanPlugin getBanPlugin() {
        return banPlugin;
    }
}

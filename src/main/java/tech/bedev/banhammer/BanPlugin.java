package tech.bedev.banhammer;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public interface BanPlugin {

    boolean isPlayerPunished(Player p);
    boolean isPlayerPunished(UUID uuid);
    boolean isPlayerPunished(String name);

    List<Punishment> getPunishments(Player p);
    List<Punishment> getPunishments(UUID uuid);
    List<Punishment> getPunishments(String name);

    Punishment createPunishment(PunishmentType type, String playerName, String OperatorName, Long start, Long end, Long duration, boolean overrideOldOne, boolean isSilent);
}

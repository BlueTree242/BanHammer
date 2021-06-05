package tech.bedev.banhammer;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface BanPlugin {

    CompletableFuture<Boolean> isPlayerPunished(Player p);
    CompletableFuture<Boolean> isPlayerPunished(UUID uuid);
    CompletableFuture<Boolean> isPlayerPunished(String name);

    CompletableFuture<List<Punishment>> getPunishments(Player p);
    CompletableFuture<List<Punishment>> getPunishments(UUID uuid);
    CompletableFuture<List<Punishment>> getPunishments(String name);

    /**
     * Create a new punishment
     * @param type The type of the punishment
     * @param playerName Name of the player
     * @param OperatorName Name of the operator that punished the player
     * @param duration Duration of the punishment. Null or 0 for permanent
     * @param overrideOldOne Should this override the old punishment
     * @param isSilent Should the punishment be silent (no message)
     * @return The new punishment, or null if nothing changed.
     */
    CompletableFuture<Punishment> createPunishment(PunishmentType type, String playerName, String OperatorName, Long duration, boolean overrideOldOne, boolean isSilent);
}

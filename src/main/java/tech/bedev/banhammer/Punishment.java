package tech.bedev.banhammer;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface Punishment {

    PunishmentType getType();

    /**
     * @param fromStart Should the duration be from start
     * @return the duration between now or start till end as {@link Duration#getDurationString(boolean)}, or null if its a permanent punishment
     */
    String getDurationString(boolean fromStart);


    /**
     * @return The duration of the Punishment
     */
    Duration getDuration();

    /**
     * @param fromStart Should the duration be from start
     * @return the duration between now or start till end in millie, or 0 if its a permanent punishment
     */
    long getDurationMillie(boolean fromStart);

    String getName();

    UUID getOperatorUUID();

    String getOperatorName();

    boolean isPermanent();

    boolean isExpired();

    Long getPunishDate();

    Long getEndDate();

    CompletableFuture<Void> unPunish();

    UUID getUUID();

    String toString();
}

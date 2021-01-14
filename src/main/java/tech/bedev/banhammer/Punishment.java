package tech.bedev.banhammer;

import java.util.UUID;

public interface Punishment {

    PunishmentType getType();
    String getDuration(boolean fromStart);
    Long getDurationMillie(boolean fromStart);
    String getName();
    String getOperator();
    boolean isPermanent();
    boolean isExpired();
    String getPunishDate();
    String getEndDate();
    void unPunish();
    UUID getUUID();
    String toString();
}

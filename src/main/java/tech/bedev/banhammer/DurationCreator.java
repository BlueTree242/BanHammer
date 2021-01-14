package tech.bedev.banhammer;

import java.util.concurrent.TimeUnit;

public class DurationCreator {
    public DurationCreator(Long start, Long end) {
        if (start != null) this.start = start;
        if (end != null) this.end = end;
    }
    private Long start = -1L;
    private Long end = -1L;

    public Long getDuration() {
        if (end == -1L) return -1L;
        if (start == -1) return -2L;
        return end - start;
    }
    public String getDurationString(boolean fromStart) {
        if (end == -1L) return "Permanent";
        if (start == -1) return "Invalid start";
        Long ms = fromStart ? end : System.currentTimeMillis() - start;
        String val = "";
        Long remaining = ms;
        Long days = TimeUnit.MILLISECONDS.toDays(ms);
        remaining = remaining - TimeUnit.DAYS.toMillis(days);
        Long hours = TimeUnit.MILLISECONDS.toHours(remaining);
        remaining = remaining - TimeUnit.HOURS.toMillis(hours);
        Long minutes = TimeUnit.MILLISECONDS.toMinutes(remaining);
        remaining = remaining - TimeUnit.MINUTES.toMillis(minutes);
        Long seconds = TimeUnit.MILLISECONDS.toSeconds(remaining);
        if (days != 0) {
            val = days + " Days";
        }
        if (hours != 0) {
            if (val.equals("")) {
                val = days + " hours";
            } else {
                val = val + ", " + hours + " hours";
            }
        }
        if (minutes != 0) {
            if (val.equals("")) {
                val = minutes + " minutes";
            } else {
                val = val + ", " + minutes + " minutes";
            }
        }
        if (seconds != 0) {
            if (val.equals("")) {
                val = seconds + " seconds";
            } else {
                val = val + ", " + seconds + " seconds";
            }
        }
        return val;
    }


}

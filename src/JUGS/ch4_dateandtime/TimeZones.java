package JUGS.ch4_dateandtime;

import java.time.ZoneId;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by kag on 18/08/15.
 */
public class TimeZones {

    public static void main(String[] args) {
        Predicate<String> tmp = str -> str.startsWith("America/L") || str.startsWith("Europe/S");

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.stream()
                .filter(tmp)
                .forEach(str -> System.out.println(str));
    }
}

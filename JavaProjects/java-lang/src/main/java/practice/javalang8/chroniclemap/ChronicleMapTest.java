package practice.javalang8.chroniclemap;

import net.openhft.chronicle.map.ChronicleMap;

import java.io.File;
import java.io.IOException;

public class ChronicleMapTest {
    public static void main(String[] args) {

        checkInMemoryChronicleMap();

        try {
            checkPersistedChronicleMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkPersistedChronicleMap() throws IOException {
        ChronicleMap<Long, CharSequence> inMemoryCountryMap = ChronicleMap
                .of(Long.class, CharSequence.class)
                .name("country-map")
                .entries(50)
                .averageValue("Sharma")
                .createPersistedTo(new File(System.getProperty("user.home") + "/country-details.dat"));

        inMemoryCountryMap.put(1L, "Sharma, Ram");
        inMemoryCountryMap.put(2L, "Sharma, Ram");
        inMemoryCountryMap.put(3L, "Sharma, Heap");

        System.out.println(inMemoryCountryMap.get(1L));
        System.out.println(inMemoryCountryMap.get(2L));
        System.out.println(inMemoryCountryMap.get(3L));

        System.out.println(Long.class.getClass());
    }

    private static void checkInMemoryChronicleMap() {
        ChronicleMap<Long, CharSequence> inMemoryCountryMap = ChronicleMap
                .of(Long.class, CharSequence.class)
                .name("country-map")
                .entries(50)
                .averageValue("Sharma")
                .create();

        inMemoryCountryMap.put(1L, "Ram, Sharma");
        inMemoryCountryMap.put(2L, "Ram, Sharma");
        inMemoryCountryMap.put(3L, "Heap, Sharma");

        System.out.println(inMemoryCountryMap.get(1L));
        System.out.println(inMemoryCountryMap.get(2L));
        System.out.println(inMemoryCountryMap.get(3L));
    }
}

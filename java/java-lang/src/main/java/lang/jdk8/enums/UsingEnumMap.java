package lang.jdk8.enums;

import java.util.EnumMap;

public class UsingEnumMap {

    public static void main(String[] args) {
        Class<Season> enumClassType = Season.class;
        EnumMap<Season, String> enumMap = new EnumMap(enumClassType);
        enumMap.put(Season.FALL, "Season-Fall");
        enumMap.put(Season.SPRING, "Season-Spring");
        enumMap.put(Season.SUMMER, "Season-Summer");
        enumMap.put(Season.WINTER, "Season-Winter");
        System.out.println(enumMap);
    }
}

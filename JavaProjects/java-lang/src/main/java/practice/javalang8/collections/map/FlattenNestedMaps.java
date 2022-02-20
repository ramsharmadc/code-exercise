package practice.javalang8.collections.map;

import java.util.*;

public class FlattenNestedMaps {

    public static void main(String[] args) {

        try {
            String s = (String) Class.forName("java.lang.String").newInstance();
            s = ("Class Loaded using forName");
            System.out.println("s is -> " + s);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Map<Object, Object> map1 = new LinkedHashMap<>();
        map1.put("A1", "Home");
        map1.put("B1", "Country");

        Map<Object, Object> map2 = new LinkedHashMap<>();
        map2.put("A2", "Tuscano");
        map2.put("B2", "Italy");
        map1.put("C2", map2);

        Map<Object, Object> map3 = new LinkedHashMap<>();
        map3.put("A3", "Europe");
        map3.put("B3", "Poland");
        map2.put("C3", map3);
        map3.put("D", "Europe");
        map3.put("E3", "Poland");
        map3.put("F3", "Europe");
        map3.put("G3", "Poland");
        map3.put("H3", "Europe");
        map3.put("I3", "Poland");

        Map<Object, Object> map4 = new LinkedHashMap<>();
        map4.put("A4", "Rolex");
        map4.put("B4", "Denim");
        map2.put("C4", map4);

        List<Object> list2 = new ArrayList<>();
        list2.add("Caracow");
        list2.add("Warsaw");
        list2.add("Caracow");
        list2.add("Warsaw");
        list2.add("Caracow");
        list2.add("Warsaw");
        list2.add("Caracow");
        list2.add("Warsaw");
        map1.put("L1", list2);
        map2.put("L2", list2);
        map3.put("L3", list2);
        map4.put("L4", list2);

        StringBuilder str = new StringBuilder("{\n");
        StringBuilder keyStr = new StringBuilder();
        List<String> keyPath = new LinkedList<>();
        // flatMap(map1, str, keyStr);
        flatMap(map1, str, keyPath);
        str.append("}");
        System.out.print(str);
    }

    static void flatMap(Map<Object, Object> map, StringBuilder str, StringBuilder keyStr) {
        for (Map.Entry e : map.entrySet()) {
            if (e.getValue() instanceof Map) {
                keyStr.append("." + e.getKey());
                flatMap((Map<Object, Object>) e.getValue(), str, keyStr);
                if (keyStr.toString().contains("/")) {
                    keyStr = new StringBuilder(keyStr.substring(0, keyStr.lastIndexOf("/")));
                } else {
                    keyStr = new StringBuilder();
                }
            } else if (e.getValue() instanceof List) {
                for (int i = 0; i < ((List) e.getValue()).size(); i++) {
                    str.append("\t{key : " + keyStr + "/" + e.getKey() + "[" + i + "]" + "}, ");
                    str.append("{value : " + ((List) e.getValue()).get(i) + "}\n");
                }
            } else {
                str.append("\t{key : " + keyStr + "/" + e.getKey() + "}, ");
                str.append("{value : " + e.getValue() + "}\n");
            }
        }
    }

    static void flatMap(Map<Object, Object> map, StringBuilder str, List<String> keyPath) {
        for (Map.Entry e : map.entrySet()) {
            if (e.getValue() instanceof Map) {
                keyPath.add((String) e.getKey());
                flatMap((Map<Object, Object>) e.getValue(), str, keyPath);
                keyPath.remove(keyPath.size() - 1);
            } else if (e.getValue() instanceof List) {
                for (int i = 0; i < ((List) e.getValue()).size(); i++) {
                    str.append(
                            "\t{key : " + preparePath(keyPath, e.getKey() + "[" + i + "]") + "}, ");
                    str.append("{value : " + ((List) e.getValue()).get(i) + "}\n");
                }
            } else {
                str.append("\t{key : " + preparePath(keyPath, (String) e.getKey()) + "}, ");
                str.append("{value : " + e.getValue() + "}\n");
            }
        }
    }

    static String preparePath(List<String> keyPath, String leafNode) {
        StringBuilder pathStr = new StringBuilder();
        keyPath.forEach(x -> pathStr.append(x + "/"));
        pathStr.append(leafNode);
        return pathStr.toString();
    }
}

package practice.javalang8.collections.List.LinkedHashList;

public class Test {

    public static void main(String[] args) {

        LinkedHashList<String> listCumMap = new LinkedHashList<>();

        listCumMap.add("ZERO");
        listCumMap.add("FIRST");
        listCumMap.add("SECOND");
        listCumMap.add("THIRD");
        listCumMap.add("FOURTH");
        listCumMap.add("FIFTH");

        // System.out.println(listCumMap.get(2));
        // System.out.println(listCumMap);

        for (String s : listCumMap) {
            System.out.println(s);
            // itr.remove();
        }

        // System.out.println(listCumMap);
    }
}

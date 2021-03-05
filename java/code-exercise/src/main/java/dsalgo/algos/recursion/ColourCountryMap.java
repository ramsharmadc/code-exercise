package dsalgo.algos.recursion;

public class ColourCountryMap {

    static final int NONE = 0;
    static final int RED = 1;
    static final int YELLOW = 2;
    static final int GREEN = 3;
    static final int BLUE = 4;
    // initial colors for 7 countries
    int[] mapColors = new int[]{NONE, NONE, NONE, NONE, NONE, NONE, NONE};
    private int[][] map;

    public static void main(String[] args) {
        ColourCountryMap m = new ColourCountryMap();
        m.createMap();
        boolean result = m.explore(0, RED);
        System.out.println(result);
        m.printMap();
    }

    void createMap() {
        map = new int[7][7];
        map[0] = new int[]{1, 4, 2, 5};
        map[1] = new int[]{0, 4, 6, 5};
        map[2] = new int[]{0, 4, 3, 6, 5};
        map[3] = new int[]{2, 4, 6};
        map[4] = new int[]{0, 1, 6, 3, 2};
        map[5] = new int[]{2, 6, 1, 0};
        map[6] = new int[]{2, 3, 4, 1, 5};
    }

    boolean explore(int country, int color) {
        if (country >= map.length)
            return true;
        if (okayToColor(country, color)) {
            mapColors[country] = color;
            for (int i = RED; i <= BLUE; i++) {
                if (explore(country + 1, i))
                    return true;
            }
        }
        return false;
    }

    boolean okayToColor(int country, int color) {
        for (int j = 0; j < map[country].length; j++) {
            int adjCtry = map[country][j];
            if (mapColors[adjCtry] == color)
                return false;
        }
        return true;
    }

    void printMap() {
        for (int i = 0; i < map.length; i++) {
            System.out.print("map[" + i + "] is ");
            switch (mapColors[i]) {
                case NONE:
                    System.out.println("None");
                    break;
                case RED:
                    System.out.println("red");
                    break;
                case YELLOW:
                    System.out.println("yellow");
                    break;
                case BLUE:
                    System.out.println("blue");
                    break;
                case GREEN:
                    System.out.println("green");
                    break;
                default:
                    break;
            }
        }
    }
}

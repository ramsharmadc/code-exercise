package dsa.problemsolving.misc;

import java.util.*;

public class TopKStockByVolume {

    static Comparator<StockVolume> ascComparator = new Comparator<StockVolume>() {
        @Override
        public int compare(StockVolume o1, StockVolume o2) {
            return o2.volume-o1.volume;
        }
    };

    private static Map<String, StockVolume> stockLookup = new HashMap<>();
    private static PriorityQueue<StockVolume> stockVolumes = new PriorityQueue<>(ascComparator);

    public static void main(String[] args) {
        TopKStockByVolume topKStockByVolume = new TopKStockByVolume();
        StockVolume sv1 = topKStockByVolume.new StockVolume(300, "GS");
        StockVolume sv2 = topKStockByVolume.new StockVolume(500, "MS");
        StockVolume sv3 = topKStockByVolume.new StockVolume(500, "GS");
        StockVolume sv4 = topKStockByVolume.new StockVolume(300, "MSFT");
        StockVolume sv5 = topKStockByVolume.new StockVolume(200, "AAPL");

        topKStockByVolume.addStock(sv1);
        topKStockByVolume.addStock(sv2);
        topKStockByVolume.addStock(sv3);
        topKStockByVolume.addStock(sv4);
        topKStockByVolume.addStock(sv5);

        List<StockVolume> stocks = topKStockByVolume.topKStocks(3);
        System.out.println(stocks);
    }

    void addStock(StockVolume sv) {
        if (stockLookup.containsKey(sv.name)) {
            StockVolume curStk = stockLookup.get(sv.name);
            stockVolumes.remove(sv); // O(n) linear time as each index of array is checked.
            StockVolume svTmp = new StockVolume(curStk.volume + sv.volume, sv.name);
            stockVolumes.add(svTmp);
            stockLookup.put(sv.getName(), svTmp);
        } else {
            StockVolume svTmp = new StockVolume(sv.volume, sv.name);
            stockLookup.put(sv.name, svTmp);
            stockVolumes.add(svTmp);
        }
    }

    List<StockVolume> topKStocks(int k) {
        List<StockVolume> topKStocks = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            topKStocks.add(stockVolumes.remove());
        }
        return topKStocks;
    }

    class StockVolume {
        int volume;
        String name;

        public StockVolume(int volume, String name) {
            this.volume = volume;
            this.name = name;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "StockVolume{" +
                    "volume=" + volume +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}

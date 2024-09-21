package code.main.app.offheap.check;

public class TestJavaMemoryLayout {
    private static final int NUM_RECORDS = 50 * 1000 * 1000;

    private static JavaMemoryTrade[] trades;

    public static void main(final String[] args) {
        for (int i = 0; i < 5; i++) {
            System.gc();
            perfRun(i);
        }
    }

    private static void perfRun(final int runNum) {
        long start = System.currentTimeMillis();

        init();

        System.out.format("Memory %,d total, %,d free\n",
                Runtime.getRuntime().totalMemory(),
                Runtime.getRuntime().freeMemory());
        long buyCost = 0;
        long sellCost = 0;

        for (int i = 0; i < NUM_RECORDS; i++) {
            final JavaMemoryTrade trade = get(i);

            if (trade.getSide() == 'B') {
                buyCost += (trade.getPrice() * trade.getQuantity());
            } else {
                sellCost += (trade.getPrice() * trade.getQuantity());
            }
        }

        long duration = System.currentTimeMillis() - start;
        System.out.println(runNum + " - duration " + duration + "ms");
        System.out.println("buyCost = " + buyCost + " sellCost = " + sellCost);
    }

    private static JavaMemoryTrade get(final int index) {
        return trades[index];
    }

    public static void init() {
        final byte[] londonStockExchange = {'X', 'L', 'O', 'N'};
        final int venueCode = pack(londonStockExchange);

        final byte[] billiton = {'B', 'H', 'P'};
        final int instrumentCode = pack(billiton);

        trades = new JavaMemoryTrade[NUM_RECORDS];
        for (int i = 0; i < NUM_RECORDS; i++) {
            JavaMemoryTrade trade = new JavaMemoryTrade();
            trades[i] = trade;

            trade.setTradeId(i);
            trade.setClientId(1);
            trade.setVenueCode(venueCode);
            trade.setInstrumentCode(instrumentCode);

            trade.setPrice(i);
            trade.setQuantity(i);

            trade.setSide((i & 1) == 0 ? 'B' : 'S');
        }
    }

    private static int pack(final byte[] value) {
        int result = 0;
        switch (value.length) {
            case 4:
                result = (value[3]);
            case 3:
                result |= ((int) value[2] << 8);
            case 2:
                result |= ((int) value[1] << 16);
            case 1:
                result |= ((int) value[0] << 24);
                break;

            default:
                throw new IllegalArgumentException("Invalid array size");
        }

        return result;
    }

    private static class JavaMemoryTrade {
        private long tradeId;
        private long clientId;
        private int venueCode;
        private int instrumentCode;
        private long price;
        private long quantity;
        private char side;

        public void setTradeId(final long tradeId) {
            this.tradeId = tradeId;
        }

        public void setClientId(final long clientId) {
            this.clientId = clientId;
        }

        public void setVenueCode(final int venueCode) {
            this.venueCode = venueCode;
        }


        public void setInstrumentCode(final int instrumentCode) {
            this.instrumentCode = instrumentCode;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(final long price) {
            this.price = price;
        }

        public long getQuantity() {
            return quantity;
        }

        public void setQuantity(final long quantity) {
            this.quantity = quantity;
        }

        public char getSide() {
            return side;
        }

        public void setSide(final char side) {
            this.side = side;
        }
    }
}

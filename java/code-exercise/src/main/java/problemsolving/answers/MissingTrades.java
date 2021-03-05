package problemsolving.answers;

import java.util.Date;
import java.util.Scanner;

public class MissingTrades {

    public static void main(String[] args) {
        final Scanner inputScanner = new Scanner(System.in);
        String nxtLiteral;
        while (inputScanner.hasNext()) {
            nxtLiteral = inputScanner.nextLine();
            if (nxtLiteral != null && !nxtLiteral.isEmpty()) {
                // break when output section begins
                if (nxtLiteral.equalsIgnoreCase("#output"))
                    break;
                // skip comment
                if (nxtLiteral.charAt(0) == '#')
                    continue;
                System.out.println(nxtLiteral);
            }
        }
    }

    private class TradeDetail {
        private Date execTime;
        private String sym;
        private String side;
        private double quantity;
        private double price;

        public Date getExecTime() {
            return execTime;
        }

        public void setExecTime(Date execTime) {
            this.execTime = execTime;
        }

        public String getSym() {
            return sym;
        }

        public void setSym(String sym) {
            this.sym = sym;
        }

        public String getSide() {
            return side;
        }

        public void setSide(String side) {
            this.side = side;
        }

        public double getQuantity() {
            return quantity;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}

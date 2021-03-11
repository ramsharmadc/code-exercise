package dsa.problemsolving.misc;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of currency exchange rates like this: EUR/USD => 1.2 USD/GBP => 0.75 GBP/AUD => 1.7
 * AUD/JPY => 90 GBP/JPY => 150 JPY/INR => 0.6
 * <p>
 * write a method double convert(String sourceCurrency, double amount, String destCurrency); For
 * example, convert(EUR, 100, INR)
 * <p>
 * The method should minimize the number of intermediate conversions.
 */

public class CurrencyExchange {

    private final static int EUR = 0;
    private final static int USD = 1;
    private final static int GBP = 2;
    private final static int AUD = 3;
    private final static int JPY = 4;
    private final static int INR = 5;

    private static final double[] cost = {1.2, 0.75, 1.9, 90, 150, 0.6};
    private static final Set<Conversation> validConverts = new HashSet<>();

    static {
        validConverts.add(Conversation.EUR2USD);
        validConverts.add(Conversation.USD2GBP);
        validConverts.add(Conversation.GBP2AUD);
        validConverts.add(Conversation.AUD2JPY);
        validConverts.add(Conversation.GBP2AUD);
        validConverts.add(Conversation.JPY2INR);
    }

    public static void main(String[] args) {

        int min = findShortConversion(Currency.EUR, Currency.INR);
        System.out.println("Min conversations => " + min);
    }

    private static int findShortConversion(Currency eur2, Currency inr2) {

        return 0;
    }

    public enum Currency {
        EUR(0, "EUR"), USD(1, "USD"), GBP(2, "GBP"), AUD(3, "AUD"), JPY(4, "JPY"), INR(5, "INR");

        int n;
        String st;

        Currency(int n, String dsc) {
            this.n = n;
            this.st = dsc;
        }
    }

    private enum Conversation {
        EUR2USD(0, "EUR2USD"), USD2GBP(1, "USD2GBP"), GBP2AUD(2, "GBP2AUD"), AUD2JPY(3,
                "AUD2JPY"), GBP2JPY(4, "GBP2JPY"), JPY2INR(5, "JPY2INR");

        int n;
        String st;

        Conversation(int n, String dsc) {
            this.n = n;
            this.st = dsc;
        }
    }

}

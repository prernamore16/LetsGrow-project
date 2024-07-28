
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {
    
    private static HashMap<String, Double> exchangeRates = new HashMap<>();

    static {
        // Define some sample exchange rates
        exchangeRates.put("USD", 1.0);          // US Dollar
        exchangeRates.put("EUR", 0.85);         // Euro
        exchangeRates.put("JPY", 110.0);        // Japanese Yen
        exchangeRates.put("GBP", 0.75);         // British Pound
        exchangeRates.put("INR", 74.0);         // Indian Rupee
        // Add more currencies and their rates as needed
    }

    public static double convert(String fromCurrency, String toCurrency, double amount) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency code");
        }
        double rateFrom = exchangeRates.get(fromCurrency);
        double rateTo = exchangeRates.get(toCurrency);
        return amount * (rateTo / rateFrom);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();
        System.out.println();
        System.out.println("Available currencies: USD EUR JPY GBP INR AUD CAD CHF CNY SEK" );
        System.out.println();

        System.out.print("Enter the currency to convert from (e.g., USD, EUR): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the currency to convert to (e.g., USD, EUR): ");
        String toCurrency = scanner.next().toUpperCase();

        try {
            double convertedAmount = convert(fromCurrency, toCurrency, amount);
            System.out.printf("%.2f %s is %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}


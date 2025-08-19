import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Available currencies
        String[] currencies = {"USD", "INR", "EUR", "GBP", "JPY"};

        double USD_TO_INR = 87.47;
        double USD_TO_EUR = 0.85;
        double USD_TO_GBP = 0.74;
        double USD_TO_JPY = 147.44;

        System.out.println("===== Currency Converter =====");
        System.out.println("Available currencies: USD, INR, EUR, GBP, JPY");

        // Input base currency
        System.out.print("Enter base currency: ");
        String base = sc.next().toUpperCase();

        // Input target currency
        System.out.print("Enter target currency: ");
        String target = sc.next().toUpperCase();

        // Input amount
        System.out.print("Enter amount in " + base + ": ");
        double amount = sc.nextDouble();

        // Step 1: Convert base to USD
        double inUSD = 0;
        switch (base) {
            case "USD": inUSD = amount; break;
            case "INR": inUSD = amount / USD_TO_INR; break;
            case "EUR": inUSD = amount / USD_TO_EUR; break;
            case "GBP": inUSD = amount / USD_TO_GBP; break;
            case "JPY": inUSD = amount / USD_TO_JPY; break;
            default: System.out.println("Invalid base currency!"); return;
        }

        // Step 2: Convert USD to target currency
        double converted = 0;
        switch (target) {
            case "USD": converted = inUSD; break;
            case "INR": converted = inUSD * USD_TO_INR; break;
            case "EUR": converted = inUSD * USD_TO_EUR; break;
            case "GBP": converted = inUSD * USD_TO_GBP; break;
            case "JPY": converted = inUSD * USD_TO_JPY; break;
            default: System.out.println("Invalid target currency!"); return;
        }

        // Step 3: Display result
        System.out.println("Converted Amount: " + converted + " " + target);

        sc.close();
    }
}

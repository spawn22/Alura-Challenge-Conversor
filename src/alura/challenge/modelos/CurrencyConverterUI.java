package alura.challenge.modelos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CurrencyConverterUI {
    private final ExchangeRateClass exchangeClient;
    private final Scanner scanner;
    private static final List<String> CURRENCIES = List.of("USD", "EUR", "JPY", "ARS");

    public CurrencyConverterUI(String apiKey) {
        this.exchangeClient = new ExchangeRateClass(apiKey);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            try {
                showMenu();
                int option = getMenuOption();

                if (option == 5) {
                    System.out.println("¡Gracias por usar el conversor de monedas!");
                    break;
                }

                processConversion(CURRENCIES.get(option - 1));

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            scanner.nextLine();
        }
        scanner.close();
    }

    private void showMenu() {
        System.out.println("\n=== Conversor de Monedas ===");
        System.out.println("Seleccione la moneda de origen:");
        System.out.println("1. Dólar Estadounidense (USD)");
        System.out.println("2. Euro (EUR)");
        System.out.println("3. Yen (JPY)");
        System.out.println("4. Argentino (ARS)");
        System.out.println("5. Salir");
    }

    private int getMenuOption() {
        while (true) {
            System.out.println("\nIngrese su opción (1-5): ");
            try {
                int option = Integer.parseInt(scanner.nextLine());
                if (option >= 1 && option <= 5) {
                    return option;
                }

                System.out.println("Por favor, ingrese una opción válida (1-5)");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido");
            }
        }
    }

    private void processConversion(String currency) throws IOException, InterruptedException {
        System.out.println("Ingrese el monto a convertir: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Por favor, ingrese un monto válido");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }

        List<CurrencyConversion> conversions = new ArrayList<>();

        for (String targetCurrency : CURRENCIES) {
            if (!targetCurrency.equals(currency)) {
                conversions.add(exchangeClient.convertAmount(currency, targetCurrency, amount));
            }
        }

        System.out.println("\n=== Resultados de la conversión ===");
        System.out.printf("Monto original: %.2f %s%n", amount, currency);
        System.out.println("Conversiones:");

        for (CurrencyConversion conversion : conversions) {
            System.out.printf("%s: %.2f (Tasa: %.4f)%n",
                    conversion.toCurrency(),
                    conversion.convertedAmount(),
                    conversion.rate());
        }

    }
}

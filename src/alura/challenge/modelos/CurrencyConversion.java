package alura.challenge.modelos;

public record CurrencyConversion(String fromCurrency,
        String toCurrency,
        double amount,
        double convertedAmount,
        double rate) {

    @Override
    public String toString() {
        return String.format("%.2f %s = %.2f %s (tasa: %.4f)",
                amount, fromCurrency, convertedAmount, toCurrency, rate);
    }

}

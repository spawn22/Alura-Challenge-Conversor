package alura.challenge.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ExchangeRateClass {
    private final HttpClient httpClient;
    private final String apiKey;
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    private final Gson gson;

    public ExchangeRateClass(String apiKey) {
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public ExchangeRateResponse getRateForCurrency(String baseCurrency, String targetCurrency)
            throws IOException, InterruptedException {
        String endpoint = String.format("%s%s/pair/%s/%s", BASE_URL, apiKey, baseCurrency, targetCurrency);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Error al obtener el precio de cambio" + response.statusCode());
        }

        return gson.fromJson(response.body(), ExchangeRateResponse.class);

    }

    public CurrencyConversion convertAmount(String baseCurrency, String targetCurrency, double amount)
            throws IOException, InterruptedException {

        ExchangeRateResponse rate = getRateForCurrency(baseCurrency, targetCurrency);
        double convertedAmount = amount * rate.conversion_rate();

        return new CurrencyConversion(
            baseCurrency,
            targetCurrency,
            amount,
            convertedAmount,
            rate.conversion_rate()
        );
    }

}

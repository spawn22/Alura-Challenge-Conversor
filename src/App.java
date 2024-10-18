
import alura.challenge.modelos.CurrencyConverterUI;

public class App {
    public static void main(String[] args) throws Exception {
        String apiKey = "702a5e78035a9059488b09e6";

        CurrencyConverterUI converter = new CurrencyConverterUI(apiKey);
        converter.start();
    }
}

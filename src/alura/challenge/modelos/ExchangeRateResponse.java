package alura.challenge.modelos;

public record ExchangeRateResponse(String result,
        String documentation,
        String terms_of_use,
        long time_last_update_unix,
        String time_last_update_utc,
        long time_next_update_unix,
        String time_next_update_utc,
        String base_code,
        String target_code,
        double conversion_rate) {
    @Override
    public String toString() {
        return String.format("Tasa de conversión de %s a %s: %.4f",
                base_code, target_code, conversion_rate);
    }
}

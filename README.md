Currency Converter 💱
Un conversor de monedas en Java que utiliza la API de ExchangeRate-API para obtener tasas de cambio en tiempo real. El proyecto permite convertir entre diferentes monedas (ARS, USD, EUR, COP) con una interfaz de usuario por consola.
🚀 Características

Conversión en tiempo real usando ExchangeRate-API
Soporte para múltiples monedas:

Peso Argentino (ARS)
Dólar Estadounidense (USD)
Euro (EUR)
Peso Colombiano (COP)


Interfaz de usuario por consola intuitiva
Utilización de Java Records para el manejo de datos
Implementación de cliente HTTP moderno
Manejo de errores robusto

📋 Prerrequisitos

Java 17 o superior
Maven
Una API key de ExchangeRate-API

🔧 Instalación

Clona el repositorio:

bashCopygit clone https://github.com/tuusuario/currency-converter.git
cd currency-converter

Instala las dependencias con Maven:

bashCopymvn install

Configura tu API key:

Reemplaza TU_API_KEY en la clase Main con tu API key de ExchangeRate-API



📦 Estructura del Proyecto
Copysrc/
├── main/
│   └── java/
│       └── alura/
│           └── challenge/
│               ├── modelos/
│               │   ├── ExchangeRateClass.java
│               │   ├── ExchangeRateResponse.java
│               │   └── CurrencyConversion.java
│               └── ui/
│                   └── CurrencyConverterUI.java
🛠️ Tecnologías Utilizadas

Java 17
Maven
Gson
ExchangeRate-API
Java HTTP Client

📄 Dependencias Maven
xmlCopy<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
</dependencies>
💻 Uso

Ejecuta la aplicación:

javaCopypublic class Main {
    public static void main(String[] args) {
        String apiKey = "TU_API_KEY";
        CurrencyConverterUI converter = new CurrencyConverterUI(apiKey);
        converter.start();
    }
}

Sigue las instrucciones en pantalla:

Selecciona la moneda de origen
Ingresa el monto a convertir
Visualiza las conversiones a todas las monedas disponibles
Decide si deseas realizar otra conversión



📝 Ejemplo de Uso
Copy=== Conversor de Monedas ===
Seleccione la moneda de origen:
1. Peso Argentino (ARS)
2. Dólar Estadounidense (USD)
3. Euro (EUR)
4. Peso Colombiano (COP)
5. Salir

Ingrese su opción (1-5): 2
Ingrese el monto a convertir: 100

=== Resultados de la conversión ===
Monto original: 100.00 USD
Conversiones:
ARS: 84539.50 (Tasa: 845.3950)
EUR: 91.23 (Tasa: 0.9123)
COP: 394650.00 (Tasa: 3946.5000)

¿Desea realizar otra conversión? (s/n)
⚡ Características Principales del Código

Records para DTO:

javaCopypublic record CurrencyConversion(
    String fromCurrency,
    String toCurrency,
    double amount,
    double convertedAmount,
    double rate
) {}

Cliente HTTP Moderno:

javaCopyHttpClient httpClient = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(endpoint))
        .header("Accept", "application/json")
        .GET()
        .build();
🤝 Contribuir

Fork el proyecto
Crea tu Feature Branch (git checkout -b feature/AmazingFeature)
Commit tus cambios (git commit -m 'Add some AmazingFeature')
Push al Branch (git push origin feature/AmazingFeature)
Abre un Pull Request

✨ Mejoras Futuras Planificadas

 Agregar más monedas
 Implementar caché de tasas de cambio
 Agregar historiales de conversión
 Crear una interfaz gráfica
 Exportar resultados a CSV

📄 Licencia
Este proyecto está bajo la Licencia MIT - mira el archivo LICENSE.md para detalles

✍️ Autor
spawn22

🎁 Agradecimientos

ExchangeRate-API por proporcionar las tasas de cambio
Alura por el desafío

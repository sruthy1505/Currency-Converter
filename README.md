# Currency Converter API (Spring Boot)

## Overview
This is a Spring Boot-based REST API for real-time currency conversion. It fetches exchange rates from a public API and allows users to convert currency amounts.

## Features
- Fetch live exchange rates.
- Convert amounts between different currencies.
- Error handling for invalid currency codes and API failures.
- Unit tests using JUnit.
- API documentation using Swagger.

## Technologies Used
- Java 17
- Spring Boot
- Spring Web
- RestTemplate (for API calls)
- JUnit (for testing)
- Maven (for dependency management)

## Setup and Installation
### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/currency-converter.git
cd currency-converter
```

### 2. Configure API Key
Update `src/main/resources/application.properties` with your API key:
```
exchange.api.url=https://api.exchangerate-api.com/v4/latest/
exchange.api.key=YOUR_API_KEY
server.port=8080
```

### 3. Build and Run the Application
```bash
mvn clean install
mvn spring-boot:run
```

## API Endpoints
### 1. Fetch Exchange Rates
**GET** `/api/rates?base=USD`
- Retrieves exchange rates for the given base currency (default: USD).

#### Example Response:
```json
{
  "base": "USD",
  "rates": {
    "EUR": 0.945,
    "INR": 83.5,
    "GBP": 0.78
  }
}
```

### 2. Convert Currency
**POST** `/api/convert`
#### Request Body:
```json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100
}
```
#### Example Response:
```json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100,
  "convertedAmount": 94.5
}
```

## Error Handling
- **Invalid Currency Code:** Returns a `400 Bad Request` with an error message.
- **API Unavailable:** Returns a `500 Internal Server Error`.

## Testing
Run unit tests using:
```bash
mvn test
```

## API Documentation
After running the application, access Swagger documentation at:
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Deployment
To create a JAR file and deploy:
```bash
mvn clean package
java -jar target/currency-converter-1.0.0.jar
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you'd like to change.

## License
This project is licensed under the MIT License.

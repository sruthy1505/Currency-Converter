# Currency Converter API (Spring Boot)

## Overview
A Spring Boot REST API for real-time currency conversion using an external exchange rate API.

## Features
- Fetch real-time exchange rates.
- Convert currency amounts.
- Error handling for invalid inputs and API failures.
- Unit testing with JUnit.
- API documentation with Swagger.

## Technologies Used
- Java 17
- Spring Boot
- Spring Web
- RestTemplate (for API calls)
- JUnit (for testing)
- Maven (for dependency management)

## Setup & Installation
### 1. Clone the Repository
bash
git clone https://github.com/yourusername/currency-converter.git
cd currency-converter


### 2. Configure API Key
Update src/main/resources/application.properties:
properties
exchange.api.url=https://api.exchangerate-api.com/v4/latest/
exchange.api.key=YOUR_API_KEY
server.port=8080
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui/index.html


### 3. Build & Run the Application
bash
mvn clean install
mvn spring-boot:run


## API Endpoints
### 1. Fetch Exchange Rates
*GET* /api/rates?base=USD (default: USD)
#### Example Response:
json
{
  "base": "USD",
  "rates": {
    "EUR": 0.945,
    "INR": 83.5
  }
}


### 2. Convert Currency
*POST* /api/convert
#### Request Body:
json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100
}

#### Example Response:
json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100,
  "convertedAmount": 94.5
}


### 3. Error Responses
#### Invalid Currency Code
json
{
  "error": "Invalid currency code: XYZ"
}

#### External API Unavailable
json
{
  "error": "Exchange rate service is currently unavailable. Please try again later."
}

#### Missing Request Parameters
json
{
  "error": "Missing required parameters: from, to, amount"
}

## Testing
Run unit tests:
bash
mvn test


## Deployment
bash
mvn clean package
java -jar target/currency-converter-1.0.0.jar


## License
MIT License.

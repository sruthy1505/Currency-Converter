package com.ty.service;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ty.model.CurrencyConversionRequest;

@Service
public class CurrencyService {
	private final RestTemplate restTemplate = new RestTemplate();
	private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";

	public Map<String, Object> getExchangeRates(String base) {
		String url = API_URL + base;
		return restTemplate.getForObject(url, Map.class);
	}

	public Map<String, Object> convertCurrency(CurrencyConversionRequest request) {
		Map<String, Object> rates = getExchangeRates(request.getFrom());
		if (rates == null || !rates.containsKey("rates")) {
			throw new IllegalArgumentException("Invalid base currency");
		}
		Map<String, Double> rateMap = (Map<String, Double>) rates.get("rates");
		if (!rateMap.containsKey(request.getTo())) {
			throw new IllegalArgumentException("Invalid target currency");
		}
		double convertedAmount = request.getAmount() * rateMap.get(request.getTo());
		return Map.of("from", request.getFrom(), "to", request.getTo(), "amount", request.getAmount(),
				"convertedAmount", convertedAmount);
	}

}

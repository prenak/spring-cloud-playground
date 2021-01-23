package com.xps.stock.fin.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

@Service
public class FinService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Stock> getStockInfoForUser(String userName) {
		ResponseEntity<List<String>> responseEntity = restTemplate.exchange("http://localhost:8089/api/db/quotes/"+userName, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {});
		
		return responseEntity.getBody()
					.stream()
					//.map(quote -> {return getYahoonFinStock(quote);})
					.map(this::getYahoonFinStock)
					.collect(Collectors.toList());
	}
	
	private Stock getYahoonFinStock(String quote) {
		try {
			return YahooFinance.get(quote);
		} catch (IOException e) {
			e.printStackTrace();
			return new Stock(quote);
		}
	}
}

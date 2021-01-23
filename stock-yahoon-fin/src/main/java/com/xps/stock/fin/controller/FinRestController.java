package com.xps.stock.fin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xps.stock.fin.service.FinService;

import yahoofinance.Stock;

@RestController
@RequestMapping(path="/api/fin")
public class FinRestController {
	
	@Autowired
	private FinService finService;
	
	
	@GetMapping(path = "/{userName}")
	public List<Stock> getStocksForUserName(@PathVariable(name = "userName") final String userName){
		return finService.getStockInfoForUser(userName);
	}

}

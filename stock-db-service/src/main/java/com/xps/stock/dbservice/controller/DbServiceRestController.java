package com.xps.stock.dbservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xps.stock.dbservice.model.Quote;
import com.xps.stock.dbservice.model.UserQuote;
import com.xps.stock.dbservice.repository.QuoteRepository;

@RestController
@RequestMapping(path = "/api/db")
public class DbServiceRestController {
	
	@Autowired
	private QuoteRepository quoteRepo;
	
	@GetMapping(path = "/quotes/{userName}")
	public List<String> getQuotes(@PathVariable(name = "userName") final String userName){
		
		return quoteRepo.findByUserName(userName)
						.stream()
						.map(Quote::getQuoteName)
						.collect(Collectors.toList());
	}
	
	@PostMapping(path = "/quotes")
	public List<Quote> addQuotesForUser(@RequestBody UserQuote userQuote){
		userQuote.getUserQuotes()
				 .stream()
				 .map(q -> new Quote(userQuote.getUserName(), q))
				 .forEach(q -> quoteRepo.save(q));
		
		return quoteRepo.findByUserName(userQuote.getUserName());
	}
}

package com.xps.stock.dbservice.model;

import java.util.List;

public class UserQuote {
	
	private String userName;
	private List<String> userQuotes;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getUserQuotes() {
		return userQuotes;
	}
	public void setUserQuotes(List<String> userQuotes) {
		this.userQuotes = userQuotes;
	}
	
	@Override
	public String toString() {
		return "UserQuote [userName=" + userName + ", userQuotes=" + userQuotes + "]";
	}
}

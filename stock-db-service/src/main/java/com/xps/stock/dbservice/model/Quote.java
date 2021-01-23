package com.xps.stock.dbservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Quote")
public class Quote {
	
	@Id
	@Column(name = "QUOTE_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "QUOTE_NAME")
	private String quoteName;
	
	
	public Quote() {}

	public Quote(String userName, String quoteName) {
		super();
		this.userName = userName;
		this.quoteName = quoteName;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getQuoteName() {
		return quoteName;
	}
	public void setQuoteName(String quoteName) {
		this.quoteName = quoteName;
	}
	@Override
	public String toString() {
		return "Quote [id=" + id + ", userName=" + userName + ", quoteName=" + quoteName + "]";
	}
}

package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class url {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String actualUrl;
	
	private String shortUrl;
	
	private LocalDateTime creationDate;
	
	private LocalDateTime expiryDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActualUrl() {
		return actualUrl;
	}

	public void setActualUrl(String actualUrl) {
		this.actualUrl = actualUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public url(Integer id, String actualUrl, String shortUrl, LocalDateTime creationDate, LocalDateTime expiryDate) {
		super();
		this.id = id;
		this.actualUrl = actualUrl;
		this.shortUrl = shortUrl;
		this.creationDate = creationDate;
		this.expiryDate = expiryDate;
	}

	public url() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

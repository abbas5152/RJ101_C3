package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.model.UrlDto;
import com.masai.model.url;

@Service
public interface urlService {
	
	public url createShroturl(UrlDto url);
	
	public url saveShorturl(url url);
	
	public url getUrl(String url);
	
	public String deleteShorturl(url url);
	

}

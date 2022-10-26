package com.masai.service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.masai.model.UrlDto;
import com.masai.model.url;
import com.masai.repo.urlRepo;

import antlr.StringUtils;

@Service
public class urlServiceImpl implements urlService {
	
	private  urlRepo ur; 

	@Override
	public url createShroturl(UrlDto url) {
		// TODO Auto-generated method stub
		if(!url.getUrl().isEmpty()) {
			
			 String encodedUrl = encodeUrl(url.getUrl());
	            url urlToPersist = new url();
	            urlToPersist.setCreationDate(LocalDateTime.now());
	            urlToPersist.setActualUrl(url.getUrl());
	            urlToPersist.setShortUrl(encodedUrl);
	            urlToPersist.setExpiryDate(getExpirationDate(url.getExpirationDate(),urlToPersist.getCreationDate()));
	            url urlToRet = saveShorturl(urlToPersist);

	            if(urlToRet != null)
	                return urlToRet;

	            return null;
	        }
	        return null;
	}
    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate)
    {
        if(!expirationDate.isEmpty())
        {
            return creationDate.plusSeconds(120);
        }
        LocalDateTime expirationDateToRet = LocalDateTime.parse(expirationDate);
        return expirationDateToRet;
    }
	 private String encodeUrl(String url)
	    {
	        String encodedUrl = "";
	        LocalDateTime time = LocalDateTime.now();
	        encodedUrl = Hashing.murmur3_32()
	                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
	                .toString();
	        return  encodedUrl;
	    }

	@Override
	public url saveShorturl(url url) {
	  
		return ur.save(url);
	}

	@Override
	public url getUrl(String url) {
		
		return ur.findByShortUrl(url);
	}

	@Override
	public String deleteShorturl(url url) {
	
		ur.delete(url);
		
		return "deleted..";
	}
	
	

}

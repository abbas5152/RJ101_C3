package com.masai.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.UrlDto;
import com.masai.model.UrlResponseDto;
import com.masai.model.url;
import com.masai.service.urlService;

@RestController
public class mycontroller {
	
	@Autowired
    private urlService urlService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateShortLink(@RequestBody UrlDto urlDto)
    {
        url urlToRet = urlService.createShroturl(urlDto);
        UrlResponseDto urlResponseDto = new UrlResponseDto();

        if(urlToRet != null)
        {
            
            urlResponseDto.setOriginalUrl(urlToRet.getActualUrl());
            urlResponseDto.setExpirationDate(urlToRet.getExpiryDate());
            urlResponseDto.setShortLink(urlToRet.getShortUrl());
            return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);
        }

        return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);

    }

    @GetMapping("/{shortLink}")
    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response) throws IOException {

        if(!shortLink.isEmpty())
        {
 
        }
        url urlToRet = urlService.getUrl(shortLink);

        if(urlToRet == null)
        {
      
        }

        if(urlToRet.getExpiryDate().isBefore(LocalDateTime.now()))
        {
            urlService.deleteShorturl(urlToRet);
        }

        response.sendRedirect(urlToRet.getActualUrl());
        return null;
    }

}

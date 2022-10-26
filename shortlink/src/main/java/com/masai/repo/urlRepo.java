package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.url;

public interface urlRepo extends JpaRepository<url,Integer>{


    public url findByShortUrl(String shortUrl);
}

package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    
  
    List<Ad> all();  // get a list of all the ads
    
    Long insert(Ad ad); // insert a new ad and return the new ad's id

    List<Ad> findByUserId(long userId);
    List<Ad> searchByTitle(String title);


    Ad findById(long id);
}

package com.example.demo.services;

import com.example.demo.models.Traducir;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranslationService {
 
   @Autowired

   RestTemplate restTemplate;

    
   public  Traducir getTraducir(String word){
       String url = "https://api.mymemory.translated.net/get?q="+word+"&langpair=es|en";
       Traducir traducir = restTemplate.getForObject(url, Traducir.class );
       return traducir;
   
}

}

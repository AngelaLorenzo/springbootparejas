package com.example.demo.services;




import com.example.demo.models.ResponseData;
//import com.example.demo.models.Traducir;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranslationService {
 
   @Autowired
   RestTemplate restTemplate;

    String word;
   public ResponseData translate(String word){
       String url = "https://api.mymemory.translated.net/get?q="+word+"&langpair=es|en";
       ResponseData responseData = restTemplate.getForObject(url, ResponseData.class );
       
       return responseData;
   
}

/*public class Matches {
    public String segment;
    public String translation;
}*/



}

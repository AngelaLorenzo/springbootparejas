package com.example.demo.services;

import com.example.demo.models.Traducir;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranslatorService {

    @Autowired
    RestTemplate restTemplate;

    public Traducir translateMetod(String cad){
        String url = "https://api.mymemory.translated.net/get?q="+cad+"&langpair=es|en";
        Traducir text = restTemplate.getForObject(url, Traducir.class);
        return text;
    }
}

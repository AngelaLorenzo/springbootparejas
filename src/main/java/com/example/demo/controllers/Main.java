package com.example.demo.controllers;

import java.text.MessageFormat;

//import com.example.demo.models.Traducir;
import com.example.demo.services.TranslationService;
//import com.fasterxml.jackson.core.io.JsonStringEncoder;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.json.JsonParser;
//import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.client.RestTemplate;
@RestController
public class Main implements ErrorController{


    //ejercicio 1
    @GetMapping("/count/{word}")
    public String count(@PathVariable String word){
        int vowels = 0, consonants = 0;
        word = word.toLowerCase();

        for(int i = 0; i < word.length(); ++i){

            char ch = word.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                ++vowels;
            }else{
                ++consonants;
            }

        }
        String word1=" ";
       
        word1="Número de vocales: "+vowels+" Número de consonantes: "+ consonants;
        return word1;


    }


    //ejercicio 2 (falta base de datos)
   //http://localhost:8080/save?pelicula=Spiderman&año=2007
    @GetMapping("/save")
   public String DatosPorQuery(@RequestParam String pelicula,@RequestParam String año){
       
       Object params[] = {pelicula, año};
       return MessageFormat.format("Has elegido la película {0} del año {1}", params);
   }



 // ejercicio 4
   @GetMapping("/{sentence}")
   public static String transforma(@PathVariable String sentence){
          
           int posicion;
           char caracter;
          
           posicion = sentence.length() - 2;
           while (posicion >= 0){
               caracter = sentence.charAt(posicion);
               sentence = sentence + caracter;
               posicion--;
           }
           System.out.println(sentence);
           return sentence;
      
    
   }

   //ejercicio 5
   @Autowired
   TranslationService translate;
//https://api.mymemory.translated.net/get?q=Hola&langpair=es|en
//http://localhost:8080/translate/get?q={phrase}&langpair=es|en

   @GetMapping("/translate/{phrase}")
      public String doTranslation(@PathVariable String phrase){
        String uri = "https://api.mymemory.translated.net/get?q="+phrase+"&langpair=es|en";
        RestTemplate restTemplate = new RestTemplate();
        String translation =restTemplate.getForObject(uri, String.class);
        
        return translation;
      }
    
    

}

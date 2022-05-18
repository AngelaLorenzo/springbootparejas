package com.example.demo.controllers;

import java.text.MessageFormat;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Main implements ErrorController{
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



    @GetMapping("/guarda")
   public String DatosPorQuery(@RequestParam String pelicula,@RequestParam String año){
       
       Object params[] = {pelicula, año};
       return MessageFormat.format("Has elegido la película {0} del año {1}", params);
   }

}

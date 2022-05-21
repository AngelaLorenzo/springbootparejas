/*package com.example.demo.controllers;

import java.text.MessageFormat;

import com.example.demo.services.DatosBDService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class WebController {
    
    @Autowired
    DatosBDService datosBDService;

    @GetMapping("/guarda")
   public String DatosPorQuery(@RequestParam String pelicula,@RequestParam String año){
       
       Object params[] = {pelicula, año};
       return MessageFormat.format("Has elegido la película {0} del año {1}", params);
   }
}*/
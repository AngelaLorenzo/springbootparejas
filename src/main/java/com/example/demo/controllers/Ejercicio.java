package com.example.demo.controllers;



import java.util.ArrayList;

import com.example.demo.models.Movie;
import com.example.demo.models.Traducir;

import com.example.demo.services.MovieService;
import com.example.demo.services.TranslatorService;

//import com.example.demo.models.Data;


//import com.example.demo.services.DataBDService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//import java.io.File;


@RestController
public class Ejercicio {

    @Autowired
    MovieService movieService;
   
    @Autowired
    TranslatorService translatorService;
  
   


    // http://localhost:8080/
     // http://localhost:8080/
     @GetMapping("/")
     public String greet(){
         return "Servidor backend de Rafael Costas y Ángela Lorenzo<br/>";
     }
 

   //ejercicio 1
   @GetMapping("/contar/{word}")
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
    
  //3º
   // http://localhost:8080/guarda?nombre=???
   @GetMapping("/guarda")
   public String addPelicula(@RequestParam String nombre, @RequestParam String genero) {
       
       Movie movie = new Movie();
       movie.setName(nombre);
       movie.setGenero(genero);
       movieService.saveMovie(movie);
       return "Pelicula registrada perfectamente";
   }

// http://localhost:8080/listar
@GetMapping("/listar")
public String cocheList(){
    ArrayList<Movie> movielist = movieService.getAllMovie();
    String listado = "Películas  registradas:<br/>";
    for(Movie movies : movielist){
        listado +=movies.getId() + " ";
        listado += movies.getName() + " ";
        listado += movies.getGenero();
        listado += "<hr>";
    }
    return listado;
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


/*5-
 /http://localhost:8080/traduce/????*/
 @GetMapping("/traduce/{frase}")
 public String getTranslation(@PathVariable String frase){
     Traducir t = translatorService.translateMetod(frase);

     return t.responseData.translatedText;
 }


}
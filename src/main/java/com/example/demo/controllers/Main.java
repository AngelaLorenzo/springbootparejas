package com.example.demo.controllers;

import java.text.MessageFormat;
import java.util.ArrayList;

import com.example.demo.models.Movie;
import com.example.demo.models.Traducir;
import com.example.demo.services.MovieService;
import com.example.demo.services.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

    @Autowired
    MovieService movieService;


@Autowired
   TranslationService translationService;


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


    //ejercicio 2 (falta base de datos)
   //http://localhost:8080/guarda?pelicula=Spiderman&año=2007
    @GetMapping("/guarda")
   public String addMovie(@RequestParam String nameMovie,@RequestParam String ageMovie){
      Movie movie = new Movie();
      movie.setName(nameMovie);
      movie.setAge(ageMovie);
      movieService.saveMovie(movie);
       return "Has essrito la película {0} del año {1}";
   }


   // ejercicio 3 : listar
   @GetMapping("/listar")
   public String movieList(){
       ArrayList<Movie> movie = movieService.getMovies();
       String lista = "Películas registradas: ";
       for(Movie movies : movie){
           lista += movies.getId() + " ";
           lista += movies.getName() + " ";
           lista += movies.getAge() + " ";
       }
       return lista;
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
   
   @GetMapping("/traduce/{phrase}")
      public String doTranslation(@PathVariable String phrase){
        Traducir p = translationService.getTraducir(phrase);
        return p.responseData.translatedText;
    }
    
    

}

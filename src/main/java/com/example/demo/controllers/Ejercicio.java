package com.example.demo.controllers;



import java.util.ArrayList;

import com.example.demo.models.Movie;
import com.example.demo.models.Traducir;
import com.example.demo.services.MovieService;
import com.example.demo.services.TranslatorService;

//import com.example.demo.models.Data;


//import com.example.demo.services.DataBDService;
//import com.example.demo.utils.Utils;

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
    @GetMapping("/")
    public String greet(){
        return "Servidor backend de Rafael Costas y Ángela Lorenzo<br/>"+
        "Para contar las consonantes y vocales de una palabra: http://localhost:8080/contar/palabra <br/>"+
        "Para guardar el nombre y el género de la película: http://localhost:8080/guarda?nombre=XXXX&genero=XXXX<br/>"+
        "Para ver la lista de las películas introducidas:  http://localhost:8080/listar <br/>"+
        "Para que tu palabra/frase se convierta en palabra/frase espejo: http://localhost:8080/palabra <br/>"+
        "Para traducir palabra/frase del español al inglés: http://localhost:8080/traduce/palabra"
        ;
    }

    //ejercicio 1
    //http://localhost:8080/contar/XXXX
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
       
        word1="El número de vocales es: "+vowels+" <br/> El número de consonantes es: "+ consonants;
        return word1;


    }


    //ejercicio 2 
   // http://localhost:8080/guarda?nombre=XXXX&genero=XXXX
   @GetMapping("/guarda")
   public String addPelicula(@RequestParam String nombre, @RequestParam String genero) {
       
       Movie movie = new Movie();
       movie.setName(nombre);
       movie.setGenero(genero);
       movieService.saveMovie(movie);
       return "Película insertada.";
   }

//ejercicio 3
   // http://localhost:8080/listar
@GetMapping("/listar")
public String movielist(){
    ArrayList<Movie> movie = movieService.getAllMovie();
    String list = "Peliculas registradas:<br/>";
    for(Movie movies : movie){
        list +=movies.getId() + " ";
        list += movies.getName() + " ";
        list += movies.getGenero();
        list += "<br/>";
    }
    return list;
}

// ejercicio 4
// http://localhost:8080/XXXX
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
      Traducir p = translatorService.translate(phrase);
      return p.responseData.translatedText;
  }
    

}
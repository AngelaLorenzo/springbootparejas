/*package com.example.demo.services;

import java.util.ArrayList;

import com.example.demo.models.DatosModel;
import com.example.demo.repository.DatosRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class DatosBDService {
    
    @Autowired
    static
    DatosRepository datosRepository;

    public static ArrayList<DatosModel> obtenerTodosLosDatos() {
        return (ArrayList<DatosModel>) datosRepository.findAll();
    }

    public static DatosModel guardarDatos (DatosModel datos){
        return datosRepository.save(datos);
    }
}*/

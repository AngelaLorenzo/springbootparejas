package com.example.demo.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "datos")

public class DatosModel {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(unique = true, nullable = false)
   private Long id;
 
    private String nombre;

    private Integer peso;
 
   @Temporal(TemporalType.TIMESTAMP)
   @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
   private Date fecha; // Si no pongo fecha, la fecha será la del sistema

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public Integer getPeso() {
    return peso;
}

public void setPeso(Integer peso) {
    this.peso = peso;
}

public Date getFecha() {
    return fecha;
}

public void setFecha(Date fecha) {
    this.fecha = fecha;
}


 
 
////// aqui van los getters y setters (los omito para que sea más legible

}

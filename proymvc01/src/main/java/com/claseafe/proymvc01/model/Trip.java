package com.claseafe.proymvc01.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import com.fasterxml.jackson.databind.util.StdDateFormat;

public class Trip {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private Double costo;
    private Integer destacado;
    private String imagen = "no-image.png";

    @Override
    public String toString(){
        return "Trip [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha= " + fecha + ", costo=" + costo +"]";
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId(){
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(String fechaString) throws ParseException{
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha = sdf.parse(fechaString);
            this.fecha = fecha;
        
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
    public Integer getDestacado() {
        return destacado;
    }
    
    public void setDestacado(Integer destacado) {
        this.destacado = destacado;
    }
    public String getImagen() {
        return imagen;
      }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
      }
}

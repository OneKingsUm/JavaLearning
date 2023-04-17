package com.claseafe.proymvc01.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.claseafe.proymvc01.model.Trip;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;


@Controller
//@RestController
public class HomeController {
    @GetMapping("/")
    public String mostrarHome(Model model){
        String mensaje2 ="hola mensaje 2";
        Date fecha = new Date();
        double costo = 6.2;
        boolean vigencia = false;

        model.addAttribute("mensaje1", "hola desde controlador y metodo");
        model.addAttribute("mensaje2", mensaje2);
        model.addAttribute("fecha", fecha);
        model.addAttribute("costo", costo);
        model.addAttribute("vigencia", vigencia);
        return "home";
    }
    @GetMapping("/listado")
    public String mostrarListado(Model model){
        List<String> lista = new LinkedList<String>();
        lista.add("En la Montana");
        lista.add("En la ciudad");
        lista.add("En los pueblos");
        lista.add("En las playas");
        model.addAttribute("listadoTrips", lista);

        return "listado";
    }
    @GetMapping("/detalle")
    public String mostrarDetalle(Model model) throws ParseException{
        Trip trip = new Trip();
        trip.setNombre("Rapel en Volcatenango");
        trip.setDescripcion("Aventa rapel en circuito en las...");
        trip.setFecha("16-04-2023");
        trip.setCosto(10.0);
        model.addAttribute("trip", trip);
        
        return "detalle";
    }
    private List <Trip> getTrips(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");

        List<Trip> lista = new LinkedList<Trip>();
        try {
            Trip trip1 = new Trip();
            trip1.setId(1);
            trip1.setNombre("Rapel en Volcatenango");
            trip1.setDescripcion("Hacer Rapel en los circuitos de Volcatenango");
            trip1.setFecha("10-05-2022");
            trip1.setCosto(5.0);
            trip1.setDestacado(1);

            Trip trip2 = new Trip();
            trip2.setId(2);
            trip2.setNombre("Deslizadero en el picnic");
            trip2.setDescripcion("Deslizate en un diverito tobogan sobre la colina");
            trip2.setFecha("10-05-2022");
            trip2.setCosto(5.0);
            trip2.setDestacado(1);

            Trip trip3 = new Trip();
            trip3.setId(3);
            trip3.setNombre("Comida y Flores");
            trip3.setDescripcion("Disfrutar de un amplio jardin en el cual podras comprar");
            trip3.setFecha("10-05-2022");
            trip3.setCosto(1.0);

            Trip trip4 = new Trip();
            trip4.setId(4);
            trip4.setNombre("Caminatas");
            trip4.setDescripcion("Disfruta hacer senderismo por las montanas");
            trip4.setFecha("10-05-2022");
            trip4.setCosto(1.0);

            lista.add(trip1);
            lista.add(trip2);
            lista.add(trip3);
            lista.add(trip4);
        }catch(ParseException e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
    @GetMapping ("/tabla")
    public String mostrarTabla(Model model){
        List <Trip> lista = getTrips();
        model.addAttribute("trips", lista);
        return "tabla";
    }
}

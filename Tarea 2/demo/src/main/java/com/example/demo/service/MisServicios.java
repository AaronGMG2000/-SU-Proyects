package com.example.demo.service;

import java.util.LinkedList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
@RequestMapping("/rest")
public class MisServicios {

    /**
     * data
     */
    static class data {
        public String name;
        public String trackName;
        public String type;
        public String service;
        public String serviceUrl;

        public data() {

        }

        public data(String name, String trackName, String type, String service, String serviceUrl) {
            this.name = name;
            this.trackName = trackName;
            this.type = type;
            this.service = service;
            this.serviceUrl = serviceUrl;
        }

    }

    static class description{
        public String languaje;
        public String averageRuntime;
        public List<String> genres;
        public String status;

        public description(){}

        public description(String languaje, String averageRuntime, List<String> genres, String status){
            this.languaje = languaje;
            this.averageRuntime = averageRuntime;
            this.genres = genres;
            this.status = status;
        }

    }
    static class data2 {
        public String name;
        public String trackName;
        public String type;
        public String service;
        public String serviceUrl;
        public description description;
        public data2() {

        }

        public data2(String name, String trackName, String type, String service, String serviceUrl, description movie) {
            this.name = name;
            this.trackName = trackName;
            this.type = type;
            this.service = service;
            this.serviceUrl = serviceUrl;
            this.description = movie;
        }

    }

    @GetMapping(path = "/find/{nombre}")
    public Object find(@PathVariable("nombre") String nombre) {
        List<data> datos = new LinkedList<data>();
        Apis.getItunes(nombre, datos);
        Apis.getTVmaze(nombre, datos);
        return new ResponseEntity<Object>(datos, HttpStatus.OK);
    }

    @GetMapping(path = "/find2/{nombre}")
    public Object find2(@PathVariable("nombre") String nombre) {
        System.out.println("entro");
        List<data2> datos = new LinkedList<data2>();
        Apis.getItunes2(nombre, datos);
        Apis.getTVmaze2(nombre, datos);
        return new ResponseEntity<Object>(datos, HttpStatus.OK);
    }
}

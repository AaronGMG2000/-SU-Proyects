package com.example.demo.service;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.service.MisServicios.data;
import com.example.demo.service.MisServicios.data2;
import com.example.demo.service.MisServicios.description;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Apis {
    static List<data> getItunes(String nombre, List<data> datos) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://itunes.apple.com/search?term=" + nombre,
                String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode artistName = root.path("results");
            for (JsonNode artist : artistName) {
                data nuevo_dato = new data(
                        artist.path("artistName").asText(),
                        artist.path("trackName").asText(),
                        "iTunes",
                        "Api iTunes",
                        "https://itunes.apple.com/search?term=" + nombre);

                datos.add(nuevo_dato);
            }
            return datos;
        } catch (Exception e) {
            return datos;
        }
    }

    static List<data> getTVmaze(String nombre, List<data> datos) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://api.tvmaze.com/search/people?q=" + nombre,
                String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            List<JsonNode> TVmaze = root.findValues("person");
            for (JsonNode artist : TVmaze) {
                data nuevo_dato = new data(
                        artist.path("name").asText(),
                        null,
                        "People",
                        "Api TVmaze",
                        "https://api.tvmaze.com/search/people?q=" + nombre);

                datos.add(nuevo_dato);
            }
            return datos;
        } catch (Exception e) {
            return datos;
        }
    }

    static List<data2> getTVmaze2(String nombre, List<data2> datos) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(
                "https://api.tvmaze.com/search/shows?q=" + nombre,
                String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            List<JsonNode> TVmaze = root.findValues("show");
            for (JsonNode artist : TVmaze) {
                List<String> generos = new LinkedList<String>();
                for (JsonNode gener : artist.path("genres")) {
                    generos.add(gener.asText());
                }
                description desc = new description(
                        artist.path("language").asText(),
                        artist.path("averageRuntime").asText(),
                        generos,
                        artist.path("status").asText());
                data2 nuevo_dato = new data2(
                        artist.path("name").asText(),
                        null,
                        "Program",
                        "Api TVmaze",
                        "https://api.tvmaze.com/search/people?q=" + nombre,
                        desc);

                datos.add(nuevo_dato);
            }
            return datos;
        } catch (Exception e) {
            System.out.println("hola");
            System.out.println(e);
            return datos;
        }
    }

    static List<data2> getItunes2(String nombre, List<data2> datos) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://itunes.apple.com/search?term=" + nombre,
                String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode artistName = root.path("results");
            for (JsonNode artist : artistName) {
                List<String> generos = new LinkedList<String>();
                generos.add(artist.path("primaryGenreName").asText());
                description desc = new description(
                        null,
                        ""+artist.path("trackTimeMillis").asLong()/60000,
                        generos,
                        null);

                data2 nuevo_dato = new data2(
                        artist.path("artistName").asText(),
                        artist.path("trackName").asText(),
                        "iTunes",
                        "Api iTunes",
                        "https://itunes.apple.com/search?term=" + nombre,
                        desc);

                datos.add(nuevo_dato);
            }
            return datos;
        } catch (Exception e) {
            return datos;
        }
    }
}

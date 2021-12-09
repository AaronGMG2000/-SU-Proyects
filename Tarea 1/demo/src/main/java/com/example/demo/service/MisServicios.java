package com.example.demo.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miServicio")
public class MisServicios {

    @GetMapping(path="/holamundo/{nombre}")
    public String holamundo(@PathVariable("nombre") String nombre){
        return "hola " + nombre;       
    }

}

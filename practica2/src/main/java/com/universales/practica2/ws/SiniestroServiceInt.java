package com.universales.practica2.ws;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.library.dt.TestDto.SiniestroDto;
import com.universales.practica2.entity.Siniestro;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/siniestro")
@CrossOrigin
public interface SiniestroServiceInt {

    @GetMapping(path = "/buscar")
    public List<Siniestro> buscar();

    @PostMapping(path = "/guardar")
    public Siniestro guardar(@RequestBody SiniestroDto newSiniestro);

    @PutMapping(path = "/actualizar")
    public Siniestro actualizar(@RequestBody SiniestroDto newSiniestro);

    @DeleteMapping(path = "/eliminar/{id}")
    public void eliminar(@PathVariable("id") int id);

    @GetMapping(path = "/buscar/indermizacion/{indermizacion}")
    public List<Siniestro> buscarPorPerito(@PathVariable("indermizacion") String indermizacion);

    @GetMapping(path = "/buscar/seguro")
    public List<Siniestro> buscarPorPoliza();

    @GetMapping(path = "/buscar/perito")
    public List<Siniestro> buscarPorPerito();

    @GetMapping(path = "/buscar/fecha/despues")
    public List<Siniestro> buscarPorFechaDespues(@RequestParam Date fechaSiniestro);

    @GetMapping(path = "/buscar/fecha/antes")
    public List<Siniestro> buscarPorFechaAntes(@RequestParam Date fechaSiniestro);

    @GetMapping(path = "/query/buscar")
    public List<Map<String, Object>> buscarPorQuery();

    @PostMapping(path = "query/guardar")
    public int postMethodName(SiniestroDto newSiniestro);

    @PutMapping(value = "query/actualizar")
    public void putMethodName(SiniestroDto newSiniestro);

    @DeleteMapping(value = "query/eliminar/{idSiniestro}")
    public int deleteMethodName(@PathVariable("idSiniestro") int idSiniestro);

}

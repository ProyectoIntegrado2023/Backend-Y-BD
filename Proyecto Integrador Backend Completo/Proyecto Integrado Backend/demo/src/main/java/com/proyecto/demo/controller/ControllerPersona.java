package com.proyecto.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.demo.DTO.PersonaDTO;
import com.proyecto.demo.service.impl.ServiceImplPersona;

@RestController
@RequestMapping("/persona")


public class ControllerPersona {
       @Autowired
    @Qualifier("personaServiceImpl")
    private ServiceImplPersona serviceImplPersona;


    @GetMapping("/list")
    public List<PersonaDTO> getAll(){
        return serviceImplPersona.getAll();
        
    }

    @GetMapping("/get/{id}")
    public PersonaDTO get(@PathVariable int id){
        return serviceImplPersona.getById(id);
    }


    @PostMapping("/agregar")
    public PersonaDTO create(@RequestBody PersonaDTO personaDTO ){


        return serviceImplPersona.create(personaDTO);
    }

    @PutMapping("/editar/{id}")
    public PersonaDTO editarEs(@PathVariable int id, @RequestBody PersonaDTO personaDTO ){

        return serviceImplPersona.update(id, personaDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        serviceImplPersona.delete(id);
    }





    
}

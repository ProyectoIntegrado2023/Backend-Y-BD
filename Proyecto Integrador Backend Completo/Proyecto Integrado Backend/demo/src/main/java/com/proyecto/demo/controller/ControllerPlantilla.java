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

import com.proyecto.demo.DTO.PlantillaDTO;
import com.proyecto.demo.service.impl.ServiceImplPlantilla;

@RestController
@RequestMapping("/plantilla")

public class ControllerPlantilla {
    
      @Autowired
    @Qualifier("plantillaServiceImpl")
    private ServiceImplPlantilla serviceImplPlantilla;


    @GetMapping("/list")
    public List<PlantillaDTO> getAll(){
        return serviceImplPlantilla.getAll();
        
    }

    @GetMapping("/get/{id}")
    public PlantillaDTO get(@PathVariable int id){
        return serviceImplPlantilla.getById(id);
    }


    @PostMapping("/agregar")
    public PlantillaDTO create(@RequestBody PlantillaDTO plantillaDTO ){


        return serviceImplPlantilla.create(plantillaDTO);
    }

    @PutMapping("/editar/{id}")
    public PlantillaDTO editarEs(@PathVariable int id, @RequestBody PlantillaDTO plantillaDTO ){

        return serviceImplPlantilla.update(id, plantillaDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        serviceImplPlantilla.delete(id);
    }






   
}

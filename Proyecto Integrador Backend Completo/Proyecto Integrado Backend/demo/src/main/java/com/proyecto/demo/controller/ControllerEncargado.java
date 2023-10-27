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

import com.proyecto.demo.DTO.EncargadoDTO;
import com.proyecto.demo.service.impl.ServiceImplEncargado;

@RestController
@RequestMapping("/encargado")

public class ControllerEncargado {

    
    @Autowired
    @Qualifier("encargadoServiceImpl")
    private ServiceImplEncargado serviceImplEncargado;


    @GetMapping("/list")
    public List<EncargadoDTO> getAll(){
        return serviceImplEncargado.getAll();
        
    }

    @GetMapping("/get/{id}")
    public EncargadoDTO get(@PathVariable int id){
        return serviceImplEncargado.getById(id);
    }


    @PostMapping("/agregar")
    public EncargadoDTO create(@RequestBody EncargadoDTO encargadoDTO ){


        return serviceImplEncargado.create(encargadoDTO);
    }

    @PutMapping("/editar/{id}")
    public EncargadoDTO editarEs(@PathVariable int id, @RequestBody EncargadoDTO encargadoDTO ){

        return serviceImplEncargado.update(id, encargadoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        serviceImplEncargado.delete(id);
    }





    
}

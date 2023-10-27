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

import com.proyecto.demo.DTO.EstadoDTO;
import com.proyecto.demo.service.impl.ServiceImplEstado;

@RestController
@RequestMapping("/estado")


public class ControllerEstado {

    @Autowired
    @Qualifier("estadoServiceImpl")
    private ServiceImplEstado serviceImplEstado;


    @GetMapping("/list")
    public List<EstadoDTO> getAll(){
        return serviceImplEstado.getAll();
        
    }

    @GetMapping("/get/{id}")
    public EstadoDTO get(@PathVariable int id){
        return serviceImplEstado.getById(id);
    }


    @PostMapping("/agregar")
    public EstadoDTO create(@RequestBody EstadoDTO estadoDTO ){


        return serviceImplEstado.create(estadoDTO);
    }

    @PutMapping("/editar/{id}")
    public EstadoDTO editarEs(@PathVariable int id, @RequestBody EstadoDTO estadoDTO ){

        return serviceImplEstado.update(id, estadoDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        serviceImplEstado.delete(id);
    }






    
}

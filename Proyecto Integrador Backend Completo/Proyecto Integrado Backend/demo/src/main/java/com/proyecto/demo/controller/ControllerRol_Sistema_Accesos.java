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

import com.proyecto.demo.DTO.Rol_Sistema_AccesosDTO;
import com.proyecto.demo.service.impl.ServiceImplRol_Sistema_Accesos;

@RestController
@RequestMapping("/rol_sistema_accesos")

public class ControllerRol_Sistema_Accesos {
    @Autowired
    @Qualifier("rol_sistema_accesosServiceImpl")
    private ServiceImplRol_Sistema_Accesos serviceImplRol_Sistema_Accesos;


    @GetMapping("/list")
    public List<Rol_Sistema_AccesosDTO> getAll(){
        return serviceImplRol_Sistema_Accesos.getAll();
        
    }

    @GetMapping("/get/{id}")
    public Rol_Sistema_AccesosDTO get(@PathVariable int id){
        return serviceImplRol_Sistema_Accesos.getById(id);
    }


    @PostMapping("/agregar")
    public Rol_Sistema_AccesosDTO create(@RequestBody Rol_Sistema_AccesosDTO rol_sistema_accesosDTO ){


        return serviceImplRol_Sistema_Accesos.create(rol_sistema_accesosDTO);
    }

    @PutMapping("/editar/{id}")
    public Rol_Sistema_AccesosDTO editarEs(@PathVariable int id, @RequestBody Rol_Sistema_AccesosDTO rol_sistema_accesosDTO ){

        return serviceImplRol_Sistema_Accesos.update(id, rol_sistema_accesosDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        serviceImplRol_Sistema_Accesos.delete(id);
    }






    
}

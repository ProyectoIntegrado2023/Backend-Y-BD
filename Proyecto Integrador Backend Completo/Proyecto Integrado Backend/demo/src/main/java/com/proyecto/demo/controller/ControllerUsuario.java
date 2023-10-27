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

import com.proyecto.demo.DTO.UsuarioDTO;
import com.proyecto.demo.service.impl.ServiceImplUsuario;


@RestController
@RequestMapping("/usuario")


public class ControllerUsuario {

    @Autowired
    @Qualifier("usuarioServiceImpl")
    private ServiceImplUsuario serviceImplUsuario;


    @GetMapping("/list")
    public List<UsuarioDTO> getAll(){
        return serviceImplUsuario.getAll();
        
    }

    @GetMapping("/get/{id}")
    public UsuarioDTO get(@PathVariable int id){
        return serviceImplUsuario.getById(id);
    }


    @PostMapping("/agregar")
    public UsuarioDTO create(@RequestBody UsuarioDTO usuarioDTO ){


        return serviceImplUsuario.create(usuarioDTO);
    }

    @PutMapping("/editar/{id}")
    public UsuarioDTO editarEs(@PathVariable int id, @RequestBody UsuarioDTO usuarioDTO ){

        return serviceImplUsuario.update(id, usuarioDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        serviceImplUsuario.delete(id);
    }




    
}

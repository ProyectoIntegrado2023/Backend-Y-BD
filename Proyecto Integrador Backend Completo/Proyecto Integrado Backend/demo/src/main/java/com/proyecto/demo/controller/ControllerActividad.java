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

import com.proyecto.demo.DTO.ActividadesDTO;
import com.proyecto.demo.service.impl.ServiceimplActividad;


@RestController
@RequestMapping("/actividad")



public class ControllerActividad {

        @Autowired
        @Qualifier("actividadServiceImpl")
        private ServiceimplActividad serviceimplActividad;



    @GetMapping("/list")
    public List<ActividadesDTO> getAll(){
        return serviceimplActividad.getAll();
        
    }

    @GetMapping("/get/{id}")
    public ActividadesDTO get(@PathVariable int id){
        return serviceimplActividad.getById(id);
    }


    @PostMapping("/agregar")
    public ActividadesDTO create(@RequestBody ActividadesDTO actividadDTO ){


        return serviceimplActividad.create(actividadDTO);
    }

    @PutMapping("/editar/{id}")
    public ActividadesDTO editarEs(@PathVariable int id, @RequestBody ActividadesDTO actividadDTO ){

        return serviceimplActividad.update(id, actividadDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        serviceimplActividad.delete(id);
    }






    
}

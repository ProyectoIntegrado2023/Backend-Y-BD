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

import com.proyecto.demo.DTO.Actividad_ParticipanteDTO;
import com.proyecto.demo.service.impl.ServiceImplActividad_Participante;

@RestController
@RequestMapping("/actividad_participante")



public class ControllerActividad_Participante {



      @Autowired
    @Qualifier("actividad_participanteServiceImpl")
    private ServiceImplActividad_Participante serviceImplActividad_Participante;


    @GetMapping("/list")
    public List<Actividad_ParticipanteDTO> getAll(){
        return serviceImplActividad_Participante.getAll();
        
    }

    @GetMapping("/get/{id}")
    public Actividad_ParticipanteDTO get(@PathVariable int id){
        return serviceImplActividad_Participante.getById(id);
    }


    @PostMapping("/agregar")
    public Actividad_ParticipanteDTO create(@RequestBody Actividad_ParticipanteDTO actividad_participanteDTO ){


        return serviceImplActividad_Participante.create(actividad_participanteDTO);
    }

    @PutMapping("/editar/{id}")
    public Actividad_ParticipanteDTO editarEs(@PathVariable int id, @RequestBody Actividad_ParticipanteDTO actividad_participanteDTO ){

        return serviceImplActividad_Participante.update(id, actividad_participanteDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        serviceImplActividad_Participante.delete(id);
    }






    
    
}

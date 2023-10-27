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

import com.proyecto.demo.DTO.CicloDTO;
import com.proyecto.demo.service.ServiceCiclo;

@RestController
@RequestMapping("/ciclo")
public class ControllerCiclo {

      @Autowired
     @Qualifier("cicloServiceImpl")
    private ServiceCiclo serviceCiclo;


    

    @GetMapping("/list")
    public List<CicloDTO> getAllCiclo(){
        return serviceCiclo.getAllCiclo();
        
    }

    @GetMapping("/get/{id}")
    public CicloDTO getCiclo(@PathVariable int id){
        return serviceCiclo.getCicloById(id);
    }


    @PostMapping("/agregar")
    public CicloDTO createCiclo(@RequestBody CicloDTO cicloDTO ){


        return serviceCiclo.createCiclo(cicloDTO);
    }

    @PutMapping("/editar/{id}")
    public CicloDTO editarEs(@PathVariable int id, @RequestBody CicloDTO cicloDTO ){

        return serviceCiclo.updateCiclo(id, cicloDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        serviceCiclo.deletCicloo(id);
    }







































    
}

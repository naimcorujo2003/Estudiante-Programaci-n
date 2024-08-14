package com.todocodeacademy.EstudianteProgramacion.controller;

import com.todocodeacademy.EstudianteProgramacion.model.Curso;
import com.todocodeacademy.EstudianteProgramacion.model.Tema;
import com.todocodeacademy.EstudianteProgramacion.service.TemaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {
    
    @Autowired
    TemaService temaServ;
    
    @GetMapping("/tema/traer")
    public List<Tema> getTema(){
        return temaServ.getTemas();
    }
    
    @PostMapping("/tema/crear")
    public String saveTema(@RequestBody Tema tem){
        
        temaServ.saveTema(tem);
        return "El tema fue creado con exito";
    }
    
    @DeleteMapping("/tema/borrar/{id_tema}")
    public String deleteTema(@PathVariable Long id_tema){
        
        temaServ.deleteTema(id_tema);
        return "El tema fue borrado con exito";
    }
    
    @PutMapping("tema/editar/{id_temaOriginal}")
    public Tema editTema(@PathVariable Long id_temaOriginal,
                            @RequestParam(required = false, name = "id") Long id_temaNuevo,
                            @RequestParam(required = false, name = "nombre") String nombreNuevo,
                            @RequestParam(required = false, name = "descripcion") String descripcionNuevo){
        
        temaServ.editTema(id_temaOriginal, id_temaNuevo, nombreNuevo, descripcionNuevo);
        Tema tem = temaServ.findTema(id_temaNuevo);
        return tem;
        
        
    }
    
}


package com.todocodeacademy.EstudianteProgramacion.controller;

import com.todocodeacademy.EstudianteProgramacion.model.Curso;
import com.todocodeacademy.EstudianteProgramacion.service.CursoService;
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
public class CursoController {
    
    @Autowired
    CursoService cursoServ;
    
    @GetMapping("/curso/traer")
    public List<Curso> getCurso(){
        return cursoServ.getCursos();
    }
    
    @PostMapping("/curso/crear")
    public String saveCurso(@RequestBody Curso cur){
        
        cursoServ.saveCurso(cur);
        return "El curso fue creado con exito";
    }
    
    @DeleteMapping("/curso/borrar/{id_curso}")
    public String deleteCurso(@PathVariable Long id_curso){
        
        cursoServ.deleteCurso(id_curso);
        return "El curso fue borrado con exito";
    }
    
    @PutMapping("curso/editar/{id_cursoOriginal}")
    public Curso editCurso(@PathVariable Long id_cursoOriginal,
                            @RequestParam(required = false, name = "id") Long id_cursoNuevo,
                            @RequestParam(required = false, name = "nombre") String nombreNuevo,
                            @RequestParam(required = false, name = "modalidad") String modalidadNueva,
                            @RequestParam(required = false, name = "fecha_fin") Date fecha_finalizacionNueva){
        cursoServ.editCurso(id_cursoOriginal, id_cursoNuevo, nombreNuevo, modalidadNueva, fecha_finalizacionNueva);
        Curso cur = cursoServ.findCurso(id_cursoNuevo);
        return cur;
    }
}

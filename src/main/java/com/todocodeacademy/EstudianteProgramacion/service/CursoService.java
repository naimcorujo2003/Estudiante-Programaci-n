package com.todocodeacademy.EstudianteProgramacion.service;

import com.todocodeacademy.EstudianteProgramacion.model.Curso;
import com.todocodeacademy.EstudianteProgramacion.repository.ICursoRepository;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService{

    @Autowired
    private ICursoRepository cursoRepo;
    
    
    @Override
    public void saveCurso(Curso cur) {
        cursoRepo.save(cur);
    }
    
    @Override
    public List<Curso> getCursos() {

        List<Curso> listaCurso = cursoRepo.findAll();
        return listaCurso;
    }
    
    @Override
    public void deleteCurso(Long id_curso) {

        cursoRepo.deleteById(id_curso);
    }

    @Override
    public Curso findCurso(Long id_curso) {

        Curso cur = cursoRepo.findById(id_curso).orElse(null);
        return cur;
    }

    @Override
    public void editCurso(Long id_cursoOriginal, Long id_cursoNuevo, String nombreNuevo, String modalidadNueva, Date fecha_finalizacionNueva) {

        Curso cur = this.findCurso(id_cursoOriginal);
        cur.setId_curso(id_cursoNuevo);
        cur.setNombre(nombreNuevo);
        cur.setModalidad(modalidadNueva);
        cur.setFecha_finalizacion(fecha_finalizacionNueva);
        this.saveCurso(cur);
    }
    
}

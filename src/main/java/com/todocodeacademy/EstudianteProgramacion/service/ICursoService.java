package com.todocodeacademy.EstudianteProgramacion.service;

import com.todocodeacademy.EstudianteProgramacion.model.Curso;
import java.util.Date;
import java.util.List;


public interface ICursoService {
    public void saveCurso(Curso cur);
    public void editCurso(Long id_cursoOriginal,
                          Long id_cursoNuevo,
                          String nombreNuevo,
                          String modalidadNueva,
                          Date fecha_finalizacionNueva);
    public List<Curso> getCursos();
    public void deleteCurso(Long id_curso);
    public Curso findCurso(Long id_curso);
}

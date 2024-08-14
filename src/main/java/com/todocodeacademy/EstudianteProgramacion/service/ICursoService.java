package com.todocodeacademy.EstudianteProgramacion.service;

import com.todocodeacademy.EstudianteProgramacion.model.Curso;
import java.util.Date;
import java.util.List;


public interface ICursoService {
    public void saveCurso(Curso cur);
    public void editCurso(Long id_cusoOriginal,
                          Long id_cusoNuevo,
                          String nombreNuevo,
                          String modalidadNueva,
                          Date fecha_finalizacionNueva);
    public List<Curso> getCursos();
    public void deleteCurso(Long id_curso);
    public Curso findCurso(Long id_curso);
}

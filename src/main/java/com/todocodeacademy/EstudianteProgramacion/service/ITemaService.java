package com.todocodeacademy.EstudianteProgramacion.service;

import com.todocodeacademy.EstudianteProgramacion.model.Tema;
import java.util.List;


public interface ITemaService {
    public void saveTema(Tema tem);
    public List<Tema> getTemas();
    public Tema findTema(Long id_tema);
    public void editTema(Long id_temaOriginal,Long id_temaNuevo,  String nombreNuevo, String descripcionNuevo);
    public void deleteTema(Long id_tema);
}

package com.todocodeacademy.EstudianteProgramacion.service;

import com.todocodeacademy.EstudianteProgramacion.model.Tema;
import com.todocodeacademy.EstudianteProgramacion.repository.ITemaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService{

    @Autowired
    ITemaRepository temaRepo;
    
    @Override
    public void saveTema(Tema tem) {
        temaRepo.save(tem);
    }

    @Override
    public List<Tema> getTemas() {

        List<Tema> listaTemas = temaRepo.findAll();
        return listaTemas;
    }

    @Override
    public void editTema(Long id_temaOriginal, Long id_temaNuevo, String nombreNuevo, String descripcionNuevo) {

        Tema tem = this.findTema(id_temaOriginal);
        tem.setId_tema(id_temaNuevo);
        tem.setNombre(nombreNuevo);
        tem.setDescripcion(descripcionNuevo);
        this.saveTema(tem);
    }

    @Override
    public void deleteTema(Long id_tema) {

        temaRepo.deleteById(id_tema);
    }

    @Override
    public Tema findTema(Long id_tema) {

        Tema tem = temaRepo.findById(id_tema).orElse(null);
        return tem;
        
    }
    
}

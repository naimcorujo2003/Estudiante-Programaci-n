package com.todocodeacademy.EstudianteProgramacion.repository;

import com.todocodeacademy.EstudianteProgramacion.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITemaRepository extends JpaRepository <Tema, Long>{
    
}

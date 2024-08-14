package com.todocodeacademy.EstudianteProgramacion.repository;

import com.todocodeacademy.EstudianteProgramacion.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository <Curso, Long> {
    
}

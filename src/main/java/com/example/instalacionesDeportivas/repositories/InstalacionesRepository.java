package com.example.instalacionesDeportivas.repositories;

import com.example.instalacionesDeportivas.entities.instalaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface InstalacionesRepository extends JpaRepository<instalaciones, Integer>{
    
}







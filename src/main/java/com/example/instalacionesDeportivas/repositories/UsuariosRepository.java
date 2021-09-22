package com.example.instalacionesDeportivas.repositories;

import com.example.instalacionesDeportivas.entities.usuarios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UsuariosRepository extends CrudRepository<usuarios, Integer>{

	Optional<usuarios> findByNombre(String nombre);


    
}

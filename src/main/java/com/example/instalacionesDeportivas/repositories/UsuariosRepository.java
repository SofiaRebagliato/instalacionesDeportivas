package com.example.instalacionesDeportivas.repositories;

import com.example.instalacionesDeportivas.entities.usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<usuarios, Integer>{

	Optional<usuarios> findByNombre(String nombre);
}

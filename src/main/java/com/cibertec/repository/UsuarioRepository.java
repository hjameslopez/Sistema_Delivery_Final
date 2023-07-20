package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query("select u from Usuario u where "
			+ "( :p_ape is '' or u.apellidos like :p_ape ) and "
			+ "( :p_dni is '' or u.dni like :p_dni ) and "
			+ "( :p_ubi is 0  or u.ubigeo.idUbigeo = :p_ubi ) ")
		public abstract List<Usuario> listaUsuarioXadu(
									 	@Param("p_ape") String ape, 
									 	@Param("p_dni") String dni,
									 	@Param("p_ubi") int ubi);
}

package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Sede;

public interface SedeRepository extends JpaRepository<Sede, Integer> {
	
	@Query("select s from Sede s where "
			+ "( :p_nom is '' or s.nombre like :p_nom ) and "
			+ "( :p_fec is '' or s.fechaRegistro like :p_fec ) and "
			+ "( :p_pai is 0  or s.pais.idPais = :p_pai ) ")
		public abstract List<Sede> listaSedeXnfp(
									 	@Param("p_nom") String nom, 
									 	@Param("p_fec") String fec,
									 	@Param("p_pai") int pais);
}

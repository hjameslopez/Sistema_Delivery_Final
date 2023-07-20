package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer>{

	@Query("select p from Proveedor p where "
			+ "( :p_ras is '' or p.razonsocial like :p_ras ) and "
			+ "( :p_ruc is '' or p.ruc like :p_ruc ) and "
			+ "( :p_ubi is 0  or p.ubigeo.idUbigeo = :p_ubi ) ")
		public abstract List<Proveedor> listaProveedorXrru(
									 	@Param("p_ras") String ras, 
									 	@Param("p_ruc") String ruc,
									 	@Param("p_ubi") int ubi);
}

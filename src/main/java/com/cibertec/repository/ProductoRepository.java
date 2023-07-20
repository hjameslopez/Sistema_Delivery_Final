package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	@Query("select p from Producto p where "
			 + "( :p_nom is '' or p.nombre like :p_nom ) AND "
			 + "( :p_mar is 0 or p.marca.idMarca = :p_mar ) AND "
			 + "( :p_pai is 0  or p.pais.idPais = :p_pai ) ")
		public abstract List<Producto> listaProductoXnmp(
									 	@Param("p_nom") String nom, 
									 	@Param("p_mar") int mar,
									 	@Param("p_pai") int pai);
}

package com.cibertec.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	@Query("Select a from Cliente a where nombre like :fil")
	public abstract List<Cliente> listaClientePorNombreLike(@Param("fil") String filtro);

	@Query("Select x from Cliente x where nombres like :var_filtro or apellidos like :var_filtro")
	public abstract List<Cliente> listaClientePorNombre2(@Param("var_filtro") String filtro, Pageable pageable);

	@Query("select c from Cliente c where "
			+ "( :p_ape is '' or c.apellidos like :p_ape ) and "
			+ "( :p_fec is '' or c.fechaRegistro like :p_fec ) and "
			+ "( :p_ubi is 0  or c.ubigeo.idUbigeo = :p_ubi ) ")
		public abstract List<Cliente> listaClienteXafu(
									 	@Param("p_ape") String ape, 
									 	@Param("p_fec") String fec,
									 	@Param("p_ubi") int ubi);
}
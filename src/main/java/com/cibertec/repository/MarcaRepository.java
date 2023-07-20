package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cibertec.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer>{

	@Query("Select a from Marca a where nombre like :fil")
	public abstract List<Marca> listaClientePorNombreLike(@Param("fil") String filtro);
	
	@Query("select m from Marca m where "
			+ "( :p_nom is '' or m.nombre like :p_nom ) and "
			+ "( :p_cer is '' or m.certificado like :p_cer ) and "
			+ "( :p_pai is 0  or m.pais.idPais = :p_pai ) ")
		public abstract List<Marca> listaMarcaXncp(
									 	@Param("p_nom") String nom, 
									 	@Param("p_cer") String cer,
									 	@Param("p_pai") int pais);
}

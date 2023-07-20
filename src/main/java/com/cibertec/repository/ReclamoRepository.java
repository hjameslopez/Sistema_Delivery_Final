package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cibertec.entity.Reclamo;

public interface ReclamoRepository extends JpaRepository<Reclamo, Integer>{
	@Query("select r from Reclamo r where "
			 + "( :p_fec is '' or r.fechaRegistro like :p_fec ) AND "
			 + "( :p_cli is 0 or r.cliente.idCliente = :p_cli ) AND "
			 + "( :p_tip is 0  or r.tipoReclamo.idTipoReclamo = :p_tip ) ")
		public abstract List<Reclamo> listaReclamoXfct(
									 	@Param("p_fec") String fechaRegistro, 
									 	@Param("p_cli") int cliente,
									 	@Param("p_tip") int TipoReclamo);
}

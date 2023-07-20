package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Marca;

public interface MarcaService {

	public abstract List<Marca> listaMarca();
	public Marca resgistrarMarca(Marca obj);
	public abstract List<Marca> listaMarcaXncp(String nom,String cer, int pais);
}

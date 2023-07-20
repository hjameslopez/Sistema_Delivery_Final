package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Sede;

public interface SedeService {

	public abstract List<Sede> listaSedes();
	public Sede insertarSede(Sede obj);
	public abstract List<Sede> listaSedeXnfp(String nom, String fec, int pai);
}

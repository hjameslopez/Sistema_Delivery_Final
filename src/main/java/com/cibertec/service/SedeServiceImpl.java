package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Sede;
import com.cibertec.repository.SedeRepository;

@Service
public class SedeServiceImpl implements SedeService{

	@Autowired
	private SedeRepository repositorio;
	
	@Override
	public List<Sede> listaSedes() {
		return repositorio.findAll();
	}

	@Override
	public Sede insertarSede(Sede obj) {
		return repositorio.save(obj);
	}

	@Override
	public List<Sede> listaSedeXnfp(String nom, String fec, int pai) {
		return repositorio.listaSedeXnfp(nom, fec, pai);
	}

}

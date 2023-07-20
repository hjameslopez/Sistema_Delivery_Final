package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Reclamo;
import com.cibertec.repository.ReclamoRepository;

@Service
public class ReclamoServiceImpl implements ReclamoService {
	
	@Autowired
	private ReclamoRepository repositorio;
	
	@Override
	public Reclamo insertarReclamo(Reclamo obj) {
		return repositorio.save(obj);
	}

	@Override
	public List<Reclamo> listarReclamos() {
		return repositorio.findAll();
	}

	@Override
	public List<Reclamo> listaReclamoXfct(String fecha, int cli, int tipo) {
		
		return repositorio.listaReclamoXfct(fecha, cli, tipo);
	}
}

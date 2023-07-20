package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Proveedor;
import com.cibertec.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository repository;

	@Override
	public List<Proveedor> listaProveedor() {
		return repository.findAll();
	}

	@Override
	public Proveedor insertaProveedor(Proveedor obj) {
		return repository.save(obj);
	}

	@Override
	public List<Proveedor> listaProveedorXruu(String ras, String ruc, int ubi) {
		return repository.listaProveedorXrru(ras, ruc, ubi);
	}
	
	

}

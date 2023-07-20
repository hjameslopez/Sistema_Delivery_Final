package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Cliente;
import com.cibertec.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	
	@Autowired
	private ClienteRepository repository;

	@Override
	public List<Cliente> listaCliente() {
		return repository.findAll();
	}
	
	@Override
	public Cliente insertarCliente(Cliente obj) {
		return repository.save(obj);
	}

	@Override
	public List<Cliente> listaClienteXafu(String ape, String fec, int ubi) {
		return repository.listaClienteXafu(ape, fec, ubi);
	}
	

}

package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Cliente;

public interface ClienteService {
	
	public abstract List<Cliente> listaCliente();
	public Cliente insertarCliente(Cliente obj);
	public abstract List<Cliente> listaClienteXafu(String ape,String fec, int ubi);
}

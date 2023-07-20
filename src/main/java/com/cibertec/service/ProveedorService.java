package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Proveedor;

public interface ProveedorService {
	public abstract List<Proveedor> listaProveedor();
	public Proveedor insertaProveedor(Proveedor obj);
	public abstract List<Proveedor> listaProveedorXruu(String ras, String ruc, int ubi);
}

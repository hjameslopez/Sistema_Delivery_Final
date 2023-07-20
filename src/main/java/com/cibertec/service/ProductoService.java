package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Producto;

public interface ProductoService {
	public abstract List<Producto> listaProducto();
	public Producto registrarProducto(Producto obj);
	public abstract List<Producto> listaProductoXnmp(String nom, int mar,int pai);
}

package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Producto;
import com.cibertec.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository repositorio;
	
	@Override
	public List<Producto> listaProducto() {
		return repositorio.findAll();
	}

	@Override
	public Producto registrarProducto(Producto obj) {
		return repositorio.save(obj);
	}

	@Override
	public List<Producto> listaProductoXnmp(String nom, int mar, int pai) {
		return repositorio.listaProductoXnmp(nom, mar, pai);
	}

	

}

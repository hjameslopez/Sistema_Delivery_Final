package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Usuario;
import com.cibertec.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repositorio;
	
	@Override
	public List<Usuario> listarUsuarios() {
		return repositorio.findAll();
	}

	@Override
	public Usuario insertarUsuario(Usuario obj) {
		return repositorio.save(obj);
	}

	@Override
	public List<Usuario> listaUsuarioXadu(String ape, String dni, int ubi) {
		return repositorio.listaUsuarioXadu(ape, dni, ubi);
	}

}

package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Usuario;

public interface UsuarioService {
	public abstract List<Usuario> listarUsuarios();
	public Usuario insertarUsuario(Usuario obj);
	public abstract List<Usuario> listaUsuarioXadu(String ape, String dni, int ubi);
}

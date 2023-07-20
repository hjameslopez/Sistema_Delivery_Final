package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Reclamo;


public interface ReclamoService {
	public Reclamo insertarReclamo (Reclamo obj);
	public List<Reclamo> listarReclamos();
	public abstract List<Reclamo> listaReclamoXfct(String fecha,int cli, int tipo);
}

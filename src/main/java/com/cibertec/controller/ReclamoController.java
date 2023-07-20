package com.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entity.Reclamo;
import com.cibertec.service.ReclamoService;

@RestController
@RequestMapping("/url/reclamo")
@CrossOrigin(origins = "http://localhost:4200")
public class ReclamoController {
	@Autowired
	private ReclamoService reclamoService;

	@GetMapping("/listaReclamos")
	@ResponseBody
	public ResponseEntity<List<Reclamo>> listaReclamos(){
		List<Reclamo> lista = reclamoService.listarReclamos();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/registrarReclamo")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaReclamos(@RequestBody Reclamo obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Reclamo objSalida = reclamoService.insertarReclamo(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL REGISTRAR RECLAMO :(");
			}else {
				salida.put("mensaje", "RECLAMO REGISTRADO EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL REGISTRAR RECLAMO :(");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/ConsultaFCTwithParam")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaXfctWithParam(
			@RequestParam(value = "fechaRegistro", required = false, defaultValue = "") String fecha,
			@RequestParam(value = "idCliente", required = false, defaultValue = "0") int cli,
			@RequestParam(value = "idTipoReclamo", required = false, defaultValue = "0") int tipo) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Reclamo> lista = reclamoService.listaReclamoXfct(fecha+"%", cli, tipo);
			if(CollectionUtils.isEmpty(lista)){
				salida.put("mensaje", "NO HAY COINCIDENCIA CON NINGÚN RECLAMO");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "SE OBTUVIERON " + lista.size() + " RECLAMOS");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error : " + e.getMessage());
		}
		
		return ResponseEntity.ok(salida);
	} 
	
	@PutMapping("/actualizarReclamo")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Reclamo obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Reclamo objSalida = reclamoService.insertarReclamo(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL ACTUALIZAR RECLAMO");
			} else {
				salida.put("mensaje", "RECLAMO ACTUALIZADO EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL ACTUALIZAR RECLAMO");
		}
		return ResponseEntity.ok(salida);
	}

}

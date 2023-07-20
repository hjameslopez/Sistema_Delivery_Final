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

import com.cibertec.entity.Sede;
import com.cibertec.service.SedeService;

@RestController
@RequestMapping("/url/sede")
@CrossOrigin(origins = "http://localhost:4200")
public class SedeController {
	
	@Autowired
	private SedeService sedeService;
	
	@PostMapping("/registrarSede")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registrarrSede(@RequestBody Sede obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Sede objSalida = sedeService.insertarSede(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL REGISTRAR SEDE");
			}else {
				salida.put("mensaje", "SEDE REGISTRADO EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL REGISTRAR SEDE");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/ConsultaNFPwithParam")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaXnfpWithParam(
			@RequestParam(value = "nombre", required = false, defaultValue = "") String nom,
			@RequestParam(value = "fechaRegistro", required = false, defaultValue = "") String fec,
			@RequestParam(value = "idPais", required = false, defaultValue = "0") int pais) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Sede> lista = sedeService.listaSedeXnfp("%"+nom+"%", fec+"%", pais);
			if(CollectionUtils.isEmpty(lista)){
				salida.put("mensaje", "NO HAY COINCIDENCIA CON NINGUNA SEDE");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "SE OBTUVIERON " + lista.size() + " SEDE(S)");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error : " + e.getMessage());
		}
		
		return ResponseEntity.ok(salida);
	} 
	
	@PutMapping("/actualizarSede")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Sede obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Sede objSalida = sedeService.insertarSede(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL ACTUALIZAR SEDE");
			} else {
				salida.put("mensaje", "SEDE ACTUALIZADO EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL ACTUALIZAR SEDE");
		}
		return ResponseEntity.ok(salida);
	}
}

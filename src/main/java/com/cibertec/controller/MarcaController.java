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

import com.cibertec.entity.Marca;
import com.cibertec.service.MarcaService;


@RestController
@RequestMapping("/url/marca")
@CrossOrigin(origins = "http://localhost:4200")
public class MarcaController {
	

	@Autowired
	private MarcaService marcaService;
	
	@PostMapping("/registraMarca")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertarMarca(@RequestBody Marca obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Marca objSalida = marcaService.resgistrarMarca(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL REGISTRAR MARCA");
			}else {
				salida.put("mensaje", "MARCA REGISTRADA EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL REGISTRAR MARCA");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/ConsultaNCPwithParam")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaXncpWithParam(
			@RequestParam(value = "nombre", required = false, defaultValue = "") String nom,
			@RequestParam(value = "certificado", required = false, defaultValue = "") String cer,
			@RequestParam(value = "idPais", required = false, defaultValue = "0") int pais) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Marca> lista = marcaService.listaMarcaXncp("%"+nom+"%", "%"+cer+"%", pais);
			if(CollectionUtils.isEmpty(lista)){
				salida.put("mensaje", "NO HAY COINCIDENCIA CON NINGUNA MARCA");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "SE OBTUVIERON " + lista.size() + " MARCA(S)");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error : " + e.getMessage());
		}
		
		return ResponseEntity.ok(salida);
	} 
	
	@PutMapping("/actualizarMarca")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Marca obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Marca objSalida = marcaService.resgistrarMarca(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL ACTUALIZAR MARCA");
			} else {
				salida.put("mensaje", "MARCA ACTUALIZADA EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL ACTUALIZAR MARCA");
		}
		return ResponseEntity.ok(salida);
	}
}

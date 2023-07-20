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

import com.cibertec.entity.Proveedor;
import com.cibertec.service.ProveedorService;

@RestController
@RequestMapping("/url/proveedor")
@CrossOrigin(origins = "http://localhost:4200")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorService;
	
	@PostMapping("/registraProveedor")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertarProveedores(@RequestBody Proveedor obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Proveedor objSalida = proveedorService.insertaProveedor(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL REGISTRAR PROVEEDOR");
			}else {
				salida.put("mensaje", "PROVEEDOR REGISTRADO EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL REGISTRAR PROVEEDOR");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/ConsultaRRUwithParam")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaXrruWithParam(
			@RequestParam(value = "razonsocial", required = false, defaultValue = "") String ras,
			@RequestParam(value = "ruc", required = false, defaultValue = "") String ruc,
			@RequestParam(value = "idUbigeo", required = false, defaultValue = "0") int ubi) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Proveedor> lista = proveedorService.listaProveedorXruu("%"+ras+"%", "%"+ruc+"%", ubi);
			if(CollectionUtils.isEmpty(lista)){
				salida.put("mensaje", "NO HAY COINCIDENCIA CON NINGÚN PROVEEDOR");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "SE OBTUVIERON " + lista.size() + " PROVEEDOR(ES)");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error : " + e.getMessage());
		}
		
		return ResponseEntity.ok(salida);
	} 
	
	@PutMapping("/actualizarProveedor")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Proveedor obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Proveedor objSalida = proveedorService.insertaProveedor(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL ACTUALIZAR PROVEEDOR");
			} else {
				salida.put("mensaje", "PROVEEDOR ACTUALIZADO EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL ACTUALIZAR PROVEEDOR");
		}
		return ResponseEntity.ok(salida);
	}
}

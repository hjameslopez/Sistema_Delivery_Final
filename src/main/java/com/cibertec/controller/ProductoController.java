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

import com.cibertec.entity.Producto;
import com.cibertec.service.ProductoService;



@RestController
@RequestMapping("/url/producto")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@PostMapping("/registrarProducto")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertarProducto(@RequestBody Producto obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Producto objSalida = productoService.registrarProducto(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL REGISTRAR PRODUCTO");
			}else {
				salida.put("mensaje", "PRODUCTO REGISTRADO EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL REGISTRAR PRODUCTO");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/ConsultaNMPwithParam")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaXnmpWithParam(
			@RequestParam(value = "nombre", required = false, defaultValue = "") String nom,
			@RequestParam(value = "idMarca", required = false, defaultValue = "0") int marca,
			@RequestParam(value = "idPais", required = false, defaultValue = "0") int pais) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Producto> lista = productoService.listaProductoXnmp("%"+nom+"%", marca, pais);
			if(CollectionUtils.isEmpty(lista)){
				salida.put("mensaje", "NO HAY COINCIDENCIA CON NINGÚN PRODUCTO");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "SE OBTUVIERON " + lista.size() + " PRODUCTO(S)");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error : " + e.getMessage());
		}
		
		return ResponseEntity.ok(salida);
	} 
	
	@PutMapping("/actualizarProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Producto obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Producto objSalida = productoService.registrarProducto(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL ACTUALIZAR PRODUCTO");
			} else {
				salida.put("mensaje", "PRODUCTO ACTUALIZADO EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL ACTUALIZAR PRODUCTO");
		}
		return ResponseEntity.ok(salida);
	}
}

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

import com.cibertec.entity.Cliente;
import com.cibertec.service.ClienteService;

@RestController
@RequestMapping("/url/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping("/registraCliente")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaClientes(@RequestBody Cliente obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Cliente objSalida = clienteService.insertarCliente(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL REGISTRAR CLIENTE");
			}else {
				salida.put("mensaje", "CLIENTE REGISTRADO EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL REGISTRAR CLIENTE");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/ConsultaAFUwithParam")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaXafuWithParam(
			@RequestParam(value = "apellidos", required = false, defaultValue = "") String ape,
			@RequestParam(value = "fechaRegistro", required = false, defaultValue = "") String fec,
			@RequestParam(value = "idUbigeo", required = false, defaultValue = "0") int ubi) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Cliente> lista = clienteService.listaClienteXafu("%"+ape+"%", fec+"%", ubi);
			if(CollectionUtils.isEmpty(lista)){
				salida.put("mensaje", "NO HAY COINCIDENCIA CON NINGÚN CLIENTE");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "SE OBTUVIERON " + lista.size() + " CLIENTES");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error : " + e.getMessage());
		}
		
		return ResponseEntity.ok(salida);
	} 
	
	@PutMapping("/actualizarCliente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Cliente obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Cliente objSalida = clienteService.insertarCliente(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL ACTUALIZAR EL CLIENTE");
			} else {
				salida.put("mensaje", "CLIENTE ACTUALIZADO EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL ACTUALIZAR EL CLIENTE :(");
		}
		return ResponseEntity.ok(salida);
	}
	 
}

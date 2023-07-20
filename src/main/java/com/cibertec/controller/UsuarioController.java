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

import com.cibertec.entity.Usuario;
import com.cibertec.service.UsuarioService;



@RestController
@RequestMapping("/url/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/registrarUsuario")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> ingresaUsuario(@RequestBody Usuario obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Usuario objSalida = usuarioService.insertarUsuario(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL REGISTRAR USUARIO");
			}else {
				salida.put("mensaje", "USUARIO REGISTRADO EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL REGISTRAR USUARIO");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/ConsultaADUwithParam")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaXaduWithParam(
			@RequestParam(value = "apellidos", required = false, defaultValue = "") String ape,
			@RequestParam(value = "dni", required = false, defaultValue = "") String dni,
			@RequestParam(value = "idUbigeo", required = false, defaultValue = "0") int ubi) {
		
		Map<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Usuario> lista = usuarioService.listaUsuarioXadu("%"+ape+"%", dni+"%", ubi);
			if(CollectionUtils.isEmpty(lista)){
				salida.put("mensaje", "NO HAY COINCIDENCIA CON NINGÚN USUARIO");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "SE OBTUVIERON " + lista.size() + " USUARIO(S)");
			}
		} catch (Exception e) {
			salida.put("mensaje", "Error : " + e.getMessage());
		}
		
		return ResponseEntity.ok(salida);
	} 
	
	@PutMapping("/actualizarUsuario")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Usuario obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Usuario objSalida = usuarioService.insertarUsuario(obj);
			if (objSalida == null) {
				salida.put("mensaje", "ERROR AL ACTUALIZAR USUARIO");
			} else {
				salida.put("mensaje", "USUARIO ACTUALIZADO EXITOSAMENTE");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "ERROR AL ACTUALIZAR USUARIO");
		}
		return ResponseEntity.ok(salida);
	}
}

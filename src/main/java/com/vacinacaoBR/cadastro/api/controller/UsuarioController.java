package com.vacinacaoBR.cadastro.api.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vacinacaoBR.cadastro.domain.service.CadastroUsuarioService;
import com.vacinacaoBR.cadastro.dto.UsuarioDTO;

@RestController
@RequestMapping("/cadastro-usuario")
public class UsuarioController {
	
	@Autowired
	CadastroUsuarioService cadastroUsuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO usuario, UriComponentsBuilder uriBuilder) {
		UsuarioDTO usuarioDto = new UsuarioDTO(cadastroUsuarioService.create(UsuarioDTO.converter(usuario)));
		URI uri = uriBuilder.path("/cadastro-usuario/{id}").buildAndExpand(usuarioDto.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);
	}
	//@PostMapping
	//public UsuarioDTO criate(@Valid @RequestBody UsuarioDTO usuarioDTO){ 
	//	return new UsuarioDTO(cadastroUsuarioService.create(UsuarioDTO.converter(usuarioDTO)));
	//}

}

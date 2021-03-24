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

import com.vacinacaoBR.cadastro.domain.service.CadastroVacinaService;
import com.vacinacaoBR.cadastro.dto.VacinaDTO;

@RestController
@RequestMapping("/cadastro-vacina")
public class VacinaController {
	
	@Autowired
	CadastroVacinaService cadastroVacinaService;
	
	@PostMapping()
	public ResponseEntity<VacinaDTO> create(@Valid @RequestBody VacinaDTO vacinaDTO, UriComponentsBuilder uriBuilder) {
		VacinaDTO vacina = new VacinaDTO(cadastroVacinaService.create(VacinaDTO.converter(vacinaDTO)));
		URI uri = uriBuilder.path("/cadastro-vacina/{id}").buildAndExpand(vacina.getId()).toUri();
			return ResponseEntity.created(uri).body(vacina);
	}
	
	//@PostMapping
	//public VacinaDTO create(@Valid @RequestBody VacinaDTO vacinaDTO){
	//	return new VacinaDTO(cadastroVacinaService.create(VacinaDTO.converter(vacinaDTO)));
	//}

}

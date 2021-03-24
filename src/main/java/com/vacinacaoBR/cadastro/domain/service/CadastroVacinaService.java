package com.vacinacaoBR.cadastro.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacinacaoBR.cadastro.domain.model.Vacina;
import com.vacinacaoBR.cadastro.domain.repository.VacinaRepository;

@Service
public class CadastroVacinaService {
	
	@Autowired
	VacinaRepository vacinaRepository;
	
	public Vacina create(Vacina vacina) {
		return vacinaRepository.save(vacina);
	}

}

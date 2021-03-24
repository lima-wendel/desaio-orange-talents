package com.vacinacaoBR.cadastro.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.vacinacaoBR.cadastro.domain.model.Vacina;

public class VacinaDTO {
	
	private Long id;
	
	@NotBlank
	private String nomeVacina;
	
	@NotBlank
	@Email
	private String usuarioEmail;
	
	@NotNull
	private LocalDate dataAplicacao;
	
public VacinaDTO() {}
	
	public VacinaDTO(Vacina vacina) {
		this.id = vacina.getId();
		this.nomeVacina = vacina.getVacina();
		this.usuarioEmail = vacina.getUsuarioEmail();
		this.dataAplicacao = vacina.getDataAplicacao();
	}
	
	public static Vacina converter(VacinaDTO vacinaDTO){
		Vacina vacina = new Vacina();
		vacina.setVacina(vacinaDTO.getNomeVacina());
		vacina.setUsuarioEmail(vacinaDTO.getUsuarioEmail());
		vacina.setDataAplicacao(vacinaDTO.getDataAplicacao());
		return vacina;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public String getUsuarioEmail() {
		return usuarioEmail;
	}

	public void setUsuarioEmail(String usuarioEmail) {
		this.usuarioEmail = usuarioEmail;
	}

	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}

	public void setDataAplicacao(LocalDate dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VacinaDTO other = (VacinaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

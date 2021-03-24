package com.vacinacaoBR.cadastro.domain.exception;

public class RespostaErro {
	
	private String campo;
	private String erro;
	
	public RespostaErro(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public String getErro() {
		return erro;
	}

}

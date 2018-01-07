package org.ufpb.projetoayla.meuProjetoWeb.model;

import java.util.Date;

public class Contexto {

	private Long id;
	private String palavra_contexto;
	private String imagem;
	private String id_usuario;
	private Date data;
	
	public Contexto(Long id, String palavra_contexto, String imagem, String id_usuario) {
		this.id = id;
		this.palavra_contexto = palavra_contexto;
		this.imagem = imagem;
		this.id_usuario = id_usuario;
	}
	
	public Contexto() {
		
	}
		
	public Long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getPalavra_contexto() {
		return palavra_contexto;
	}
	
	public void setPalavra_contexto(String palavra_contexto) {
		this.palavra_contexto = palavra_contexto;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public String getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	
}

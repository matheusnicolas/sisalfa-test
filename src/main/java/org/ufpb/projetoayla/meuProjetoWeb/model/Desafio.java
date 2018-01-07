package org.ufpb.projetoayla.meuProjetoWeb.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Desafio{
	
	private long id;
	private String palavra_desafio;
	private String imagem;
	private String id_usuario;
	private Date data;
	
	public Desafio(long id, String palavra_desafio, String imagem, String id_usuario){
		this.id = id;
		this.palavra_desafio = palavra_desafio;
		this.imagem = imagem;
		this.id_usuario = id_usuario;
	}
	
	public Desafio(){
		
	}
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getPalavra_desafio() {
		return palavra_desafio;
	}

	public void setPalavra_desafio(String palavra_desafio) {
		this.palavra_desafio = palavra_desafio;
	}

	public String getImagem() {
		return this.imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public String getId_usuario() {
		return this.id_usuario;
	}
	
	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public Date getCreated(){
		return this.data;
	}

	
}
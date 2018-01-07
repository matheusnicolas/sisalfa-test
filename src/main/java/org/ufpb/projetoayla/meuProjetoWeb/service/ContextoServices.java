package org.ufpb.projetoayla.meuProjetoWeb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.ufpb.projetoayla.meuProjetoWeb.database.DatabaseClass;
import org.ufpb.projetoayla.meuProjetoWeb.exception.DataNotFoundException;
import org.ufpb.projetoayla.meuProjetoWeb.model.Contexto;

public class ContextoServices {
	
	private Map<Long, Contexto> contextos = DatabaseClass.getContextos();
	
	public ContextoServices() {
		contextos.put(1L, new Contexto(1L, "Esporte", "https://i.imgur.com/7MW91Y2.jpg", "1"));
		contextos.put(2L, new Contexto(2L, "Circo", "https://imgur.com/a/o8dJo", "2"));
		contextos.put(3L, new Contexto(3L, "Escola", "https://imgur.com/a/WdDAC", "3"));
	}
	
	public List<Contexto> getAllContextos(){
		return new ArrayList<Contexto>(contextos.values());
	}
	
	public Contexto getContexto(long id) {
		Contexto contexto = contextos.get(id);
		if(contexto == null) {
			throw new DataNotFoundException("O contexo de id " + id + " não foi encontrado");
		}
		return contexto;
	}
	
	public Contexto addContexto(Contexto contexto) {
		contexto.setId(contextos.size() + 1);
		contextos.put(contexto.getId(), contexto);
		return contexto;		
	}
	
	public Contexto updateContexto(Contexto contexto) {
		if(contexto.getId() <= 0) {
			return null;
		}
		contextos.put(contexto.getId(), contexto);
		return contexto;
	}
	
	public Contexto removeContexto(long id) {
		return contextos.remove(id);
	}
}

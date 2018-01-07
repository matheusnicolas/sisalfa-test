package org.ufpb.projetoayla.meuProjetoWeb.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.ufpb.projetoayla.meuProjetoWeb.database.DatabaseClass;
import org.ufpb.projetoayla.meuProjetoWeb.exception.DataNotFoundException;
import org.ufpb.projetoayla.meuProjetoWeb.model.Desafio;

public class DesafioServices {
	
	private Map<Long, Desafio> desafios = DatabaseClass.getDesafios();
	
	public DesafioServices(){
		desafios.put(1L, new Desafio(1, "Bola", "https://imgur.com/a/pMlMs", "1"));
		desafios.put(2L, new Desafio(2, "Palhaço", "https://imgur.com/a/o8yE8", "2"));
		desafios.put(3L, new Desafio(3, "Lousa", "https://imgur.com/a/JHxcY", "3"));
	}

	public List<Desafio> getAllDesafios(){
		return new ArrayList<Desafio>(desafios.values());
	}
	
	public List<Desafio> getAllDesafiosForYear(int year){
		List <Desafio> desafiosForYear = new ArrayList<>();
		Calendar calendario = Calendar.getInstance();
		for(Desafio desafio: desafios.values()){
			calendario.setTime(desafio.getCreated());
			if(calendario.get(Calendar.YEAR) == year){
				desafiosForYear.add(desafio);
			}
		}
		return desafiosForYear;
	}
	
	public List<Desafio> getAllDesafiosPaginated(int start, int size){
		ArrayList<Desafio> list = new ArrayList<Desafio>(desafios.values());
		if((start + size) > list.size()){
			return new ArrayList<Desafio>();
		}
		return list.subList(start, start + size);
	}
	
	public Desafio getDesafio(long id){
		Desafio desafio = desafios.get(id);
		if(desafio == null){
			throw new DataNotFoundException("O desafio de id " + id + " nao foi encontrado");
		}
		return desafio;
	}
	
	public Desafio addDesafio(Desafio desafio){
		desafio.setId(desafios.size() + 1);
		desafios.put(desafio.getId(), desafio);
		return desafio;
	}
	
	public Desafio updateDesafio(Desafio desafio){
		if(desafio.getId() <= 0){
			return null;
		}
		desafios.put(desafio.getId(), desafio);
		return desafio;
	}
	
	public Desafio removeDesafio(long id){
		return desafios.remove(id);
	}
}
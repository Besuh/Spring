package com.besuh.DojosNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.besuh.DojosNinjas.models.Ninja;
import com.besuh.DojosNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private NinjaRepository nr;
	public NinjaService(NinjaRepository nr) {
		this.nr = nr;
	}
	public List<Ninja> allNinjas() {
		return (List<Ninja>) nr.findAll();
	}
	public void addNinja(Ninja ninja) {
		nr.save(ninja);
	}
	public void destroyDojo(Integer id) {
		System.out.println(id);
		nr.deleteById(id);
	}
	public Ninja findNinjaById(Integer id) {
		return nr.findById(id).orElse(null);
	}
	public List<Ninja> findNinjasByDojo(Integer id){
		return (List<Ninja>) nr.findDistinctNinjasByDojoID(id);
	}
	public void updateDojo(Ninja ninja) {
		nr.save(ninja);
	}

}

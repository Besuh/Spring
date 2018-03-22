package com.besuh.DojosNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.besuh.DojosNinjas.models.Dojo;
import com.besuh.DojosNinjas.repositories.DojoRepository;
import com.besuh.DojosNinjas.repositories.NinjaRepository;

@Service
public class DojoService {
	private DojoRepository dr;
	private NinjaRepository nr;
	public DojoService(DojoRepository dr, NinjaRepository nr) {
		this.dr = dr;
		this.nr = nr;
	}
	public List<Dojo> allDojos() {
		return (List<Dojo>) dr.findAll();
	}
	public void addDojo(Dojo dojo) {
		dr.save(dojo);
	}
	public void destroyDojo(Integer id) {
		System.out.println(id);
		dr.deleteById(id);
	}
	public Dojo findDojoById(Integer id) {
		return dr.findById(id).orElse(null);
	}
	public void updateDojo(Dojo dojo) {
		dr.save(dojo);
	}
}

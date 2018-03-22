package com.besuh.Crud.services;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.besuh.Crud.models.Language;
import com.besuh.Crud.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository languageRepository;
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
//	private List<Language> languages = new ArrayList<Language>(Arrays.asList(
//			new Language("Python", "Kobayashi", 1.8),
//			new Language("Java", "Bean", 1.3)
//			));
	public List<Language> allLanguages() {
		return (List<Language>) languageRepository.findAll();
	}
	public void addLanguage(Language language) {
		languageRepository.save(language);
	}
	public void destroyLanguage(Integer id) {
		System.out.println(id);
		languageRepository.deleteById(id);
	}
	public Language findLanguageById(Integer id) {
		return languageRepository.findById(id).orElse(null);
	}
	public void updateLanguage(Language language) {
		languageRepository.save(language);
	}
}

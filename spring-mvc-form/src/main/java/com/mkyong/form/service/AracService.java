package com.mkyong.form.service;

import java.util.List;

import com.mkyong.form.model.Arac;

public interface AracService {

	Arac findById(Integer id);
	
	List<Arac> findAll();

	void saveOrUpdate(Arac user);
	
	void delete(int id);
	
}
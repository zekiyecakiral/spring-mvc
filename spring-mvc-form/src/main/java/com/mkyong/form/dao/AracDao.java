package com.mkyong.form.dao;

import java.util.List;

import com.mkyong.form.model.Arac;

public interface AracDao {
	
	Arac findById(Integer id);

	List<Arac> findAll();

	void save(Arac arac);

	void update(Arac arac);

	void delete(Integer id);

}

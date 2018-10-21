package com.mkyong.form.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkyong.form.dao.AracDao;
import com.mkyong.form.model.Arac;

@Service("aracService")
public class AracServiceImpl implements AracService {

	AracDao aracDao;

	@Autowired
	public void setAracDao(AracDao aracDao) {
		this.aracDao = aracDao;
	}

	@Override
	public Arac findById(Integer id) {
		return aracDao.findById(id);
	}

	@Override
	public List<Arac> findAll() {
		return aracDao.findAll();
	}

	@Override
	public void saveOrUpdate(Arac arac) {

		if (findById(arac.getId())==null) {
			aracDao.save(arac);
		} else {
			aracDao.update(arac);
		}

	}

	@Override
	public void delete(int id) {
		aracDao.delete(id);
	}

}
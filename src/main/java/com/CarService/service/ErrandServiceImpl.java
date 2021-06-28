package com.CarService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarService.dao.ErrandDao;
import com.CarService.model.Errand;

@Service
@Transactional
public class ErrandServiceImpl implements ErrandService {

	@Autowired
	private ErrandDao errandDao;
	
	@Override
	public Errand createErrand(Errand errand) {
		return errandDao.createErrand(errand);
	}

	@Override
	public void updateErrand(Errand errand) {
		errandDao.updateErrand(errand);
	}
	
	@Override
	public List<Errand> getAllErrands(){
		return errandDao.getAllErrands();
	}
	
	@Override
	public Errand getErrand(int errandId) {
		return errandDao.getErrand(errandId);
	}
	
	@Override
	public List<Errand> getAllErrandsWithStatus(String status){
		return errandDao.getAllErrandsWithStatus(status);
	}
}

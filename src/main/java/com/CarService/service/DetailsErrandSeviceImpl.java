package com.CarService.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CarService.dao.DetailsErrandDao;
import com.CarService.model.DetailsErrand;

@Service
@Transactional
public class DetailsErrandSeviceImpl implements DetailsErrandSevice{
	
	@Autowired
	private DetailsErrandDao detailsErrandDao;
	
	@Override
	public void CreateDetailsErrand (DetailsErrand detailsErrand) {
		detailsErrandDao.createDetailsErrand(detailsErrand);
	}
	
	@Override
	public List<DetailsErrand> getAllDetailsErrandWithIdErrand(int errandId){
		return detailsErrandDao.getAllDetailsErrandWithIdErrand(errandId);
	}
}

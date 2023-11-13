package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.entity.Manufacturer;
import com.sm.repository.IManufacturerRepository;

@Service
public class ManufacturerService implements IManufacturerService {

	@Autowired
	private IManufacturerRepository manufacturerRepository;

	@Override
	public List<Manufacturer> getAllManufacturers() {
		// TODO Auto-generated method stub
		return manufacturerRepository.findAll();
	}


}
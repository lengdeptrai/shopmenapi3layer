package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.entity.Size;
import com.sm.repository.ISizeRepository;

@Service
public class SizeService implements ISizeService{

	@Autowired
	private ISizeRepository sizeRepository;
	
	@Override
	public List<Size> getAllSizes() {
		// TODO Auto-generated method stub
		return sizeRepository.findAll();
	}
}

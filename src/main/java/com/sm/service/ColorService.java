package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.entity.Color;
import com.sm.repository.IColorRepository;

@Service
public class ColorService implements IColorService{

	@Autowired
	private IColorRepository colorRepository;
	
	@Override
	public List<Color> getAllColors() {
		// TODO Auto-generated method stub
		return colorRepository.findAll();
	}
}

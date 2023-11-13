package com.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sm.entity.Category;
import com.sm.repository.ICategoryRepository;

@Service
public class CategoryService implements ICategoryService{
	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public List<Category> getAllCategorys() {
		return categoryRepository.findAll();
	}
	
}

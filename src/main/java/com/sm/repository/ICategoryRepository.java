package com.sm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Short> {
	
}

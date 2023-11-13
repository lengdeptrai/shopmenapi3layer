package com.sm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.entity.Color;

public interface IColorRepository extends JpaRepository<Color, Short>{

}

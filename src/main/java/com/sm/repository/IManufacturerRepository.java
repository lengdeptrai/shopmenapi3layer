package com.sm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sm.entity.Manufacturer;

public interface IManufacturerRepository extends JpaRepository<Manufacturer, Short>{

}

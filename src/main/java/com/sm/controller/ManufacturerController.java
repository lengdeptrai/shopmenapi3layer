package com.sm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.dto.ManufacturerDto;
import com.sm.entity.Manufacturer;
import com.sm.service.IManufacturerService;

@RestController
@RequestMapping(value = "api/v1/manufacturers")
@CrossOrigin
public class ManufacturerController {

	@Autowired
	private IManufacturerService manufacturerService;

	
	@GetMapping()
	public ResponseEntity<?> getAllManufacturers() {
		List<Manufacturer> manufacturerListDB = manufacturerService.getAllManufacturers();
		List<ManufacturerDto> manufacturerListDto = new ArrayList<>();

		// convert manufacturerListDB --> manufacturerListDto
		for (Manufacturer manufacturerDB : manufacturerListDB) {
			ManufacturerDto manufacturerDto = new ManufacturerDto();
			manufacturerDto.setId(manufacturerDB.getId());
			manufacturerDto.setName(manufacturerDB.getName().toString());

			manufacturerListDto.add(manufacturerDto);
		}

		return new ResponseEntity<>(manufacturerListDto, HttpStatus.OK);
	}

}

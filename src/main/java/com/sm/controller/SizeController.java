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

import com.sm.dto.ColorDto;
import com.sm.dto.SizeDto;
import com.sm.entity.Color;
import com.sm.entity.Size;
import com.sm.service.ISizeService;

@RestController
@RequestMapping(value = "api/v1/sizes")
@CrossOrigin("*")
public class SizeController {

	@Autowired
	private ISizeService sizeService;
	
	@GetMapping()
	public ResponseEntity<?> getAllSizes() {
		List<Size> sizeListDB = sizeService.getAllSizes();
		List<SizeDto> sizeListDto = new ArrayList<>();
		
		// convert categoryListDB --> categoryListDto
		for (Size sizeDB : sizeListDB) {
			SizeDto sizeDto = new SizeDto();
			sizeDto.setId(sizeDB.getId());
			sizeDto.setName(sizeDB.getName().toString());
			
			sizeListDto.add(sizeDto);
		}

		return new ResponseEntity<>(sizeListDto, HttpStatus.OK);
	}
}

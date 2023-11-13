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

import com.sm.dto.CategoryDto;
import com.sm.dto.ColorDto;
import com.sm.entity.Category;
import com.sm.entity.Color;
import com.sm.service.IColorService;

@RestController
@RequestMapping(value = "api/v1/colors")
@CrossOrigin("*")
public class ColorController {
	
	@Autowired
	private IColorService colorService;
	
	
	@GetMapping()
	public ResponseEntity<?> getAllColors() {
		List<Color> colorListDB = colorService.getAllColors();
		List<ColorDto> colorListDto = new ArrayList<>();
		
		// convert categoryListDB --> categoryListDto
		for (Color colorDB : colorListDB) {
			ColorDto colorDto = new ColorDto();
			colorDB.setId(colorDB.getId());
			colorDto.setName(colorDB.getName());
			
			colorListDto.add(colorDto);
		}

		return new ResponseEntity<>(colorListDto, HttpStatus.OK);
	}
	
}

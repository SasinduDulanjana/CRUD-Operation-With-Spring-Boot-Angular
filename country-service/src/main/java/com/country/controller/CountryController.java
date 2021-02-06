package com.country.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.country.domain.Country;
import com.country.exception.CustomException;
import com.country.service.CountryService;

@RestController
@RequestMapping("/rest/v2")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@CrossOrigin
	@PostMapping("/createcountry")
	public ResponseEntity<?> createCountry(@Valid @RequestBody Country country) {

		Country reponseResult = countryService.createCountry(country);
		return new ResponseEntity<>(reponseResult, HttpStatus.CREATED);

	}
	
	@CrossOrigin
	@GetMapping("/findAllCountries")
	public ResponseEntity<?> getAllCountries() {

		List<Country> CountryList = countryService.getAllCountries();
		return new ResponseEntity<>(CountryList, HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/updateCountry")
	public ResponseEntity<?> UpdateCountry(@Valid @RequestBody Country country) {

		Country reponseResult = countryService.updateCountry(country);
		return new ResponseEntity<>(reponseResult, HttpStatus.OK);
	}

	@CrossOrigin
	@DeleteMapping("/deleteCountry/{id}")
	public ResponseEntity<?>DeleteCountry(@PathVariable(required = true) Long id){
		
		try {
			if (id <= 0) {
				throw new CustomException("Invalid Id");
			}
			countryService.deleteCountry(id);
		} catch (Exception e) {
			throw new CustomException("Error while Deleting Record");
		}
		
		Map<String,Object> map=new HashMap<>();
		map.put("message", "Record Deleted ID :: "+id);

		return new ResponseEntity<Map>(map,HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> getAllCountriesById(@PathVariable(required = true) Long id) {

		Country countryDetail = countryService.findCountryById(id);
		return new ResponseEntity<>(countryDetail, HttpStatus.OK);
	}
	}



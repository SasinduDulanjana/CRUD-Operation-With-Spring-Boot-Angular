package com.country.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.domain.Country;
import com.country.exception.CustomException;
import com.country.repository.CountryRepository;
import com.country.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public Country createCountry(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public List<Country> getAllCountries() {
		
	 try {
		 List<Country> countrylist = countryRepository.findAllCountries(Boolean.TRUE);
			
			if(countrylist == null) {
				
				throw new CustomException("No Record Found");
			}
			
			return countrylist;
			
	} catch (Exception e) {
		
		throw new CustomException("Error While Searching Record");
	}
		
	}

	@Override
	public Country updateCountry(Country country) {
		
		
		try {
			Country countryObj = countryRepository.findById(country.getId()).get();
			
			if(countryObj == null) {
				
				throw new CustomException("No Record Found");
			}
			return countryRepository.save(country);
			}
			catch(Exception e) {
				throw new CustomException("Error While Updating Record");
			}
		
		
		
	}

	@Override
	public void deleteCountry(Long id) {
		try {
			Country countryObj = countryRepository.findById(id).get();
			
			if(countryObj == null) {
				
				throw new CustomException("No Record Found");
			}
			countryRepository.delete(countryObj);
			}
			catch(Exception e) {
				throw new CustomException("Unable to Delete Record");
			}
		
	}

	@Override
	public Country findCountryById(Long id) {
		try {
			Country findByIdcountryObj = countryRepository.findById(id).get();
			
			if(findByIdcountryObj == null) {
				
				throw new CustomException("No Record Found");
			}
			return findByIdcountryObj;
			}
			catch(Exception e) {
				throw new CustomException("Unable to Search Record");
			}
	}
	
	

}

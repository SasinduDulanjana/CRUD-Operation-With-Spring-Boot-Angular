package com.country.service;

import java.util.List;

import com.country.domain.Country;

public interface CountryService {

public Country createCountry(Country country);
	
public List<Country> getAllCountries();

public Country updateCountry(Country country);
	
public void deleteCountry(Long id);
	
public Country findCountryById(Long id);
	
}

package com.country.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.country.domain.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	@Query(value = "select c from Country c where c.isActive = ?1")
    List<Country> findAllCountries (Boolean status);
	
}

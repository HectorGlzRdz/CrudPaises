package com.mx.PaisesApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.PaisesApi.Dao.CountryDao;
import com.mx.PaisesApi.Entity.Country;

@Service
public class CountryService {
	
	@Autowired
	CountryDao countryDao;
	
	public List<Country> countryList() {
		
		return countryDao.findAll();
		
	}
	
	public String save(Country country) {
		
		for (Country countryF : countryList()) {
			if(countryF.getId().equals(country.getId())) {
				return "El ID ya existe";
			}
			else if (countryF.getName().equals(country.getName())) {
				return "El nombre del pais ya existe";
			}
		}
		
		countryDao.save(country);
		return "ok";
		
	}
	
	public Country srchCountry(Country country) {
		
		return countryDao.findById(country.getId()).orElse(null);
		
	}
	
	public String edit(Country country) {
		for (Country countryI : countryList()) {
			System.out.println("ID FOR "+countryI.getId()+" ID IN "+country.getId());
			if(countryI.getId().equals(country.getId())) {
				
				for (Country countryN : countryList()) {
					if (countryN.getName().equals(country.getName())) {
						return "El nombre del pais ya existe";
					}
				}
				countryDao.save(country);
				return "ok";
			}
		}
		
		return "El id de registro no existe";
		
	}
	
	public boolean delete(Country country) {
		
		if(srchCountry(country)!=null) {
			countryDao.deleteById(country.getId());
			return true;
		}
		
		
		return false;
		
	}
	

}

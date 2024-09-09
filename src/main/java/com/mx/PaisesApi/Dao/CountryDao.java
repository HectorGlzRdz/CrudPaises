package com.mx.PaisesApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.PaisesApi.Entity.Country;

@Repository
public interface CountryDao extends JpaRepository<Country, Long>{

}

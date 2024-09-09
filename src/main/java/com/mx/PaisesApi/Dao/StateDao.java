package com.mx.PaisesApi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.PaisesApi.Entity.State;

@Repository
public interface StateDao extends JpaRepository<State, Long>{

}

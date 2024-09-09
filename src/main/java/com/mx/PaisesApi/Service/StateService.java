package com.mx.PaisesApi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.PaisesApi.Dao.CountryDao;
import com.mx.PaisesApi.Dao.StateDao;
import com.mx.PaisesApi.Entity.Country;
import com.mx.PaisesApi.Entity.State;

@Service
public class StateService {

	@Autowired
	StateDao stateDao;
	@Autowired
	CountryService countrySrvc;
	@Autowired
	CountryDao cd;

	public List<State> list() {
		return stateDao.findAll();
	}

	public String save(State state) {

		for (State stateF : list()) {
			if (stateF.getId().equals(state.getId())) {
				return "El id ya existe";
			} else if (stateF.getName().equals(state.getName())
					&& stateF.getCountry().getId().equals(state.getCountry().getId())) {
				return "El estado ya existe en este pais";
			}
		}

		stateDao.save(state);
		return "ok";
	}

	public State srchState(State state) {

		return stateDao.findById(state.getId()).orElse(null);

	}

	public String edit(State state) {

		Country country = countrySrvc.srchCountry(state.getCountry());

		// determina si el pais existe
		if (country != null) {
			for (State stateF : list()) {

				// Determina si el id del estado ya esta usado
				if (stateF.getId().equals(state.getId())) {
					
					//System.out.println("pais " + country.States);
					System.out.println("antes");
					if (country.States.isEmpty()) {
						
						stateDao.save(state);
						return "ok";
					}
					
					for (State stateF2 : country.States) {
						
						// Dentro se determina si el nombre del estado ya existe dentro dentro de los
						// estados del pais
						if (stateF2.getName().equals(state.getName())) {
							return "El estado ya existe en este pais";
						} else {
							stateDao.save(state);
							return "ok";
						}

					}
					break;
				} else
					return "El id no existe";
			}
		} else
			return "El pais no existe";

		return "error desconocido";
	}

	public boolean delete(State state) {
		
		if (srchState(state)!=null) {
			stateDao.delete(state);
			return true;
		}
		
		return false;
	}

}

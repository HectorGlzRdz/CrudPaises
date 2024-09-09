package com.mx.PaisesApi.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PAIS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {
	
	@Id
	@Column(name ="ID")
	private Long id;
	@Column(name="NOMBRE")
	private String name;
	@Column(name="IDIOMA")
	private String lenguages;
	
	@OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
	@JsonIgnore
	public List<State> States;
	
}

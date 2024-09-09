package com.mx.PaisesApi.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ESTADO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class State {
	
	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="NOMBRE")
	private String name;
	@Column(name="CLIMA")
	private String weather;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_PAIS")
	private Country country;

}

package br.com.omini.bethehero.ong;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.omini.bethehero.incident.Incident;

@Entity
@Table(name="ong")
public class Ong {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	private String name;
	private String email;
	private Integer whatsapp;
	private String city;
	private String uf;
	
	@OneToMany
	@JsonIgnore
	private List<Incident> incidents = new ArrayList<>();
	

	public Ong() {
		super();
	}
	
	public Ong(Long id) {
		super();
		this.id = id;
	}

	public Ong(String name, String email, Integer whatsapp, String city, String uf) {
		super();
		this.name = name;
		this.email = email;
		this.whatsapp = whatsapp;
		this.city = city;
		this.uf = uf;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(Integer whatsapp) {
		this.whatsapp = whatsapp;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public List<Incident> getIncidents() {
		return incidents;
	}
	public void setIncidents(List<Incident> incidents) {
		this.incidents = incidents;
	}
	
}

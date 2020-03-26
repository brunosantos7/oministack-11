package br.com.omini.bethehero.incident;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.omini.bethehero.ong.Ong;

public class IncidentDTO {
	
	private String title;
	private String description;
	private Double value;
	@JsonIgnore
	private Long ongId;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	public Long getOngId() {
		return ongId;
	}
	
	public void setOngId(Long ongId) {
		this.ongId = ongId;
	}

	public Incident toIncidentEntity() {
		return new Incident(
				this.getTitle(), 
				this.getDescription(), 
				this.getValue(), 
				new Ong(this.ongId));
	}
}

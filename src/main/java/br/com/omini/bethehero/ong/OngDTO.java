package br.com.omini.bethehero.ong;

public class OngDTO {

	private Long id;
	private String name;
	private String email;
	private Integer whatsapp;
	private String city;
	private String uf;
	
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
	
	public Ong toOng() {
		 return new Ong(
				 this.getName(),
				 this.getEmail(),
				 this.getWhatsapp(), 
				 this.getCity(), 
				 this.getUf()
				 );
	}
	
}

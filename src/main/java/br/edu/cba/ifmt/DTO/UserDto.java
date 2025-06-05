package br.edu.cba.ifmt.DTO;

import org.apache.struts.action.ActionForm;

import br.edu.cba.ifmt.DTO.CityDto;

public class UserDto extends ActionForm {
	private int id;
	private String nome;
	private String email;
	private String CPF;
	//private CityDto city;
	
	public UserDto() {}
	
	public UserDto(String nome, String email, String CPF) {
		this.nome = nome;
		this.email = email;
		this.CPF = CPF;
	}
	
	public UserDto(int id, String nome, String email, String CPF) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.CPF = CPF;
	}
	
	/*public UserDto(String nome, String email, String CPF, CityDto city) {
		this.nome = nome;
		this.email = email;
		this.CPF = CPF;
		this.city = city;
	}
	
	public UserDto(int id, String nome, String email, String CPF, CityDto city) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.CPF = CPF;
		this.city = city;
	}*/

	public int getId() { return id;	}

	public void setId(int id) { this.id = id; }

	public String getNome() { return nome;	}

	public void setNome(String nome) { this.nome = nome; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getCPF() { return CPF; }

	public void setCPF(String cPF) { CPF = cPF;	}

	//public CityDto getCity() { return city; }

	//public void setCity(CityDto city) { this.city = city; }
}

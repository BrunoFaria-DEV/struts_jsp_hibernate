package br.edu.cba.ifmt.DTO;

import org.apache.struts.action.ActionForm;

public class UserDto extends ActionForm {
	private int id;
	private String nome;
	private String email;
	private String cpf;
	private CityDto city;
	
    public UserDto() {
        this.city = new CityDto();
    }
	
	public UserDto(String nome, String email, String cpf, CityDto city) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.city = city;
	}
	
	public UserDto(int id, String nome, String email, String cpf, CityDto city) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.city = city;
	}

	public int getId() { return id;	}

	public void setId(int id) { this.id = id; }

	public String getNome() { return nome;	}

	public void setNome(String nome) { this.nome = nome; }

	public String getEmail() { return email; }

	public void setEmail(String email) { this.email = email; }

	public String getCpf() { return cpf; }

	public void setCpf(String cpf) { this.cpf = cpf;	}

	public CityDto getCity() { return city; }

	public void setCity(CityDto city) { this.city = city; }
}

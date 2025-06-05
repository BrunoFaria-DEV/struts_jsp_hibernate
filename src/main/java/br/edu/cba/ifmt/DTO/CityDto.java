package br.edu.cba.ifmt.DTO;

import org.apache.struts.action.ActionForm;

public class CityDto extends ActionForm{
	private int id;
	private String nome;
	
	public CityDto() {}
	
	public CityDto(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() { return id;	}

	public void setId(int id) { this.id = id; }

	public String getNome() { return nome; }

	public void setNome(String nome) { this.nome = nome; }
	
}

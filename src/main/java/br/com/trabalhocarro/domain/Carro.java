package br.com.trabalhocarro.domain;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;



@Entity
public class Carro implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@NotNull
	@Column(name="Ano")
	private Integer ano;
	
	@NotNull
	@Column(name="Odometro")
	private double odometro;
	
	@NotNull
	@Column(name="Diaria")
	private double diaria;
	
	@NotNull
	@Column(name="Cor")
	private String cor;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Modelo_Id")
	private Modelo modelo;
	
	public Carro() {
		
	}
	
	public Carro(Integer id, Integer ano, double odometro, double diaria,
			String cor, Modelo modelo) {
		super();
		this.id = id;
		this.ano = ano;
		this.diaria = diaria;
		this.cor = cor;
		this.modelo = modelo;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getAno() {
		return ano;
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public double getOdometro() {
		return odometro;
	}
	
	public void setOdometro(double odometro) {
		this.odometro = odometro;
	}
	
	public double getDiaria() {
		return diaria;
	}
	
	public void setDiaria(double diaria) {
		this.diaria = diaria;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public Modelo getModelo() {
		return modelo;
	}
	
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
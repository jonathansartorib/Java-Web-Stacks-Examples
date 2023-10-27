package com.sistemaclienteservidor5;

import java.util.LinkedHashMap;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Employee {
	@Min(value=0, message="Id deve ser maior que zero.")
	@Max(value=10, message="Id deve ser menor ou igual a 10.")
	private int id;
	
	@NotNull(message="Informação requerida.")
	@Size(min="2", message="Digite no minimo 2 caracteres.")
	private String fisrtName;
	
	private String lastName;
	private String city;
	private String zipCode;
	private String businessUnit;
	private String[] languages;
	private LinkedHashMap<String, String> citiesOptions;
	
	public Employee() {
		citiesOptions = new LinkedHashMap<>();
		citiesOptions.put("SP", "São Paulo");
		citiesOptions.put("RJ", "Rio de Janeiro");
		citiesOptions.put("MG", "Minas Gerais");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFisrtName() {
		return fisrtName;
	}
	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}
	public String[] getLanguages() {
		return languages;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	public LinkedHashMap<String, String> getCitiesOptions() {
		return citiesOptions;
	}
	public void setCitiesOptions(LinkedHashMap<String, String> citiesOptions) {
		this.citiesOptions = citiesOptions;
	}
}

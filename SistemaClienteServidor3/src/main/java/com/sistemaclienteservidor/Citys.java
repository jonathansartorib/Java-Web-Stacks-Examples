package com.sistemaclienteservidor;

public class Citys {
	
	private String name;
	private String id;
	private String district;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Citys(String name, String id, String district) {
		super();
		this.name = name;
		this.id = id;
		this.district = district;
	}
	
}

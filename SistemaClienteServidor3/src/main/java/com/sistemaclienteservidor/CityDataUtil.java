package com.sistemaclienteservidor;

import java.util.ArrayList;
import java.util.List;

public class CityDataUtil {
	public CityDataUtil() {
		
	}
	
	public static List<Citys> getCitys(){
		//criar uma lista vazia
		List<Citys> citys = new ArrayList<>();
		
		//adicionar dados a lista
		
		citys.add(new Citys("nome1", "id1", "distrito1"));
		citys.add(new Citys("nome2", "id2", "distrito2"));
		citys.add(new Citys("nome3", "id3", "distrito3"));
		
		return citys;
		
	}
}

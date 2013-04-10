package com.blmstrm.ocjp2;


import java.util.ArrayList;
import java.util.NavigableMap;
import java.util.TreeMap;


public class Basket{

	NavigableMap <String, KitchenWare> innerMap = new TreeMap<>();
	

	public KitchenWare getKitchenWare(String item){
		return innerMap.get(item);
	}
	
	public ArrayList <KitchenWare> getEveryWareFromTo(String from, String to){
		
		ArrayList <KitchenWare> returnList = new ArrayList<KitchenWare>();
		
		for(KitchenWare k : this.innerMap.subMap(from,to).values()){
			returnList.add(k);
		}
		
		return returnList;
		
	}
	
	public void addKitchenWare(String s, KitchenWare k){
		this.innerMap.put(s,k);
	}
		
}

package com.blmstrm.ocjp2.utensils;

import java.io.Serializable;

import com.google.code.morphia.annotations.Entity;

@Entity
public class Fork extends Utensil implements KitchenWare,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void use() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}

	
	
}

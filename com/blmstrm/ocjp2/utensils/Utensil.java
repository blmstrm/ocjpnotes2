package com.blmstrm.ocjp2.utensils;

import java.io.Serializable;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public abstract class Utensil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String brand = "";
	private boolean dirty;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

	public String toString(){
		return "utensil from "+this.brand;
	}
	
}

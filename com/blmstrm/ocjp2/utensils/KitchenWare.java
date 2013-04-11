package com.blmstrm.ocjp2.utensils;

import com.google.code.morphia.annotations.Embedded;

@Embedded
public interface KitchenWare {
	
	public void use();
	
	public void clean();
		
}

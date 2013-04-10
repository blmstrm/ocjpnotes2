package com.blmstrm.ocjp2.cupboard;
import com.blmstrm.ocjp2.KitchenWare;
import com.blmstrm.ocjp2.plates.Plate;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public final class KitchenWareWrapper {

	@SuppressWarnings("unused")
	@Id
	private String Id;
	private KitchenWare kitchenWare;
	private Plate p;

	public KitchenWare getKitchenWare() {

		if (p==null){
			return kitchenWare;
		}
		return p;
	}

	public void setKitchenWare(KitchenWare kitchenWare) {
		if(kitchenWare instanceof Plate){
			this.p = (Plate) kitchenWare;
		}else{
			this.kitchenWare = kitchenWare;
		}
	}
}

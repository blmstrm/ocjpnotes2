package com.blmstrm.ocjp2.possessions;

import java.util.ArrayList;
import com.blmstrm.ocjp2.Photo;


public class Camera {

	ArrayList <Photo> photos = new ArrayList<>();

	public void snapAPhoto(Photo photo){
		this.photos.add(photo);
	}
	
	@Override
	protected void finalize() throws Throwable{
		/*Serialize photos to photos*/
	}
	
}

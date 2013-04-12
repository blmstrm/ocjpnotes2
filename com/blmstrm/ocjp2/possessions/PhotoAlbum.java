package com.blmstrm.ocjp2.possessions;

import java.util.ArrayList;


public class PhotoAlbum {

	ArrayList <Photo> photos = new ArrayList<>();
	
	{
		/*deserialize photos from photos*/
	}
	
	public void flipTrough(){
		for(Photo p : photos){
			System.out.println(p);
		}
	}
}

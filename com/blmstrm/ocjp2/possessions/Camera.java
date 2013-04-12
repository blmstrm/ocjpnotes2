package com.blmstrm.ocjp2.possessions;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Camera {

	ArrayList <Photo> photos = new ArrayList<>();
	
	
	public void snapAPhoto(Photo photo){
			this.photos.add(photo);
	developPhotos();
	}
	
	private void developPhotos(){
		try(DataOutputStream dataOutput = new DataOutputStream(new FileOutputStream("photos"))) {
	
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			ObjectOutputStream objOut = new ObjectOutputStream( byteOut);
			objOut.writeObject(photos);
			dataOutput.write(byteOut.toByteArray());
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
}

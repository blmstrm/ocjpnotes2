package com.blmstrm.ocjp2.possessions;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class PhotoAlbum {

	ArrayList <Photo> photos = new ArrayList<>();

	{
		try(DataInputStream dataInput = new DataInputStream(new FileInputStream("photos"))) {
			long charCount =( new File("photos")).length();

			byte [] inBytes = new byte[(int) charCount];

			int b = 0;
			int i= 0;
			while((b = dataInput.read())!=-1){
				inBytes[i] = (byte) b;
				i++;
			}

			ByteArrayInputStream byteIn = new ByteArrayInputStream(inBytes);
			ObjectInputStream objIn = new ObjectInputStream(byteIn);

			Object objs = objIn.readObject();
			if(objs instanceof ArrayList<?>){
				for(Object o : (ArrayList <?>)objs){				
					this.photos.add(Photo.class.cast(o));
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (ClassCastException  e){
			e.printStackTrace();
		}
	}

	public void flipTrough(){
		for(Photo p : photos){
			System.out.println(p);
		}
	}
}

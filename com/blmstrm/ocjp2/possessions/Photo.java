package com.blmstrm.ocjp2.possessions;

import java.io.Serializable;
import java.util.ArrayList;

public class Photo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList <Object> photoObjects = new ArrayList<>();

	public void addObject(Object o){
		this.photoObjects.add(o);
	}

	public ArrayList <Object> getObjects(){
		return this.photoObjects;
	}

	@Override
	public String toString(){
		int c = 0;
		int size = this.photoObjects.size();
		String returnString = "";
		if(this.photoObjects.size()!=0){
			returnString += "The photo contains a ";
			for(Object s : photoObjects){
				returnString +=s;
				if(c == size-1){
					returnString +="and a ";
				}else{
					returnString +=", ";
				}
				c++;
			}
			returnString += ".";
		}else{
			returnString += "No photo in camera.";
		}

		return returnString;
	}

}

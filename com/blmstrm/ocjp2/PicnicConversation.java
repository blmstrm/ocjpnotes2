package com.blmstrm.ocjp2;

import java.io.Console;

public class PicnicConversation {


	private Console console;

	{
		console =System.console();
		console.printf("Opening file\n");
		/*Open file conversation*/
		
		
	}

	public static void main(String args[]){
		
		PicnicConversation convo = new PicnicConversation();
		convo.talk();
	}

	private void talk(){

		try {
			
	
		} finally{
			console.printf("Saving file\n");
		}
	}
	
}

package com.blmstrm.ocjp2;

import java.io.Console;

public class PicnicConversation {

	private Talker currentTalker;

	private enum Talker {
		DROGBA,ANKA
	}

	private Console console;

	{

		console = System.console();
		console.printf("Opening file\n");
		this.currentTalker = Talker.DROGBA;
		/*Open file conversation*/

	}

	public static void main(String args[]){

		PicnicConversation convo = new PicnicConversation();
		convo.talk();
	}

	private void talk(){
		String line = "";

		while(true){
			switch(currentTalker){
			case DROGBA:
				console.printf("Drogba: ");
				line +="Drogba: ";
				currentTalker=Talker.ANKA;
				break;
			case ANKA:
				console.printf("Anka: ");
				line +="Anka: ";
				currentTalker=Talker.DROGBA;
				break;
			}
		
			line += console.readLine();
			line += "\n";
			line ="";
		}


	}

}

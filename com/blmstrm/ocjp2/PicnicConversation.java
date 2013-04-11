package com.blmstrm.ocjp2;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;

public class PicnicConversation {

	private Talker currentTalker;

	private enum Talker {
		Drogba,Anka
	}

	private Console console;
	private BufferedWriter writer;

	{

		this.console = System.console();
		this.currentTalker = Talker.Drogba;
		try {
			this.writer = new BufferedWriter(new FileWriter("conversation"));
		} catch (IOException e) {
			System.exit(1);
		}

	}

	public static void main(String args[]){

		PicnicConversation convo = new PicnicConversation();
		try {
			convo.talk();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void talk() throws IOException{
		String line = "";

		while(true){
			switch(currentTalker){
			case Drogba:
				console.printf("Drogba: ");
				line +="Drogba: ";

				break;
			case Anka:
				console.printf("Anka: ");
				line +="Anka: ";
	
				break;
			}

			line += console.readLine();

			if(line.compareTo(currentTalker+": \\exit")==0){
				writer.close();
				System.exit(0);
			}
			line += "\n";
			this.writer.write(line);
			line ="";

			currentTalker = currentTalker==Talker.Drogba? Talker.Anka:Talker.Drogba;



		}



	}

}

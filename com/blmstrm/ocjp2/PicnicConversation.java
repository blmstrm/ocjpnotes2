package com.blmstrm.ocjp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PicnicConversation {

	private Talker currentTalker;

	private enum Talker {
		Drogba,Anka
	}

	private Console console;
	private BufferedWriter writer;
	private BufferedReader reader;


	{

		String replay = "";
		String lastLine= "";
		this.console = System.console();
		this.currentTalker = Talker.Anka;
		
		try {
			if(new File("conversation").exists()){
				this.reader = new BufferedReader(new FileReader("conversation"));

				while((replay = this.reader.readLine())!= null){
					console.printf(replay+"\n");
					lastLine = replay;
				}

				if(lastLine.startsWith("Drogba: ")){
					this.currentTalker= Talker.Anka;
				}else{
					this.currentTalker = Talker.Drogba;
				}
			}


		} catch (IOException e) {
			System.out.println("It started raining. No conversation today.");
			System.exit(1);
		}
		
		try {
			this.writer = new BufferedWriter(new FileWriter("conversation",true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			this.writer.append(line);
			line ="";

			currentTalker = currentTalker==Talker.Drogba? Talker.Anka:Talker.Drogba;

		}
	}
}

package gameCenter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import finalCode.FinalCode;
import guessTheNumber.GuessTheNumber;

public class GOperater {
	private GUser using;
	private static ArrayList<Projects> queue = new ArrayList<>(); 
	
	public void kernelMain() {
		queueInitialize();
		Scanner inputcom = new Scanner(System.in);
		
		printOption();
		System.out.print("Please enter your command: ");
		while(inputcom.hasNextLine()) {
			String content = inputcom.nextLine();
			boolean key = false;
			int index = -10;
			for(int i = 0; i < queue.size(); i++) {
				Projects ins = queue.get(i);
				if(content.equals(ins.getWord())) {
					key = true;
					index = i-1;
					break;
				}
			}
			if(key) {
				GuessTheNumber g = new GuessTheNumber(using);
				FinalCode f = new FinalCode(using);				
				Operate(index);
			}else {
				System.out.println("I don't understand your command.");	
			}
			System.out.print("Please enter your command: ");
		}
	}
	
	public void queueInitialize() {
		File instruction = new File("Instruction.txt");
		try{
			Scanner reader = new Scanner(instruction);
			try {		
				while(reader.hasNextLine()) {
					String content = reader.nextLine();
					Projects newInstruction = new Projects(content);
					queue.add(newInstruction);
				}
			}finally {
				reader.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	public void Operate(int label) {
		System.out.println("-".repeat(40));
		if(label < 0) {
			switch (label) {
			case -1:
				Projects.logOut();
				break;
			default:
				System.out.println("Null.");
			}
		}else {
			Game gaming = using.play(label);
			
			switch (label) {
			case 0:
				GuessTheNumber g = (GuessTheNumber) gaming;
				g.guessTheNumber();
				break;
			case 1:
				FinalCode f = (FinalCode) gaming;
				f.finalCode();
				break;
			default:
				System.out.println("Null.");
			}
		}
		System.out.println("-".repeat(40));
	}
	
	public void setUser(GUser u) {
		using = u;
	}
	
	public void printOption() {
		System.out.println("Game we have:");
		for(Projects i:queue) {
			System.out.println(i.getWord());
		}
		System.out.println("");
	}
	
	public Projects getProject(int i) {
		return queue.get(i);
	}

}

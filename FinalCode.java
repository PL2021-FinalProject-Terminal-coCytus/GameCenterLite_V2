package finalCode;

import java.util.Scanner;

import gameCenter.GUser;
import gameCenter.Game;

public class FinalCode extends Game{
	
	public FinalCode(GUser u) {
		super(u);
	}
	
	public void finalCode(){
		this.unit = " times.";
		
		int L = 1,H = 1000;
		int key = (int)(Math.random()*999+1);
		int guess = 0;
		int count = 0;
		
		System.out.println(key);
				
	    Scanner scan = new Scanner(System.in);
		System.out.println("Final Code Game Start!");
		
		do{
	     System.out.println("Range:"+L+"~"+H);
	     System.out.print("Please enter a number: ");
	     guess = scan.nextInt();
	     count++;
	     
	     if(guess > key) {
	    	 H = guess;
	     }else {
	    	 L = guess;
	     }
		}
		
		while(key != guess);
		
		System.out.println("Bingo!" + gamer.getName() + ", you tried "+count+" times.");

		this.historyL(count);
		
	}
	
}

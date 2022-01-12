package gameCenter;

import java.util.Scanner;


public class Projects {
	private String word;
	
	public Projects(String word) {
		this.word = word;
	}
	
	public String getWord() {
		return word;
	}
	
	public static void logOut() {
		System.out.println("Log out!");
		System.out.println("-".repeat(40));
		System.exit(0);
	}

	
}

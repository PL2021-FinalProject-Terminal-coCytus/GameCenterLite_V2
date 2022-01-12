package gameCenter;

import java.util.Scanner;

public class GGate {

	private GUser trying;
	private GUserLibrary library = new GUserLibrary();

	public static void main(String[] args) {
		GGate shell = new GGate();
		GOperater Alyx = new GOperater();
		GUserLibrary.initialize();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to GameCenter!");
		System.out.print("Log in or Regist?");
		while (input.hasNextLine()) {
			String choose = input.nextLine();
			if (choose.equals("log in") || choose.equals("Log in")) {
				while (!shell.getin(input)) {
					shell.getin(input);
				}
				System.out.println("-".repeat(40));
				shell.userTransport(Alyx);
				Alyx.kernelMain();

			} else if (choose.equals("regist") || choose.equals("Regist")) {
				shell.regist(input);
				System.out.println("-".repeat(50));
				input.nextLine();
			} else {
				System.out.println("I don't know what you said.");
			}
			System.out.print("Log in or Regist?");
			choose = null;
		}

	}

	public boolean getin(Scanner input) {
		boolean valid = false;
		int state = 0;
		System.out.print("Please input user name: ");
		String tryName = input.nextLine();

		GUser tryy = new GUser(tryName);
		state = library.check(tryy);
		switch (state) {
		case 1:
			System.out.println("Log in succeed!");
			valid = true;
			break;
		case 2:
			System.out.println("Wrong name.");
			break;
		default:
			System.out.println("Null point.");
			break;
		}
		if (valid) {
			trying = tryy;
		}
		return valid;
	}

	public void regist(Scanner input) {
		System.out.println("-".repeat(50));
		System.out.println("Registing:");
		System.out.print("Please enter your name: ");

		while (input.hasNextLine()) {

			String newName = new String(input.nextLine());
			boolean valid = false;
			for (int i = 0; i < library.size(); i++) {
				if (newName.equals(library.getUser(i).getName())) {
					valid = true;
					System.out.println("Duplicate use name!");
					break;
				}
			}
			if (!valid) {
				System.out
						.print("Sure? If yes, please enter \"yes\". If no, enter \"no\", or enter \"exit.\"to quit. :");
				String check = input.next();
				if (check.equals("yes")) {
					GUser newUser = new GUser(newName);
					library.regist(newUser);
					System.out.println("Regist success!");
					return;
				} else if (check.equals("no")) {
					System.out.println("Please enter again.");
				} else if (check.equals("exit.")) {
					return;
				} else {
					System.out.println("I don't know what you said.");
					System.out.println("Please enter again.");
				}
				input.nextLine();
			}
			newName = null;
			System.out.print("Please enter your name: ");
		}
	}

	public void userTransport(GOperater k) {
		k.setUser(trying);
	}

}

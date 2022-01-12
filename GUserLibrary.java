package gameCenter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class GUserLibrary {
private static ArrayList<GUser> Library = new ArrayList<>();
	
	public GUser getUser(int index) {
		return Library.get(index);
	}
	
	public void setUser(int index, GUser user) {
		Library.set(index, user);
	}
	
	public static void initialize() {
		Library.clear();
		try {
			File bookN = new File("User.txt");
			Scanner readerN = new Scanner(bookN);
			ArrayList<String> name = new ArrayList<>();
			
			try {
				while (readerN.hasNextLine()) {
					String n = readerN.nextLine();
					name.add(n);
				}
				for(int i = 0; i < name.size(); i++) {
					GUser user = new GUser(name.get(i));
					Library.add(user);
				}				
			} finally {
				readerN.close();
				name.clear();
			}
		} catch (FileNotFoundException e3) {
			System.out.println("File canot found.(E3)");
		}
	}
	
	public int check(GUser user) {
		int state = 0;
		initialize();
		String name = user.getName();
		for(GUser u: Library) {
			if(name.equals(u.getName())) {
				state = 1;
				break;
			}else {
				state = 2;
			}
		}
		return state;
	}
	
	public void regist(GUser newUser) {
		try {
			File bookN = new File("User.txt");
			FileOutputStream fosN=new FileOutputStream(bookN,true); //接水管
	        OutputStreamWriter oswN=new OutputStreamWriter(fosN);      //裝馬達,編碼轉換
	        BufferedWriter bwN=new BufferedWriter(oswN);    //接水桶(緩衝區)
	        
			try {
				Library.add(newUser);
				bwN.write(newUser.getName() + "\n");//將字串寫入檔案
	            bwN.flush();               //清空緩衝區
			} finally {
				fosN.close();
				oswN.close();
				bwN.close();				
			}
			
		} catch (FileNotFoundException e1) {
			System.out.println("File canot found.(E1)");
		} catch (IOException e1) {
			System.out.println("IOException.(E1)");
		} 
	}
	
	public int size() {
		return Library.size();
	}

}

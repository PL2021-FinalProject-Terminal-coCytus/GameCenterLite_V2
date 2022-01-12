package gameCenter;

import java.util.*;

public class GUser {
	private String name;
	private ArrayList<Game> games = new ArrayList<>();
	
	public GUser(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public String getScore(int i) {
		return games.get(i).returnResult();
	}
	
	public int totalNumber() {
		return games.size();
	}
	
	public void add(Game g) {
		games.add(g);
	}
	
	public Game play(int index) {
		return games.get(index);
	}
	
}

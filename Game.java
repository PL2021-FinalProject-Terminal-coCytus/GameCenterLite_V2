package gameCenter;

public class Game {
	protected GUser gamer;
	protected int score = 100;
	protected String unit;

	
	public Game(GUser u) {
		u.add(this);
		gamer = u;
	}
	
	public String returnResult() {
		String result = score + unit;
		return result; 
	}

	public void historyH(int nowScore) {
		if(nowScore > score) {
			System.out.println("You achieved your new high score!");
			score = nowScore;
		}
	}
	
	public void historyL(int nowScore) {
		if(nowScore < score) {
			System.out.println("You achieved your new high score!");
			score = nowScore;
		}
	}
	

}

package players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PlayersLocal extends Players{

	private List<Integer> total;
	private String name;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public PlayersLocal(String nName) {
		total = new ArrayList<Integer>();
		name = nName;
	}

	public int playTurn() throws IllegalArgumentException, IOException, NumberFormatException {
		int num;
		System.out.println("Player " + name + " choose a number bewteen 1 and 9: ");
		num = Integer.parseInt(br.readLine());
		return num;
	}

	public void updateTotal(int num){
		total.add(num);
	}
	

	public void clearTotal() {
		total.clear();
	}
	
	public String getName() {
		return name;
	}

	public List<Integer> getTotal() {
		return total;
	}

	@Override
	public void sendMessage2This(String message) {
		System.out.println(message);
	}
}

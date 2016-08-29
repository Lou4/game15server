package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import players.Players;
import numbers.Numbers;

public class Game {

	private Numbers numbers;
	private Players p1, p2;
	private int goal;
	private String winner;
	private List<Integer> winningCombination;
	
	public Game(BuilderGame builder) {
		numbers = builder.numbers;
		p1 = builder.p1;
		p2 = builder.p2;
		goal = builder.goal;
	}
	
	public void start() throws IOException{		
		//GAME LOGIC
		gameLogic();
		
		//RETURN VALUE
		p1.sendMessage2This(calculateReturnValue());
		p2.sendMessage2This(calculateReturnValue());
	}
	
	public boolean win(Players currPlayer) {
		List<Integer> listNumbers = currPlayer.getTotal();
		int sum;
		
		if(listNumbers.size() < 3)
			return false;
		
		for(int uno = 0; uno<listNumbers.size(); uno++){
			for(int due = 0; due<listNumbers.size(); due++){
				if(due == uno)
					continue;
				
				for(int tre = 0; tre<listNumbers.size(); tre++){
					if(tre == due || tre == uno)
						continue;
					
					sum = listNumbers.get(uno) + listNumbers.get(due) + listNumbers.get(tre);
					if(sum == goal){
						winner = currPlayer.getName();
						if(winningCombination == null)
							winningCombination = new ArrayList<Integer>();
						winningCombination.add(listNumbers.get(uno));
						winningCombination.add(listNumbers.get(due));
						winningCombination.add(listNumbers.get(tre));
						return true;
					}
				}	
			}
		}
		
		return false;
	}
	
	public void clear(){
		numbers.clear();
		p1.clearTotal();
		p2.clearTotal();
	}
	
	public String winningCombination(){
		if(winningCombination.size() == 0)
			return "";
		else{
			String res = "";
			for(Integer num: winningCombination){
				res += num + " ";
			}
			return res;
		}
		
	}
	
	private String calculateReturnValue() {
		if(winner != null){
			System.out.println("Win " + winner);
			return "PLAYER " + winner + " WIN WITH: " + winningCombination();
		}else{
			System.out.println("Draw");
			return "DRAW";
		}
	}

	private void gameLogic() throws IOException {
		
		
		int i = 0;
		int num = 0;
		Players currPlayers = null;
		do{
			try{
				currPlayers = (i%2 == 0) ? p1 : p2;
				
				System.out.println("Turn " + currPlayers.getName());
			
				num = currPlayers.playTurn();
				numbers.take(num);
				currPlayers.updateTotal(num);
				
				System.out.println("Player " + currPlayers.getName() + " choose " + num);
				
				i++;
			}catch(NumberFormatException e){
				currPlayers.sendMessage2This("Select e number");
				System.out.println(currPlayers.getName() + " has pick and invalid number: " + num);
			}catch (IllegalArgumentException e) {
				currPlayers.sendMessage2This(e.getMessage());
				System.out.println(currPlayers.getName() + " has insert an invalid string");
			}
			
		}while(!win(currPlayers) && numbers.isNotNumberAllTaken());
	}
}

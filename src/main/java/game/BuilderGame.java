package game;

import players.Players;
import customException.WrongBuilderInitializationException;
import numbers.Numbers;

public class BuilderGame {

	Numbers numbers;
	Players p1;
	Players p2;
	Integer goal;
	Integer turn;
	
	public BuilderGame setNumbers(Numbers numbers) {
		this.numbers = numbers;
		return this;
	}
	
	public BuilderGame setP1(Players p1) {
		this.p1 = p1;
		return this;
	}
	
	public BuilderGame setP2(Players p2) {
		this.p2 = p2;
		return this;
	}
	
	public BuilderGame setGoal(int goal) {
		this.goal = goal;
		return this;
	}
	
	public BuilderGame setTurn(int turn) {
		this.turn = turn * 2;
		return this;
	}
	
	public Game build() throws WrongBuilderInitializationException{
		if(numbers == null)
			throw new WrongBuilderInitializationException("Missing numbers structure");
		if(p1 == null)
			throw new WrongBuilderInitializationException("Missing player 2 name informations");
		if(p2 == null)
			throw new WrongBuilderInitializationException("Missing player 2 name informations");
		if(goal == null)
			throw new WrongBuilderInitializationException("Missing goal informations");
		if(turn == null)
			throw new WrongBuilderInitializationException("Missing turn informaions");
			
		return new Game(this);
	}
	

}

package game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import customException.WrongBuilderInitializationException;
import numbers.Numbers;
import players.Players;
import players.PlayersLocal;
import players.PlayersOnLine;

public class GameFactory {
	
	public static Game createGame15() throws WrongBuilderInitializationException{
		PlayersLocal p1 = new PlayersLocal("LUCA");
		PlayersLocal p2 = new PlayersLocal("PREDO");
		
		BuilderGame builderGame = new BuilderGame();
		builderGame.setNumbers(Numbers.getIstance())
				.setP1(p1)
				.setP2(p2)
				.setGoal(15)
				.setTurn(3);
		
		return builderGame.build();
	}
	
	public static Game createGame15OnLine() throws WrongBuilderInitializationException, IOException{
		System.out.println("Waiting for 2 players...");
		ServerSocket ss = new ServerSocket(11111);
		Socket p1Socket = ss.accept();
		Socket p2Socket = ss.accept();
		Players p1 = new PlayersOnLine("LUCA", p1Socket);
		Players p2 = new PlayersOnLine("PREDO", p2Socket);
		ss.close();
		System.out.println("Two players arrived");
		
		BuilderGame builderGame = new BuilderGame();
		builderGame.setNumbers(Numbers.getIstance())
				.setP1(p1)
				.setP2(p2)
				.setGoal(15)
				.setTurn(3);
		
		return builderGame.build();
	}
}

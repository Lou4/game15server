package main;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import customException.WrongBuilderInitializationException;
import game.Game;
import game.GameFactory;

public class Main {
	public static void main(String[] args) {
		Game game;
		Date date = new Date();
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		System.out.println("- - - GAME BEGUN - - - " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
		
		try {
			game = GameFactory.createGame15OnLine();
			game.start();

		} catch (WrongBuilderInitializationException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("- - - END - - - " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
	}
}

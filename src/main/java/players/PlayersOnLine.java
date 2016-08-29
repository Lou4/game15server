package players;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class PlayersOnLine extends Players{

	private Socket socket;
	private List<Integer> total;
	private String name;
	private BufferedReader in;
	private PrintWriter out;
	
	public PlayersOnLine(String nName, Socket nSocket) throws IOException {
		total = new ArrayList<Integer>();
		name = nName;
		socket = nSocket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
	}
	
	@Override
	public int playTurn() throws IllegalArgumentException, IOException, NumberFormatException {
		sendMessage2This("Player " + name + " choose a number bewteen 1 and 9:");
		return Integer.parseInt(in.readLine().toString());
	}

	@Override
	public void updateTotal(int num) {
		total.add(num);
		sendMessage2This("true");
	}

	@Override
	public void clearTotal() {
		total.clear();
		
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<Integer> getTotal() {
		return total;
	}

	@Override
	public void sendMessage2This(String message) {
		out.write(message + "\n");
		out.flush();
	}
}

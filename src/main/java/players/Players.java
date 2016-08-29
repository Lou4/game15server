package players;

import java.io.IOException;
import java.util.List;

public abstract class Players {
	public abstract int playTurn() throws IllegalArgumentException, IOException, NumberFormatException;
	public abstract void updateTotal(int num);
	public abstract void clearTotal();
	public abstract String getName();
	public abstract List<Integer> getTotal();
	public abstract void sendMessage2This(String message);
}

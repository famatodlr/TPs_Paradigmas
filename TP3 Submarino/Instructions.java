package submarino;

import java.util.ArrayList;
import java.util.Arrays;

public class Instructions {
	public static ArrayList<Character> comands = new ArrayList<>(Arrays.asList('d', 'u', 'r', 'l', 'f', 'm', ' '));

	public void followComand(char comand, Submarine submarine) {
		int index = comands.indexOf(comand);
		Submarine.instructions[index].doInstruction(submarine);
	}
	public void doInstruction(Submarine submarine){
	}

}

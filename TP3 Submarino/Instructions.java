package submarino;

import java.util.ArrayList;
import java.util.Arrays;

public class Instructions {

	public static ArrayList<Character> comands = new ArrayList<>(Arrays.asList('d', 'u', 'r', 'l', 'f', 'm', ' '));

	public Submarine followComand(char comand, Submarine submarine) {
		int index = comands.indexOf(comand);
		return Submarine.instructions[index].doInstruction( submarine );
	}

	public Submarine doInstruction(Submarine submarine){
		return submarine;
	}
}

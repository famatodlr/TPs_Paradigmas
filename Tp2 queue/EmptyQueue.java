package queue;

import java.util.LinkedList;

public class EmptyQueue extends TypesOfQueues{

	public Object take(LinkedList queueList) {
		throw new Error(emptyQueue);
	}

	public Object head(LinkedList queueList) {
		throw new Error(emptyQueue);
	} 
	
	public static String emptyQueue = "Queue is empty";
}

package queue;

import java.util.LinkedList;

public class EmptyQueue extends TypesOfQueues{

	public Object take(LinkedList queueList) {
		throw new Error(Queue.emptyQueue);
	}

	public Object head(LinkedList queueList) {
		throw new Error(Queue.emptyQueue);
	} 
}

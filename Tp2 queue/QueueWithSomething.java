package queue;

import java.util.LinkedList;

public class QueueWithSomething extends TypesOfQueues {
	
	public Object take( LinkedList queueList) {
		return queueList.removeFirst();
	}
	
	public Object head( LinkedList queueList ) {
		return queueList.getFirst();
	}
}

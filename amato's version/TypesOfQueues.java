package queue;

import java.util.LinkedList;

public abstract class TypesOfQueues {

	public abstract Object take(LinkedList queueList) ;
	
	public abstract Object head(LinkedList queueList) ;
	
	public TypesOfQueues update () {
		return new QueueWithSomething();
	}
	
	public TypesOfQueues bringPrevious( TypesOfQueues previous) {
		return previous;
	};
}
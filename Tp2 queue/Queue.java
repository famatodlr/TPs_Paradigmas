package queue;

import java.util.LinkedList;

public class Queue {
	
  public static String emptyQueue = "Queue is empty"; 
  public LinkedList<Object> queueList = new LinkedList<>();
  
  private TypesOfQueues status = new EmptyQueue();
  public TypesOfQueues previousStatus = new EmptyQueue();

  public boolean isEmpty() {
	  return queueList.isEmpty();
	}

	public Queue add( String  element ) {
		queueList.addLast( element );
		
		previousStatus = status;
		status = new QueueWithSomething();
		
		return this;
	}

	public Object take() {
		Object element = status.take(queueList);
		status = previousStatus;
		return element;
	}

	public Object head() {return status.head(queueList);}
	public int size() {return queueList.size();}

}

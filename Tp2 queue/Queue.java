package queue;

import java.util.LinkedList;

public class Queue {
	
  public static String emptyQueue = "Queue is empty"; 
  public LinkedList<Object> queueList = new LinkedList<>();
  
  private TypesOfQueues type = new EmptyQueue();
  public TypesOfQueues previousType = new EmptyQueue();

  public boolean isEmpty() {
	  return queueList.isEmpty();
	}

	public Queue add( String  element ) {
		queueList.addLast( element );
		
		previousType = type;
		type = type.update();
		
		return this;
	}

	public Object take() {
		Object element = type.take(queueList);
		type = previousType;
		return element;
	}

	public Object head() {return type.head(queueList);}
	public int size() {return queueList.size();}

}

package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class QueueTest {

private static final String SECOND = "Second";
private static final String FIRST = "First";
@Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( QueueWithSomething().isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals( SOMETHING, QueueWithSomething().head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = QueueWithSomething();
    queue.take();
    
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    Queue queue = new Queue();
    String addedObject = SOMETHING;
    queue.add( addedObject );
    
    assertEquals( addedObject, queue.take() );
  }

  @Test public void test06QueueBehavesFIFO() {
    Queue queue = new Queue();

    queue.add( firstAddedObject() );
    queue.add( secondAddedObject() );

    assertEquals( queue.take(), firstAddedObject() );
    assertEquals( queue.take(), secondAddedObject() );
    assertTrue( queue.isEmpty() );
  }

  @Test public void test07HeadReturnsFirstAddedObject() {
    Queue queue = new Queue();

    queue.add( firstAddedObject() );
    queue.add( SECOND );

    assertEquals( queue.head(), firstAddedObject() );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = new Queue();
    queue.add( SOMETHING );
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals( 2, new Queue().add( FIRST ).add( SECOND ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    try {
      queue.take();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = new Queue();
    queue.add( SOMETHING );
    queue.take();
    try {
      queue.take();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    try {
      queue.head();
      fail( "Expected Error was not thrown." );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( "Queue is empty" ) );
    }
  }
  
  private Queue QueueWithSomething() {return new Queue().add( SOMETHING );}
  
  private String secondAddedObject() {
		String secondAddedObject = SECOND;
		return secondAddedObject;
	}

	private String firstAddedObject() {
		String firstAddedObject = FIRST;
		return firstAddedObject;
	}
  
  private static final String SOMETHING = "Something";
  
}
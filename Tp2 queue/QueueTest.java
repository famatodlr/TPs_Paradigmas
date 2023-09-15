package queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class QueueTest {

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
    assertEquals( SOMETHING, QueueWithSomething().take() );
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
    Queue queue = QueueWithSomething();
    assertEquals( 1, queue.size() );
    queue.head();
    assertEquals( 1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
	  assertEquals( 2, new Queue().add( FIRST ).add( SECOND ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
	  assertThrowsLike( Queue.emptyQueue , () -> new Queue().take());
  }
  
  @Test public void test11CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = QueueWithSomething();
    queue.take();
    assertThrowsLike( Queue.emptyQueue , () -> queue.take());
  }

  @Test public void test12CanNotHeadWhenThereAreNoObjectsInTheQueue() {
	  assertThrowsLike( Queue.emptyQueue , () -> new Queue().head());
  }
  
  private static final String SOMETHING = "Something";
  private static final String SECOND = "Second";
  private static final String FIRST = "First";
  
  private Queue QueueWithSomething() {return new Queue().add( SOMETHING );}
  
  private String firstAddedObject() {return FIRST;}
  private String secondAddedObject() {return SECOND;}

  public void assertThrowsLike( String msg, Executable codeToRun ) {
	  assertEquals( msg, assertThrows( Error.class, codeToRun ).getMessage() );
}
}
package queue;

import java.util.LinkedList;

public class Queue2 {

    private LinkedList<Object> queueList;

    public Queue2() {
        queueList = new LinkedList<>();
    }

    public boolean isEmpty() {
        return queueList.isEmpty();
    }

    public Queue2 add(Object cargo) {
        queueList.addLast(cargo);
        return this;
    }

    public Object take() {
        return isEmpty() ? error("Queue is empty") : queueList.removeFirst();
    }

    public Object head() {
        return isEmpty() ? error("Queue is empty") : queueList.getFirst();
    }

    public int size() {
        return queueList.size();
    }

    private Object error(String message) {
        throw new Error(message);
    }
}

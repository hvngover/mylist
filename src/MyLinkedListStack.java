import java.util.LinkedList;
import java.util.EmptyStackException;

public class MyLinkedListStack<E> implements MyStack<E> {
    private LinkedList<E> stack;

    // Constructor initializes an empty linked list
    public MyLinkedListStack() {
        stack = new LinkedList<>();
    }
    // Adds an element to the top of the stack
    public void push(E e) {
        stack.addFirst(e);
    }


// Throws an exception if the stack is empty
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }  // Removes and returns the element at the top of the stack
        return stack.removeFirst();
    }

// Throws an exception if the stack is empty
    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getFirst(); // Returns the element at the top of the stack without removing it
    }


    // Returns true if the stack is empty, false otherwise
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Returns the number of elements in the stack
    public int size() {
        return stack.size();
    }
}
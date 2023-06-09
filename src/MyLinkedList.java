
public class MyLinkedList<E> implements MyList<E> {
    private Node<E> head; // reference to the first node in the list
    private int size; // number of elements in the list

    // adds the specified element to the end of the list
    public void add(E element) {
        add(size, element);
    }

    // inserts the specified element at the specified position in the list
    public void add(int index, E element) {
        // Check if index is out of bounds
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        // If adding at beginning of list
        if (index == 0) {
            head = new Node<>(element, head);
            size++;
            return;
        }
        Node<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        // Insert the new node after the current node
        current.next = new Node<>(element, current.next);
        size++;
    }

    // Get the element at a specific index in the list
    public E get(int index) {
        // Throw an exception if the index is invalid
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // Find the node at the specified index
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        // Return the data of the node at the specified index
        return current.data;
    }

    // Remove the element at a specific index in the list
    public E remove(int index) {
        // Throw an exception if the index is invalid
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // If removing the first element
        if (index == 0) {
            // Get the data of the head node, and point the head to the next node
            E element = head.data;
            head = head.next;
            size--;
            return element;
        }

        // Find the node at the index immediately preceding the node to be removed
        Node<E> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        // Get the data of the node to be removed, and point the previous node to the next node
        E element = current.next.data;
        current.next = current.next.next;
        size--;
        return element;
    }

    // Get the size of the list
    public int size() {
        return size;
    }

    // Inner class representing a node in the linked list
    private static class Node<E> {
        // The data stored in the node
        private E data;
        // The next node in the list
        private Node<E> next;

        // Constructor for a node with only data
        private Node(E dataItem) {
            data = dataItem;
            next = null;
        }
        // Constructor for a node with both data and a reference to the next node
        private Node(E dataItem, Node<E> nodeRef) {

            data = dataItem;

            next = nodeRef;

        }
    }

    // Method to delete duplicates in the list
    public void delete_duplicates() {
        Node<E> current = head;
        while (current != null) {
            // Check if the current node's data is equal to the data of any subsequent nodes
            Node<E> runner = current;
            while (runner.next != null) {
                if (current.data.equals(runner.next.data)) {
                    // If a duplicate is found, remove the subsequent node
                    runner.next = runner.next.next;
                    size--;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

}
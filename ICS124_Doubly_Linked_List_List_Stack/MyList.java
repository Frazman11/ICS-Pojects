package Lab4;

import ca.camosun.ics124.lab4.List;
import java.util.NoSuchElementException;

/**
 * List implemented with a doubly linked list.
 *
 * @author c0530980
 * @param <Q> - Generic type
 */
public class MyList<Q> implements List<Q> {

    public Node head = null;
    public Node tail = null;
    public int counter = 0;
    public Node newNode;

    /**
     * Nested Node class, Nodes are objects in the list that hold the datum and
     * have pointers to previous and next.
     */
    private class Node {

        public Q datum;
        public Node previous = null;
        public Node next = null;

        public Node(Q q, Node next, Node previous) {
            this.datum = q;
            this.next = next;
            this.previous = previous;

        }

        @Override
        public String toString() {
            return datum.toString();
        }
    }

    @Override
    public int size() {
        return this.counter;
    }
     
    @Override
    public void clear() {
        head = null;
        tail = null;
        counter = 0;
    }

    @Override
    public Q first() {
        if (head == null) {
            throw new NoSuchElementException("The List is Empty");
        } else {
            return head.datum;
        }
    }

    @Override
    public Q last() {
        if (tail == null) {
            throw new NoSuchElementException("The List is Empty");
        } else {
            return tail.datum;
        }
    }

    /**
     * Finds node at requested index and returns the datum. If supplied index is
     * out of range, throws IndexOutOfBoundsException.
     *
     * @param i - desired index to get datum
     * @return Q - datum of node at supplied index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public Q get(int i) throws IndexOutOfBoundsException {
        //start at head
        Node current = head;
        //iterate of each node until raech requested index
        for (int n = 0; n < i; n++) {
            current = current.next;
        }
        //return datum at current index
        if (current != null) {
            return current.datum;
        } else {
            throw new IndexOutOfBoundsException("Index Out of Bounds: " + i);
        }
    }

    @Override
    public void add(Q q) {
        newNode = new Node(q, head, null);
        counter++;
        //if head not null (list is not empty) update the current head's previous link to the new node
        if (head != null) {
            head.previous = newNode;
        }
        //newNode is now the head
        head = newNode;
        //if tail is null (empty list) then new tail is also newNode
        if (tail == null) {
            tail = newNode;
        }
    }

    @Override
    /**
     * Inserts an element at the given position. If position is over half, method will
     * search starting at the tail, If less than half, search will begin at head. 
     */
    public void add(Q q, int i) {
        //iterate from head through each pointer until you reach the index. use counter.
        //when you reach a node before index, this is the node you will insert in front of.
        //setting current to head moves to first index.
        Node current;
        int currentIndex;
        //here we could test to see if index is greater or less than half size
        if (i < size() / 2) {
            //if less than half, start from beginning
            current = head;
            currentIndex = 0;
            while (currentIndex < i) {
                current = current.next;
                currentIndex++;
            }
            //if greater than half, start from tail and work backwards.
        } else {
            current = tail;
            currentIndex = size();

            while (currentIndex > i) {
                current = current.previous;
                currentIndex--;
            }
        }
        //set new node's next to current node, new node's previous to the current's previous
        newNode = new Node(q, current, current.previous);
        //update the previous node's next link to new Node
        newNode.previous.next = newNode;
        //update current  node's previous to new Node
        current.previous = newNode;
    }

    @Override
    public Q remove(int i) {
        if (i < -size() || i >= size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds: " + i);
        }
        //iterate from head through each pointer until you reach the index. use counter.
        //when you reach a node before index, this is the node you will delete in front of.
        int currentIndex = 0;
        //setting current to head moves to first index.
        Node current = head;

        while (currentIndex < i) {
            current = current.next;
            currentIndex++;
        }
        Q datumReturn = current.datum;
        if (current == head) {
            head = current.next;
        } else {
            current.previous.next = current.next;
        }
        counter--;
        return datumReturn;
    }

    @Override
    public int indexOf(Q q) {
        Node current = head;
        int currentIndex = 1;
        while (current != null) {
            if (current.datum.equals(q)) {
                return currentIndex;
            }
            current = current.next;
            currentIndex++;
        }
        return -1;
    }

    @Override
    public void reverse() {
        //use new node to use as transfer vehicle
        Node temp = new Node(null, null, null);
        Node current = head;
        //swap each node's next and previous references
        while (current != null) {
            temp = current.next;
            //swap pointers (reverses direction)
            current.next = current.previous;
            current.previous = temp;
            //move up one node
            current = temp;
        }
        //finally swap head with tail.
        temp = head;
        head = tail;
        tail = temp;

    }

    @Override
    public MyList<Q> cut(int i) {
        //go until index
        Node current = head;
        int currentIndex = 0;
        while (currentIndex < i) {
            if (current == null) {
                throw new IndexOutOfBoundsException("Index out of bounds!");
            }
            current = current.next;
            currentIndex++;
        }
        //create new List, set new list head to current
        MyList<Q> newList = new MyList();
        newList.counter = this.size() - i;
        newList.head = current;
        //update original list tail;
        tail = current.previous;
        //erase current previous link
        current.previous = null;
        //update tail's next link to null to seperate the lists
        if (tail != null) {
            tail.next = null;
        }
        counter = currentIndex;

        //if new tail is null, list is empty, so set head to null
        if (tail == null) {
            head = null;
        }
        return newList;
    }

    public static void main(String[] args) {
        MyList<String> list1 = new MyList();

        // Test add() method
        list1.add("First Node");
        System.out.println("After 1 node added: ");
        System.out.println("Head: " + list1.head);
        System.out.println(list1.head.datum);

        // Test add() method (adding a second node to the front)
        System.out.println("Adding A Second Node to front:");
        list1.add("Second!");
        System.out.println("Head: " + list1.head);
        System.out.println(list1.head.datum);

        // Test add() method (adding a third node)
        System.out.println("adding third node");
        list1.add("Im the Third");
        System.out.println("head: " + list1.head);
        System.out.println(list1.head.datum);

        // Test add() method (adding a fourth node)
        System.out.println("Adding Fourth Node");
        list1.add("Fourth Node!");
        System.out.println("Head: " + list1.head);
        System.out.println(list1.head.datum);

        // Test add() method (inserting a fifth node at index 3)
        System.out.println("Inserting Node 5 at Index 3");
        list1.add("FIFTH Node!", 3);

        // Test indexOf() method
        System.out.println("Testing with IndexOf()");
        System.out.println("Was fifth node correctly inserted at 3: ");
        System.out.println(list1.indexOf("FIFTH Node!"));

        // Test remove() method
        System.out.println("Testing Remove Fifth (2)");
        System.out.println(list1.remove(2));

        // Test size() method
        System.out.println("Testing Size (Should be 4): " + list1.size());

        // Test first() method
        System.out.println("testing first: (fourth node)" + list1.first());

        // Test last() method
        System.out.println("testing last: (first node)" + list1.last());

        // Test clear() method
        System.out.println("testing clear: ");
        list1.clear();
        System.out.println("head, tail and size: " + list1.head + " " + list1.tail + " " + list1.size());

        MyList<Integer> list2 = new MyList();

        // Test add() method (adding 6 nodes named 1-6)
        System.out.println("Adding 6 nodes named 1-6");
        for (int i = 0; i < 6; i++) {
            list2.add(i + 1);
        }
        System.out.println("List 2 Size should be 6: " + list2.size());
        System.out.println("Head should be 6: " + list2.head);
        System.out.println("Get Index 4 (3): " + list2.get(4));

        // Test reverse() method
        System.out.println("testing Reverse: Is list now 1-->6: ");
        list2.reverse();
        for (int i = 0; i < list2.size(); i++) {
            Integer item = list2.get(i);
            System.out.println(item);
        }

        //test remove() method
        System.out.println("Removing [0] x 6");
        list2.remove(0);
        System.out.println("New head: " + list2.get(0));
        list2.remove(0);
        System.out.println("New head: " + list2.get(0));
        list2.remove(0);
        System.out.println("New head: " + list2.get(0));
        list2.remove(0);
        System.out.println("New head: " + list2.get(0));
        list2.remove(0);
        System.out.println("New head: " + list2.get(0));
        list2.remove(0);
        System.out.println("Should now be empty: " + list2.size());

        //test cut method
        MyList<Integer> list3 = new MyList();
        System.out.println("Adding 6 nodes named 1-6");
        for (int i = 0; i < 6; i++) {
            list3.add(i + 1);
        }
        System.out.println("List3 size: " + list3.size());
        System.out.println("Cutting list at 2: ");
        MyList<Integer> newList = list3.cut(2);
        System.out.println("NewList size (4): " + newList.size());
        for (int i = 0; i < newList.size(); i++) {
            Integer item = newList.get(i);
            System.out.println(item);
        }
        System.out.println("Original list size: " + list3.size());

    }

}

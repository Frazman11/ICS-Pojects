package Lab3;

import ca.camosun.ics124.lab3.Queue;

/**
 * A simple First-In, First-Out (FIFO) container. This queue may not hold null
 * values, since null is used to signal when no element is available for the
 * dequeue() and peek() methods. This Queue is implemented using a circular
 * array.
 *
 * @author C0530980 <your.name at your.org>
 */
public class ArrayQueue<T> implements Queue<T> {

    public T[] queue;
    int tail;
    int head;
    int numInQue; //counter for how many elements are in the queue

    public ArrayQueue(int n) {
        this.queue = (T[]) new Object[n];
    }

    @Override
    public int capacity() {
        return queue.length - numInQue;
    }

    /**
     * Adds an element to the end of the queue. If the queue is found to be
     * full, the queue will grow. IllegalStateException thus removed, as queue
     * will have infinite capacity.
     *
     * @param t - the element to add to the collection.
     */
    @Override
    public void enqueue(T t) {
        if (capacity() == 0) {
//            throw new IllegalStateException("Queue is full");
            this.grow();
        } else if (t == null) {
            throw new NullPointerException("Cannot enqueue null item");
        } else {
            queue[tail] = t;
            numInQue++;
            if (tail != queue.length - 1) {
                tail++;
            } else {
                tail = 0;
            }
        }
    }

    @Override
    public T dequeue() {
        T headElement = null;
        if (queue[head] == null) {
            return null;
        } else {
            headElement = queue[head];
            queue[head] = null;
            numInQue--;
            if (head != queue.length - 1) {
                head++;
            } else if (head == queue.length - 1) {
                head = 0;
            }
        }
        return headElement;
    }

    @Override
    public T peek() {
        if (queue[head] == null) {
            return null;
        } else {
            return queue[head];
        }
    }

    @Override
    public int size() {
        return numInQue;
    }

    public T[] grow() {
        //create a new array with twice the length
        T[] newQueue = (T[]) new Object[queue.length * 2];
        //copy current queue contents to new array
        for (int i = 0; i < numInQue; i++) {
            //use modulus to wrap around the original queue length, stay in range
            newQueue[i] = queue[(head + i) % queue.length];
        }
        //update queue reference to point to new array
        queue = newQueue;
        head = 0;
        tail = numInQue + 1;
        return newQueue;
    }

    //------------Code Graveyard ------------//
// This was my original grow(), using dequeue() to copy elements to new array.
//Ran into problems with numInQue updating while copying, resulting in incorrect 
// new nuInQue and size() for the new array.
//    public T[] grow(){
//        //create a new array with twice the length
//        T[] newQueue = (T[]) new Object[queue.length * 2];
//        //copy current queue contents to new array
//        //numInQueFrozen craeted so that we iterate over the initial number of elements
//        int numInQueFrozen = numInQue;
//        for (int i = 0; i < numInQueFrozen; i++){
//            newQueue[i] = queue[head];
//            this.dequeue();
//        }
//        
//        //update queue reference to point to new array
//        queue = newQueue;
//        head = 0;
//        tail = numInQue + 1;
//        return newQueue;
//        
//    }
    // O(n), change to use index variables
//    @Override
//    public int capacity() {
//        Integer capCount = 0;
//        for (T queue1 : queue) {
//            if (queue1 == null) {
//                capCount++;
//            }
//        }
//        return capCount;
//    }
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        System.out.println("Is it Empty?\nSize: " + queue.size() + " Peek: " + queue.peek() + " Capacity: " + queue.capacity());

        System.out.println("Enqueuing 5 elements:");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Capacity after enqueuing: " + queue.capacity());
        System.out.println("Peek (1st element): " + queue.peek());

        System.out.println("Dequeuing 3 elements:");
        System.out.println("Head of queue: " + queue.dequeue());
        System.out.println("Head of queue: " + queue.dequeue());
        System.out.println("Head of queue: " + queue.dequeue());
        System.out.println("Capacity after dequeuing: " + queue.capacity());

        System.out.println("\nEnqueuing 2 more elements:");
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println("Peek (4th element): " + queue.peek());

        System.out.println("Dequeuing all elements:");
        while (queue.peek() != null) {
            System.out.println("Head of queue: " + queue.dequeue());
        }
        System.out.println("Is it Empty? (Size): " + queue.size());

        System.out.println("\nTesting whether head will wrap around");
        queue.head = 0;
        queue.tail = 0;
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        for (int i = 0; i < 4; i++) {
            queue.dequeue();
        }
        System.out.println("Add 5, remove 4, Head: " + queue.head + " at end of array.");
        queue.enqueue(6);
        System.out.println("Add 1 more --> Tail: " + queue.tail + " wrapped around.");
        queue.dequeue();
        System.out.println("Dequeue--> Head: " + queue.head + " has wrapped around.");
        System.out.println("Successful circular array.");

        System.out.println("Testing grow()");
        queue.head = 0;
        queue.tail = 0;
        queue.numInQue = 0;
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Queue is full (capacity: " + queue.capacity() + "). Attempting to grow.");
        queue.grow();
        System.out.println("New length: " + (queue.size() + queue.capacity())
                + ", new size: " + queue.size()
                + ", new capacity: " + queue.capacity()
                + ", new head: " + queue.head
                + ", new tail: " + queue.tail);
        System.out.println("Successful Growth !");
    }
}

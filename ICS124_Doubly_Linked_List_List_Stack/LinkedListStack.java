
package Lab4;

import ca.camosun.ics124.lab3.Stack;

/**
 * Stack implemented using the Doubly Linked List from MyList class. 
 * @author C0530980 
 */
public class LinkedListStack<Q> implements Stack<Q>{
    public MyList<Q> list;
    int counter = 0;
    
    public LinkedListStack(){
        list = new MyList<>();
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public void push(Q t) {
        list.add(t);
        counter++;
    }

    @Override
    public Q pop() {
        counter--;
        Q item = list.remove(0);
        return item;
        
    }

    @Override
    public Q peek() {
        return list.get(0);
    }

    @Override
    public int size() {
        return counter;
    }
    public static void main(String[] args) {
        // Test stack implementation using List
        
        LinkedListStack<Integer> stack1 = new LinkedListStack<>();
        // Test isEmpty() method
        System.out.println("Is it Empty?: " + stack1.isEmpty());

        // Test size() method
        System.out.println("Is Size 0: " + stack1.size());

        // Test push() method
        System.out.println("\nPushing elements: 1-5");
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);

        // Test isEmpty() method
        System.out.println("Is it Empty?: " + stack1.isEmpty());

        // Test size() method
        System.out.println("Is Size 5: " + stack1.size());

        // Test peek() method
        System.out.println("Peek (5): " + stack1.peek());

        // Test pop() method
        System.out.println("\nPopping 3 elements:");
        System.out.println("Top of stack: " + stack1.pop());
        System.out.println("Top of stack: " + stack1.pop());
        System.out.println("Top of stack: " + stack1.pop());

        // Test size() method
        System.out.println("Is Size 2: " + stack1.size());

        // Test push() method (pushing 2 more elements)
        System.out.println("Pushing 2 more elements:");
        stack1.push(6);
        stack1.push(7);

        // Test peek() method
        System.out.println("Peek (7): " + stack1.peek());

        // Test pop() method (popping all elements)
        System.out.println("\nPopping all elements (stack = 7,6,2,1):");
        while (!stack1.isEmpty()) {
            System.out.println("Top of stack: " + stack1.pop());
        }

        // Test isEmpty() method
        System.out.println("Is it Empty?: " + stack1.isEmpty());

        // Test size() method
        System.out.println("Is Size 0: " + stack1.size());
    }
}

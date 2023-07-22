package Lab3;

import ca.camosun.ics124.lab3.Stack;

/**
 * A simple Last-In, First-Out (LIFO) container. This stack may not hold null
 * values, since null is used to signal when no element is available for the
 * pop() and peek() methods. This stack is implemented using an array, and can
 * automatically grow when full. 
 *
 * @author C0530980
 */
public class ArrayStack<T> implements Stack<T> {

    T[] stack;
    int emptyTopOfStack = 0;

    public ArrayStack(int n) {
        this.stack = (T[]) new Object[n];
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int size() {
        return (emptyTopOfStack);
    }
    /**
     * Add an element to the top of the stack. If stack is full, stack will grow
     * to allow more elements. IllegalStateException commented out due to
     * stack's ability to grow.
     *
     * @param t
     */
    @Override
    public void push(T t) {
        if (t == null) {
            throw new NullPointerException("Cannot push Null object onto stack");
//        } else if (size() == stack.length) {
//            throw new IllegalStateException("Stack is full");
        } else if (emptyTopOfStack == stack.length - 1) {
            this.grow();
        }
        stack[emptyTopOfStack++] = t;
    }

    private T[] grow() {
        //create a new array with twice the length
        T[] newStack = (T[]) new Object[stack.length * 2];
        //copy current queue contents to new array
        for (int i = 0; i <= emptyTopOfStack; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
        return newStack;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T t = stack[emptyTopOfStack - 1];
            stack[emptyTopOfStack - 1] = null;
            if (emptyTopOfStack != 0) {
                emptyTopOfStack--;
            }
            return t;
        }
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stack[emptyTopOfStack - 1];
        }
    }

    // ---------Code GraveYard--------------//
//    @Override
//    public void push(T t) {
    //this is O(n) and we want to avoid this. use a variable to keep track of the empty index
//        try {
//            if (size() == stack.length) {
//                throw new IllegalStateException("Stack is full");
//            }
//            for (int i = 0; i < stack.length; i++) {
//                if (stack[i] == null) {
//                    stack[i] = t;
//                    break;
//                }
//            }
//        } catch (NullPointerException e) {
//            throw new NullPointerException("Cannot push Null object onto stack");
//        }
//    }
    // This is also o(n), use counter variables to keep track of index instead of iterating thourgh every time
//    @Override
//    public T pop() {
//        T t = null;
//        if (isEmpty()) {
//            return null;
//        } else {
//            for (int i = stack.length - 1; i >= 0; i--) {
//                if (stack[i] != null) {
//                    t = stack[i];
//                    stack[i] = null;
//                    break;
//                }
//            }
//        }
//        return t;
//    }
    public static void main(String[] args) {
        ArrayStack stack1 = new ArrayStack(5);
        System.out.println("Is it Empty?: " + stack1.isEmpty());
        System.out.println("Is Size 0: " + stack1.size());
        System.out.println("\nPushing elements: 1-5");
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        System.out.println("Is it Empty?: " + stack1.isEmpty());
        System.out.println("Is Size 5: " + stack1.size());
        System.out.println("Peek (5): " + stack1.peek());
        System.out.println("\nPopping 3 elements:");
        System.out.println("Top of stack: " + stack1.pop());
        System.out.println("Top of stack: " + stack1.pop());
        System.out.println("Top of stack: " + stack1.pop());
        System.out.println("Is Size 2: " + stack1.size());
        System.out.println("Pushing 2 more elements:");
        stack1.push(6);
        stack1.push(7);
        System.out.println("Peek (7): " + stack1.peek());
        System.out.println("\nPopping all elements (stack = 7,6,2,1 :");
        while (!stack1.isEmpty()) {
            System.out.println("Top of stack: " + stack1.pop());
        }
        System.out.println("Is it Empty?: " + stack1.isEmpty());
        System.out.println("Is Size 0: " + stack1.size());
        System.out.println("\nTesting grow(). Filling Stack (5)");
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        System.out.println("attempting to add another element to full stack:");
        stack1.push(6);
        System.out.println("new size: " + stack1.size() + " new stack array length: "
                + stack1.stack.length + "\nTop of Stack: " + stack1.peek());
        System.out.println("Stack successfully grows and populates.");
    }
}

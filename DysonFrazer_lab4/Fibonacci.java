package DysonFrazer_lab4;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Fibonacci Number: ");
        int inputFib = input.nextInt();

        int currentFib = 1;
        int previousFib = 0;
        int nextFib = 0;

        //loop to produce fib numbers starting with 0, 1, until currentFib = inputFib 
        //for (previousFib = 0;nextFib <= inputFib;){
        //    currentFib = nextFib + previousFib;
        //    previousFib = nextFib;
        //    nextFib = currentFib;
        //    System.out.println("Current Fib = " + currentFib);
        
        //while current fib number is less than input fib number, find next and update values.
        do {
            nextFib = currentFib + previousFib;
            previousFib = currentFib;
            currentFib = nextFib;
        } while (currentFib <= inputFib);
        System.out.printf("Next Fibonacci Number: %d\n", nextFib);
        
    }
}


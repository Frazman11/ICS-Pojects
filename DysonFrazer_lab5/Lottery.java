package DysonFrazer_lab5;
import java.util.Scanner;

public class Lottery {
    static int numGuess = 0;
    static int[] guesses; //declare a class variable so that it can be used by the moreTickets and winnings2 methods
    static int reRollCount = 0;
    static int winnings = 0;
    static String winCond;
    public static void main(String[] args) {

        int lottery = lotteryNum();
        // System.out.println("Lottery Number: " + lottery);   //print for code testing
        
        
        int guess = getLotteryNumber();
        winnings = winningsMethod(guess, lottery);
        if(winCond.equals("Jackpot!!!")){
            System.out.println(winCond + "\nCongratulations, You Win " + winnings + "$!!" ); 
            System.exit(0); //exit the program if jackpot is hit.
        }
        
        else if(winnings > 0){
            System.out.println(winCond + "\nCongratulations, You Win " + winnings + "$!!" ); //subtract ticket cost from winnings
            
        }
        if(winnings == 0){
            System.out.println(winCond + " You win $0. Please Play Again.");
        }

        String answer;
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("Would you like to play again? Each Re-Roll of the lottery, the rewards narrow by 5%. (y/n)");
            answer = input.nextLine();
        }while ((!answer.equals("y")) && (!answer.equals("n")));
        //continue to ask for input while the answer is NOT equal to y or n
        
        
        if(answer.equals("y")){ //if user answers yes, offer more Tickets and Re-Roll, until they say no
            do{
                reRollCount++; //update number of re-rolls
                int[] newGuesses = moreTickets();  //make a new array called guesses and fill with moreTickets method
                winnings = winningsMethod2(newGuesses, lottery);

                if(winnings == 0){
                    System.out.println("You Still Win $0.. ");
                    System.out.println("Would you like to play again? Each Re-Roll of the lottery, the rewards narrow by 5%. (y/n)");
                    answer = input.nextLine();
                }
                else if(winCond.equals("Jackpot!!!")){
                    System.out.println(winCond + "\nCongratulations, You Win " +((1-.05*reRollCount)*winnings - numGuess*25) + "$!!" ); //subtract ticket cost and scale down for amount of re-rolls from winnings
                    System.exit(0); //exit the program if jackpot is hit.

                
                }else{
                    System.out.println(winCond + "\nCongratulations, You Win " +((1-.05*reRollCount)*winnings - numGuess*25) + "$!!" ); //subtract ticket cost and scale down for amount of re-rolls from winnings
                    System.out.println("Would you like to play again? Each Re-Roll of the lottery, the rewards narrow by 5%. (y/n)");
                    answer = input.nextLine();
                }
        }while(!answer.equals("n"));
        }
    }
    
//make array and fill with guess values
    public static int[] moreTickets(){

    
        Scanner input = new Scanner(System.in);
        System.out.println("How many Tickets do you wish to buy? Tickets are $25 each");
        numGuess = input.nextInt();

        System.out.print("Make " +numGuess+ " guesses (0-99) at the lottery number!\n");
        int[] newGuesses = new int[numGuess]; //create an arrya to hold the next xtickets guesses

        for(int i = 0; i <= numGuess-1; i++){
            newGuesses[i] = getLotteryNumber(); //each cell is filled using original getLotteryNumber method
        }
        
        return newGuesses; //return the array

    }

    public static int lotteryNum() {
        //randomly generate a number 0-99 and split into digits
        int lottery = (int) (Math.random() * 100);
        return lottery;
    }

    public static int getLotteryNumber() {
        Scanner input = new Scanner(System.in);
        int guess;
    
        do {
            System.out.print("Enter your lottery number (0-99): ");
            
            
            while(!input.hasNextInt()){     //if input is not an int...
                System.out.println("Invalid Input..Lottery Number must be an Integer from 0-99, try again: ");
                input.next();   //discard invalid input, continue to recieve input until an int is entered
            }
            guess = input.nextInt();
    
            if (guess < 0 || guess > 99) {
                System.out.println("Lottery number must be between 0 and 99.");
            }
            
        } while (guess < 0 || guess > 99);  //continue to ask until valid guess entered
        System.out.println("Thank you, guess recorded: " + guess);
        return guess;
    }

    public static int winningsMethod(int guess, int lottery) {
    //split lottery and guess into single digits
        int winnings = 0;
        int lottery1 = lottery / 10;    //lottery digit 1
        int lottery2 = lottery % 10;

        int guess1 = guess / 10;    //GUESS DIGIT 1
        int guess2 = guess % 10;

        //determine winnings based on rules:
        //If the user input matches the lottery number exactly, the award is $10,000.
        if (guess == lottery) {
            winnings = 10000;
            winCond = "Jackpot!!!";

        } //If the user enters the correct digits, but in the wrong order, the award is $3000.
        else if ((guess1 == lottery1 || guess1 == lottery2) & (guess2 == lottery1 || guess2 == lottery2)) {
            winnings = 3000;
            winCond = "Digits reversed!!";
        } //If the lottery number has two digits and the user's guess contains just one of them, 
        //the award is $1000.
        else if ((lottery >= 10) && ((guess1 == lottery1) || (guess1 == lottery2) || (guess2 == lottery1) || (guess2 == lottery2))) {
            winnings = 1000;
            winCond = "One Digit Correct!";
        } //In all other cases, there is no award.
        else {
            winnings = 0;
            winCond = "No Match!";
        }
        return winnings;
    }
    public static int winningsMethod2(int[] moreGuesses, int lottery) {     //same winningsMethod but takes an array (kinda overloading? )
        //split lottery and guess into single digits
            int winnings = 0;
            int lottery1 = lottery / 10;
            int lottery2 = lottery % 10;

            for(int i =0; i < moreGuesses.length; i++){
                int guess1 = moreGuesses[i] / 10;
                int guess2 = moreGuesses[i] % 10;
    
                //determine winnings based on rules:
                //If the user input matches the lottery number exactly, the award is $10,000.
                if (moreGuesses[i] == lottery) {
                    winnings = 10000;
                    winCond = "Jackpot!!!";
                } //If the user enters the correct digits, but in the wrong order, the award is $3000.
                else if ((guess1 == lottery1 || guess1 == lottery2) & (guess2 == lottery1 || guess2 == lottery2)) {
                    winnings = 3000;
                    winCond = "Digits reversed!!";

                } //If the lottery number has two digits and the user's guess contains just one of them, 
                //the award is $1000.
                else if ((lottery >= 10) && ((guess1 == lottery1) || (guess1 == lottery2) || (guess2 == lottery1) || (guess2 == lottery2))) {
                    winnings = 1000;
                    winCond = "One Digit Correct!";

                } //In all other cases, there is no award.
                else {
                    winnings = 0;
                    winCond = "No Match!";
                }
                
            }
            return winnings;
        }
            
}


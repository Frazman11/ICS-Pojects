/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DysonFrazer_lab4;

import java.util.Scanner;

public class Interest {

    public static void main(String[] args) {

        final int COMPOUND_PER_YEAR = 1; // annual
        final double INTEREST_RATE = 0.025; // 2.5% / year
        double principal; // initial investment, $
        double future; // value at end of investment, $
        Scanner input = new Scanner(System.in);
        
        while (true){
        while (true){
            System.out.print("Initial Investment: ");

            if (input.hasNextDouble()) {
                principal = input.nextDouble();
                if (principal > 0) {
                    break;
                } else {
                    System.out.println("Invalid Input (must be greater than 0)");
                }
            }else if (input.hasNext()){
            System.out.println("Please enter an int, not a String!");
            continue;
            }
        }

        // 6 month term, no compounding (simple interest)
    
            future = principal * (1 + INTEREST_RATE / 2);

            System.out.printf("6 month: $%,.2f\n", future);

            // 1-5 year terms, compounding
            future = principal;
            for (int years = 1; years < 6; years++) {
                future *= (1 + INTEREST_RATE / COMPOUND_PER_YEAR);
                System.out.printf(years + " year:  $%,.2f\n", future);
            }
        }
    }
}


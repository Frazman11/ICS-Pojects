/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DysonFrazer_lab4;

import java.util.Scanner;

/**
 *
 * @author c0530980
 */
public class Matrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in);
        System.out.println("What is the Height of the Matrix?");
        int matrixSize = input.nextInt();
        System.out.println("What Type of Matrix would you like? Triangle Left (1), Triangle Right (2), Mario Wall Left (3), Mario Wall Right (4), Diamond (5)");
        int matrixTypeI = input.nextInt();

        String matrixType[] = {"TriangleLeft", "TriangleRight", "MarioWallLeft", "MarioWallRight", "Diamond"};
        
        

        
        //basic triangle matrix method
        //out loop to iterate over rows of wall, from entered height to 0
        for(int y = 0; y <= matrixSize; y++){
            
            //inner loop to iterate over columns and print *, while number of stars = y
            for(int x = 0; x <= y; x++){
            System.out.printf("*");
        }
            System.out.printf("\n");
        }
    }
}

package DysonFrazer_lab4;

import java.util.Scanner;
/**
 *
 * @author c0530980
 */
public class MatrixFinal {
    
    public static void main(String[] args) {
        // Get inputs for matrix height and triangle type...
        Scanner input = new Scanner(System.in);
        System.out.println("What is the Height of the Matrix?");
        int matrixSize = input.nextInt();
        System.out.println("Which type of matrix do you want?\n1 = traingle right\n2 = triangle left\n3 = Mario Wall left\n4 = Mario Wall Right\n5 = Diamond");
                        int shape = input.nextInt();
                        
                        //switch based on triangle type input
                        switch(shape){
                            case 1: triangleRight(matrixSize);
                            break;
                            case 2: triangleLeft(matrixSize);
                            break;
                            case 3: marioWallLeft(matrixSize);
                            break;
                            case 4: marioWallRight(matrixSize);
                            break;
                            case 5: diamond(matrixSize);
                            break;
                        }
    }
//Triangle Methods taking MatrixSize as attribute listed BELOW//

    static void triangleRight(int matrixSize){
 //out loop to iterate over rows of wall, from entered height to 0
        
            for(int y = matrixSize; y > 0; y--){
            
                //inner loop to iterate over columns and print *, while number of stars = y
                for(int x = 0; x < y; x++){
                System.out.printf("*");
        }
            System.out.printf("\n");
        }
    }

    static void triangleLeft(int matrixSize){
     //out loop to iterate over rows of wall, from entered 0 to entered Height
        for(int y = 0; y < matrixSize; y++){
            //iterate from matrixSize to y and print SPACES
            for(int x = matrixSize; x > matrixSize - y; x--){   
                System.out.printf(" ");
            }
            //inner loop to iterate over columns and print *, while number of stars = y
            for(int x = 0; x < matrixSize - y; x++){
            System.out.printf("*");
            }
            System.out.printf("\n");
        }
 }  

    static void marioWallLeft(int matrixSize){
     //out loop to iterate over rows of wall, from entered 0 to entered Height
        for(int y = 0; y <= matrixSize; y++){
            //iterate from matrixSize to y and print SPACES
            for(int x = matrixSize; x > y; x--){   
                System.out.printf(" ");
            }
            //inner loop to iterate over columns and print *, while number of stars < y
            for(int x = 0; x < y; x++){
            System.out.printf("*");
        }
            System.out.printf("\n");
        }
 }

    static void marioWallRight(int matrixSize){
    //out loop to iterate over rows of wall, from entered 0 to entered Height
        for(int y = 0; y <= matrixSize; y++){
            //inner loop to iterate over columns and print *, while number of stars < y
            for(int x = 0; x < y; x++){
            System.out.printf("*");
        }
            // //iterate from matrixSize to y and print SPACES
            // for(int x = matrixSize; x > y; x--){   
            //     System.out.printf(" ");
            // }
            System.out.printf("\n");
        }
  }

    static void diamond(int matrixSize){
        //out loop to iterate over rows of wall, from entered 0 to entered Height
        for(int y = 0; y <= matrixSize; y++){
            
            //iterate from 0 while x < matrixSize - y and print SPACES on left
            for(int x = 0; x < matrixSize - y; x++){   
                System.out.printf(" ");
            }

            //inner loop to iterate over columns and print * in middle, while number of stars <= 2*y-1 (1,3,5,7....)
            for(int x = 0; x < 2*y-1; x++){
            System.out.printf("*");
            }
            //iterate from 0 to matrixsize - y and print SPACES on right
            for(int x = 0; x < matrixSize - y; x++){   
                System.out.printf(" ");
            }
            System.out.printf("\n");
        }
        //whhen height is reached, repeat starting at matrixsize - 1, with y decreasing
        for(int y = (matrixSize - 1) ; y >= 0; y--){
            
            //iterate from 0 to matrixsize - y and print SPACES on left
            for(int x = 0; x < matrixSize - y; x++){   
                System.out.printf(" ");
            }

            //inner loop to iterate over columns and print * in middle, while number of stars < 2*y-1 (1,3,5,7...)
            for(int x = 0; x < 2*y-1; x++){
            System.out.printf("*");
            }
            //iterate from 0 while > matrixsize - y and print SPACES
            for(int x = 0; x < matrixSize - y; x++){   
                System.out.printf(" ");
            }
            System.out.printf("\n");
        }
    }
}

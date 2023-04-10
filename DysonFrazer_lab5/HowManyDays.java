/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DysonFrazer_lab5;
import java.util.Scanner;





/**
 *
 * @author C0530980
 */
public class HowManyDays 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        int year;
        int month;
        
        Scanner input = new Scanner(System.in);
        System.out.print("What year is it? ");
        year = input.nextInt();
        System.out.print("What month is it? (1-12) ");
        month = input.nextInt();
        
        System.out.println(daysInMonth(month, year));
    }
        
        
    public static int daysInMonth(int month, int year){
        int numDays = 0;
    //make switch based on the month entered, assign number to numDays
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
                
            //if month is 2, determine if it is a leap year
            case 2:
                //if leap year assign 29 days
                if(year %4 == 0){
                    
                    //if divisble by 4 possible leap year. check if divisble by 100 and not divisble by 400
                    if((year %100 == 0)&(year %400 != 0)){
                        numDays = 28;
                        break;}
                    else if(year %400 == 0){
                        numDays = 29;
                        break;}
                }
                else{
                    numDays = 28;
                    break;
                }
            }
        return numDays;
    }
}
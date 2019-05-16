/*****************************************
 * Xin Ying Weng
 * xw2600
 * 4/10/19
 * 
 * Human.java - Human class for human Nim player
 * Ask user for the number of marbles
 * the user want to take in each round.
 ****************************************/ 
import java.util.Scanner;

public class Human {
   
    private int choice;
    private Scanner input;
    
    public Human() {
        input = new Scanner(System.in);
        choice = -1;
    }
   
    public void move() {
        System.out.print("How many? Please take at least 1 and at most half of the marbles: ");
            choice = input.nextInt();
    }
    
    public int getChoice(){
        return choice;
    }  
}

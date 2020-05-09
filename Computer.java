/*****************************************
 * @Rennah Weng
 * 4/10/19
 * 
 * Human.java - Human class for human player
 * Decide the number of marbles the
 * computer takes in each round.
 ****************************************/ 
import java.util.Random;

public class Computer{
    
    private int mode;
    private int choice;
    
    public Computer(int m){
        mode = m;
        choice = -1;
    }
    
    public void move(int marblesLeft){
        /* draw a random # of marbles between 1 and n/2 if
         * 1. it plays stupid mode OR if
         * 2. the size of the pile is one less than a power of two */

        // play stupid if 1
        if ( mode == 1 || this.isPowerOfTwo(marblesLeft + 1) ) {

            //min = 1, max = marblesLeft/2
            choice = (int) ( Math.random() * (marblesLeft/2) + 1);
        }
        
        // play smart if 2
        else {
            /* calculate the least number of marbles should be taken:
             * 
             * Find the power of 2 that is the closest to marblesLeft -->
             * floor(log base 2 of (marblesLeft)) = the closest exponent that -->
             * 2^closest exponent = closest powerOfTwo to marblesLeft
             * 
             * After the draw, new marblesLeft should be powerOf2 -1 -->
             * new marblesLeft = (closest powerOfTwo)-1 -->
             * so choice is the difference between the old marblesLeft and new marblesLeft -->
             * choice = marblesLeft - new marblesLeft -->
             * choice = marblesLeft - ( (closest powerOfTwo)-1 ).
            */
            int closestExp = (int) ( Math.log(marblesLeft) / Math.log(2) );
            int closestPowerOfTwo = (int) Math.pow(2, closestExp);
            choice = marblesLeft - (closestPowerOfTwo - 1);
        } 
    }
    
    public int getChoice() {
        return choice;
    }
    
    private boolean isPowerOfTwo(int num) {
        //checks if the # of marbles is a power of two

        // return false if 0
        if (num == 0) {
            return false;
        }
        
        // check using modulus
        else {
            while (num != 1) {
                if (num % 2 != 0) {
                    return false;
                }
                num /= 2;
            }
            return true;
        }
    }
}

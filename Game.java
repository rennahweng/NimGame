/*****************************************
 * @Rennah Weng
 * 
 * Game.java - Game class for Nim game
 * Human player plays against computer player.
 ****************************************/ 
public class Game {
    
    private int marbles;
    private Human humanPlayer;
    private Computer computerPlayer;
    
    public Game(int difficulty){
        // generate a random pile of marbles 10 to 100
        int MAX_PILE = 100;
        int MIN_PILE = 10;
        marbles = (int) (Math.random()*(MAX_PILE - MIN_PILE + 1)) + MIN_PILE;
        
        humanPlayer = new Human();
        computerPlayer = new Computer(difficulty);
    }
     
    // Game starting point
    public void play() {
        
        //DECIDE WHO GOES FIRST RANDOMLY
        int playerTurn = (int) Math.round(Math.random());
        // if 0, computer plays
        // if 1, human plays
        
        //PLAY MORE ROUNDS UNTIL ONLY ONE MARBLE LEFT
        while(marbles > 1) {
            this.oneRound(playerTurn);
            //alternate turns by making playerTurn into 0 or 1
            playerTurn = Math.abs(playerTurn - 1);
        }
        
        //DETERMINE WHO IS THE WINNER
        // check which player has to take the last one marble:
        
        // human wins if last turn is computer
        if(playerTurn == 0) {
            System.out.println("\n***YOU WIN!***");
        }
        // Computer wins if last turn is human
        else {
            System.out.println("\n***YOU LOSE! COMPUTER WINS!***");
        }
    }
  
        
    private void oneRound(int playerTurn) {
        
        // display remaining marbles before each round
        System.out.println("\nTotal marbles left: " + marbles);
        
        // count the marble(s) taken by each player in each round
        int marblesTaken = 0;
        
        // computer plays
        if (playerTurn == 0) {
            System.out.println("----------Computer's turn--------");
            computerPlayer.move(marbles);
            marblesTaken = computerPlayer.getChoice();
            System.out.println("Computer took: " + marblesTaken);
        }
        
        // human plays
        else {
            System.out.println("-----------Your turn-------------");

            // check if human player takes a legal number of marbles
            while(true) {
                humanPlayer.move();
                marblesTaken = humanPlayer.getChoice();
                
                // keep user's input if legal
                if ( (marblesTaken >= 1) && (marblesTaken <= (marbles/2)) ) {
                    System.out.println("You took: " + marblesTaken);
                    break;
                }
                // re-prompt if illegal
                System.out.println("ILLEGAL MOVE! Please enter again.\n");
            }
        }
        
        //get total # of marbles left after each round
        marbles -= marblesTaken;
    }
}

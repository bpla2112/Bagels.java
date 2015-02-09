import java.util.Random;
import javax.swing.JOptionPane;

/**
 * A class to play the game of Bagels
 * @author Bernardo Pla
 */
public class Bagels
{
   // instance variable declarations go here
    private int secretNum ; // stores the random secret number
    private int guessNum ; // stores the user guess
    private int digit1 ; // first random number between 1 and 9
    private int digit2 ; // second random number between 0 and 9
    private int digit3 ; // third random number between 0 and 9
    private int guess1 ; // first digit of user guess
    private int guess2 ; // second digit of user guess
    private int guess3 ; // third digit of user guess
    private int countGuess ; // counts the guesses

   // creates a random number generator object
   private static Random r = new Random();

   /**
    * Creates a Bagels object
    */
   public Bagels()
   {
       countGuess = 0; // initializes counter at 0 each game
       
       
      
// NOTE: Since the secret number is initialized in a separate method,
      // the constructor body may be left empty (unless you have other
      // instance vars to initialize)
   }

   /**
    * Conducts a game and prints the results
    */
   public void play()
   {
      generateSecretNumber();
      
      do
      {
          String play = JOptionPane.showInputDialog("Enter a 3 digit number" + 
                  " not starting with 0. Or press cancel to quit.  ");
          if(play != null)
          {
          guessNum = Integer.parseInt(play);
          
          System.out.print("\n" + guessNum + " ");                  
          
          this.evaluateGuess();
          countGuess++ ;
          }
          else
          {
              System.out.println("Quitting already? ");
              System.exit(0);
          }
      }
      while (guessNum != secretNum);
      
      System.out.println("It took you " + countGuess + " guesses. Well done!");
      
      if(guessNum == secretNum)
      {
          String playagain = JOptionPane.showInputDialog("Would you like to play again? Y/N ");
          if(playagain.equalsIgnoreCase("y"))
          {
              countGuess = (countGuess - countGuess);
              this.play();
              
              
          }
          if(playagain.equalsIgnoreCase("n"))
          {
              System.out.println("Thanks for playing! ");
              System.exit(0);
          }
      }
      
              
// write method body here
   }

   // Generates three random single digit ints.  The first cannot be zero
   // and all three will be different. Called by public method play()
   private void generateSecretNumber()
   {
      do
      {
          secretNum = r.nextInt(900)+100 ;
          digit1 = secretNum / 100 ;
          digit2 = (secretNum -(digit1 * 100)) / 10 ;
          digit3 = (secretNum -(digit1 *100)-(digit2 * 10));
      }
      while((digit1 == digit2) || (digit2 == digit3) || (digit3 == digit1)) ;
// write method body here
   }

   /* Evaluates the user's guess and prints the guess and hints to System.out.
    Called by public method play()
   */
   private void evaluateGuess()
   {
       System.out.println();
       
      if(secretNum == guessNum)
      {
          System.out.println("Well Done! You Win! ");
          
      }
      else
      {
          guess1 = guessNum / 100 ;
          guess2 = (guessNum%100) /10 ;
          guess3 = (guessNum%100) % 10 ;
          
          if(guess1 == digit1 )
          {
              
              System.out.print("Fermi ");
          }
          if(guess2 == digit2)
          {
              
              System.out.print("Fermi ");
          }
          if(guess3 == digit3)
          {
              
              System.out.print("Fermi ");
          }
           if (guess1 == digit2 || guess1 == digit3) 
           {
                System.out.print("Pico ");
            }
            
            if (guess2 == digit3 || guess2 == digit1) {
                System.out.print("Pico ");
            }
            
            if (guess3 == digit1 || guess3 == digit2) {
                System.out.print("Pico ");
            }
          else if((guess1 != digit1) && (guess1 != digit2) && (guess1 != digit3)
                  && (guess2 != digit1) && (guess2 != digit2) && (guess2 != digit3)
                  && (guess3 != digit1) && (guess3 != digit2) && (guess3 != digit3))
          {
              System.out.println("Bagels! ");
          }
                  
                  
      }
// write method body here
   }

   // Returns a value of true or false indicating whether the current
   // guess is a winner. Called by public method play()
   private boolean isWinner()
   {
       if(guess1 == digit1 && guess2 == digit2 && guess3 == digit3)
       {
           return true ;
       }    
       // write method body here

      // NOTE: this return statement is here only so the class skeleton
      // will compile.  Feel free to use or discard
       else
       {
           return false;           
       }
      
   }
}


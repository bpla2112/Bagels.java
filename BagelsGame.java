import java.awt.Component;
import javax.swing.JOptionPane;

public class BagelsGame {
    private static Component frame;
    
    public static void main(String[]args){
        Bagels game = new Bagels();
        int answer = 0 ;
       
        
        JOptionPane.showMessageDialog(frame, "Bagels! Here are the rules: "
        + "\nGuess the secret number in the fewest tries possible. "+
                "\nDo not start with the number 0 and enter any 3 digit number " +
                "\nDo not repeat digits. " + "\nFermi means you have a number in the correct position. "
        + "\nPico means you have a number but in the wrong position. " + "\nBagels means the number has no mathches."
        + "\nGood Luck! ");
        
        while(answer != JOptionPane.NO_OPTION)
        {
            answer = JOptionPane.showConfirmDialog(null,"Ready for Bagels? ", "Choose ", JOptionPane.YES_NO_OPTION) ;
            
            if(answer == JOptionPane.YES_OPTION)
            {
                game.play();
            }
            else
            {
                System.out.println("See you next time! ");
                System.exit(0);
            }
            
           
        }
    }
}

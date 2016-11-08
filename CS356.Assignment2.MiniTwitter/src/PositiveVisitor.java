
import javax.swing.JOptionPane;


/**
 * This is PositiveVisitor class that displays positive message percentage
 * @author Miraj
 */
public class PositiveVisitor  implements TwitterVisitor{
    
    // counter for total messages and positive messages
    private int messageCounter = 0, posCounter = 0;
    
    // array of words that are considered positive
    private static final String[] positiveWords = {"good", "great","excellent"};
    
    /*
    * visitUser method counts positive message by user
    */
    @Override
    public void visitUser(TwittSubject node) {
        if(!(node instanceof User)){
            return;
        } else{
            for(String s : ((User)node).getMessageFeed()){
                messageCounter++;
                for(String posWords : positiveWords){
                    if(s.toLowerCase().contains(posWords)){
                        posCounter++;
                        break;
                    }
                }
            }
        }
    
    }

    /*
    * displayResult is used to display positive message percentage in a dialog box
    */
    @Override
    public void displayResult() {
        if(messageCounter == 0){
            JOptionPane.showMessageDialog(null, "Positive Message Percentage: 0",
                        "Positive Messages", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
        JOptionPane.showMessageDialog(null, "Positive Message Percentage: " + ((posCounter * 100)/messageCounter),
                        "Positive Messages", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}


import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miraj
 */
public class PositiveVisitor  implements TwitterVisitor{
    
    private int messageCounter = 0, posCounter = 0;
    private static final String[] positiveWords = {"good", "great","excellent"};
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

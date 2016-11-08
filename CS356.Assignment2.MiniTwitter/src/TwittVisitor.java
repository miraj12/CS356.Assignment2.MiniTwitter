
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
public class TwittVisitor implements TwitterVisitor{
    private int messageCounter = 0;

    @Override
    public void visitUser(TwittSubject node) {
        
        if(!(node instanceof User)){
            return;
        }
        else{
            messageCounter += ((User)node).getMessageFeed().size();
        }
    }

    @Override
    public void displayResult() {
        JOptionPane.showMessageDialog(null, "Total Messages: " + messageCounter, "Message Count", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}

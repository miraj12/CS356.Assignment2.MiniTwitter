
import javax.swing.JOptionPane;



/**
 * TwittVisitor class is used to count total messages from all message feeds
 * @author Miraj
 */
public class TwittVisitor implements TwitterVisitor{
    // total message counter
    private int messageCounter = 0;
    
    /**
    * visitUser visits user and counts number of message in the current feed.
    */
    @Override
    public void visitUser(TwittSubject node) {
        
        if(!(node instanceof User)){
            return;
        }
        else{
            messageCounter += ((User)node).getMessageFeed().size();
        }
    }
    /**
    * displayResult is used to display total messages in dialog box
    */
    @Override
    public void displayResult() {
        JOptionPane.showMessageDialog(null, "Total Messages: " + messageCounter, "Message Count", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}

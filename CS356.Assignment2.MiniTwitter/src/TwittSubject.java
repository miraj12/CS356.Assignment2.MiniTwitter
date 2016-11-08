
import java.util.LinkedList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 * TwittSubject is abstract class allows observers to register and get updates.
 * @author Miraj
 */
public abstract class TwittSubject extends DefaultMutableTreeNode implements Visitable {
    
    private List<TwittObserver> followers;
    
    public TwittSubject(){
        super();
        followers = new LinkedList<>();
    }
    /**
     * attach adds observers/followers.
     */
    public void attach(TwittObserver ob){
        followers.add(ob);
    }
    /**
     * notifyObserver notifies the observers/followers of user messages
     */
    public void notifyObserver(){
        for(TwittObserver ob : followers){
            ob.update(this);
        }
    }
}

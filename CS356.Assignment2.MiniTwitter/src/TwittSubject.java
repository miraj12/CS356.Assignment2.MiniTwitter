
import java.util.LinkedList;
import java.util.List;
import javax.swing.tree.DefaultMutableTreeNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miraj
 */
public abstract class TwittSubject extends DefaultMutableTreeNode implements Visitable {
    
    private List<TwittObserver> followers;
    
    public TwittSubject(){
        super();
        followers = new LinkedList<>();
    }
    
    public void addObserver(TwittObserver ob){
        followers.add(ob);
    }
    
    public void notifyObserver(){
        for(TwittObserver ob : followers){
            ob.update(this);
        }
    }
}

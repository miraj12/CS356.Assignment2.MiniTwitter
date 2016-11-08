
import java.util.Enumeration;
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
public class Group extends DefaultMutableTreeNode implements Visitable {
    
    public Group(String userID){
        super();
        super.setAllowsChildren(true);
        super.setUserObject(userID);
    }

    @Override
    public void accept(TwitterVisitor visitor) {
        Enumeration<DefaultMutableTreeNode> e = this.children();
        
        while(e.hasMoreElements()){
            ((Visitable)e.nextElement()).accept(visitor);
        }
    }

    
    
}


import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 * This is the Group class that uses DefaultMutableTreeNode as component from
 * Composite pattern. It forms tree like structure allows to have any number of
 * users under the group that are tree nodes. Also implements Visitable allowing
 * to reach user nodes under group.
 * @author Miraj
 */
public class Group extends DefaultMutableTreeNode implements Visitable {
    
    public Group(String userID){
        super();
        super.setAllowsChildren(true);
        super.setUserObject(userID);
    }

    // visitor to reach child node
    @Override
    public void accept(TwitterVisitor visitor) {
        Enumeration<DefaultMutableTreeNode> e = this.children();
        
        while(e.hasMoreElements()){
            ((Visitable)e.nextElement()).accept(visitor);
        }
    }

    
    
}

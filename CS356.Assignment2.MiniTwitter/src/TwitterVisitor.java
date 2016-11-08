

/**
 * This is the TwitterVisitor interface allows to visit user nodes for 
 * different operations and display results.
 * @author Miraj
 */
public interface TwitterVisitor {
    public void visitUser(TwittSubject node);
    public void displayResult();
    
}



/**
 * This interface uses Observer pattern. It allows to update on notifyObserver 
 * from subject.
 * @author Miraj
 */
public interface TwittObserver {
    public void update(TwittSubject subject);
}

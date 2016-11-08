
import java.util.LinkedList;
import java.util.List;


/**
 * User class represents each user, it extends subject and implements observer
 * allowing to observe other users
 * @author Miraj
 */
public class User extends TwittSubject implements TwittObserver {
    // list of followings and messages for each user
    private List<String> followings, messageFeed;
    // holds message
    private String message;
    
    //user control panel, each user has only one control panel 
    //simply  hide it when closed instead of creating new panel
    private UserUI userIns = null;
    
    public User(String userId){
        
        super();
        super.setAllowsChildren(false);
        super.setUserObject(userId);
        followings = new LinkedList<>();
        messageFeed = new LinkedList<>();
        
    }
    /**
    * This method gets the UI control panel for this user
    */
    public UserUI getUserUI(){
        if(userIns == null){
            userIns = new UserUI(this);
            this.attach(userIns); 
        }
        
        return userIns;
    }
    
    /**
    * This method gets userId for the user
    */
    public String getUserId(){
        return (String) super.getUserObject();
    }
    
    /**
    * This method is used to set the current message from user
    */
    public void setCurrentMessage(String message){
        this.message = message;
        messageFeed.add(0,this.getUserId()+": "+ message);  
    }
    
    /**
    * This method is used to get message from user
    */
    public  String getCurrentMessage(){
        return message;
    }
    /**
    * This method is used to get the user's whole message feed.
    */
    public List<String> getMessageFeed(){
        return messageFeed;
    }

    /**
    * This method is used to get current followings for the user
    */
    public List<String> getFollowings(){
        return followings;
    }
    
    /**
    * This method allows to add the followings for the user
    */
    public void addToFollowings(String user){
        followings.add(user);
    }
   
    /**
    * This method updates the users message feed when followings has posted
    * method
    */
    @Override
    public void update(TwittSubject subject) {
        if(subject instanceof User){
            messageFeed.add(0, ((User)subject).getUserId()+": "+ ((User)subject).getCurrentMessage());
        }
    }
    
    /**
    *This method allows access to other visitors.
    */
    @Override
    public void accept(TwitterVisitor visitor) {
        visitor.visitUser(this);
    }

   
}


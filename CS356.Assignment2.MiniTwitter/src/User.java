
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miraj
 */
public class User extends TwittSubject implements TwittObserver {
    
    private List<String> followings, messageFeed;
    private String message;
    
    private UserUI userIns = null;
    
    public User(String userId){
        
        super();
        super.setAllowsChildren(false);
        super.setUserObject(userId);
        followings = new LinkedList<>();
        messageFeed = new LinkedList<>();
        
    }
    
    public UserUI getUserUI(){
        if(userIns == null){
            userIns = new UserUI(this);
            this.addObserver(userIns); 
        }
        
        return userIns;
    }
    
    public String getUserId(){
        return (String) super.getUserObject();
    }
    
    public void setCurrentMessage(String message){
        this.message = message;
        messageFeed.add(0,this.getUserId()+": "+ message);  
    }
    
    public  String getCurrentMessage(){
        return message;
    }
    
    public List<String> getMessageFeed(){
        return messageFeed;
    }

    public List<String> getFollowings(){
        return followings;
    }
    
    public void addToFollowings(String user){
        followings.add(user);
    }
   

    @Override
    public void update(TwittSubject subject) {
        if(subject instanceof User){
            messageFeed.add(0, ((User)subject).getUserId()+": "+ ((User)subject).getCurrentMessage());
        }
    }
    
    @Override
    public void accept(TwitterVisitor visitor) {
        visitor.visitUser(this);
    }

   
}


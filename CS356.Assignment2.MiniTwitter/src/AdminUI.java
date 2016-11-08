
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 * This class is the UI control panel for the admin user, 
 * it uses singleton pattern.
 * 
 * @author Miraj
 */
public class AdminUI extends javax.swing.JFrame implements ActionListener{
    // userTree displays users and groups in tree format
    private JTree userTree;
    private static AdminUI instance = null;
    // variables to keep count of user and group, it does not consider root as group
    private int userCount = 0, groupCount = 0;
    
    // this hashsets has all the users and groups added so far, purpose is to 
    // not allow duplicate user ids or group ids.
    private HashSet<String> users,groups;
    
    private AdminUI() {
        initComponents();
        initialize();
    }
    //Lazy loading for singleton pattern
    public static AdminUI getInstance(){
        if(instance == null){
            instance = new AdminUI();
        }
        return instance;
    }
    
    /*
    * This method initializes JTree with position and root node. It also addes
    * listeners for total message feed and positive message percentage.
    */
    private void initialize(){
        DefaultMutableTreeNode root = new Group("ROOT");
        
        users = new HashSet<>();
        groups = new HashSet<>();
        
        userTree = new JTree(root);
        userTree.setBounds(12,20,150,305);
        getContentPane().add(userTree);
        groups.add("root");
        
        
        //total message button listener
        messageTotal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                TwittVisitor tVisit = new TwittVisitor();
                ((Group)root).accept(tVisit);
                tVisit.displayResult();
            }
        });
        
        // positive message percentage button listener
        posPercentage.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e){
                 PositiveVisitor posVisit = new PositiveVisitor();
                 ((Group)root).accept(posVisit);
                 posVisit.displayResult();
             }   
        
        });
        
    }
    /*
    * This method performs action based on the button pressed such as add user,
    * add group, and open user view. It also makes sure no duplicate user or group
    * is added and also group cannot be added under user
    */
    @Override
    public void actionPerformed(ActionEvent ae) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) userTree.getLastSelectedPathComponent();
        
        if(selectedNode == null){
            selectedNode = (DefaultMutableTreeNode) userTree.getModel().getRoot();
        }
        
        switch(ae.getActionCommand()){
            
            case "addUser":{
                try{
                    String id = userId.getText();
                    if(!users.contains(id.toLowerCase()) && !id.equals("")){
                       selectedNode.add(new User(id));
                       userTree.updateUI();
                       users.add(id.toLowerCase());
                       userCount++;
                       userId.setText("");
                    }
                    else{
                       JOptionPane.showMessageDialog(null, "Invalid user id.", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "User cannot be added in selected location.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
            
            case "addGroup":{
                try{
                    String id = groupId.getText();
                    if(!groups.contains(id.toLowerCase()) && !id.equals("")){
                       selectedNode.add(new Group(id));
                       userTree.updateUI();
                       groups.add(id.toLowerCase());
                       groupCount++;
                       groupId.setText("");
                    }
                    else{
                       JOptionPane.showMessageDialog(null, "Invalid group id", 
                                        "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Group cannot be added in selected location.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                }
                break;
            }
            
            case "viewUser":{
                if(selectedNode instanceof User){
                    User user = (User) selectedNode;
                    java.awt.EventQueue.invokeLater(() -> {
                        try {
                            user.getUserUI().setVisibility(true);
                        } catch(Exception e){
                        }
                    });
                }
                else {
                    JOptionPane.showMessageDialog(null, "select user", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userId = new javax.swing.JTextField();
        addUser = new javax.swing.JButton();
        groupId = new javax.swing.JTextField();
        addGroup = new javax.swing.JButton();
        userView = new javax.swing.JButton();
        totalUser = new javax.swing.JButton();
        groupTotal = new javax.swing.JButton();
        messageTotal = new javax.swing.JButton();
        posPercentage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Control Panel");

        userId.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        userId.setToolTipText("Add userID");

        addUser.setText("Add User");
        addUser.addActionListener(this);
        addUser.setActionCommand("addUser");

        groupId.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        groupId.setToolTipText("Add groupId");

        addGroup.setText("Add Group");
        addGroup.addActionListener(this);
        addGroup.setActionCommand("addGroup");

        userView.setText("Open User View");
        userView.setToolTipText("open user's panel");
        userView.addActionListener(this);
        userView.setActionCommand("viewUser");

        totalUser.setText("Total User");
        totalUser.setToolTipText("display total user");

        groupTotal.setText("Total Group");
        groupTotal.setToolTipText("display total group");

        messageTotal.setText("Total Message");
        messageTotal.setToolTipText("display total messages");

        posPercentage.setText("Positive Percentage");
        posPercentage.setToolTipText("positive messages percentage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(messageTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(totalUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(posPercentage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(groupTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(groupId, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(userId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(userView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groupId, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(userView, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(totalUser, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(groupTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(posPercentage, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(messageTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        totalUser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Total User: " + userCount,
                    "Total Users", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        groupTotal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Total Group: " + groupCount,
                    "Total Group", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addGroup;
    private javax.swing.JButton addUser;
    private javax.swing.JTextField groupId;
    private javax.swing.JButton groupTotal;
    private javax.swing.JButton messageTotal;
    private javax.swing.JButton posPercentage;
    private javax.swing.JButton totalUser;
    private javax.swing.JTextField userId;
    private javax.swing.JButton userView;
    // End of variables declaration//GEN-END:variables

   
}

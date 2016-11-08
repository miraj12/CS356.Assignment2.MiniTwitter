
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mirajpatel
 */
public class Driver {
    public static void main(String[] args){
        try {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ae) {
           
                }
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AdminUI admin = AdminUI.getInstance();
                admin.setVisible(true);
            }
        });
    }
    
}

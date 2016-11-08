
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;



/**
 * Driver class for mini twitter
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

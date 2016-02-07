/**
 *
 * @author Blacqueous
 */
package project_001_hris;

public class Project_001_hris {

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        try {
//            Thread.sleep(1000);
//            Thread.sleep(10);
        } catch(Exception e) { }
        
        FrameLogin frm = new FrameLogin();
        
        try {  // Open program if successful.
            int max = 1;
            if( max == 0 ){
                frm.setSize(frm.getMinimumSize());
                frm.setLocationRelativeTo(null);
            } else {
                frm.setExtendedState(frm.MAXIMIZED_BOTH);
            }
            frm.setVisible(true);
        } catch (Exception e) {  // Close program if error.
            frm.dispose();
        }

    }

}

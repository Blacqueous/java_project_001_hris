/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author egrubellano
 */
public class ClassLoadNewPanel {

    private JPanel panelFrame;
    private JPanel panelPopup;
    private JPanel panelParent;
    private final ClassConstantsCustom constant = new ClassConstantsCustom();

    public void loadFrame(final JPanel panel, final JPanel panelFrameMain) {
        
        coreLoadPanel(panel, constant.PANEL_FRAME, panelFrameMain, null);
    }

    public void loadPopup(final JPanel panel, final JPanel panelFramePopup) {
        
        coreLoadPanel(panel, constant.PANEL_POPUP, null, panelFramePopup);
    }

    public JPanel setParentPanel(JPanel parent) {
        
        this.panelParent = parent;
        return this.panelParent;
    }

    /**
     *
     * @param panel
     * @param type frame(1) or pop-up(2)
     */
    private void coreLoadPanel(final JPanel panel, final int type, final JPanel panelFrameMain, final JPanel panelFramePopup) {
        
        final JPanel panel_parent = this.panelParent;
        final CardLayout mainLayout = (CardLayout) panel_parent.getLayout();
        
        @SuppressWarnings("unchecked")
        
        SwingWorker<Void, Void> sw = new SwingWorker() {
            
            @Override
            protected Object doInBackground() throws Exception {
                
                mainLayout.show(panel_parent, "card_loading");
                
                try {
                    if (type == constant.PANEL_FRAME) {
                        if (panelFrame == null || panelFrame.isVisible()) {
                            
                            panelFrameMain.removeAll();
                            panelFrame = panel;
                            panelFrameMain.add(panelFrame);
                        }
                    } else if (type == constant.PANEL_POPUP) {
                        if (panelPopup == null || panelPopup.isVisible()) {
                            
                            panelFramePopup.removeAll();
                            panelPopup = panel;
                            panelFramePopup.add(panelPopup);
                        }
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error Occured When Loading", "ERROR!", JOptionPane.ERROR_MESSAGE);
                }
                
                return null;
            }
            
            @Override
            protected void done() {
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                mainLayout.show(panel_parent, "card_main");
                            }
                        },
                        1000
                );
            }
        };
        
        sw.execute();
    }

}

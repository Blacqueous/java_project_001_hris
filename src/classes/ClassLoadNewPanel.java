/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.CardLayout;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
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
    private ButtonGroup buttons = new ButtonGroup();
    private final ClassConstantsCustom constant = new ClassConstantsCustom();

    public void goFrameHome(final JPanel panelFrameMain) {
        
        final JPanel panel_parent = this.panelParent;
        final CardLayout mainLayout = (CardLayout) panel_parent.getLayout();
        
        @SuppressWarnings("unchecked")
        
        SwingWorker<Void, Void> sw = new SwingWorker() {
            
            @Override
            protected Object doInBackground() throws Exception {
                
                mainLayout.show(panel_parent, "card_loading");
                
                try {
                    panelFrameMain.removeAll();
                } catch (Exception ex) {
                    // System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error occured while loading the desired panel.", "ERROR :: Loading panel", JOptionPane.ERROR_MESSAGE);
                }
                
                return null;
            }
            
            @Override
            protected void done() {
                new java.util.Timer().schedule(
                        new java.util.TimerTask() {
                            @Override
                            public void run() {
                                mainLayout.show(panel_parent, "card_home");
                            }
                        },
                        1000
                );
            }
        };
        
        sw.execute();
    }
    
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

    public ButtonGroup setButtonGroup(ButtonGroup button_group) {
        
        this.buttons = button_group;
        return this.buttons;
    }

    /**
     * @param bool
     */
    private void changeButtonStatus(boolean bool) {
        
        Enumeration<AbstractButton> elements = this.buttons.getElements();
        while (elements.hasMoreElements()) {
            AbstractButton button = (AbstractButton)elements.nextElement();
            if (button.isEnabled()) {
                button.setEnabled(bool);
            }
        }
    }

    /**
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
                    // System.out.println(ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error occured while loading the desired panel.", "ERROR :: Loading panel", JOptionPane.ERROR_MESSAGE);
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

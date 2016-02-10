/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author egrubellano
 */
public class FramePrime extends javax.swing.JFrame {

    /**
     * Creates new form FramePrime
     */
    public FramePrime() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btn_grp = new javax.swing.ButtonGroup();
        panel_btns = new javax.swing.JPanel();
        panel_btn_labels = new javax.swing.JPanel();
        panel_logo = new javax.swing.JPanel();
        label_logo = new javax.swing.JLabel();
        label_background = new javax.swing.JLabel();
        label_btn = new javax.swing.JLabel();
        toolbar_controller = new javax.swing.JToolBar();
        label_ = new javax.swing.JLabel();
        button_dbd = new javax.swing.JToggleButton();
        button_cmp = new javax.swing.JToggleButton();
        button_emp = new javax.swing.JToggleButton();
        button_cat = new javax.swing.JToggleButton();
        button_dpt = new javax.swing.JToggleButton();
        button_pos = new javax.swing.JToggleButton();
        button_elg = new javax.swing.JToggleButton();
        button_trn = new javax.swing.JToggleButton();
        button_lvs = new javax.swing.JToggleButton();
        separator = new javax.swing.JSeparator();
        panel_main = new javax.swing.JPanel();
        panel_menu = new javax.swing.JPanel();
        separator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_btns.setMaximumSize(new java.awt.Dimension(200, 10));
        panel_btns.setLayout(new java.awt.BorderLayout());

        panel_btn_labels.setBackground(new java.awt.Color(50, 50, 50));
        panel_btn_labels.setMaximumSize(new java.awt.Dimension(200, 130));
        panel_btn_labels.setMinimumSize(new java.awt.Dimension(200, 130));
        panel_btn_labels.setName(""); // NOI18N
        panel_btn_labels.setPreferredSize(new java.awt.Dimension(200, 130));
        panel_btn_labels.setLayout(new java.awt.BorderLayout());

        panel_logo.setMaximumSize(new java.awt.Dimension(190, 10));
        panel_logo.setMinimumSize(new java.awt.Dimension(190, 10));
        panel_logo.setPreferredSize(new java.awt.Dimension(190, 10));
        panel_logo.setLayout(new java.awt.GridBagLayout());

        label_logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/merged/misc/logo-pure-tiny.png"))); // NOI18N
        label_logo.setIconTextGap(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panel_logo.add(label_logo, gridBagConstraints);

        label_background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/merged/misc/img-darker.png"))); // NOI18N
        label_background.setIconTextGap(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        panel_logo.add(label_background, gridBagConstraints);

        panel_btn_labels.add(panel_logo, java.awt.BorderLayout.CENTER);

        label_btn.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        label_btn.setForeground(new java.awt.Color(255, 255, 255));
        label_btn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/merged/white/icon_25_category.png"))); // NOI18N
        label_btn.setText("MENU  ");
        label_btn.setIconTextGap(10);
        label_btn.setMaximumSize(new java.awt.Dimension(200, 40));
        label_btn.setMinimumSize(new java.awt.Dimension(200, 40));
        label_btn.setPreferredSize(new java.awt.Dimension(200, 40));
        panel_btn_labels.add(label_btn, java.awt.BorderLayout.PAGE_END);

        panel_btns.add(panel_btn_labels, java.awt.BorderLayout.PAGE_START);

        toolbar_controller.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        toolbar_controller.setFloatable(false);
        toolbar_controller.setOrientation(javax.swing.SwingConstants.VERTICAL);
        toolbar_controller.setMaximumSize(new java.awt.Dimension(200, 10));
        toolbar_controller.setMinimumSize(new java.awt.Dimension(200, 10));
        toolbar_controller.setPreferredSize(new java.awt.Dimension(200, 10));

        label_.setIconTextGap(10);
        label_.setMaximumSize(new java.awt.Dimension(200, 3));
        label_.setMinimumSize(new java.awt.Dimension(200, 3));
        label_.setName(""); // NOI18N
        label_.setPreferredSize(new java.awt.Dimension(200, 3));
        toolbar_controller.add(label_);

        btn_grp.add(button_dbd);
        button_dbd.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        button_dbd.setForeground(new java.awt.Color(40, 40, 40));
        button_dbd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_32_speedometer.png"))); // NOI18N
        button_dbd.setText("Dashboard");
        button_dbd.setFocusable(false);
        button_dbd.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        button_dbd.setIconTextGap(8);
        button_dbd.setMargin(new java.awt.Insets(2, 25, 2, 14));
        button_dbd.setMaximumSize(new java.awt.Dimension(180, 48));
        button_dbd.setMinimumSize(new java.awt.Dimension(180, 48));
        button_dbd.setPreferredSize(new java.awt.Dimension(180, 48));
        toolbar_controller.add(button_dbd);

        btn_grp.add(button_cmp);
        button_cmp.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        button_cmp.setForeground(new java.awt.Color(40, 40, 40));
        button_cmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_32_tower_2.png"))); // NOI18N
        button_cmp.setText("Company");
        button_cmp.setFocusable(false);
        button_cmp.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        button_cmp.setIconTextGap(8);
        button_cmp.setMargin(new java.awt.Insets(2, 25, 2, 14));
        button_cmp.setMaximumSize(new java.awt.Dimension(180, 48));
        button_cmp.setMinimumSize(new java.awt.Dimension(180, 48));
        button_cmp.setPreferredSize(new java.awt.Dimension(180, 48));
        toolbar_controller.add(button_cmp);

        btn_grp.add(button_emp);
        button_emp.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        button_emp.setForeground(new java.awt.Color(40, 40, 40));
        button_emp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_32_staff_group_01.png"))); // NOI18N
        button_emp.setText("Employees");
        button_emp.setFocusable(false);
        button_emp.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        button_emp.setIconTextGap(8);
        button_emp.setMargin(new java.awt.Insets(2, 25, 2, 14));
        button_emp.setMaximumSize(new java.awt.Dimension(180, 48));
        button_emp.setMinimumSize(new java.awt.Dimension(180, 48));
        button_emp.setPreferredSize(new java.awt.Dimension(180, 48));
        toolbar_controller.add(button_emp);

        btn_grp.add(button_cat);
        button_cat.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        button_cat.setForeground(new java.awt.Color(40, 40, 40));
        button_cat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_32_category_black.png"))); // NOI18N
        button_cat.setText("Categories");
        button_cat.setFocusable(false);
        button_cat.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        button_cat.setIconTextGap(8);
        button_cat.setMargin(new java.awt.Insets(2, 25, 2, 14));
        button_cat.setMaximumSize(new java.awt.Dimension(180, 48));
        button_cat.setMinimumSize(new java.awt.Dimension(180, 48));
        button_cat.setPreferredSize(new java.awt.Dimension(180, 48));
        toolbar_controller.add(button_cat);

        btn_grp.add(button_dpt);
        button_dpt.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        button_dpt.setForeground(new java.awt.Color(40, 40, 40));
        button_dpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_32_museum.png"))); // NOI18N
        button_dpt.setText("Departments");
        button_dpt.setFocusable(false);
        button_dpt.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        button_dpt.setIconTextGap(8);
        button_dpt.setMargin(new java.awt.Insets(2, 25, 2, 14));
        button_dpt.setMaximumSize(new java.awt.Dimension(180, 48));
        button_dpt.setMinimumSize(new java.awt.Dimension(180, 48));
        button_dpt.setPreferredSize(new java.awt.Dimension(180, 48));
        toolbar_controller.add(button_dpt);

        btn_grp.add(button_pos);
        button_pos.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        button_pos.setForeground(new java.awt.Color(40, 40, 40));
        button_pos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_32_briefcase.png"))); // NOI18N
        button_pos.setText("Positions");
        button_pos.setFocusable(false);
        button_pos.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        button_pos.setIconTextGap(8);
        button_pos.setMargin(new java.awt.Insets(2, 25, 2, 14));
        button_pos.setMaximumSize(new java.awt.Dimension(180, 48));
        button_pos.setMinimumSize(new java.awt.Dimension(180, 48));
        button_pos.setPreferredSize(new java.awt.Dimension(180, 48));
        toolbar_controller.add(button_pos);

        btn_grp.add(button_elg);
        button_elg.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        button_elg.setForeground(new java.awt.Color(40, 40, 40));
        button_elg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_32_checklist_01.png"))); // NOI18N
        button_elg.setText("Eligibilities");
        button_elg.setFocusable(false);
        button_elg.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        button_elg.setIconTextGap(8);
        button_elg.setMargin(new java.awt.Insets(2, 25, 2, 14));
        button_elg.setMaximumSize(new java.awt.Dimension(180, 48));
        button_elg.setMinimumSize(new java.awt.Dimension(180, 48));
        button_elg.setPreferredSize(new java.awt.Dimension(180, 48));
        toolbar_controller.add(button_elg);

        btn_grp.add(button_trn);
        button_trn.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        button_trn.setForeground(new java.awt.Color(40, 40, 40));
        button_trn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_32_blackboard_drawing.png"))); // NOI18N
        button_trn.setText("Trainings");
        button_trn.setFocusable(false);
        button_trn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        button_trn.setIconTextGap(8);
        button_trn.setMargin(new java.awt.Insets(2, 25, 2, 14));
        button_trn.setMaximumSize(new java.awt.Dimension(180, 48));
        button_trn.setMinimumSize(new java.awt.Dimension(180, 48));
        button_trn.setPreferredSize(new java.awt.Dimension(180, 48));
        toolbar_controller.add(button_trn);

        btn_grp.add(button_lvs);
        button_lvs.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        button_lvs.setForeground(new java.awt.Color(40, 40, 40));
        button_lvs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_32_tags_three_.png"))); // NOI18N
        button_lvs.setFocusable(false);
        button_lvs.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        button_lvs.setIconTextGap(8);
        button_lvs.setLabel("Leave List");
        button_lvs.setMargin(new java.awt.Insets(2, 25, 2, 14));
        button_lvs.setMaximumSize(new java.awt.Dimension(180, 48));
        button_lvs.setMinimumSize(new java.awt.Dimension(180, 48));
        button_lvs.setPreferredSize(new java.awt.Dimension(180, 48));
        toolbar_controller.add(button_lvs);

        panel_btns.add(toolbar_controller, java.awt.BorderLayout.CENTER);

        separator.setOrientation(javax.swing.SwingConstants.VERTICAL);
        separator.setMaximumSize(new java.awt.Dimension(2, 2));
        separator.setMinimumSize(new java.awt.Dimension(2, 2));
        separator.setPreferredSize(new java.awt.Dimension(2, 2));
        panel_btns.add(separator, java.awt.BorderLayout.LINE_END);

        getContentPane().add(panel_btns, java.awt.BorderLayout.LINE_START);

        panel_main.setLayout(new java.awt.BorderLayout());

        panel_menu.setMaximumSize(new java.awt.Dimension(10, 91));
        panel_menu.setMinimumSize(new java.awt.Dimension(10, 91));
        panel_menu.setPreferredSize(new java.awt.Dimension(10, 91));
        panel_menu.setLayout(new java.awt.BorderLayout());

        separator1.setMaximumSize(new java.awt.Dimension(2, 2));
        separator1.setMinimumSize(new java.awt.Dimension(2, 2));
        separator1.setPreferredSize(new java.awt.Dimension(2, 2));
        panel_menu.add(separator1, java.awt.BorderLayout.PAGE_END);

        panel_main.add(panel_menu, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(panel_main, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FramePrime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btn_grp;
    private javax.swing.JToggleButton button_cat;
    private javax.swing.JToggleButton button_cmp;
    private javax.swing.JToggleButton button_dbd;
    private javax.swing.JToggleButton button_dpt;
    private javax.swing.JToggleButton button_elg;
    private javax.swing.JToggleButton button_emp;
    private javax.swing.JToggleButton button_lvs;
    private javax.swing.JToggleButton button_pos;
    private javax.swing.JToggleButton button_trn;
    private javax.swing.JLabel label_;
    private javax.swing.JLabel label_background;
    private javax.swing.JLabel label_btn;
    private javax.swing.JLabel label_logo;
    private javax.swing.JPanel panel_btn_labels;
    private javax.swing.JPanel panel_btns;
    private javax.swing.JPanel panel_logo;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JSeparator separator;
    private javax.swing.JSeparator separator1;
    private javax.swing.JToolBar toolbar_controller;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import classes.ClassConstantsCustom;
import classes.ClassDateFormatValue;
import classes.ClassLoadNewPanel;
import classes.ClassMyDBConnectionEmbeddedDerby;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author egrubellano
 */
public class PanelEmployeesCreate extends javax.swing.JPanel {

    private final ClassDateFormatValue fmtDateVal = new ClassDateFormatValue();
    private final ClassLoadNewPanel load_panel = new ClassLoadNewPanel();
    private final PanelEmployeesCreateProfile  panel_crtpfl = new PanelEmployeesCreateProfile();
    private final PanelEmployeesCreateDependent  panel_crtdep = new PanelEmployeesCreateDependent();
    private final PanelEmployeesCreateEligibility  panel_crtelg = new PanelEmployeesCreateEligibility();
    private final PanelEmployeesCreateTraining  panel_crttrn = new PanelEmployeesCreateTraining();
    protected FramePrime panel_ancestor;
    protected PanelEmployees panel_parent;
    protected ClassConstantsCustom constant;

    /**
     * Creates new form PanelEmployeesCreate
     */
    public PanelEmployeesCreate() {
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

        panel_control = new javax.swing.JPanel();
        classImageCropPanel = new classes.ClassImageCropPanel_v1();
        panel_ctrl = new javax.swing.JPanel();
        panel_ctrl_btn = new javax.swing.JPanel();
        panel_ctrl_btn_sav = new javax.swing.JPanel();
        label_button_sav = new javax.swing.JLabel();
        panel_ctrl_btn_clr = new javax.swing.JPanel();
        label_button_clr = new javax.swing.JLabel();
        label_button_bck = new javax.swing.JLabel();
        panel_center = new javax.swing.JPanel();
        panel_control_button = new javax.swing.JPanel();
        panel_control_button_list = new javax.swing.JPanel();
        panel_control_button_pfl = new javax.swing.JPanel();
        label_button_pfl = new javax.swing.JLabel();
        panel_control_button_dep = new javax.swing.JPanel();
        label_button_dep = new javax.swing.JLabel();
        panel_control_button_elg = new javax.swing.JPanel();
        label_button_elg = new javax.swing.JLabel();
        panel_control_button_trn = new javax.swing.JPanel();
        label_button_trn = new javax.swing.JLabel();
        panel_frame = new javax.swing.JPanel();
        panel_main = new javax.swing.JPanel();
        panel_loading = new javax.swing.JPanel();
        label_loading_animated = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        panel_control.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 10, 10, 10));
        panel_control.setMaximumSize(new java.awt.Dimension(185, 0));
        panel_control.setMinimumSize(new java.awt.Dimension(185, 0));
        panel_control.setName(""); // NOI18N
        panel_control.setOpaque(false);
        panel_control.setPreferredSize(new java.awt.Dimension(175, 0));
        panel_control.setLayout(new java.awt.BorderLayout());

        classImageCropPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 159)));
        classImageCropPanel.setDefaultSize(155);
        classImageCropPanel.setMaximumSize(new java.awt.Dimension(155, 155));
        classImageCropPanel.setMinimumSize(new java.awt.Dimension(155, 155));
        classImageCropPanel.setPanelControls(0);
        classImageCropPanel.setPanelMode(0);
        classImageCropPanel.setPreferredSize(new java.awt.Dimension(155, 155));
        panel_control.add(classImageCropPanel, java.awt.BorderLayout.PAGE_START);

        panel_ctrl.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 5, 0));
        panel_ctrl.setOpaque(false);
        panel_ctrl.setLayout(new java.awt.BorderLayout());

        panel_ctrl_btn.setMinimumSize(new java.awt.Dimension(0, 200));
        panel_ctrl_btn.setOpaque(false);
        panel_ctrl_btn.setPreferredSize(new java.awt.Dimension(0, 200));
        panel_ctrl_btn.setLayout(new java.awt.GridLayout(2, 0));

        panel_ctrl_btn_sav.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panel_ctrl_btn_sav.setOpaque(false);
        panel_ctrl_btn_sav.setLayout(new java.awt.BorderLayout());

        label_button_sav.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        label_button_sav.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_button_sav.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_32_form_photo.png"))); // NOI18N
        label_button_sav.setText("save employee");
        label_button_sav.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 159)));
        label_button_sav.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_button_sav.setIconTextGap(10);
        label_button_sav.setOpaque(true);
        label_button_sav.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        label_button_sav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_button_savMouseClicked(evt);
            }
        });
        panel_ctrl_btn_sav.add(label_button_sav, java.awt.BorderLayout.CENTER);

        panel_ctrl_btn.add(panel_ctrl_btn_sav);

        panel_ctrl_btn_clr.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panel_ctrl_btn_clr.setOpaque(false);
        panel_ctrl_btn_clr.setLayout(new java.awt.BorderLayout());

        label_button_clr.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        label_button_clr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_button_clr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_32_form_wizard.png"))); // NOI18N
        label_button_clr.setText("clear form");
        label_button_clr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 159)));
        label_button_clr.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        label_button_clr.setIconTextGap(10);
        label_button_clr.setOpaque(true);
        label_button_clr.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        label_button_clr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_button_clrMouseClicked(evt);
            }
        });
        panel_ctrl_btn_clr.add(label_button_clr, java.awt.BorderLayout.CENTER);

        panel_ctrl_btn.add(panel_ctrl_btn_clr);

        panel_ctrl.add(panel_ctrl_btn, java.awt.BorderLayout.PAGE_START);

        panel_control.add(panel_ctrl, java.awt.BorderLayout.CENTER);

        label_button_bck.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        label_button_bck.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_button_bck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_16_back_black.png"))); // NOI18N
        label_button_bck.setText("back ");
        label_button_bck.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 159)));
        label_button_bck.setIconTextGap(10);
        label_button_bck.setMaximumSize(new java.awt.Dimension(0, 50));
        label_button_bck.setMinimumSize(new java.awt.Dimension(0, 50));
        label_button_bck.setOpaque(true);
        label_button_bck.setPreferredSize(new java.awt.Dimension(0, 50));
        label_button_bck.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        label_button_bck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_button_bckMouseClicked(evt);
            }
        });
        panel_control.add(label_button_bck, java.awt.BorderLayout.PAGE_END);

        add(panel_control, java.awt.BorderLayout.LINE_START);

        panel_center.setOpaque(false);
        panel_center.setLayout(new java.awt.BorderLayout());

        panel_control_button.setMaximumSize(new java.awt.Dimension(0, 65));
        panel_control_button.setMinimumSize(new java.awt.Dimension(0, 65));
        panel_control_button.setName(""); // NOI18N
        panel_control_button.setOpaque(false);
        panel_control_button.setPreferredSize(new java.awt.Dimension(0, 75));
        panel_control_button.setLayout(new java.awt.CardLayout());

        panel_control_button_list.setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 0, 10, 0));
        panel_control_button_list.setMinimumSize(new java.awt.Dimension(500, 560));
        panel_control_button_list.setOpaque(false);
        panel_control_button_list.setPreferredSize(new java.awt.Dimension(100, 570));
        panel_control_button_list.setLayout(new java.awt.GridLayout(1, 0));

        panel_control_button_pfl.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 8));
        panel_control_button_pfl.setMinimumSize(new java.awt.Dimension(220, 220));
        panel_control_button_pfl.setOpaque(false);
        panel_control_button_pfl.setPreferredSize(new java.awt.Dimension(220, 220));
        panel_control_button_pfl.setLayout(new java.awt.BorderLayout());

        label_button_pfl.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        label_button_pfl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_button_pfl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_20_users_00.png"))); // NOI18N
        label_button_pfl.setText("profile info");
        label_button_pfl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 159)));
        label_button_pfl.setIconTextGap(10);
        label_button_pfl.setOpaque(true);
        label_button_pfl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_button_pflMouseClicked(evt);
            }
        });
        panel_control_button_pfl.add(label_button_pfl, java.awt.BorderLayout.CENTER);

        panel_control_button_list.add(panel_control_button_pfl);

        panel_control_button_dep.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 8));
        panel_control_button_dep.setMinimumSize(new java.awt.Dimension(220, 220));
        panel_control_button_dep.setOpaque(false);
        panel_control_button_dep.setPreferredSize(new java.awt.Dimension(220, 220));
        panel_control_button_dep.setLayout(new java.awt.BorderLayout());

        label_button_dep.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        label_button_dep.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_button_dep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_20_user_male_info2.png"))); // NOI18N
        label_button_dep.setText("dependents");
        label_button_dep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 159)));
        label_button_dep.setIconTextGap(10);
        label_button_dep.setOpaque(true);
        label_button_dep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_button_depMouseClicked(evt);
            }
        });
        panel_control_button_dep.add(label_button_dep, java.awt.BorderLayout.CENTER);

        panel_control_button_list.add(panel_control_button_dep);

        panel_control_button_elg.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 8));
        panel_control_button_elg.setMinimumSize(new java.awt.Dimension(220, 220));
        panel_control_button_elg.setOpaque(false);
        panel_control_button_elg.setPreferredSize(new java.awt.Dimension(220, 220));
        panel_control_button_elg.setLayout(new java.awt.BorderLayout());

        label_button_elg.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        label_button_elg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_button_elg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_20_magic_wand.png"))); // NOI18N
        label_button_elg.setText("eligibilities");
        label_button_elg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 159)));
        label_button_elg.setIconTextGap(10);
        label_button_elg.setOpaque(true);
        label_button_elg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_button_elgMouseClicked(evt);
            }
        });
        panel_control_button_elg.add(label_button_elg, java.awt.BorderLayout.CENTER);

        panel_control_button_list.add(panel_control_button_elg);

        panel_control_button_trn.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 8));
        panel_control_button_trn.setMinimumSize(new java.awt.Dimension(220, 220));
        panel_control_button_trn.setOpaque(false);
        panel_control_button_trn.setPreferredSize(new java.awt.Dimension(220, 220));
        panel_control_button_trn.setLayout(new java.awt.BorderLayout());

        label_button_trn.setFont(new java.awt.Font("Century Gothic", 1, 11)); // NOI18N
        label_button_trn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_button_trn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/icon_20_blackboard_drawing.png"))); // NOI18N
        label_button_trn.setText("trainings");
        label_button_trn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 159)));
        label_button_trn.setIconTextGap(10);
        label_button_trn.setOpaque(true);
        label_button_trn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_button_trnMouseClicked(evt);
            }
        });
        panel_control_button_trn.add(label_button_trn, java.awt.BorderLayout.CENTER);

        panel_control_button_list.add(panel_control_button_trn);

        panel_control_button.add(panel_control_button_list, "card2");

        panel_center.add(panel_control_button, java.awt.BorderLayout.PAGE_START);

        panel_frame.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 10));
        panel_frame.setMaximumSize(new java.awt.Dimension(185, 0));
        panel_frame.setMinimumSize(new java.awt.Dimension(185, 0));
        panel_frame.setName(""); // NOI18N
        panel_frame.setOpaque(false);
        panel_frame.setPreferredSize(new java.awt.Dimension(185, 0));
        panel_frame.setLayout(new java.awt.CardLayout());

        panel_main.setBackground(new java.awt.Color(245, 245, 245));
        panel_main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(175, 175, 175)));
        panel_main.setLayout(new java.awt.CardLayout());
        panel_frame.add(panel_main, "card_main");

        panel_loading.setBackground(new java.awt.Color(245, 245, 245));
        panel_loading.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(175, 175, 175)));
        panel_loading.setLayout(new java.awt.BorderLayout());

        label_loading_animated.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_loading_animated.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/merged/misc/loading.gif"))); // NOI18N
        label_loading_animated.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 50, 0));
        label_loading_animated.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panel_loading.add(label_loading_animated, java.awt.BorderLayout.CENTER);

        panel_frame.add(panel_loading, "card_loading");

        panel_center.add(panel_frame, java.awt.BorderLayout.CENTER);

        add(panel_center, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public void initAdditionalComponents(PanelEmployees panel_parent) {
        
        setFrameParent(panel_parent);
        
        load_panel.setParentPanel(panel_frame);
        
        load_panel.loadFrame(panel_crtpfl, panel_main);
        
        panel_crtpfl.initAdditionalComponents(this);
        panel_crtdep.initAdditionalComponents(this);
        panel_crtelg.initAdditionalComponents(this);
        panel_crttrn.initAdditionalComponents(this);
        
        panel_parent.lbl_btn.addClass(label_button_bck, constant.BUTTON_BG_COLOR_PRESS_GRAY, constant.BUTTON_BG_COLOR_NEW_GRAY, constant.BUTTON_BG_COLOR_OLD, constant.BUTTON_FG_COLOR_NEW, constant.BUTTON_FG_COLOR_OLD);
        panel_parent.lbl_btn.addClass(label_button_pfl, constant.BUTTON_BG_COLOR_PRESS_DEFAULT, constant.BUTTON_BG_COLOR_NEW_DEFAULT, constant.BUTTON_BG_COLOR_OLD, constant.BUTTON_FG_COLOR_NEW, constant.BUTTON_FG_COLOR_OLD);
        panel_parent.lbl_btn.addClass(label_button_dep, constant.BUTTON_BG_COLOR_PRESS_DEFAULT, constant.BUTTON_BG_COLOR_NEW_DEFAULT, constant.BUTTON_BG_COLOR_OLD, constant.BUTTON_FG_COLOR_NEW, constant.BUTTON_FG_COLOR_OLD);
        panel_parent.lbl_btn.addClass(label_button_elg, constant.BUTTON_BG_COLOR_PRESS_DEFAULT, constant.BUTTON_BG_COLOR_NEW_DEFAULT, constant.BUTTON_BG_COLOR_OLD, constant.BUTTON_FG_COLOR_NEW, constant.BUTTON_FG_COLOR_OLD);
        panel_parent.lbl_btn.addClass(label_button_trn, constant.BUTTON_BG_COLOR_PRESS_DEFAULT, constant.BUTTON_BG_COLOR_NEW_DEFAULT, constant.BUTTON_BG_COLOR_OLD, constant.BUTTON_FG_COLOR_NEW, constant.BUTTON_FG_COLOR_OLD);
        panel_parent.lbl_btn.addClass(label_button_sav, constant.BUTTON_BG_COLOR_PRESS_GREEN, constant.BUTTON_BG_COLOR_NEW_GREEN, constant.BUTTON_BG_COLOR_OLD, constant.BUTTON_FG_COLOR_NEW, constant.BUTTON_FG_COLOR_OLD);
        panel_parent.lbl_btn.addClass(label_button_clr, constant.BUTTON_BG_COLOR_PRESS_RED, constant.BUTTON_BG_COLOR_NEW_RED, constant.BUTTON_BG_COLOR_OLD, constant.BUTTON_FG_COLOR_NEW, constant.BUTTON_FG_COLOR_OLD);
        
        resetPanel();
    }

    private void label_button_pflMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_button_pflMouseClicked

        load_panel.loadFrame(panel_crtpfl, panel_main);
    }//GEN-LAST:event_label_button_pflMouseClicked

    private void label_button_depMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_button_depMouseClicked

        panel_crtdep.refreshDialog();
        panel_crtdep.resetLabelButtons();
        load_panel.loadFrame(panel_crtdep, panel_main);
    }//GEN-LAST:event_label_button_depMouseClicked

    private void label_button_elgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_button_elgMouseClicked

        panel_crtelg.refreshDialog();
        panel_crtelg.resetLabelButtons();
        load_panel.loadFrame(panel_crtelg, panel_main);
    }//GEN-LAST:event_label_button_elgMouseClicked

    private void label_button_trnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_button_trnMouseClicked

        panel_crttrn.refreshDialog();
        panel_crttrn.resetLabelButtons();
        load_panel.loadFrame(panel_crttrn, panel_main);
    }//GEN-LAST:event_label_button_trnMouseClicked

    private void label_button_bckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_button_bckMouseClicked

        this.panel_parent.loadSummary();
    }//GEN-LAST:event_label_button_bckMouseClicked

    private void label_button_savMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_button_savMouseClicked

        String[] formArray;

        formArray = panel_crtpfl.getFieldsForSave();

        for (String string : formArray) {
            System.out.println(string);
        }

/**
        if(formArray != null && formArray.length == 25) {

            int x = JOptionPane.showConfirmDialog(this, "Are you sure you want to Create New Employee Data?", "VALIDATE ACTION", JOptionPane.YES_NO_OPTION);

            if (x == 0) {

                try {
                    //Database connection
                    ClassMyDBConnectionEmbeddedDerby.initDB();
                    Connection conn = ClassMyDBConnectionEmbeddedDerby.getMyConnection();

                    PreparedStatement ps;

                    ps = conn.prepareStatement("INSERT INTO " + constant.TABLE_EMPLOYEE_HEADER + " (name_first, name_middle, name_last, plantilla_id, list_pos_id, list_off_id, list_cat_id, date_hired, salary) values ((?),(?),(?),(?),(?),(?),(?),(?),(?))", Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, formArray[0]); // name_first
                    ps.setString(2, formArray[1]); // name_middle
                    ps.setString(3, formArray[2]); // name_last
                    ps.setInt(4, Integer.parseInt(formArray[3])); // plantilla_id
                    ps.setInt(5, this.panel_ancestor.cmbboxId.getId(constant.TABLE_LIST_POSITION, formArray[4])); // list_pos_id
                    ps.setInt(6, this.panel_ancestor.cmbboxId.getId(constant.TABLE_LIST_OFFICE, formArray[5])); // list_off_id
                    ps.setInt(7, this.panel_ancestor.cmbboxId.getId(constant.TABLE_LIST_CATEGORY, formArray[6])); // list_cat_id
                    ps.setDate(8, java.sql.Date.valueOf(formArray[7])); // date_hired
                    ps.setInt(9, Integer.parseInt(formArray[8])); // salary

                    ps.execute();

                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs != null && rs.next()) {

                        ps = conn.prepareStatement("INSERT INTO " + constant.TABLE_EMPLOYEE_DETAIL + " ( "
                            + " header_id, date_birth, address_prime, address_other, gender, civil_status, nationality, religion, email, phone_tele, phone_cell, phone_misc, code_SSS, code_TIN, code_GSIS, code_PHIC, code_PAGIBIG) values ((?),(?),(?),(?),(?),(?),(?),(?),(?),(?),(?),(?),(?),(?),(?),(?),(?))", Statement.RETURN_GENERATED_KEYS);

                        int employeeID = rs.getInt(1);

                        ps.setInt(1, employeeID); // header_id
                        ps.setDate(2, java.sql.Date.valueOf(formArray[9])); // date_birth
                        ps.setString(3, formArray[10]); // address_prime
                        ps.setString(4, formArray[11]); // address_other
                        ps.setString(5, formArray[12]); // gender
                        ps.setString(6, formArray[13]); // civil_status
                        ps.setString(7, formArray[14]); // nationality
                        ps.setString(8, formArray[15]); // religion
                        ps.setString(9, formArray[16]); // email
                        if(formArray[17].equals("")) { // phone_tele
                            ps.setNull(10, java.sql.Types.INTEGER);
                        } else {
                            ps.setInt(10, (formArray[17].equals("")) ? null : Integer.parseInt(formArray[17]));
                        }
                        if (formArray[18].equals("")) { // phone_cell
                            ps.setNull(11, java.sql.Types.INTEGER);
                        } else {
                            ps.setInt(11, (formArray[18].equals("")) ? null : Integer.parseInt(formArray[18]));
                        }
                        if(formArray[19].equals("")) { // phone_misc
                            ps.setNull(12, java.sql.Types.INTEGER);
                        } else {
                            ps.setInt(12, Integer.parseInt(formArray[19]));
                        }
                        ps.setString(13, formArray[20]); // code_SSS
                        ps.setString(14, formArray[21]); // code_TIN
                        ps.setString(15, formArray[22]); // code_GSIS
                        ps.setString(16, formArray[23]); // code_PHIC
                        ps.setString(17, formArray[24]); // code_PAGIBIG

                        ps.execute();

                        Object[][] tblDep = getTableData(panel_crtdep.getTable());
                        String queryDep = "";
                        int countDep = 0;
                        if(tblDep.length > 0) {
                            queryDep += "INSERT INTO " + constant.TABLE_MANAGE_DEPENDENTS + " (emp_header_id, name, date) VALUES ";
                            for (Object[] tableData : tblDep) {
                                String date = fmtDateVal.formatDateToString(fmtDateVal.formatStringToDate(tableData[2].toString(), "MMMM dd, yyyy"), "yyyy-MM-dd");
                                queryDep += "(" + employeeID + ", '" + tableData[1] + "', '" + java.sql.Date.valueOf(date) + "')";
                                countDep++;
                                if(tblDep.length != countDep) {
                                    queryDep += ", ";
                                }
                            }
                        }
                        if(!queryDep.isEmpty()) {
                            conn.createStatement().execute(queryDep);
                        }

                        Object[][] tblElg = getTableData(panel_crtelg.getTable());
                        String queryElg = "";
                        int countElg = 0;
                        if(tblElg.length > 0) {
                            queryElg += "INSERT INTO " + constant.TABLE_MANAGE_ELIGIBILITY + " (emp_header_id, mngr_elg_id, date) VALUES ";
                            for (Object[] tableData : tblElg) {
                                String date = fmtDateVal.formatDateToString(fmtDateVal.formatStringToDate(tableData[2].toString(), "MMMM dd, yyyy"), "yyyy-MM-dd");
                                queryElg += "(" + employeeID + ", " + tableData[0] + ", '" + java.sql.Date.valueOf(date) + "')";
                                countElg++;
                                if(tblElg.length != countElg) {
                                    queryElg += ", ";
                                }
                            }
                        }
                        if(!queryElg.isEmpty()) {
                            conn.createStatement().execute(queryElg);
                        }

                        Object[][] tblTrn = getTableData(panel_crttrn.getTable());
                        String queryTrn = "";
                        int countTrn = 0;
                        if(tblTrn.length > 0) {
                            queryTrn += "INSERT INTO " + constant.TABLE_MANAGE_TRAINING + " (emp_header_id, mngr_trn_id, date) VALUES ";
                            for (Object[] tableData : tblTrn) {
                                String date = fmtDateVal.formatDateToString(fmtDateVal.formatStringToDate(tableData[2].toString(), "MMMM dd, yyyy"), "yyyy-MM-dd");
                                queryTrn += "(" + employeeID + ", " + tableData[0] + ", '" + java.sql.Date.valueOf(date) + "')";
                                countTrn++;
                                if(tblTrn.length != countTrn) {
                                    queryTrn += ", ";
                                }
                            }
                        }
                        if(!queryTrn.isEmpty()) {
                            conn.createStatement().execute(queryTrn);
                        }

                    }

                    JOptionPane.showMessageDialog(this, "New Employee Successfully Created.", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                    // Reset form fields.
                    resetForm();

                    // Return to first panel.
                    load_panel.loadFrame(panel_crtpfl, panel_main);

                } catch (SQLException | HeadlessException ex) {
                    JOptionPane.showMessageDialog(this, "An Error Occured.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            }

        }
*/
    }//GEN-LAST:event_label_button_savMouseClicked

    private void label_button_clrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_button_clrMouseClicked

        // Reset form fields.
        resetForm();
        
    }//GEN-LAST:event_label_button_clrMouseClicked

    public Object[][] getTableData(JTable table) {
        
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        
        for (int i = 0 ; i < nRow ; i++)
            for (int j = 0 ; j < nCol ; j++)
                tableData[i][j] = dtm.getValueAt(i,j);
        
        return tableData;
    }
    
    public void resetPanel() {

        // Reset button colors.
        resetLabelButtons();
        // Clear upload image.
        classImageCropPanel.resetImagePanel();
        // Clear form data.
        panel_crtpfl.clearFields();
        // Clear table data.
        panel_crtdep.clearDialog();
        panel_crtelg.clearDialog();
        panel_crttrn.clearDialog();
        // Return to first panel.
        load_panel.loadFrame(panel_crtpfl, panel_main);
    }
    
    public void resetForm() {

        // Clear upload image.
        classImageCropPanel.resetImagePanel();
        // Clear form data.
        panel_crtpfl.clearFields();
        // Clear table data.
        panel_crtdep.clearDialog();
        panel_crtelg.clearDialog();
        panel_crttrn.clearDialog();
    }

    public void resetLabelButtons() {

        label_button_bck.setBackground(constant.BUTTON_BG_COLOR_OLD);
        label_button_bck.setForeground(constant.BUTTON_FG_COLOR_OLD);
        label_button_pfl.setBackground(constant.BUTTON_BG_COLOR_OLD);
        label_button_pfl.setForeground(constant.BUTTON_FG_COLOR_OLD);
        label_button_dep.setBackground(constant.BUTTON_BG_COLOR_OLD);
        label_button_dep.setForeground(constant.BUTTON_FG_COLOR_OLD);
        label_button_elg.setBackground(constant.BUTTON_BG_COLOR_OLD);
        label_button_elg.setForeground(constant.BUTTON_FG_COLOR_OLD);
        label_button_trn.setBackground(constant.BUTTON_BG_COLOR_OLD);
        label_button_trn.setForeground(constant.BUTTON_FG_COLOR_OLD);
        label_button_sav.setBackground(constant.BUTTON_BG_COLOR_OLD);
        label_button_sav.setForeground(constant.BUTTON_FG_COLOR_OLD);
        label_button_clr.setBackground(constant.BUTTON_BG_COLOR_OLD);
        label_button_clr.setForeground(constant.BUTTON_FG_COLOR_OLD);
    }

    private void setFrameParent(PanelEmployees parent_value) {

        this.panel_parent = parent_value;
        setFrameAncestor(this.panel_parent.panel_ancestor);
        setFrameConstants(this.panel_ancestor.constant);
    }

    private void setFrameAncestor(FramePrime ancestor_value) {

        this.panel_ancestor = ancestor_value;
    }

    private void setFrameConstants(ClassConstantsCustom constant_value) {

        this.constant = constant_value;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private classes.ClassImageCropPanel_v1 classImageCropPanel;
    private javax.swing.JLabel label_button_bck;
    private javax.swing.JLabel label_button_clr;
    private javax.swing.JLabel label_button_dep;
    private javax.swing.JLabel label_button_elg;
    private javax.swing.JLabel label_button_pfl;
    private javax.swing.JLabel label_button_sav;
    private javax.swing.JLabel label_button_trn;
    private javax.swing.JLabel label_loading_animated;
    private javax.swing.JPanel panel_center;
    private javax.swing.JPanel panel_control;
    private javax.swing.JPanel panel_control_button;
    private javax.swing.JPanel panel_control_button_dep;
    private javax.swing.JPanel panel_control_button_elg;
    private javax.swing.JPanel panel_control_button_list;
    private javax.swing.JPanel panel_control_button_pfl;
    private javax.swing.JPanel panel_control_button_trn;
    private javax.swing.JPanel panel_ctrl;
    private javax.swing.JPanel panel_ctrl_btn;
    private javax.swing.JPanel panel_ctrl_btn_clr;
    private javax.swing.JPanel panel_ctrl_btn_sav;
    private javax.swing.JPanel panel_frame;
    private javax.swing.JPanel panel_loading;
    private javax.swing.JPanel panel_main;
    // End of variables declaration//GEN-END:variables
}

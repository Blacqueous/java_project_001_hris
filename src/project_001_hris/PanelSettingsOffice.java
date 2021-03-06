/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_001_hris;

import java.util.Calendar;
import javax.swing.JComponent;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Web Dev
 */
public class PanelSettingsOffice extends javax.swing.JPanel {

    final static ClassSliderJPanel slider = new ClassSliderJPanel();
    Calendar currentDate = Calendar.getInstance();

    /**
     * Creates new form PanelSettingElg
     */
    public PanelSettingsOffice() {
        initComponents();
        // Initialize JPanel Slider.
        panelMain.add(initSlider());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSearch = new javax.swing.JPanel();
        panelTextfield = new javax.swing.JPanel();
        panelTextfieldInner = new javax.swing.JPanel();
        panelTextfieldInner01 = new javax.swing.JPanel();
        labelSearch = new javax.swing.JLabel();
        labelColon = new javax.swing.JLabel();
        txtfldSearch = new javax.swing.JTextField();
        panelTable = new javax.swing.JPanel();
        scrollpaneSearch = new javax.swing.JScrollPane();
        tableSearch = new javax.swing.JTable();
        panelCreate = new javax.swing.JPanel();
        panelCreateInner = new javax.swing.JPanel();
        buttonCreate = new javax.swing.JButton();
        panelCreateForm = new javax.swing.JPanel();
        panelFields = new javax.swing.JPanel();
        panelFieldsDetail = new javax.swing.JPanel();
        panelFieldsDetail01 = new javax.swing.JPanel();
        panelFieldsDetail01Inner01 = new javax.swing.JPanel();
        panelFieldsDetail01Inner01Field_Panel = new javax.swing.JPanel();
        panelFieldsDetail01Inner01Field_Panel_LabelName = new javax.swing.JLabel();
        panelFieldsDetail01Inner01Field_Panel_LabelColon = new javax.swing.JLabel();
        txtfldName = new javax.swing.JTextField();
        panelFieldsDetail02 = new javax.swing.JPanel();
        panelFieldsDetail01Inner02 = new javax.swing.JPanel();
        panelFieldsDetail01Inner02Field_Panel = new javax.swing.JPanel();
        panelFieldsDetail01Inner02Field_Panel_Label = new javax.swing.JPanel();
        panelFieldsDetail01Inner02Field_Panel_Label01 = new javax.swing.JPanel();
        panelFieldsDetail01Inner02Field_Panel_LabelName = new javax.swing.JLabel();
        panelFieldsDetail01Inner02Field_Panel_LabelColon = new javax.swing.JLabel();
        scrollpane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        panelBack = new javax.swing.JPanel();
        panelBackInner = new javax.swing.JPanel();
        buttonBack = new javax.swing.JButton();
        panelTitle = new javax.swing.JPanel();
        separator = new javax.swing.JSeparator();
        lblTitle = new javax.swing.JLabel();
        panelMain = new javax.swing.JPanel();

        panelSearch.setLayout(new java.awt.BorderLayout());

        panelTextfield.setPreferredSize(new java.awt.Dimension(669, 35));
        panelTextfield.setLayout(new java.awt.CardLayout());

        panelTextfieldInner.setLayout(new java.awt.BorderLayout());

        panelTextfieldInner01.setPreferredSize(new java.awt.Dimension(75, 4));
        panelTextfieldInner01.setLayout(new java.awt.BorderLayout());

        labelSearch.setFont(new java.awt.Font("Century Gothic", 3, 11)); // NOI18N
        labelSearch.setText(" ● Search");
        panelTextfieldInner01.add(labelSearch, java.awt.BorderLayout.CENTER);

        labelColon.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        labelColon.setText(" : ");
        panelTextfieldInner01.add(labelColon, java.awt.BorderLayout.LINE_END);

        panelTextfieldInner.add(panelTextfieldInner01, java.awt.BorderLayout.LINE_START);

        txtfldSearch.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtfldSearch.setForeground(new java.awt.Color(51, 51, 51));
        ((AbstractDocument) txtfldName.getDocument()).setDocumentFilter(new MyDocumentFilterIsLetter());
        txtfldSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtfldSearchFocusLost(evt);
            }
        });
        panelTextfieldInner.add(txtfldSearch, java.awt.BorderLayout.CENTER);

        panelTextfield.add(panelTextfieldInner, "card3");

        panelSearch.add(panelTextfield, java.awt.BorderLayout.PAGE_START);

        panelTable.setLayout(new java.awt.BorderLayout());

        tableSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tableSearch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollpaneSearch.setViewportView(tableSearch);

        panelTable.add(scrollpaneSearch, java.awt.BorderLayout.CENTER);

        panelCreate.setPreferredSize(new java.awt.Dimension(669, 40));
        panelCreate.setLayout(new java.awt.CardLayout());

        panelCreateInner.setPreferredSize(new java.awt.Dimension(669, 25));
        panelCreateInner.setLayout(new java.awt.BorderLayout());

        buttonCreate.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        buttonCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_src/icon_16_bullet_arrow_right.png"))); // NOI18N
        buttonCreate.setText("New Entry");
        buttonCreate.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        buttonCreate.setMargin(new java.awt.Insets(2, 14, 2, 4));
        buttonCreate.setPreferredSize(new java.awt.Dimension(125, 75));
        buttonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCreateActionPerformed(evt);
            }
        });
        panelCreateInner.add(buttonCreate, java.awt.BorderLayout.LINE_END);

        panelCreate.add(panelCreateInner, "card2");

        panelTable.add(panelCreate, java.awt.BorderLayout.PAGE_END);

        panelSearch.add(panelTable, java.awt.BorderLayout.CENTER);

        panelCreateForm.setBackground(new java.awt.Color(245, 245, 245));
        panelCreateForm.setLayout(new java.awt.BorderLayout());

        panelFields.setLayout(new java.awt.BorderLayout());

        panelFieldsDetail.setPreferredSize(new java.awt.Dimension(669, 55));
        panelFieldsDetail.setLayout(new java.awt.BorderLayout());

        panelFieldsDetail01.setToolTipText("Fill-in Office Name.");
        panelFieldsDetail01.setPreferredSize(new java.awt.Dimension(351, 35));
        panelFieldsDetail01.setLayout(new java.awt.GridLayout(0, 1));

        panelFieldsDetail01Inner01.setPreferredSize(new java.awt.Dimension(10, 4));
        panelFieldsDetail01Inner01.setLayout(new java.awt.BorderLayout());

        panelFieldsDetail01Inner01Field_Panel.setPreferredSize(new java.awt.Dimension(60, 4));
        panelFieldsDetail01Inner01Field_Panel.setLayout(new java.awt.BorderLayout());

        panelFieldsDetail01Inner01Field_Panel_LabelName.setFont(new java.awt.Font("Century Gothic", 3, 11)); // NOI18N
        panelFieldsDetail01Inner01Field_Panel_LabelName.setText(" ● Name");
        panelFieldsDetail01Inner01Field_Panel_LabelName.setPreferredSize(new java.awt.Dimension(125, 125));
        panelFieldsDetail01Inner01Field_Panel.add(panelFieldsDetail01Inner01Field_Panel_LabelName, java.awt.BorderLayout.CENTER);

        panelFieldsDetail01Inner01Field_Panel_LabelColon.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        panelFieldsDetail01Inner01Field_Panel_LabelColon.setText(" : ");
        panelFieldsDetail01Inner01Field_Panel.add(panelFieldsDetail01Inner01Field_Panel_LabelColon, java.awt.BorderLayout.LINE_END);

        panelFieldsDetail01Inner01.add(panelFieldsDetail01Inner01Field_Panel, java.awt.BorderLayout.LINE_START);

        txtfldName.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtfldName.setForeground(new java.awt.Color(51, 51, 51));
        ((AbstractDocument) txtfldName.getDocument()).setDocumentFilter(new MyDocumentFilterIsLetter());
        panelFieldsDetail01Inner01.add(txtfldName, java.awt.BorderLayout.CENTER);

        panelFieldsDetail01.add(panelFieldsDetail01Inner01);

        panelFieldsDetail.add(panelFieldsDetail01, java.awt.BorderLayout.PAGE_START);

        panelFieldsDetail02.setToolTipText("Fill-in Office Description.");
        panelFieldsDetail02.setLayout(new java.awt.CardLayout());

        panelFieldsDetail01Inner02.setPreferredSize(new java.awt.Dimension(10, 4));
        panelFieldsDetail01Inner02.setLayout(new java.awt.BorderLayout());

        panelFieldsDetail01Inner02Field_Panel.setLayout(new java.awt.BorderLayout());

        panelFieldsDetail01Inner02Field_Panel_Label.setPreferredSize(new java.awt.Dimension(60, 4));
        panelFieldsDetail01Inner02Field_Panel_Label.setLayout(new java.awt.BorderLayout());

        panelFieldsDetail01Inner02Field_Panel_Label01.setPreferredSize(new java.awt.Dimension(50, 30));
        panelFieldsDetail01Inner02Field_Panel_Label01.setLayout(new java.awt.BorderLayout());

        panelFieldsDetail01Inner02Field_Panel_LabelName.setFont(new java.awt.Font("Century Gothic", 3, 11)); // NOI18N
        panelFieldsDetail01Inner02Field_Panel_LabelName.setText(" ● Desc.");
        panelFieldsDetail01Inner02Field_Panel_LabelName.setPreferredSize(new java.awt.Dimension(125, 125));
        panelFieldsDetail01Inner02Field_Panel_Label01.add(panelFieldsDetail01Inner02Field_Panel_LabelName, java.awt.BorderLayout.CENTER);

        panelFieldsDetail01Inner02Field_Panel_LabelColon.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        panelFieldsDetail01Inner02Field_Panel_LabelColon.setText(" : ");
        panelFieldsDetail01Inner02Field_Panel_Label01.add(panelFieldsDetail01Inner02Field_Panel_LabelColon, java.awt.BorderLayout.LINE_END);

        panelFieldsDetail01Inner02Field_Panel_Label.add(panelFieldsDetail01Inner02Field_Panel_Label01, java.awt.BorderLayout.PAGE_START);

        panelFieldsDetail01Inner02Field_Panel.add(panelFieldsDetail01Inner02Field_Panel_Label, java.awt.BorderLayout.LINE_START);

        textArea.setColumns(20);
        textArea.setRows(1);
        textArea.setWrapStyleWord(true);
        scrollpane.setViewportView(textArea);

        panelFieldsDetail01Inner02Field_Panel.add(scrollpane, java.awt.BorderLayout.CENTER);

        panelFieldsDetail01Inner02.add(panelFieldsDetail01Inner02Field_Panel, java.awt.BorderLayout.CENTER);

        panelFieldsDetail02.add(panelFieldsDetail01Inner02, "card2");

        panelFieldsDetail.add(panelFieldsDetail02, java.awt.BorderLayout.CENTER);

        panelFields.add(panelFieldsDetail, java.awt.BorderLayout.CENTER);

        panelCreateForm.add(panelFields, java.awt.BorderLayout.CENTER);

        panelBack.setPreferredSize(new java.awt.Dimension(669, 40));
        panelBack.setLayout(new java.awt.CardLayout());

        panelBackInner.setPreferredSize(new java.awt.Dimension(669, 25));
        panelBackInner.setLayout(new java.awt.BorderLayout());

        buttonBack.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        buttonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_src/icon_16_bullet_arrow_left.png"))); // NOI18N
        buttonBack.setText("Back");
        buttonBack.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        buttonBack.setMargin(new java.awt.Insets(2, 4, 2, 14));
        buttonBack.setPreferredSize(new java.awt.Dimension(100, 75));
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        panelBackInner.add(buttonBack, java.awt.BorderLayout.LINE_END);

        panelBack.add(panelBackInner, "card2");

        panelCreateForm.add(panelBack, java.awt.BorderLayout.PAGE_END);

        setLayout(new java.awt.BorderLayout());

        panelTitle.setPreferredSize(new java.awt.Dimension(100, 35));
        panelTitle.setLayout(new java.awt.BorderLayout());
        panelTitle.add(separator, java.awt.BorderLayout.PAGE_END);

        lblTitle.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("OFFICE MANAGER");
        panelTitle.add(lblTitle, java.awt.BorderLayout.CENTER);

        add(panelTitle, java.awt.BorderLayout.PAGE_START);

        panelMain.setLayout(new java.awt.CardLayout(10, 10));
        add(panelMain, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateActionPerformed

        slider.next();
        slider.refresh();

    }//GEN-LAST:event_buttonCreateActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed

        slider.prev();
        slider.refresh();

    }//GEN-LAST:event_buttonBackActionPerformed

    private void txtfldSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtfldSearchFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfldSearchFocusLost


    /**
     * Initialize JPanel slider
     * 
     * @return ClassSliderJPanel
     */
    private static JComponent initSlider() {

        slider.addSliderComponent(panelSearch);
        slider.addSliderComponent(panelCreateForm);
        slider.refresh();

        return slider;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton buttonCreate;
    private javax.swing.JLabel labelColon;
    private javax.swing.JLabel labelSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelBackInner;
    private javax.swing.JPanel panelCreate;
    private static javax.swing.JPanel panelCreateForm;
    private javax.swing.JPanel panelCreateInner;
    private javax.swing.JPanel panelFields;
    private javax.swing.JPanel panelFieldsDetail;
    private javax.swing.JPanel panelFieldsDetail01;
    private javax.swing.JPanel panelFieldsDetail01Inner01;
    private javax.swing.JPanel panelFieldsDetail01Inner01Field_Panel;
    private javax.swing.JLabel panelFieldsDetail01Inner01Field_Panel_LabelColon;
    private javax.swing.JLabel panelFieldsDetail01Inner01Field_Panel_LabelName;
    private javax.swing.JPanel panelFieldsDetail01Inner02;
    private javax.swing.JPanel panelFieldsDetail01Inner02Field_Panel;
    private javax.swing.JPanel panelFieldsDetail01Inner02Field_Panel_Label;
    private javax.swing.JPanel panelFieldsDetail01Inner02Field_Panel_Label01;
    private javax.swing.JLabel panelFieldsDetail01Inner02Field_Panel_LabelColon;
    private javax.swing.JLabel panelFieldsDetail01Inner02Field_Panel_LabelName;
    private javax.swing.JPanel panelFieldsDetail02;
    private javax.swing.JPanel panelMain;
    private static javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelTable;
    private javax.swing.JPanel panelTextfield;
    private javax.swing.JPanel panelTextfieldInner;
    private javax.swing.JPanel panelTextfieldInner01;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JScrollPane scrollpaneSearch;
    private javax.swing.JSeparator separator;
    private javax.swing.JTable tableSearch;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField txtfldName;
    public javax.swing.JTextField txtfldSearch;
    // End of variables declaration//GEN-END:variables

    class MyDocumentFilterIsLetter extends DocumentFilter {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isLetter(c) || c == ' ') {
                    super.replace(fb, i, i1, String.valueOf(c), as);
                } else if (Character.isLetter(c) || c == '`') {
                    super.replace(fb, i, i1, String.valueOf(""), as);
                }
            }
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int i, int i1) throws BadLocationException {
            super.remove(fb, i, i1);
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(fb, i, string, as);
        }

    }

    class MyDocumentFilterIsDigit extends DocumentFilter {

        @Override
        public void replace(DocumentFilter.FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
            for (int n = string.length(); n > 0; n--) {
                char c = string.charAt(n - 1);
                if (Character.isDigit(c) || c == ' ') {
                    super.replace(fb, i, i1, String.valueOf(c), as);
                } else if (Character.isDigit(c) || c == '`') {
                    super.replace(fb, i, i1, String.valueOf(""), as);
                }
            }
        }

        @Override
        public void remove(DocumentFilter.FilterBypass fb, int i, int i1) throws BadLocationException {
            super.remove(fb, i, i1);
        }

        @Override
        public void insertString(DocumentFilter.FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
            super.insertString(fb, i, string, as);
        }

    }

}

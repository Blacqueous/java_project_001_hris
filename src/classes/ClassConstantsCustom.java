/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Blacqueous
 */
public class ClassConstantsCustom {
    
    /**
     * Database Employee Table
     */
    public final int PANEL_FRAME;
    public final int PANEL_POPUP;

    /**
     * Main Frame Panel
     */
    public final String PANEL_HOME;
    public final String PANEL_DBD;
    public final String PANEL_CMP;
    public final String PANEL_EMP;
    public final String PANEL_EMP_PFL;
    public final String PANEL_EMP_DEP;
    public final String PANEL_EMP_ELG;
    public final String PANEL_EMP_TRN;
    public final String PANEL_CAT;
    public final String PANEL_DPT;
    public final String PANEL_POS;
    public final String PANEL_ELG;
    public final String PANEL_TRN;
    public final String PANEL_LVS;

    /**
     * Database Employee Table
     */
    public final String TABLE_ACCOUNT_TYPE;
    public final String TABLE_ACCOUNT_HEADER;
    public final String TABLE_ACCOUNT_DETAIL;
    public final String TABLE_EMPLOYEE_HEADER;
    public final String TABLE_EMPLOYEE_DETAIL;
    public final String TABLE_MANAGE_DEPENDENTS;
    public final String TABLE_MANAGE_ELIGIBILITY;
    public final String TABLE_MANAGE_TRAINING;
    public final String TABLE_LIST_CATEGORY;
    public final String TABLE_LIST_OFFICE;
    public final String TABLE_LIST_POSITION;
    public final String TABLE_LIST_ELIGIBILITY;
    public final String TABLE_LIST_TRAINING;

    /**
     * Database Employee Search
     */
    public final String TABLE_SEARCH_NAME_FULL;
    public final String TABLE_SEARCH_NAME_FIRST;
    public final String TABLE_SEARCH_NAME_MIDDLE;
    public final String TABLE_SEARCH_NAME_LAST;
    public final String TABLE_SEARCH_PLANTILLA_NO;
    public final String TABLE_SEARCH_POSITION;
    public final String TABLE_SEARCH_OFFICE;
    public final String TABLE_SEARCH_CATEGORY;

    /**
     * Database Employee Info Columns
     */
    public final ArrayList<String> LIST_GENDER;
    public final ArrayList<String> LIST_CIVIL_STATUS;
    public final ArrayList<String> LIST_SEARCH_FILTER;

    /**
     * Database Employee Info Columns
     */
    public final String COLUMN_FULL_NAME;
    public final String COLUMN_FIRST_NAME;
    public final String COLUMN_MIDDLE_NAME;
    public final String COLUMN_LAST_NAME;
    public final String COLUMN_PLANTILLA_NUM;
    public final String COLUMN_POSITION;
    public final String COLUMN_OFFICE;
    public final String COLUMN_CATEGORY;
    public final String COLUMN_DATE_HIRED;
    public final String COLUMN_BIRTHDATE;
    public final String COLUMN_GENDER;
    public final String COLUMN_CIVIL_STATUS;

    /**
     * Database Employee Info Columns (UPPERCASE)
     */
    public final String COLUMN_FULL_NAME_UC;
    public final String COLUMN_FIRST_NAME_UC;
    public final String COLUMN_MIDDLE_NAME_UC;
    public final String COLUMN_LAST_NAME_UC;
    public final String COLUMN_PLANTILLA_NUM_UC;
    public final String COLUMN_POSITION_UC;
    public final String COLUMN_OFFICE_UC;
    public final String COLUMN_CATEGORY_UC;
    public final String COLUMN_DATE_HIRED_UC;
    public final String COLUMN_BIRTHDATE_UC;
    public final String COLUMN_GENDER_UC;
    public final String COLUMN_CIVIL_STATUS_UC;

    /**
     * Constant Color Sets
     * 
     * 1 - For Table Row
     * 2 - For Label Buttons
     * 
     */
    public final Color ROW_BG_COLOR_ODD; // 1
    public final Color ROW_BG_COLOR_EVEN; // 1
    public final Color ROW_BG_COLOR_SELECT_DEFAULT; // 1
    public final Color ROW_BG_COLOR_SELECT_BLUE; // 1
    public final Color ROW_BG_COLOR_SELECT_GRAY; // 1
    public final Color ROW_BG_COLOR_SELECT_GREEN; // 1
    public final Color ROW_BG_COLOR_SELECT_ORANGE; // 1
    public final Color ROW_BG_COLOR_SELECT_RED; // 1
    public final Color ROW_BG_COLOR_SELECT_VIOLET; // 1
    public final Color ROW_BG_COLOR_SELECT_YELLOW; // 1
    public final Color BUTTON_FG_COLOR_NEW; // 2
    public final Color BUTTON_FG_COLOR_OLD; // 2
    public final Color BUTTON_BG_COLOR_OLD; // 2
    public final Color BUTTON_BG_COLOR_NEW_RED; // 2
    public final Color BUTTON_BG_COLOR_PRESS_RED; // 2
    public final Color BUTTON_BG_COLOR_NEW_BLUE; // 2
    public final Color BUTTON_BG_COLOR_PRESS_BLUE; // 2
    public final Color BUTTON_BG_COLOR_NEW_SKYBLUE; // 2
    public final Color BUTTON_BG_COLOR_PRESS_SKYBLUE; // 2
    public final Color BUTTON_BG_COLOR_NEW_DEFAULT; // 2
    public final Color BUTTON_BG_COLOR_PRESS_DEFAULT; // 2
    public final Color BUTTON_BG_COLOR_NEW_GRAY; // 2
    public final Color BUTTON_BG_COLOR_PRESS_GRAY; // 2
    public final Color BUTTON_BG_COLOR_NEW_GREEN; // 2
    public final Color BUTTON_BG_COLOR_PRESS_GREEN; // 2
    public final Color BUTTON_BG_COLOR_NEW_ORANGE; // 2
    public final Color BUTTON_BG_COLOR_PRESS_ORANGE; // 2
    public final Color BUTTON_BG_COLOR_NEW_VIOLET; // 2
    public final Color BUTTON_BG_COLOR_PRESS_VIOLET; // 2
    public final Color BUTTON_BG_COLOR_NEW_YELLOW; // 2
    public final Color BUTTON_BG_COLOR_PRESS_YELLOW; // 2

    public ClassConstantsCustom() {

        this.PANEL_FRAME = 1;
        this.PANEL_POPUP = 2;

        this.PANEL_HOME   = "PANEL_HOME";
        this.PANEL_DBD    = "PANEL_DBD";
        
        this.PANEL_CMP     = "PANEL_CMP";
        this.PANEL_EMP     = "PANEL_EMP";
        this.PANEL_EMP_PFL = "PANEL_EMP_PFL";
        this.PANEL_EMP_DEP = "PANEL_EMP_DEP";
        this.PANEL_EMP_ELG = "PANEL_EMP_ELG";
        this.PANEL_EMP_TRN = "PANEL_EMP_TRN";
        this.PANEL_CAT     = "PANEL_CAT";
        this.PANEL_DPT     = "PANEL_DEP";
        this.PANEL_POS     = "PANEL_POS";
        this.PANEL_ELG     = "PANEL_ELG";
        this.PANEL_TRN     = "PANEL_TRN";
        this.PANEL_LVS     = "PANEL_LVS";
       
        this.TABLE_ACCOUNT_TYPE         = "account_type";
        this.TABLE_ACCOUNT_HEADER       = "account_header";
        this.TABLE_ACCOUNT_DETAIL       = "account_detail";
        this.TABLE_EMPLOYEE_HEADER      = "employee_header";
        this.TABLE_EMPLOYEE_DETAIL      = "employee_detail";
        this.TABLE_MANAGE_DEPENDENTS    = "settings_manage_dependent";
        this.TABLE_MANAGE_ELIGIBILITY   = "settings_manage_eligibility";
        this.TABLE_MANAGE_TRAINING      = "settings_manage_training";
        this.TABLE_LIST_CATEGORY        = "settings_list_category";
        this.TABLE_LIST_OFFICE          = "settings_list_office";
        this.TABLE_LIST_POSITION        = "settings_list_position";
        this.TABLE_LIST_ELIGIBILITY     = "settings_list_eligibility";
        this.TABLE_LIST_TRAINING        = "settings_list_training";

        this.TABLE_SEARCH_NAME_FULL     = "TABLE_SEARCH_NAME_FULL";
        this.TABLE_SEARCH_NAME_FIRST    = "TABLE_SEARCH_NAME_FIRST";
        this.TABLE_SEARCH_NAME_MIDDLE   = "TABLE_SEARCH_NAME_MIDDLE";
        this.TABLE_SEARCH_NAME_LAST     = "TABLE_SEARCH_NAME_LAST";
        this.TABLE_SEARCH_PLANTILLA_NO  = "TABLE_SEARCH_PLANTILLA_NO";
        this.TABLE_SEARCH_POSITION      = "TABLE_SEARCH_POSITION";
        this.TABLE_SEARCH_OFFICE        = "TABLE_SEARCH_OFFICE";
        this.TABLE_SEARCH_CATEGORY      = "TABLE_SEARCH_CATEGORY";

        this.LIST_GENDER            = new ArrayList<>(Arrays.asList("Male", "Female"));
        this.LIST_CIVIL_STATUS      = new ArrayList<>(Arrays.asList("Single", "Married", "Widowed", "Divorced"));
        this.LIST_SEARCH_FILTER     = new ArrayList<>(Arrays.asList("First Name", "Middle Name", "Last Name", "Plantilla #", "Position", "Office", "Category"));

        this.COLUMN_FULL_NAME       = "(COALESCE(h.name_first || ' ', '') || COALESCE(h.name_middle || ' ', '') || h.name_last)";
        this.COLUMN_FIRST_NAME      = "h.name_first";
        this.COLUMN_MIDDLE_NAME     = "h.name_middle";
        this.COLUMN_LAST_NAME       = "h.name_last";
        this.COLUMN_PLANTILLA_NUM   = "h.plantilla_id";
        this.COLUMN_POSITION        = "p.name";
        this.COLUMN_OFFICE          = "o.name";
        this.COLUMN_CATEGORY        = "c.name";
        this.COLUMN_DATE_HIRED      = "h.date_hired";
        this.COLUMN_BIRTHDATE       = "d.date_birth";
        this.COLUMN_GENDER          = "d.gender";
        this.COLUMN_CIVIL_STATUS    = "d.civil_status";

        this.COLUMN_FULL_NAME_UC       = "UCASE(h.name_first || ' ' || h.name_middle || ' ' || h.name_last)";
        this.COLUMN_FIRST_NAME_UC      = "UCASE(h.name_first)";
        this.COLUMN_MIDDLE_NAME_UC     = "UCASE(h.name_middle)";
        this.COLUMN_LAST_NAME_UC       = "UCASE(h.name_last)";
        this.COLUMN_PLANTILLA_NUM_UC   = "UCASE(h.plantilla_id)";
        this.COLUMN_POSITION_UC        = "UCASE(p.name)";
        this.COLUMN_OFFICE_UC          = "UCASE(o.name)";
        this.COLUMN_CATEGORY_UC        = "UCASE(c.name)";
        this.COLUMN_DATE_HIRED_UC      = "UCASE(h.date_hired)";
        this.COLUMN_BIRTHDATE_UC       = "UCASE(d.date_birth)";
        this.COLUMN_GENDER_UC          = "UCASE(d.gender)";
        this.COLUMN_CIVIL_STATUS_UC    = "UCASE(d.civil_status)";
        
        this.ROW_BG_COLOR_ODD    = new Color(245, 245, 245);
        this.ROW_BG_COLOR_EVEN   = new Color(250, 250, 250);
        this.ROW_BG_COLOR_SELECT_DEFAULT = new Color(115, 164, 209);
        this.ROW_BG_COLOR_SELECT_BLUE      = new Color(12, 107, 181);
        this.ROW_BG_COLOR_SELECT_GRAY      = new Color(193, 193, 193);
        this.ROW_BG_COLOR_SELECT_GREEN     = new Color(12, 152, 66);
        this.ROW_BG_COLOR_SELECT_ORANGE    = new Color(240, 93, 31);
        this.ROW_BG_COLOR_SELECT_RED       = new Color(233, 28, 34);
        this.ROW_BG_COLOR_SELECT_VIOLET    = new Color(118, 56, 143);
        this.ROW_BG_COLOR_SELECT_YELLOW    = new Color(253, 217, 15);
        this.BUTTON_FG_COLOR_NEW = new Color(255, 255, 255);
        this.BUTTON_FG_COLOR_OLD = new Color(40, 40, 40);
        this.BUTTON_BG_COLOR_OLD = new Color(255, 255, 255);
        
        this.BUTTON_BG_COLOR_NEW_BLUE      = new Color(12, 107, 181);
        this.BUTTON_BG_COLOR_PRESS_BLUE    = new Color(02, 97, 171);
        this.BUTTON_BG_COLOR_NEW_SKYBLUE   = new Color(91, 192, 222);
        this.BUTTON_BG_COLOR_PRESS_SKYBLUE = new Color(49, 176, 213);
        this.BUTTON_BG_COLOR_NEW_DEFAULT   = new Color(115, 164, 209);
        this.BUTTON_BG_COLOR_PRESS_DEFAULT = new Color(105, 154, 199);
        this.BUTTON_BG_COLOR_NEW_GRAY      = new Color(150, 150, 150);
        this.BUTTON_BG_COLOR_PRESS_GRAY    = new Color(135, 135, 135);
        this.BUTTON_BG_COLOR_NEW_GREEN     = new Color(12, 152, 66);
        this.BUTTON_BG_COLOR_PRESS_GREEN   = new Color(07, 142, 56);
        this.BUTTON_BG_COLOR_NEW_ORANGE    = new Color(240, 93, 31);
        this.BUTTON_BG_COLOR_PRESS_ORANGE  = new Color(230, 83, 21);
        this.BUTTON_BG_COLOR_NEW_RED       = new Color(229, 57, 53);
        this.BUTTON_BG_COLOR_PRESS_RED     = new Color(219, 47, 43);
        this.BUTTON_BG_COLOR_NEW_VIOLET    = new Color(118, 56, 143);
        this.BUTTON_BG_COLOR_PRESS_VIOLET  = new Color(108, 46, 133);
        this.BUTTON_BG_COLOR_NEW_YELLOW    = new Color(253, 217, 15);
        this.BUTTON_BG_COLOR_PRESS_YELLOW  = new Color(243, 207, 05);
    }
    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src_class;

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
    final protected int PANEL_FRAME;
    final protected int PANEL_POPUP;

    /**
     * Main Frame Panel
     */
    final protected String FRAME_HOME;
    final protected String FRAME_EMP_HOME;
    final protected String FRAME_EMP_SEARCH;
    final protected String FRAME_EMP_CREATE;

    /**
     * Database Employee Table
     */
    final protected String TABLE_ACCOUNT_TYPE;
    final protected String TABLE_ACCOUNT_HEADER;
    final protected String TABLE_ACCOUNT_DETAIL;
    final protected String TABLE_EMPLOYEE_HEADER;
    final protected String TABLE_EMPLOYEE_DETAIL;
    final protected String TABLE_MANAGE_DEPENDENTS;
    final protected String TABLE_MANAGE_ELIGIBILITY;
    final protected String TABLE_MANAGE_TRAINING;
    final protected String TABLE_LIST_CATEGORY;
    final protected String TABLE_LIST_OFFICE;
    final protected String TABLE_LIST_POSITION;
    final protected String TABLE_LIST_ELIGIBILITY;
    final protected String TABLE_LIST_TRAINING;

    /**
     * Database Employee Info Columns
     */
    final ArrayList<String> LIST_GENDER;
    final ArrayList<String> LIST_CIVIL_STATUS;
    final ArrayList<String> LIST_SEARCH_FILTER;

    /**
     * Database Employee Info Columns
     */
    final protected String COLUMN_FULL_NAME;
    final protected String COLUMN_FIRST_NAME;
    final protected String COLUMN_MIDDLE_NAME;
    final protected String COLUMN_LAST_NAME;
    final protected String COLUMN_PLANTILLA_NUM;
    final protected String COLUMN_POSITION;
    final protected String COLUMN_OFFICE;
    final protected String COLUMN_CATEGORY;
    final protected String COLUMN_DATE_HIRED;
    final protected String COLUMN_BIRTHDATE;
    final protected String COLUMN_GENDER;
    final protected String COLUMN_CIVIL_STATUS;

    /**
     * Database Employee Info Columns (UPPERCASE)
     */
    final protected String COLUMN_FULL_NAME_UC;
    final protected String COLUMN_FIRST_NAME_UC;
    final protected String COLUMN_MIDDLE_NAME_UC;
    final protected String COLUMN_LAST_NAME_UC;
    final protected String COLUMN_PLANTILLA_NUM_UC;
    final protected String COLUMN_POSITION_UC;
    final protected String COLUMN_OFFICE_UC;
    final protected String COLUMN_CATEGORY_UC;
    final protected String COLUMN_DATE_HIRED_UC;
    final protected String COLUMN_BIRTHDATE_UC;
    final protected String COLUMN_GENDER_UC;
    final protected String COLUMN_CIVIL_STATUS_UC;

    public ClassConstantsCustom() {

        this.PANEL_FRAME = 1;
        this.PANEL_POPUP = 2;
        
        this.FRAME_HOME   = "FRAME_HOME";
        this.FRAME_EMP_HOME   = "FRAME_EMP_HOME";
        this.FRAME_EMP_SEARCH = "FRAME_EMP_SEARCH";
        this.FRAME_EMP_CREATE = "FRAME_EMP_CREATE";

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

    }
    
}
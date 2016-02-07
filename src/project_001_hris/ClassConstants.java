/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package project_001_hris;

/**
 *
 * @author Blacqueous
 */
public class ClassConstants {

    /**
     * Database Employee Table
     */
    final protected String TABLE_ACCOUNT_TYPE;
    final protected String TABLE_CATEGORY;
    final protected String TABLE_OFFICE;
    final protected String TABLE_POSITION;
    final protected String TABLE_TRAINING;
    final protected String TABLE_ELIGIBILITY;
    
    /**
     * Database Employee Info Columns
     */
    final protected String COLUMN_FULL_NAME;
    final protected String COLUMN_FIRST_NAME;
    final protected String COLUMN_MIDDLE_NAME;
    final protected String COLUMN_LAST_NAME;
    final protected String COLUMN_POSITION;
    final protected String COLUMN_PLANTILLA_NUM;
    final protected String COLUMN_CATEGORY;
    final protected String COLUMN_OFFICE;
    final protected String COLUMN_BIRTHDATE;
    final protected String COLUMN_GENDER;
    final protected String COLUMN_AGE;
    final protected String COLUMN_MARITAL_STATUS;
    final protected String COLUMN_NUM_GSIS;
    final protected String COLUMN_NUM_PAGIBIG;
    final protected String COLUMN_NUM_PHIC;
    final protected String COLUMN_NUM_SSS;
    final protected String COLUMN_NUM_TIN;
    final protected String COLUMN_SALARY;
    final protected String COLUMN_DATE_HIRED;
    final protected String COLUMN_YEARS_OF_SERVICE;

    public ClassConstants() {
        this.TABLE_ACCOUNT_TYPE = "account_type";
        this.TABLE_CATEGORY = "settings_category";
        this.TABLE_ELIGIBILITY = "settings_eligibility";
        this.TABLE_TRAINING = "settings_training";
        this.TABLE_OFFICE = "settings_office";
        this.TABLE_POSITION = "settings_position";
        this.COLUMN_FULL_NAME = "CONCAT(edh.name_last,', ',edh.name_first,' ',edh.name_middle)";
        this.COLUMN_FIRST_NAME = "e2h.name_first";
        this.COLUMN_MIDDLE_NAME = "edh.name_middle";
        this.COLUMN_LAST_NAME = "edh.name_last";
        this.COLUMN_POSITION = "edh.position";
        this.COLUMN_PLANTILLA_NUM = "edh.plantilla_no";
        this.COLUMN_CATEGORY = "edh.category";
        this.COLUMN_OFFICE = "edh.office";
        this.COLUMN_BIRTHDATE = "CONCAT(MONTH(edd.birthdate),'-',DAY(edd.birthdate),'-',YEAR(edd.birthdate))";
        this.COLUMN_GENDER = "edd.gender";
        this.COLUMN_AGE = "YEAR(now())-YEAR(edd.birthdate)";
        this.COLUMN_MARITAL_STATUS = "edd.marital_status";
        this.COLUMN_NUM_GSIS = "edd.code_GSIS";
        this.COLUMN_NUM_PAGIBIG = "edd.code_PAGIBIG";
        this.COLUMN_NUM_PHIC = "edd.code_PHIC";
        this.COLUMN_NUM_SSS = "edd.code_SSS";
        this.COLUMN_NUM_TIN = "edd.code_TIN";
        this.COLUMN_SALARY = "edd.salary";
        this.COLUMN_DATE_HIRED = "CONCAT(MONTH(edd.date_hired),'-',DAY(edd.date_hired),'-',YEAR(edd.date_hired))";
        this.COLUMN_YEARS_OF_SERVICE = "YEAR(now())-YEAR(edd.date_hired)";
    }
    
}

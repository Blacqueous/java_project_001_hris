/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src_class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author egrubellano
 */
public class ClassMyDBConnectionEmbeddedDerby {

    public static Connection myConnection;
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String JDBC_URL = "jdbc:derby:project001;create=true";
    public static ClassConstantsCustom constant = new ClassConstantsCustom();

    public ClassMyDBConnectionEmbeddedDerby() {};

    public static void initDB() {
        try {
            Class.forName(DRIVER);
            myConnection = DriverManager.getConnection(JDBC_URL);
        } catch(ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static Connection getMyConnection() {
        return myConnection;
    }

    /*
     * View table entries
     * @param table 
    */
    public static void viewTable(String table) {
        try {
            try (Statement st = myConnection.createStatement()) {
                ResultSet rs = st.executeQuery("SELECT * FROM " + table);
                ResultSetMetaData rsm = rs.getMetaData();
                int columnCount = rsm.getColumnCount();
                
                for (int i = 1; i <= columnCount; i++) {
                    System.out.format("%20s", rsm.getColumnName(i) + " | ");
                }
                while (rs.next()) {
                    System.out.println("");
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.format("%20s", rs.getString(i) + " | ");
                    }
                }
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static void createTableAccountType() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_ACCOUNT_TYPE);
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_ACCOUNT_TYPE + " ( "
                                                + " id  INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " code varchar(25) NOT NULL default '', " 
                                                + " name varchar(100) NOT NULL default '' " 
                                                + " ) ");
//            myConnection.createStatement().execute("ALTER TABLE " + constant.TABLE_ACCOUNT_TYPE
//                                                + " ADD CONSTRAINT uk_acct_type_code UNIQUE (code) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_ACCOUNT_TYPE.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_ACCOUNT_TYPE.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void insertTableAccountType() {
        try {
            myConnection.createStatement().execute("INSERT INTO " + constant.TABLE_ACCOUNT_TYPE + " ( code, name) VALUES"
                                                + " ( 'MASTR', 'Master Account'),"
                                                + " ( 'ADMIN', 'Administrator'),"
                                                + " ( 'USER',  'User Account'),"
                                                + " ( 'GUEST', 'Guest')");
            System.out.println("Database Connection: Entry for table <" + constant.TABLE_ACCOUNT_TYPE.toLowerCase() + "> successfully inserted.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.uniqueAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println("Entry already exists in table <" + constant.TABLE_ACCOUNT_TYPE.toLowerCase() + ">. No need to reinsert.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void createTableAccountHeader() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_ACCOUNT_DETAIL);
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_ACCOUNT_HEADER);
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_ACCOUNT_HEADER + " ( "
                                                + " id  INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " username VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " password VARCHAR(250) NOT NULL DEFAULT '', "
                                                + " acct_type_id INT NOT NULL DEFAULT 4, "
                                                + " CONSTRAINT fk_acct_type_id FOREIGN KEY (acct_type_id)"
                                                + " REFERENCES account_type(id)"
                                                + " ) ");
//            myConnection.createStatement().execute("ALTER TABLE " + constant.TABLE_ACCOUNT_HEADER
//                                                + " ADD CONSTRAINT uk_acct_hdr_username UNIQUE (username) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_ACCOUNT_HEADER.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_ACCOUNT_HEADER.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void insertTableAccountHeader() {
        try {
            myConnection.createStatement().execute("INSERT INTO " + constant.TABLE_ACCOUNT_HEADER + " (username, password) VALUES"
                                                + " ( 'test', 'test')");
            System.out.println("Database Connection: Entry for table <" + constant.TABLE_ACCOUNT_HEADER.toLowerCase() + "> successfully inserted.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.uniqueAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println("Entry already exists in table <" + constant.TABLE_ACCOUNT_HEADER.toLowerCase() + ">. No need to reinsert.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void createTableAccountDetail() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_ACCOUNT_DETAIL );
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_ACCOUNT_DETAIL + " ( "
                                                + " id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " header_id INT NOT NULL DEFAULT 0, "
                                                + " name_first VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " name_middle VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " name_last VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " gender VARCHAR(50) NOT NULL DEFAULT '', "
                                                + " email VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " phone_1 VARCHAR(50) NOT NULL DEFAULT '', "
                                                + " phone_2 VARCHAR(50) NOT NULL DEFAULT '', "
                                                + " CONSTRAINT fk_acct_hdr_id FOREIGN KEY (header_id) "
                                                + " REFERENCES account_header (id) "
                                                + " ) ");
//            myConnection.createStatement().execute("ALTER TABLE " + constant.TABLE_ACCOUNT_DETAIL
//                                                + " ADD CONSTRAINT uk_acct_dtl_hdr_id UNIQUE (header_id) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_ACCOUNT_DETAIL.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_ACCOUNT_DETAIL.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void createTableSettingsListCategory() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_LIST_CATEGORY );
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_LIST_CATEGORY + " ( "
                                                + " id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " name VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " img_src VARCHAR(500) DEFAULT NULL "
                                                + " ) ");
//            myConnection.createStatement().execute("ALTER TABLE " + constant.TABLE_LIST_CATEGORY
//                                                + " ADD CONSTRAINT uk_settings_cat_name UNIQUE (name) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_LIST_CATEGORY.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_LIST_CATEGORY.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void insertTableSettingsListCategory() {
        try {
            myConnection.createStatement().execute("INSERT INTO " + constant.TABLE_LIST_CATEGORY + " (name) VALUES"
                                                + " ('Faculty'),"
                                                + " ('Staff'),"
                                                + " ('Job Order') ");
            System.out.println("Database Connection: Entry for table <" + constant.TABLE_LIST_CATEGORY.toLowerCase() + "> successfully inserted.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.uniqueAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println("Entry already exists in table <" + constant.TABLE_LIST_CATEGORY.toLowerCase() + ">. No need to reinsert.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void createTableSettingsListOffice() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_LIST_OFFICE);
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_LIST_OFFICE + " ( "
                                                + " id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " name VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " img_src VARCHAR(500) DEFAULT NULL "
                                                + " ) ");
//            myConnection.createStatement().execute("ALTER TABLE " + constant.TABLE_LIST_OFFICE
//                                                + " ADD CONSTRAINT uk_settings_off_name UNIQUE (name) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_LIST_OFFICE.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_LIST_OFFICE.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void insertTableSettingsListOffice() {
        try {
            myConnection.createStatement().execute("INSERT INTO " + constant.TABLE_LIST_OFFICE + " (name) VALUES"
                                                + " ('Office of the Campus Director'),"
                                                + " ('Finance and Administrative Division'),"
                                                + " ('Curriculum and Instructional Services Division'),"
                                                + " ('Student''s Services Division') ");
            System.out.println("Database Connection: Entry for table <" + constant.TABLE_LIST_OFFICE.toLowerCase() + "> successfully inserted.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.uniqueAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println("Entry already exists in table <" + constant.TABLE_LIST_OFFICE.toLowerCase() + ">. No need to reinsert.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void createTableSettingsListPosition() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_LIST_POSITION );
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_LIST_POSITION + " ( "
                                                + " id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " name VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " img_src VARCHAR(500) DEFAULT NULL "
                                                + " ) ");
            myConnection.createStatement().execute("ALTER TABLE " + constant.TABLE_LIST_POSITION
                                                + " ADD CONSTRAINT uk_settings_pos_name UNIQUE (name) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_LIST_POSITION.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_LIST_POSITION.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void insertTableSettingsListPosition() {
        try {
            myConnection.createStatement().execute("INSERT INTO " + constant.TABLE_LIST_POSITION + " (name) VALUES"
                                                + " ('Accountant I'),"
                                                + " ('Accountant II'),"
                                                + " ('Accountant III'),"
                                                + " ('Administrative Aide'),"
                                                + " ('Programmer') ");
            System.out.println("Database Connection: Entry for table <" + constant.TABLE_LIST_POSITION.toLowerCase() + "> successfully inserted.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.uniqueAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println("Entry already exists in table <" + constant.TABLE_LIST_POSITION.toLowerCase() + ">. No need to reinsert.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void createTableSettingsListEligibility() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_LIST_ELIGIBILITY );
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_LIST_ELIGIBILITY + " ( "
                                                + " id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " name VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " img_src VARCHAR(500) DEFAULT NULL "
                                                + " ) ");
//            myConnection.createStatement().execute("ALTER TABLE " + constant.TABLE_LIST_ELIGIBILITY
//                                                + " ADD CONSTRAINT uk_settings_elg_name UNIQUE (name) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_LIST_ELIGIBILITY.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_LIST_ELIGIBILITY.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void insertTableSettingsListEligibility() {
        try {
            myConnection.createStatement().execute("INSERT INTO " + constant.TABLE_LIST_ELIGIBILITY + " (name) VALUES"
                                                + " ('Primary Eligibility'),"
                                                + " ('Secondary Eligibility'),"
                                                + " ('Tertiary Eligibility'),"
                                                + " ('Fourth Eligibility'),"
                                                + " ('Civil Service') ");
            System.out.println("Database Connection: Entry for table <" + constant.TABLE_LIST_ELIGIBILITY.toLowerCase() + "> successfully inserted.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.uniqueAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println("Entry already exists in table <" + constant.TABLE_LIST_ELIGIBILITY.toLowerCase() + ">. No need to reinsert.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void createTableSettingsListTraining() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_LIST_TRAINING );
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_LIST_TRAINING + " ( "
                                                + " id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " name VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " img_src VARCHAR(500) DEFAULT NULL "
                                                + " ) ");
//            myConnection.createStatement().execute("ALTER TABLE " + constant.TABLE_LIST_TRAINING
//                                                + " ADD CONSTRAINT uk_settings_trn_name UNIQUE (name) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_LIST_TRAINING.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_LIST_TRAINING.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void insertTableSettingsListTraining() {
        try {
            myConnection.createStatement().execute("INSERT INTO " + constant.TABLE_LIST_TRAINING + " (name) VALUES"
                                                + " ('Primary Training'),"
                                                + " ('Secondary Training'),"
                                                + " ('Tertiary Training'),"
                                                + " ('Fourth Training'),"
                                                + " ('Fifth Training') ");
            System.out.println("Database Connection: Entry for table <" + constant.TABLE_LIST_TRAINING.toLowerCase() + "> successfully inserted.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.uniqueAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println("Entry already exists in table <" + constant.TABLE_LIST_TRAINING.toLowerCase() + ">. No need to reinsert.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void createTableEmployeeHeader() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_EMPLOYEE_DETAIL );
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_EMPLOYEE_HEADER );
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_EMPLOYEE_HEADER + " ( "
                                                + " id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " name_first VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " name_middle VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " name_last VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " plantilla_id INT NOT NULL DEFAULT 0, "
                                                + " list_cat_id INT NOT NULL DEFAULT 1, "
                                                + " list_off_id INT NOT NULL DEFAULT 1, "
                                                + " list_pos_id INT NOT NULL DEFAULT 1, "
                                                + " salary INT NOT NULL DEFAULT 0, "
                                                + " date_hired DATE NOT NULL DEFAULT '0001-01-01 00:00:00', "
                                                + " CONSTRAINT fk_list_cat_id FOREIGN KEY (list_cat_id) REFERENCES settings_list_category (id), "
                                                + " CONSTRAINT fk_list_off_id FOREIGN KEY (list_off_id) REFERENCES settings_list_office (id), "
                                                + " CONSTRAINT fk_list_pos_id FOREIGN KEY (list_pos_id) REFERENCES settings_list_position (id) "
                                                + " ) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_EMPLOYEE_HEADER.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_EMPLOYEE_HEADER.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void createTableEmployeeDetail() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_EMPLOYEE_DETAIL );
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_EMPLOYEE_DETAIL + " ( "
                                                + " id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " header_id INT NOT NULL DEFAULT 0, "
                                                + " date_birth DATE NOT NULL DEFAULT '0001-01-01 00:00:00', "
                                                + " gender VARCHAR(10) NOT NULL DEFAULT 'Male', "
                                                + " address_prime VARCHAR(150) NOT NULL DEFAULT '', "
                                                + " address_other VARCHAR(150) DEFAULT NULL, "
                                                + " email VARCHAR(100) DEFAULT NULL, "
                                                + " civil_status VARCHAR(50) NOT NULL DEFAULT 'Single', "
                                                + " religion VARCHAR(100) DEFAULT NULL, "
                                                + " nationality VARCHAR(100) DEFAULT NULL, "
                                                + " phone_tele INT DEFAULT NULL, "
                                                + " phone_cell INT DEFAULT NULL, "
                                                + " phone_misc INT DEFAULT NULL, "
                                                + " code_GSIS VARCHAR(50) DEFAULT NULL, "
                                                + " code_PAGIBIG VARCHAR(50) DEFAULT NULL, "
                                                + " code_PHIC VARCHAR(50) DEFAULT NULL, "
                                                + " code_SSS VARCHAR(50) DEFAULT NULL, "
                                                + " code_TIN VARCHAR(50) DEFAULT NULL, "
                                                + " CONSTRAINT fk_emp_dtl_header_id FOREIGN KEY (header_id) REFERENCES " + constant.TABLE_EMPLOYEE_HEADER + " (id) "
                                                + " ) ");
            myConnection.createStatement().execute("ALTER TABLE " + constant.TABLE_EMPLOYEE_DETAIL
                                                + " ADD CONSTRAINT uk_emp_dtl_header_id UNIQUE (header_id) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_EMPLOYEE_DETAIL.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_EMPLOYEE_DETAIL.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void createTableSettingsManageDependents() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_MANAGE_DEPENDENTS );
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_MANAGE_DEPENDENTS + " ( "
                                                + " id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " emp_header_id INT DEFAULT NULL, "
                                                + " name VARCHAR(100) NOT NULL DEFAULT '', "
                                                + " date DATE NOT NULL DEFAULT '0001-01-01 00:00:00' "
                                                + " ) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_MANAGE_DEPENDENTS.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_MANAGE_DEPENDENTS.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void createTableSettingsManageEligibility() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_MANAGE_ELIGIBILITY );
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_MANAGE_ELIGIBILITY + " ( "
                                                + " id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " emp_header_id INT DEFAULT NULL, "
                                                + " mngr_elg_id INT DEFAULT NULL, "
                                                + " date DATE NOT NULL DEFAULT '0001-01-01 00:00:00' "
                                                + " ) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_MANAGE_ELIGIBILITY.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_MANAGE_ELIGIBILITY.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    public static void createTableSettingsManageTraining() {
        try {
//            myConnection.createStatement().execute("DROP TABLE " + constant.TABLE_MANAGE_TRAINING );
            myConnection.createStatement().execute("CREATE TABLE " + constant.TABLE_MANAGE_TRAINING + " ( "
                                                + " id INT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                                                + " emp_header_id INT DEFAULT NULL, "
                                                + " mngr_trn_id INT DEFAULT NULL, "
                                                + " date DATE NOT NULL DEFAULT '0001-01-01 00:00:00' "
                                                + " ) ");
            System.out.println("Database Connection: Table <" + constant.TABLE_MANAGE_TRAINING.toLowerCase() + "> successfully created.");
        } catch(SQLException e) {
            if(ClassMyDBConnectionEmbeddedDerbyUtils.tableAlreadyExists(e)) { //check if the exception is because of pre-existing table.
                System.out.println( "Table <" + constant.TABLE_MANAGE_TRAINING.toLowerCase() + "> already exists. No need to recreate.");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + "\nClosing system.", "Database Connection: Failed.", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        }
    }

    // RUN PROGRAM
//    public static void main(String[] args) throws SQLException {
//        initDB();
//
//        System.out.println("ACCOUNT TYPE");
////        createTableAccountType();
////        insertTableAccountType();
//        viewTable(constant.TABLE_ACCOUNT_TYPE);
//
//        System.out.println("\nACCOUNT HEADER");
////        createTableAccountHeader();
////        insertTableAccountHeader();
//        viewTable(constant.TABLE_ACCOUNT_HEADER);
//
//        System.out.println("\nACCOUNT DETAIL");
////        createTableAccountDetail();
////        insertTableAccountDetail();
//        viewTable(constant.TABLE_ACCOUNT_DETAIL);
//
//        System.out.println("\nSETTINGS LIST CATEGORIES");
//        createTableSettingsListCategory();
////        insertTableSettingsListCategory();
//        viewTable(constant.TABLE_LIST_CATEGORY);
//
//        System.out.println("\nSETTINGS LIST OFFICES");
//        createTableSettingsListOffice();
////        insertTableSettingsListOffice();
//        viewTable(constant.TABLE_LIST_OFFICE);
//
//        System.out.println("\nSETTINGS LIST POSITIONS");
////        createTableSettingsListPosition();
////        insertTableSettingsListPosition();
//        viewTable(constant.TABLE_LIST_POSITION);
//
//        System.out.println("\nSETTINGS LIST ELIGIBILITIES");
////        createTableSettingsListEligibility();
////        insertTableSettingsListEligibility();
//        viewTable(constant.TABLE_LIST_ELIGIBILITY);
//
//        System.out.println("\nSETTINGS LIST TRAININGS");
////        createTableSettingsListTraining();
////        insertTableSettingsListTraining();
//        viewTable(constant.TABLE_LIST_TRAINING);
//
//        System.out.println("\nEMPLOYEE HEADER");
//        createTableEmployeeHeader();
//        insertTableEmployeeHeader();
//        viewTable(constant.TABLE_EMPLOYEE_HEADER);

//        System.out.println("\nEMPLOYEE DETAIL");
//        createTableEmployeeDetail();
//        insertTableEmployeeDetail();
//        viewTable(constant.TABLE_EMPLOYEE_DETAIL);
//
//        System.out.println("\nDEPENDENTS MANAGER");
////        createTableSettingsManageDependents();
//        viewTable(constant.TABLE_MANAGE_DEPENDENTS);
//
//        System.out.println("\nELIGIBILITY MANAGER");
////        createTableSettingsManageEligibility();
//        viewTable(constant.TABLE_MANAGE_ELIGIBILITY);
//
//        System.out.println("\nTRAINING MANAGER");
////        createTableSettingsManageTraining();
//        viewTable(constant.TABLE_MANAGE_TRAINING);
//
//        myConnection.close();
//
//    }

}

//SELECT DATEDIFF(DAY, @Birth, GetDate()) / 365.25

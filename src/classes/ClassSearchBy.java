/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.swing.JComboBox;

/**
 *
 * @author egrubellano
 */
public class ClassSearchBy {

    private final ClassConstantsCustom constant = new ClassConstantsCustom();
    private String whereColumn = "";

    public String searchBySelect(JComboBox comboBox) {

        switch (comboBox.getSelectedItem().toString().toUpperCase()) {
            case "FIRST NAME":
                whereColumn = constant.COLUMN_FIRST_NAME;
                break;
            case "MIDDLE NAME":
                whereColumn = constant.COLUMN_MIDDLE_NAME;
                break;
            case "LAST NAME":
                whereColumn = constant.COLUMN_LAST_NAME;
                break;
            case "PLANTILLA #":
                whereColumn = constant.COLUMN_PLANTILLA_NUM;
                break;
            case "POSITION":
                whereColumn = constant.COLUMN_POSITION;
                break;
            case "OFFICE":
                whereColumn = constant.COLUMN_OFFICE;
                break;
            case "CATEGORY":
                whereColumn = constant.COLUMN_CATEGORY;
                break;
            default:
                whereColumn = constant.COLUMN_FULL_NAME;
                break;
        }

        return whereColumn;
    }

    public String searchBySelect(JComboBox comboBox, String whereString) {

        switch (comboBox.getSelectedItem().toString().toUpperCase()) {
            case "FIRST NAME":
                whereColumn = constant.COLUMN_FIRST_NAME_UC + " LIKE '" + whereString +"%'";
                break;
            case "MIDDLE NAME":
                whereColumn = constant.COLUMN_MIDDLE_NAME_UC + " LIKE '" + whereString +"%'";
                break;
            case "LAST NAME":
                whereColumn = constant.COLUMN_LAST_NAME_UC + " LIKE '" + whereString +"%'";
                break;
            case "PLANTILLA #":
                whereColumn = constant.COLUMN_PLANTILLA_NUM_UC + " LIKE '" + whereString +"%'";
                break;
            case "POSITION":
                whereColumn = constant.COLUMN_POSITION_UC + " LIKE '" + whereString +"%'";
                break;
            case "OFFICE":
                whereColumn = constant.COLUMN_OFFICE_UC + " LIKE '" + whereString +"%'";
                break;
            case "CATEGORY":
                whereColumn = constant.COLUMN_CATEGORY_UC + " LIKE '" + whereString +"%'";
                break;
            default:
                whereColumn = constant.COLUMN_FIRST_NAME_UC + " LIKE '%" + whereString +"%' OR " + constant.COLUMN_MIDDLE_NAME_UC + " LIKE '%" + whereString +"%' OR " + constant.COLUMN_LAST_NAME_UC + " LIKE '%" + whereString +"%'";
                break;
        }

        return whereColumn;
    }


    public String searchByString(String whereLabel, String whereString) {

        if (whereLabel.equals(constant.TABLE_SEARCH_NAME_FIRST)) {

            whereColumn = constant.COLUMN_FIRST_NAME_UC + " LIKE '" + whereString + "%'";
        } else if (whereLabel.equals(constant.TABLE_SEARCH_NAME_MIDDLE)) {

            whereColumn = constant.COLUMN_MIDDLE_NAME_UC + " LIKE '" + whereString + "%'";
        } else if (whereLabel.equals(constant.TABLE_SEARCH_NAME_LAST)) {

            whereColumn = constant.COLUMN_LAST_NAME_UC + " LIKE '" + whereString + "%'";
        } else if (whereLabel.equals(constant.TABLE_SEARCH_PLANTILLA_NO)) {

            whereColumn = constant.COLUMN_PLANTILLA_NUM_UC + " LIKE '" + whereString + "%'";
        } else if (whereLabel.equals(constant.TABLE_SEARCH_POSITION)) {

            whereColumn = constant.COLUMN_POSITION_UC + " LIKE '" + whereString + "%'";
        } else if (whereLabel.equals(constant.TABLE_SEARCH_OFFICE)) {

            whereColumn = constant.COLUMN_OFFICE_UC + " LIKE '" + whereString + "%'";
        } else if (whereLabel.equals(constant.TABLE_SEARCH_CATEGORY)) {

            whereColumn = constant.COLUMN_CATEGORY_UC + " LIKE '" + whereString + "%'";
        } else {

            whereColumn = constant.COLUMN_FIRST_NAME_UC + " LIKE '%" + whereString + "%' OR " + constant.COLUMN_MIDDLE_NAME_UC + " LIKE '%" + whereString + "%' OR " + constant.COLUMN_LAST_NAME_UC + " LIKE '%" + whereString +"%'";
        }

        return whereColumn;
    }

}

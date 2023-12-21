package com.example.tv;

import javafx.scene.control.TableView;

public class Controller {
    public TableView<KeystoneStudentData> myTableView;

    // MEETS EXPECTATIONS: Display at least 3 rows and 3 columns of data
    public void initialize() {
        // create data Objects
        KeystoneStudentData student1 = new KeystoneStudentData("Noah Frank", "Jonas", 12, false);
        KeystoneStudentData student2 = new KeystoneStudentData("Eli Phillips", "Pahomov", 12, false);

        // need to tell the TableView about each data object
        // ???????
    }

    // EXCEEDS EXPECTATIONS
    public void addNewData() {
        // need to get data that user typed or checked
        // ???

        // need to create a data Object from that data
        // ???

        // need to tell TableView about that new data Object
        // ???
    }

    // EXCEEDS EXPECTATIONS
    public void saveData() {

    }

    // EXCEEDS EXPECTATIONS
    public void restoreData() {

    }

}
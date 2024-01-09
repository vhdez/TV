package com.example.tv;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.*;

public class Controller {
    public TableView<KeystoneStudentData> myTableView;
    public TableColumn<KeystoneStudentData, String> nameColumn;
    public TableColumn<KeystoneStudentData, String> advisoryColumn;
    public TableColumn<KeystoneStudentData, Integer> gradeColumn;
    public TableColumn<KeystoneStudentData, Boolean> algTakingColumn;

    // MEETS EXPECTATIONS: Display at least 3 rows and 3 columns of data
    public void initialize() throws Exception {
        this.restoreData();
        // My TableView needs to have editing features turned on first:
        myTableView.setEditable(true);

        // Each column in my Table needs to be taught how to find the Object’s field for the data it displays:
        nameColumn.setCellValueFactory(new PropertyValueFactory<KeystoneStudentData, String>("studentName"));
        // Make each cell editable by setting up its CellFactory
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        // Set up an onAction method for cell edit commit event
        nameColumn.setOnEditCommit(event -> {
            KeystoneStudentData cellData = event.getRowValue();
            cellData.setStudentName(event.getNewValue());
        });

        advisoryColumn.setCellValueFactory(new PropertyValueFactory<KeystoneStudentData, String>("advisory"));
        advisoryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        advisoryColumn.setOnEditCommit(event -> {
            KeystoneStudentData cellData = event.getRowValue();
            cellData.setAdvisory(event.getNewValue());
        });

        gradeColumn.setCellValueFactory(new PropertyValueFactory<KeystoneStudentData, Integer>("grade"));
        gradeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        gradeColumn.setOnEditCommit(event -> {
            KeystoneStudentData cellData = event.getRowValue();
            cellData.setGrade(event.getNewValue());
        });

        algTakingColumn.setCellValueFactory(new PropertyValueFactory<KeystoneStudentData, Boolean>("algebraTaking"));
        algTakingColumn.setCellFactory(TextFieldTableCell.forTableColumn(new BooleanStringConverter()));
        algTakingColumn.setOnEditCommit(event -> {
            KeystoneStudentData cellData = event.getRowValue();
            cellData.setAlgebraTaking(event.getNewValue());
        });
    }

    // MEETS EXPECTATIONS
    public void saveData() throws Exception {
        File fileForData = new File("MyData");
        FileOutputStream outputStream = new FileOutputStream(fileForData);
        ObjectOutputStream objOutputStream = new ObjectOutputStream(outputStream);
        objOutputStream.writeObject(myTableView.getItems().size());
        for (KeystoneStudentData eachData : myTableView.getItems()) {
            objOutputStream.writeObject(eachData);
        }
        objOutputStream.flush();
        outputStream.flush();
    }

    // MEETS EXPECTATIONS
    public void restoreData() throws Exception {
        File fileForData = new File("MyData");
        FileInputStream inputStream = new FileInputStream(fileForData);
        ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
        Integer numOfSavedObjects = (Integer)objInputStream.readObject();
        for (int i = 0; i < numOfSavedObjects; i = i + 1) {
            KeystoneStudentData eachData = (KeystoneStudentData) objInputStream.readObject();
            myTableView.getItems().add(eachData);
        }
        inputStream.close();
    }

    // EXCEEDS EXPECTATIONS
    public void userAddNewData() {
        // need to get data that user typed or checked
        // ???

        // need to create a data Object from that data
        // ???

        // need to tell TableView about that new data Object
        // ???
    }

}
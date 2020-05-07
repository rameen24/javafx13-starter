package com.sample.Data;

import com.sample.Data.Datamaskin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class DatamaskinCollection {

        public ObservableList<Datamaskin> enMaskin = FXCollections.observableArrayList();

        public void attachTableView(TableView<Datamaskin> tableView) {

            tableView.setItems(enMaskin);
        }

        public void addElement(Datamaskin objekt) {
            enMaskin.add(objekt);
        }

}




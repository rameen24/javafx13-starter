package com.sample.ProduktData;

import com.sample.ProduktData.Produkter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class ProdukterCollection {

        public ObservableList<Produkter> enMaskin = FXCollections.observableArrayList();

        public void attachTableView(TableView<Produkter> tableView) {

            tableView.setItems(enMaskin);
        }

        public void addElement(Produkter objekt) {

            enMaskin.add(objekt);
        }

}




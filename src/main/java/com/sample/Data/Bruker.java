package com.sample.Data;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Bruker implements Serializable {
        private SimpleStringProperty fornavn;
        private SimpleStringProperty etternavn;
        private SimpleStringProperty epost;
        private SimpleStringProperty brukernavn;
        private SimpleObjectProperty passord;

        public Bruker(){

        }

        public Bruker(SimpleStringProperty fornavn, SimpleStringProperty etternavn, SimpleStringProperty epost, SimpleStringProperty brukernavn, SimpleObjectProperty password) {
            this.fornavn = fornavn;
            this.etternavn = etternavn;
            this.epost = epost;
            this.brukernavn = brukernavn;
            this.passord = password;
        }

        public String getFornavn() {
            return fornavn.get();
        }

        public SimpleStringProperty fornavnProperty() {
            return fornavn;
        }

        public void setFornavn(String fornavn) {
            this.fornavn.set(fornavn);
        }

        public String getEtternavn() {
            return etternavn.get();
        }

        public SimpleStringProperty etternavnProperty() {
            return etternavn;
        }

        public void setEtternavn(String etternavn) {
            this.etternavn.set(etternavn);
        }

        public String getEpost() {
            return epost.get();
        }

        public SimpleStringProperty epostProperty() {
            return epost;
        }

        public void setEpost(String epost) {
            this.epost.set(epost);
        }

        public String getBrukernavn() {
            return brukernavn.get();
        }

        public SimpleStringProperty brukernavnProperty() {
            return brukernavn;
        }

        public void setBrukernavn(String brukernavn) {
            this.brukernavn.set(brukernavn);
        }

        public Object getPassord() {
            return passord.get();
        }

        public SimpleObjectProperty passordProperty() {
            return passord;
        }

        public void setPassord(Object passord) {
            this.passord.set(passord);
        }

    }


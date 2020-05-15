package com.sample.Filhåndtering;

import com.sample.ProduktData.Produkter;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class FileReader {
    public static class readFile {

        public static List<Produkter> readSerializedFile(){
            System.out.println("Reading file.");

            try{
                FileInputStream fileInputStream = new FileInputStream("objectSuperList.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                List<Produkter> produkters = (List<Produkter>) objectInputStream.readObject();

                System.out.print("Objects are read from file.");

                System.out.println();
                System.out.println("Read Successful.\n");
                objectInputStream.close();
                return produkters;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Read Failed.\n" );
                return null;
            }
        }
}

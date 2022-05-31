package io;

import models.Student;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite2 {
    public void write(ArrayList<Student> st, String link) {
        File file = new File(link);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(st);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<Student> reader(String link){
        File file = new File(link);
        try {
         FileInputStream fileInputStream = new FileInputStream(file);
         ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
         return (ArrayList<Student>) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }
}

package io;

import models.ClassCG;
import models.Student;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite {
    public ArrayList<Student> readerStudent() {
        File file = new File("student.csv");
        ArrayList<Student> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arr = str.split(",");
                int age = Integer.parseInt(arr[1]);
                list.add(new Student(arr[0], age, arr[2], arr[3], arr[4], arr[5]));
                str = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public ArrayList<ClassCG> renderClassCG() {
        File file = new File("class.csv");
        ArrayList<ClassCG> cls = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null) {
                String[] arr = str.split(",");
                int numberStudent = Integer.parseInt(arr[3]);
                cls.add(new ClassCG(arr[0], arr[1], arr[2], numberStudent));
                str = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cls;
    }
    public void write(ArrayList<Student> st,String link) {
        File file = new File(link);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Student s:st
            ) {
                bufferedWriter.write(s.toString());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

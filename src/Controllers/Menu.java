package Controllers;

import io.ReadAndWrite;
import io.ReadAndWrite2;
import models.ClassCG;
import models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    ReadAndWrite rw = new ReadAndWrite();
    ReadAndWrite2 rw2 = new ReadAndWrite2();
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> students = rw2.reader("student.csv");
    ArrayList<ClassCG> classCGS = rw.renderClassCG();
    public void menu() {
        try {
            System.out.println("1|Enter student");
            System.out.println("2|Display student");
            System.out.println("3|Display student by class");
            System.out.println("4|Delete student");
            System.out.println("5|Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    students.add(createStudent());
                    break;
                case 2:
                    displayStudent();
                    break;
                case 3:
                    displayStudentByClass();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    rw2.write(students,"student.csv");
//                   rw.write(students,"student.csv");
                    System.exit(0);
            }
        }catch (Exception e){
            System.err.println("Wrong choice");
        }

    }
    public Student createStudent() {
        while (true) {
            try {
                System.out.println("Enter Name");
                String name = scanner.nextLine();
                System.out.println("Enter age");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter birth");
                String birth = scanner.nextLine();
                System.out.println("Enter phone number");
                String phone = scanner.nextLine();
                System.out.println("Enter address");
                String address = scanner.nextLine();
                System.out.println("Choice class");
                String nameClass = choiceClass();
                Student stNew = new Student(name, age, birth, phone, address, nameClass);
                return stNew;
            } catch (Exception e) {
                System.err.println("Retype");
            }
        }


    }

    public String choiceClass() {
        if (classCGS.isEmpty()){
            return null;
        }
        int index = 1;
        for (ClassCG cg : classCGS
        ) {
            System.out.println("ID " + index + cg);
            index++;
        }
        while (true) {
            try {
                System.out.println("Enter id class");
                int id = Integer.parseInt(scanner.nextLine());
                String name = classCGS.get(id - 1).getClassName();
                return name;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    public void displayStudent() {
        for (Student st : students
        ) {
            System.out.println("Name: " + st.getName() + " ,Age: " + st.getAge() + " ,Birth: " + st.getBirth() +
                    " ,Phone Number: " + st.getPhoneNumber()+" ,Address: "+st.getAddress()+" ,Class "+st.getClassCG());
        }
    }
    public void displayStudentByClass(){
        String className = choiceClass();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getClassCG().equals(className)){
                System.out.println(students.get(i));
            }
        }
    }
    public void deleteStudent(){
        System.out.println("Enter index");
        int index = Integer.parseInt(scanner.nextLine());
        students.remove(index);
    }
}

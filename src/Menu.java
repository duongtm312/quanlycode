import models.ClassCG;
import models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<ClassCG> classCGS = new ArrayList<>();
    public void menu() {
        try {
            System.out.println("1|Enter student");
            System.out.println("2|Display student");
            System.out.println("3|Display student by class");
            System.out.println("4|Exit");
            students = readerStudent();
            classCGS = renderClassCG();
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
                    System.exit(0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
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
                write(stNew);
                return stNew;
            } catch (Exception e) {
                System.err.println("Retype");
            }
        }


    }

    public String choiceClass() {
        int index = 1;
        for (ClassCG cg : classCGS
        ) {
            System.out.println("ID " + index + cg);
            index++;
        }
        System.out.println("Enter id class");
        int id = Integer.parseInt(scanner.nextLine());
        String name = classCGS.get(id - 1).getClassName();
        return name;
    }

    public void write(Student sd) {
        File file = new File("student.csv");
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(sd.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
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
}

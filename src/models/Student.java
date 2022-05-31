package models;

public class Student {
    private String name;
    private int age;
    private String birth;
    private String phoneNumber;
    private String address;
    private String classCG;

    public Student() {
    }

    public Student(String name, int age, String birth, String phoneNumber, String address, String classCG) {
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.classCG = classCG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClassCG() {
        return classCG;
    }

    public void setClassCG(String classCG) {
        this.classCG = classCG;
    }

    @Override
    public String toString() {
        return name +
                "," + age +
                "," + birth +
                "," + phoneNumber +
                "," + address +
                "," + classCG;
    }
}

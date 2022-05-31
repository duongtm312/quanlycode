package models;

import java.io.Serializable;

public class ClassCG implements Serializable {
    private String className;
    private String startDay;
    private String course;
    private int numberStudent;

    public ClassCG() {
    }

    public ClassCG(String className, String  startDay, String course, int numberStudent) {
        this.className = className;
        this.startDay = startDay;
        this.course = course;
        this.numberStudent = numberStudent;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getNumberStudent() {
        return numberStudent;
    }

    public void setNumberStudent(int numberStudent) {
        this.numberStudent = numberStudent;
    }

    @Override
    public String toString() {
        return ",Class Name='" + className + '\'' +
                ", Start Day=" + startDay +
                ", Course ='" + course + '\'' +
                ", Number Student=" + numberStudent;
    }
}

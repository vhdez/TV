package com.example.tv;

import java.io.Serializable;

public class KeystoneStudentData implements Serializable {
    String studentName;
    String advisory;
    int grade;
    boolean algebraTaking;

    public KeystoneStudentData(String studentName, String advisory, int grade, boolean algebraTaking) {
        this.studentName = studentName;
        this.advisory = advisory;
        this.grade = grade;
        this.algebraTaking = algebraTaking;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAdvisory() {
        return advisory;
    }

    public void setAdvisory(String advisory) {
        this.advisory = advisory;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean isAlgebraTaking() {
        return algebraTaking;
    }

    public void setAlgebraTaking(boolean algebraTaking) {
        this.algebraTaking = algebraTaking;
    }

    public String toString() {
        return studentName + advisory + grade + algebraTaking;
    }
}

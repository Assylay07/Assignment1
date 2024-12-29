package models;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int studentID;
    private static List<Integer> grades;
    private static int idCounter = 1;

    public Student(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        }
    }

    public double calculateGPA(){
        if (grades.isEmpty()){
            return 0.0;
        }
        int sum = 0;
        for(int grade : grades){
            sum += grade;
        }
        return (double)sum/grades.size();
    }

    @Override
    public String toString() {
        return super.toString() + "I am a student with ID " + studentID + '.';
    }

    public String getGrades() {
        return grades.toString();
    }

    public void setStudentID(int i) {
        this.studentID = i;
    }
}



import models.Person;
import models.Student;
import models.Teacher;
import models.School;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) throws FileNotFoundException {

        School school = new School();

        File studentFile = new File("src/student.txt");
        Scanner studentScanner = new Scanner(studentFile);

        int studentID = 1;
        while (studentScanner.hasNextLine()) {
            String[] data = studentScanner.nextLine().split(" ");
            String name = data[0];
            String surname = data[1];
            int age = Integer.parseInt(data[2]);
            boolean gender = data[3].equalsIgnoreCase("Male");
            List<Integer> grades = new ArrayList<>();
            for (int i = 4; i < data.length; i++) {
                grades.add(Integer.parseInt(data[i]));
            }

            Student student = new Student(name, surname, age, gender);
            grades.forEach(student::addGrade);
            student.setStudentID(studentID++);
            school.addMember(student);
        }

        studentScanner.close();

        File teacherFile = new File("src/teachers.txt");
        Scanner teacherScanner = new Scanner(teacherFile);

        while (teacherScanner.hasNextLine()) {
            String[] data = teacherScanner.nextLine().split(" ");
            String name = data[0];
            String surname = data[1];
            int age = Integer.parseInt(data[2]);
            boolean gender = data[3].equalsIgnoreCase("Male");
            String subject = data[4];
            int yearsOfExperience = Integer.parseInt(data[5]);
            double salary = Double.parseDouble(data[6]);

            Teacher teacher = new Teacher(name, surname, age, gender);
            teacher.setSubject(subject);
            teacher.setYearsOfExperience(yearsOfExperience);
            teacher.setSalary(salary);

            school.addMember(teacher);
        }

        teacherScanner.close();

        System.out.println("School Members:");
        System.out.println(school.toString());

        System.out.println("\nGPA Calculations:");
        for (Person member : school.getMembers()) {
            if (member instanceof Student student) {
                System.out.println(student.getName() + "'s GPA: " + String.format("%.2f", student.calculateGPA()));
            }
        }

        System.out.println("\nGiving raises to teachers with more than 10 years of experience:");
        for (Person member : school.getMembers()) {
            if (member instanceof Teacher teacher) {
                if (teacher.getYearsOfExperience() > 10) {
                    System.out.println("Before Raise: " + teacher);
                    teacher.giveRaise(10);
                    System.out.println("After Raise: " + teacher);
                }
            }
        }
    }
}

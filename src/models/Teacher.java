package models;

public class Teacher extends Person {

    private String subject;
    private int yearsOfExperience;
    private double salary;

    public Teacher(String name, String surname, int age, boolean gender) {
        super(name, surname, age, gender);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void giveRaise(double percentage){
        if (percentage > 0){
            this.salary += this.salary * percentage/100;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " I teach " + subject + ".";
    }
}




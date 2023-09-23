package lab1;

import java.util.Random;


public class Studentss {
    private static final Random random = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Student student = newStudent();
            System.out.println(studentType(student)+" " + student.displayStudent());
        }
    }

    private static Student newStudent() {
        int id = 100000 + random.nextInt(900000);
        double gpa = roundTo3SF(random.nextDouble() * 4);

        if (random.nextBoolean()) {
            return new Undergraduate(id, gpa);
        } else {
            return new Graduate(id, gpa);
        }
    }

    private static String studentType(Student student) {
        if (student instanceof Undergraduate) {
            return "Undergraduate";
        } else {
            return "Graduate";
        }
    }

    private static double roundTo3SF(double value) {
        double scaleFactor = Math.pow(10, 2); // 2 is used to get 3 significant figures for a number up to 4.000
        return Math.round(value * scaleFactor) / scaleFactor;
    }
}


abstract class Student {
    private int ID;
    private double GPA;

    public Student(int ID,double GPA){
        this.ID =ID;
        this.GPA = GPA;
    }
    public abstract String getStatus();

    public double getGPA(){
        return GPA;
    }
    public void setGPA(double GPA){
        this.GPA = GPA;
    }

    public final String displayStudent(){
        return "ID>> " + ID + ", GPA>> " + GPA + ", Status>> " + getStatus();    }


}

class Graduate extends Student {


    public Graduate(int ID,double GPA){
    super(ID, GPA);

    }

    @Override
    public String getStatus() {
        if(getGPA() >= 3 ){
            return "good";
        }else {
            return "probation";

        }
    }
}
class Undergraduate extends Student {

    public Undergraduate(int ID, double GPA) {
        super(ID, GPA);
    }

    @Override
    public String getStatus() {
        if (getGPA() >= 3) {
            return "honor";
        } else if (getGPA() >= 2) {
            return "good";
        } else {
            return "probation";
        }
    }
}




abstract class Student {
    private int rollNumber;
    private String name;
    private int semester;

    public Student(int rollNumber, String name, int semester) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.semester = semester;
    }

    // getters
    public int getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    // setters
    public void setRollNumber(int rollNumber) {
        if (rollNumber >= 0) {
            this.rollNumber = rollNumber;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemester(int semester) {
        if (semester >= 1 && semester <= 8) {
            this.semester = semester;
        }
    }

    abstract double calculateGrade();

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Semester: " + semester);
    }

    static String universityName = "LPU";

    static void displayUniversityName() {
        System.out.println("University: " + universityName);
    }

    final int MAX_SEMESTER = 8;

    final void showRules() {
        System.out.println("Max semesters allowed: " + MAX_SEMESTER);
    }
}

// Engineering student
class EngineeringStudent extends Student {
    private double internalMarks;
    private double externalMarks;

    public EngineeringStudent(int roll, String name, int sem,
                              double internal, double external) {
        super(roll, name, sem);
        this.internalMarks = internal;
        this.externalMarks = external;
    }

    @Override
    double calculateGrade() {
        return (internalMarks * 0.4) + (externalMarks * 0.6);
    }
}

// Medical student
class MedicalStudent extends Student {
    private double theoryMarks;
    private double practicalMarks;

    public MedicalStudent(int roll, String name, int sem,
                          double theoryMarks, double practicalMarks) {
        super(roll, name, sem);
        this.theoryMarks = theoryMarks;
        this.practicalMarks = practicalMarks;
    }

    @Override
    double calculateGrade() {
        return (theoryMarks + practicalMarks) / 2;
    }
}

// Interfaces
interface SportsParticipant {
    void playSport();
}

interface CulturalParticipant {
    void performActivity();
}

// All-rounder
class AllRounderStudent extends Student
        implements SportsParticipant, CulturalParticipant {

    private double score;

    public AllRounderStudent(int roll, String name, int sem, double score) {
        super(roll, name, sem);
        this.score = score;
    }

    @Override
    double calculateGrade() {
        return score;
    }

    public void playSport() {
        System.out.println(getName() + " plays football.");
    }

    public void performActivity() {
        System.out.println(getName() + " performs dance.");
    }
}

// Main class
public class Main{
    public static void main(String[] args) {

        Student s1 = new EngineeringStudent(1, "Amit", 4, 80, 90);
        Student s2 = new MedicalStudent(2, "Neha", 3, 85, 88);
        Student s3 = new AllRounderStudent(3, "Ravi", 2, 92);

        System.out.println(s1.calculateGrade());
        System.out.println(s2.calculateGrade());
        System.out.println(s3.calculateGrade());

        SportsParticipant sp = (SportsParticipant) s3;
        sp.playSport();
    }
}

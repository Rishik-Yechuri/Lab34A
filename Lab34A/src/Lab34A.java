import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Lab34A {
    public static void main(String args[]) throws IOException {
        DoubleList studentList = new DoubleList();
        studentList.getList();
        studentList.displayAll();
        studentList.pause();
        studentList.displayHonorRoll();
        studentList.pause();
        studentList.displayAcademicProbation();
        studentList.pause();
        int studentID = getID();
        Student2Node nodeRef = studentList.search(studentID);
        if (nodeRef == null) System.out.println("There is no student with an ID# of " + studentID + ".\n");
        else {
            studentList.displayStudent(nodeRef);
            studentList.pause();
            studentList.delete(nodeRef);
            studentList.displayAll();
            studentList.pause();
        }
    }

    public static int getID() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the 6-digit ID of the student.  { 100000 - 999999 }  -->  ");
        return input.nextInt();
    }
}

class Student2Node {
    private String name;
    private int id;
    private int age;
    private double gpa;
    private Student2Node forward;
    private Student2Node back;

    public Student2Node(String n, int ID, int a, double g, Student2Node f, Student2Node b) {
        name = n;
        id = ID;
        age = a;
        gpa = g;
        forward = f;
        back = b;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return gpa;
    }

    public Student2Node getForward() {
        return forward;
    }

    public Student2Node getBack() {
        return back;
    }

    public void setName(String n) {
        name = n;
    }

    public void setID(int ID) {
        id = ID;
    }

    public void setAge(int a) {
        age = a;
    }

    public void setGPA(double g) {
        gpa = g;
    }

    public void setForward(Student2Node f) {
        forward = f;
    }

    public void setBack(Student2Node b) {
        back = b;
    }
}

class DoubleList {
    Student2Node front, back;

    public DoubleList() {
        front = back = null;
    }

    public void getList() throws IOException {
        FileReader inFile = new FileReader("students2.dat");
        BufferedReader inStream = new BufferedReader(inFile);
        String s1, s2, s3, s4;
        int age, id;
        double gpa;
        while (((s1 = inStream.readLine()) != null) && ((s2 = inStream.readLine()) != null) && ((s3 = inStream.readLine()) != null) && ((s4 = inStream.readLine()) != null)) {
            String name = s1;
            id = Integer.parseInt(s2);
            age = Integer.parseInt(s3);
            gpa = Double.parseDouble(s4);
            Student2Node newStudent = new Student2Node(name, id, age, gpa, null, null);
            insert(newStudent);
        }
        inStream.close();
    }

    public void displayAll() {
        System.out.println("\nDISPLAYING ALL STUDENTS");
        System.out.println("\nStudent ID#     Student Name            Age         GPA");
        System.out.println("============================================================");
        Student2Node originalBack = front;
        back = front;
        boolean keepGoing = true;
        while (keepGoing) {
            if (back == null) {
                keepGoing = false;
                back = originalBack;
            } else {
                String spaceAfterName = "";
                for (int x = 0; x < (25 - back.getName().length()); x++) {
                    spaceAfterName += " ";
                }
                System.out.println(back.getID() + "\t\t   " + back.getName() + spaceAfterName + back.getAge() + "\t\t   " + back.getGPA());
                back = back.getForward();
            }
        }
    }

    public void displayHonorRoll() {
        System.out.println("\nDISPLAYING HONOR ROLL STUDENTS");
        System.out.println("\nStudent ID#     Student Name            Age         GPA");
        System.out.println("============================================================");
        Student2Node originalBack = front;
        back = front;
        boolean keepGoing = true;
        while (keepGoing) {
            if (back == null || back.getForward().getGPA() < 3.5) {
                keepGoing = false;
                back = originalBack;
            } else {
                String spaceAfterName = "";
                for (int x = 0; x < (25 - back.getName().length()); x++) {
                    spaceAfterName += " ";
                }
                System.out.println(back.getID() + "\t\t   " + back.getName() + spaceAfterName + back.getAge() + "\t\t   " + back.getGPA());
                back = back.getForward();
            }
        }
    }

    public void displayAcademicProbation() {
        System.out.println("\nDISPLAYING ACADEMIC PROBATION");
        System.out.println("\nStudent ID#     Student Name            Age         GPA");
        System.out.println("============================================================");
        Student2Node originalFront = front;
        while(front.getForward() != null){
            front = front.getForward();
        }
        boolean keepGoing = true;
        while (keepGoing) {
            if (front == null || front.getBack().getGPA() >= 2.0) {
                keepGoing = false;
                front = originalFront;
            } else {
                String spaceAfterName = "";
                for (int x = 0; x < (25 - front.getName().length()); x++) {
                    spaceAfterName += " ";
                }
                System.out.println(front.getID() + "\t\t   " + front.getName() + spaceAfterName + front.getAge() + "\t\t   " + front.getGPA());
                front = front.getBack();
            }
        }
    }

    public void pause() {
        Scanner input = new Scanner(System.in);
        String dummy;
        System.out.print("\nPress <Enter> to continue.");
        dummy = input.nextLine();
    }

    public void displayStudent(Student2Node p) {
        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
        System.out.println("GPA: " + p.getGPA());
    }

    private void insert(Student2Node newStudent) {
        if (front == null) {
            front = newStudent;
        } else {
            newStudent.setForward(front);
            newStudent.getForward().setBack(newStudent);
            front = newStudent;
        }
        Student2Node current = null, index = null;
        String tempName;
        int tempID;
        int tempAge;
        double tempGPA;
        for (current = front; current.getForward() != null; current = current.getForward()) {
            for (index = current.getForward(); index != null; index = index.getForward()) {
                if (current.getGPA() < index.getGPA()) {
                    tempName = current.getName();
                    tempID = current.getID();
                    tempAge = current.getAge();
                    tempGPA = current.getGPA();

                    current.setAge(index.getAge());
                    current.setName(index.getName());
                    current.setGPA(index.getGPA());
                    current.setID(index.getID());

                    index.setAge(tempAge);
                    index.setGPA(tempGPA);
                    index.setID(tempID);
                    index.setName(tempName);
                }
            }
        }
    }

    public Student2Node search(int studentID) {
        back = front;
        boolean keepGoing = true;
        while (keepGoing) {
            if (back == null) {
                keepGoing = false;
                //back = originalBack;
            } else {
                if(back.getID() == studentID){
                    return back;
                }
                back = back.getForward();
            }
        }
        return null;
    }

    public void delete(Student2Node p) {
        Student2Node temp1 = back.getBack();
        temp1.setForward(back.getForward());
        back.getForward().setBack(back.getBack());
        p.setBack(null);
        p.setForward(null);
    }
}
import java .io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
 class Student implements Serializable
 {
     private String name;
     private int rollNumber;
     private String grade;
     public  Student(String name,int rollNumber,String garde)
     {
         this.name = name;
         this.rollNumber = rollNumber;
         this.grade = grade;

     }
     public String getName()
     {
         return name;
     }
     public void setName(String name)
     {
         this.name = name;
     }
     public int getRollNumber()
     {
         return rollNumber;
     }
     public  void setRollNumber(int rollNumber)
     {
         this.rollNumber = rollNumber;
     }
     public static String getGrade()
     {
         return getGrade();
     }
 }
 class StudentManagmentSystem
 {
     private  List<Student> student;
     private  String dataFile;
     public StudentManagmentSystem(String dataFile)
     {
         this.dataFile = dataFile;
         student = new ArrayList<>();
         loadStudent();
     }
     public void addStudent(Student student)
     {
         Students.add(student);
         saveStudent();
     }
     public void removeStudent(Student student)
     {
        
         Students.remove(student);
         saveStudent();
     }
     public Student searchStudent(int rollNumber)
     {
         for(Student student : student)
         {
             if(student.getRollNumber() == rollNumber)
             {
                 return student;
             }
         }
         return null;
     }
     public void displayAllStudent()
     {
         for(Student student : student)
         {
             System.out.println("Name:" + student.getName() + ",Roll Number:"+student.getRollNumber() + ",Grade:" + Student.getGrade());
         }
     }
     private void loadStudent()
     {
         try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFile)))
         {
            student = (List<Student>) ois.readObject();
         }
         catch (IOException ClassNotFoundExceptione)
         {
             //File might not exist or empty
         } catch (ClassNotFoundException e) {

         }
     }
     private  void saveStudent()
     {
         try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFile)))
         {
             oos.writeObject(student);
         }
         catch(IOException e)
         {
             e.printStackTrace();
         }
     }

     private static class Students {
         public static void add(Student student) {
         }

         public static void remove(Student student) {
         }
     }
 }
 public  class Main
 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         StudentManagmentSystem system = new StudentManagmentSystem("student.dat");
         while (true) {
             System.out.println("\nStudent Management System");
             System.out.println("1.Add Student");
             System.out.println("2.Remove Student");
             System.out.println("3.Search Student");
             System.out.println("4.Display All Students");
             System.out.println("5.Exit");
             System.out.println("Enter your choice:");
             int choice = scanner.nextInt();
             scanner.nextLine();
             switch (choice)
             {
                 case 1:
                     System.out.println("Enter student name:");
                     String name = scanner.nextLine();
                     System.out.println("Enter roll number:");
                     int rollNumber = scanner.nextInt();
                     scanner.nextLine();
                     System.out.println("Enter grade:");
                     String grade = scanner.nextLine();
                     system.addStudent(new Student(name,rollNumber,grade));
                     break;
                 case 2:
                     System.out.println("Enter rollnumber of student to remove:");
                     int removeRollNumber = scanner.nextInt();
                     Student removeStudent = system.searchStudent(removeRollNumber);
                     if(removeStudent!=null)
                 {
                     system.removeStudent(removeStudent);
                     System.out.println("Student removed successfully.");
                 }
                     else
                 {
                     System.out.println("Student not found.");
                 }
                     break;
                 case  3:
                     System.out.println("Enter roll number of student to search:");
                     int searchRollNumber = scanner.nextInt();
                     Student foundStudent = system.searchStudent(searchRollNumber);
                     if (foundStudent!=null)
                 {
                     System.out.println("Student found:");
                     System.out.println("Name:" + foundStudent.getName() + ",RollNumber:" + foundStudent.getRollNumber() + ",Grade:" + foundStudent.getGrade());
                 }
                     else
                 {
                     System.out.println("Student not found.");
                 }
                     break;
                 case 4:

                     system.displayAllStudent();
                     break;
                 case 5:
                     System.out.println("Exiting....");
                     System.exit(0);
                     break;
                 default:
                     System.out.println("Invalid choice.Please try again.");
             }
         }
     }
}
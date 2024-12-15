package attandancetracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AttandanceManagement {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("1. ADD STUDENT");
            System.out.println("2. MARK ATTENDANCE");
            System.out.println("3. DISPLAY ATTENDANCE");
            System.out.println("4. SEARCH STUDENT");
            System.out.println("5. UPDATE STUDENT");
            System.out.println("6. DELETE STUDENT");
            System.out.println("7. EXIT");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1: // Add Student
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    students.add(new Student(studentId, name));
                    System.out.println("Student Added Successfully");
                    break;

                case 2: // Mark Attendance
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextInt();
                    scanner.nextLine(); 
                    String date = LocalDate.now().toString(); // Automatically get the current date
                    System.out.print("Is Present? (p/a): ");
                    char attendance = scanner.nextLine().charAt(0);

                    boolean isPresent = attendance == 'p' || attendance == 'P';

                    boolean found = false;
                    for (Student student : students) {
                        if (student.getStudentId() == studentId) {
                            student.markAttendance(date, isPresent);
                            found = true;
                            System.out.println("Attendance Marked Successfully for " + date);
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student Not Found");
                    }
                    break;

                case 3: // Display Attendance
                    System.out.println("----- Attendance Records -----");
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;

                case 4: // Search Student
                    System.out.print("Enter Student ID to Search: ");
                    studentId = scanner.nextInt();
                    found = false;
                    for (Student student : students) {
                        if (student.getStudentId() == studentId) {
                            System.out.println(student);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student Not Found");
                    }
                    break;

                case 5: // Update Student
                    System.out.print("Enter Student ID to Update: ");
                    studentId = scanner.nextInt();
                    found = false;
                    for (Student student : students) {
                        if (student.getStudentId() == studentId) {
                            System.out.print("Enter New Name: ");
                            String newName = scanner.next();
                            student.setName(newName); 
                            found = true;
                            System.out.println("Student Updated Successfully");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student Not Found");
                    }
                    break;

                case 6: // Delete Student
                    System.out.print("Enter Student ID to Delete: ");
                    studentId = scanner.nextInt();
                    found = false;
                    Iterator<Student> iterator = students.iterator();
                    while (iterator.hasNext()) {
                        Student student = iterator.next();
                        if (student.getStudentId() == studentId) {
                            iterator.remove();
                            found = true;
                            System.out.println("Student Deleted Successfully");
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student Not Found");
                    }
                    break;

                case 7: // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
            System.out.println();
        } while (choice != 7);

        scanner.close();
    }
}

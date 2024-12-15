package attandancetracker;


import java.util.HashMap;
import java.util.Map;

public class Student {
    
    private int studentId;
    private String name;
    private Map<String, Boolean> attendance; // Date -> Present/Absent

    // Constructor to initialize the student with an ID and name
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.attendance = new HashMap<>();
    }

    // Getter for student ID
    public int getStudentId() {
        return studentId;
    }

    // Getter for student name
    public String getName() {
        return name;
    }

    // Setter for student name
    public void setName(String name) {
        this.name = name;
    }
    
    // Method to mark attendance for a specific date
    public void markAttendance(String date, boolean isPresent) {
        attendance.put(date, isPresent);
    }

    // Getter for attendance map
    public Map<String, Boolean> getAttendance() {
        return attendance;
    }

    // Override toString to provide a readable representation of the student
    @Override
    public String toString() {
        return "ID: " + studentId + ", Name: " + name + ", Attendance: " + attendance;
    }
}

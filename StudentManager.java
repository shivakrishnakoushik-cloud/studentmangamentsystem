import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public boolean add(Student student) {
        if (findByRoll(student.getRollNumber()) != null) {
            System.out.println("Error: Roll number " + student.getRollNumber() + " already exists.");
            return false;
        }
        students.add(student);
        System.out.println("Student added successfully.");
        return true;
    }

    public void viewAll() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("\n--- Student Records ---");
        students.forEach(System.out::println);
        System.out.println("-----------------------");
    }

    public boolean update(int rollNumber, String newName, double newMarks) {
        Student s = findByRoll(rollNumber);
        if (s == null) {
            System.out.println("Error: Student with roll number " + rollNumber + " not found.");
            return false;
        }
        s.setName(newName);
        s.setMarks(newMarks);
        System.out.println("Student updated successfully.");
        return true;
    }

    public boolean delete(int rollNumber) {
        Student s = findByRoll(rollNumber);
        if (s == null) {
            System.out.println("Error: Student with roll number " + rollNumber + " not found.");
            return false;
        }
        students.remove(s);
        System.out.println("Student deleted successfully.");
        return true;
    }

    private Student findByRoll(int rollNumber) {
        return students.stream()
                .filter(s -> s.getRollNumber() == rollNumber)
                .findFirst()
                .orElse(null);
    }
}

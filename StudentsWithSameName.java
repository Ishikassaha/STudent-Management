import java.util.ArrayList;
import java.util.List;

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class Student {
    private int id;
    private String name;
    private String address;
    private String degree;

    public Student(int id, String name, String address, String degree) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
}

public class StudentsWithSameName {
    public static Student[] findDuplicates(Student[] students, String name) throws StudentNotFoundException {
        List<Student> duplicates = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                duplicates.add(student);
            }
        }
        if (duplicates.isEmpty()) {
            throw new StudentNotFoundException("No students found with name " + name);
        }
        return duplicates.toArray(new Student[0]);
    }

    public static Student[] getLongNamedStudents(Student[] original) throws StudentNotFoundException {
        List<Student> longNamedStudents = new ArrayList<>();
        for (Student student : original) {
            if (student.getName().length() > 4) {
                longNamedStudents.add(student);
            }
        }
        if (longNamedStudents.isEmpty()) {
            throw new StudentNotFoundException("No students found with name length greater than 4");
        }
        return longNamedStudents.toArray(new Student[0]);
    }

    public static void printBCAStudentsStartingWithI(Student[] students) throws StudentNotFoundException {
        boolean found = false;
        for (Student student : students) {
            if (student.getDegree().equalsIgnoreCase("BCA") && student.getName().startsWith("I")) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            throw new StudentNotFoundException("No BCA students found starting with 'I'");
        }
    }

    public static void main(String[] args) {
        //try {
            // Create BBA students
            Student[] bbaStudents = new Student[] {
                    new Student(1, "Ishika", "Address1", "BBA"),
                    new Student(2, "Rahul", "Address2", "BBA"),
                    new Student(3, "Ishika", "Address3", "BBA"),
                    new Student(4, "Sohan", "Address4", "BBA")
            };

            // Create BCA students
            Student[] bcaStudents = new Student[] {
                    new Student(5, "Ishan", "Address5", "BCA"),
                    new Student(6, "Ishita", "Address6", "BCA"),
                    new Student(7, "Ramesh", "Address7", "BCA"),
                    new Student(8, "Suresh", "Address8", "BCA"),
                    new Student(9, "Ila", "Address9", "BCA")
            };

            // Combine BBA and BCA students
            Student[] allStudents = new Student[bbaStudents.length + bcaStudents.length];
            System.arraycopy(bbaStudents, 0, allStudents, 0, bbaStudents.length);
            System.arraycopy(bcaStudents, 0, allStudents, bbaStudents.length, bcaStudents.length);

            // Print all students
            System.out.println("All Students:");
            for (Student student : allStudents) {
                System.out.println(student);
            }

            // Find duplicates
            try {
                Student[] duplicates = findDuplicates(allStudents, "Ishika");
                System.out.println("Duplicates:");
                for (Student student : duplicates) {
                    System.out.println(student);
                }
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
            }

            // Get long named students
            try {
                Student[] longNamedStudents = getLongNamedStudents(allStudents);
                System.out.println("Long Named Students:");
                for (Student student : longNamedStudents) {
                    System.out.println(student);
                }
            } catch (StudentNotFoundException e) {
                System.out.println(e.getMessage());
           // }
		}
	}
}

           
package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class _02_StudentsByFirstAndLastName {
    public static void main(String[] args) throws IOException {

        LinkedHashSet<Student> students = new LinkedHashSet<>();
        students = fillStudentSet(students);
        printStudentSet(students);

    }

    private static void printStudentSet(LinkedHashSet<Student> students) {
        students.stream()
                .filter(n -> (int) n.getFirstName().charAt(0) < (int) n.getLastName().charAt(0))
                .forEach(n -> System.out.printf("%s %s%n", n.getFirstName(), n.getLastName()));
    }

    private static LinkedHashSet<Student> fillStudentSet(LinkedHashSet<Student> students) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split("\\s+");
        while (!"END".equals(line[0])) {

            String firstName = line[0];
            String lastName = line[1];
            Student newStudent = new Student();
            newStudent.setFirstName(firstName);
            newStudent.setLastName(lastName);
            students.add(newStudent);

            line = bf.readLine().split("\\s+");
        }
        return students;
    }

    public static class Student {

        private String firstName;

        private String lastName;

        public Student() {
        }

        public Student(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}

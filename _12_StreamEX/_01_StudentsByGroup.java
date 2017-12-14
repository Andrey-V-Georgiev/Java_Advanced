package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _01_StudentsByGroup {

    static BufferedReader bf;
    static List<Student> students;

    public static void main(String[] args) throws IOException {
        students = new ArrayList<>();
        readAdFillTheListOsStudents();
        sortTheListOfStudents();

    }

    private static void sortTheListOfStudents() {

        students.stream()
                .filter(x -> x.getGroup() == 2)
                .sorted((a, b) -> a.getFirstName().compareTo(b.getFirstName()))
                .forEach(x -> System.out.printf("%s %s%n",x.getFirstName(), x.getLastName()));

    }

    private static void readAdFillTheListOsStudents() throws IOException {

        bf = new BufferedReader(new InputStreamReader(System.in));

        List<String> readLine = Stream.of(bf.readLine().split("\\s+"))
                .map(String::trim).collect(Collectors.toList());

        while (!"END".equals(readLine.get(0))) {

            String firstName = readLine.get(0);
            String lastName = readLine.get(1);
            int numGroup = Integer.parseInt(readLine.get(2));
            Student newStudent = new Student();
            newStudent.setFirstName(firstName);
            newStudent.setLastName(lastName);
            newStudent.setGroup(numGroup);
            students.add(newStudent);

            readLine = Stream.of(bf.readLine().split("\\s+"))
                    .map(String::trim).collect(Collectors.toList());
        }
    }

    public static class Student {

        private String firstName;

        private String lastName;

        private int group;

        public Student() {
        }

        public Student(String firstName, String lastName, int group) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.group = group;
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

        public int getGroup() {
            return group;
        }

        public void setGroup(int group) {
            this.group = group;
        }

    }
}

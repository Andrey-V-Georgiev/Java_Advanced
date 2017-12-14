package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class _03_StudentsByAge {

    static LinkedHashSet<Student> students;

    public static void main(String[] args) throws IOException {

        students = new LinkedHashSet<>();
        fillTheSetOfStudents();
        sortAndPrint();
    }

    private static void sortAndPrint() {

        students.stream().filter(x -> x.getAge() >= 18 && x.getAge() <= 24)
                .forEach(x -> System.out.printf("%s %s %d%n", x.getFirstName(), x.getLastName(), x.getAge()));
    }

    private static void fillTheSetOfStudents() throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split("\\s+");
        while (!"END".equals(line[0])) {

            String firstName = line[0];
            String lastName = line[1];
            int age = Integer.parseInt(line[2]);
            Student newStudent = new Student();
            newStudent.setFirstName(firstName);
            newStudent.setLastName(lastName);
            newStudent.setAge(age);
            students.add(newStudent);

            line = bf.readLine().split("\\s+");
        }
    }

    public static class Student {

        private String firstName;

        private String lastName;

        private int age;

        public Student() {
        }

        public Student(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
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

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

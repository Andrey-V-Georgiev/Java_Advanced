package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class _05_FilterStudentsByEmailDomain {

    static String firstName;
    static String lastName;
    static String domain;
    static LinkedHashSet<Student> students;

    public static void main(String[] args) throws IOException {
        students = new LinkedHashSet<>();
        fillTheSet();
        sortAndPrint();

    }

    private static void sortAndPrint() {
        students.stream()
                .filter(x -> x.getDomain().equals("gmail.com"))
                .forEach(x -> System.out.printf("%s %s%n",x.getFirstName(), x.getLastName()));
    }

    private static void fillTheSet() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split("\\s+");
        while (!"END".equals(line[0])) {
            String firstName = line[0];
            String lastName = line[1];
            String domain = line[2].split("@")[1];
            Student newStudent = new Student();
            newStudent.setFirstName(firstName);
            newStudent.setLastName(lastName);
            newStudent.setDomain(domain);
            students.add(newStudent);
            line = bf.readLine().split("\\s+");
        }
    }

    public static class Student {
        private String firstName;
        private String lastName;
        private String domain;

        public Student() {
        }

        public Student(String firstName, String lastName, String domain) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.domain = domain;
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

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }
    }
}

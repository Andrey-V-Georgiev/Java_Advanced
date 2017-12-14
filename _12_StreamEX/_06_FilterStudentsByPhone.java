package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _06_FilterStudentsByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashSet<Student> students = new LinkedHashSet<>();

        String line = bf.readLine();
         while(!"END".equals(line)){
            List<String> lineArr = Stream.of(line.split("\\s+")).collect(Collectors.toList());
            String firstName = lineArr.get(0);
            String lastName = lineArr.get(1);
            String phoneNumber = lineArr.get(2);
            Student newStudent = new Student();
            newStudent.setFirstName(firstName);
            newStudent.setLastName(lastName);
            newStudent.setPhoneNumber(phoneNumber);
            students.add(newStudent);
            line = bf.readLine();
        }

        students.stream().filter(x -> x.getPhoneNumber().startsWith("+3592")
                || x.getPhoneNumber().startsWith("02"))
                .forEach(x -> System.out.printf("%s %s%n", x.getFirstName(), x.getLastName()));
    }

    public static class Student {
        private String firstName;
        private String lastName;
        private String phoneNumber;

        public Student() {
        }

        public Student(String firstName, String lastName, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
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

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}

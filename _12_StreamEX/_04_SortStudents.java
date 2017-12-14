package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.stream.Collectors;

public class _04_SortStudents {
    static HashSet<Student> students;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        students = new HashSet<>();
        String[] line = bf.readLine().trim().split("\\s+");

        while(!"END".equals(line[0])){
            String firstName = line[0];
            String lastName = line[1];
            Student newStudent = new Student();
            newStudent.setFirstName(firstName);
            newStudent.setLastName(lastName);
            students.add(newStudent);
            line = bf.readLine().trim().split("\\s+");
        }

           students.stream()
                   .sorted((a, b) -> b.getFirstName().compareTo(a.getFirstName()))
                   .sorted((a, b)-> a.getLastName().compareTo(b.getLastName()))
                   .forEach(x -> System.out.printf("%s %s%n",x.getFirstName(), x.getLastName()));



    }

    public static class Student{
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

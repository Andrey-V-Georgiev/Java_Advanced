package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _07_ExcellentStudents {
    static List<Student> students;

    public static void main(String[] args) throws IOException {
        students = new ArrayList<>();
        fillStudentList();
        printByRequirements();
    }

    private static void printByRequirements() {
        students.stream()
                .filter(x -> x.getEstimates().contains(6))
                .forEach(x -> System.out.printf("%s %s%n",x.getFirstName(), x.getLastName()));
    }

    private static void fillStudentList() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bf.readLine().split("\\s+");
        while(!"END".equals(line[0])){

            String firstName = line[0];
            String lastName = line[1];
            List<Integer> estimates = new ArrayList<>();
            for (int i = 2; i < line.length; i++) {
                estimates.add(Integer.parseInt(line[i]));
            }
            Student newStudent = new Student();
            newStudent.setFirstName(firstName);
            newStudent.setLastName(lastName);
            newStudent.setEstimates(estimates);
            students.add(newStudent);

            line = bf.readLine().split("\\s+");
        }
    }

    static class Student{
        private String firstName;

        private String lastName;

        private List<Integer> estimates;

        public Student() {
        }

        public Student(String firstName, String lastName, List<Integer> estimates) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.estimates = estimates;
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

        public List<Integer> getEstimates() {
            return estimates;
        }

        public void setEstimates(List<Integer> estimates) {
            this.estimates = estimates;
        }
    }
}

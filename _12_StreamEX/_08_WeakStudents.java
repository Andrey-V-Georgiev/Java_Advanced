package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _08_WeakStudents {
    static List<Student> students;

    public static void main(String[] args) throws IOException {
        students = new ArrayList<>();
        fillStudentLIst();
        sortAndPrint();
    }

    private static void sortAndPrint() {
        students.stream()
                .filter(x -> x.estimates.size() >= 2)
                .forEach(x -> System.out.printf("%s %s%n", x.firstName, x.lastName));
    }

    public static void fillStudentLIst() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = bf.readLine();
        while (!"END".equals(inputLine)) {
            List<String> tokens = Stream.of(inputLine.split("\\s+")).collect(Collectors.toList());
            String firstName = tokens.get(0);
            String lastName = tokens.get(1);
            List<Integer> estimates = tokens.stream().skip(2)
                    .map(Integer::parseInt)
                    .filter(x -> x <= 3)
                    .collect(Collectors.toList());
            Student newStudent = new Student();
            newStudent.setFirstName(firstName);
            newStudent.setLastName(lastName);
            newStudent.setEstimates(estimates);
            students.add(newStudent);
            inputLine = bf.readLine();
        }
    }

    public static class Student {
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

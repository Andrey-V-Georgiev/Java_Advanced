package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class _01_StudentsByGroupRegex {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String regex = "(\\w+)\\s+(\\w+)\\s+(\\d+)";
        LinkedHashSet<Student> students = new LinkedHashSet<>();
        Pattern pattern = Pattern.compile(regex);
        String line = bf.readLine();
        Matcher matcher = pattern.matcher(line);
        while(true){
            while(matcher.find()){
                String firstName = matcher.group(1).trim();
                String lastName = matcher.group(2).trim();
                int group = Integer.parseInt(matcher.group(3).trim());
                Student newStudent = new Student();
                newStudent.setFirstName(firstName);
                newStudent.setLastName(lastName);
                newStudent.setGroup(group);
                students.add(newStudent);
            }
            if(line.endsWith("END")){
                break;
            }
            line = bf.readLine();
        }
        Stream<Student> studentsStream = students.stream();
        studentsStream
                 .filter(x -> x.getGroup() == 2)
                .sorted((a, b) -> a.getFirstName().compareTo(b.getFirstName()))
                .forEach(x -> System.out.printf("%s %s%n",x.getFirstName(), x.getLastName()));
    }

    public static class Student{
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

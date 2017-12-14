package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class _10_GroupByGroup {
    static List<Student> students;
    static TreeSet<Integer> sortedGroupsSet;

    public static void main(String[] args) throws IOException {
        students = new ArrayList<>();
        sortedGroupsSet = new TreeSet<>();
        fillStudentList();
        printByGroups();

    }

    private static void printByGroups() {

        for (Integer group : sortedGroupsSet) {
            System.out.printf("%s - ",group);

          List<String> printList =  students.stream()
                    .filter(x->x.getGroup()==group)
                    .map(x -> x.getFirstName() + " " + x.getLastName())
                    .collect(Collectors.toList());
            System.out.println(String.join(", ", printList));
        }
    }

    private static void fillStudentList() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split("\\s+");
        while(!"END".equals(line[0])){
            String firstName = line[0];
            String lastName = line[1];
            int group = Integer.parseInt(line[2]);
            Student newStudent = new Student();
            newStudent.setFirstName(firstName);
            newStudent.setLastName(lastName);
            newStudent.setGroup(group);
            sortedGroupsSet.add(group);
            students.add(newStudent);
            line = bf.readLine().split("\\s+");
        }
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

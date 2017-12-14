package _12_StreamEX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _11_StudentsJoinedToSpecialties {
    static List<Student> students;
    static List<Speciality> specialities;
    static List<Final> finalList;

    public static void main(String[] args) throws IOException {
        specialities = new ArrayList<>();
        students = new ArrayList<>();
        finalList = new ArrayList<>();
        fillSpecialitiesList();

        compileFinalList();
        finalList.stream()
                .sorted((a,b)->a.getName().compareTo(b.getName()))
                .forEach(x-> System.out.printf("%s %d %s%n",x.getName(),x.getFacultyNumber(),x.getSpeciality()));
    }

    private static List<Final> compileFinalList() {
        for (Student student : students) {
            for (Speciality speciality : specialities) {
                if(student.getFacultyNumber()==speciality.getFacultyNumber()){
                    Final newFinal = new Final();
                    newFinal.setName(student.getName());
                    newFinal.setSpeciality(speciality.getSpeciality());
                    newFinal.setFacultyNumber(speciality.getFacultyNumber());
                    finalList.add(newFinal);
                }
            }
        }
        return finalList;
    }

    private static void fillStudentList() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = bf.readLine().split("\\s+");

    }

    private static void fillSpecialitiesList() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = bf.readLine().split("\\s+");
        while (true) {

            while (!"Students:".equals(tokens[0])) {
                String speciality = String.format("%s %s", tokens[0], tokens[1]);
                int facultyNumber = Integer.parseInt(tokens[2]);
                Speciality newSpeciality = new Speciality();
                newSpeciality.setSpeciality(speciality);
                newSpeciality.setFacultyNumber(facultyNumber);
                specialities.add(newSpeciality);
                tokens = bf.readLine().split("\\s+");
            }

            tokens = bf.readLine().split("\\s+");
            while (!"END".equals(tokens[0])) {
                int facultyNumber = Integer.parseInt(tokens[0]);
                String name = String.format("%s %s",tokens[1], tokens[2]);
                Student newStudent = new Student();
                newStudent.setName(name);
                newStudent.setFacultyNumber(facultyNumber);
                students.add(newStudent);
                tokens = bf.readLine().split("\\s+");
            }
            break;
        }
    }

    public static class Final{
        private String name;
        private String speciality;
        private int facultyNumber;

        public Final() {
        }

        public Final(String name, String speciality, int facultyNumber) {
            this.name = name;
            this.speciality = speciality;
            this.facultyNumber = facultyNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        public int getFacultyNumber() {
            return facultyNumber;
        }

        public void setFacultyNumber(int facultyNumber) {
            this.facultyNumber = facultyNumber;
        }
    }

    public static class Speciality{
        private String speciality;
        private int facultyNumber;

        public Speciality() {
        }

        public Speciality(String speciality, int facultyNumber) {
            this.speciality = speciality;
            this.facultyNumber = facultyNumber;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        public int getFacultyNumber() {
            return facultyNumber;
        }

        public void setFacultyNumber(int facultyNumber) {
            this.facultyNumber = facultyNumber;
        }
    }

    public static class Student {
        private String name;
        private int facultyNumber;

        public Student() {
        }

        public Student(String name, String speciality, int facultyNumber) {
            this.name = name;
            this.facultyNumber = facultyNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getFacultyNumber() {
            return facultyNumber;
        }

        public void setFacultyNumber(int facultyNumber) {
            this.facultyNumber = facultyNumber;
        }
    }
}

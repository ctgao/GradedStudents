package io.zipcoder;

import java.util.ArrayList;
import java.util.HashMap;

public class Classroom {
    private Student[] students;

    // Constructors
    public Classroom(){
        this(30);
    }
    public Classroom(Student[] students){
        this.students = students;
    }
    public Classroom(int maxNumberOfStudents){
        students = new Student[maxNumberOfStudents];
    }

    // Getter
    public Student[] getStudents(){
        return students;
    }

    public double getAverageExamScore(){
        double sum = 0.0;
        for(Student s : students){
            sum += s.getAverageExamScore();
        }
        return sum / students.length;
    }

    // Note: not sure if this is right but we'll see i guess
    public void addStudent(Student student){
        int i;
        for(i = 0; i < students.length; i++){
            if(students[i] == null){
                break;
            }
        }
        students[i] = student;
    }

    public void removeStudent(String firstName, String lastName){
        int i;
        for(i = 0; i < students.length; i++){
            Student s = students[i];
            if(s == null){
                break;
            }
            if(s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)){
                break;
            }
        }
        // Just in case we reach the null
        if(students[i] == null){
            return;
        }
        // Now we remove and shift stuff around
        while(i < students.length - 1){
            students[i] = students[i + 1];
        }
    }

    public Student[] getStudentsByScore(){
        ArrayList<Student> sortingStudents = new ArrayList<>();
        // Iterate through all the students
        for(Student s : students){
            int idx = 0;
            double curStudentScore = s.getAverageExamScore();
            double otherStudentScore;
            // Iterate through the ArrayList
            while(idx < sortingStudents.size()){
                otherStudentScore = sortingStudents.get(idx).getAverageExamScore();
                // Compare the scores
                if(curStudentScore > otherStudentScore){
                    break;
                } else if (curStudentScore == otherStudentScore) {
                    // same score means compare last name first
                    if(s.getLastName().compareTo(sortingStudents.get(idx).getLastName()) > 0){
                        break;
                    }
                    // same score and same LAST NAME means compare first name
                    else if(s.getLastName().compareTo(sortingStudents.get(idx).getLastName()) == 0){
                        if(s.getFirstName().compareTo(sortingStudents.get(idx).getFirstName()) > 0){
                            break;
                        }
                    }
                }
                // incrementing to prevent infinite while loop
                idx++;
            }
            sortingStudents.add(idx, s);
        }
        return sortingStudents.toArray(new Student[students.length]);
    }

    // HAVEN'T IMPLEMENTED YET
    public HashMap<Student, Character> getGradeBook(){
        HashMap<Student, Character> book = new HashMap<>();

        Student[] studentsByScore = getStudentsByScore();
        for(int i = 0; i < students.length; i++) {
            double yourPercentile = (i + 1) / students.length * 100.0;

            if (yourPercentile >= 90) {
                // you got an A
                book.put(studentsByScore[i], 'A');
            }
            else if (yourPercentile >= 71) {
                // you got a B
                book.put(studentsByScore[i], 'B');
            }
            else if (yourPercentile >= 50) {
                // you got a C
                book.put(studentsByScore[i], 'C');
            }
            else if (yourPercentile >= 10) {
                // you got a D
                book.put(studentsByScore[i], 'D');
            }
            else {
                // you got an F
                book.put(studentsByScore[i], 'F');
            }
        }

        return book;
    }
}

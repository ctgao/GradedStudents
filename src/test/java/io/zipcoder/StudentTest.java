package io.zipcoder;

import org.junit.Test;
import org.junit.Assert;

public class StudentTest {
    // Testing Constructors
    @Test
    public void testNullConstructor() {
        // Given: expected values of created Student
        String expectedFirstName = "First Name";
        String expectedLastName = "Last Name";
        String noTestScores = "Exam Scores:\n";

        // When: create a Student using nullary constructor
        Student s = new Student();

        // Then: Student is created omg
        Assert.assertEquals(expectedFirstName, s.getFirstName());
        Assert.assertEquals(expectedLastName, s.getLastName());
        Assert.assertEquals(noTestScores, s.getExamScores());
    }
    @Test
    public void testConstructor() {
        // Given: expected values of created Student
        String expectedFirstName = "Hello";
        String expectedLastName = "World";
        String noTestScores = "Exam Scores:\n";

        // When: create a Student using constructor
        Student s = new Student(expectedFirstName, expectedLastName, new Double[0]);

        // Then: Student is created omg
        Assert.assertEquals(expectedFirstName, s.getFirstName());
        Assert.assertEquals(expectedLastName, s.getLastName());
        Assert.assertEquals(noTestScores, s.getExamScores());
    }
    @Test
    public void testConstructor2() {
        // Given: expected values of created Student
        String expectedFirstName = "Hello";
        String expectedLastName = "World";
        String expectedTestScores = "Exam Scores:\n\tExam 1 -> 9.10\n";

        // When: create a Student using constructor
        Student s = new Student(expectedFirstName, expectedLastName, new Double[]{9.1});

        // Then: Student is created omg
        Assert.assertEquals(expectedFirstName, s.getFirstName());
        Assert.assertEquals(expectedLastName, s.getLastName());
        Assert.assertEquals(expectedTestScores, s.getExamScores());
    }

    // Testing Setters and Getters
    @Test
    public void testSetFirstName() {
        // Given: expected first name and regular Student
        String expectedFirstName = "Hello";
        Student s = new Student();

        // When: set first name of Student
        s.setFirstName(expectedFirstName);

        // Then: does it work?
        Assert.assertEquals(expectedFirstName, s.getFirstName());
    }
    @Test
    public void testGetFirstName() {
        // Given: expected first name and regular Student
        String expectedFirstName = "First Name";
        Student s = new Student();

        // When: get name of Student
        String actualFirstName = s.getFirstName();

        // Then: it works!
        Assert.assertEquals(expectedFirstName, actualFirstName);
    }
    @Test
    public void testSetLastName() {
        // Given: expected last name and regular Student
        String expectedLastName = "World";
        Student s = new Student();

        // When: set last name of Student
        s.setLastName(expectedLastName);

        // Then: do you work?
        Assert.assertEquals(expectedLastName, s.getFirstName());
    }
    @Test
    public void testGetLastName() {
        // Given: expected last name and regular Student
        String expectedLastName = "Last Name";
        Student s = new Student();

        // When: get last name of Student
        String actualLastName = s.getLastName();

        // Then: they are equal?
        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void testGetExamScores() {
        // Given: no expected exam scores and regular Student
        String noTestScores = "Exam Scores:\n";
        Student s = new Student();

        // When: get exam scores of Student
        String actualExamScores = s.getExamScores();

        // Then: got no scores but the strings equal!
        Assert.assertEquals(noTestScores, actualExamScores);
    }
    @Test
    public void testGetExamScores1() {
        // Given: no expected exam scores and regular Student
        String noTestScores = "Exam Scores:\n";
        Student s = new Student("", "", new Double[0]);

        // When: get exam scores of Student
        String actualExamScores = s.getExamScores();

        // Then: no scores but should be equal
        Assert.assertEquals(noTestScores, actualExamScores);
    }
    @Test
    public void testGetExamScores2() {
        // Given: expected exam scores and regular Student
        String expectedTestScores = "Exam Scores:\n\tExam 1 -> 9.01\n\tExam 2 -> 13.00\n";
        Student s = new Student("", "", new Double[]{9.01, 13.0});

        // When: get exam scores of Student
        String actualExamScores = s.getExamScores();

        // Then: you got some scores?
        Assert.assertEquals(expectedTestScores, actualExamScores);
    }

    @Test
    public void testGetNumberOfExamsTaken() {
        // Given: no exams and regular Student
        int expectedNumberOfExams = 0;
        Student s = new Student();

        // When: get number of exams of Student
        int actualNumberOfExams = s.getNumberOfExamsTaken();

        // Then: should be empty!
        Assert.assertEquals(expectedNumberOfExams, actualNumberOfExams);
    }
    @Test
    public void testGetNumberOfExamsTaken1() {
        // Given: no exams and regular Student
        int expectedNumberOfExams = 2;
        Student s = new Student("", "", new Double[]{9.01, 13.0});

        // When: get number of exams of Student
        int actualNumberOfExams = s.getNumberOfExamsTaken();

        // Then: should be same as expected!
        Assert.assertEquals(expectedNumberOfExams, actualNumberOfExams);
    }

    @Test
    public void testAddExamScore() {
        // Given: expected single exam score and regular Student
        Student s = new Student();
        String expectedTestScores = "Exam Scores:\n\tExam 1 -> 9.10\n";

        // When: add an exam!
        s.addExamScore(9.1);

        // Then: should be same as expected!
        Assert.assertEquals(expectedTestScores, s.getExamScores());
    }
    @Test
    public void testAddExamScore1() {
        // Given: expected exam scores and regular Student
        Student s = new Student("", "", new Double[]{9.01});
        String expectedTestScores = "Exam Scores:\n\tExam 1 -> 9.01\n\tExam 2 -> 13.00\n";

        // When: add an exam!
        s.addExamScore(13.0);

        // Then: should be same as expected!
        Assert.assertEquals(expectedTestScores, s.getExamScores());
    }

    @Test
    public void setExamScore() {
        // Given: expected test scores and regular Student
        Student s = new Student("", "", new Double[]{9.01, 1.0});
        String expectedTestScores = "Exam Scores:\n\tExam 1 -> 9.01\n\tExam 2 -> 13.00\n";

        // When: change an exam grade
        s.setExamScore(2, 13.0);

        // Then: should be same as expected!
        Assert.assertEquals(expectedTestScores, s.getExamScores());
    }

    @Test
    public void getAverageExamScore() {
    }

    @Test
    public void toSting() {
    }
}
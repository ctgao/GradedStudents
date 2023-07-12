package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import javax.print.attribute.HashAttributeSet;
import java.util.HashMap;

public class ClassroomTest {
    // Testing Constructors
    @Test
    public void testNullConstructor() {
        // Given: expected classroom
        Student[] expectedStudents = new Student[30];

        // When: create a Classroom using nullary constructor
        Classroom c = new Classroom();

        // Then: Classroom exists WOAH
        Assert.assertEquals(expectedStudents, c.getStudents());
    }
    @Test
    public void testConstructor() {
        // Given: expected classroom of one kiddo
        Student[] expectedStudents = new Student[]{new Student()};

        // When: create a Classroom using constructor
        Classroom c = new Classroom(expectedStudents);

        // Then: Classroom got a kiddo
        Assert.assertEquals(expectedStudents, c.getStudents());
    }
    @Test
    public void testConstructor2() {
        // Given: expected classroom
        int expectedSize = 17;
        Student[] expectedStudents = new Student[expectedSize];

        // When: create a Classroom using constructor
        Classroom c = new Classroom(expectedSize);

        // Then: Classroom exists with lotsa empty spaces
        Assert.assertEquals(expectedStudents, c.getStudents());
    }

    // Testing Getters and Setters
    @Test
    public void testGetStudents() {
        // Given: expected Student Array and a classroom
        Student[] expectedStudents = new Student[30];
        Classroom c = new Classroom();

        // When: getting students
        Student[] actualStudents = c.getStudents();

        // Then: equivalent arrays!
        Assert.assertEquals(expectedStudents, actualStudents);
    }
    @Test
    public void testGetStudents1() {
        // Given: expected Student Array and a classroom
        Student[] expectedStudents = new Student[]{new Student(), new Student()};
        Classroom c = new Classroom(expectedStudents);

        // When: getting students
        Student[] actualStudents = c.getStudents();

        // Then: equivalent arrays!
        Assert.assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void testGetAverageExamScore() {
        // Given: expected average exam score and a classroom of students
        Student s1 = new Student("one", "one", new Double[]{100.0});
        Student s2 = new Student("two", "two", new Double[]{50.0});
        Classroom c = new Classroom(new Student[]{s1, s2});
        double expectedAvgScore = 75.0;

        // When: getting avg score of all students
        double actualAvgScore = c.getAverageExamScore();

        // Then: average exam score is as expected
        Assert.assertEquals(expectedAvgScore, actualAvgScore, 0.01);
    }

    @Test
    public void testAddStudent() {
        // Given: expected Student Array and a classroom
        Classroom c = new Classroom();
        Student expectedStudent = new Student();
        Student[] expectedArray = new Student[30];
        expectedArray[0] = expectedStudent;

        // When: adding said student
        c.addStudent(expectedStudent);

        // Then: equivalent arrays!
        Assert.assertEquals(expectedArray, c.getStudents());
    }
    @Test
    public void testAddStudent1() {
        // Given: expected Student Array and a classroom and the extra student
        Student s2 = new Student("Hello", "World", new Double[]{});
        Student[] expectedStudents = new Student[]{new Student(), null};
        Classroom c = new Classroom(expectedStudents);

        // When: adding said student
        c.addStudent(s2);
        expectedStudents[1] = s2;

        // Then: equivalent arrays!
        Assert.assertEquals(expectedStudents, c.getStudents());
    }

    @Test
    public void testRemoveStudent() {
        // Given: expected Student Array and a classroom and the extra student
        Student s1 = new Student();
        Student s2 = new Student("Hello", "World", new Double[]{});
        Classroom c = new Classroom(new Student[]{new Student(), s2});
        Student[] expectedStudents = new Student[]{s2, null};

        // When: removing said student s1
        c.removeStudent(s1.getFirstName(), s1.getLastName());

        // Then: equivalent arrays!
        Assert.assertEquals(expectedStudents, c.getStudents());
    }
    @Test
    public void testRemoveStudent1() {
        // Given: expected Student Array and a classroom and the extra student
        Student s1 = new Student();
        Student s2 = new Student("Hello", "World", new Double[]{});
        Classroom c = new Classroom(new Student[]{s1, s2});
        Student[] expectedStudents = new Student[]{s1, null};

        // When: removing said student s2
        c.removeStudent(s2.getFirstName(), s2.getLastName());

        // Then: equivalent arrays!
        Assert.assertEquals(expectedStudents, c.getStudents());
    }

    @Test
    public void testGetStudentsByScore() {
        // Given: expected Student Array and classroom
        Student s1 = new Student("one", "one", new Double[]{50.0});
        Student s2 = new Student("two", "two", new Double[]{100.0});
        Classroom c = new Classroom(new Student[]{s1, s2});
        Student[] expectedStudents = new Student[]{s2, s1};

        // When: getting students sorted by their scores
        Student[] actualStudents = c.getStudentsByScore();

        // Then: equivalent arrays!
        Assert.assertEquals(expectedStudents, actualStudents);
    }
    @Test
    public void testGetStudentsByScore1() {
        // Given: expected Student Array and classroom
        Student s1 = new Student("one", "owo", new Double[]{100.0});
        Student s2 = new Student("two", "one", new Double[]{100.0});
        Classroom c = new Classroom(new Student[]{s1, s2});
        Student[] expectedStudents = new Student[]{s2, s1};

        // When: getting students sorted by their scores
        Student[] actualStudents = c.getStudentsByScore();

        // Then: equivalent arrays!
        Assert.assertEquals(expectedStudents, actualStudents);
    }
    @Test
    public void testGetStudentsByScore2() {
        // Given: expected Student Array and classroom
        Student s1 = new Student("owo", "one", new Double[]{100.0});
        Student s2 = new Student("one", "one", new Double[]{100.0});
        Classroom c = new Classroom(new Student[]{s1, s2});
        Student[] expectedStudents = new Student[]{s2, s1};

        // When: getting students sorted by their scores
        Student[] actualStudents = c.getStudentsByScore();

        // Then: equivalent arrays!
        Assert.assertEquals(expectedStudents, actualStudents);
    }

    @Test
    public void getGradeBook() {
        // Given: some students
        Student s1 = new Student("one", "one", new Double[]{90.0});
        Student s2 = new Student("two", "two", new Double[]{18.0});
        Student s3 = new Student("three", "three", new Double[]{27.0});
        Student s4 = new Student("four", "four", new Double[]{80.0});
        Student s5 = new Student("five", "five", new Double[]{69.0});
        Student s6 = new Student("six", "six", new Double[]{13.0});
        Student s7 = new Student("seven", "seven", new Double[]{100.0});
        Student s8 = new Student("eight", "eight", new Double[]{59.0});

        // Given: their classroom
        Classroom c = new Classroom(new Student[]{s1, s2, s3, s4, s5, s6, s7, s8});

        // Given: expected HashMap of the grade book
        HashMap<Student, Character> expectedMapping = new HashMap<>();
        expectedMapping.put(s1, 'B');
        expectedMapping.put(s2, 'D');
        expectedMapping.put(s3, 'D');
        expectedMapping.put(s4, 'B');
        expectedMapping.put(s5, 'C');
        expectedMapping.put(s6, 'F');
        expectedMapping.put(s7, 'A');
        expectedMapping.put(s8, 'D');

        // When: getting the mappings
        HashMap<Student, Character> actualMapping = c.getGradeBook();

        // Then: equivalent maps?
        Assert.assertEquals(expectedMapping, actualMapping);
    }
}

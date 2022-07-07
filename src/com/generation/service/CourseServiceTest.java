package com.generation.service;

import org.junit.Before;
import org.junit.jupiter.api.*;
import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.generation.model.Student;

public class CourseServiceTest {
    private CourseService courseService = new CourseService();
    private Student student;

    @Before
    public void setup() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        student = new Student("123", "Testman", "test@test.com", formatter.parse("01/01/2000"));
    }

    @Test
    void testApproveStudent() {
        courseService.enrollStudent("INTRO-CS-1", student);
        courseService.approveStudent("INTRO-CS-1", student);
        assertFalse(courseService.showEnrolledStudents("INTRO-CS-1").contains(student));
    }

    @Test
    void testEnrollStudent() {
        courseService.enrollStudent("INTRO-CS-1", student);
        assertTrue(courseService.showEnrolledStudents("INTRO-CS-1").contains(student));
    }
}

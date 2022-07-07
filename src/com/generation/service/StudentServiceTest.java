package com.generation.service;

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.generation.model.Student;
import com.generation.model.Course;

public class StudentServiceTest {
    private CourseService courseService = new CourseService();
    private StudentService studentService = new StudentService();
    Course course = courseService.getCourse("INTRO-CS-1");
    DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    @Test
    void testSubscribeStudent() throws ParseException {
        Student student =
                new Student("123", "Testman", "test@test.com", formatter.parse("01/01/2000"));
        studentService.subscribeStudent(student);
        assertEquals(student, studentService.findStudent("123"));
    }

    @Test
    void isSubscribed() throws ParseException {
        Student student2 =
                new Student("456", "Testman2", "test2@test.com", formatter.parse("02/02/2000"));
        studentService.subscribeStudent(student2);
        assertTrue(studentService.isSubscribed("456"));
    }
}

package com.generation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Person implements Evaluation {
    private double average;

    private final List<Course> courses = new ArrayList<>();

    private final Map<String, Course> approvedCourses = new HashMap<>();

    public Student(String id, String name, String email, Date birthDate) {
        super(id, name, email, birthDate);
    }

    public void enrollToCourse(Course course) {
        courses.add(course);
    }

    public void unenrollFromCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
        }
    }

    public void registerApprovedCourse(Course course) {
        approvedCourses.put(course.getCode(), course);
    }

    public boolean isCourseApproved(String courseCode) {
        return approvedCourses.containsKey(courseCode);
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve.
    public List<Course> findPassedCourses(Course course) {
        // TODO implement this method
        return null;
    }

    // inefficient
    public boolean isAttendingCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getAverage() {
        return average;
    }

    @Override
    public List<Course> getApprovedCourses() {
        return (List<Course>) approvedCourses.values();
    }

    @Override
    public String toString() {
        return "Student {" + super.toString() + "}";
    }
}

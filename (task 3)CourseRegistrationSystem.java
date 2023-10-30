package Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

	public int getRegisteredStudents() {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (registeredCourses.size() < 5) { // Assuming a student can register for up to 5 courses
            registeredCourses.add(course);
            System.out.println(name + " registered for " + course.getTitle());
        } else {
            System.out.println(name + " has reached the maximum number of registered courses.");
        }
    }

    public void removeCourse(Course course) {
        registeredCourses.remove(course);
        System.out.println(name + " removed " + course.getTitle());
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Course course1 = new Course("CS101", "Introduction to Computer Science", "Basic CS concepts", 30, "Mon/Wed 9:00 AM");
        Course course2 = new Course("MATH201", "Calculus I", "Fundamental calculus principles", 25, "Tue/Thu 2:00 PM");
        Course course3 = new Course("ENG101", "English Composition", "Writing and communication skills", 35, "Mon/Wed/Fri 11:00 AM");

        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");

        student1.registerCourse(course1);
        student1.registerCourse(course2);
        student1.registerCourse(course3);

        student2.registerCourse(course2);
        student2.registerCourse(course3);

        student1.removeCourse(course2);

        displayCourseDetails(course1);
        displayCourseDetails(course2);
        displayCourseDetails(course3);
    }

    public static void displayCourseDetails(Course course) {
        System.out.println("Course Code: " + course.getCode());
        System.out.println("Course Title: " + course.getTitle());
        System.out.println("Description: " + course.getDescription());
        System.out.println("Capacity: " + course.getCapacity());
        System.out.println("Schedule: " + course.getSchedule());
        System.out.println("Available Slots: " + (course.getCapacity() - course.getRegisteredStudents()));
        System.out.println();
    }
}

package dao;

import java.util.List;
import java.util.Map;

import model.Course;
import model.Registration;
import model.Student;

public interface StudentDao {

	String addNewStudent(Student student);
	void updateStudentProfile(Student student);
	//void registration(Registration registration); //whether registered or not
	Student findAStudentByRollNo(int rollNo);
	List<Student> viewAllStudents();
	String addNewCourse(Course course);
	List<Course> viewAllCourses();
	void registration(Student student, Course course);
	Map<Student,Course> viewAllRegistrations();
	Course findCourseById(int courseId);
	String registrationDb(Registration registration);
	
}

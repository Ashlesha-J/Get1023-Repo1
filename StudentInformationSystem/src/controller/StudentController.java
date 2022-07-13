package controller;

import java.util.List;
import java.util.Map;

import dao.StudentDao;
import dao.StudentDaoImplDatabase;
import exception.PhoneException;
import model.Course;
import model.Registration;
import model.Student;

public class StudentController {
	
	StudentDao dao=new StudentDaoImplDatabase();
	
	public String addNewStudent(Student student) {
		if(student.getPhoneNo().length()!=10)
		{
			try
			{
				throw new PhoneException("Invalid phone number");
			}
			catch(PhoneException e)
			{
				return e.getMessage();
			}
		}
		dao.addNewStudent(student);
		return "New student added successfully";
	}

	
	public void updateStudentProfile(Student student) {
		
	}

	
	public Student findAStudentByRollNo(int rollNo) {
	
		return dao.findAStudentByRollNo(rollNo);
	}

	
	public List<Student> viewAllStudents() {
		
		return dao.viewAllStudents();
	}

	
	public String addNewCourse(Course course) {
		
		return dao.addNewCourse(course);
	}

	
	public List<Course> viewAllCourses() {
		
		return null;
	}

	
	public void registration(Student student, Course course) {

	}
	
	public String registrationDb(Registration registration) {
		String message="";
		Student student=dao.findAStudentByRollNo(registration.getRollNo());
		Course course=dao.findCourseById(registration.getCourseId());
		
			if(student!=null)
			{
				if(course!=null)
				{
					if(student.getQualification().equals(course.getEligibilty()))
					{
						message=dao.registrationDb(registration);
					}
					else
					{
						message="you not eligible";
					}
				}
			}
		else
		{
			message="Student does not exist";
		}
			return message;
	}
	

	
	public Map<Student, Course> viewAllRegistrations() {
		
		return null;
	}

	
	public Course findCourseById(int courseId) {
		
		return null;
	}


}

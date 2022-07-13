package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import model.Course;
import model.Registration;
import model.Student;

public class StudentDaoImplInMemory implements StudentDao {
	
	public static List<Student> students = new ArrayList<Student>();
	public static Set<Course> courses = new HashSet<Course>();
	public static Map<Student,Course> registration=new HashMap<Student,Course>();
	@Override
	public String addNewStudent(Student student) {
		// TODO Auto-generated method stub
		students.add(student);
		return "";
		
	}

	@Override
	public void updateStudentProfile(Student student) {
		// TODO Auto-generated method stub
		Student student1=findAStudentByRollNo(student.getRollNo());
		int index;
		index=students.indexOf(student1);
		students.set(index, student);
		
	}

	@Override
	public void registration(Student student,Course course) {
		
		registration.put(student,course);
	}
	@Override
	public Map<Student,Course> viewAllRegistrations()
	{
		return registration;
	}

	@Override
	public Student findAStudentByRollNo(int rollNo) {
		return students.parallelStream().filter(st->st.getRollNo()==rollNo).findFirst().orElse(null);
	}

	@Override
	public List<Student> viewAllStudents() {
		// TODO Auto-generated method stub
		return students.parallelStream().collect(Collectors.toList());
	}

	@Override
	public String addNewCourse(Course course) {
		// TODO Auto-generated method stub
		courses.add(course);
		return "";
	}
	public Course findCourseById(int courseId)
	{
		return courses.parallelStream().filter(c->c.getCourseId()==courseId).findAny().orElse(null);
	}

	@Override
	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return courses.parallelStream().collect(Collectors.toList());

	}

	@Override
	public String registrationDb(Registration registration) {
		// TODO Auto-generated method stub
		return "";
	}

}

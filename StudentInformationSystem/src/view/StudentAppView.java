package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import controller.StudentController;
import model.Course;
import model.Qualification;
import model.Registration;
import model.Student;

public class StudentAppView {

	public static void main(String[] args)
	{
		StudentController controller=new StudentController();
		Scanner sc=new Scanner(System.in);
		while(true){
		System.out.println("1. Student 2.Admin 3.Exit");
		int userType=sc.nextInt();
		
		if(userType==1)
		{
			String choice="y";
			do
			{
			System.out.println("1.Sign Up\n 2.Update Phone Number\n 3.view all courses\n 4.Register for course\n 5.Sign Out");
			int option=sc.nextInt();
			
			switch(option)
			{
			case 1: 
				System.out.println("Enter name,date of birth(dd/mm/yyyy),phoneno,email,address");
				String name=sc.next();
				
				String dateOfBirth=sc.next(); //"04/12/2000"
				DateTimeFormatter sdf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dob=LocalDate.parse(dateOfBirth,sdf);//converted string date to local date
			    
				String phoneNumber	= sc.next();
				String email=sc.next();
				String address=sc.next();
				
				System.out.println("1.Master 2.Graduate 3.Intermediate 4.Matric");
				int q=sc.nextInt();
				Qualification qualification = null;
				if(q==1) qualification=Qualification.Master;
				if(q==2) qualification=Qualification.Graduate;
				if(q==3) qualification=Qualification.Intermidiate;
				if(q==4) qualification=Qualification.Matric;
				
				Student student = new Student(name,dob,qualification,phoneNumber,email,address);
				
				String message=controller.addNewStudent(student);
				System.out.println(message);
				break;
			case 4:
				System.out.println("enter rollno and courseid");
				int rollNo=sc.nextInt();
				int courseId=sc.nextInt();
				String regDateString=sc.next();
				DateTimeFormatter form=DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate regDate=LocalDate.parse(regDateString,form);
				Registration registration=new Registration(regDate, courseId, rollNo);
				message=controller.registrationDb(registration);
				System.out.println(message);
				break;
				
			}
				
			System.out.println("continue?(y/n)");
			choice=sc.next();
			}
			while(choice.equalsIgnoreCase("y"));	
		}
				
		else if(userType==2)
		{
			System.out.println("1.view all users\n 2.Find student \n 3.Add course");
			int option = sc.nextInt();
			switch(option)
			{
			case 1:
				List<Student> students=controller.viewAllStudents();
				Iterator<Student> iterator=students.iterator();
				while(iterator.hasNext())
				{
					Student st=iterator.next();
					System.out.println(st.getRollNo()+" "+st.getName()+" "+st.getEmail()+" "+st.getPhoneNo());
				}
				break;
			case 2:
				System.out.println("Enter rollno");
				int rollNo=sc.nextInt();
				Student st=controller.findAStudentByRollNo(rollNo);
				if(st!=null)
				{
					System.out.println(st.getName());
				}
				else
				{
					System.out.println("Not found roll no");
				}
				break;
			case 3:
				System.out.println("Enter course name,duration,fee:");
				String courseName=sc.next();
				int duration=sc.nextInt();
				double fee=sc.nextDouble();
				System.out.println("1.Master 2.Graduate 3.Intermediate 4.Matric");
				int q=sc.nextInt();
				Qualification eligibility = null;
				if(q==1) eligibility=Qualification.Master;
				if(q==2) eligibility=Qualification.Graduate;
				if(q==3) eligibility=Qualification.Intermidiate;
				if(q==4) eligibility=Qualification.Matric;
				
				Course course=new Course(courseName,duration,fee,eligibility);
				String message=controller.addNewCourse(course);
				System.out.println(message);
				break;
				
			
			}
		}
		
		else
		{
			//System.out.println("Invalid choice");
			System.exit(0);
		}
	
	
	
	
	
	
	
	
	
		}
	
	}
	
}

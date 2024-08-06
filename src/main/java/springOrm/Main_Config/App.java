package springOrm.Main_Config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hibernateTemplate.DAO.StudentDAO;
import ormHibernate.Entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springOrm/Main_Config/spring_config.xml");
		StudentDAO studentDao = context.getBean("studentDAO", StudentDAO.class);
		BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
		
		boolean start = true;

		while (start) {

			System.out.println("PRESS 1 : FOR Inserting Student Details");
			System.out.println("PRESS 2 : FOR Sudent Details");
			System.out.println("PRESS 3 : FOR All Sudent Details");
			System.out.println("PRESS 4 : FOR Sudent Details Delete");
			System.out.println("PRESS 5 : FOR Sudent Details Update");
			System.out.println("PRESS 6 : FOR Exit");

			try {
				int input = Integer.parseInt(bR.readLine());

				if (input < 1 || input > 6) {
					throw new IllegalArgumentException("Input must be between 1 and 6." + "\n");
				}

				switch (input) {

//				Insert 
				case 1:
					System.out.println("Enter the Student Details:");
					
					System.out.println("Enter Student ID");
					int id = Integer.parseInt(bR.readLine());
					
					System.out.println("Enter Student Name");
					String stdName = bR.readLine();
					
					System.out.println("Enter Student Stream");
					String stdStream = bR.readLine();
					
					Student std = new Student(id, stdName, stdStream);
					studentDao.insertStudent(std);
					
					System.out.println("Data Successfully Added " + "\n");
					break;

// 				Get 
				case 2:
					System.out.println("Enter Student ID");
					
					int id1 = Integer.parseInt(bR.readLine());
					Student stdData = studentDao.getStudent(id1);
					
					System.out.println("Student ID : " + stdData.getStudent_Id());
					System.out.println("Student Name : " + stdData.getStudent_Name());
					System.out.println("Student Stream : " + stdData.getStudent_Stream() + "\n");
					break;

//				Get All	
				case 3:
					List<Student> allStudents = studentDao.getAllStudents();
					
					for (Student s : allStudents) {
						System.out.println("Student ID : " + s.getStudent_Id());
						System.out.println("Student Name : " + s.getStudent_Name());
						System.out.println("Student Stream : " + s.getStudent_Stream() + "\n");
					}
					break;

//				Delete	
				case 4:
					System.out.println("Enter Student ID");
					
					int id2 = Integer.parseInt(bR.readLine());
					studentDao.deleteStudent(id2);
					
					System.out.println("Successfully Deleted" + "\n");
					break;

//				Update	
				case 5:
					System.out.println("Enter Student ID to Update Details");
					int id3 = Integer.parseInt(bR.readLine());
					
					Student student = studentDao.getStudent(id3);
					
					System.out.println("Enter New Student Name");
					String stdNameUpdate = bR.readLine();
					
					System.out.println("Enter New Student Stream");
					String stdStreamUpdate = bR.readLine();
					
					student = new Student(id3, stdNameUpdate, stdStreamUpdate);
					studentDao.updateStudent(student);
					
					System.out.println("Data Successfully Updated " + "\n");
					break;

//				Exit Application	
				case 6:
					start = false;
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number." + "\n");
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(
						"Enter a valid value between 1 to 6 for performing operaions on Student Details" + "\n");
				System.out.println(e.getMessage());
			}
		}
		System.out.println(" Thank You! ");
	}
}

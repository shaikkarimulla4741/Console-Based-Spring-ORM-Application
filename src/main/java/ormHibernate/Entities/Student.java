package ormHibernate.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
	
	@Id
	private int student_Id;
	private String student_Name;
	private String student_Stream;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int student_Id, String student_Name, String student_Stream) {
		super();
		this.student_Id = student_Id;
		this.student_Name = student_Name;
		this.student_Stream = student_Stream;
	}

	public int getStudent_Id() {
		return student_Id;
	}

	public void setStudent_Id(int student_Id) {
		this.student_Id = student_Id;
	}

	public String getStudent_Name() {
		return student_Name;
	}

	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}

	public String getStudent_Stream() {
		return student_Stream;
	}

	public void setStudent_Stream(String student_Stream) {
		this.student_Stream = student_Stream;
	}
	
}

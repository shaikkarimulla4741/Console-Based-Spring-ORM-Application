package hibernateTemplate.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import ormHibernate.Entities.Student;

public class StudentDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insertStudent(Student student) {
		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	@Transactional
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		if (student == null) {
			throw new IllegalArgumentException("No Student Data Available" + "\n");
		}
		return student;
	}

//	@Transactional
	public List<Student> getAllStudents() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		if (students.isEmpty()) {
			throw new IllegalArgumentException("No Student Data Available" + "\n");
		}
		return students;
	}

	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);

	}

	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
				
	}

}

package student.entities;

import faculty.entites.Faculty;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name = "tsu.junior.Student")
@Table(name = "STUDENTS")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "java.student.Student", table = "ID_GENERATORS", pkColumnName = "PRIMARY_KEYS", pkColumnValue = "STUDENT_ID", valueColumnName = "KEY_VALUES", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "java.student.Student")
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "E_MAIL")
	private String email;

	@ManyToOne
	@JoinColumn(name = "FACULTY_ID")
	private Faculty faculty;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

}

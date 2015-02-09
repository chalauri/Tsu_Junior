package java.student.entities;

import java.io.Serializable;
import java.project.Project;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "tsu.junior.studentProject")
@Table(name = "STUDENT_PROJECT")
public class StudentProject implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "java.student.StudentProject", table = "ID_GENERATORS", pkColumnName = "PRIMARY_KEYS", pkColumnValue = "STUDENT_PROJECT_ID", valueColumnName = "KEY_VALUES", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "java.student.StudentProject")
	@Column(name = "ID")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "PROJECT_ID")
	private Project project;

	@Temporal(TemporalType.DATE)
	@Column(name = "PROJECT_START_DATE")
	private Date projectStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "PROJECT_END_DATE")
	private Date projectEndDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getProjectStartDate() {
		return projectStartDate;
	}

	public void setProjectStartDate(Date projectStartDate) {
		this.projectStartDate = projectStartDate;
	}

	public Date getProjectEndDate() {
		return projectEndDate;
	}

	public void setProjectEndDate(Date projectEndDate) {
		this.projectEndDate = projectEndDate;
	}

}

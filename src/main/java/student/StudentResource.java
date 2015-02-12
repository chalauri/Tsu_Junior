package student;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import student.entities.Student;
import student.entities.StudentProject;
import utils.Descriptor;

@Path("/students")
public class StudentResource {

	StudentBean studentBean = new StudentBean();

	@POST
	@Path("saveStudent")
	@Consumes("application/json")
	@Produces("application/json")
	public Descriptor saveStudent(Student student) {

		if (!isValidEmail(student.getEmail())) {

			return Descriptor.invalidDescriptor("შეიყვანეთ ელ. ფოსტა სწორად");
		}

		return studentBean.saveStudent(student);
	}

	private Boolean isValidEmail(String email) {

		int indexOfAt = email.indexOf('@');

		if (indexOfAt == -1) {

			return false;
		}

		int indexOfLastDot = email.lastIndexOf('.');

		if (indexOfAt + 2 >= indexOfLastDot
				|| indexOfLastDot + 2 >= email.length()) {

			return false;
		}

		return true;
	}

	@GET
	@Path("getStudents")
	@Produces("application/json; charset=UTF-8")
	public List<Student> getStudents() {

		return studentBean.getStudents();
	}

	@POST
	@Path("registerStudentOnProject")
	@Consumes("application/json")
	@Produces("application/json")
	public Descriptor registerStudentOnProject(StudentProject studentOnProject) {

		return studentBean.registerStudentOnProject(studentOnProject);
	}

	@GET
	@Path("getStudentsOnProjects")
	@Produces("application/json; charset=UTF-8")
	public List<StudentProject> getStudentsOnProjects() {

		return studentBean.getStudentsOnProjects();
	}

	@GET
	@Path("getStudentsOnProject")
	@Produces("application/json; charset=UTF-8")
	public List<StudentProject> getStudentsOnProject(
			@QueryParam("projectId") Integer projectId) {

		return studentBean.getStudentsOfProject(projectId);
	}

	@GET
	@Path("getProjectsOfStudent")
	@Produces("application/json; charset=UTF-8")
	public List<StudentProject> getProjectsOfStudent(
			@QueryParam("studentId") Integer studentId) {

		return studentBean.getProjectsOfStudent(studentId);
	}

}

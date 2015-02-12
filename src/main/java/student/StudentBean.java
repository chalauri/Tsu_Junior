package student;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import student.entities.Student;
import student.entities.StudentProject;
import utils.Descriptor;

public class StudentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager em = Persistence.createEntityManagerFactory("tsu_junior")
			.createEntityManager();

	public Descriptor saveStudent(Student student) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(student);
		tx.commit();

		return Descriptor.validDescriptor("სტუდენტი წარმატებით დაემატა");
	}

	public List<Student> getStudents() {

		return em.createQuery("from tsu.junior.Student e", Student.class)
				.getResultList();
	}

	public Descriptor registerStudentOnProject(StudentProject studentOnProject) {

		if (isAlreadyOnProject(studentOnProject)) {

			return Descriptor
					.invalidDescriptor("სტუდენტი უკვე არის დარეგისტრირებული აღნიშნულ პროექტზე");
		}

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(studentOnProject);
		tx.commit();

		return Descriptor
				.validDescriptor("სტუდენტი პროექტზე  წარმატებით დარეგისტრირდა");
	}

	private Boolean isAlreadyOnProject(StudentProject stOnProject) {

		Long count = em
				.createQuery(
						"select count (e) from tsu.junior.studentProject e where e.project.id =:projectId and e.student.id =:studentId and e.projectStartDate =:start and e.projectEndDate =:end",
						Long.class)
				.setParameter("projectId", stOnProject.getProject().getId())
				.setParameter("studentId", stOnProject.getStudent().getId())
				.setParameter("start", stOnProject.getProjectStartDate())
				.setParameter("end", stOnProject.getProjectEndDate())
				.getSingleResult();

		return count > 0;
	}

	public List<StudentProject> getStudentsOnProjects() {

		return em.createQuery("from tsu.junior.studentProject",
				StudentProject.class).getResultList();
	}

	public List<StudentProject> getStudentsOfProject(Integer projectId) {

		return em
				.createQuery(
						"from tsu.junior.studentProject e where e.project.id =:projectId",
						StudentProject.class)
				.setParameter("projectId", projectId).getResultList();
	}
	
	public List<StudentProject> getProjectsOfStudent(Integer studentId) {

		return em
				.createQuery(
						"from tsu.junior.studentProject e where e.student.id =:studentId",
						StudentProject.class)
				.setParameter("studentId", studentId).getResultList();
	}

}

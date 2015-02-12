package project;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import project.entities.Project;
import utils.Descriptor;

public class ProjectBean implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager em = Persistence.createEntityManagerFactory("tsu_junior")
			.createEntityManager();

	public Descriptor saveProject(Project project) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(project);
		tx.commit();

		return Descriptor.validDescriptor("პროექტი წარმატებით დაემატა");
	}

	public List<Project> getProjects() {

		return em.createQuery("from tsu.junior.project", Project.class)
				.getResultList();
	}
}

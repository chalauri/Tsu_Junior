package faculty;

import faculty.entites.Faculty;

import java.io.Serializable;
import java.util.List;

import utils.Descriptor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FacultyBean implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager em = Persistence.createEntityManagerFactory("tsu_junior")
			.createEntityManager();

	public Descriptor saveFaculty(Faculty faculty) {

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(faculty);
		tx.commit();

		return Descriptor.validDescriptor("ფაკულტეტი წარმატებით დაემატა");
	}

	public List<Faculty> getFaculties() {

		return em.createQuery("from tsu.junior.Faculty e", Faculty.class)
				.getResultList();
	}
}

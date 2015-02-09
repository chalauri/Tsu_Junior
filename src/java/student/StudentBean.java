package java.student;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class StudentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager em = Persistence.createEntityManagerFactory("tsu_junior")
			.createEntityManager();

}

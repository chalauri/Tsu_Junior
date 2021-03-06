package project.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity(name = "tsu.junior.project")
@Table(name = "PROJECTS")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "java.project.Project", table = "ID_GENERATORS", pkColumnName = "PRIMARY_KEYS", pkColumnValue = "PROJECT_ID", valueColumnName = "KEY_VALUES", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "java.project.Project")
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

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

}

package project;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import project.entities.Project;
import utils.Descriptor;

@Path("/projects")
public class ProjectResource {

	ProjectBean projectBean = new ProjectBean();

	@POST
	@Path("/saveProject")
	@Consumes("application/json")
	@Produces("application/json")
	public Descriptor saveProject(Project project) {

		return projectBean.saveProject(project);
	}

	@GET
	@Path("/getProjects")
	@Produces("application/json; charset=UTF-8")
	public List<Project> getProjects() {

		return projectBean.getProjects();
	}
}

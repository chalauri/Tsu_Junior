package faculty;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import utils.Descriptor;
import faculty.entites.Faculty;

@Path("/faculty")
public class FacultyResource {

	FacultyBean bean = new FacultyBean();

	@Path("/saveFaculty")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Descriptor saveFaculty(Faculty faculty) {

		return bean.saveFaculty(faculty);
	}

	@Path("getFaculties")
	@GET
	@Produces("application/json; charset=UTF-8")
	public List<Faculty> getFaculties(){
		
		return bean.getFaculties();
	}
	
}

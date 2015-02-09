package java.faculty.entites;

import java.faculty.FacultyBean;
import java.utils.Descriptor;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
	
	@Path("/test")
	@GET
	@Produces("text/plain")
	public String get(){
		
		return "GIGA";
	}
}

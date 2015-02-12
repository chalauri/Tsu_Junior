package utils;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.Provider;

@ApplicationPath("/tsu")
@Provider
public class AppConfig extends Application {

	private static final Set<Object> emptyObjectSet = Collections.emptySet();
	private static final Set<Class<?>> emptyClassSet = Collections.emptySet();

	public Set<Class<?>> getClasses() {
	//	emptyClassSet.add(FacultyResource.class);
		return emptyClassSet;
	}

	public Set<Object> getSingletons() {
		return emptyObjectSet;
	}

}
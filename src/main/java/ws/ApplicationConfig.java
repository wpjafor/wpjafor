package ws;

import java.util.Set;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;

@javax.ws.rs.ApplicationPath("a")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourceClasses(resources);
		//resources.add(com.sun.jersey.api.json.POJOMappingFeature.class);
        //we could also use this:
        //resources.add(com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider.class);
        
        //instead let's do it manually:
       
        //==> we could also choose packages, see below getProperties()
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(ws.DemoRestController.class);
		//resources.add(MultiPartFeature.class);
        //resources.add(org.glassfish.jersey.moxy.json.MoxyJsonFeature.class);
        
        //Configure Moxy behavior
       // resources.add(JsonMoxyConfigurationContextResolver.class);

		
	}

}

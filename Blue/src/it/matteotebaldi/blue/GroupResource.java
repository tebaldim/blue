package it.matteotebaldi.blue;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import it.matteotebaldi.blue.model.Group;

@Path("/group")
public class GroupResource {
	// This method is called if XMLis request
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Group getXML() {
		Group group = new Group();
		group.setId(0);
		group.setTag("Gruppo Zero");
		group.setType("prova");
		return group;
	}
  
  // This can be used to test the integration with the browser
  @GET
  @Produces({ MediaType.TEXT_XML })
  public Group getHTML() {
		Group group = new Group();
		group.setId(0);
		group.setTag("Gruppo Zero");
		group.setType("prova");
		return group;
  }

} 

package it.matteotebaldi.blue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;

import it.matteotebaldi.blue.model.Group;

@Path("/group")
public class GroupResource {
	private static final Logger log = Logger.getLogger(Groups.class.getName());
	private static List<Group> groupsList;
	
	// This method is called if XMLis request
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Group> getGroupsListXML() {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Group").addSort("id", Query.SortDirection.ASCENDING);
		List<Entity> entities = datastore.prepare(query).asList(FetchOptions.Builder.withDefaults());
		List<Group> groups = new ArrayList<Group>();
		for (Entity e : entities) {
			groups.add(new Group(Long.parseLong(e.getProperty("id").toString()), e.getProperty("name").toString(), e.getProperty("type").toString()));
		}
		return groups;
	}
	
	// This method is called if XMLis request
	@GET
	@Path("{groupId}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Group getGroupXML(@PathParam("groupId") String groupId) {
		List<Group> gl = getGroupsList();
		log.info("groupId: " + groupId);
		if (groupId.equals("0")) {
			return gl.get(0);
		} else if (groupId.equals("1")) {
			return gl.get(1);
		}
		return null;
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

	@POST
	public void post() {
		log.info("qui");
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_XML })
	public void postGroup(HttpServletRequest request) {
		
	}
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public void postForm(@FormParam("id") String id, @FormParam("name") String name, @FormParam("type") String type) {
		log.info("id: " + id + ", name: " + name + ", type " + type);
		// Group g = new Group(groupsList.size(), name, "prova");
		// groupsList.add(g);
		// Key blueKey = KeyFactory.createKey("Group", groupsList.size());
		Entity g = new Entity("Group");
		g.setProperty("id", Long.parseLong(id));
		g.setProperty("name", name);
		g.setProperty("type", type);
		
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(g);
	}
	
	// Temporary method for tests
	private List<Group> getGroupsList() {
		return groupsList;
	}
} 

package it.matteotebaldi.blue;

import it.matteotebaldi.blue.model.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/groups")
public class Groups {
	private static final Logger log = Logger.getLogger(Groups.class.getName());

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String listPlainTextGroups() {
		log.info("Function listPlainTextGroups");
		return "Groups list";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String listXMLGroups() {
		log.info("Function listXMLGroups");
		return "<?xml version=\"1.0\"?><groups>Groups list</groups>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String listHtmlGroups() {
		log.info("Function listHtmlGroups");
		List<Group> groupsList = getGroupsList();
		String returnString = "";
		returnString = "<html><head><title>Groups</title></head><body>";
		for (Group group : groupsList) {
			returnString += group.toString() + "<br>";
		}
		returnString += "</body></html>";
		return returnString;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listJsonGroups() {
		log.info("Function listHtmlGroups");
		return "<html> " + "<title>" + "Groups" + "</title>"
	        + "<body><h1>" + "Groups list" + "</body></h1>" + "</html> ";
	}
	
	private List<Group> getGroupsList() {
		List<Group> groupsList = new ArrayList<Group>();
		groupsList.add(new Group(0, "Casa Genova", "home network"));
		groupsList.add(new Group(1, "Casa Verona", "home network"));
		groupsList.add(new Group(2, "BMW", "vehicle"));
		groupsList.add(new Group(3, "Click", "office network"));
		return groupsList;
	}
}

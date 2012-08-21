package it.matteotebaldi.blue;

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
		return "<html> " + "<title>" + "Groups" + "</title>"
	        + "<body><h1>" + "Groups list" + "</body></h1>" + "</html> ";
	}	
}

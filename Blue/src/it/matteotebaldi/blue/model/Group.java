package it.matteotebaldi.blue.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "group")
@XmlType(propOrder = { "id", "tag", "type" })
public class Group {
	private long id;
	private String tag;
	private String type;
	
	public Group() {
		super();
		this.id = 0;
		this.tag = "";
		this.type = "";
	}
	
	public Group(long id, String tag, String type) {
		super();
		this.id = id;
		this.tag = tag;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", tag=" + tag + ", type=" + type + "]";
	}
	
	
}

package org.ufpb.projetoayla.meuProjetoWeb.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	
	private long id;
	private String userEmail;
	private Date date;
	
	public Profile(long id, String userEmail){
		this.id = id;
		this.userEmail = userEmail;
	}
	
	public Profile() {

	}
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String profileUser) {
		this.userEmail = profileUser;
	}	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public Date getCreated() {
		return this.date;
	}
}
package Notifications;

import Notifications.Observer;

public class Manager implements Observer {
	private String name;
	private String email;
	
	
	public Manager(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public void doUpdate(String message) {
		System.out.println(message);
	}
}

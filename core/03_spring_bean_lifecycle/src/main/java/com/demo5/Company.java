package com.demo5;

import java.util.Map;

public class Company {
	private String companyName;
	// project mgr ---> project
	private Map<String, Project> projects;

	// dept ---> location
	private Map<String, String> locations;

	public Map<String, String> getLocations() {
		return locations;
	}

	public void setLocations(Map<String, String> locations) {
		this.locations = locations;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Map<String, Project> getProjects() {
		return projects;
	}

	public void setProjects(Map<String, Project> projects) {
		this.projects = projects;
	}

	public void print() {
		System.out.println("company name: " + companyName);
		projects.forEach((k, v) -> System.out.println(k + " : " + v));
		locations.forEach((k, v) -> System.out.println(k + " : " + v));
	}
}

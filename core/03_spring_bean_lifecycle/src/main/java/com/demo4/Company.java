package com.demo4;

import java.util.Set;

public class Company {
	private String companyName;

	private Set<Project> projects;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public void print() {
		System.out.println("company name: " + companyName);
		projects.forEach(project -> System.out.println(project));
	}
}

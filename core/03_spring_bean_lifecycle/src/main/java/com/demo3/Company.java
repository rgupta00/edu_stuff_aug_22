package com.demo3;
import java.util.Set;
public class Company {
	private String companyName;
	
	private Set<String> projects;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	public Set<String> getProjects() {
		return projects;
	}
	public void setProjects(Set<String> projects) {
		this.projects = projects;
	}
	public void print() {
		System.out.println("company name: "+ companyName);
		projects.forEach(project-> System.out.println(project));
	}
}

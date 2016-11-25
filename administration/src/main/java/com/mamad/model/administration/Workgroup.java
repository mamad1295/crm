package com.mamad.model.administration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * this is workgroup model used also to map the entity and the table, contains only 
 * getters and setters for the parameters
 * @author Mamadou
 *
 */
@Entity
@Table (name = "WORKGROUP")
public class Workgroup {
	private int id;
	private String name;
	private String speciality;
	private String description;
	
	@Id
	@GeneratedValue //because the id in the table workgroup is autoincremented
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}

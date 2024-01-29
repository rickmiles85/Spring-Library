package com.lbg.demo.domain;

import java.util.List;

import org.springframework.http.ResponseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Library {

	@Id
	// Set Generated Value at later time
	private Integer id;
	private String name;
	private String location;

	public Library() {
		super();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Name: " + name + ", Location" + location + "]";
	}

	public List<Library> getLibaries() {
		return null;
	}

	public ResponseEntity<Library> createLibrary(Library newLibrary) {
		return null;
	}

	public ResponseEntity<Library> getLibrary(int id) {
		return null;
	}

	public boolean remove(int id) {
		return false;
	}

	public ResponseEntity<Library> update(int id, Library newLibrary) {
		return null;
	}

}
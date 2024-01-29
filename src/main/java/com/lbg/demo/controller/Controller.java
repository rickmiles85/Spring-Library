package com.lbg.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Library;
import com.lbg.demo.services.LibraryService;

@RestController

public class Controller {

	private LibraryService service;

	public Controller(LibraryService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Library> createLibrary(@RequestBody Library newLibrary) {
		return this.service.createLibrary(newLibrary);

	}

	@GetMapping("/get")
	public List<Library> getLibaries() {
		return this.service.getLibaries();

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Library> getLibrary(@PathVariable int id) {
		return this.service.getLibrary(id);
	}

	@DeleteMapping("/remove/{id}")
	public boolean remove(@PathVariable int id) {
		return this.service.remove(id);

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Library> update(@PathVariable int id, @RequestBody Library newLibrary) {
		return this.service.update(id, newLibrary);

	}

}
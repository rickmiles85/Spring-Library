package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Library;
import com.lbg.demo.repository.Repo;

@Service
public class LibraryService {

	private Repo repo;

	public LibraryService(Repo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Library> createLibrary(Library newLibrary) {
		Library created = this.repo.save(newLibrary);
		return new ResponseEntity<Library>(created, HttpStatus.CREATED);
	}

	public List<Library> getLibrary() {
		return this.repo.findAll();
	}

	public ResponseEntity<Library> getLibrary(int id) {
		Optional<Library> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Library>(HttpStatus.NOT_FOUND);
		}

		Library body = found.get();
		return ResponseEntity.ok(body);

	}

	public ResponseEntity<Library> update(int id, Library newLibrary) {
		Optional<Library> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Library>(HttpStatus.NOT_FOUND);
		}

		Library existing = found.get();

		if (newLibrary.getName() != null) {
			existing.setName(newLibrary.getName());
		}

		if (newLibrary.getLocation() != null) {
			existing.setLocation(newLibrary.getLocation());
		}

		Library updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean remove(int id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}
}

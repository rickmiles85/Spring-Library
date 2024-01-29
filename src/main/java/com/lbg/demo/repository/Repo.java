package com.lbg.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lbg.demo.domain.Library;

public interface Repo extends JpaRepository<Library, Integer> {

}

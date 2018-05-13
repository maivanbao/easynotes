package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Todo;
@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>{

}

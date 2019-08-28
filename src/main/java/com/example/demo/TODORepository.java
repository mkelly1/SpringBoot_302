package com.example.demo;
/* implements CRUD operations with builtin methods. creates 'a pipeline' to the database. Can return single or multiple rows */

import org.springframework.data.repository.CrudRepository;

public interface TODORepository extends CrudRepository<TODO, Long> {
}

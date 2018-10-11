package com.arif.springrest.entity;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}

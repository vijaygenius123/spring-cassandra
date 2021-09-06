package com.example.springcassandra.repository;

import com.example.springcassandra.model.Todo;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface TodoRepository extends CassandraRepository<Todo, Integer> {
}

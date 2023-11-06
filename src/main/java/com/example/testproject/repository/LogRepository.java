package com.example.testproject.repository;

import com.example.testproject.entity.Log;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log, Long> {
}

package com.example.mongoexample.repository;

import com.example.mongoexample.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findByEmail(String email);

    @Query("{gender: {$ne: null } }")
    List<Student> findStudentsWithGender();

    @Query("{gender: null}")
    List<Student> findStudentsWithoutGender();
}

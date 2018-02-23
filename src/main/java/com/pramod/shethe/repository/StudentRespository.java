package com.pramod.shethe.repository;

import com.pramod.shethe.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository extends CrudRepository<Student, Long> {
}

package com.example.stc.stc.Repository;


import com.example.stc.stc.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    List<Student> findAllByDeletedFalse();
    List<Student> findAllByDeletedTrue();
    Student findBySid(Long sid);


}

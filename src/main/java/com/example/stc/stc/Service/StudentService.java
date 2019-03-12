package com.example.stc.stc.Service;


import com.example.stc.stc.Entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudentsActive();
    List<Student> getAllStudentsDeleted();
    ResponseEntity addStudent(Student student);
    ResponseEntity updateStudent(Student student, Long sid);
    ResponseEntity deletStudent(Long sid);
    ResponseEntity undeletStudent(Long sid);
    Student findBySid(Long sid);


}

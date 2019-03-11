package com.example.stc.stc.Service;


import com.example.stc.stc.Entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudentsActive();
    List<Student> getAllStudentsDeleted();
    Student addStudent(Student student);
    Student updateStudent(Student student, Long sid);
    Student deletStudent(Long sid);
    Student undeletStudent(Long sid);
    Student findBySid(Long sid);


}

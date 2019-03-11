package com.example.stc.stc.ServiceImpl;

import com.example.stc.stc.Entity.Student;
import com.example.stc.stc.Repository.StudentRepository;
import com.example.stc.stc.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudentsActive() {
        return studentRepository.findAllByDeletedFalse();
    }

    @Override
    public List<Student> getAllStudentsDeleted() {
        return studentRepository.findAllByDeletedTrue();
    }

    @Override
    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student, Long sid) {
        if (!student.isDeleted()) {
            student.setSid(sid);
            studentRepository.save(student);
            return student;
        }
        return null;
    }

    @Override
    public Student deletStudent(Long sid) {
        Student student = studentRepository.findById(sid).get();
        student.setDeleted(true);
        return studentRepository.save(student);
    }

    @Override
    public Student undeletStudent(Long sid) {
        Student student = studentRepository.findById(sid).get();
        student.setDeleted(false);
        return studentRepository.save(student);
    }

    @Override
    public Student findBySid(Long sid) {
        return studentRepository.findBySid(sid);
    }
}

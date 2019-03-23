package com.example.stc.stc.ServiceImpl;

import com.example.stc.stc.Entity.Student;
import com.example.stc.stc.Repository.StudentRepository;
import com.example.stc.stc.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity addStudent(Student student) {
        studentRepository.save(student);
        return new ResponseEntity("Student Has Added.", HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity updateStudent(Student student, Long sid) {
        Student student1 =studentRepository.findById(sid).get();
        if (!student1.isDeleted()) {
            student.setSid(sid);
            studentRepository.save(student);
            return new ResponseEntity("Student Has Updated.", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity("Student Already UnActive.", HttpStatus.ACCEPTED);
        }

    }

    @Override
    public ResponseEntity deletStudent(Long sid) {
        Student student = studentRepository.findById(sid).get();
        student.setDeleted(true);
        studentRepository.save(student);
        return new ResponseEntity("Student Has Deleted.", HttpStatus.ACCEPTED);

    }

    @Override
    public ResponseEntity undeletStudent(Long sid) {
        Student student = studentRepository.findById(sid).get();
        student.setDeleted(false);
        studentRepository.save(student);
        return new ResponseEntity("Student Has UnDeleted.", HttpStatus.ACCEPTED);
    }

    @Override
    public Student findBySid(Long sid) {
        return studentRepository.findBySid(sid);
    }

}

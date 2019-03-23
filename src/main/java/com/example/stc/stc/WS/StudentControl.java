package com.example.stc.stc.WS;


import com.example.stc.stc.Entity.Student;
import com.example.stc.stc.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentControl {
    @Autowired
    private StudentService studentService;


    @PostMapping(value = "/addstudent")
    public ResponseEntity addStudent(@RequestBody Student student){
        return ResponseEntity.ok( studentService.addStudent(student));
    }

    @GetMapping(value = "/allstudent")
    public List<Student> getAllStudentsActive() {return studentService.getAllStudentsActive();}

    @GetMapping(value = "/allstudentDeleted")
    public List<Student> getAllStudentsDeleted() {return studentService.getAllStudentsDeleted();}

    @PutMapping (value ="/update/{sid}")
    public ResponseEntity updateUser (@RequestBody Student student, @PathVariable Long sid) {

        return ResponseEntity.ok(studentService.updateStudent(student,sid));}

    @DeleteMapping (value = "/delete/{sid}")
    public ResponseEntity deleteById(@PathVariable Long sid){
        return ResponseEntity.ok(studentService.deletStudent(sid));
    }

    @DeleteMapping (value = "/undelete/{sid}")
    public ResponseEntity undeleteById(@PathVariable Long sid){
        return ResponseEntity.ok(studentService.undeletStudent(sid));
    }

    @GetMapping (value = "/student/{sid}")
    public Student findBySid(@PathVariable Long sid) {

        return studentService.findBySid(sid);}

}

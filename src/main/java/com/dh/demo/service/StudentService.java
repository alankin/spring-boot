package com.dh.demo.service;

import com.dh.demo.domain.Student;
import com.dh.demo.repository.StudentRepository;
import com.dh.demo.web.StudentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alan on 10/6/2017.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(StudentController.StudentRequsetDTO studentDTO) {
        Student newStudent = new Student();
        newStudent.setCi(studentDTO.getCi());
        newStudent.setCodeSis(studentDTO.getCodeSis());
        newStudent.setName(studentDTO.getName());

        //LOS IDS YA SE AUTOGENERAN, POR LO TANTO NO DEBEN SER SETEADOS

        studentRepository.save(newStudent);
    }
}

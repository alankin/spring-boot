package com.dh.demo.web;

import com.dh.demo.domain.Student;
import com.dh.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Alan on 10/6/2017.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addStudent(@RequestBody StudentRequsetDTO student) {
        studentService.addNewStudent(student);
    }

    //DTO

    public static class StudentRequsetDTO {

        private String name;
        private long ci;
        private long codeSis;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getCi() {
            return ci;
        }

        public void setCi(long ci) {
            this.ci = ci;
        }

        public long getCodeSis() {
            return codeSis;
        }

        public void setCodeSis(long codeSis) {
            this.codeSis = codeSis;
        }
    }
}

package com.dh.demo.web;

import com.dh.demo.domain.Subject;
import com.dh.demo.service.SubjectService;
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
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Subject> getSubjects() {
        return subjectService.getAllSubjects();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addSubject(@RequestBody SubjectRequestDTO subject) {
        subjectService.addNewSubject(subject);
    }

    //DTO
    public static class SubjectRequestDTO {
        private String code;
        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

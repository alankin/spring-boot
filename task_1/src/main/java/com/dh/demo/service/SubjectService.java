package com.dh.demo.service;

import com.dh.demo.domain.Subject;
import com.dh.demo.repository.SubjectRepository;
import com.dh.demo.web.SubjectController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alan on 10/6/2017.
 */
@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public void addNewSubject(SubjectController.SubjectRequestDTO subjectDTO) {
        Subject newSubject = new Subject();
        newSubject.setCode(subjectDTO.getCode());
        newSubject.setName(subjectDTO.getName());

        subjectRepository.save(newSubject);
    }
}

package com.dh.demo.service;

import com.dh.demo.domain.Teacher;
import com.dh.demo.repository.TeacherRepository;
import com.dh.demo.web.TeacherController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alan on 3/6/2017.
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        //TODO use repository
        /*List<Teacher> res = new ArrayList<>();

        res.add(new Teacher("jv", "Jhonny", 655555, "Ing Sistemas"));
        res.add(new Teacher("gd", "Gabriel", 655555, "NONE"));
        res.add(new Teacher("su", "Susana", 655555, "Ing Sistemas"));
        res.add(new Teacher("an", "Andres", 655555, "Ing Sistemas"));*/

        List<Teacher> res = teacherRepository.findAll();
        return res;
    }

    public Teacher getTeacherById(String id) {
        // Find one Teacher
        return teacherRepository.findOne(id);
    }

    public void addTeacher(TeacherController.TeacherRequestDTO teacherDTO) {
        Teacher newTeacher = new Teacher();
        newTeacher.setCi(teacherDTO.getCi());
        newTeacher.setName(teacherDTO.getName());
        newTeacher.setProfession(teacherDTO.getProfession());

        teacherRepository.save(newTeacher);
    }

    public Teacher deleteTeacherById(String id) {
        Teacher response = teacherRepository.findOne(id);

        // delete teacher
        teacherRepository.delete(response);
        return response;
    }

    public Teacher updateTeacherById(String id, TeacherController.TeacherRequestDTO teacherDTO) {
        Teacher newTeacher = new Teacher();
        newTeacher.setCi(teacherDTO.getCi());
        newTeacher.setProfession(teacherDTO.getProfession());
        newTeacher.setName(teacherDTO.getName());

        newTeacher.setId(id);
        teacherRepository.save(newTeacher);
        return newTeacher;
    }
}

package com.dh.demo.service;

import com.dh.demo.domain.*;
import com.dh.demo.repository.*;
import com.dh.demo.web.SubscriptionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Alan on 10/6/2017.
 */
@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public void addNewSubscription(SubscriptionController.SubscriptionRequestDTO subscriptionDTO) {
        Subscription newSubscription = new Subscription();
        Student newStudent = studentRepository.findOne(subscriptionDTO.getStudentId());
        Teacher newTeacher = teacherRepository.findOne(subscriptionDTO.getTeacherId());
        Room newRoom = roomRepository.findOne(subscriptionDTO.getRoomId());
        Subject newSubject = subjectRepository.findOne(subscriptionDTO.getSubjectId());

        newSubscription.setSubDate(subscriptionDTO.getSubDate());
        newSubscription.setStudent(newStudent);
        newSubscription.setTeacher(newTeacher);
        newSubscription.setRoom(newRoom);
        newSubscription.setSubject(newSubject);

        subscriptionRepository.save(newSubscription);
    }
}

package com.dh.demo.web;

import com.dh.demo.domain.Subscription;
import com.dh.demo.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by Alan on 10/6/2017.
 */
@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addSubscription(@RequestBody SubscriptionRequestDTO subscription) {
        subscriptionService.addNewSubscription(subscription);
    }

    // DTO

    public static class SubscriptionRequestDTO {

        // Debe ser lo mas plano posible
        private String teacherId;
        private String studentId;
        private String roomId;
        private String subjectId;
        private Date subDate;

        public String getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(String teacherId) {
            this.teacherId = teacherId;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getSubjectId() {
            return subjectId;
        }

        public void setSubjectId(String subjectId) {
            this.subjectId = subjectId;
        }

        public Date getSubDate() {
            return subDate;
        }

        public void setSubDate(Date subDate) {
            this.subDate = subDate;
        }
    }
}

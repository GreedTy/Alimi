package com.example.alimi.Repository;

import com.example.alimi.Domain.ScheduleInfo;
import com.example.alimi.Domain.StudyGroup;
import com.example.alimi.Domain.StudyReservation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class StudyReservationRepositoryTest {

    @Autowired
    StudyReservationRepository studyReservationRepository;

    @Autowired
    ScheduleInfoRepository scheduleInfoRepository;

    @Test
    @Rollback(value = false)
    public void StudyScheduleList() {
        StudyReservation studySchedule = new StudyReservation();
        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setName("영어 스터디");
        studySchedule.setStudyGroup(studyGroup);
        ScheduleInfo scheduleInfo = new ScheduleInfo();
        scheduleInfo.setName("금일 영어 수업!!");
        studySchedule.setScheduleInfo(scheduleInfo);
        studyReservationRepository.save(studySchedule);

        StudyReservation studySchedule1 = new StudyReservation();
        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setName("수학 스터디");
        studySchedule1.setStudyGroup(studyGroup1);
        ScheduleInfo scheduleInfo1 = new ScheduleInfo();
        scheduleInfo1.setName("금일 수학 수업!!");
        studySchedule1.setScheduleInfo(scheduleInfo1);
        studyReservationRepository.save(studySchedule1);

        studyReservationRepository.findAll().stream().forEach(c -> {
            System.out.println(c.getScheduleInfo());
            System.out.println(c.getStudyGroup());
            System.out.println(c.getScheduleInfo().getName());
            System.out.println(c.getStudyGroup().getName());
        });


    }
}
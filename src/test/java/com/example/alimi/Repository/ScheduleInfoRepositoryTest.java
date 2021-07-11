package com.example.alimi.Repository;

import com.example.alimi.Domain.Day;
import com.example.alimi.Domain.ScheduleInfo;
import com.example.alimi.Domain.StudyGroup;
import com.example.alimi.Domain.StudyReservation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class ScheduleInfoRepositoryTest {

    @Autowired
    ScheduleInfoRepository scheduleInfoRepository;

    @Test
    public void scheduleInfoList() {
        ScheduleInfo scheduleInfo = new ScheduleInfo();
        //StudySchedule studySchedule = new StudySchedule();

        /*scheduleInfo.setName("영어 문법 공부");
        scheduleInfo.setDay(Day.MON);
        scheduleInfo.setStart_hour("11:00");
        scheduleInfo.setEnd_hour("13:00");
        StudySchedule studySchedule = new StudySchedule();
        studySchedule.setScheduleInfo(scheduleInfo);
        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setName("영어모임");
        studySchedule.setStudyGroup(studyGroup);

        ScheduleInfo scheduleInfo1 = new ScheduleInfo();
        scheduleInfo1.setName("수학 문법 공부");
        scheduleInfo1.setDay(Day.TUE);
        scheduleInfo1.setStart_hour("18:00");
        scheduleInfo1.setEnd_hour("20:00");
        StudySchedule studySchedule1 = new StudySchedule();
        studySchedule1.setScheduleInfo(scheduleInfo1);
        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setName("영어모임");
        studySchedule1.setStudyGroup(studyGroup1);
        Set<StudySchedule> studyScheduleSet = new HashSet<>();
        studyScheduleSet.add(studySchedule);
        studyScheduleSet.add(studySchedule1);
        scheduleInfo.setStudySchedules(studyScheduleSet);

        scheduleInfoRepository.save(scheduleInfo);
        scheduleInfoRepository.save(scheduleInfo1);
        scheduleInfoRepository.findAll().stream().forEach( c-> {
            System.out.println(c.getName());
            System.out.println(c.getDay());
            System.out.println(c.getStart_hour());
            System.out.println(c.getEnd_hour());
        });*/
    }
}
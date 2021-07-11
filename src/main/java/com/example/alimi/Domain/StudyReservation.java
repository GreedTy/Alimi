package com.example.alimi.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class StudyReservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "schedule_info")
    private ScheduleInfo scheduleInfo;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationRank;
}

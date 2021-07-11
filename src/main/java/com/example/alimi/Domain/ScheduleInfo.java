package com.example.alimi.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleInfo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_info")
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Day day;
    private String start_hour;
    private String end_hour;
    @OneToMany(mappedBy = "scheduleInfo")
    private Set<StudyReservation> studySchedules = new HashSet<>();
}

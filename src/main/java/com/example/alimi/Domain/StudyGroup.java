package com.example.alimi.Domain;


import com.example.alimi.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudyGroup extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_group_id")
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "user")
    private List<StudyGroupMember> userList = new ArrayList<>();

    @OneToMany(mappedBy = "studyGroup")
    private Set<StudyReservation> studySchedule = new HashSet<>();

    @Column(name = "study_name")
    private String name;
    private String master;

}

package com.example.alimi.Domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id")
@NoArgsConstructor @AllArgsConstructor
@Builder
public class StudyJoin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "study_join_id")
    private Long id;

    @Column(unique = true, nullable = false)
    private Long accountId;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;
}

package com.example.alimi.Domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "category_id")
    private Long id;
    @Column(name = "category_name")
    private String name;
    @OneToOne(mappedBy = "category", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private StudyGroup studyGroup;

    public void setStudyGroup(StudyGroup studyGroup) {
        this.studyGroup.setCategory(this);
        this.setStudyGroup(studyGroup);
    }
}

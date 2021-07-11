package com.example.alimi.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class StudyGroupMember {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    @Enumerated(EnumType.STRING)
    private AccountRole accountGroupRole;

    public void setUser(Account user) {
        if (this.user != null) {
            this.user.getStudyGroupMember().remove(this);
        }
        this.user = user;
        user.getStudyGroupMember().add(this);
    }
    public void setStudyGroup(StudyGroup studyGroup) {
        if (this.studyGroup != null) {
            this.studyGroup.getUserList().remove(this);
        }
        this.studyGroup = studyGroup;
        studyGroup.getUserList().add(this);
    }
}

package com.example.alimi.Repository;

import com.example.alimi.Domain.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long>, StudyGroupRepositoryCustom {
    public void deleteStudyGroupById(long id);
}

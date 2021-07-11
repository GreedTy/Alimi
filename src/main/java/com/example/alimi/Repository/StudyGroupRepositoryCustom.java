package com.example.alimi.Repository;

import com.example.alimi.Domain.StudyGroup;
import com.example.alimi.dto.StudyGroupDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudyGroupRepositoryCustom {
    Page<StudyGroup> selectStudyGroupList(Pageable pageable);

    Page<StudyGroup> selectStudyGroupList(String keyword, Pageable pageable);
}

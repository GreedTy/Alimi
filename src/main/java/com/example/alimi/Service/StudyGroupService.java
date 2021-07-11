package com.example.alimi.Service;

import com.example.alimi.Domain.QStudyGroup;
import com.example.alimi.Domain.StudyGroup;
import com.example.alimi.Repository.StudyGroupRepository;
import com.example.alimi.base.PageRequest;
import com.example.alimi.dto.StudyGroupDto;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyGroupService {

    @Autowired
    JPAQueryFactory queryFactory;

    @Autowired
    StudyGroupRepository studyGroupRepository;

    private final Integer BLOCK_PAGE_NUM_COUNT = 10;
    private final Integer PAGE_POST_COUNT = 50;

    public void createStudyGroup(StudyGroup studyGroup) {
        studyGroupRepository.save(studyGroup);
    }

    // 메소드 오버로딩
    public Page<StudyGroup> selectStudyGroupList(Pageable pageable) {
        return studyGroupRepository.selectStudyGroupList(pageable);
    }

    public Page<StudyGroup> selectStudyGroupList(String keyword, Pageable pageable) {
        return studyGroupRepository.selectStudyGroupList(keyword, pageable);
    }

    @Transactional
    public void deleteStudyGroup(StudyGroup studyGroup) throws Exception {
        queryFactory.delete(QStudyGroup.studyGroup).where(QStudyGroup.studyGroup.id.eq(studyGroup.getId())).execute();
    }
}

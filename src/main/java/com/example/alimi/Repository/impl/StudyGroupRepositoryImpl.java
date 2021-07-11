package com.example.alimi.Repository.impl;

import com.example.alimi.Domain.QCategory;
import com.example.alimi.Domain.QStudyGroup;
import com.example.alimi.Domain.StudyGroup;
import com.example.alimi.Repository.StudyGroupRepositoryCustom;
import com.example.alimi.dto.StudyGroupDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class StudyGroupRepositoryImpl implements StudyGroupRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    // N+1문제 fetchJoin으로 해결
    @Override
    public Page<StudyGroup> selectStudyGroupList(Pageable pageable) {
        QStudyGroup studyGroup = QStudyGroup.studyGroup;
        QCategory category = QCategory.category;
        QueryResults<StudyGroup> results = jpaQueryFactory.selectFrom(studyGroup)
                                                            .leftJoin(studyGroup.category(), category)
                                                            .offset(pageable.getOffset())
                                                            .limit(pageable.getPageSize())
                                                            .orderBy(studyGroup.id.desc())
                                                            .fetchJoin()
                                                            .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    @Override
    public Page<StudyGroup> selectStudyGroupList(String keyword, Pageable pageable) {
        QStudyGroup studyGroup = QStudyGroup.studyGroup;
        QCategory category = QCategory.category;
        QueryResults<StudyGroup> results = jpaQueryFactory.selectFrom(studyGroup)
                                                            .leftJoin(studyGroup.category(), category)
                                                            .where(studyGroup.name.contains(keyword))
                                                            .offset(pageable.getOffset())
                                                            .limit(pageable.getPageSize())
                                                            .orderBy(studyGroup.id.desc())
                                                            .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
}

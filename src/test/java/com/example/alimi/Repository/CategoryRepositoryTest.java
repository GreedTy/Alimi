package com.example.alimi.Repository;

import com.example.alimi.Domain.Category;
import com.example.alimi.Domain.StudyGroup;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    StudyGroupRepository studyGroupRepository;

    @Test
    public void categoryInsert() {
        Category category = new Category();
        category.setName("디지털완제품");

        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setName("영어 스터디");
        category.setStudyGroup(studyGroup);
        Category category1 = categoryRepository.save(category);
        Optional<Category> categoryOptional = categoryRepository.findById(1L);
        categoryOptional.ifPresent( c -> {
            System.out.println(c.getStudyGroup().getName());
        });
    }

    @Test
    public void categoryList() {
        Category category1 = new Category();
        category1.setName("디지털완제품");
        StudyGroup studyGroup1 = new StudyGroup();
        studyGroup1.setName("스피치 스터디");
        category1.setStudyGroup(studyGroup1);
        studyGroup1.setCategory(category1);

        Category category2 = new Category();
        category2.setName("가전제품");
        StudyGroup studyGroup2 = new StudyGroup();
        studyGroup2.setName("영어 스터디");
        category2.setStudyGroup(studyGroup2);
        studyGroup2.setCategory(category2);

        Category category3 = new Category();
        category3.setName("생활가전");
        StudyGroup studyGroup3 = new StudyGroup();
        studyGroup3.setName("수학 스터디");
        category3.setStudyGroup(studyGroup3);
        studyGroup3.setCategory(category3);
        studyGroupRepository.save(studyGroup1);
        studyGroupRepository.save(studyGroup2);
        studyGroupRepository.save(studyGroup3);
        studyGroupRepository.findAll().stream().forEach( s -> {
            s.getUserList().stream().forEach( u -> {
                System.out.println(u.getUser().getUsername());
            });
        });

    }
}
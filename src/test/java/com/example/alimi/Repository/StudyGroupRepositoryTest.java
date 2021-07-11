package com.example.alimi.Repository;

import com.example.alimi.Domain.*;
import com.example.alimi.Service.StudyGroupService;
import com.example.alimi.TestConfig;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Import(TestConfig.class)
class StudyGroupRepositoryTest {

    @Autowired
    AccountRepository userRepository;

    @Autowired
    StudyGroupRepository studyGroupRepository;

    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Autowired
    StudyGroupService studyGroupService;

    @Test
    public void studyGroupList() {
        StudyGroup studyGroup = new StudyGroup();
        studyGroup.setName("영어");
        Account user1 = Account.builder()
                .username("테스트")
                .password("test!@#")
                .email("eeee@gmail.com")
                .phoneNumber("010-1110-1111")
                .build();

        StudyGroupMember studyGroupMember = new StudyGroupMember();
        studyGroupMember.setStudyGroup(studyGroup);
        studyGroupMember.setUser(user1);

        Account user2 = Account.builder()
                .username("테스트")
                .password("test!@#")
                .email("eeee@gmail.com")
                .phoneNumber("010-1110-1111")
                .build();

        StudyGroupMember studyGroupMember1 = new StudyGroupMember();
        studyGroupMember1.setStudyGroup(studyGroup);
        studyGroupMember1.setUser(user2);

        studyGroupRepository.save(studyGroup);
        Optional<StudyGroup> studyGroup1 = studyGroupRepository.findById(1L);
        studyGroup1.ifPresent(s -> {
            System.out.println(s.getName());
            s.getUserList().stream().forEach(w ->
            {
                System.out.println(w.getUser().getUsername());
                System.out.println(w.getUser().getPhoneNumber());
                System.out.println(w.getUser().getPassword());
            });
        });
    }

    @Test
    public void studyGroupFirstPage() {
        Pageable pageRequest = PageRequest.of(0, 5, Sort.by("create_date").descending());
        studyGroupService.selectStudyGroupList(pageRequest).getContent().forEach( s -> {
            System.out.println(s.getName());
            System.out.println(s.getMaster());
            System.out.println(s.getCategory().getName());
        });
    }

    /*@Test
    public void studyGroupSearchSelect() throws Exception {
        mockMvc.perform(get("/group/list/search")
                .param("keyword", "영어스터디"))
                .andDo(print())
                .andExpect(jsonPath("studyGroupList").exists());
    }*/
}
package com.example.alimi.Repository;

import com.example.alimi.Domain.Account;
import com.example.alimi.Domain.AccountRole;
import com.example.alimi.Domain.StudyGroup;
import com.example.alimi.Service.UserService;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class UserRepositoryTest {

    @Rule
    public ExpectedException expectedException;

    @Autowired
    UserService userService;

    @Autowired
    AccountRepository userRepository;

    @Autowired
    StudyGroupRepository studyGroupRepository;

    @Test
    public void userList() {
        StudyGroup studyGroup = new StudyGroup();
        List<StudyGroup> studyGroupList = new ArrayList<>();
        studyGroup.setName("영어 스터디");
        studyGroup.setMaster("김보성");
        studyGroupList.add(studyGroup);
        Account user1 = Account.builder()
                .username("테스트")
                .password("test!@#")
                .email("eeee@gmail.com")
                .phoneNumber("010-1110-1111")
                .build();
        Account user2 = Account.builder()
                .username("테스트")
                .password("test!@#")
                .email("eeee@gmail.com")
                .phoneNumber("010-1110-1111")
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
        studyGroupRepository.save(studyGroup);

        userRepository.findAll().stream().forEach(u ->{

        });
    }
    @Test
    public void userAuth() {
        Account user = Account.builder()
                .username("테스트")
                .password("test!@#")
                .email("eeee@gmail.com")
                .phoneNumber("010-1110-1111")
                .build();
    }
}
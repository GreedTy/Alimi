package com.example.alimi.Domain;

import com.example.alimi.base.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "account_name", length = 10, unique = true)
    private String username;

    private String password;

    private String email;

    @Column(name = "phoneNumber", length = 14)
    private String phoneNumber;

    private String role;

    @OneToMany(mappedBy = "studyGroup")
    private List<StudyGroupMember> studyGroupMember = new ArrayList<>();

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
    }

    @Builder
    public Account(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = "NORMAL";
    }
}

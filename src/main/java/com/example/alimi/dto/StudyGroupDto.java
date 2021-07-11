package com.example.alimi.dto;

import com.example.alimi.Domain.Category;
import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter @EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudyGroupDto {
    private Long id;
    private String name;
    private String master;
    private LocalDateTime createDate;
    private Category category;

    @Builder
    public StudyGroupDto(Long id, String name, String master, Category category, LocalDateTime localDateTime) {
        this.id = id;
        this.name = name;
        this.master = master;
        this.createDate = localDateTime;
        this.category = category;
    }
}

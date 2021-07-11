package com.example.alimi.Controller;

import com.example.alimi.Domain.Category;
import com.example.alimi.Domain.StudyGroup;
import com.example.alimi.Service.StudyGroupService;
import com.example.alimi.dto.StudyGroupDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/group")
public class StudyGroupController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    StudyGroupService studyGroupService;

    @GetMapping
    public String groupList(
            @PageableDefault(size = 5, direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(required = false, defaultValue = "") String keyword,
            Model model) {
        List<StudyGroupDto> newStudyGroupDtoList = new ArrayList<>();
        Page<StudyGroup> studyGroupPage = null;
        if (!keyword.equals("")) {
            studyGroupPage = studyGroupService.selectStudyGroupList(keyword, pageable);
        } else {
            studyGroupPage = studyGroupService.selectStudyGroupList(pageable);
        }
        studyGroupPage.getContent().forEach( s -> {
            newStudyGroupDtoList.add(modelMapper.map(s, StudyGroupDto.class));
        });
        // System.out.println(studyGroupPage.getTotalElements());
        // System.out.println(studyGroupPage.getTotalPages());
        // System.out.println(studyGroupPage.getNumber());
        // System.out.println(studyGroupPage.getNumberOfElements());
        model.addAttribute("startPage", Math.max(1, studyGroupPage.getNumber()-4));
        model.addAttribute("endPage", Math.min((int) studyGroupPage.getTotalElements(), studyGroupPage.getNumber()+4));
        model.addAttribute("studyGroupList", newStudyGroupDtoList);
        return "grouplist";
    }

    @PostMapping
    public @ResponseBody String groupCreate(@RequestBody StudyGroup studyGroup) {
        // 원래는 카테고리를 조회해와서 넣어줘야함
        Category category = Category.builder()
                                .name("외국어")
                                .studyGroup(studyGroup)
                                .build();
        studyGroup.setCategory(category);
        studyGroupService.createStudyGroup(studyGroup);
        return "success";
    }
    @PostMapping("/{id}")
    public String groupDelete(@PathVariable long id, @ModelAttribute StudyGroup studyGroup) throws Exception {
        System.out.println(studyGroup.getId());
        System.out.println(id);
        studyGroupService.deleteStudyGroup(studyGroup);
        return "grouplist";
    }
}

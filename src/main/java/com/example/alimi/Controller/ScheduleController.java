package com.example.alimi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @GetMapping("/info")
    public String view() {
        return "scheduleinfo";
    }
}

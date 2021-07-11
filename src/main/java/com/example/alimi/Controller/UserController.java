package com.example.alimi.Controller;

import com.example.alimi.Domain.Account;
import com.example.alimi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/account/{role}/{username}/{password}")
    public Account userRegister(@ModelAttribute Account account) {
        return userService.registUser(account);
    }

    @GetMapping("/expose")
    public ModelAndView exposeUser() {
        List<String> userIdList = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView("userlist");
        userService.selectAllUser().stream().forEach(u -> {
            userIdList.add(u.getPhoneNumber());
        });
        modelAndView.addObject("datas", userIdList);
        return modelAndView;
    }

    @PostMapping(value = "/account")
    public void accountRegister(HttpServletResponse response, Account account) throws IOException {
        // 해당 Role은 전체 서비스에 대한 Role이다. StudyGroup의 Role은 아니다.
        account.setRole("NORMAL");
        Account registerAccount = userService.findUserName(account.getUsername());
        if (registerAccount == null) {
            userService.registUser(account);
            response.sendRedirect("/login");
        } else {
            response.sendRedirect("/join");
        }
    }
}
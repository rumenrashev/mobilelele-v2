package com.spring.mobilelele.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.spring.mobilelele.constant.GlobalConstants.LOGIN_PATH;

@Controller
public class LoginController extends BaseController {

    @GetMapping(LOGIN_PATH)
    public String login() {
        return LOGIN_PATH;
    }
}

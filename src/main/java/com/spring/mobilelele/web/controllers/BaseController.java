package com.spring.mobilelele.web.controllers;

public class BaseController {

    public String redirect(String url){
        return "redirect:" + url;
    }

}

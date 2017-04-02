package com.mikeio.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SISTEMAS03 on 02/03/2016.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {


    @GetMapping(value = {"/"})
    public String registra() {
        return "index";
    }

    @GetMapping(value = {"/securePage"})
    public String securePage() {
        return "securePage";
    }




}

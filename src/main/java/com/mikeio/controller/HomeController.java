package com.mikeio.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

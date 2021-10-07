package com.cofeeBin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Server Connected!!";
    }

}

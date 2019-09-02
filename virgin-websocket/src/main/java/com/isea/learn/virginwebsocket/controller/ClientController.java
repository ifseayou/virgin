package com.isea.learn.virginwebsocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author isea_you
 * @date 2019/9/2
 * @time 13:27
 * @target:
 */

@Controller
public class ClientController {

    @GetMapping("client")
    public ModelAndView client(){
        return new ModelAndView("client");
    }
}
